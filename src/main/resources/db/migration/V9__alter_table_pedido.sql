ALTER TABLE Pedido
MODIFY COLUMN status ENUM('Pendente', 'Pago', 'Cancelado') NOT NULL;
