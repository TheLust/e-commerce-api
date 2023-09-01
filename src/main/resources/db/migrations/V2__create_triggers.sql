-- V2__create_triggers.sql

CREATE OR REPLACE FUNCTION check_order_product_quantity()
    RETURNS TRIGGER AS $check_order_product_quantity$
BEGIN
    IF NEW.quantity > (SELECT inventory FROM product WHERE id = NEW.product_id) THEN
        RAISE EXCEPTION 'Order quantity exceeds available product quantity.';
    END IF;
    RETURN NEW;
END;
$check_order_product_quantity$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION set_discount_to_default()
    RETURNS TRIGGER AS $set_discount_to_default$
BEGIN
    IF NEW.discount_type IS NULL THEN
        NEW.discount_type = 'NONE';
    END IF;

    IF NEW.discount IS NULL THEN
        NEW.discount = 0.0;
    END IF;

    RETURN NEW;
END;
$set_discount_to_default$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER enforce_order_product_quantity
    BEFORE INSERT OR UPDATE ON order_item
    FOR EACH ROW
EXECUTE FUNCTION check_order_product_quantity();

CREATE OR REPLACE TRIGGER before_insert_update_discount
    BEFORE INSERT OR UPDATE ON product
        FOR EACH ROW
            EXECUTE FUNCTION set_discount_to_default();
