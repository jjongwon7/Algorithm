-- 코드를 입력하세요


select sales_date, product_id, user_id, sales_amount
from (
    SELECT date_format(sales_date, '%Y-%m-%d') as sales_date, product_id, user_id, sales_amount
    from online_sale
    where EXTRACT(MONTH FROM sales_date) = 3
    UNION ALL
    SELECT date_format(sales_date, '%Y-%m-%d') as sales_date, product_id, NULL as user_id, sales_amount
    from offline_sale
    where EXTRACT(MONTH FROM sales_date) = 3
) result
order by sales_date, product_id, user_id