# 项目名称 (terminal-rail)

一个基于 Java 和 ANSI 转义字符构建的命令行游戏原型。

## 如何运行（目前尚未推出，敬请期待）

1.  确保已安装 Java 17。
2.  下载本仓库的 JAR 包。
3.  在终端中运行：`java -jar your-jar-file-name.jar`

## 游戏操作

采用Scanner对命令行读取操作输入，内容均为小写字母，Enter确认指令。

- x 开关光标显示（后续操作均仅在光标点亮情况下视为有效）
- z 扳动道岔
- wasd 切换选定的道岔
- quit/exit 退出游戏

## 构建项目

本项目使用 Maven 构建，运行 `mvn clean package` 即可打包。
