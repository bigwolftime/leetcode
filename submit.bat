@echo off

rem		底色			字色
rem    0 = 黑色        8 = 灰色
rem    1 = 蓝色        9 = 淡蓝色
rem    2 = 绿色        A = 淡绿色
rem    3 = 湖蓝色      B = 淡浅绿色
rem    4 = 红色        C = 淡红色
rem    5 = 紫色        D = 淡紫色
rem    6 = 黄色        E = 淡黄色
rem    7 = 白色        F = 亮白色

cls

set branchName=%1
set commitText=%2

if "%branchName%" NEQ "" (
	if "%commitText%" NEQ "" (
		color 0A
		echo 回到 master 分支
		color 0F
		
		git checkout master
		
		color 0A
		echo 合并分支到 master
		color 0F
		
		git merge "%branchName%"
		
		color 0A
		echo 添加文件并提交
		color 0F
		
		git add .
		git commit -m "%commitText%"
		
		color 0A
		echo 推送
		color 0F
		
		git push origin master
		
		color 0A
		echo 删除分支
		color 0F
		
		git branch -d "%branchName%"
		
		color 0A
		echo 完成
		color 0F
	) else echo 格式：submit.bat 分支名称 注释
) else echo 格式：submit.bat 分支名称 注释