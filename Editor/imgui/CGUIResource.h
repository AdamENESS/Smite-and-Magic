#pragma once
#include "ImGuiWindow.h"
#include <vector>
#include <map>
#include <filesystem>

namespace SmitED
{
	struct SFileType
	{
		SFileType(const std::string& sDesc, const std::string& sExt, const std::string& sClassName);
		std::string sDesc;
		std::vector<std::string> vecExtensions;
		std::string sClassName;

	};

	class CGUIResource :public SmitED::ImGuiWindow
	{
	public:

		CGUIResource(const std::string& _workingFolder);
		void update() override;

	protected:

	private:
		bool bLoading;
		std::string sWorkingFolder;
		

		static std::map<std::string, SFileType*> s_mapFileTypeMatcher;
	};
}