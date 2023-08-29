-- V2023-08-29__create_trigger.sql

CREATE OR REPLACE FUNCTION check_order_item_quantity()
    RETURNS TRIGGER AS $check_order_item_quantity$
BEGIN
    IF NEW.quantity > (SELECT quantity FROM inventory WHERE id = NEW.product_id) THEN
        RAISE EXCEPTION 'Order quantity exceeds available inventory.';
    END IF;
    RETURN NEW;
END;
$check_order_item_quantity$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER enforce_order_item_quantity
    BEFORE INSERT OR UPDATE ON order_item
    FOR EACH ROW
EXECUTE FUNCTION check_order_item_quantity();
