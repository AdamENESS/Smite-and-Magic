#include "CGUIResource.h"
#include <iostream>
#include "CHexViewer.h"
#include "ImGuiWindow.h"
#include "ImGuiManager.h"
#include "CShapeViewer.h"
#include <functional>
#include "CMazViewer.h"

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
	//fileList = std::filesystem::directory_iterator(sWorkingFolder);

	WindowName("Resources");
}

void SmitED::CGUIResource::update()
{
	if (bLoading)
	{
	/*	auto entry = *fileList;
		std::cout << entry.path() << std::endl;
		if(entry.path().extension().compare(".PAK") == 0)
		{
			std::string sPakPath = entry.path().string();
			SmitED::CPak* pPak = new SmitED::CPak(sPakPath);
			vecPakFiles.emplace(entry.path().filename().string() , pPak);
		}
		fileList++;
		if (fileList == std::filesystem::end(fileList))
		{
			bLoading = false;
		}*/
	}
	else
	{
		begin();
		/*for (auto pak:vecPakFiles)
		{
			std::string sDisplayName;
			sDisplayName = pak.first+ " - " + std::to_string(pak.second->GetFileCount());
			
			bool node_open = ImGui::TreeNodeEx(sDisplayName.c_str());
			if (node_open)
			{

				//for (auto item: pak.second->GetAllFileEntries())
				//{
				//	if (ImGui::Selectable(item.first.c_str()))
				//	{
				//		SmitED::CHexViewer* pViewer = nullptr;
				//		auto ext = item.first.substr(item.first.size() - 4, 3);
				//		;
				//		for (auto ft : fileTypes)
				//		{
				//			if (ext.compare(ft.ext) == 0)
				//			{
				//				pViewer = ft.creator->Create();
				//			}
				//		}

				//		if (pViewer == nullptr)
				//		{
				//			pViewer = new SmitED::CHexViewer();
				//		}
				//
				//		if (pViewer)
				//		{
				//			auto size = item.second->Size();
				//			pViewer->SetPakFile(pak.second);
				//			pViewer->SetData(item.first, item.second->Data(), size);
				//			pOwner->AddWindowNextFrame(pViewer);

				//		}
				//		//ImGui::TreePop();
				//	}
				//}

				ImGui::TreePop();
			}
		}*/
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

SmitED::SFileType::SFileType(const std::string& _sDesc, const std::string& _sExt, const std::string& _sClassName)
{
	sDesc = _sDesc;
	sClassName = _sClassName;
	vecExtensions.emplace_back(_sExt);
}
