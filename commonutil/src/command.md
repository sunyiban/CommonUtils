# 这里面记录的是一些零散的命令

## maven 打包
### clean install package -Pprod
最后一个参数的意思是你使用的配置文件目录，比如在resource目录下有两套配置文件
prod 和 test，通过这个命令可以打出对应的包。执行此命令后在项目下的target文件
夹中会出现对应的war包。