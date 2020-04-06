# mall

 A Mall Project based on Vue and JavaWeb

 # 商店（Vue与Servlet） #

 1.管理员模块：/api/admin/admin/
 --

###  post:

#### 		1. 管理员账号

> 1. admin.login
> 2. admin.addAdminss
> 3. updateAdminss
> 4. getSearchAdmins
> 5. changePwd

#### 		2. 用户管理



#### 		3. 商品管理
> ​	1.addGoods

```
{name: "1", typeId: "236", img: "", desc: "描述",…}
name: "1"
typeId: "236"
img: ""
desc: "描述"
specList: [{specName: "默认", stockNum: "2", unitPrice: "3"}]
```
	
> 	2.addType

```
Request:
name: "juno"
Response:
{"code":0}
```

> 	3.addGoods

```
Request:
name: "juno"
Response:
{"code":0}
```

> 	4.imgUpload

> 	5.deleteSpec

> 	6.updateGoods

> 	7.addSpec

#### 		4. 订单管理
> 	1.ordersByPage


### get:

#### 		1. 管理员账号

> 1. allAdmins
> 2. deleteAdmins
> 3. getAdminsInfo

####  		2. 用户管理

> 1. allUser
> 2. deleteUser

```
   Request:
   id: 460
   Response:
   {"code":0}
```

> ​3.searchUser

```
   Request:
     word: ad
   Response:
     {"code":0,"data":[{"id":1,"email":"admin","nickname":"admin","pwd":"admin","recipient":"admin","address":"admin","phone":"11111111111"}]}
```



#### 		3. 商品管理

> 1. getType

```
>       Response:
>            {"code":0,"data":[{"id":190,"name":"男装"},{"id":191,"name":"电子产品"},{"id":192,"name":"食品"},{"id":193,"name":"家居家具"},{"id":194,"name":"二手交易"},{"id":206,"name":"书籍"},{"id":216,"name":"水果"},{"id":224,"name":"咖啡"},{"id":225,"name":"球鞋"},{"id":230,"name":"灵丹"},{"id":233,"name":"啥玩意"},{"id":235,"name":"文具"}]}
```

> 2. getGoodsByType

```
>       Request:
>    
>    ​		typeId: 190
>    
>       Response:
>    
>    ​		{"code":0,"data":[{"id":475,"img":"http://115.29.141.32:8084/static/image/1570850192433156699448698020190828201124.jpg","name":"半身裙","price":100.0,"typeId":190,"stockNum":1532},{"id":534,"img":"http://115.29.141.32:8084/static/image/1585744787830timg (1).jpg","name":"球鞋","price":1399.0,"typeId":190,"stockNum":123118}]}
```

​	

> 3.deleteGoods?id=546

```
>       Request:
>    
>    ​		id: 546
>    
>       Response:
>    
>    ​		{"code":0}
```

> 4.getGoodsInfo

#### 		4. 订单管理
ordersByPage



## 2.用户模块：/api/admin/user/*



## 3.商品模块：/api/admin/product/*

## 4.订单模块：/api/admin/order/*