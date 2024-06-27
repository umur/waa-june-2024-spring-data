insert into spring_data.address (city, id, street, zip)
values  ('string', '352c4543-de60-432d-b2f1-cc128a9ff79b', '321', 'string'),
        ('string', '4a824684-68ce-4da0-bd9e-c958a0c26110', 'string', 'string');

insert into spring_data.user (address_id, email, first_name, id, last_name, password)
values  ('4a824684-68ce-4da0-bd9e-c958a0c26110', 'string', 'string', '6a0e7d6f-bfd3-4e62-95cd-75e81f549ec0', 'string', 'string'),
        (null, 'update_string', 'update_string', '94972f49-f8e5-4327-8034-b5416083af88', 'update_string', 'update_string');


insert into spring_data.category (id, name)
values  ('2e71ddfa-b4c5-451b-a739-27cecd34f503', 'string'),
        ('4438b781-769b-4c17-a970-e660eb02eff3', 'string'),
        ('dc6d21c9-0773-4441-9c67-b4012b371688', 'string'),
        ('ff2d6462-7a45-4dbd-bb0b-ee66246b2264', 'string');

insert into spring_data.product (price, rating, category_id, id, name)
values  (0, 0, '2e71ddfa-b4c5-451b-a739-27cecd34f503', '08b38814-419c-4f12-ad4a-f1759cbd6000', 'string'),
        (707, 0, '2e71ddfa-b4c5-451b-a739-27cecd34f503', '12d8e0ed-1a0a-4677-87b2-57be552a0032', 'string'),
        (197, 0, '2e71ddfa-b4c5-451b-a739-27cecd34f503', '1b94e9ba-62a3-4f1b-bfa0-adf4e516744c', 'string'),
        (0, 0, '2e71ddfa-b4c5-451b-a739-27cecd34f503', '28103cc2-6aa9-4c6b-8352-51d307b2feec', 'string'),
        (0, 0, '2e71ddfa-b4c5-451b-a739-27cecd34f503', '416c5c24-d5ac-4e94-95b6-f8b627af8f5a', 'string'),
        (0, 0, '2e71ddfa-b4c5-451b-a739-27cecd34f503', '4a80968c-05e8-4fdb-91e3-3b6c8b21023e', 'string'),
        (0, 0, '2e71ddfa-b4c5-451b-a739-27cecd34f503', '80d25302-b812-4244-8f95-9ea7d19746a0', 'string'),
        (975, 0, '2e71ddfa-b4c5-451b-a739-27cecd34f503', 'af288b0e-47a3-4a61-83e3-1c35ded1922b', 'string'),
        (999, 4.9, '2e71ddfa-b4c5-451b-a739-27cecd34f503', 'cc408922-697a-4390-bfae-a95af4db8542', 'update_name'),
        (0, 0, '2e71ddfa-b4c5-451b-a739-27cecd34f503', 'd7300feb-3554-41b4-b744-c021c5f042f2', 'string');

insert into spring_data.review (comment, id, product_id, user_id)
values  ('string', '04eded84-9e20-4160-bf12-db9fff97ebcd', '4a80968c-05e8-4fdb-91e3-3b6c8b21023e', '94972f49-f8e5-4327-8034-b5416083af88'),
        ('string', '0ec3b1f5-7c5a-41ea-a5d7-ff45b91fc3b5', 'd7300feb-3554-41b4-b744-c021c5f042f2', '6a0e7d6f-bfd3-4e62-95cd-75e81f549ec0'),
        ('string', '12472534-dc66-43c5-9591-220ba4d905c8', 'd7300feb-3554-41b4-b744-c021c5f042f2', '6a0e7d6f-bfd3-4e62-95cd-75e81f549ec0'),
        ('string', '14b5a10e-9ff4-4895-af6d-9c8a52864a09', 'd7300feb-3554-41b4-b744-c021c5f042f2', '6a0e7d6f-bfd3-4e62-95cd-75e81f549ec0'),
        ('string', '465cfe7d-88f5-4d5a-8258-1cc154e57c21', '4a80968c-05e8-4fdb-91e3-3b6c8b21023e', '94972f49-f8e5-4327-8034-b5416083af88'),
        ('string', '4a61d258-b08d-45aa-b866-2c35f079dcb1', '4a80968c-05e8-4fdb-91e3-3b6c8b21023e', '6a0e7d6f-bfd3-4e62-95cd-75e81f549ec0'),
        ('string', '51384b1d-8806-492d-90b4-e19ee9f537f0', '4a80968c-05e8-4fdb-91e3-3b6c8b21023e', '94972f49-f8e5-4327-8034-b5416083af88'),
        ('string', '6d2aeabc-ee95-492f-8de3-7c7bb79f5399', '4a80968c-05e8-4fdb-91e3-3b6c8b21023e', '94972f49-f8e5-4327-8034-b5416083af88'),
        ('string', '8ce8481e-a2c8-4223-a4d8-48729acc2786', 'd7300feb-3554-41b4-b744-c021c5f042f2', '6a0e7d6f-bfd3-4e62-95cd-75e81f549ec0'),
        ('string', '9de3e34e-0b36-4234-94bf-eaae2e142444', '4a80968c-05e8-4fdb-91e3-3b6c8b21023e', '6a0e7d6f-bfd3-4e62-95cd-75e81f549ec0'),
        ('string', 'cf680155-7afe-4571-93b4-6b2912bc2d70', 'd7300feb-3554-41b4-b744-c021c5f042f2', '6a0e7d6f-bfd3-4e62-95cd-75e81f549ec0'),
        ('string', 'd43376f9-2254-4b91-a3a0-99c1703de0de', '4a80968c-05e8-4fdb-91e3-3b6c8b21023e', '94972f49-f8e5-4327-8034-b5416083af88'),
        ('string', 'eedefbea-59b7-4420-bdf7-b6182a50a31d', '4a80968c-05e8-4fdb-91e3-3b6c8b21023e', '94972f49-f8e5-4327-8034-b5416083af88'),
        ('string', 'fb222d54-4e9f-4de2-8d13-35458f21e6e6', '4a80968c-05e8-4fdb-91e3-3b6c8b21023e', '94972f49-f8e5-4327-8034-b5416083af88');