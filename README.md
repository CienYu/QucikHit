# QuickHit
a pratice project

#测试环境: jdk1.8

#测试软件: idea

#编码格式: utf-8

#version: 2.0

#version note:
    2.0
        no和role的功能存在重复，将no和role分开，no为玩家等级，role为玩家段位，游戏难度由role决定
        no改为玩家等级的提升通过题数，role的提升通过积分，两者相辅相成
        role
            0: Rookie
            1: credit>getCreditLimit() && no>getNoLimit()
        no
            0: 0
            1: queSum>getQueLimit(this.role.getValue)
    1.0
        no与枚举值绑定，游戏难度随着角色变化而变化

#游戏配置和参数请在config中的Setting中修改

#主要涉及知识: 字符串的处理,文件I/O操作,常用数据结构,java反射知识,java计时器,异常处理,枚举类

#本项目仅作学期java课程总结,且存在部分为了使用而使用的代码结构,代码不一定没有bug,欢迎反馈

#by:Cien

