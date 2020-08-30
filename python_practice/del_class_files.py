# /usr/local/bin/python3
# -*- coding: UTF-8 -*-

import os

# 删除此路径下所有class文件
def del_class_files(root_path):
    for (root, dirs, files) in os.walk(root_path):
        for name in files:
            if '.class' in name:
                # 这行语句很危险，注意不要删错文件
                os.remove(os.path.join(root, name))
                print("Delete file: ", os.path.join(root, name))


def check_files_in_current_project(root_path):
    for (root, dirs, files) in os.walk(root_path):
        for name in files:
            path = os.path.join(root, name)
            if '.class' in name:
                print("Please check file: ", os.path.join(root, name))
            if '/interview/' in path:
                print("WARNING: root path contains other files out of interview project")
                print(path)
                return False
    return True


if __name__ == "__main__":
    # 注意，这里相对路径是以python解释器启动路径为目标,如果在vscode终端某个目录下执行代码，相对路径会发生变化
    # 安全执行命令的方式是进入python_practice目录下，执行命令 python3 del_class_files.py
    root_path = "../"
    if check_files_in_current_project(root_path):
        # del_class_files(root_path)
        pass
