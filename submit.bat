@echo off

@rem color 0A
cls

set branchName=%1
set commitText=%2

if "%branchName%" NEQ "" (
	if "%commitText%" NEQ "" (
		git checkout master
		
		git merge "%branchName%"
		
		git add .
		
		git commit -m "%commitText%"
		
		git push origin master
		
		echo okokok
	) else echo 格式：submit.bat 分支名称 注释
) else echo 格式：submit.bat 分支名称 注释