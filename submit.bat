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
		echo ===== 回到 master 分支 =======
		
		git checkout master
		
		echo ===== 合并分支到 master ======
		
		git merge "%branchName%"
		
		echo ====== 添加文件并提交 ========
		
		git add .
		git commit -m "%commitText%"
		
		echo ========== 推送 ==============
		
		git push origin master
		
		echo ======== 删除分支 ============
		
		git branch -d "%branchName%"
		
		echo =========== 完成 =============
	) else echo 格式：submit.bat 分支名称 注释
) else echo 格式：submit.bat 分支名称 注释