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
		echo ===== �ص� master ��֧ =======
		
		git checkout master
		
		echo ===== �ϲ���֧�� master ======
		
		git merge "%branchName%"
		
		echo ====== ����ļ����ύ ========
		
		git add .
		git commit -m "%commitText%"
		
		echo ========== ���� ==============
		
		git push origin master
		
		echo ======== ɾ����֧ ============
		
		git branch -d "%branchName%"
		
		echo =========== ��� =============
	) else echo ��ʽ��submit.bat ��֧���� ע��
) else echo ��ʽ��submit.bat ��֧���� ע��