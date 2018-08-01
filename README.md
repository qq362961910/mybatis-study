####
Init db script
```sql
CREATE TABLE `user` (
  `id` bigint(20) primary key,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` smallint(1) DEFAULT NULL
)
```
