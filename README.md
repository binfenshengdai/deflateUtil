## 一款支持deflate算法的压缩解压工具
支持大部分的deflate算法压缩后的文件解压
#### 运行环境
 jdk 1.8
#### 使用说明
- 命令说明： java -jar defalteUtil.jar [参数1] [参数2] [参数3]
- 解压: java -jar deflateUtil.jar j [源文件] [生成文件]
- 压缩: java -jar deflateUtil.jar y [源文件] [生成文件]
- 例如: java -jar deflateUtil.jar y /usr/sundae/a.txt /usr/sundae/a.txt.deflate