INSERT INTO `cliente` (`id_cliente`, `cpf`, `email`, `endereco`, `nome`) VALUES (1, '17585249537', 'rayssali@gmail.com', 'Rua Mercurio', 'Rayssa Lima');

INSERT INTO `cliente` (`id_cliente`, `cpf`, `email`, `endereco`, `nome`) VALUES (2, '458.964.238-97', 'richardpi@gmail.com', 'Rua Venus', 'Richard Pires');

INSERT INTO `cliente` (`id_cliente`, `cpf`, `email`, `endereco`, `nome`) VALUES (3, '794.685.234-12', 'eduardaca@gmail.com', 'Rua Terra', 'Eduarda Castelo');

INSERT INTO `vendedor` (`id_vendedor`, `cpf`, `email`, `nome`) VALUES (1, '458.964.238-97', 'felipecri@gmail.com', 'Felipe Cristomo');

INSERT INTO `vendedor` (`id_vendedor`, `cpf`, `email`, `nome`) VALUES (2, '794.685.234-12', 'diegocr@gmail.com', 'Diego Cristophe');

INSERT INTO `vendedor` (`id_vendedor`, `cpf`, `email`, `nome`) VALUES (3, '498.964.238-97', 'robertosa@gmail.com', 'Roberto Santiago');

INSERT INTO `venda` (`id_venda`, `data`, `cliente_id_cliente`, `vendedor_id_vendedor`) VALUES (1, '2023-05-19', '1', '1');

INSERT INTO `venda` (`id_venda`, `data`, `cliente_id_cliente`, `vendedor_id_vendedor`) VALUES (2, '2022-07-30', '2', '3');

INSERT INTO `venda` (`id_venda`, `data`, `cliente_id_cliente`, `vendedor_id_vendedor`) VALUES (3, '2020-10-09', '2', '2');

INSERT INTO `produto` (`id_produto`, `nome`, `preco`, `quantidade_em_estoque`) VALUES (1, 'Boneca Barbie', '50.00', '1000');

INSERT INTO `produto` (`id_produto`, `nome`, `preco`, `quantidade_em_estoque`) VALUES (2, 'Carrinho Hot Wheels', '10.00', '2000');

INSERT INTO `produto` (`id_produto`, `nome`, `preco`, `quantidade_em_estoque`) VALUES (3, 'Boneca Polly Pocket', '40.00', '200');

INSERT INTO `item_da_venda` (`id_item_da_venda`, `quantidade`, `valor_total`, `produto_id_produto`, `venda_id_venda`) VALUES (1, '3', '150.00', '1', '1');

INSERT INTO `item_da_venda` (`id_item_da_venda`, `quantidade`, `valor_total`, `produto_id_produto`, `venda_id_venda`) VALUES (2, '2', '20.00', '2', '3');

INSERT INTO `item_da_venda` (`id_item_da_venda`, `quantidade`, `valor_total`, `produto_id_produto`, `venda_id_venda`) VALUES (3, '5', '200.00', '3', '1');

