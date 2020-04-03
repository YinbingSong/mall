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

### get:

#### 		1. 管理员账号

> 1. allAdmins
> 2. deleteAdmins
> 3. getAdminsInfo

####  		2. 用户管理

> 4. allUser
> 5. deleteUser

```
   Request:
   id: 460
   Response:
   {"code":0}
```

> ​	6.searchUser

```
   Request:
     word: ad
   Response:
     {"code":0,"data":[{"id":1,"email":"admin","nickname":"admin","pwd":"admin","recipient":"admin","address":"admin","phone":"11111111111"}]}
```



#### 		3. 商品管理

> 7. getType
> 8. getGoodsByType

## 2.用户模块：/api/admin/user/*



## 3.商品模块：/api/admin/product/*

## 4.订单模块：/api/admin/order/*