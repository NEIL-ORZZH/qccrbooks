# 汽车超人图书app
* author: zhuhuanhuan@qccr.com
* group: twl_android
* time: 2016/07/18

## 说明
* 本项目都是copy即刻app ui,如果遇到涉及版权啥的,立删

## 项目说明
* butterknife只能用7.0.1的

## 参考资料
* https://github.com/wequick/Small，请到这个地址仔细阅读

## 感谢开源的第三方依赖
* https://github.com/wequick/Small
* https://github.com/tyzlmjj/PagerBottomTabStrip
* https://github.com/CymChad/BaseRecyclerViewAdapterHelper
* https://github.com/JakeWharton/butterknife
* https://github.com/JeasonWong/JikeGallery
* https://github.com/SkillCollege/ZBarAndroidSDK
* https://github.com/AndroidKnife/RxBus
* https://github.com/f2prateek/rx-preferences
* https://github.com/dlew/joda-time-android
* https://github.com/bumptech/glide
* https://github.com/drakeet/Meizhi
* https://github.com/square/retrofit

## 感谢免费的服务
* 伟大的豆瓣, I love u more than I can say: http://api.douban.com/v2/
* http://gank.io/api


## 功能
* 借书，还书
* 关注技术内容
* 评论

## 意料之中的内容
* 一次架构的改变，其存在的问题会逐渐在我们后面的开发当中暴露出来
* 在探索过程中，需要尽可能得考虑会出现的问题，因为这会对后续其他同学采用这一框架带来开发成本
* 当前正确的设计对于十倍或者百倍的增长可能就是非常错误的了，可以针对十倍的增长进行设计，但在增长到百倍之前就要计划去重写了
* 好的模块化是一个健康代码库的关键部分，当要更换一个系统时，模块化通常能够带来巨大的帮助。最好的一种做法就是，在系统早期系统就探索最好的模块化结构应该是什么样的，以便你能够基于替换的认知去进行构建。由于在早期时它就被设计成了全部系统都是可以牺牲的，随着系统的增长要牺牲独立模块时就会更加的高效，因为如果你有良好的模块边界，就只做简单地替换就可以了
* 写牺牲的架构的团队决定了牺牲的时机，也了解代码在未来牺牲掉是一件好事