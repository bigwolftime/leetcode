@echo off

rem		��ɫ			��ɫ
rem    0 = ��ɫ        8 = ��ɫ
rem    1 = ��ɫ        9 = ����ɫ
rem    2 = ��ɫ        A = ����ɫ
rem    3 = ����ɫ      B = ��ǳ��ɫ
rem    4 = ��ɫ        C = ����ɫ
rem    5 = ��ɫ        D = ����ɫ
rem    6 = ��ɫ        E = ����ɫ
rem    7 = ��ɫ        F = ����ɫ

cls

set branchName=%1
set commitText=%2

if "%branchName%" NEQ "" (
	if "%commitText%" NEQ "" (
		color 0A
		echo �ص� master ��֧
		color 0F
		
		git checkout master
		
		color 0A
		echo �ϲ���֧�� master
		color 0F
		
		git merge "%branchName%"
		
		color 0A
		echo ����ļ����ύ
		color 0F
		
		git add .
		git commit -m "%commitText%"
		
		color 0A
		echo ����
		color 0F
		
		git push origin master
		
		color 0A
		echo ɾ����֧
		color 0F
		
		git branch -d "%branchName%"
		
		color 0A
		echo ���
		color 0F
	) else echo ��ʽ��submit.bat ��֧���� ע��
) else echo ��ʽ��submit.bat ��֧���� ע��