INSERT INTO merchent.requests
    (created,
    customer_name,
    customer_phone,
    customer_mail,
    customer_address,
    position,
    delivery)
VALUES
    (CURRENT_DATE(), 'Петр1', '1234567', 'some@mail.domain', 'Город, улица и дом', 'P', NULL);