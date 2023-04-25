--liquibase formatted sql
--changeset <Serhii Buria>:<add-data-table-recipes>

insert into recipes (complexity_id, cooking_time, cuisine_region_id, dish_type_id, image_url, portions, spiced, subtitle, dish_name)
values (2, 120, 4, 5, 'https://i.ibb.co/X2tsCpz/Rectangle-88.png', 10, 0, 'Як приготувати класичний борщ з томатно-буряковою заправкою', 'Класичний борщ');