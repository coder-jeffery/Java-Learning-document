Redis笔记：
    NoSQL： Not Only SQL
    memcached：键值对 内存数据库 断电就无法记录 redis具备持久化
    hbase列存储
    MongoDB document存储 
Redis模式：槽位  16384
    Sentinal
    Cluster
Redis五种类型：
    String 字符串 键值对、String类型是二进制安全 key-value String键值最大存储512MB
        key/value：存储value对象以序列化方式存储 引入CAS
    Hash 哈希 键值对 
        id为key 对象作为value 减少序列化和反序列化开销
    List 列表  键集合不可重复
        简单字符串列表，按照插入顺序排训、添加一个元素到列表的头部或者尾部
    Set 集合  键集合可以重复 唯一性 可以自动排重
    ZSet 有序集合 有序集合
Redis 对key操作：
    ttl 
    expire
字符串key操作
    set
    get
    setnx 仅当key不存在时新增 不存在返回1 存在返回0
    setex 设置过期时间 会覆盖新值
哈希 Hash：
    hset 三个字段
    hget
    hmset 多个kv
    hmget 多个kv
    hgettall
    hdel
    hvals
列表：List
    rpush 末尾插入
    lrange 查找范围 lrange list 0 -1
    lpush 头插入 返回列表长度
    llen 列表长度
    lrem 正数 从左往右删除。负数 从右往左删
SET集合：
    无序 不允许重复
    sadd:
    scards:
    smembers
有序集合ZSet：
    zadd zset 1 a 5 b 2 c 3 d 
    zrange zset 0 -1
    zrange zset 

Redis持久话：
    RDB 默认方式 指定时间间隔保存文件 
    AOF
    
    
    