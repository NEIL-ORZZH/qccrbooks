package com.qccr.books.lib.util.retrofit;

import java.util.List;

/**
 * @author: zhuhuanhuan
 * @time: 16/9/6-下午1:52.
 * @email: zhuhuanhuan@qccr.com
 * @desc:
 */

public final class DouBanBook {

    /**
     * max : 10
     * numRaters : 460
     * average : 9.0
     * min : 0
     */

    private RatingEntity rating;
    /**
     * rating : {"max":10,"numRaters":460,"average":"9.0","min":0}
     * subtitle :
     * author : ["Brian Goetz","Tim Peierls","Joshua Bloch","Joseph Bowbeer","David Holmes","Doug Lea"]
     * pubdate : 2012-2
     * tags : [{"count":728,"name":"Java","title":"Java"},{"count":590,"name":"并发","title":"并发"},{"count":423,"name":"多线程","title":"多线程"},{"count":166,"name":"编程","title":"编程"},{"count":120,"name":"java","title":"java"},{"count":104,"name":"计算机","title":"计算机"},{"count":58,"name":"线程","title":"线程"},{"count":48,"name":"软件开发","title":"软件开发"}]
     * origin_title : Java Concurrency in Practice
     * image : http://img3.douban.com/mpic/s7663093.jpg
     * binding : 平装
     * translator : ["童云兰"]
     * catalog : 对本书的赞誉 译者序 前　言 第1章　简介1 1.1　并发简史1 1.2　线程的优势2 1.2.1　发挥多处理器的强大能力2 1.2.2　建模的简单性3 1.2.3　异步事件的简化处理3 1.2.4　响应更灵敏的用户界面4 1.3　线程带来的风险4 1.3.1　安全性问题5 1.3.2　活跃性问题7 1.3.3　性能问题7 1.4　线程无处不在7 第一部分　基础知识 第2章　线程安全性11 2.1　什么是线程安全性13 2.2　原子性14 2.2.1　竞态条件15 2.2.2　示例：延迟初始化中的竞态条件16 2.2.3　复合操作17 2.3　加锁机制18 2.3.1　内置锁20 2.3.2　重入21 2.4　用锁来保护状态22 2.5　活跃性与性能23 第3章　对象的共享27 3.1　可见性27 3.1.1　失效数据28 3.1.2　非原子的64位操作29 3.1.3　加锁与可见性30 3.1.4　Volatile变量 30 3.2　发布与逸出32 3.3　线程封闭35 3.3.1　Ad-hoc线程封闭35 3.3.2　栈封闭36 3.3.3　ThreadLocal类37 3.4　不变性38 3.4.1　Final域39 3.4.2　示例：使用Volatile类型来发布不可变对象40 3.5　安全发布41 3.5.1　不正确的发布：正确的对象被破坏42 3.5.2 　不可变对象与初始化安全性42 3.5.3　安全发布的常用模式43 3.5.4　事实不可变对象44 3.5.5　可变对象44 3.5.6　安全地共享对象44 第4章　对象的组合46 4.1　设计线程安全的类46 4.1.1　收集同步需求47 4.1.2　依赖状态的操作48 4.1.3　状态的所有权48 4.2　实例封闭49 4.2.1　Java监视器模式51 4.2.2　示例：车辆追踪51 4.3　线程安全性的委托53 4.3.1　示例：基于委托的车辆追踪器54 4.3.2　独立的状态变量55 4.3.3　当委托失效时56 4.3.4　发布底层的状态变量57 4.3.5　示例：发布状态的车辆追踪器58 4.4　在现有的线程安全类中添加功能59 4.4.1　客户端加锁机制60 4.4.2　组合62 4.5　将同步策略文档化62 第5章　基础构建模块66 5.1　同步容器类66 5.1.1　同步容器类的问题66 5.1.2　迭代器与Concurrent-ModificationException68 5.1.3　隐藏迭代器69 5.2　并发容器70 5.2.1　ConcurrentHashMap71 5.2.2　额外的原子Map操作72 5.2.3　CopyOnWriteArrayList72 5.3　阻塞队列和生产者-消费者模式73 5.3.1　示例：桌面搜索75 5.3.2　串行线程封闭76 5.3.3　双端队列与工作密取77 5.4　阻塞方法与中断方法77 5.5　同步工具类78 5.5.1　闭锁79 5.5.2　FutureTask80 5.5.3　信号量82 5.5.4　栅栏83 5.6　构建高效且可伸缩的结果缓存85 第二部分　结构化并发应用程序 第6章　任务执行93 6.1　在线程中执行任务93 6.1.1　串行地执行任务94 6.1.2　显式地为任务创建线程94 6.1.3　无限制创建线程的不足95 6.2　Executor框架96 6.2.1　示例：基于Executor的Web服务器97 6.2.2　执行策略98 6.2.3　线程池98 6.2.4　Executor的生命周期99 6.2.5　延迟任务与周期任务101 6.3　找出可利用的并行性102 6.3.1　示例：串行的页面渲染器102 6.3.2　携带结果的任务Callable与Future103 6.3.3　示例：使用Future实现页面渲染器104 6.3.4　在异构任务并行化中存在的局限106 6.3.5　CompletionService:Executor与BlockingQueue106 6.3.6　示例：使用CompletionService实现页面渲染器107 6.3.7　为任务设置时限108 6.3.8　示例：旅行预定门户网站109 第7章　取消与关闭111 7.1　任务取消111 7.1.1　中断113 7.1.2　中断策略116 7.1.3　响应中断117 7.1.4　示例：计时运行118 7.1.5　通过Future来实现取消120 7.1.6　处理不可中断的阻塞121 7.1.7　采用newTaskFor来封装非标准的取消122 7.2　停止基于线程的服务124 7.2.1　示例：日志服务124 7.2.2　关闭ExecutorService127 7.2.3　“毒丸”对象128 7.2.4　示例：只执行一次的服务129 7.2.5　shutdownNow的局限性130 7.3　处理非正常的线程终止132 7.4　JVM关闭135 7.4.1　关闭钩子135 7.4.2　守护线程136 7.4.3　终结器136 第8章　线程池的使用138 8.1　在任务与执行策略之间的隐性耦合138 8.1.1　线程饥饿死锁139 8.1.2　运行时间较长的任务140 8.2　设置线程池的大小140 8.3　配置ThreadPoolExecutor141 8.3.1　线程的创建与销毁142 8.3.2　管理队列任务142 8.3.3　饱和策略144 8.3.4　线程工厂146 8.3.5　在调用构造函数后再定制ThreadPoolExecutor147 8.4　扩展 ThreadPoolExecutor148 8.5　递归算法的并行化149 第9章　图形用户界面应用程序156 9.1　为什么GUI是单线程的156 9.1.1　串行事件处理157 9.1.2　Swing中的线程封闭机制158 9.2　短时间的GUI任务160 9.3　长时间的GUI任务161 9.3.1　取消162 9.3.2　进度标识和完成标识163 9.3.3　SwingWorker165 9.4　共享数据模型165 9.4.1　线程安全的数据模型166 9.4.2　分解数据模型166 9.5　其他形式的单线程子系统167 第三部分　活跃性、性能与测试 第10章　避免活跃性危险169 10.1　死锁169 10.1.1　锁顺序死锁170 10.1.2　动态的锁顺序死锁171 10.1.3　在协作对象之间发生的死锁174 10.1.4　开放调用175 10.1.5　资源死锁177 10.2　死锁的避免与诊断178 10.2.1　支持定时的锁178 10.2.2　通过线程转储信息来分析死锁178 10.3　其他活跃性危险180 10.3.1　饥饿180 10.3.2　糟糕的响应性181 10.3.3　活锁181 第11章　性能与可伸缩性183 11.1　对性能的思考183 11.1.1　性能与可伸缩性184 11.1.2　评估各种性能权衡因素185 11.2　Amdahl定律186 11.2.1　示例：在各种框架中隐藏的串行部分188 11.2.2　Amdahl定律的应用189 11.3　线程引入的开销189 11.3.1　上下文切换190 11.3.2　内存同步190 11.3.3　阻塞192 11.4　减少锁的竞争192 11.4.1　缩小锁的范围（“快进快出”）193 11.4.2　减小锁的粒度195 11.4.3　锁分段196 11.4.4　避免热点域197 11.4.5　一些替代独占锁的方法198 11.4.6　监测CPU的利用率199 11.4.7　向对象池说“不”200 11.5　示例：比较Map的性能200 11.6　减少上下文切换的开销201 第12章　并发程序的测试204 12.1　正确性测试205 12.1.1　基本的单元测试206 12.1.2　对阻塞操作的测试207 12.1.3　安全性测试208 12.1.4　资源管理的测试212 12.1.5　使用回调213 12.1.6　产生更多的交替操作214 12.2　性能测试215 12.2.1　在PutTakeTest中增加计时功能215 12.2.2　多种算法的比较217 12.2.3　响应性衡量218 12.3　避免性能测试的陷阱220 12.3.1　垃圾回收220 12.3.2　动态编译220 12.3.3　对代码路径的不真实采样222 12.3.4　不真实的竞争程度222 12.3.5　无用代码的消除223 12.4　其他的测试方法224 12.4.1　代码审查224 12.4.2　静态分析工具224 12.4.3　面向方面的测试技术226 12.4.4　分析与监测工具226 第四部分　高级主题 第13章　显式锁227 13.1　Lock与 ReentrantLock227 13.1.1　轮询锁与定时锁228 13.1.2　可中断的锁获取操作230 13.1.3　非块结构的加锁231 13.2　性能考虑因素231 13.3　公平性232 13.4　在synchronized和ReentrantLock之间进行选择234 13.5　读-写锁235 第14章　构建自定义的同步工具238 14.1　状态依赖性的管理238 14.1.1　示例：将前提条件的失败传递给调用者240 14.1.2　示例：通过轮询与休眠来实现简单的阻塞241 14.1.3　条件队列243 14.2　使用条件队列244 14.2.1　条件谓词244 14.2.2　过早唤醒245 14.2.3　丢失的信号246 14.2.4　通知247 14.2.5　示例：阀门类248 14.2.6　子类的安全问题249 14.2.7　封装条件队列250 14.2.8　入口协议与出口协议250 14.3　显式的Condition对象251 14.4　Synchronizer剖析253 14.5　AbstractQueuedSynchronizer254 14.6　java.util.concurrent同步器类中的 AQS257 14.6.1　ReentrantLock257 14.6.2　Semaphore与CountDownLatch258 14.6.3　FutureTask259 14.6.4　ReentrantReadWriteLock259 第15章　原子变量与非阻塞同步机制261 15.1　锁的劣势261 15.2　硬件对并发的支持262 15.2.1　比较并交换263 15.2.2　非阻塞的计数器264 15.2.3　JVM对CAS的支持265 15.3　原子变量类265 15.3.1　原子变量是一种“更好的volatile”266 15.3.2　性能比较：锁与原子变量267 15.4　非阻塞算法270 15.4.1　非阻塞的栈270 15.4.2　非阻塞的链表272 15.4.3　原子的域更新器274 15.4.4　ABA问题275 第16章　Java内存模型277 16.1　什么是内存模型，为什么需要它277 16.1.1　平台的内存模型278 16.1.2　重排序278 16.1.3　Java内存模型简介280 16.1.4　借助同步281 16.2　发布283 16.2.1　不安全的发布283 16.2.2　安全的发布284 16.2.3　安全初始化模式284 16.2.4　双重检查加锁286 16.3　初始化过程中的安全性287 附录A　并发性标注289 参考文献291
     * pages : 293
     * images : {"small":"http://img3.douban.com/spic/s7663093.jpg","large":"http://img3.douban.com/lpic/s7663093.jpg","medium":"http://img3.douban.com/mpic/s7663093.jpg"}
     * alt : https://book.douban.com/subject/10484692/
     * id : 10484692
     * publisher : 机械工业出版社华章公司
     * isbn10 : 711137004X
     * isbn13 : 9787111370048
     * title : Java并发编程实战
     * url : http://api.douban.com/v2/book/10484692
     * alt_title : Java Concurrency in Practice
     * author_intro : 本书作者都是Java Community Process JSR 166专家组（并发工具）的主要成员，并在其他很多JCP专家组里任职。Brian Goetz有20多年的软件咨询行业经验，并著有至少75篇关于Java开发的文章。Tim Peierls是“现代多处理器”的典范，他在BoxPop.biz、唱片艺术和戏剧表演方面也颇有研究。Joseph Bowbeer是一个Java ME专家，他对并发编程的兴趣始于Apollo计算机时代。David Holmes是《The Java Programming Language》一书的合著者，任职于Sun公司。Joshua Bloch是Google公司的首席Java架构师，《Effective Java》一书的作者，并参与著作了《Java Puzzlers》。Doug Lea是《Concurrent Programming》一书的作者，纽约州立大学 Oswego分校的计算机科学教授。
     * summary : 本书深入浅出地介绍了Java线程和并发，是一本完美的Java并发参考手册。书中从并发性和线程安全性的基本概念出发，介绍了如何使用类库提供的基本并发构建块，用于避免并发危险、构造线程安全的类及验证线程安全的规则，如何将小的线程安全类组合成更大的线程安全类，如何利用线程来提高并发应用程序的吞吐量，如何识别可并行执行的任务，如何提高单线程子系统的响应性，如何确保并发程序执行预期任务，如何提高并发代码的性能和可伸缩性等内容，最后介绍了一些高级主题，如显式锁、原子变量、非阻塞算法以及如何开发自定义的同步工具类。 本书适合Java程序开发人员阅读。
     * price : 69.00元
     */

    private String subtitle;
    private String pubdate;
    private String origin_title;
    private String image;
    private String binding;
    private String catalog;
    private String pages;
    /**
     * small : http://img3.douban.com/spic/s7663093.jpg
     * large : http://img3.douban.com/lpic/s7663093.jpg
     * medium : http://img3.douban.com/mpic/s7663093.jpg
     */

    private ImagesEntity images;
    private String alt;
    private String id;
    private String publisher;
    private String isbn10;
    private String isbn13;
    private String title;
    private String url;
    private String alt_title;
    private String author_intro;
    private String summary;
    private String price;
    private List<String> author;
    /**
     * count : 728
     * name : Java
     * title : Java
     */

    private List<TagsEntity> tags;
    private List<String> translator;

    public RatingEntity getRating() {
        return rating;
    }

    public void setRating(RatingEntity rating) {
        this.rating = rating;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getOrigin_title() {
        return origin_title;
    }

    public void setOrigin_title(String origin_title) {
        this.origin_title = origin_title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public ImagesEntity getImages() {
        return images;
    }

    public void setImages(ImagesEntity images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlt_title() {
        return alt_title;
    }

    public void setAlt_title(String alt_title) {
        this.alt_title = alt_title;
    }

    public String getAuthor_intro() {
        return author_intro;
    }

    public void setAuthor_intro(String author_intro) {
        this.author_intro = author_intro;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public List<TagsEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagsEntity> tags) {
        this.tags = tags;
    }

    public List<String> getTranslator() {
        return translator;
    }

    public void setTranslator(List<String> translator) {
        this.translator = translator;
    }

    public static class RatingEntity {
        private int max;
        private int numRaters;
        private String average;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getNumRaters() {
            return numRaters;
        }

        public void setNumRaters(int numRaters) {
            this.numRaters = numRaters;
        }

        public String getAverage() {
            return average;
        }

        public void setAverage(String average) {
            this.average = average;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class ImagesEntity {
        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class TagsEntity {
        private int count;
        private String name;
        private String title;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
