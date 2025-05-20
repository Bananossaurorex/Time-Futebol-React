import React from 'react';
import './styles.css'; // opcional, para estilizar depois
import { useNavigate } from 'react-router-dom'

function PaginaBemvindo() {
    const navigate = useNavigate()
  return (
    <div className="pagina-bemvindo">
      <h1>Bem-vindo!</h1>
      <p>Você entrou no sistema dos Crocodilos Sarados 🐊⚽</p>
      <button onClick={() => navigate('/cadastro')} className='botao-bemvindo'>
                    Entrar para o time!!
        </button>
    </div>
  );
}

export default PaginaBemvindo;