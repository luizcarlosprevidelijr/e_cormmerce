CREATE TABLE audit_preco_item (
    id INT AUTO_INCREMENT PRIMARY KEY,
    item_id INT NOT NULL,
    preco_antigo DECIMAL(10, 2) NOT NULL,
    preco_novo DECIMAL(10, 2) NOT NULL,
    data_alteracao DATE NOT NULL,
    FOREIGN KEY (item_id) REFERENCES item(id)
);
