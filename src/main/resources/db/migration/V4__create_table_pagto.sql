CREATE TABLE Pagamento (
    id_pedido INT NOT NULL,
    id_forma_pagto INT NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (id_pedido, id_forma_pagto),
    FOREIGN KEY (id_pedido) REFERENCES Pedido(id),
    FOREIGN KEY (id_forma_pagto) REFERENCES Forma_Pagto(id)
);
