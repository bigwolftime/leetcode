@echo off

@rem color 0A
cls

set branchName=%1
set commitText=%2

if "%branchName%" NEQ "" (
	if "%commitText%" NEQ "" (
		echo 回到 master 分支
		git checkout master
		
		echo 合并分支到 master
		git merge "%branchName%"
		
		echo 添加文件并提交
		git add .
		git commit -m "%commitText%"
		
		echo 推送
		git push origin master
		
		echo okokok
	) else echo 格式：submit.bat 分支名称 注释
) else echo 格式：submit.bat 分支名称 注释