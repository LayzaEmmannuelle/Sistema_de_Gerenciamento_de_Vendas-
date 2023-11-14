DELIMITER //
CREATE TRIGGER valor_total
BEFORE INSERT ON item_da_venda
FOR EACH ROW
BEGIN
    DECLARE preco_produto DECIMAL(10, 2);

    -- Use uma cláusula WHERE para corresponder ao produto certo
    SELECT preco INTO preco_produto FROM produto WHERE id_produto = NEW.produto_id_produto;
    
    -- Calcule o preço total e atribua-o ao campo correto
    SET NEW.valor_total = NEW.quantidade * preco_produto;
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER quantidade_em_estoque
AFTER INSERT ON item_da_venda
FOR EACH ROW
BEGIN
    -- Subtrair a quantidade vendida do estoque do produto correspondente
    UPDATE produto
    SET quantidade_em_estoque = quantidade_em_estoque - NEW.quantidade
    WHERE id_produto = NEW.produto_id_produto;
    
    -- Adicione aqui a lógica adicional que deseja modificar
    -- Por exemplo, verificar se o estoque ficou negativo e tomar ação adicional
END;
//
DELIMITER ;

INSERT INTO cliente (id_cliente, nome, email, cpf, endereco) VALUES (NULL, 'Rayssa Lima', 'rayssali@gmail.com', '175.852.495-38', 'Rua Mercúrio');

INSERT INTO cliente (id_cliente, nome, email, cpf, endereco) VALUES (NULL, 'Stephanie Cardoso', 'stephanieca@gmail.com', '158.698.438-65', 'Rua Vênus');

INSERT INTO produto (id_produto, nome, preco, quantidade_em_estoque) VALUES (NULL, 'Boneca Barbie', '60.00', '1000');

INSERT INTO produto (id_produto, nome, preco, quantidade_em_estoque) VALUES (NULL, 'Carro Hotwheels', '10.00', '500');

INSERT INTO vendedor (id_vendedor, nome, email, cpf) VALUES (NULL, 'Guilherme Alvares', 'guilhermeal@gmail.com', '458.965.891-26');

INSERT INTO vendedor (id_vendedor, nome, email, cpf) VALUES (NULL, 'Ricardo Santos', 'ricardosa@gmail.com', '785.657.942-31');

INSERT INTO venda (id_venda, vendedor_id_vendedor, cliente_id_cliente, data) VALUES (NULL, '1', '2', '2023-07-30');

INSERT INTO venda (id_venda, vendedor_id_vendedor, cliente_id_cliente, data) VALUES (NULL, '2', '1', '2020-03-12');

INSERT INTO item_da_venda (id_item_da_venda, produto_id_produto, venda_id_venda, quantidade, valor_total) VALUES (NULL, '1', '1', '5', '');

INSERT INTO item_da_venda (id_item_da_venda, produto_id_produto, venda_id_venda, quantidade, valor_total) VALUES (NULL, '2', '1', '3', '');
