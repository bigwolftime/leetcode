@echo off

@rem color 0A
cls

set branchName=%1
set commitText=%2

if "%branchName%" NEQ "" (
	if "%commitText%" NEQ "" (
		echo �ص� master ��֧
		git checkout master
		
		echo �ϲ���֧�� master
		git merge "%branchName%"
		
		echo ����ļ����ύ
		git add .
		git commit -m "%commitText%"
		
		echo ����
		git push origin master
		
		echo okokok
	) else echo ��ʽ��submit.bat ��֧���� ע��
) else echo ��ʽ��submit.bat ��֧���� ע��