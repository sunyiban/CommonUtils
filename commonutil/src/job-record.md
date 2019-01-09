# 这里记录一下工作中踩得坑
## 关于maven
一：在maven打包时，默认会执行测试用例，这个行为可能会导致报错。通过以下配置跳过测试：
\<plugin>
    \<groupId>org.apache.maven.plugins\</groupId>
    \<artifactId>maven-surefire-plugin\</artifactId>
    \<configuration>
        \<skipTests>true\</skipTests>
    \</configuration>
\</plugin>
--

## 关于反射
一：在通过反射获取执行方法时，如果参数类型是基本数据类型可能无法正常解析，用包装类型可以解决。

--

## 关于系统
一：今天遇到一个奇葩问题，win7系统，在生成txt文件时，文件内容一直是编码错误，原因是无法解析一个词 连某，或者某字，编码是GBK，
但是在部署到Linux服务器上后不会出错。

--

