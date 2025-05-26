// src\components\FormularioCadastro\index.js

import { useState } from "react";
import './styles.css'
import { useNavigate } from "react-router-dom";
import useMensagem from '../../hooks/useMensagem'
import MensagemFeedback from '../MensagemFeedback'
import logo from '../../assets/images/crocodilossarados.png'
import axios from 'axios'

function FormularioCadastro() {
    const [nome, setNome] = useState('')
    const [sexo, setSexo] = useState('')
    const [idade, setIdade] = useState('')
    const [altura, setAltura] = useState('')
    const [peso, setPeso] = useState('')
    const [posicao, setPosicao] = useState('')
    const [numCamisa, setNumCamisa] = useState('')
    const navigate = useNavigate()
    const { exibirMensagem , mensagem, tipoMensagem, visivel, fecharMensagem } = useMensagem()

    const cadastrarUsuario = async () => {
        
        try {
            const response = await axios.post('http://localhost:8080/usuarios', {nome, sexo, idade, altura, peso, posicao, numCamisa})
            exibirMensagem(response.data.mensagem || 'Usuário cadastrado com sucesso!', 'sucesso')
            setNome('')
            setSexo('')
            setIdade('')
            setAltura('')
            setPeso('')
            setPosicao('')
            setNumCamisa('')
        } catch (error) {
            let erroMsg = 'Erro ao conectar ao servidor.'
            if (error.response && error.response.data) {
                erroMsg = error.response.data.mensagem
                if (error.response.data.erros) {
                    erroMsg += ' ' + Object.values(error.response.data.erros).join(', ')
                }
            }
            exibirMensagem(erroMsg, 'erro')
        }
    }
    function PaginaCadastro() {
  return (
    <div className="pagina-cadastrado"></div>
  )
    }
    return (
        
        <div className="container">
            <img src={logo} style ={{ marginBottom: 0}} alt="Logo da empresa" />
            <h3 style={{marginTop: 0}}>Crocodilos Sarados</h3>
            <h2>Cadastro de jogador</h2>
            <form onSubmit={(e) => {e.preventDefault(); cadastrarUsuario()}}>
                <input 
                    type="text"
                    id="nome"
                    placeholder="Nome"
                    value={nome}
                    onChange={(e) => setNome(e.target.value)}
                    required
                />
               <select
                value = {sexo}
                onChange={(e) => setSexo(e.target.value)}
                >
                {sexo === '' && (
                    <option value="" disabled>Selecione o sexo</option>
                )}
                <option value="MASCULINO">Masculino</option>
                <option value="FEMININO">Feminino</option>
               </select>

               <select
                value = {posicao}
                onChange={(e) => setPosicao(e.target.value)}
                >
                {posicao === '' && (
                    <option value="" disabled>Selecione a posição</option>
                )}
                <option value="GOLEIRO">Goleiro</option>
                <option value="ZAQUEIRO">Zaqueiro</option>
                <option value="LATERAL">Lateral</option>
                <option value="VOLANTE">Volante</option>
                <option value="ARMADOR">Armador</option>
                <option value="MEIOCAMPISTA">MeioCampista</option>
                <option value="PONTA">Ponta</option>
                <option value="CENTROAVANTE">CentroAvante</option>
               </select>

                <input 
                    type="text"
                    id="idade"
                    placeholder="Idade"
                    value={idade}
                    onChange={(e) => setIdade(e.target.value)}
                    required
                />
                <input 
                    type="text"
                    id="altura"
                    placeholder="Altura"
                    value={altura}
                    onChange={(e) => setAltura(e.target.value)}
                    required
                />
                <input 
                    type="text"
                    id="peso"
                    placeholder="Peso"
                    value={peso}
                    onChange={(e) => setPeso(e.target.value)}
                    required
                />
                <input 
                    type="text"
                    id="numCamisa"
                    placeholder="Número da Camisa"
                    value={numCamisa}
                    onChange={(e) => setNumCamisa(e.target.value)}
                    required
                />
                <button type="submit">Cadastrar</button>
            </form>

            <button onClick={() => navigate('/usuarios')} className="link-usuarios">
                Ver usuários cadastrados
            </button>

            <MensagemFeedback
                mensagem={mensagem}
                tipo={tipoMensagem}
                visivel={visivel}
                onclose={fecharMensagem}
            />
        </div>
    )
}

export default FormularioCadastro