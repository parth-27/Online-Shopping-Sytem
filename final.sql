create table signin(email varchar2(50) constraint pk_email Primary Key,password varchar2(20) not null);

create table customer(email varchar2(50),name varchar2(50) not null,ph_no varchar2(10) not null, address varchar2(100) not null,constraint fk_email Foreign key (email) references signin(email));

create or replace procedure create_user(mail IN signin.email%TYPE,pass IN signin.password%TYPE, result OUT int) as
begin
result:=0;
insert into signin(email,password) values(mail,pass);
commit;
result := 1;
exception
when others then
result := 0;
rollback;
end

create or replace procedure add_user(mail IN customer.email%TYPE,uname IN customer.name%TYPE,phone IN customer.ph_no%TYPE,add IN customer.address%TYPE, result OUT int) as
begin
result:=0;
insert into customer(email,name,ph_no,address) values(mail,uname,phone,add);
commit;
result := 1;
exception
when others then
result := 0;
rollback;
end

create or replace procedure check_user(mail IN signin.email%TYPE,pass IN signin.password%TYPE, result OUT varchar2) as
begin
select email into result from signin where email=mail and password=pass;
exception
when NO_DATA_FOUND then
result := 'USER ID AND PASSWORD INCORRECT';
end;

create or replace procedure get_details(mail IN signin.email%TYPE,uname OUT varchar2,phone OUT varchar2,adr OUT varchar2,pwd OUT varchar2) as
begin
select name,ph_no,address into uname,phone,adr from customer where email=mail;
select password into pwd from signin where email=mail;
exception
when others then
rollback;
end;
/


create or replace procedure update_details(mail IN signin.email%TYPE, uname IN customer.name%TYPE, phone IN customer.ph_no%TYPE, adr IN customer.address%TYPE, pwd IN signin.password%TYPE, result OUT int) as
begin
update customer set name=uname, ph_no=phone,address=adr where email=mail;
update signin set password=pwd where email=mail;
result:=1;
exception
when others then
result:=0;
rollback;
end

//

create table category(cat_id int constraint pk2_email Primary Key, cat_name  varchar2(50) NOT NULL UNIQUE);

create table product(prod_id int constraint pk3_email Primary Key,
					 cat_id int,
					 prod_name varchar2(50) UNIQUE,
					 price int,
					 quantity int,
					 constraint fk2_email Foreign key (cat_id) references category(cat_id));

CREATE OR REPLACE TRIGGER cat_bir
BEFORE INSERT ON category
FOR EACH ROW

BEGIN
  SELECT dept_seq.NEXTVAL
  INTO   :new.cat_id
  FROM   dual;
END;

 CREATE SEQUENCE dept_seq START WITH 1;


CREATE OR REPLACE TRIGGER prod_bir
BEFORE INSERT ON product
FOR EACH ROW

BEGIN
  SELECT prod_seq.NEXTVAL
  INTO   :new.prod_id
  FROM   dual;
END;

 CREATE SEQUENCE prod_seq START WITH 1;

insert into category values (dept_seq.nextval,'fashion');


	CREATE OR REPLACE PROCEDURE add_product (
	    prod_name      IN   product.prod_name%type,
	    price          IN   product.price%type,
	    quantity	   IN   product.quantity%type,
		catt_name       IN   category.cat_name%type,result OUT int
	) AS
		cursor c_name is select cat_id from category where cat_name = catt_name;
		r_name c_name%rowtype;
	BEGIN
		open c_name;
		loop
			fetch c_name into r_name;
			if c_name%notfound then
	                    insert into category values(dept_seq.nextval,catt_name);
	                else
		INSERT INTO product(prod_id,cat_id,prod_name,price,quantity) VALUES (
	        prod_seq.nextval,
	        r_name.cat_id,
	        prod_name,
	        price,
		quantity
	        );
	end if;
	exit;
	end loop;
	close c_name;
	commit;
	result := 1;
	exception
	when others then
	result := 0;
	rollback;
	END add_product;


	-- create or replace procedure add_cart(prodname in product.prod_name%TYPE,mail in signin.email%TYPE,qty in product.quantity%TYPE,result out int) as
	-- 	cursor c_prodid is select * from product where prod_name=prodname;
	-- 	r_prodid c_prodid%rowtype;
	-- 	cursor c_shop is select * from shoppingcart where email=mail;
	-- 	r_shop c_shop%rowtype;
	-- 	begin
	-- 	open c_prodid;
	-- 	    loop
	-- 	    fetch c_prodid into r_prodid;
	-- 	    if c_prodid%notfound then
	-- 	        result:=0;
	-- 	    exit;
	-- 	    else
	-- 		open c_shop;
	-- 		loop
	-- 			fetch c_shop into r_shop;
	-- 			if c_shop%found then
	--                                 update shoppingcart set quantity = qty where email = mail and prod_name = prodname;
	--                         exit;
	-- 			else
	--                                 insert into shoppingcart(email,prod_id,prod_name,price,quantity) values(mail,r_prodid.prod_id,prodname,r_prodid.price,qty);
	--                                 result:=1;
	--                      end if;
	--                    end loop;
	-- 		close c_shop;
	-- 	      exit;
	-- 	    end if;
	-- 	end loop;
	-- close c_prodid;
	-- end;



create table shoppingcart(email varchar2(50),prod_id int,
prod_name varchar2(50),
price int ,quantity int,
constraint pk_shop primary key(email,prod_id),
constraint fk_emailshop Foreign key (email) references signin(email),
constraint fk2_prodid Foreign key (prod_id) references product(prod_id));


create or replace procedure resetcart(emailin in signin.email%TYPE,result out int) as
BEGIN
	delete from shoppingcart where email=emailin;
	result:=1;
	exception
	when others then
	result:=0;
	rollback;
END

create or replace procedure getcart_details(emailin in shoppingcart.email%TYPE, cart_details OUT SYS_REFCURSOR) as
BEGIN
	open cart_details for select prod_name,price,quantity from shoppingcart where email=emailin;
END

create or replace procedure getproduct_details(catname in category.cat_name%TYPE, prod_details OUT SYS_REFCURSOR) as
BEGIN
	open prod_details for select prod_name,price from product where cat_id=(select cat_id from category where cat_name=catname);
END

create or replace procedure getuser_details(user_details OUT SYS_REFCURSOR) as
BEGIN
	open user_details for select * from signin join customer on signin.email=customer.email;
END


CREATE OR REPLACE function tot_amt(shopemail IN shoppingcart.email%type) return int as tot_amt int;
cursor c_shop is select price,quantity from shoppingcart where email = shopemail;
r_shop c_shop%rowtype;
begin
tot_amt:=0;
open c_shop;
loop
fetch c_shop into r_shop;
if c_shop%notfound then
exit;
else
	tot_amt:=tot_amt+(r_shop.price);
end if;
end loop;
close c_shop;
return tot_amt;
end;
/

create table orderdetails(order_id int, prod_id int,
	email varchar2(50),
	prod_name varchar2(50),
	price int,
	quantity int,
	totalprice int,
	constraint pkk_ord primary key(order_id,prod_id),
	constraint fkk_ord Foreign key(order_id) references placeorder(order_id));

create or replace procedure addyourorder(orderid in int,emailid in signin.email%TYPE, tprice in int, result out int) as
cursor c_addorder is select * from shoppingcart where email = emailid;
r_addorder c_addorder%ROWTYPE;
begin
result:=0;
open c_addorder;
loop
  fetch c_addorder into r_addorder;
    if c_addorder%notfound then
    exit;
    else
      insert into orderdetails(order_id,prod_id,email,prod_name,price,quantity,totalprice) values(orderid,r_addorder.prod_id,emailid,r_addorder.prod_name,r_addorder.price,r_addorder.quantity,tprice);
			result:=1;
    end if;
end loop;
close c_addorder;
exception
when others then
result:=0;
rollback;
end;
/
create table placeorder(order_id int,
		email varchar2(50),
		name varchar2(50),
		city varchar2(50),
		address varchar2(100),
		ph_no varchar2(10),
		constraint pk5_ord primary key(order_id));

create or replace procedure orderplace(orderid in int,emailid in placeorder.email%TYPE,add in placeorder.address%TYPE,phnnumber in placeorder.ph_no%type,name in customer.name%TYPE, city in varchar2, result out int) as
begin
result:=0;
  insert into placeorder values(orderid,emailid,name,city,add,phnnumber);
	result:=1;
	exception
	when others then
	result:=0;
end;
/

CREATE OR REPLACE TRIGGER ord_bir
BEFORE INSERT ON placeorder
FOR EACH ROW

BEGIN
  SELECT ord_seq.NEXTVAL
  INTO   :new.order_id
  FROM   dual;
END;
/


CREATE SEQUENCE ord_seq
  START WITH 1
  INCREMENT BY 1
  CACHE 100;


create or replace trigger check_quan before insert on orderdetails
for each row
declare
cursor c_quan is select quantity from product where prod_name = :new.prod_name;
r_quan c_quan%rowtype;
begin
open c_quan;
loop
fetch c_quan into r_quan;
if c_quan%notfound then
  raise_application_error(-20001,'Quantity not available');
exit;
else
    if (r_quan.quantity<:new.quantity) then
      raise_application_error(-20001,'Enough quantity not available');
end if;
end if;
end loop;
close c_quan;
end;


create or replace trigger sub_quan after insert on orderdetails
for each row
declare
cursor c_quan is select quantity from product where prod_name = :new.prod_name;
r_quan c_quan%rowtype;
begin
open c_quan;
loop
fetch c_quan into r_quan;
if c_quan%notfound then
  exit;
else
    update product set quantity=(r_quan.quantity - :new.quantity);
end if;
end loop;
close c_quan;
end;
/

create table payment(pay_id int,order_id int,pay_type varchar2(50) ,totalprice int,
constraint pkk_pay primary key(pay_id),
constraint fkk_pay Foreign key (order_id) references placeorder(order_id) );

CREATE SEQUENCE pay_seq
  START WITH 1
  INCREMENT BY 1
  CACHE 100;

====================================================
create or replace procedure getorder_id (mail in signin.email%TYPE,ord_id OUT sys_refcursor) as
begin
open ord_id for select order_id from placeorder where email=mail;
end


create or replace procedure disorder (mail in signin.email%TYPE,cnt out int) as
begin
select distinct count(order_id) into cnt from placeorder where email=mail;
end

create or replace procedure getinvoice(ordid in int,get_inv OUT sys_refcursor) as
begin
open get_inv for select * from orderdetails where order_id=ordid;
end


create or replace procedure ordidcnt(ordid in int,cnt out int) as
begin
select count(order_id) into cnt from orderdetails where order_id=ordid;
end

create or replace procedure getallorders(allorder out sys_refcursor) as
begin
open allorder for select * from orderdetails;
end

create or replace procedure getuserorders(mail in signin.email%TYPE,allorder out sys_refcursor) as
begin
open allorder for select * from orderdetails where email=mail;
end


create or replace procedure add_cart(prodname in product.prod_name%TYPE,email in signin.email%TYPE,quantity in product.quantity%TYPE,result out int) as
cursor c_prodid is select * from product where prod_name=prodname;
r_prodid c_prodid%rowtype;
begin
open c_prodid;
    loop
    fetch c_prodid into r_prodid;
    if c_prodid%notfound then
        result:=0;
    exit;
    else
      insert into shoppingcart(email,prod_id,prod_name,price,quantity) values(email,r_prodid.prod_id,prodname,r_prodid.price*quantity,quantity);
      result:=1;
      exit;
    end if;
end loop;
close c_prodid;
end;
/

create or replace procedure add_pay(ord_id in int,paytype in varchar,tprice in int, result out int) as
begin
insert into payment(pay_id,order_id,pay_type,totalprice) values(pay_seq.nextval,ord_id,paytype,tprice);
end

create or replace procedure getpaydetails(ord_id in int,paytype out varchar, tprice out int) as
	BEGIN
	select pay_type,totalprice into paytype,tprice from payment where order_id=ord_id;
	end
