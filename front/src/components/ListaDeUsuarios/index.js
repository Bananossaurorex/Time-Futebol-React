// src\components\ListaDeUsuarios\index.js

import { useState, useEffect } from "react";
import axios from "axios";
import './styles.css'

function ListaDeUsuarios() {
    const [usuarios, setUsuarios] = useState([])
    useEffect(() => {
        const carregarUsuarios = async () => {
            try {
                const response = await axios.get('http://localhost:8080/usuarios')
                setUsuarios(response.data)
            } catch (error) {
                alert('Erro ao buscar usuários: ', error)
                setUsuarios([])
            }
        }
        carregarUsuarios()
    }, [])
    function PaginaListaUsuarios() {
        return (
          <div className="pagina-lista"></div>
        )
          }
    return (
        <div className="card-usuarios">
                <h1>Lista de usuários</h1>
                <ul className="lista-usuarios">
                    {usuarios.map(usuario => (
                        <li key={usuario.id}>
                            <strong>Nome:</strong> {usuario.nome}<br />
                            <strong>Sexo:</strong> {usuario.sexo}<br />
                            <strong>Idade:</strong> {usuario.idade}<br />
                            <strong>Altura:</strong> {usuario.altura}m<br />
                            <strong>Peso:</strong> {usuario.peso}kg<br />
                            <strong>Posição:</strong> {usuario.posicao}
                        </li>
                    ))}
                </ul>
            </div>
    )
    
}

export default ListaDeUsuarios