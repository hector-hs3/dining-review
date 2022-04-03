INSERT INTO users(id,name,city,state,zipcode,peanut,egg,dairy) VALUES (1,'hector0791','Miami','FL',33130,false,false,false);

INSERT INTO reviews(id,user,restaurant_id,peanut,egg,dairy,comment,status) VALUES (1,'hector0791',1,1,1,1,'Okay','PENDING');

INSERT INTO restaurants(id,name,zipcode,reviews,overall,peanut,egg,dairy) VALUES (1,'Chipotle',33130,1,3,3,3,3);