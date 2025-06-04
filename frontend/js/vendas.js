fetch("http://localhost:8080/vendas", {
    headers: {
        "Authorization": "Bearer " + localStorage.getItem("token")
    }
})
    .then(res => {
        if (!res.ok) {
            if (res.status === 401) {
                alert("Sessão expirada. Faça login novamente.");
                window.location.href = "index.html";
            }
            throw new Error("Erro ao buscar vendas");
        }
        return res.json();
    })
    .then(vendas => {
        carregarVendas();
        console.log(vendas);
    })
    .catch(err => {
        console.error(err.message);
    });

document.addEventListener("DOMContentLoaded", carregarVendas);

function carregarVendas() {
    fetch("http://localhost:8080/vendas", {
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("token")
        }
    })
        .then(res => {
            if (!res.ok) {
                if (res.status === 401) {
                    alert("Sessão expirada. Faça login novamente.");
                    window.location.href = "index.html";
                }
                throw new Error("Erro ao carregar vendas");
            }
            return res.json();
        })
        .then(vendas => {
            const tabela = document.getElementById("tabela-vendas");
            tabela.innerHTML = "";

            vendas.forEach(venda => {
                const linha = document.createElement("tr");

                // coluna ID
                const tdId = document.createElement("td");
                tdId.textContent = venda.id;

                // coluna Data
                const tdData = document.createElement("td");
                tdData.textContent = venda.data;

                // coluna Itens (quantidade de itens ou nomes dos produtos)
                const tdItens = document.createElement("td");
                tdItens.textContent = venda.itens?.length || 0;

                // coluna Ações
                const tdAcoes = document.createElement("td");

                const btnEditar = document.createElement("button");
                btnEditar.textContent = "Editar";
                btnEditar.onclick = () => editarVenda(venda.id);

                const btnExcluir = document.createElement("button");
                btnExcluir.textContent = "Excluir";
                btnExcluir.onclick = () => excluirVenda(venda.id);

                tdAcoes.appendChild(btnEditar);
                tdAcoes.appendChild(btnExcluir);

                linha.appendChild(tdId);
                linha.appendChild(tdData);
                linha.appendChild(tdItens);
                linha.appendChild(tdAcoes);

                tabela.appendChild(linha);
            });
        })
        .catch(err => console.error(err.message));
}

function editarVenda(id) {
    alert("Função de editar venda com ID " + id + " ainda não implementada.");
}

function excluirVenda(id) {
    if (!confirm("Tem certeza que deseja excluir esta venda?")) return;

    fetch(`http://localhost:8080/vendas/${id}`, {
        method: "DELETE",
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("token")
        }
    })
        .then(res => {
            if (res.ok) {
                alert("Venda excluída com sucesso.");
                carregarVendas();
            } else {
                alert("Erro ao excluir venda.");
            }
        });
}
