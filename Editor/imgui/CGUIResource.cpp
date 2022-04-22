#include "CGUIResource.h"
#include <iostream>
#include "CHexViewer.h"
#include "ImGuiWindow.h"
#include "ImGuiManager.h"
#include "CShapeViewer.h"
#include <functional>
#include "CMazViewer.h"
#include <fstream>
#include <iterator>
#include <algorithm>
#include <iosfwd>

//std::map<std::string, SmitED::SFileType*> SmitED::CGUIResource::s_mapFileTypeMatcher;
//#define ADDRESOURCE(x, y, z) s_mapFileTypeMatcher.insert(std::make_pair(x, new SmitED::SFileType(y, x,z))); 

//typedef int (SmitED::CAnimationScriptViewer::* CommandProc)(const uint16_t*);



template<class Base>
class CreatorBaseVector
{
public:
	CreatorBaseVector(const std::string& sObjectTypeName)
	{
		m_ObjectTypeName = sObjectTypeName;
	}


	virtual Base* Create(void) =0;

public:
	std::string m_ObjectTypeName;
};

template<class Product, class Base>
class CreatorVector : public CreatorBaseVector<Base>
{
public:
	CreatorVector(const std::string& sObjectTypeName)
		: CreatorBaseVector<Base>(sObjectTypeName)
	{
	}

	virtual Base* Create(void);
};


template<class Product, class Base>
Base* CreatorVector<Product, Base>::Create(void)
{
	return new Product;
}


struct typeLookup
{
	const char* ext;
	const char* disc;
	
	CreatorBaseVector<SmitED::CHexViewer>* creator;
};

#define ADDRESOURCE(x,y,z) {x,y, new CreatorVector<SmitED::z, SmitED::CHexViewer>(y)}  


static const typeLookup fileTypes[] = {
	ADDRESOURCE("32","Game Graphics", CHexViewer),
	ADDRESOURCE("ANM","Game Anim Sprite", CHexViewer),

//ADDRESOURCE("CPS", "Compressed Picture Screen", CCPSViewer),
//ADDRESOURCE("WSA", "Westwood Scripted Animated", CWSAViewer),
//ADDRESOURCE("TIM", "Animation Script", CAnimationScriptViewer),
//ADDRESOURCE("SHP", "Shapes", CShapeViewer),
//ADDRESOURCE("UNK", "Unknown Resource", CHexViewer),
//ADDRESOURCE("MAZ", "Level Maze", CMazViewer),
//ADDRESOURCE("INI", "Level Ini", CMazViewer),
//ADDRESOURCE("XXX", "Level Extra", CMazViewer),
//ADDRESOURCE("INF", "Level Script", CMazViewer),
//ADDRESOURCE("WLL", "Level Walls", CMazViewer),
//ADDRESOURCE("CMZ", "Level CMZ", CMazViewer),

};
SmitED::CGUIResource::CGUIResource(const std::string& _workingFolder)
	: SmitED::ImGuiWindow()
{
		
	sWorkingFolder = _workingFolder;
	bLoading = true;
	fileList = std::filesystem::directory_iterator(sWorkingFolder);

	WindowName("Resources");
}

void SmitED::CGUIResource::update()
{
	if (bLoading)
	{
		auto entry = *fileList;
		std::cout << entry.path() << std::endl;
		auto ext = entry.path().extension();
		if(validExtension(ext))
		{
			//std::string sPakPath = entry.path().string();
			std::string sFileName = entry.path().filename().string();
			m_vecValidFiles.push_back(sFileName);
			//SmitED::CPak* pPak = new SmitED::CPak(sPakPath);
			//vecPakFiles.emplace(entry.path().filename().string() , pPak);
		}
		fileList++;
		if (fileList == std::filesystem::end(fileList))
		{
			bLoading = false;
		}
	}
	else
	{
		begin();
		for (const auto& file : m_vecValidFiles)
		{

			//for (auto item: pak.second->GetAllFileEntries())
			//{
			if (ImGui::Selectable(file.c_str()))
			{
				SmitED::CHexViewer* pViewer = nullptr;
				auto ext = file.substr(file.size() - 4, 3);
				;
				for (auto ft : fileTypes)
				{
					if (ext.compare(ft.ext) == 0)
					{
						pViewer = ft.creator->Create();
					}
				}

				if (pViewer == nullptr)
				{
					pViewer = new SmitED::CHexViewer();
				}

				if (pViewer)
				{
					//auto size = item.second->Size();
					//pViewer->SetPakFile(pak.second);
					std::ifstream is;
					is.open(sWorkingFolder+"\\"+file, std::ios::binary);
					// get length of file:
					is.seekg(0, std::ios::end);
					int length = is.tellg();
					is.seekg(0, std::ios::beg);
					// allocate memory:
					uint8_t* buffer = new uint8_t[length];
					// read data as a block:
					is.read((char*)buffer, length);
					is.close();

					pViewer->SetData(file, buffer,length);
					pOwner->AddWindowNextFrame(pViewer);

				}
				//ImGui::TreePop();
			}
			//}

		}
		end();
	}
		// 	}
		//if (entry.path().extension().compare(".PAK") == 0)
		//{
		//	std::cout << entry.path() << std::endl;
		//	std::string sPakPath = entry.path().string();

		//	SmitED::CPak* pPak = new SmitED::CPak(sPakPath);
		//	//delete pPak;
		//}
	
}

bool SmitED::CGUIResource::validExtension(const std::filesystem::path& param1)
{
	if (param1.compare(".32") == 0 ||
		param1.compare(".anm") == 0 ||
		param1.compare(".dat") == 0
		)
	{
		return true;
	}
	return false;
}

SmitED::SFileType::SFileType(const std::string& _sDesc, const std::string& _sExt, const std::string& _sClassName)
{
	sDesc = _sDesc;
	sClassName = _sClassName;
	vecExtensions.emplace_back(_sExt);
}
