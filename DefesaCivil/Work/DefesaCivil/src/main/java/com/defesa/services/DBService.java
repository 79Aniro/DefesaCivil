

package com.defesa.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.defesa.domain.Departamento;
import com.defesa.domain.Endereco;
import com.defesa.domain.Funcionario;
import com.defesa.domain.Ocorrencia;
import com.defesa.domain.OrigemOcorrencia;
import com.defesa.domain.Relatorio;
import com.defesa.domain.Solicitante;
import com.defesa.domain.TipoOcorrencia;
import com.defesa.domain.TipoSolicitante;
import com.defesa.domain.Tramitacao;
import com.defesa.domain.enums.Perfil;
import com.defesa.repositories.DepartamentoRepository;
import com.defesa.repositories.EnderecoRepository;
import com.defesa.repositories.FuncionarioRepository;
import com.defesa.repositories.OcorrenciaRepository;
import com.defesa.repositories.OrigemOcorrenciaRepository;
import com.defesa.repositories.RelatorioRepository;
import com.defesa.repositories.SolicitanteRepository;
import com.defesa.repositories.TipoOcorrenciaRepository;
import com.defesa.repositories.TipoSolicitanteRepository;
import com.defesa.repositories.TramitacaoRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private EnderecoRepository endRepository;

	@Autowired
	private SolicitanteRepository solicitanteRepository;
	@Autowired
	private RelatorioRepository relatorioRepository;

	@Autowired
	private OcorrenciaRepository ocoRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Autowired
	private TipoSolicitanteRepository tipoSolRepository;
	
	@Autowired
	private OrigemOcorrenciaRepository oriOcoRepository;
	

	
	@Autowired
	private TipoOcorrenciaRepository tipoOcoRepository;
	
	@Autowired
	private TramitacaoRepository tramitacaoRepository;
	
	public void insert() throws ParseException {
		instantiateTestDatabase();
		instantiateTestDatabase2();
		insere3();
		insere4();
	}

	protected void instantiateTestDatabase() throws ParseException {

		///////////////////////////
		Endereco rua1 = new Endereco(null, "Rua Benedito Pedroso de Andrade", "Águas da Prata", "Leste", "12225261");
		Endereco rua2 = new Endereco(null, "Rua Luiz Miguel dos Santos", "Alto da Ponte", "Norte", "12212300");
		Endereco rua3 = new Endereco(null, "Rua Tamandaré", "Alto da Ponte", "Norte", "12212301");
		Endereco rua4 = new Endereco(null, "Travessa Noé de Souza Lima", "Alto da Ponte", "Norte", "12212310");
		Endereco rua5 = new Endereco(null, "Avenida Nacib Simão", "Alto da Ponte", "Norte", "12212320");
		Endereco rua6 = new Endereco(null, "Rodovia Monteiro Lobato", "Alto da Ponte", "Norte", "12212325");
		Endereco rua7 = new Endereco(null, "Rua Ester Oliveira Bertolini", "Alto da Ponte", "Norte", "12212330");
		Endereco rua8 = new Endereco(null, "Rua José Maria Vilaça", "Alto da Ponte", "Norte", "12212340");
		Endereco rua9 = new Endereco(null, "Rua Maria Renata Alcântara Manfredini", "Alto da Ponte", "Norte",
				"12212371");
		Endereco rua10 = new Endereco(null, "Rua Audemo Veneziani", "Alto da Ponte", "Norte", "12212372");
		Endereco rua11 = new Endereco(null, "Rua Agenor Luchetti Simão", "Alto da Ponte", "Norte", "12212390");
		Endereco rua12 = new Endereco(null, "Rua Sebastiana Maria Trindade", "Alto da Ponte", "Norte", "12212410");
		Endereco rua13 = new Endereco(null, "Rua David Miguel dos Santos", "Alto da Ponte", "Norte", "12212420");
		Endereco rua14 = new Endereco(null, "Rua Itararé", "Alto da Ponte", "Norte", "12212430");
		Endereco rua15 = new Endereco(null, "Estrada Municipal Pedro Moacir de Almeida", "Alto da Ponte", "Norte",
				"12212452");
		Endereco rua16 = new Endereco(null, "Ponte Domingos Fortes de Almeida", "Alto da Ponte", "Norte", "12212471");
		Endereco rua17 = new Endereco(null, "Rua José Pereira Filho", "Alto da Ponte", "Norte", "12212490");
		Endereco rua18 = new Endereco(null, "Rua Alzirio Lebrão", "Alto da Ponte", "Norte", "12212500");
		Endereco rua19 = new Endereco(null, "Praça Padre José Rúbens Franco Bonafe", "Alto da Ponte", "Norte",
				"12212510");
		Endereco rua20 = new Endereco(null, "Rua Vicente Paulo dos Santos", "Alto da Ponte", "Norte", "12212511");
		Endereco rua21 = new Endereco(null, "Rua Cândido Gonçalves Gomes", "Alto da Ponte", "Norte", "12212512");
		Endereco rua22 = new Endereco(null, "Travessa Santa Joana D'Arc", "Alto da Ponte", "Norte", "12212515");
		Endereco rua23 = new Endereco(null, "Rua Maria Conceição da Cunha", "Alto da Ponte", "Norte", "12212520");
		Endereco rua24 = new Endereco(null, "Avenida Rui Barbosa", "Alto da Ponte", "Norte", "12212531");
		Endereco rua25 = new Endereco(null, "Travessa José Moreira Campos", "Alto da Ponte", "Norte", "12212620");
		Endereco rua26 = new Endereco(null, "Praça Padre José Rúbens Franco Bonafe", " 49", "Alto da Ponte", "Norte");
		Endereco rua27 = new Endereco(null, "Rua Rio Manso", "Altos da Vila Paiva", "Norte", "12213060");
		Endereco rua28 = new Endereco(null, "Rua Rio das Cobras", "Altos da Vila Paiva", "Norte", "12213062");
		Endereco rua29 = new Endereco(null, "Rua Rio Jaguari", "Altos da Vila Paiva", "Norte", "12213064");
		Endereco rua30 = new Endereco(null, "Rua Ribeirão da Fartura", "Altos da Vila Paiva", "Norte", "12213066");
		Endereco rua31 = new Endereco(null, "Rua Córrego da Ressaca", "Altos da Vila Paiva", "Norte", "12213068");
		Endereco rua32 = new Endereco(null, "Rua Córrego do Sabão", "Altos da Vila Paiva", "Norte", "12213070");
		Endereco rua33 = new Endereco(null, "Avenida Rio Buquira", "Altos da Vila Paiva", "Norte", "12213072");
		Endereco rua34 = new Endereco(null, "Rua Rio Turvo", "Altos da Vila Paiva", "Norte", "12213074");
		Endereco rua35 = new Endereco(null, "Rua Rio Pararangaba", "Altos da Vila Paiva", "Norte", "12213076");
		Endereco rua36 = new Endereco(null, "Rua Rio do Peixe", "Altos da Vila Paiva", "Norte", "12213078");
		Endereco rua37 = new Endereco(null, "Rua Ribeirão do Cajuru", "Altos da Vila Paiva", "Norte", "12213080");
		Endereco rua38 = new Endereco(null, "Rua Ribeirão da Água Soca", "Altos da Vila Paiva", "Norte", "12213082");
		Endereco rua39 = new Endereco(null, "Rua Córrego Senhorinha", "Altos da Vila Paiva", "Norte", "12213084");
		Endereco rua40 = new Endereco(null, "Rua Córrego do Sertãozinho", "Altos da Vila Paiva", "Norte", "12213086");
		Endereco rua41 = new Endereco(null, "Rua Ribeirão do Vidoca", "Altos da Vila Paiva", "Norte", "12213088");
		Endereco rua42 = new Endereco(null, "Rua Ribeirão do Guirra", "Altos da Vila Paiva", "Norte", "12213090");
		Endereco rua43 = new Endereco(null, "Rua Córrego do Cambuí", "Altos da Vila Paiva", "Norte", "12213092");
		Endereco rua44 = new Endereco(null, "Rua Córrego do Bengalar", "Altos da Vila Paiva", "Norte", "12213094");
		Endereco rua45 = new Endereco(null, "Rua Córrego do Roncador", "Altos da Vila Paiva", "Norte", "12213096");
		Endereco rua46 = new Endereco(null, "Rua Córrego Santa Bárbara", "Altos da Vila Paiva", "Norte", "12213098");
		Endereco rua47 = new Endereco(null, "Rua Rio Comprido", "Altos da Vila Paiva", "Norte", "12213100");
		Endereco rua48 = new Endereco(null, "Rua Ribeirão do Butá", "Altos da Vila Paiva", "Norte", "12213102");
		Endereco rua49 = new Endereco(null, "Rua Ribeirão Pau de Saia", "Altos da Vila Paiva", "Norte", "12213104");
		Endereco rua50 = new Endereco(null, "Rua Corrégo Lava Pés", "Altos da Vila Paiva", "Norte", "12213106");
		Endereco rua51 = new Endereco(null, "Rua Vinte e Quatro", "Altos da Vila Paiva", "Norte", "12213108");
		Endereco rua52 = new Endereco(null, "Rua Ribeirão do Putim", "Altos da Vila Paiva", "Norte", "12213110");
		Endereco rua53 = new Endereco(null, "Rua Córrego Taquari", "Altos da Vila Paiva", "Norte", "12213112");
		Endereco rua54 = new Endereco(null, "Rua Ribeirão Caeté", "Altos da Vila Paiva", "Norte", "12213114");
		Endereco rua55 = new Endereco(null, "Rua Carvalho de Araújo", "Vila Maria", "Leste", "12209390");
		Endereco rua56 = new Endereco(null, "Rua Targino Cardoso de Araújo", "Vila Nova Cristina", "Leste", "12211137");
		Endereco rua57 = new Endereco(null, "Rua Mário de Araújo Cesar", "Santana", "Leste", "12211250");
		Endereco rua58 = new Endereco(null, "Rua Raul Ramos de Araújo", "Santana", "Leste", "12211760");
		Endereco rua59 = new Endereco(null, "Rua José Araújo de Andrade", "Jardim Minas Gerais", "Leste", "12213256");
		Endereco rua60 = new Endereco(null, "Rua Anésio Rodrigues Araújo", "Jardim Nova Detroit", "Leste", "12224680");
		Endereco rua61 = new Endereco(null, "Rua Lavrinhas", "Chácaras Araújo II", "Leste", "12225121");
		Endereco rua62 = new Endereco(null, "Rua Três Rios", "Chácaras Araújo I", "Leste", "12225122");
		Endereco rua63 = new Endereco(null, "Rua Volta Redonda", "Chácaras Araújo I", "Leste", "12225123");
		Endereco rua64 = new Endereco(null, "Rua Barra Mansa", "Chácaras Araújo I", "Leste", "12225124");
		Endereco rua65 = new Endereco(null, "Rua Pinheiral", "Chácaras Araújo I", "Leste", "12225125");
		Endereco rua66 = new Endereco(null, "Rua Barra do Piraí", "Chácaras Araújo I", "Leste", "12225126");
		Endereco rua67 = new Endereco(null, "Rua Quatis", "Chácaras Araújo I", "Leste", "12225127");
		Endereco rua68 = new Endereco(null, "Rua Vassouras", "Chácaras Araújo I", "Leste", "12225128");
		Endereco rua69 = new Endereco(null, "Avenida Presidente Tancredo Neves", "Chácaras Araújo I", "Leste",
				"12225129");
		Endereco rua70 = new Endereco(null, "Avenida Cesário de Araújo", "Chácaras Araújo II", "Leste", "12225131");
		Endereco rua71 = new Endereco(null, "Rua Eduardo Lino", "Chácaras Araújo II", "Leste", "12225132");
		Endereco rua72 = new Endereco(null, "Rua São José do Barreiro", "Chácaras Araújo II", "Leste", "12225133");
		Endereco rua73 = new Endereco(null, "Rua Arapeí", "Chácaras Araújo II", "Leste", "12225134");
		Endereco rua74 = new Endereco(null, "Rua São Luiz do Paraitinga", "Chácaras Araújo II", "Leste", "12225135");
		Endereco rua75 = new Endereco(null, "Rua Silveiras", "Chácaras Araújo II", "Leste", "12225136");
		Endereco rua76 = new Endereco(null, "Rua Eugênia Paula de Araújo", "Chácaras Araújo II", "Leste", "12225137");
		Endereco rua77 = new Endereco(null, "Rua Canas", "Chácaras Araújo II", "Leste", "12225138");
		Endereco rua78 = new Endereco(null, "Rua Cachoeira Paulista", "Chácaras Araújo II", "Leste", "12225139");
		Endereco rua79 = new Endereco(null, "Rua Areias", "Chácaras Araújo II", "Leste", "12225141");
		Endereco rua80 = new Endereco(null, "Avenida Presidente Tancredo Neves", "Chácaras Araújo II", "Leste",
				"12225142");
		Endereco rua81 = new Endereco(null, "Avenida Bruno Bazetto", "Chácaras Araújo II", "Leste", "12225143");
		Endereco rua82 = new Endereco(null, "Avenida Porto Real", "Chácaras Araújo I", "Leste", "12225151");
		Endereco rua83 = new Endereco(null, "Rua Benedito de Araújo", "Chácaras Araújo I", "Leste", "12225152");
		Endereco rua84 = new Endereco(null, "Rua Vicente Antônio de Araújo", "Parque Nova Esperança", "Leste",
				"12226060");
		Endereco rua85 = new Endereco(null, "Avenida Marcos Antônio de Araújo", "Portal do Céu", "Leste", "12226231");
		Endereco rua86 = new Endereco(null, "Rua Benedicto Antonio de Araújo", "Campos de São José", "Leste",
				"12226510");
		Endereco rua87 = new Endereco(null, "Rua Ramiro Augusto de Araújo", "Campos de São José", "Leste", "12226680");
		Endereco rua88 = new Endereco(null, "Avenida Marcos Antonio Araújo", " 31 - Mercearia do Cezar", "Leste",
				"12226990");
		Endereco rua89 = new Endereco(null, "Rua Sargento Tertuliano Santos Araújo", "Conjunto Habitacional Leste A",
				"Leste", "12228452");
		Endereco rua90 = new Endereco(null, "Rua Getúlio Vargas de Araújo", "Jardim Torrão de Ouro", "Leste",
				"12229291");
		Endereco rua91 = new Endereco(null, "Rua Jacira Barbosa de Araújo", "Jardim República", "Leste", "12234838");
		Endereco rua92 = new Endereco(null, "Rua Maria Otília Araújo Lima de Oliveira", "Jardim Nova República",
				"Leste", "12234894");
		Endereco rua93 = new Endereco(null, "Rua Felício Alves de Araújo", "Parque dos Ipês", "Leste", "12236861");
		Endereco rua94 = new Endereco(null, "Travessa Antônio de Araújo Leite", "Residencial União", "Leste",
				"12239046");
		Endereco rua95 = new Endereco(null, "Rua Malvina Barbosa de Araújo", "Campo dos Alemães", "Leste", "12239401");
		Endereco rua96 = new Endereco(null, "Rua Antônio Rodrigues de Araújo", "Campo dos Alemães", "Leste",
				"12239510");
		Endereco rua97 = new Endereco(null, "Rua Pedro Rabelo de Araújo", "Jardim Apolo II", "Leste", "12243111");
		Endereco rua98 = new Endereco(null, "Rua Hugo de Araujo Freire", "Condomínio Residencial Colinas do Paratehy",
				"Leste", "12244118");
		Endereco rua99 = new Endereco(null, "Rua Sílvia de Araújo Lopes da Costa", "Condomínio Residencial Monte Carlo",
				"Leste", "12244163");
		Endereco rua100 = new Endereco(null, "Rua Economista Alfeu Gonçalves de Araújo",
				"Condomínio Residencial Colinas do Paratehy", "Leste", "12244185");
		Endereco rua101 = new Endereco(null, "Rua Marcos Salgado de Araújo", "Urbanova", "Leste", "12244360");
		Endereco rua102 = new Endereco(null, "Rua Narciso da Silva Araújo", "Jardim do Golfe", "Leste", "12244651");
		Endereco rua103 = new Endereco(null, "Rua Doutor José Job de Araújo Alves", "Condomínio Esplanada do Sol",
				"Leste", "12244810");
		Endereco rua104 = new Endereco(null, "Rua Orlando Machado de Araújo", "Jardim Itapoã", "Leste", "12247320");
		Endereco rua105 = new Endereco(null, "Rua Arnaldo Machado de Araújo", "Jardim Itapoã", "Leste", "12247380");
		Endereco rua106 = new Endereco(null, "Estrada Municipal Martins Guimarães", "Vila Tesouro", "Leste",
				"12221520");
		Endereco rua107 = new Endereco(null, "Estrada do Mato Dentro", "Jardim Nova Michigan", "Leste", "12225470");
		Endereco rua108 = new Endereco(null, "Avenida Engenheiro Florestan Fernandes", "Jardim Serimbura", "Centro",
				"12242012");
		Endereco rua109 = new Endereco(null, "Avenida Rodrigo Reis Tuy", "Jardim Serimbura", "Centro", "12242014");
		Endereco rua110 = new Endereco(null, "Rua Serimbura", "Vila Guaianazes", "Centro", "12243360");
		Endereco rua111 = new Endereco(null, "Praça Bom Jesus do Serimbura", "Vila Guaianazes", "Centro", "12243370");
		Endereco rua112 = new Endereco(null, "Rua Serimbura", " 355", "Vila Ema", "Centro");
		Endereco rua113 = new Endereco(null, "Praça Bom Jesus do Serimbura", " 60", "Vila Ema", "Centro");
		Endereco rua114 = new Endereco(null, "Rua Evandro Moreira", "Condomínio Chácara Serimbura", "Centro",
				"12244002");
		Endereco rua115 = new Endereco(null, "Rua Izidoro Bonvechio", "Condomínio Chácara Serimbura", "Centro",
				"12244003");
		Endereco rua116 = new Endereco(null, "Rua Tereza Cristina Vieira Gomes de Oliveira",
				"Condomínio Chácara Serimbura", "Centro", "12244004");
		Endereco rua117 = new Endereco(null, "Rua Paulo Roberto Pinto Neves", "Condomínio Chácara Serimbura", "Centro",
				"12244005");
		Endereco rua118 = new Endereco(null, "Rua Arlene Menna Barreto", "Condomínio Chácara Serimbura", "Centro",
				"12244006");
		Endereco rua119 = new Endereco(null, "Rua Pedro Paulo de Andrade", "Condomínio Chácara Serimbura", "Centro",
				"12244007");
		Endereco rua120 = new Endereco(null, "Rua Maria José Ricardo de Lima", "Condomínio Chácara Serimbura", "Centro",
				"12244008");
		Endereco rua121 = new Endereco(null, "Rua Helena Vaz de Lima Soliva", "Condomínio Chácara Serimbura", "Centro",
				"12244009");
		Endereco rua122 = new Endereco(null, "Rua Maurício Vaz de Lima", "Condomínio Chácara Serimbura", "Centro",
				"12244011");
		Endereco rua123 = new Endereco(null, "Rua Maria Izabel Mendes Gomes", "Condomínio Chácara Serimbura", "Centro",
				"12244012");
		Endereco rua124 = new Endereco(null, "Rua Antônia Rosa Batista", "Condomínio Chácara Serimbura", "Centro",
				"12244013");
		Endereco rua125 = new Endereco(null, "Avenida Jarbas Vaz de Lima", "Condomínio Chácara Serimbura", "Centro",
				"12244014");
		Endereco rua126 = new Endereco(null, "Travessa Dourados", "Jardim Beira Rio", "Oeste", "12212453");
		Endereco rua127 = new Endereco(null, "Travessa das Piabas", "Jardim Beira Rio", "Oeste", "12212455");
		Endereco rua128 = new Endereco(null, "Rua Beira Rio", "Residencial Caminho das Montanhas", "Oeste", "12213633");
		Endereco rua129 = new Endereco(null, "Rua Monsenhor Iran de Oliveira", "Bom Retiro", "Leste", "12226202");
		Endereco rua130 = new Endereco(null, "Estrada Municipal Nelson Tavares da Silva", "Bom Retiro", "Leste",
				"12226205");
		Endereco rua131 = new Endereco(null, "Rua Irene Toledo de Souza Gomes", "Bom Retiro", "Leste", "12226280");
		Endereco rua132 = new Endereco(null, "Rua José Augusto de Oliveira Barros", "Bom Retiro", "Leste", "12226290");
		Endereco rua133 = new Endereco(null, "Rua B", "Bom Retiro", "Leste", "12226291");
		Endereco rua134 = new Endereco(null, "Rua Barroso", "Bom Retiro", "Leste", "12226292");
		Endereco rua135 = new Endereco(null, "Praça Dom Carlos Carmelo Vasconcelos Motta", "Bom Retiro", "Leste",
				"12226294");
		Endereco rua136 = new Endereco(null, "Rua E", "Bom Retiro", "Leste", "12226295");
		Endereco rua137 = new Endereco(null, "Rua Clementino de Oliveira", "Bom Retiro", "Leste", "12226300");
		Endereco rua138 = new Endereco(null, "Travessa Mogno", "Bosque dos Eucaliptos", "Sul", "12232086");
		Endereco rua139 = new Endereco(null, "Rua Alfredo Coslop", "Bosque dos Eucaliptos", "Sul", "12232090");
		Endereco rua140 = new Endereco(null, "Rua Felisbino Franco Rodrigues", "Bosque dos Eucaliptos", "Sul",
				"12232091");
		Endereco rua141 = new Endereco(null, "Travessa Mangabeira", "Bosque dos Eucaliptos", "Sul", "12232096");
		Endereco rua142 = new Endereco(null, "Rua José Rachid", "Bosque dos Eucaliptos", "Sul", "12232100");
		Endereco rua143 = new Endereco(null, "Rua Geraldo Ferreira Tavares", "Bosque dos Eucaliptos", "Sul",
				"12232110");
		Endereco rua144 = new Endereco(null, "Rua João Rodrigues", "Bosque dos Eucaliptos", "Sul", "12232111");
		Endereco rua145 = new Endereco(null, "Rua José Duarte", "Bosque dos Eucaliptos", "Sul", "12232112");
		Endereco rua146 = new Endereco(null, "Rua Durvalina da Gama Ferreira", "Bosque dos Eucaliptos", "Sul",
				"12232120");
		Endereco rua147 = new Endereco(null, "Rua Antônio Quirino", "Bosque dos Eucaliptos", "Sul", "12232130");
		Endereco rua148 = new Endereco(null, "Rua José Alves Ribeiro Filho", "Bosque dos Eucaliptos", "Sul",
				"12232330");
		Endereco rua149 = new Endereco(null, "Rua Amâncio Mazzaropi", "Bosque dos Eucaliptos", "Sul", "12232340");
		Endereco rua150 = new Endereco(null, "Rua Cincinato Caetano da Silva", "Bosque dos Eucaliptos", "Sul",
				"12232341");
		Endereco rua151 = new Endereco(null, "Rua Tony Beik Frangio", "Bosque dos Eucaliptos", "Sul", "12232342");
		Endereco rua152 = new Endereco(null, "Rua Henrique Vinhas", "Bosque dos Eucaliptos", "Sul", "12232350");
		Endereco rua153 = new Endereco(null, "Praça José Carlos Bastos", "Bosque dos Eucaliptos", "Sul", "12232360");
		Endereco rua154 = new Endereco(null, "Rua Vanessa Marciano", "Bosque dos Eucaliptos", "Sul", "12232370");
		Endereco rua155 = new Endereco(null, "Rua Vera Lúcia Carnevalli Barreto", "Bosque dos Eucaliptos", "Sul",
				"12232371");
		Endereco rua156 = new Endereco(null, "Rua Lamartine Maia da Silva Torres", "Bosque dos Eucaliptos", "Sul",
				"12232380");
		Endereco rua157 = new Endereco(null, "Rua Professora Regina Rachid", "Bosque dos Eucaliptos", "Sul",
				"12232390");
		Endereco rua158 = new Endereco(null, "Rua Antenor Teodoro de Azevedo", "Bosque dos Eucaliptos", "Sul",
				"12232400");
		Endereco rua159 = new Endereco(null, "Rua Lamartine Maia da Silva Torres", " 177", "Bosque dos Eucaliptos",
				"Sul");
		Endereco rua160 = new Endereco(null, "Avenida Andrômeda", "Bosque dos Eucaliptos", "Sul", "12233000");
		Endereco rua161 = new Endereco(null, "Avenida Andrômeda", "Bosque dos Eucaliptos", "Sul", "12233001");
		Endereco rua162 = new Endereco(null, "Avenida Cidade Jardim", "Bosque dos Eucaliptos", "Sul", "12233002");
		Endereco rua163 = new Endereco(null, "Praça das Bandeiras", "Bosque dos Eucaliptos", "Sul", "12233003");
		Endereco rua164 = new Endereco(null, "Rua Alberto Alves Aguiar", "Bosque dos Eucaliptos", "Sul", "12233010");
		Endereco rua165 = new Endereco(null, "Rua Frederico Fiebig", "Bosque dos Eucaliptos", "Sul", "12233020");
		Endereco rua166 = new Endereco(null, "Rua Benedito Marcondes dos Santos", "Bosque dos Eucaliptos", "Sul",
				"12233030");
		Endereco rua167 = new Endereco(null, "Rua Antônio Campos Mello", "Bosque dos Eucaliptos", "Sul", "12233040");
		Endereco rua168 = new Endereco(null, "Rua Adhemar Prisco da Cunha", "Bosque dos Eucaliptos", "Sul", "12233050");
		Endereco rua169 = new Endereco(null, "Rua Eddie Maia Ramos", "Bosque dos Eucaliptos", "Sul", "12233060");
		Endereco rua170 = new Endereco(null, "Rua Orlando Marciano Leite", "Bosque dos Eucaliptos", "Sul", "12233080");
		Endereco rua171 = new Endereco(null, "Rua José Otávio Franco Bittencourt", "Bosque dos Eucaliptos", "Sul",
				"12233090");
		Endereco rua172 = new Endereco(null, "Rua Newton Vieira Novaes", "Bosque dos Eucaliptos", "Sul", "12233100");
		Endereco rua173 = new Endereco(null, "Rua Manoel Freire de Castro", "Bosque dos Eucaliptos", "Sul", "12233110");
		Endereco rua174 = new Endereco(null, "Rua Ignácio Trunkel", "Bosque dos Eucaliptos", "Sul", "12233120");
		Endereco rua175 = new Endereco(null, "Rua Benedito Pereira", "Bosque dos Eucaliptos", "Sul", "12233130");
		Endereco rua176 = new Endereco(null, "Rua Major Arnaldo Visoto", "Bosque dos Eucaliptos", "Sul", "12233140");
		Endereco rua177 = new Endereco(null, "Rua José Baruel da Rosa", "Bosque dos Eucaliptos", "Sul", "12233150");
		Endereco rua178 = new Endereco(null, "Rua Teodomiro Dias Pereira", "Bosque dos Eucaliptos", "Sul", "12233151");
		Endereco rua179 = new Endereco(null, "Rua José Bento de Moura", "Bosque dos Eucaliptos", "Sul", "12233160");
		Endereco rua180 = new Endereco(null, "Área Verde José Sanches Rodrigues", "Bosque dos Eucaliptos", "Sul",
				"12233161");
		Endereco rua181 = new Endereco(null, "Rua Sebastiana Monteiro", "Bosque dos Eucaliptos", "Sul", "12233170");
		Endereco rua182 = new Endereco(null, "Rua Bertolino Cezário dos Santos", "Bosque dos Eucaliptos", "Sul",
				"12233180");
		Endereco rua183 = new Endereco(null, "Rua São João Del Rei", "Bosque dos Eucaliptos", "Sul", "12233190");
		Endereco rua184 = new Endereco(null, "Rua Divinópolis", "Bosque dos Eucaliptos", "Sul", "12233200");
		Endereco rua185 = new Endereco(null, "Rua Centralina", "Bosque dos Eucaliptos", "Sul", "12233210");
		Endereco rua186 = new Endereco(null, "Rua Mariana", "Bosque dos Eucaliptos", "Sul", "12233220");
		Endereco rua187 = new Endereco(null, "Rua Lima Duarte", "Bosque dos Eucaliptos", "Sul", "12233230");
		Endereco rua188 = new Endereco(null, "Rua Corinto", "Bosque dos Eucaliptos", "Sul", "12233240");
		Endereco rua189 = new Endereco(null, "Rua Galiléia", "Bosque dos Eucaliptos", "Sul", "12233250");
		Endereco rua190 = new Endereco(null, "Rua Janauba", "Bosque dos Eucaliptos", "Sul", "12233270");
		Endereco rua191 = new Endereco(null, "Rua Planura", "Bosque dos Eucaliptos", "Sul", "12233280");
		Endereco rua192 = new Endereco(null, "Rua Viçosa", "Bosque dos Eucaliptos", "Sul", "12233290");
		Endereco rua193 = new Endereco(null, "Rua Espinosa", "Bosque dos Eucaliptos", "Sul", "12233300");
		Endereco rua194 = new Endereco(null, "Rua Itapecerica", "Bosque dos Eucaliptos", "Sul", "12233310");
		Endereco rua195 = new Endereco(null, "Rua Timóteo", "Bosque dos Eucaliptos", "Sul", "12233320");
		Endereco rua196 = new Endereco(null, "Rua Pedra Azul", "Bosque dos Eucaliptos", "Sul", "12233330");
		Endereco rua197 = new Endereco(null, "Rua Pouso Alegre", "Bosque dos Eucaliptos", "Sul", "12233340");
		Endereco rua198 = new Endereco(null, "Rua Lagoa da Prata", "Bosque dos Eucaliptos", "Sul", "12233350");
		Endereco rua199 = new Endereco(null, "Rua Frutal", "Bosque dos Eucaliptos", "Sul", "12233360");
		Endereco rua200 = new Endereco(null, "Rua Ipatinga", "Bosque dos Eucaliptos", "Sul", "12233370");
		Endereco rua201 = new Endereco(null, "Rua Aracuai", "Bosque dos Eucaliptos", "Sul", "12233380");
		Endereco rua202 = new Endereco(null, "Rua Lazara Augusta Silva Lisboa", "Bosque dos Eucaliptos", "Sul",
				"12233390");
		Endereco rua203 = new Endereco(null, "Avenida Ouro Fino", "Bosque dos Eucaliptos", "Sul", "12233400");
		Endereco rua204 = new Endereco(null, "Avenida Ouro Fino", "Bosque dos Eucaliptos", "Sul", "12233401");
		Endereco rua205 = new Endereco(null, "Rua Pedro Martins Ribeiro", "Bosque dos Eucaliptos", "Sul", "12233410");
		Endereco rua206 = new Endereco(null, "Rua Tatui", "Bosque dos Eucaliptos", "Sul", "12233420");
		Endereco rua207 = new Endereco(null, "Rua Vinhedo", "Bosque dos Eucaliptos", "Sul", "12233430");
		Endereco rua208 = new Endereco(null, "Rua Pompéia", "Bosque dos Eucaliptos", "Sul", "12233440");
		Endereco rua209 = new Endereco(null, "Rua Arujá", "Bosque dos Eucaliptos", "Sul", "12233450");
		Endereco rua210 = new Endereco(null, "Rua Cruzeiro", "Bosque dos Eucaliptos", "Sul", "12233460");
		Endereco rua211 = new Endereco(null, "Rua Bananal", "Bosque dos Eucaliptos", "Sul", "12233461");
		Endereco rua212 = new Endereco(null, "Rua Cananéia", "Bosque dos Eucaliptos", "Sul", "12233470");
		Endereco rua213 = new Endereco(null, "Rua Mirassol", "Bosque dos Eucaliptos", "Sul", "12233480");
		Endereco rua214 = new Endereco(null, "Rua Votuporanga", "Bosque dos Eucaliptos", "Sul", "12233490");
		Endereco rua215 = new Endereco(null, "Rua Ibiuna", "Bosque dos Eucaliptos", "Sul", "12233500");
		Endereco rua216 = new Endereco(null, "Rua Ministro José Geraldo Rodrigues Alkmin", "Bosque dos Eucaliptos",
				"Sul", "12233510");
		Endereco rua217 = new Endereco(null, "Rua Franca", "Bosque dos Eucaliptos", "Sul", "12233520");
		Endereco rua218 = new Endereco(null, "Rua Jacinto Gallo", "Bosque dos Eucaliptos", "Sul", "12233521");
		Endereco rua219 = new Endereco(null, "Rua Itanhomi", "Bosque dos Eucaliptos", "Sul", "12233530");
		Endereco rua220 = new Endereco(null, "Rua Teófilo Otoni", "Bosque dos Eucaliptos", "Sul", "12233540");
		Endereco rua221 = new Endereco(null, "Rua Nanuque", "Bosque dos Eucaliptos", "Sul", "12233550");
		Endereco rua222 = new Endereco(null, "Rua Conselheiro Lafaiete", "Bosque dos Eucaliptos", "Sul", "12233560");
		Endereco rua223 = new Endereco(null, "Rua Campos Altos", "Bosque dos Eucaliptos", "Sul", "12233570");
		Endereco rua224 = new Endereco(null, "Rua Ponte Nova", "Bosque dos Eucaliptos", "Sul", "12233580");
		Endereco rua225 = new Endereco(null, "Avenida Salinas", "Bosque dos Eucaliptos", "Sul", "12233590");
		Endereco rua226 = new Endereco(null, "Rua Itapeva", "Bosque dos Eucaliptos", "Sul", "12233591");
		Endereco rua227 = new Endereco(null, "Rua Pará de Minas", "Bosque dos Eucaliptos", "Sul", "12233592");
		Endereco rua228 = new Endereco(null, "Avenida Salinas", "Bosque dos Eucaliptos", "Sul", "12233593");
		Endereco rua229 = new Endereco(null, "Rua Montena", "Bosque dos Eucaliptos", "Sul", "12233594");
		Endereco rua230 = new Endereco(null, "Rua Iturama", "Bosque dos Eucaliptos", "Sul", "12233595");
		Endereco rua231 = new Endereco(null, "Rua Campo Belo", "Bosque dos Eucaliptos", "Sul", "12233596");
		Endereco rua232 = new Endereco(null, "Rua Andrelândia", "Bosque dos Eucaliptos", "Sul", "12233597");
		Endereco rua233 = new Endereco(null, "Rua Água Boa", "Bosque dos Eucaliptos", "Sul", "12233598");
		Endereco rua234 = new Endereco(null, "Rua Wladimir Herzog", "Bosque dos Eucaliptos", "Sul", "12233610");
		Endereco rua235 = new Endereco(null, "Rua José Friggi", "Bosque dos Eucaliptos", "Sul", "12233620");
		Endereco rua236 = new Endereco(null, "Rua José Armando de Oliveira Gomes", "Bosque dos Eucaliptos", "Sul",
				"12233630");
		Endereco rua237 = new Endereco(null, "Rua Maria Palmira Ferreira Ivo", "Bosque dos Eucaliptos", "Sul",
				"12233640");
		Endereco rua238 = new Endereco(null, "Rua Lins", "Bosque dos Eucaliptos", "Sul", "12233650");
		Endereco rua239 = new Endereco(null, "Rua Garça", "Bosque dos Eucaliptos", "Sul", "12233660");
		Endereco rua240 = new Endereco(null, "Rua Promissão", "Bosque dos Eucaliptos", "Sul", "12233670");
		Endereco rua241 = new Endereco(null, "Rua Jales", "Bosque dos Eucaliptos", "Sul", "12233680");
		Endereco rua242 = new Endereco(null, "Rua Manoel Fiel Filho", "Bosque dos Eucaliptos", "Sul", "12233690");
		Endereco rua243 = new Endereco(null, "Rua São Gotardo", "Bosque dos Eucaliptos", "Sul", "12233700");
		Endereco rua244 = new Endereco(null, "Rua José Peneluppi", "Bosque dos Eucaliptos", "Sul", "12233710");
		Endereco rua245 = new Endereco(null, "Rua Dimas Ferreira Ivo", "Bosque dos Eucaliptos", "Sul", "12233720");
		Endereco rua246 = new Endereco(null, "Rua Araras", "Bosque dos Eucaliptos", "Sul", "12233730");
		Endereco rua247 = new Endereco(null, "Rua Batatais", "Bosque dos Eucaliptos", "Sul", "12233740");
		Endereco rua248 = new Endereco(null, "Rua Valinhos", "Bosque dos Eucaliptos", "Sul", "12233750");
		Endereco rua249 = new Endereco(null, "Rua Palmital", "Bosque dos Eucaliptos", "Sul", "12233760");
		Endereco rua250 = new Endereco(null, "Rua Sumaré", "Bosque dos Eucaliptos", "Sul", "12233770");
		Endereco rua251 = new Endereco(null, "Rua Piraju", "Bosque dos Eucaliptos", "Sul", "12233780");
		Endereco rua252 = new Endereco(null, "Rua Doutor Oscar Strauss", "Bosque dos Eucaliptos", "Sul", "12233790");
		Endereco rua253 = new Endereco(null, "Rua Américo de Souza", "Bosque dos Eucaliptos", "Sul", "12233800");
		Endereco rua254 = new Endereco(null, "Rua Joaquim Silvério Neto", "Bosque dos Eucaliptos", "Sul", "12233810");
		Endereco rua255 = new Endereco(null, "Rua Salim Simão", "Bosque dos Eucaliptos", "Sul", "12233820");
		Endereco rua256 = new Endereco(null, "Rua José Eduardo Pivatto", "Bosque dos Eucaliptos", "Sul", "12233830");
		Endereco rua257 = new Endereco(null, "Rua Alberto da Silva Ramos", "Bosque dos Eucaliptos", "Sul", "12233840");
		Endereco rua258 = new Endereco(null, "Rua Avelino Pereira Lima", "Bosque dos Eucaliptos", "Sul", "12233841");
		Endereco rua259 = new Endereco(null, "Rua Canavieiras", "Bosque dos Eucaliptos", "Sul", "12233842");
		Endereco rua260 = new Endereco(null, "Rua Joaquim F. Silva", "Bosque dos Eucaliptos", "Sul", "12233843");
		Endereco rua261 = new Endereco(null, "Rua Roberto Alves de Aguiar", "Bosque dos Eucaliptos", "Sul", "12233844");
		Endereco rua262 = new Endereco(null, "Rua Rosario Tericugue Aquira", "Bosque dos Eucaliptos", "Sul",
				"12233845");
		Endereco rua263 = new Endereco(null, "Avenida Cidade Jardim", " 3141", "Bosque dos Eucaliptos", "Sul");
		Endereco rua264 = new Endereco(null, "Rua João Adão", "Residencial Bosque dos Ipês", "Sul", "12236811");
		Endereco rua265 = new Endereco(null, "Rua Nelson Favaro", "Residencial Bosque dos Ipês", "Sul", "12236863");
		Endereco rua266 = new Endereco(null, "Rua Luiz Roberto Garcia Tavares", "Residencial Bosque dos Ipês", "Sul",
				"12236868");
		Endereco rua267 = new Endereco(null, "Rua Ione Mitico Hayashi", "Residencial Bosque dos Ipês", "Sul",
				"12236869");
		Endereco rua268 = new Endereco(null, "Avenida José Honorato Sobrinho", "Residencial Bosque dos Ipês", "Sul",
				"12236870");
		Endereco rua269 = new Endereco(null, "Avenida Mário Frigi", "Residencial Bosque dos Ipês", "Sul", "12236871");
		Endereco rua270 = new Endereco(null, "Rua Luiz Gustavo de Vasconcelos", "Residencial Bosque dos Ipês", "Sul",
				"12236872");
		Endereco rua271 = new Endereco(null, "Rua José Aparecido Lobo Colino", "Residencial Bosque dos Ipês", "Sul",
				"12236873");
		Endereco rua272 = new Endereco(null, "Rua José Antônio Monteiro Santos", "Residencial Bosque dos Ipês", "Sul",
				"12236874");
		Endereco rua273 = new Endereco(null, "Rua Londrina", "Residencial Bosque dos Ipês", "Sul", "12236875");
		Endereco rua274 = new Endereco(null, "Rua Santino Cosentino", "Residencial Bosque dos Ipês", "Sul", "12236876");
		Endereco rua275 = new Endereco(null, "Rua Manoel Terto de Amorim", "Residencial Bosque dos Ipês", "Sul",
				"12236877");
		Endereco rua276 = new Endereco(null, "Rua Ana Giselle Ramos Lima", "Residencial Bosque dos Ipês", "Sul",
				"12236878");
		Endereco rua277 = new Endereco(null, "Rua José Fidêncio dos Santos", "Residencial Bosque dos Ipês", "Sul",
				"12236879");
		Endereco rua278 = new Endereco(null, "Avenida Nelson Alves", "Residencial Bosque dos Ipês", "Sul", "12236880");
		Endereco rua279 = new Endereco(null, "Rua Rosa Claro Martins", "Residencial Bosque dos Ipês", "Sul",
				"12236881");
		Endereco rua280 = new Endereco(null, "Rua Divino Paulino da Cruz", "Residencial Bosque dos Ipês", "Sul",
				"12236882");
		Endereco rua281 = new Endereco(null, "Rua Luiz Eduardo Dias Grunewald", "Residencial Bosque dos Ipês", "Sul",
				"12236883");
		Endereco rua282 = new Endereco(null, "Rua José Yoshihiro Munetaka", "Residencial Bosque dos Ipês", "Sul",
				"12236884");
		Endereco rua283 = new Endereco(null, "Rua Antônio Custódio dos Santos", "Residencial Bosque dos Ipês", "Sul",
				"12236885");
		Endereco rua284 = new Endereco(null, "Rua Bertho Cortez", "Residencial Bosque dos Ipês", "Sul", "12236886");
		Endereco rua285 = new Endereco(null, "Rua Josefa Oliveira Santos", "Residencial Bosque dos Ipês", "Sul",
				"12236887");
		Endereco rua286 = new Endereco(null, "Rua Luiz Omar da Silva", "Residencial Bosque dos Ipês", "Sul",
				"12236888");
		Endereco rua287 = new Endereco(null, "Rua Benedita Rosa Jesus Santos", "Residencial Bosque dos Ipês", "Sul",
				"12236889");
		Endereco rua288 = new Endereco(null, "Avenida João Bráulio de Melo", "Residencial Bosque dos Ipês", "Sul",
				"12236890");
		Endereco rua289 = new Endereco(null, "Rua Aidê Josefa Andrade Diacov", "Residencial Bosque dos Ipês", "Sul",
				"12236891");
		Endereco rua290 = new Endereco(null, "Rua Nivaldo Veríssimo Santos", "Residencial Bosque dos Ipês", "Sul",
				"12236892");
		Endereco rua291 = new Endereco(null, "Rua Claudio Mitsuhiro Kano", "Residencial Bosque dos Ipês", "Sul",
				"12236893");
		Endereco rua292 = new Endereco(null, "Rua Pastor José Freire Maciel Parente", "Residencial Bosque dos Ipês",
				"Sul", "12236894");
		Endereco rua293 = new Endereco(null, "Rua Hugo José de Freitas", "Residencial Bosque dos Ipês", "Sul",
				"12236895");
		Endereco rua294 = new Endereco(null, "Rua Gabriel de Souza Nogueira", "Residencial Bosque dos Ipês", "Sul",
				"12236896");
		Endereco rua295 = new Endereco(null, "Rua Therezinha de Toledo", "Residencial Bosque dos Ipês", "Sul",
				"12236898");
		Endereco rua296 = new Endereco(null, "Rua Antônio Pereira Santos", "Residencial Bosque dos Ipês", "Sul",
				"12236899");
		Endereco rua297 = new Endereco(null, "Rua Visconde de Ouro Preto", "Condomínio Bosque Imperial", "Oeste",
				"12242040");
		Endereco rua298 = new Endereco(null, "Rua Imperatriz Tereza Cristina", "Condomínio Bosque Imperial", "Oeste",
				"12242041");
		Endereco rua299 = new Endereco(null, "Rua Barão de Cocais", "Condomínio Bosque Imperial", "Oeste", "12242042");
		Endereco rua300 = new Endereco(null, "Praça Marquês de Itu", "Condomínio Bosque Imperial", "Oeste", "12242043");
		Endereco rua301 = new Endereco(null, "Rua Barão de Jaceguai", "Condomínio Bosque Imperial", "Oeste",
				"12242044");
		Endereco rua302 = new Endereco(null, "Rua Tereza Cristina Liesack Cunha", "Buquirinha", "Norte", "12213730");
		Endereco rua303 = new Endereco(null, "Rua Osvanir Santos", "Buquirinha", "Norte", "12213731");
		Endereco rua304 = new Endereco(null, "Rua Irineu Paixão", "Buquirinha", "Norte", "12213732");
		Endereco rua305 = new Endereco(null, "Rua Maria Hilda de Faria", "Buquirinha", "Norte", "12213733");
		Endereco rua306 = new Endereco(null, "Rua Frei Galvão", "Buquirinha", "Norte", "12213734");
		Endereco rua307 = new Endereco(null, "Rua Caetano Alves Camargo", "Buquirinha", "Norte", "12213740");
		Endereco rua308 = new Endereco(null, "Rua José Mendonça da Costa", "Buquirinha", "Norte", "12213750");
		Endereco rua309 = new Endereco(null, "Rua Joaquim Monteiro", "Buquirinha", "Norte", "12213760");
		Endereco rua310 = new Endereco(null, "Rua Ismael de Oliveira Luiz", "Buquirinha", "Norte", "12213770");
		Endereco rua311 = new Endereco(null, "Rua Francisco Fernandes Gomes", "Buquirinha", "Norte", "12213780");
		Endereco rua312 = new Endereco(null, "Rua Benedito de Oliveira e Silva", "Buquirinha", "Norte", "12213790");
		Endereco rua313 = new Endereco(null, "Rua Antônio de Oliveira Pinto", "Buquirinha", "Norte", "12213800");
		Endereco rua314 = new Endereco(null, "Condomínio Chácaras Recanto dos Sonhos", "Buquirinha", "Norte",
				"12213801");
		Endereco rua315 = new Endereco(null, "Rua Ana Angélica de Oliveira", "Buquirinha", "Norte", "12213810");
		Endereco rua316 = new Endereco(null, "Rua Ubiratan de Oliveira Pinto", "Buquirinha", "Norte", "12213820");
		Endereco rua317 = new Endereco(null, "Rua Rufina Oliveira Arantes", "Buquirinha", "Norte", "12213821");
		Endereco rua318 = new Endereco(null, "Rua Buquira", "Buquirinha", "Norte", "12213822");
		Endereco rua319 = new Endereco(null, "Rua Dois", "Buquirinha", "Norte", "12213823");
		Endereco rua320 = new Endereco(null, "Estrada Heitor Vieira", "Buquirinha", "Norte", "12213830");
		Endereco rua321 = new Endereco(null, "Rua Antônio O. Pinto", "Buquirinha", "Norte", "12213831");
		Endereco rua322 = new Endereco(null, "Avenida Um", "Buquirinha", "Norte", "12213832");
		Endereco rua323 = new Endereco(null, "Rodovia Monteiro Lobato", "Buquirinha", "Norte", "12213840");
		Endereco rua324 = new Endereco(null, "Rua A", "Buquirinha", "Norte", "12213841");
		Endereco rua325 = new Endereco(null, "Estrada Anor Rodrigues Ramalho", "Buquirinha", "Norte", "12213843");
		Endereco rua326 = new Endereco(null, "Rua Cinco", "Mirante do Buquirinha", "Norte", "12214513");
		Endereco rua327 = new Endereco(null, "Rua Um", "Mirante do Buquirinha", "Norte", "12214520");
		Endereco rua328 = new Endereco(null, "Avenida Um", "Mirante do Buquirinha", "Norte", "12214523");
		Endereco rua329 = new Endereco(null, "Rua Dois", "Mirante do Buquirinha", "Norte", "12214526");
		Endereco rua330 = new Endereco(null, "Rua Três", "Mirante do Buquirinha", "Norte", "12214529");
		Endereco rua331 = new Endereco(null, "Rua Quatro", "Mirante do Buquirinha", "Norte", "12214532");
		Endereco rua332 = new Endereco(null, "Rua Seis", "Mirante do Buquirinha", "Norte", "12214535");
		Endereco rua333 = new Endereco(null, "Rua Sete", "Mirante do Buquirinha", "Norte", "12214538");
		Endereco rua334 = new Endereco(null, "Rua Oito", "Mirante do Buquirinha", "Norte", "12214541");
		Endereco rua335 = new Endereco(null, "Travessa Pedro José Dias", "Mirante do Buquirinha", "Norte", "12214544");
		Endereco rua336 = new Endereco(null, "Travessa Pica Pau Amarelo", "Mirante do Buquirinha", "Norte", "12214547");
		Endereco rua337 = new Endereco(null, "Estrada do Florindo", "Buquirinha II", "Norte", "12214560");
		Endereco rua338 = new Endereco(null, "Rua Paturi", "Buquirinha II", "Norte", "12214563");
		Endereco rua339 = new Endereco(null, "Rua Santo Ângelo", "Buquirinha II", "Norte", "12214564");
		Endereco rua340 = new Endereco(null, "Avenida Ubiratan Mendes", "Buquirinha II", "Norte", "12214566");
		Endereco rua341 = new Endereco(null, "Travessa Olívia Cesária S. Silva", "Buquirinha II", "Norte", "12214569");
		Endereco rua342 = new Endereco(null, "Travessa Um", "Buquirinha II", "Norte", "12214572");
		Endereco rua343 = new Endereco(null, "Travessa Três", "Buquirinha II", "Norte", "12214575");
		Endereco rua344 = new Endereco(null, "Travessa do Matão", "Buquirinha II", "Norte", "12214578");
		Endereco rua345 = new Endereco(null, "Travessa Chacramento", "Buquirinha II", "Norte", "12214581");
		Endereco rua346 = new Endereco(null, "Travessa Quatro", "Buquirinha II", "Norte", "12214584");
		Endereco rua347 = new Endereco(null, "Rua Luiz Geraldo", "Buquirinha II", "Norte", "12214587");
		Endereco rua348 = new Endereco(null, "Rua Guiomar Fonseca", "Buquirinha II", "Norte", "12214588");
		Endereco rua349 = new Endereco(null, "Rua Wilson Domingos Fonseca", "Buquirinha II", "Norte", "12214590");
		Endereco rua350 = new Endereco(null, "Rua Antonio Toledo Lima", "Buquirinha II", "Norte", "12214593");
		Endereco rua351 = new Endereco(null, "Rua Antônio de Assis Dias", "Buquirinha II", "Norte", "12214596");
		Endereco rua352 = new Endereco(null, "Rua Tereza Machado Lima", "Buquirinha II", "Norte", "12214599");
		Endereco rua353 = new Endereco(null, "Rua Carlos Bruno", "Buquirinha II", "Norte", "12214602");
		Endereco rua354 = new Endereco(null, "Rua Ribeirão Caeté", "Altos da Vila Paiva", "Norte", "12213114");
		Endereco rua355 = new Endereco(null, "Avenida José Amauri Delfino", "Altos do Caetê I", "Norte", "12213132");
		Endereco rua356 = new Endereco(null, "Rua dos Escoteiros", "Altos do Caetê I", "Norte", "12213133");
		Endereco rua357 = new Endereco(null, "Rua José Gonçalves Sobrinho", "Altos do Caetê I", "Norte", "12213134");
		Endereco rua358 = new Endereco(null, "Rua Maria da Silva Santos", "Altos do Caetê I", "Norte", "12213135");
		Endereco rua359 = new Endereco(null, "Estrada Elisa Delfim Moreira", "Altos do Caetê II", "Norte", "12213151");
		Endereco rua360 = new Endereco(null, "Rua Ângelo Galo", "Recanto Caeté", "Norte", "12213220");
		Endereco rua361 = new Endereco(null, "Rua João Teodoro de Souza", "Recanto Caeté", "Norte", "12213240");
		Endereco rua362 = new Endereco(null, "Rua Primavera", "Recanto Caeté", "Norte", "12213250");
		Endereco rua363 = new Endereco(null, "Rua Verão", "Recanto Caeté", "Norte", "12213260");
		Endereco rua364 = new Endereco(null, "Travessa Caeté", "Vila São Geraldo", "Norte", "12213312");
		Endereco rua365 = new Endereco(null, "Estrada do Bonsucesso", "Altos do Caete", "Norte", "12213992");
		Endereco rua366 = new Endereco(null, "Rua Caeté", "Jardim Satélite", "Norte", "12230494");
		Endereco rua367 = new Endereco(null, "Avenida dos Evangelicos", "Campo dos Alemães", "Sul", "12239060");
		Endereco rua368 = new Endereco(null, "Avenida João Guska", "Campo dos Alemães", "Sul", "12239061");
		Endereco rua369 = new Endereco(null, "Rua José Marcos da Costa", "Campo dos Alemães", "Sul", "12239062");
		Endereco rua370 = new Endereco(null, "Rua Ismael Alves Rodrigues", "Campo dos Alemães", "Sul", "12239063");
		Endereco rua371 = new Endereco(null, "Rua José Izaltino Silva", "Campo dos Alemães", "Sul", "12239064");
		Endereco rua372 = new Endereco(null, "Rua Professor Ramiro Pinto de Faria", "Campo dos Alemães", "Sul",
				"12239065");
		Endereco rua373 = new Endereco(null, "Rua Mamude Carneiro", "Campo dos Alemães", "Sul", "12239066");
		Endereco rua374 = new Endereco(null, "Rua Maria Helena Ferreira", "Campo dos Alemães", "Sul", "12239067");
		Endereco rua375 = new Endereco(null, "Rua João Nogueira Bustamante", "Campo dos Alemães", "Sul", "12239070");
		Endereco rua376 = new Endereco(null, "Rua José Anastácio de Souza", "Campo dos Alemães", "Sul", "12239080");
		Endereco rua377 = new Endereco(null, "Rua Maria de Lourdes Damasceno Peres", "Campo dos Alemães", "Sul",
				"12239090");
		Endereco rua378 = new Endereco(null, "Rua Aurora Guimarães Segolin", "Campo dos Alemães", "Sul", "12239100");
		Endereco rua379 = new Endereco(null, "Rua Benedito Ernane do Prado", "Campo dos Alemães", "Sul", "12239110");
		Endereco rua380 = new Endereco(null, "Rua Claudinei Duarte Pereira", "Campo dos Alemães", "Sul", "12239120");
		Endereco rua381 = new Endereco(null, "Rua Oliveira Antunes Alvarenga", "Campo dos Alemães", "Sul", "12239130");
		Endereco rua382 = new Endereco(null, "Rua Edson Prince Soares", "Campo dos Alemães", "Sul", "12239140");
		Endereco rua383 = new Endereco(null, "Rua Maria das Dores Silva Cerqueira", "Campo dos Alemães", "Sul",
				"12239141");
		Endereco rua384 = new Endereco(null, "Estrada do Imperador", "Campo dos Alemães", "Sul", "12239148");
		Endereco rua385 = new Endereco(null, "Rua Arlinda Pereira Dias", "Campo dos Alemães", "Sul", "12239150");
		Endereco rua386 = new Endereco(null, "Rua Andréa Fabiano de Carvalho", "Campo dos Alemães", "Sul", "12239160");
		Endereco rua387 = new Endereco(null, "Rua Nelson José de Carvalho Ferreira", "Campo dos Alemães", "Sul",
				"12239170");
		Endereco rua388 = new Endereco(null, "Rua Geraldo Moreira", "Campo dos Alemães", "Sul", "12239180");
		Endereco rua389 = new Endereco(null, "Rua Alcidia Dias Pedrosa", "Campo dos Alemães", "Sul", "12239190");
		Endereco rua390 = new Endereco(null, "Rua Christiano Pugliesi", "Campo dos Alemães", "Sul", "12239200");
		Endereco rua391 = new Endereco(null, "Rua João Carlos Pinto da Cunha", "Campo dos Alemães", "Sul", "12239210");
		Endereco rua392 = new Endereco(null, "Rua Elis Regina", "Campo dos Alemães", "Sul", "12239220");
		Endereco rua393 = new Endereco(null, "Rua César Luiz da Silva Generoso", "Campo dos Alemães", "Sul",
				"12239230");
		Endereco rua394 = new Endereco(null, "Rua Regina Alves dos Santos", "Campo dos Alemães", "Sul", "12239240");
		Endereco rua395 = new Endereco(null, "Rua Artur Pereira Dias", "Campo dos Alemães", "Sul", "12239250");
		Endereco rua396 = new Endereco(null, "Rua Abrahão Coelho Cruz", "Campo dos Alemães", "Sul", "12239270");
		Endereco rua397 = new Endereco(null, "Rua Valter Dellu", "Campo dos Alemães", "Sul", "12239280");
		Endereco rua398 = new Endereco(null, "Avenida João de Oliveira e Silva", "Campo dos Alemães", "Sul",
				"12239290");
		Endereco rua399 = new Endereco(null, "Rua João Abreu Ramos", "Campo dos Alemães", "Sul", "12239300");
		Endereco rua400 = new Endereco(null, "Rua João Batista do Nascimento", "Campo dos Alemães", "Sul", "12239310");
		Endereco rua401 = new Endereco(null, "Rua Carlos de Alvarenga", "Campo dos Alemães", "Sul", "12239320");
		Endereco rua402 = new Endereco(null, "Rua Wagner Porcini", "Campo dos Alemães", "Sul", "12239330");
		Endereco rua403 = new Endereco(null, "Rua Alencar dos Santos", "Campo dos Alemães", "Sul", "12239340");
		Endereco rua404 = new Endereco(null, "Rua Manoel Corrêa de Oliveira", "Campo dos Alemães", "Sul", "12239350");
		Endereco rua405 = new Endereco(null, "Rua Sérgio Silva dos Santos", "Campo dos Alemães", "Sul", "12239360");
		Endereco rua406 = new Endereco(null, "Rua Lourdes Maria de Oliveira", "Campo dos Alemães", "Sul", "12239370");
		Endereco rua407 = new Endereco(null, "Rua Marcelo Cunha Frahya", "Campo dos Alemães", "Sul", "12239380");
		Endereco rua408 = new Endereco(null, "Rua Mário Antonio Abrantes da Fonseca", "Campo dos Alemães", "Sul",
				"12239390");
		Endereco rua409 = new Endereco(null, "Avenida Padre Wilson Cunha", "Campo dos Alemães", "Sul", "12239400");
		Endereco rua410 = new Endereco(null, "Rua Malvina Barbosa de Araújo", "Campo dos Alemães", "Sul", "12239401");
		Endereco rua411 = new Endereco(null, "Rua Carlos Drumond de Andrade", "Campo dos Alemães", "Sul", "12239410");
		Endereco rua412 = new Endereco(null, "Rua Frida Christine de Almeida Souza", "Campo dos Alemães", "Sul",
				"12239411");
		Endereco rua413 = new Endereco(null, "Rua Maria Martins Ottoboni", "Campo dos Alemães", "Sul", "12239420");
		Endereco rua414 = new Endereco(null, "Rua Waldemar Pinto da Cunha", "Campo dos Alemães", "Sul", "12239430");
		Endereco rua415 = new Endereco(null, "Rua Benedicta Turco", "Campo dos Alemães", "Sul", "12239440");
		Endereco rua416 = new Endereco(null, "Rua Simião Ferreira da Mata", "Campo dos Alemães", "Sul", "12239450");
		Endereco rua417 = new Endereco(null, "Rua Maria Sabino Angelo", "Campo dos Alemães", "Sul", "12239451");
		Endereco rua418 = new Endereco(null, "Rua Elpídio dos Santos", "Campo dos Alemães", "Sul", "12239460");
		Endereco rua419 = new Endereco(null, "Rua Maria Roseclair de Oliveira", "Campo dos Alemães", "Sul", "12239470");
		Endereco rua420 = new Endereco(null, "Rua Ana Maria Dias", "Campo dos Alemães", "Sul", "12239480");
		Endereco rua421 = new Endereco(null, "Rua João Alves Ferro", "Campo dos Alemães", "Sul", "12239490");
		Endereco rua422 = new Endereco(null, "Rua Luciane Almeida Tonino", "Campo dos Alemães", "Sul", "12239500");
		Endereco rua423 = new Endereco(null, "Rua Antônio Rodrigues de Araújo", "Campo dos Alemães", "Sul", "12239510");
		Endereco rua424 = new Endereco(null, "Rua Reverendo José Pereira Costa", "Campo dos Alemães", "Sul",
				"12239520");
		Endereco rua425 = new Endereco(null, "Rua Acássia Pereira", "Campo dos Alemães", "Sul", "12239530");
		Endereco rua426 = new Endereco(null, "Rua Irmã Maria Ruth do Santíssimo Sacramento", "Campo dos Alemães", "Sul",
				"12239540");
		Endereco rua427 = new Endereco(null, "Rua Palmyra Rosa do Prado Estefano", "Campo dos Alemães", "Sul",
				"12239550");
		Endereco rua428 = new Endereco(null, "Rua Braz Nicola Rossi", "Campo dos Alemães", "Sul", "12239560");
		Endereco rua429 = new Endereco(null, "Avenida Adonias da Silva", "Campo dos Alemães", "Sul", "12239570");
		Endereco rua430 = new Endereco(null, "Avenida Maria de Lourdes Medeiros de Assis", "Campo dos Alemães", "Sul",
				"12239580");
		Endereco rua431 = new Endereco(null, "Rua Vicente Nunes de Assis", "Campo dos Alemães", "Sul", "12239590");
		Endereco rua432 = new Endereco(null, "Rua Anibal Gallo Delella", "Campo dos Alemães", "Sul", "12239600");
		Endereco rua433 = new Endereco(null, "Rua José Clemente da Silva", "Campo dos Alemães", "Sul", "12239610");
		Endereco rua434 = new Endereco(null, "Rua Paloma Cintia Santos Oliveira", "Campo dos Alemães", "Sul",
				"12239620");
		Endereco rua435 = new Endereco(null, "Rua Pastor José Medeiros de Oliveira", "Campo dos Alemães", "Sul",
				"12239630");
		Endereco rua436 = new Endereco(null, "Rua Honorato Macedo de Souza", "Campo dos Alemães", "Sul", "12239640");
		Endereco rua437 = new Endereco(null, "Rua José Benedicto Orestes", "Campo dos Alemães", "Sul", "12239650");
		Endereco rua438 = new Endereco(null, "Rua Leonor de Campos Pereira", "Campo dos Alemães", "Sul", "12239651");
		Endereco rua439 = new Endereco(null, "Rua José Domingos Pereira", "Campo dos Alemães", "Sul", "12239660");
		Endereco rua440 = new Endereco(null, "Rua José Rodrigues Salgado", "Campo dos Alemães", "Sul", "12239670");
		Endereco rua441 = new Endereco(null, "Rua Pastor Jaime Wright", "Campo dos Alemães", "Sul", "12239680");
		Endereco rua442 = new Endereco(null, "Rua José Garcia da Silva", "Campo dos Alemães", "Sul", "12239690");
		Endereco rua443 = new Endereco(null, "Rua Geraldo Queiroz", "Campo dos Alemães", "Sul", "12239700");
		Endereco rua444 = new Endereco(null, "Rua Salvatino Eufrasio Machado", "Campo dos Alemães", "Sul", "12239710");
		Endereco rua445 = new Endereco(null, "Rua Sirlei da Conceição Gomes Alves", "Campo dos Alemães", "Sul",
				"12239720");
		Endereco rua446 = new Endereco(null, "Rua Andreza Batista dos Santos", "Campo dos Alemães", "Sul", "12239731");
		Endereco rua447 = new Endereco(null, "Rua José Luiz de Siqueira", "Campo dos Alemães", "Sul", "12239732");
		Endereco rua448 = new Endereco(null, "Rua Albertina Pereira Lima", "Campo dos Alemães", "Sul", "12239740");
		Endereco rua449 = new Endereco(null, "Rua José Ferreira Ivo", "Campo dos Alemães", "Sul", "12239750");
		Endereco rua450 = new Endereco(null, "Rua Walter Bastos", "Campo dos Alemães", "Sul", "12239760");
		Endereco rua451 = new Endereco(null, "Rua Lúcio Alves", "Campo dos Alemães", "Sul", "12239770");
		Endereco rua452 = new Endereco(null, "Rua Rubens de Melo Gaia", "Campo dos Alemães", "Sul", "12239780");
		Endereco rua453 = new Endereco(null, "Rua Cabo Geraldo Ribeiro da Silva", "Campo dos Alemães", "Sul",
				"12239790");
		Endereco rua454 = new Endereco(null, "Rua Adelgido Justiniano de Paula", "Campo dos Alemães", "Sul",
				"12239800");
		Endereco rua455 = new Endereco(null, "Rua José Benedito Dias", "Campo dos Alemães", "Sul", "12239810");
		Endereco rua456 = new Endereco(null, "Rua Benedita Henrique", "Campo dos Alemães", "Sul", "12239820");
		Endereco rua457 = new Endereco(null, "Rua Paula Correia de Faria", "Campo dos Alemães", "Sul", "12239825");
		Endereco rua458 = new Endereco(null, "Rua Pedro José dos Santos", "Campo dos Alemães", "Sul", "12239830");
		Endereco rua459 = new Endereco(null, "Rua José Carlos de Macedo", "Campo dos Alemães", "Sul", "12239831");
		Endereco rua460 = new Endereco(null, "Rua Valentina Oliveira Santos", "Campo dos Alemães", "Sul", "12239832");
		Endereco rua461 = new Endereco(null, "Rua José Carmo dos Anjos", "Campos de São José", "Leste", "12226310");
		Endereco rua462 = new Endereco(null, "Rua Roberto Wagner dos Anjos Conrado", "Campos de São José", "Leste",
				"12226320");
		Endereco rua463 = new Endereco(null, "Rua Orlandino de Freitas", "Campos de São José", "Leste", "12226330");
		Endereco rua464 = new Endereco(null, "Rua Gyulo Bakos", "Campos de São José", "Leste", "12226340");
		Endereco rua465 = new Endereco(null, "Rua Maria Lancini", "Campos de São José", "Leste", "12226350");
		Endereco rua466 = new Endereco(null, "Rua Lecticia de Moraes Vieira", "Campos de São José", "Leste",
				"12226360");
		Endereco rua467 = new Endereco(null, "Rua Terceiro-Sargento-Polícia Militar Alexandre de Souza Roberto",
				"Campos de São José", "Leste", "12226370");
		Endereco rua468 = new Endereco(null, "Rua Mirabeau Antonio Pini", "Campos de São José", "Leste", "12226380");
		Endereco rua469 = new Endereco(null, "Rua Dalila Marques Miguez", "Campos de São José", "Leste", "12226390");
		Endereco rua470 = new Endereco(null, "Rua Domingos Santos Pinto Filho", "Campos de São José", "Leste",
				"12226400");
		Endereco rua471 = new Endereco(null, "Rua Ero Silverman Guarrido", "Campos de São José", "Leste", "12226401");
		Endereco rua472 = new Endereco(null, "Rua Médico Ruston", "Campos de São José", "Leste", "12226402");
		Endereco rua473 = new Endereco(null, "Rua Acedro Ruston", "Campos de São José", "Leste", "12226410");
		Endereco rua474 = new Endereco(null, "Rua Benedita Friggi de Toledo", "Campos de São José", "Leste",
				"12226420");
		Endereco rua475 = new Endereco(null, "Rua Carlos Pinheiro Vasquez Pato", "Campos de São José", "Leste",
				"12226430");
		Endereco rua476 = new Endereco(null, "Rua Quinze", "Campos de São José", "Leste", "12226440");
		Endereco rua477 = new Endereco(null, "Rua Palmira Colla Rosa", "Campos de São José", "Leste", "12226450");
		Endereco rua478 = new Endereco(null, "Rua Antônio Aurélio Monteiro de Barros", "Campos de São José", "Leste",
				"12226460");
		Endereco rua479 = new Endereco(null, "Rua Jerônimo Mendonça Ribeiro", "Campos de São José", "Leste",
				"12226470");
		Endereco rua480 = new Endereco(null, "Rua Manoel Ângelo de Andrade", "Campos de São José", "Leste", "12226480");
		Endereco rua481 = new Endereco(null, "Rua Antônio Bernardo Hemkemeir", "Campos de São José", "Leste",
				"12226490");
		Endereco rua482 = new Endereco(null, "Rua Nicolau Galardo", "Campos de São José", "Leste", "12226500");
		Endereco rua483 = new Endereco(null, "Rua Benedicto Antonio de Araújo", "Campos de São José", "Leste",
				"12226510");
		Endereco rua484 = new Endereco(null, "Rua Pastor José Ferreira Rito", "Campos de São José", "Leste",
				"12226520");
		Endereco rua485 = new Endereco(null, "Rua Irmã Emerência Balestieri", "Campos de São José", "Leste",
				"12226530");
		Endereco rua486 = new Endereco(null, "Rua Judith Nunes dos Santos", "Campos de São José", "Leste", "12226540");
		Endereco rua487 = new Endereco(null, "Rua Benedito de Paula Ferreira", "Campos de São José", "Leste",
				"12226550");
		Endereco rua488 = new Endereco(null, "Estrada Dom José Antonio do Couto", "Campos de São José", "Leste",
				"12226551");
		Endereco rua489 = new Endereco(null, "Avenida Eduardo Lourenço", "Campos de São José", "Leste", "12226552");
		Endereco rua490 = new Endereco(null, "Avenida Dantas Luiz do Prado", "Campos de São José", "Leste", "12226553");
		Endereco rua491 = new Endereco(null, "Rua Maria Alves Bonfim", "Campos de São José", "Leste", "12226560");
		Endereco rua492 = new Endereco(null, "Rua Luci Perdigão", "Campos de São José", "Leste", "12226570");
		Endereco rua493 = new Endereco(null, "Rua Geraldo Ferreira Maldos", "Campos de São José", "Leste", "12226580");
		Endereco rua494 = new Endereco(null, "Rua Dejanira de Paula Freire", "Campos de São José", "Leste", "12226590");
		Endereco rua495 = new Endereco(null, "Praça Hélio Alves Garcia", "Campos de São José", "Leste", "12226592");
		Endereco rua496 = new Endereco(null, "Rua Diácono José Arantes", "Campos de São José", "Leste", "12226600");
		Endereco rua497 = new Endereco(null, "Rua Ernesto Lourenço", "Campos de São José", "Leste", "12226610");
		Endereco rua498 = new Endereco(null, "Rua Roberto Bianchi", "Campos de São José", "Leste", "12226620");
		Endereco rua499 = new Endereco(null, "Rua Shenna Azevedo Rodrigues", "Campos de São José", "Leste", "12226630");
		Endereco rua500 = new Endereco(null, "Rua José Sanador Ferreira", "Campos de São José", "Leste", "12226640");
		Endereco rua501 = new Endereco(null, "Rua Adelina Delgado Motta", "Campos de São José", "Leste", "12226650");
		Endereco rua502 = new Endereco(null, "Rua Álvaro Pinheiro Mendonça", "Campos de São José", "Leste", "12226660");
		Endereco rua503 = new Endereco(null, "Rua José Policarpo Sabioni", "Campos de São José", "Leste", "12226670");
		Endereco rua504 = new Endereco(null, "Rua Ramiro Augusto de Araújo", "Campos de São José", "Leste", "12226680");
		Endereco rua505 = new Endereco(null, "Rua Virgílio Fernandes de Oliveira", "Campos de São José", "Leste",
				"12226690");
		Endereco rua506 = new Endereco(null, "Rua Vicente Pereira", "Campos de São José", "Leste", "12226700");
		Endereco rua507 = new Endereco(null, "Avenida Antônio da Costa Nunes", "Campos de São José", "Leste",
				"12226705");
		Endereco rua508 = new Endereco(null, "Avenida Izabel Nunes dos Santos Guimarães", "Campos de São José", "Leste",
				"12226708");
		Endereco rua509 = new Endereco(null, "Rua Maria Auxiliadora Monção Antinópolis Bonafé", "Campos de São José",
				"Leste", "12226710");
		Endereco rua510 = new Endereco(null, "Rua Ana Paula Nunes Dutra", "Campos de São José", "Leste", "12226711");
		Endereco rua511 = new Endereco(null, "Rua Samara Regina Oliveira Pedreiro", "Campos de São José", "Leste",
				"12226712");
		Endereco rua512 = new Endereco(null, "Rua José Benedito dos Santos", "Campos de São José", "Leste", "12226713");
		Endereco rua513 = new Endereco(null, "Rua Vicente Donati Nunes", "Campos de São José", "Leste", "12226714");
		Endereco rua514 = new Endereco(null, "Rua Ângela Codello Bertti", "Campos de São José", "Leste", "12226715");
		Endereco rua515 = new Endereco(null, "Rua Hanna Youssef Chabchoul", "Campos de São José", "Leste", "12226716");
		Endereco rua516 = new Endereco(null, "Rua Antônio Sudário Ferreira", "Campos de São José", "Leste", "12226717");
		Endereco rua517 = new Endereco(null, "Rua Rosa Cândida Ferreira", "Campos de São José", "Leste", "12226718");
		Endereco rua518 = new Endereco(null, "Rua José Gonçalves de Oliveira", "Campos de São José", "Leste",
				"12226719");
		Endereco rua519 = new Endereco(null, "Rua Bernardino Lourenço", "Campos de São José", "Leste", "12226720");
		Endereco rua520 = new Endereco(null, "Rua Alcides Salgado", "Campos de São José", "Leste", "12226721");
		Endereco rua521 = new Endereco(null, "Estrada Natan Sampaio de Almeida", "Jardim Capitingal", "Sul",
				"12236840");
		Endereco rua522 = new Endereco(null, "Travessa Capitingal", "Residencial Gazzo", "Sul", "12236843");
		Endereco rua523 = new Endereco(null, "Rua José Luiz Cembranelli", "Chácara dos Eucalíptos", "Centro",
				"12221740");
		Endereco rua524 = new Endereco(null, "Rua Mário Campos", "Chácara dos Eucalíptos", "Centro", "12221750");
		Endereco rua525 = new Endereco(null, "Rua Viriato Jesus Arana", "Chácara dos Eucalíptos", "Centro", "12221760");
		Endereco rua526 = new Endereco(null, "Rua Dois", "Condomínio Chácara dos Eucaliptos", "Centro", "12244081");
		Endereco rua527 = new Endereco(null, "Rua Três", "Condomínio Chácara dos Eucaliptos", "Centro", "12244083");
		Endereco rua528 = new Endereco(null, "Rua Sebastião da Silva Fileno", "Condomínio Chácara dos Eucaliptos",
				"Centro", "12244085");
		Endereco rua529 = new Endereco(null, "Alameda Rio Negro", "Chácaras Reunidas", "Sul", "12238270");
		Endereco rua530 = new Endereco(null, "Alameda Rio Danúbio", "Chácaras Reunidas", "Sul", "12238280");
		Endereco rua531 = new Endereco(null, "Praça Brasiléia", "Chácaras Reunidas", "Sul", "12238290");
		Endereco rua532 = new Endereco(null, "Praça Cariri", "Chácaras Reunidas", "Sul", "12238300");
		Endereco rua533 = new Endereco(null, "Praça Belmont", "Chácaras Reunidas", "Sul", "12238310");
		Endereco rua534 = new Endereco(null, "Rua Moxoto", "Chácaras Reunidas", "Sul", "12238320");
		Endereco rua535 = new Endereco(null, "Rua Loanda", "Chácaras Reunidas", "Sul", "12238330");
		Endereco rua536 = new Endereco(null, "Rua Lagoa Santa", "Chácaras Reunidas", "Sul", "12238340");
		Endereco rua537 = new Endereco(null, "Rua Monte Azul", "Chácaras Reunidas", "Sul", "12238350");
		Endereco rua538 = new Endereco(null, "Rua Miracema", "Chácaras Reunidas", "Sul", "12238360");
		Endereco rua539 = new Endereco(null, "Avenida Doutor Sebastião Henrique da Cunha Pontes", "Chácaras Reunidas",
				"Sul", "12238365");
		Endereco rua540 = new Endereco(null, "Rua Búzios", "Chácaras Reunidas", "Sul", "12238370");
		Endereco rua541 = new Endereco(null, "Rua Penha", "Chácaras Reunidas", "Sul", "12238380");
		Endereco rua542 = new Endereco(null, "Rua Astorga", "Chácaras Reunidas", "Sul", "12238400");
		Endereco rua543 = new Endereco(null, "Rua Jaguarão", "Chácaras Reunidas", "Sul", "12238410");
		Endereco rua544 = new Endereco(null, "Rua Mogiana", "Chácaras Reunidas", "Sul", "12238420");
		Endereco rua545 = new Endereco(null, "Avenida Central", "Chácaras Reunidas", "Sul", "12238430");
		Endereco rua546 = new Endereco(null, "Rua Concórdia", "Chácaras Reunidas", "Sul", "12238440");
		Endereco rua547 = new Endereco(null, "Rua Lucélia", "Chácaras Reunidas", "Sul", "12238450");
		Endereco rua548 = new Endereco(null, "Rua Guaianesia", "Chácaras Reunidas", "Sul", "12238460");
		Endereco rua549 = new Endereco(null, "Praça Rosa Maria Salvador de Oliveira", "Chácaras Reunidas", "Sul",
				"12238461");
		Endereco rua550 = new Endereco(null, "Rua Guarapiranga", "Chácaras Reunidas", "Sul", "12238470");
		Endereco rua551 = new Endereco(null, "Rua Guacui", "Chácaras Reunidas", "Sul", "12238480");
		Endereco rua552 = new Endereco(null, "Praça Colinas", "Chácaras Reunidas", "Sul", "12238481");
		Endereco rua553 = new Endereco(null, "Rua Januaria", "Chácaras Reunidas", "Sul", "12238500");
		Endereco rua554 = new Endereco(null, "Rua Maria Aparecida Cucchiaro", "Chácaras Reunidas", "Sul", "12238501");
		Endereco rua555 = new Endereco(null, "Rua Sete Lagos", "Chácaras Reunidas", "Sul", "12238510");
		Endereco rua556 = new Endereco(null, "Praça Boqueirão", "Chácaras Reunidas", "Sul", "12238520");
		Endereco rua557 = new Endereco(null, "Rua Joaçaba", "Chácaras Reunidas", "Sul", "12238530");
		Endereco rua558 = new Endereco(null, "Rua Viseu", "Chácaras Reunidas", "Sul", "12238550");
		Endereco rua559 = new Endereco(null, "Estrada Imperador", "Chácaras Reunidas", "Sul", "12238560");
		Endereco rua560 = new Endereco(null, "Rodovia Presidente Dutra", " 159", "Chácaras Reunidas", "Sul");
		Endereco rua561 = new Endereco(null, "Rua Loanda", " 895 Lojas 1 e 2", "Chácaras Reunidas", "Sul");
		Endereco rua562 = new Endereco(null, "Rua Poncas", "Chácaras São José", "Sudeste", "12227550");
		Endereco rua563 = new Endereco(null, "Rua Goiabeiras", "Chácaras São José", "Sudeste", "12227560");
		Endereco rua564 = new Endereco(null, "Avenida Livio Veneziani", "Chácaras São José", "Sudeste", "12227570");
		Endereco rua565 = new Endereco(null, "Rua Joana Soares Ferreira", "Cidade Morumbi", "Sul", "12236420");
		Endereco rua566 = new Endereco(null, "Rua Odete Garcia", "Cidade Morumbi", "Sul", "12236430");
		Endereco rua567 = new Endereco(null, "Avenida Arthur Antônio dos Santos", "Cidade Morumbi", "Sul", "12236440");
		Endereco rua568 = new Endereco(null, "Avenida Arthur Antônio dos Santos", "Cidade Morumbi", "Sul", "12236442");
		Endereco rua569 = new Endereco(null, "Rua Joaquim de Paula", "Cidade Morumbi", "Sul", "12236450");
		Endereco rua570 = new Endereco(null, "Rua Francisco Rodrigues Silva", "Cidade Morumbi", "Sul", "12236460");
		Endereco rua571 = new Endereco(null, "Rua Maria Augusta Pereira dos Santos", "Cidade Morumbi", "Sul",
				"12236470");
		Endereco rua572 = new Endereco(null, "Rua José Lenir Silvestre", "Cidade Morumbi", "Sul", "12236480");
		Endereco rua573 = new Endereco(null, "Rua José do Prado Júnior", "Cidade Morumbi", "Sul", "12236490");
		Endereco rua574 = new Endereco(null, "Rua Gisele Martins", "Cidade Morumbi", "Sul", "12236500");
		Endereco rua575 = new Endereco(null, "Rua Benedito Cubas", "Cidade Morumbi", "Sul", "12236510");
		Endereco rua576 = new Endereco(null, "Rua Luiz de Oliveira da Silva", "Cidade Morumbi", "Sul", "12236520");
		Endereco rua577 = new Endereco(null, "Rua Marcelo Carlos Pereira", "Cidade Morumbi", "Sul", "12236530");
		Endereco rua578 = new Endereco(null, "Rua Benedito Batista Campos", "Cidade Morumbi", "Sul", "12236540");
		Endereco rua579 = new Endereco(null, "Rua Manoel José Filho", "Cidade Morumbi", "Sul", "12236550");
		Endereco rua580 = new Endereco(null, "Rua Mário Pereira Benevides", "Cidade Morumbi", "Sul", "12236560");
		Endereco rua581 = new Endereco(null, "Avenida Eliane Maria Barbiere Soares", "Cidade Morumbi", "Sul",
				"12236570");
		Endereco rua582 = new Endereco(null, "Avenida Eliane Maria Barbiere Soares", "Cidade Morumbi", "Sul",
				"12236572");
		Endereco rua583 = new Endereco(null, "Avenida Benedito Bento", "Cidade Morumbi", "Sul", "12236580");
		Endereco rua584 = new Endereco(null, "Avenida Benedito Bento", "Cidade Morumbi", "Sul", "12236582");
		Endereco rua585 = new Endereco(null, "Rua Cecílio Celeste", "Cidade Morumbi", "Sul", "12236590");
		Endereco rua586 = new Endereco(null, "Rua José Brás da Silva", "Cidade Morumbi", "Sul", "12236600");
		Endereco rua587 = new Endereco(null, "Rua Maximino José de Almeida", "Cidade Morumbi", "Sul", "12236610");
		Endereco rua588 = new Endereco(null, "Rua Heitor Antunes Pereira", "Cidade Morumbi", "Sul", "12236620");
		Endereco rua589 = new Endereco(null, "Rua Vilma Fátima de Oliveira", "Cidade Morumbi", "Sul", "12236630");
		Endereco rua590 = new Endereco(null, "Rua Olímpio de Lima", "Cidade Morumbi", "Sul", "12236640");
		Endereco rua591 = new Endereco(null, "Rua José de Campos", "Cidade Morumbi", "Sul", "12236650");
		Endereco rua592 = new Endereco(null, "Avenida João Batista de Souza Soares", "Cidade Morumbi", "Sul",
				"12236660");
		Endereco rua593 = new Endereco(null, "Avenida João Batista de Souza Soares", "Cidade Morumbi", "Sul",
				"12236662");
		Endereco rua594 = new Endereco(null, "Rua Josefa Albuquerque dos Santos", "Cidade Morumbi", "Sul", "12236670");
		Endereco rua595 = new Endereco(null, "Rua Zélia Albuquerque dos Santos", "Cidade Morumbi", "Sul", "12236680");
		Endereco rua596 = new Endereco(null, "Rua Ari Pinto de Oliveira", "Cidade Morumbi", "Sul", "12236681");
		Endereco rua597 = new Endereco(null, "Rua José Nicodemo", "Cidade Morumbi", "Sul", "12236682");
		Endereco rua598 = new Endereco(null, "Rua José Antônio de Oliveira", "Cidade Morumbi", "Sul", "12236690");
		Endereco rua599 = new Endereco(null, "Avenida Benedito Domingues de Oliveira", "Cidade Morumbi", "Sul",
				"12236700");
		Endereco rua600 = new Endereco(null, "Avenida Benedito Domingues de Oliveira", "Cidade Morumbi", "Sul",
				"12236702");
		Endereco rua601 = new Endereco(null, "Rua José Hamilton da Silva", "Cidade Morumbi", "Sul", "12236710");
		Endereco rua602 = new Endereco(null, "Rua Adriano Espindola", "Cidade Morumbi", "Sul", "12236720");
		Endereco rua603 = new Endereco(null, "Rua Sebastiana Faria de Oliveira", "Cidade Morumbi", "Sul", "12236730");
		Endereco rua604 = new Endereco(null, "Avenida Elisio Galdino Sobrinho", "Cidade Morumbi", "Sul", "12236740");
		Endereco rua605 = new Endereco(null, "Avenida Elisio Galdino Sobrinho", "Cidade Morumbi", "Sul", "12236742");
		Endereco rua606 = new Endereco(null, "Rua Luiz Fernandes", "Cidade Morumbi", "Sul", "12236750");
		Endereco rua607 = new Endereco(null, "Rua Inocêncio Claudino Barbosa", "Cidade Morumbi", "Sul", "12236760");
		Endereco rua608 = new Endereco(null, "Rua Adelaide Oliveira Marcelino", "Cidade Morumbi", "Sul", "12236770");
		Endereco rua609 = new Endereco(null, "Avenida João Cândido Lopes Neto", "Cidade Morumbi", "Sul", "12236780");
		Endereco rua610 = new Endereco(null, "Avenida João Cândido Lopes Neto", "Cidade Morumbi", "Sul", "12236782");
		Endereco rua611 = new Endereco(null, "Rua Manuel Barbosa de Souza", "Cidade Morumbi", "Sul", "12236790");
		Endereco rua612 = new Endereco(null, "Rua São José Esporte Clube", "Cidade Morumbi", "Sul", "12236791");
		Endereco rua613 = new Endereco(null, "Rua Luiz Antônio de Castro", "Cidade Morumbi", "Sul", "12236800");
		Endereco rua614 = new Endereco(null, "Rua Maria Luciana de Jesus", "Cidade Morumbi", "Sul", "12236801");
		Endereco rua615 = new Endereco(null, "Rua Antônio Soares de Andrade", "Cidade Morumbi", "Sul", "12236810");
		Endereco rua616 = new Endereco(null, "Rua Anunciação Rodrigues", "Cidade Morumbi", "Sul", "12236820");
		Endereco rua617 = new Endereco(null, "Rua Anna Carolina Santos", "Cidade Morumbi", "Sul", "12236825");
		Endereco rua618 = new Endereco(null, "Rua Francisco de Assis Dias", "Cidade Morumbi", "Sul", "12236830");
		Endereco rua619 = new Endereco(null, "Rua Argentina", "Cidade Vista Verde", "Leste", "12223000");
		Endereco rua620 = new Endereco(null, "Rua Uruguai", "Cidade Vista Verde", "Leste", "12223010");
		Endereco rua621 = new Endereco(null, "Rua Jamaica", "Cidade Vista Verde", "Leste", "12223020");
		Endereco rua622 = new Endereco(null, "Rua Peru", "Cidade Vista Verde", "Leste", "12223030");
		Endereco rua623 = new Endereco(null, "Rua Paraguai", "Cidade Vista Verde", "Leste", "12223040");
		Endereco rua624 = new Endereco(null, "Praça Raimundo Nonanto Lisboa", "Cidade Vista Verde", "Leste",
				"12223045");
		Endereco rua625 = new Endereco(null, "Rua Panamá", "Cidade Vista Verde", "Leste", "12223050");
		Endereco rua626 = new Endereco(null, "Rua Chile", "Cidade Vista Verde", "Leste", "12223060");
		Endereco rua627 = new Endereco(null, "Praça Júlio Sea", "Cidade Vista Verde", "Leste", "12223065");
		Endereco rua628 = new Endereco(null, "Rua Bolívia", "Cidade Vista Verde", "Leste", "12223070");
		Endereco rua629 = new Endereco(null, "Rua Equador", "Cidade Vista Verde", "Leste", "12223080");
		Endereco rua630 = new Endereco(null, "Rua Colômbia", "Cidade Vista Verde", "Leste", "12223090");
		Endereco rua631 = new Endereco(null, "Avenida Cajuru", "Cidade Vista Verde", "Leste", "12223100");
		Endereco rua632 = new Endereco(null, "Via Nair de Souza Camargo Oliveira", "Cidade Vista Verde", "Leste",
				"12223105");
		Endereco rua633 = new Endereco(null, "Rua Venezuela", "Cidade Vista Verde", "Leste", "12223220");
		Endereco rua634 = new Endereco(null, "Rua Alasca", "Cidade Vista Verde", "Leste", "12223230");
		Endereco rua635 = new Endereco(null, "Rua Estados Unidos", "Cidade Vista Verde", "Leste", "12223240");
		Endereco rua636 = new Endereco(null, "Rua Canadá", "Cidade Vista Verde", "Leste", "12223250");
		Endereco rua637 = new Endereco(null, "Rua Honduras", "Cidade Vista Verde", "Leste", "12223260");
		Endereco rua638 = new Endereco(null, "Rua Costa Rica", "Cidade Vista Verde", "Leste", "12223270");
		Endereco rua639 = new Endereco(null, "Rua Nicarágua", "Cidade Vista Verde", "Leste", "12223280");
		Endereco rua640 = new Endereco(null, "Rua Martinica", "Cidade Vista Verde", "Leste", "12223290");
		Endereco rua641 = new Endereco(null, "Rua Guiana", "Cidade Vista Verde", "Leste", "12223300");
		Endereco rua642 = new Endereco(null, "Rua Haiti", "Cidade Vista Verde", "Leste", "12223310");
		Endereco rua643 = new Endereco(null, "Praça Nicolau Salomão de Camargo", "Cidade Vista Verde", "Leste",
				"12223315");
		Endereco rua644 = new Endereco(null, "Rua Guatemala", "Cidade Vista Verde", "Leste", "12223320");
		Endereco rua645 = new Endereco(null, "Rua Suriname", "Cidade Vista Verde", "Leste", "12223330");
		Endereco rua646 = new Endereco(null, "Rua Santa Fé", "Cidade Vista Verde", "Leste", "12223340");
		Endereco rua647 = new Endereco(null, "Rua Malvinas", "Cidade Vista Verde", "Leste", "12223350");
		Endereco rua648 = new Endereco(null, "Praça José Nissi", "Cidade Vista Verde", "Leste", "12223351");
		Endereco rua649 = new Endereco(null, "Rua Filipinas", "Cidade Vista Verde", "Leste", "12223360");
		Endereco rua650 = new Endereco(null, "Rua Belize", "Cidade Vista Verde", "Leste", "12223370");
		Endereco rua651 = new Endereco(null, "Rua Cuba", "Cidade Vista Verde", "Leste", "12223390");
		Endereco rua652 = new Endereco(null, "Rua Caraíbas", "Cidade Vista Verde", "Leste", "12223400");
		Endereco rua653 = new Endereco(null, "Rua México", "Cidade Vista Verde", "Leste", "12223410");
		Endereco rua654 = new Endereco(null, "Rua Trinidad", "Cidade Vista Verde", "Leste", "12223420");
		Endereco rua655 = new Endereco(null, "Avenida Pedro Friggi", "Cidade Vista Verde", "Leste", "12223430");
		Endereco rua656 = new Endereco(null, "Rua Porto Rico", "Cidade Vista Verde", "Leste", "12223440");
		Endereco rua657 = new Endereco(null, "Rua Gustavo Rico Toro", "Cidade Vista Verde", "Leste", "12223450");
		Endereco rua658 = new Endereco(null, "Rua Júlio Cezar Sales", "Cidade Vista Verde", "Leste", "12223460");
		Endereco rua659 = new Endereco(null, "Rua Terezinha da Silva Almeida", "Cidade Vista Verde", "Leste",
				"12223470");
		Endereco rua660 = new Endereco(null, "Rua Antonio Nunes Machado", "Cidade Vista Verde", "Leste", "12223480");
		Endereco rua661 = new Endereco(null, "Rua Luiz Barone", "Cidade Vista Verde", "Leste", "12223490");
		Endereco rua662 = new Endereco(null, "Rua Cinqüenta e Sete", "Cidade Vista Verde", "Leste", "12223500");
		Endereco rua663 = new Endereco(null, "Rua Nathalie Alvarado Gomes", "Cidade Vista Verde", "Leste", "12223510");
		Endereco rua664 = new Endereco(null, "Rua José Roberto de Souza", "Cidade Vista Verde", "Leste", "12223520");
		Endereco rua665 = new Endereco(null, "Rua José Bezerra da Silva", "Cidade Vista Verde", "Leste", "12223540");
		Endereco rua666 = new Endereco(null, "Rua Manoel Senra Delgado", "Cidade Vista Verde", "Leste", "12223550");
		Endereco rua667 = new Endereco(null, "Rua Elizabetha Gaubatz Rohde", "Cidade Vista Verde", "Leste", "12223560");
		Endereco rua668 = new Endereco(null, "Rua Anna de Paula Figueiredo", "Cidade Vista Verde", "Leste", "12223570");
		Endereco rua669 = new Endereco(null, "Rua João Friggi Filho", "Cidade Vista Verde", "Leste", "12223580");
		Endereco rua670 = new Endereco(null, "Rua Cidade de Lima", "Cidade Vista Verde", "Leste", "12223590");
		Endereco rua671 = new Endereco(null, "Rua Cidade de Washington", "Cidade Vista Verde", "Leste", "12223600");
		Endereco rua672 = new Endereco(null, "Rua Reverendo Professor Eliel de Almeida Martins", "Cidade Vista Verde",
				"Leste", "12223610");
		Endereco rua673 = new Endereco(null, "Rua Reverendo José Emídio Sobrinho", "Cidade Vista Verde", "Leste",
				"12223620");
		Endereco rua674 = new Endereco(null, "Rua Celso Vilhena Vieira", "Cidade Vista Verde", "Leste", "12223630");
		Endereco rua675 = new Endereco(null, "Rua Cidade de Otawa", "Cidade Vista Verde", "Leste", "12223631");
		Endereco rua676 = new Endereco(null, "Rua Cidade de Brasília", "Cidade Vista Verde", "Leste", "12223640");
		Endereco rua677 = new Endereco(null, "Rua Cidade de Quito", "Cidade Vista Verde", "Leste", "12223650");
		Endereco rua678 = new Endereco(null, "Rua Cidade de Montevidéo", "Cidade Vista Verde", "Leste", "12223660");
		Endereco rua679 = new Endereco(null, "Rua Cidade de Santiago", "Cidade Vista Verde", "Leste", "12223670");
		Endereco rua680 = new Endereco(null, "Rua Cidade de La Paz", "Cidade Vista Verde", "Leste", "12223680");
		Endereco rua681 = new Endereco(null, "Rua Cidade de Assunção", "Cidade Vista Verde", "Leste", "12223690");
		Endereco rua682 = new Endereco(null, "Rua Caracas", "Cidade Vista Verde", "Leste", "12223700");
		Endereco rua683 = new Endereco(null, "Rua Bogotá", "Cidade Vista Verde", "Leste", "12223710");
		Endereco rua684 = new Endereco(null, "Rua Elvis Presley", "Cidade Vista Verde", "Leste", "12223720");
		Endereco rua685 = new Endereco(null, "Rua Buenos Aires", "Cidade Vista Verde", "Leste", "12223730");
		Endereco rua686 = new Endereco(null, "Rua Bermudas", "Cidade Vista Verde", "Leste", "12223740");
		Endereco rua687 = new Endereco(null, "Praça Lions", "Cidade Vista Verde", "Leste", "12223741");
		Endereco rua688 = new Endereco(null, "Rua Curacao", "Cidade Vista Verde", "Leste", "12223750");
		Endereco rua689 = new Endereco(null, "Rua Baviera", "Cidade Vista Verde", "Leste", "12223760");
		Endereco rua690 = new Endereco(null, "Rua Bahamas", "Cidade Vista Verde", "Leste", "12223770");
		Endereco rua691 = new Endereco(null, "Rua Aruba", "Cidade Vista Verde", "Leste", "12223780");
		Endereco rua692 = new Endereco(null, "Rua Tobago", "Cidade Vista Verde", "Leste", "12223790");
		Endereco rua693 = new Endereco(null, "Rua São Domingos", "Cidade Vista Verde", "Leste", "12223800");
		Endereco rua694 = new Endereco(null, "Rua El Salvador", "Cidade Vista Verde", "Leste", "12223810");
		Endereco rua695 = new Endereco(null, "Rua Barbados", "Cidade Vista Verde", "Leste", "12223820");
		Endereco rua696 = new Endereco(null, "Alameda Harvey C Weeks", "Cidade Vista Verde", "Leste", "12223830");
		Endereco rua697 = new Endereco(null, "Rua Aparecida Dalprat Souza", "Cidade Vista Verde", "Leste", "12223845");
		Endereco rua698 = new Endereco(null, "Praça Jave Nissi", "Cidade Vista Verde", "Leste", "12223846");
		Endereco rua699 = new Endereco(null, "Alameda Flor de Laranjeira", "Condomínio Colinas do Parahyba", "Norte",
				"12213547");
		Endereco rua700 = new Endereco(null, "Alameda das Gérberas", "Condomínio Colinas do Parahyba", "Norte",
				"12213548");
		Endereco rua701 = new Endereco(null, "Alameda dos Lisianthus", "Condomínio Colinas do Parahyba", "Norte",
				"12213549");
		Endereco rua702 = new Endereco(null, "Alameda das Calêndulas", "Condomínio Colinas do Parahyba", "Norte",
				"12213574");
		Endereco rua703 = new Endereco(null, "Alameda das Magnólias", "Condomínio Colinas do Parahyba", "Norte",
				"12213575");
		Endereco rua704 = new Endereco(null, "Rua Doze", "Condomínio Colinas do Parahyba", "Norte", "12213576");
		Endereco rua705 = new Endereco(null, "Alameda Flor de Lothus", "Condomínio Colinas do Parahyba", "Norte",
				"12213577");
		Endereco rua706 = new Endereco(null, "Alameda das Frésias", "Condomínio Colinas do Parahyba", "Norte",
				"12213578");
		Endereco rua707 = new Endereco(null, "Alameda das Caliandras", "Condomínio Colinas do Parahyba", "Norte",
				"12213579");
		Endereco rua708 = new Endereco(null, "Avenida Lírio do Vale", "Condomínio Colinas do Parahyba", "Norte",
				"12213621");
		Endereco rua709 = new Endereco(null, "Alameda das Sakuras", "Condomínio Colinas do Parahyba", "Norte",
				"12213622");
		Endereco rua710 = new Endereco(null, "Rua Mirim", "Jardim Ebenézer", "Leste", "12226199");
		Endereco rua711 = new Endereco(null, "Rua Shalon", "Jardim Ebenézer", "Leste", "12226203");
		Endereco rua712 = new Endereco(null, "Rua José Alves dos Santos", "Floradas de São José", "Sul", "12230081");
		Endereco rua713 = new Endereco(null, "Rua Matias Peres", "Floradas de São José", "Sul", "12230082");
		Endereco rua714 = new Endereco(null, "Rua Francisca Maria de Jesus", "Floradas de São José", "Sul", "12230083");
		Endereco rua715 = new Endereco(null, "Rua Tsunessaburo Makiguti", "Floradas de São José", "Sul", "12230084");
		Endereco rua716 = new Endereco(null, "Rua José Augusto dos Santos", "Floradas de São José", "Sul", "12230085");
		Endereco rua717 = new Endereco(null, "Rua da Alegria", "Floradas de São José", "Sul", "12230086");
		Endereco rua718 = new Endereco(null, "Rua Moisés Tristão dos Santos", "Floradas de São José", "Sul",
				"12230087");
		Endereco rua719 = new Endereco(null, "Rua João Fonseca dos Santos", "Floradas de São José", "Sul", "12230088");
		Endereco rua720 = new Endereco(null, "Rua Mário Valério Camargo", "Floradas de São José", "Sul", "12230089");
		Endereco rua721 = new Endereco(null, "Rua Paulo da Silva Santos", "Floradas de São José", "Sul", "12230091");
		Endereco rua722 = new Endereco(null, "Rua Frei Galvão", "Buquirinha", "Leste", "12213734");
		Endereco rua723 = new Endereco(null, "Praça Frei Galvão", "Jardim São Judas Tadeu", "Leste", "12228373");
		Endereco rua724 = new Endereco(null, "Rua das Marulas", "Residencial Frei Galvão", "Leste", "12248700");
		Endereco rua725 = new Endereco(null, "Rua das Cerejas", "Residencial Frei Galvão", "Leste", "12248701");
		Endereco rua726 = new Endereco(null, "Rua das Amoras", "Residencial Frei Galvão", "Leste", "12248702");
		Endereco rua727 = new Endereco(null, "Avenida das Oliveiras", "Residencial Frei Galvão", "Leste", "12248703");
		Endereco rua728 = new Endereco(null, "Rua das Pitangas", "Residencial Frei Galvão", "Leste", "12248704");
		Endereco rua729 = new Endereco(null, "Rua das Framboesas", "Residencial Frei Galvão", "Leste", "12248705");
		Endereco rua730 = new Endereco(null, "Rua das Acerolas", "Residencial Frei Galvão", "Leste", "12248706");
		Endereco rua731 = new Endereco(null, "Rua das Amêndoas", "Residencial Frei Galvão", "Leste", "12248707");
		Endereco rua732 = new Endereco(null, "Rua das Ameixas", "Residencial Frei Galvão", "Leste", "12248708");
		Endereco rua733 = new Endereco(null, "Rua dos Damascos", "Residencial Frei Galvão", "Leste", "12248709");
		Endereco rua734 = new Endereco(null, "Rua das Avelãs", "Residencial Frei Galvão", "Leste", "12248710");
		Endereco rua735 = new Endereco(null, "Rua das Graviolas", "Residencial Frei Galvão", "Leste", "12248711");
		Endereco rua736 = new Endereco(null, "Rua das Tâmaras", "Residencial Frei Galvão", "Leste", "12248712");
		Endereco rua737 = new Endereco(null, "Estrada Municipal do Jaguariuna",
				"Condomínio Residencial Colinas do Paratehy", "Norte/Oeste", "12244109");
		Endereco rua738 = new Endereco(null, "Rua Noruega", "Jardim Aeroporto", "Sul", "12231140");
		Endereco rua739 = new Endereco(null, "Rua Letônia", "Jardim Aeroporto", "Sul", "12231150");
		Endereco rua740 = new Endereco(null, "Rua Estônia", "Jardim Aeroporto", "Sul", "12231160");
		Endereco rua741 = new Endereco(null, "Avenida Governador Mário Covas Júnior", "Jardim Aeroporto", "Sul",
				"12231168");
		Endereco rua742 = new Endereco(null, "Rua Finlândia", "Jardim Aeroporto", "Sul", "12231170");
		Endereco rua743 = new Endereco(null, "Rua Dinamarca", "Jardim Aeroporto", "Sul", "12231200");
		Endereco rua744 = new Endereco(null, "Rua Talim", "Jardim Aeroporto", "Sul", "12231280");
		Endereco rua745 = new Endereco(null, "Praça Professor José Vieira de Macedo", "Jardim Aeroporto", "Sul",
				"12231281");
		Endereco rua746 = new Endereco(null, "Rua Dublim", "Jardim Aeroporto", "Sul", "12231300");
		Endereco rua747 = new Endereco(null, "Avenida Um", "Jardim Aeroporto", "Sul", "12231301");
		Endereco rua748 = new Endereco(null, "Avenida Pico das Agulhas Negras", "Jardim Altos de Santana", "Norte",
				"12214000");
		Endereco rua749 = new Endereco(null, "Rua Horto Florestal", "Jardim Altos de Santana", "Norte", "12214001");
		Endereco rua750 = new Endereco(null, "Avenida Alto do Rio Doce", "Jardim Altos de Santana", "Norte",
				"12214010");
		Endereco rua751 = new Endereco(null, "Rua Pico Cruzeiro", "Jardim Altos de Santana", "Norte", "12214020");
		Endereco rua752 = new Endereco(null, "Rua Pico do Pulpito", "Jardim Altos de Santana", "Norte", "12214030");
		Endereco rua753 = new Endereco(null, "Rua Pico Juliana", "Jardim Altos de Santana", "Norte", "12214040");
		Endereco rua754 = new Endereco(null, "Rua Pico do Selado", "Jardim Altos de Santana", "Norte", "12214050");
		Endereco rua755 = new Endereco(null, "Rua Serra da Ibitipoca", "Jardim Altos de Santana", "Norte", "12214060");
		Endereco rua756 = new Endereco(null, "Rua Pedra Vermelha", "Jardim Altos de Santana", "Norte", "12214070");
		Endereco rua757 = new Endereco(null, "Rua Pedra Redonda", "Jardim Altos de Santana", "Norte", "12214080");
		Endereco rua758 = new Endereco(null, "Rua Monte Paschoal", "Jardim Altos de Santana", "Norte", "12214090");
		Endereco rua759 = new Endereco(null, "Rua Monte das Oliveiras", "Jardim Altos de Santana", "Norte", "12214100");
		Endereco rua760 = new Endereco(null, "Rua Monte Castelo", "Jardim Altos de Santana", "Norte", "12214110");
		Endereco rua761 = new Endereco(null, "Rua Serra das Araras", "Jardim Altos de Santana", "Norte", "12214120");
		Endereco rua762 = new Endereco(null, "Rua Serra Dourada", "Jardim Altos de Santana", "Norte", "12214130");
		Endereco rua763 = new Endereco(null, "Rua Pico do Jaraguá", "Jardim Altos de Santana", "Norte", "12214140");
		Endereco rua764 = new Endereco(null, "Rua Alto da Boa Vista", "Jardim Altos de Santana", "Norte", "12214150");
		Endereco rua765 = new Endereco(null, "Rua Pico Marins", "Jardim Altos de Santana", "Norte", "12214160");
		Endereco rua766 = new Endereco(null, "Rua Montanha Fuji", "Jardim Altos de Santana", "Norte", "12214170");
		Endereco rua767 = new Endereco(null, "Rua Monte Sinai", "Jardim Altos de Santana", "Norte", "12214180");
		Endereco rua768 = new Endereco(null, "Rua Pico dos Três Estados", "Jardim Altos de Santana", "Norte",
				"12214190");
		Endereco rua769 = new Endereco(null, "Rua Pico do Bugil", "Jardim Altos de Santana", "Norte", "12214200");
		Endereco rua770 = new Endereco(null, "Rua Pedra do Sino", "Jardim Altos de Santana", "Norte", "12214210");
		Endereco rua771 = new Endereco(null, "Rua Serra de Santa Bárbara", "Jardim Altos de Santana", "Norte",
				"12214220");
		Endereco rua772 = new Endereco(null, "Rua Monte Roraima", "Jardim Altos de Santana", "Norte", "12214230");
		Endereco rua773 = new Endereco(null, "Rua Pico Cristal", "Jardim Altos de Santana", "Norte", "12214240");
		Endereco rua774 = new Endereco(null, "Rua Pico da Neblina", "Jardim Altos de Santana", "Norte", "12214250");
		Endereco rua775 = new Endereco(null, "Rua Pedra do Capim Azul", "Jardim Altos de Santana", "Norte", "12214260");
		Endereco rua776 = new Endereco(null, "Rua Pico do Aconcagua", "Jardim Altos de Santana", "Norte", "12214270");
		Endereco rua777 = new Endereco(null, "Rua Pedra Pouso do Rochedo", "Jardim Altos de Santana", "Norte",
				"12214280");
		Endereco rua778 = new Endereco(null, "Rua Pico da Bandeira", "Jardim Altos de Santana", "Norte", "12214290");
		Endereco rua779 = new Endereco(null, "Rua Serra da Canastra", "Jardim Altos de Santana", "Norte", "12214300");
		Endereco rua780 = new Endereco(null, "Rua Vinte e Nove", "Jardim Altos de Santana", "Norte", "12214310");
		Endereco rua781 = new Endereco(null, "Rua Serra de Jambeiro", "Jardim Altos de Santana", "Norte", "12214320");
		Endereco rua782 = new Endereco(null, "Rua Alto do Araguaia", "Jardim Altos de Santana", "Norte", "12214330");
		Endereco rua783 = new Endereco(null, "Rua Pico Itapevi", "Jardim Altos de Santana", "Norte", "12214340");
		Endereco rua784 = new Endereco(null, "Rua Serra do Japi", "Jardim Altos de Santana", "Norte", "12214350");
		Endereco rua785 = new Endereco(null, "Rua Monte Kilimanjaro", "Jardim Altos de Santana", "Norte", "12214370");
		Endereco rua786 = new Endereco(null, "Rua Pedra do Baú", "Jardim Altos de Santana", "Norte", "12214380");
		Endereco rua787 = new Endereco(null, "Rua Serra dos Carajás", "Jardim Altos de Santana", "Norte", "12214390");
		Endereco rua788 = new Endereco(null, "Rua Pedra Alta", "Jardim Altos de Santana", "Norte", "12214391");
		Endereco rua789 = new Endereco(null, "Rua Serra dos Aimorés", "Jardim Altos de Santana", "Norte", "12214400");
		Endereco rua790 = new Endereco(null, "Rua Serra da Saudade", "Jardim Altos de Santana", "Norte", "12214410");
		Endereco rua791 = new Endereco(null, "Rua Jaguari", " s/n", "Jardim Altos de Santana", "Norte");
		Endereco rua792 = new Endereco(null, "Rua São Caetano do Sul", "Jardim Alvorada", "Oeste", "12240510");
		Endereco rua793 = new Endereco(null, "Rua Ourinhos", "Jardim Alvorada", "Oeste", "12240511");
		Endereco rua794 = new Endereco(null, "Rua São Bernardo do Campo", "Jardim Alvorada", "Oeste", "12240520");
		Endereco rua795 = new Endereco(null, "Rua Santo André", "Jardim Alvorada", "Oeste", "12240521");
		Endereco rua796 = new Endereco(null, "Avenida Campos Elíseos", "Jardim Alvorada", "Oeste", "12240530");
		Endereco rua797 = new Endereco(null, "Avenida Cassiano Ricardo", "Jardim Alvorada", "Oeste", "12240540");
		Endereco rua798 = new Endereco(null, "Avenida da Liberdade", "Jardim Alvorada", "Oeste", "12240550");
		Endereco rua799 = new Endereco(null, "Rua Araçatuba", "Jardim Alvorada", "Oeste", "12240560");
		Endereco rua800 = new Endereco(null, "Avenida Aclimação", "Jardim Alvorada", "Oeste", "12240570");
		Endereco rua801 = new Endereco(null, "Rua Itapetininga", "Jardim Alvorada", "Oeste", "12240571");
		Endereco rua802 = new Endereco(null, "Rua Santos", "Jardim Alvorada", "Oeste", "12240580");
		Endereco rua803 = new Endereco(null, "Rua Itu", "Jardim Alvorada", "Oeste", "12240590");
		Endereco rua804 = new Endereco(null, "Rua Sorocaba", "Jardim Alvorada", "Oeste", "12240600");
		Endereco rua805 = new Endereco(null, "Rua Avaré", "Jardim Alvorada", "Oeste", "12240601");
		Endereco rua806 = new Endereco(null, "Rua Campinas", "Jardim Alvorada", "Oeste", "12240620");
		Endereco rua807 = new Endereco(null, "Rua Ribeirão Preto", "Jardim Alvorada", "Oeste", "12240630");
		Endereco rua808 = new Endereco(null, "Rua Botucatu", "Jardim Alvorada", "Oeste", "12240640");
		Endereco rua809 = new Endereco(null, "Rua Limeira", "Jardim Alvorada", "Oeste", "12240650");
		Endereco rua810 = new Endereco(null, "Rua Jundiai", "Jardim Alvorada", "Oeste", "12240651");
		Endereco rua811 = new Endereco(null, "Praça Alvorada", "Jardim Alvorada", "Oeste", "12240652");
		Endereco rua812 = new Endereco(null, "Rua Marília", "Jardim Alvorada", "Oeste", "12240660");
		Endereco rua813 = new Endereco(null, "Rua Bauru", "Jardim Alvorada", "Oeste", "12240670");
		Endereco rua814 = new Endereco(null, "Avenida Cassiano Ricardo", " 179", "Jardim Alvorada", "Oeste");
		Endereco rua815 = new Endereco(null, "Avenida Cassiano Ricardo", " 761", "Jardim Alvorada", "Oeste");
		Endereco rua816 = new Endereco(null, "Avenida Presidente Tancredo Neves", "Jardim Americano", "Sul",
				"12225011");
		Endereco rua817 = new Endereco(null, "Rua Otávio Moraes Lopes", "Jardim Americano", "Sul", "12225040");
		Endereco rua818 = new Endereco(null, "Praça José Carlos Pace", "Jardim Americano", "Sul", "12225050");
		Endereco rua819 = new Endereco(null, "Rua José Duarte Simões", "Jardim Americano", "Sul", "12225060");
		Endereco rua820 = new Endereco(null, "Rua Benedito Eras", "Jardim Americano", "Sul", "12225070");
		Endereco rua821 = new Endereco(null, "Rua Frei Bertholdo Vah Der Mee", "Jardim Americano", "Sul", "12225080");
		Endereco rua822 = new Endereco(null, "Rua Julia Cursino", "Jardim Americano", "Sul", "12225090");
		Endereco rua823 = new Endereco(null, "Rua Maria Carolina de Jesus", "Jardim Americano", "Sul", "12225100");
		Endereco rua824 = new Endereco(null, "Rua Padre Joaquim Franca", "Jardim Americano", "Sul", "12225110");
		Endereco rua825 = new Endereco(null, "Avenida Guadalupe", "Jardim América", "Sul", "12235000");
		Endereco rua826 = new Endereco(null, "Rua Cali", "Jardim América", "Sul", "12235010");
		Endereco rua827 = new Endereco(null, "Rua Paissandu", "Jardim América", "Sul", "12235020");
		Endereco rua828 = new Endereco(null, "Rua Patagones", "Jardim América", "Sul", "12235031");
		Endereco rua829 = new Endereco(null, "Rua Principado de Mônaco", "Jardim América", "Sul", "12235040");
		Endereco rua830 = new Endereco(null, "Rua Andorra", "Jardim América", "Sul", "12235050");
		Endereco rua831 = new Endereco(null, "Rua Shizuko Iida", "Jardim América", "Sul", "12235051");
		Endereco rua832 = new Endereco(null, "Rua Pedro Tatimoto", "Jardim América", "Sul", "12235060");
		Endereco rua833 = new Endereco(null, "Rua Haiti", "Jardim América", "Sul", "12235070");
		Endereco rua834 = new Endereco(null, "Rua San Marino", "Jardim América", "Sul", "12235080");
		Endereco rua835 = new Endereco(null, "Rua Groelândia", "Jardim América", "Sul", "12235090");
		Endereco rua836 = new Endereco(null, "Rua Equador", "Jardim América", "Sul", "12235100");
		Endereco rua837 = new Endereco(null, "Rua João de Paula", "Jardim América", "Sul", "12235101");
		Endereco rua838 = new Endereco(null, "Rua Arequipa", "Jardim América", "Sul", "12235110");
		Endereco rua839 = new Endereco(null, "Rua Costa Rica", "Jardim América", "Sul", "12235120");
		Endereco rua840 = new Endereco(null, "Rua Ryokichi Asanome", "Jardim América", "Sul", "12235130");
		Endereco rua841 = new Endereco(null, "Rua Nelson Cavaquinho", "Jardim América", "Sul", "12235140");
		Endereco rua842 = new Endereco(null, "Rua Irmã Emília Michelin", "Jardim América", "Sul", "12235150");
		Endereco rua843 = new Endereco(null, "Rua Benedito Pinto da Cunha", "Jardim América", "Sul", "12235160");
		Endereco rua844 = new Endereco(null, "Rua Professor Luiz Eurico Ferreira", "Jardim América", "Sul", "12235170");
		Endereco rua845 = new Endereco(null, "Rua Koichi Matsumura", "Jardim América", "Sul", "12235180");
		Endereco rua846 = new Endereco(null, "Rua Iraci Gonçalves Ferreira", "Jardim América", "Sul", "12235181");
		Endereco rua847 = new Endereco(null, "Rua Aurora Pinto da Cunha", "Jardim América", "Sul", "12235190");
		Endereco rua848 = new Endereco(null, "Rua Benedicto de Alvarenga", "Jardim América", "Sul", "12235191");
		Endereco rua849 = new Endereco(null, "Rua Vicente Venâncio da Silva", "Jardim América", "Sul", "12235192");
		Endereco rua850 = new Endereco(null, "Avenida João Batista de Souza Soares", "Jardim América", "Sul",
				"12235200");
		Endereco rua851 = new Endereco(null, "Avenida Marginal B", "Jardim América", "Sul", "12235311");
		Endereco rua852 = new Endereco(null, "Rua Bariloche", "Jardim América", "Sul", "12235320");
		Endereco rua853 = new Endereco(null, "Rua Tucuman", "Jardim América", "Sul", "12235330");
		Endereco rua854 = new Endereco(null, "Rua Mar Del Plata", "Jardim América", "Sul", "12235340");
		Endereco rua855 = new Endereco(null, "Praça Kadoma", "Jardim América", "Sul", "12235341");
		Endereco rua856 = new Endereco(null, "Rua Arica", "Jardim América", "Sul", "12235350");
		Endereco rua857 = new Endereco(null, "Rua Professor José Antônio Coutinho Condino", "Jardim América", "Sul",
				"12235361");
		Endereco rua858 = new Endereco(null, "Rua Maracaibo", "Jardim América", "Sul", "12235370");
		Endereco rua859 = new Endereco(null, "Rua Alcides Barbosa", "Jardim América", "Sul", "12235371");
		Endereco rua860 = new Endereco(null, "Rua Valparaiso", "Jardim América", "Sul", "12235380");
		Endereco rua861 = new Endereco(null, "Rua Cordoba", "Jardim América", "Sul", "12235390");
		Endereco rua862 = new Endereco(null, "Rua Merida", "Jardim América", "Sul", "12235400");
		Endereco rua863 = new Endereco(null, "Rua Rosario", "Jardim América", "Sul", "12235420");
		Endereco rua864 = new Endereco(null, "Rua Particular", "Jardim América", "Sul", "12235421");
		Endereco rua865 = new Endereco(null, "Avenida Guadalupe", " 11", "Jardim América", "Sul");
		Endereco rua866 = new Endereco(null, "Avenida Presidente Tancredo Neves", "Jardim Americano", "Leste",
				"12225011");
		Endereco rua867 = new Endereco(null, "Rua Otávio Moraes Lopes", "Jardim Americano", "Leste", "12225040");
		Endereco rua868 = new Endereco(null, "Praça José Carlos Pace", "Jardim Americano", "Leste", "12225050");
		Endereco rua869 = new Endereco(null, "Rua José Duarte Simões", "Jardim Americano", "Leste", "12225060");
		Endereco rua870 = new Endereco(null, "Rua Benedito Eras", "Jardim Americano", "Leste", "12225070");
		Endereco rua871 = new Endereco(null, "Rua Frei Bertholdo Vah Der Mee", "Jardim Americano", "Leste", "12225080");
		Endereco rua872 = new Endereco(null, "Rua Julia Cursino", "Jardim Americano", "Leste", "12225090");
		Endereco rua873 = new Endereco(null, "Rua Maria Carolina de Jesus", "Jardim Americano", "Leste", "12225100");
		Endereco rua874 = new Endereco(null, "Rua Padre Joaquim Franca", "Jardim Americano", "Leste", "12225110");
		Endereco rua875 = new Endereco(null, "Rua Serra do Parima", "Jardim Anhembi", "Sul", "12235210");
		Endereco rua876 = new Endereco(null, "Rua Serra dos Pirineus", "Jardim Anhembi", "Sul", "12235220");
		Endereco rua877 = new Endereco(null, "Rua Serra dos Órgãos", "Jardim Anhembi", "Sul", "12235230");
		Endereco rua878 = new Endereco(null, "Rua Serra do Roncador", "Jardim Anhembi", "Sul", "12235240");
		Endereco rua879 = new Endereco(null, "Rua Serra da Mantiqueira", "Jardim Anhembi", "Sul", "12235250");
		Endereco rua880 = new Endereco(null, "Rua Serra do Paranapiacaba", "Jardim Anhembi", "Sul", "12235251");
		Endereco rua881 = new Endereco(null, "Praça Serra Formosa", "Jardim Anhembi", "Sul", "12235260");
		Endereco rua882 = new Endereco(null, "Rua Serra do Pacaraima", "Jardim Anhembi", "Sul", "12235270");
		Endereco rua883 = new Endereco(null, "Praça Serra do Acarai", "Jardim Anhembi", "Sul", "12235280");
		Endereco rua884 = new Endereco(null, "Rua Serra do Ibiacaba", "Jardim Anhembi", "Sul", "12235290");
		Endereco rua885 = new Endereco(null, "Rua Serra do Mar", "Jardim Anhembi", "Sul", "12235310");
		Endereco rua886 = new Endereco(null, "Rua Ismael Vieira das Neves", "Jardim Aparecida", "Centro", "12245040");
		Endereco rua887 = new Endereco(null, "Travessa Gisberto Ballarini", "Jardim Aparecida", "Centro", "12245050");
		Endereco rua888 = new Endereco(null, "Rua Jordão Monteiro Ferreira", "Jardim Aparecida", "Centro", "12245089");
		Endereco rua889 = new Endereco(null, "Rua Elza Bierfeld D'Avila", "Jardim Aparecida", "Centro", "12245381");
		Endereco rua890 = new Endereco(null, "Rua Euclides Figueiredo", "Jardim Apolo I", "Centro", "12243002");
		Endereco rua891 = new Endereco(null, "Praça Cândida Maria César Sawaya Giana", "Jardim Apolo I", "Centro",
				"12243003");
		Endereco rua892 = new Endereco(null, "Rua Coronel Francisco Américo Fontenele", "Jardim Apolo I", "Centro",
				"12243004");
		Endereco rua893 = new Endereco(null, "Rua Assuntina Ciocchi Blair", "Jardim Apolo II", "Centro", "12243090");
		Endereco rua894 = new Endereco(null, "Rua Paulo Edson Blair", "Jardim Apolo II", "Centro", "12243100");
		Endereco rua895 = new Endereco(null, "Rua Augusto Edson Ehlke", "Jardim Apolo II", "Centro", "12243110");
		Endereco rua896 = new Endereco(null, "Rua Pedro Rabelo de Araújo", "Jardim Apolo II", "Centro", "12243111");
		Endereco rua897 = new Endereco(null, "Rua Amparo", "Jardim Apolo I", "Centro", "12243120");
		Endereco rua898 = new Endereco(null, "Rua Ubatuba", "Jardim Apolo I", "Centro", "12243130");
		Endereco rua899 = new Endereco(null, "Rua Lindoia", "Jardim Apolo I", "Centro", "12243140");
		Endereco rua900 = new Endereco(null, "Rua Caraguatatuba", "Jardim Apolo I", "Centro", "12243150");
		Endereco rua901 = new Endereco(null, "Rua Itanhaém", "Jardim Apolo I", "Centro", "12243160");
		Endereco rua902 = new Endereco(null, "Rua Assis", "Jardim Apolo I", "Centro", "12243170");
		Endereco rua903 = new Endereco(null, "Rua Taquaritinga", "Jardim Apolo I", "Centro", "12243180");
		Endereco rua904 = new Endereco(null, "Rua Serra Negra", "Jardim Apolo I", "Centro", "12243190");
		Endereco rua905 = new Endereco(null, "Rua Itatiba", "Jardim Apolo I", "Centro", "12243200");
		Endereco rua906 = new Endereco(null, "Rua Atibaia", "Jardim Apolo I", "Centro", "12243210");
		Endereco rua907 = new Endereco(null, "Rua Itapira", "Jardim Apolo I", "Centro", "12243220");
		Endereco rua908 = new Endereco(null, "Rua Guarujá", "Jardim Apolo I", "Centro", "12243230");
		Endereco rua909 = new Endereco(null, "Rua Socorro", "Jardim Apolo I", "Centro", "12243240");
		Endereco rua910 = new Endereco(null, "Rua Assuntina Ciocchi Blair", "Jardim Apolo II", "Centro", "12243090");
		Endereco rua911 = new Endereco(null, "Rua Paulo Edson Blair", "Jardim Apolo II", "Centro", "12243100");
		Endereco rua912 = new Endereco(null, "Rua Augusto Edson Ehlke", "Jardim Apolo II", "Centro", "12243110");
		Endereco rua913 = new Endereco(null, "Rua Pedro Rabelo de Araújo", "Jardim Apolo II", "Centro", "12243111");
		Endereco rua914 = new Endereco(null, "Rua Roma", "Jardim Augusta", "Centro", "12216510");
		Endereco rua915 = new Endereco(null, "Praça Arábia", "Jardim Augusta", "Centro", "12216610");
		Endereco rua916 = new Endereco(null, "Avenida Lisboa", "Jardim Augusta", "Centro", "12216630");
		Endereco rua917 = new Endereco(null, "Praça Berlim", "Jardim Augusta", "Centro", "12216631");
		Endereco rua918 = new Endereco(null, "Rua Haia", "Jardim Augusta", "Centro", "12216650");
		Endereco rua919 = new Endereco(null, "Rua Copenhague", "Jardim Augusta", "Centro", "12216660");
		Endereco rua920 = new Endereco(null, "Rua Budapest", "Jardim Augusta", "Centro", "12216670");
		Endereco rua921 = new Endereco(null, "Rua Berna", "Jardim Augusta", "Centro", "12216680");
		Endereco rua922 = new Endereco(null, "Rua Estocolmo", "Jardim Augusta", "Centro", "12216690");
		Endereco rua923 = new Endereco(null, "Avenida Samuel Wainer", "Jardim Augusta", "Centro", "12216710");
		Endereco rua924 = new Endereco(null, "Rua Varsóvia", "Jardim Augusta", "Centro", "12216730");
		Endereco rua925 = new Endereco(null, "Rua Madrid", "Jardim Augusta", "Centro", "12216750");
		Endereco rua926 = new Endereco(null, "Praça Londres", "Jardim Augusta", "Centro", "12216760");
		Endereco rua927 = new Endereco(null, "Rua Atenas", "Jardim Augusta", "Centro", "12216770");
		Endereco rua928 = new Endereco(null, "Praça Paris", "Jardim Augusta", "Centro", "12216780");
		Endereco rua929 = new Endereco(null, "Avenida Rui Barbosa", "Jardim Bela Vista", "Centro", "12209000");
		Endereco rua930 = new Endereco(null, "Avenida Marechal Castelo Branco", "Jardim Bela Vista", "Centro",
				"12209002");
		Endereco rua931 = new Endereco(null, "Rua Capitão Roberto Ferreira Maldos", "Jardim Bela Vista", "Centro",
				"12209003");
		Endereco rua932 = new Endereco(null, "Avenida Doutor Mário Galvão", "Jardim Bela Vista", "Centro", "12209004");
		Endereco rua933 = new Endereco(null, "Rua Romeu Carnevalli", "Jardim Bela Vista", "Centro", "12209005");
		Endereco rua934 = new Endereco(null, "Avenida São José", "Jardim Bela Vista", "Centro", "12209010");
		Endereco rua935 = new Endereco(null, "Avenida Tenente Névio Baracho", "Jardim Bela Vista", "Centro",
				"12209020");
		Endereco rua936 = new Endereco(null, "Praça do Expedicionário", "Jardim Bela Vista", "Centro", "12209030");
		Endereco rua937 = new Endereco(null, "Rua Ana Eufrásia", "Jardim Bela Vista", "Centro", "12209071");
		Endereco rua938 = new Endereco(null, "Rua Sebastião Felício", "Jardim Bela Vista", "Centro", "12209090");
		Endereco rua939 = new Endereco(null, "Rua Laudelino Nogueira", "Jardim Bela Vista", "Centro", "12209100");
		Endereco rua940 = new Endereco(null, "Rua José Leite da Silva", "Jardim Bela Vista", "Centro", "12209110");
		Endereco rua941 = new Endereco(null, "Rua Geraldo Augusto dos Santos", "Jardim Bela Vista", "Centro",
				"12209120");
		Endereco rua942 = new Endereco(null, "Praça Vicente Batista", "Jardim Bela Vista", "Centro", "12209130");
		Endereco rua943 = new Endereco(null, "Rua Doutor Gaspar Resende", "Jardim Bela Vista", "Centro", "12209140");
		Endereco rua944 = new Endereco(null, "Rua Delfino Mascarenhas", "Jardim Bela Vista", "Centro", "12209150");
		Endereco rua945 = new Endereco(null, "Travessa Claudionor Chaves Itacaramby", "Jardim Bela Vista", "Centro",
				"12209155");
		Endereco rua946 = new Endereco(null, "Rua Padre Antônio Vieira", "Jardim Bela Vista", "Centro", "12209160");
		Endereco rua947 = new Endereco(null, "Viaduto dos Expedicionários", "Jardim Bela Vista", "Centro", "12209162");
		Endereco rua948 = new Endereco(null, "Rua Joaquim Nabuco", "Jardim Bela Vista", "Centro", "12209170");
		Endereco rua949 = new Endereco(null, "Viaduto Tenente João Alves Cardoso", "Jardim Bela Vista", "Centro",
				"12209171");
		Endereco rua950 = new Endereco(null, "Rua José Fonseca dos Santos", "Jardim Bela Vista", "Centro", "12209180");
		Endereco rua951 = new Endereco(null, "Rua Silvino Guedes", "Jardim Bela Vista", "Centro", "12209190");
		Endereco rua952 = new Endereco(null, "Rua Cônego José Fortunato da Silva Ramos", "Jardim Bela Vista", "Centro",
				"12209200");
		Endereco rua953 = new Endereco(null, "Travessa Inocêncio Alves da Silva", "Jardim Bela Vista", "Centro",
				"12209210");
		Endereco rua954 = new Endereco(null, "Travessa Contantino Pinto", "Jardim Bela Vista", "Centro", "12209211");
		Endereco rua955 = new Endereco(null, "Avenida Tenente Névio Baracho", " 330", "Jardim Bela Vista", "Centro");
		Endereco rua956 = new Endereco(null, "Avenida Marechal Castelo Branco", " 439", "Jardim Bela Vista", "Centro");
		Endereco rua957 = new Endereco(null, "Rua Maria Luiza Rodrigues Costa", "Jardim Boa Vista", "Norte",
				"12213630");
		Endereco rua958 = new Endereco(null, "Rua Ângelo Miguel Scavazzini", "Jardim Boa Vista", "Norte", "12213640");
		Endereco rua959 = new Endereco(null, "Rua Amâncio Bráulio de Melo", "Jardim Boa Vista", "Norte", "12213650");
		Endereco rua960 = new Endereco(null, "Rua José Duarte Júnior", "Jardim Boa Vista", "Norte", "12213660");
		Endereco rua961 = new Endereco(null, "Rua João Vilaça de Oliveira", "Jardim Boa Vista", "Norte", "12213670");
		Endereco rua962 = new Endereco(null, "Rua Sebastião Alves de Almeida", "Jardim Boa Vista", "Norte", "12213680");
		Endereco rua963 = new Endereco(null, "Largo da Boa Vista", "Jardim Boa Vista", "Norte", "12213690");
		Endereco rua964 = new Endereco(null, "Rua Maria Fausta de Souza", "Jardim Boa Vista", "Norte", "12213700");
		Endereco rua965 = new Endereco(null, "Rua José Vieira da Silva", "Jardim Boa Vista", "Norte", "12213710");
		Endereco rua966 = new Endereco(null, "Rua João Pereira Costa", "Jardim Boa Vista", "Norte", "12213711");
		Endereco rua967 = new Endereco(null, "Avenida João Pereira Costa", "Jardim Boa Vista", "Norte", "12213720");
		Endereco rua968 = new Endereco(null, "Rua Messias Palmeira", "Jardim Brasília", "Leste", "12221260");
		Endereco rua969 = new Endereco(null, "Avenida São João", "Jardim das Colinas", "Oeste", "12242000");
		Endereco rua970 = new Endereco(null, "Avenida Doutor Eduardo Cury", "Jardim das Colinas", "Oeste", "12242001");
		Endereco rua971 = new Endereco(null, "Rua Professora Lila Barboza", "Jardim das Colinas", "Oeste", "12242005");
		Endereco rua972 = new Endereco(null, "Avenida Deputado Benedito Matarazzo", "Jardim das Colinas", "Oeste",
				"12242010");
		Endereco rua973 = new Endereco(null, "Rua Calisto", "Jardim das Colinas", "Oeste", "12242035");
		Endereco rua974 = new Endereco(null, "Avenida João Tuca", "Jardim das Colinas", "Oeste", "12242050");
		Endereco rua975 = new Endereco(null, "Avenida Major Miguel Naked", "Jardim das Colinas", "Oeste", "12242051");
		Endereco rua976 = new Endereco(null, "Rua Professor Carlos Alberto de Buarque Borges", "Jardim das Colinas",
				"Oeste", "12242060");
		Endereco rua977 = new Endereco(null, "Rua Francisco de Oliveira Pinto", "Jardim das Colinas", "Oeste",
				"12242070");
		Endereco rua978 = new Endereco(null, "Rua Marechal-do-Ar Benjamim Manoel Amarante", "Jardim das Colinas",
				"Oeste", "12242071");
		Endereco rua979 = new Endereco(null, "Rua Professora Renê Maria Vandaele", "Jardim das Colinas", "Oeste",
				"12242080");
		Endereco rua980 = new Endereco(null, "Rua Professor Richard Robert Wallauchek", "Jardim das Colinas", "Oeste",
				"12242090");
		Endereco rua981 = new Endereco(null, "Rua Coronel Hildebrando Pralon Ferreira Leite", "Jardim das Colinas",
				"Oeste", "12242100");
		Endereco rua982 = new Endereco(null, "Rua Doutor Paulo Felizardo", "Jardim das Colinas", "Oeste", "12242110");
		Endereco rua983 = new Endereco(null, "Rua Major Dietrich Ott", "Jardim das Colinas", "Oeste", "12242111");
		Endereco rua984 = new Endereco(null, "Rua José Raimundo da Silva", "Jardim das Colinas", "Oeste", "12242120");
		Endereco rua985 = new Endereco(null, "Rua Doutor Pedro Popini Mascarenhas", "Jardim das Colinas", "Oeste",
				"12242130");
		Endereco rua986 = new Endereco(null, "Praça Jorge Vieira da Silva", "Jardim das Colinas", "Oeste", "12242131");
		Endereco rua987 = new Endereco(null, "Avenida Saul Vieira", "Jardim das Colinas", "Oeste", "12242140");
		Endereco rua988 = new Endereco(null, "Rua Victório Peneluppi", "Jardim das Colinas", "Oeste", "12242150");
		Endereco rua989 = new Endereco(null, "Rua Ceramista Roberto Weiss", "Jardim das Colinas", "Oeste", "12242160");
		Endereco rua990 = new Endereco(null, "Avenida Paul Harris", "Jardim das Colinas", "Oeste", "12242170");
		Endereco rua991 = new Endereco(null, "Avenida Jornalista Napoleão Monteiro", "Jardim das Colinas", "Oeste",
				"12242180");
		Endereco rua992 = new Endereco(null, "Rua Salim Felizardo", "Jardim das Colinas", "Oeste", "12242181");
		Endereco rua993 = new Endereco(null, "Rua Antônio Eras", "Jardim das Colinas", "Oeste", "12242190");
		Endereco rua994 = new Endereco(null, "Rua Ângelo Rodrigues Alves", "Jardim das Colinas", "Oeste", "12242200");
		Endereco rua995 = new Endereco(null, "Avenida Ulisses Dias Costa", "Jardim das Colinas", "Oeste", "12242210");
		Endereco rua996 = new Endereco(null, "Avenida Professor José Luiz Pereira Garcez", "Jardim das Colinas",
				"Oeste", "12242220");
		Endereco rua997 = new Endereco(null, "Rua Antônio Cara", "Jardim das Colinas", "Oeste", "12242221");
		Endereco rua998 = new Endereco(null, "Rua Valdemar Raimundo da Silva", "Jardim das Colinas", "Oeste",
				"12242222");
		Endereco rua999 = new Endereco(null, "Rua Flaminio Vaz de Lima", "Jardim das Colinas", "Oeste", "12242230");
		Endereco rua1000 = new Endereco(null, "Rua Professor João Batista Ortiz Monteiro", "Jardim das Colinas",
				"Oeste", "12242240");
		Endereco rua1001 = new Endereco(null, "Rua Padre José Maria da Silva Ramos", "Jardim das Colinas", "Oeste",
				"12242250");
		Endereco rua1002 = new Endereco(null, "Avenida Hellmuth P. Schicker", "Jardim das Colinas", "Oeste",
				"12242260");
		Endereco rua1003 = new Endereco(null, "Avenida Deputado Benedito Matarazzo", " 7007", "Jardim das Colinas",
				"Oeste");
		Endereco rua1004 = new Endereco(null, "Avenida São João", " 2200", "Jardim das Colinas", "Oeste");
		Endereco rua1005 = new Endereco(null, "Estrada do Imperador", "Jardim Colonial", "Sul", "12234001");
		Endereco rua1006 = new Endereco(null, "Rua Edesio Soares", "Jardim Colonial", "Sul", "12234002");
		Endereco rua1007 = new Endereco(null, "Rua Ester de Oliveira", "Jardim Colonial", "Sul", "12234003");
		Endereco rua1008 = new Endereco(null, "Rua Álvaro Lordello", "Jardim Colonial", "Sul", "12234004");
		Endereco rua1009 = new Endereco(null, "Rua Iran Faria Siqueira", "Jardim Colonial", "Sul", "12234005");
		Endereco rua1010 = new Endereco(null, "Rua Edesia Gonçalves Neves", "Jardim Colonial", "Sul", "12234006");
		Endereco rua1011 = new Endereco(null, "Rua São Fidélis", "Jardim Colonial", "Sul", "12234008");
		Endereco rua1012 = new Endereco(null, "Rua Caramuru", "Jardim Colonial", "Sul", "12234201");
		Endereco rua1013 = new Endereco(null, "Avenida Napoleão Bonaparte", "Jardim Colonial", "Sul", "12234270");
		Endereco rua1014 = new Endereco(null, "Praça Moreira Vita", "Jardim Colonial", "Sul", "12234271");
		Endereco rua1015 = new Endereco(null, "Rua Joaquim Bueno de Vasconcelos", "Jardim Colonial", "Sul", "12234280");
		Endereco rua1016 = new Endereco(null, "Rua José Simão", "Jardim Colonial", "Sul", "12234290");
		Endereco rua1017 = new Endereco(null, "Rua Anacleto Deolindo Liberato", "Jardim Colonial", "Sul", "12234300");
		Endereco rua1018 = new Endereco(null, "Rua Gustavo Sonnewend Filho", "Jardim Colonial", "Sul", "12234310");
		Endereco rua1019 = new Endereco(null, "Rua Cantagalo", "Jardim Colonial", "Sul", "12234320");
		Endereco rua1020 = new Endereco(null, "Rua Coronel Palimerico Resende", "Jardim Colonial", "Sul", "12234330");
		Endereco rua1021 = new Endereco(null, "Rua Monte Verde", "Jardim Colonial", "Sul", "12234331");
		Endereco rua1022 = new Endereco(null, "Rua Pureza", "Jardim Colonial", "Sul", "12234350");
		Endereco rua1023 = new Endereco(null, "Rua Baltazar", "Jardim Colonial", "Sul", "12234360");
		Endereco rua1024 = new Endereco(null, "Rua Celina", "Jardim Colonial", "Sul", "12234370");
		Endereco rua1025 = new Endereco(null, "Rua João Muzzaco", "Jardim Colonial", "Sul", "12234420");
		Endereco rua1026 = new Endereco(null, "Praça Bertolino Claudio", "Jardim Colonial", "Sul", "12234440");
		Endereco rua1027 = new Endereco(null, "Rua José Anconi", "Jardim Colonial", "Sul", "12234470");
		Endereco rua1028 = new Endereco(null, "Rua José Machado Faria", "Jardim Colorado", "Sudeste", "12227730");
		Endereco rua1029 = new Endereco(null, "Rua Cinco", "Jardim Colorado", "Sudeste", "12227733");
		Endereco rua1030 = new Endereco(null, "Rua Francisco Cipriano do Amaral", "Jardim Colorado", "Sudeste",
				"12227740");
		Endereco rua1031 = new Endereco(null, "Rua Tenente Benedito Dias Pereira", "Jardim Colorado", "Sudeste",
				"12227760");
		Endereco rua1032 = new Endereco(null, "Rua Professor Luiz Gonzaga Rios", "Jardim Colorado", "Sudeste",
				"12227771");
		Endereco rua1033 = new Endereco(null, "Rua Charles Diamond", "Jardim Copacabana", "Leste", "12221150");
		Endereco rua1034 = new Endereco(null, "Rua João Lindemberg", "Jardim Copacabana", "Leste", "12221220");
		Endereco rua1035 = new Endereco(null, "Praça Joaquim Figueira de Andrade", "Jardim Copacabana", "Leste",
				"12221221");
		Endereco rua1036 = new Endereco(null, "Rua Newton Ferreira Ivo", "Jardim Copacabana", "Leste", "12221230");
		Endereco rua1037 = new Endereco(null, "Rua Sidney Antônio Moreira da Silva", "Jardim Copacabana", "Leste",
				"12221240");
		Endereco rua1038 = new Endereco(null, "Avenida Orlando Ferreira Rebouças", "Jardim Cruzeiro do Sul", "Sul",
				"12234801");
		Endereco rua1039 = new Endereco(null, "Rua Octávio Bertti", "Jardim Cruzeiro do Sul", "Sul", "12234806");
		Endereco rua1040 = new Endereco(null, "Rua Isaac Guilherme Gonçalves", "Jardim Cruzeiro do Sul", "Sul",
				"12234807");
		Endereco rua1041 = new Endereco(null, "Rua Aparecida da Silva Alves", "Jardim Cruzeiro do Sul", "Sul",
				"12234808");
		Endereco rua1042 = new Endereco(null, "Rua Vítor Pinto Ribeiro", "Jardim Cruzeiro do Sul", "Sul", "12234809");
		Endereco rua1043 = new Endereco(null, "Rua Amélia Maria da Conceição", "Jardim Cruzeiro do Sul", "Sul",
				"12234810");
		Endereco rua1044 = new Endereco(null, "Rua Fernando Bráulio de Melo", "Jardim Cruzeiro do Sul", "Sul",
				"12234811");
		Endereco rua1045 = new Endereco(null, "Rua Romeu Gonçalves Mendes", "Jardim Cruzeiro do Sul", "Sul",
				"12234812");
		Endereco rua1046 = new Endereco(null, "Rua Honorato Gonçalves Teixeira", "Jardim Cruzeiro do Sul", "Sul",
				"12234813");
		Endereco rua1047 = new Endereco(null, "Rua José Eduardo Ferreira dos Santos", "Jardim Cruzeiro do Sul", "Sul",
				"12234814");
		Endereco rua1048 = new Endereco(null, "Rua João Francisco da Silva", "Jardim Cruzeiro do Sul", "Sul",
				"12234815");
		Endereco rua1049 = new Endereco(null, "Rua Francisco Alexandre Buck", "Jardim Cruzeiro do Sul", "Sul",
				"12234816");
		Endereco rua1050 = new Endereco(null, "Rua Theodoro José Sampaio", "Jardim Cruzeiro do Sul", "Sul", "12234817");
		Endereco rua1051 = new Endereco(null, "Rua Sebastião Borges Leal", "Jardim Cruzeiro do Sul", "Sul", "12234818");
		Endereco rua1052 = new Endereco(null, "Avenida Doutor Amin Simão", "Jardim da Granja", "Sudeste", "12227001");
		Endereco rua1053 = new Endereco(null, "Avenida dos Astronautas", "Jardim da Granja", "Sudeste", "12227010");
		Endereco rua1054 = new Endereco(null, "Rua Madre Maria Gema de Jesus", "Jardim da Granja", "Sudeste",
				"12227180");
		Endereco rua1055 = new Endereco(null, "Rua José Alves Moreira", "Jardim da Granja", "Sudeste", "12227190");
		Endereco rua1056 = new Endereco(null, "Rua Odete Mimessi", "Jardim da Granja", "Sudeste", "12227200");
		Endereco rua1057 = new Endereco(null, "Rua Primo Betti", "Jardim da Granja", "Sudeste", "12227210");
		Endereco rua1058 = new Endereco(null, "Rua Carolina Antunes Stetener", "Jardim da Granja", "Sudeste",
				"12227220");
		Endereco rua1059 = new Endereco(null, "Praça Hélio Dias", "Jardim da Granja", "Sudeste", "12227230");
		Endereco rua1060 = new Endereco(null, "Rua Orlando Saes", "Jardim da Granja", "Sudeste", "12227240");
		Endereco rua1061 = new Endereco(null, "Rua Herminio José Friggi", "Jardim da Granja", "Sudeste", "12227250");
		Endereco rua1062 = new Endereco(null, "Rua Dom Gabriel Paulino Bueno do Couto", "Jardim da Granja", "Sudeste",
				"12227260");
		Endereco rua1063 = new Endereco(null, "Rua José Busato", "Jardim da Granja", "Sudeste", "12227270");
		Endereco rua1064 = new Endereco(null, "Rua Centaurus", "Jardim da Granja", "Sudeste", "12227280");
		Endereco rua1065 = new Endereco(null, "Praça Áquila", "Jardim da Granja", "Sudeste", "12227290");
		Endereco rua1066 = new Endereco(null, "Rua Fênix", "Jardim da Granja", "Sudeste", "12227300");
		Endereco rua1067 = new Endereco(null, "Rua Sagitarios", "Jardim da Granja", "Sudeste", "12227310");
		Endereco rua1068 = new Endereco(null, "Rua Aquarius", "Jardim da Granja", "Sudeste", "12227320");
		Endereco rua1069 = new Endereco(null, "Rua Áries", "Jardim da Granja", "Sudeste", "12227330");
		Endereco rua1070 = new Endereco(null, "Rua Taurus", "Jardim da Granja", "Sudeste", "12227340");
		Endereco rua1071 = new Endereco(null, "Rua Orion", "Jardim da Granja", "Sudeste", "12227350");
		Endereco rua1072 = new Endereco(null, "Praça Hércules", "Jardim da Granja", "Sudeste", "12227360");
		Endereco rua1073 = new Endereco(null, "Rua Capricórnio", "Jardim da Granja", "Sudeste", "12227370");
		Endereco rua1074 = new Endereco(null, "Rua Netuno", "Jardim da Granja", "Sudeste", "12227380");
		Endereco rua1075 = new Endereco(null, "Rua Hidra", "Jardim da Granja", "Sudeste", "12227390");
		Endereco rua1076 = new Endereco(null, "Rua Lupus", "Jardim da Granja", "Sudeste", "12227400");
		Endereco rua1077 = new Endereco(null, "Rua Lince", "Jardim da Granja", "Sudeste", "12227410");
		Endereco rua1078 = new Endereco(null, "Rua Vênus", "Jardim da Granja", "Sudeste", "12227420");
		Endereco rua1079 = new Endereco(null, "Praça Marte", "Jardim da Granja", "Sudeste", "12227430");
		Endereco rua1080 = new Endereco(null, "Rua Plutão", "Jardim da Granja", "Sudeste", "12227440");
		Endereco rua1081 = new Endereco(null, "Rua Vesta", "Jardim da Granja", "Sudeste", "12227450");
		Endereco rua1082 = new Endereco(null, "Rua Jupiter", "Jardim da Granja", "Sudeste", "12227460");
		Endereco rua1083 = new Endereco(null, "Rua Juno", "Jardim da Granja", "Sudeste", "12227470");
		Endereco rua1084 = new Endereco(null, "Rua Saturno", "Jardim da Granja", "Sudeste", "12227480");
		Endereco rua1085 = new Endereco(null, "Rua Ceres", "Jardim da Granja", "Sudeste", "12227490");
		Endereco rua1086 = new Endereco(null, "Rua Palas", "Jardim da Granja", "Sudeste", "12227500");
		Endereco rua1087 = new Endereco(null, "Praça Columba", "Jardim da Granja", "Sudeste", "12227510");
		Endereco rua1088 = new Endereco(null, "Rua Urano", "Jardim da Granja", "Sudeste", "12227520");
		Endereco rua1089 = new Endereco(null, "Rua Mercúrio", "Jardim da Granja", "Sudeste", "12227530");
		Endereco rua1090 = new Endereco(null, "Avenida Brigadeiro Faria Lima", " 1758", "Jardim da Granja", "Sudeste");
		Endereco rua1091 = new Endereco(null, "Avenida Doutor João Batista Soares de Queiroz Júnior",
				"Jardim das Indústrias", "Oeste", "12240000");
		Endereco rua1092 = new Endereco(null, "Rua Braúlio de Melo", "Jardim das Indústrias", "Oeste", "12240001");
		Endereco rua1093 = new Endereco(null, "Praça da Criança", "Jardim das Indústrias", "Oeste", "12240002");
		Endereco rua1094 = new Endereco(null, "Praça Professor Hélio Augusto de Souza", "Jardim das Indústrias",
				"Oeste", "12240003");
		Endereco rua1095 = new Endereco(null, "Rua das Amariliseas", "Jardim das Indústrias", "Oeste", "12240010");
		Endereco rua1096 = new Endereco(null, "Rua dos Cravos", "Jardim das Indústrias", "Oeste", "12240020");
		Endereco rua1097 = new Endereco(null, "Rua dos Alecrins", "Jardim das Indústrias", "Oeste", "12240030");
		Endereco rua1098 = new Endereco(null, "Rua das Felandrias", "Jardim das Indústrias", "Oeste", "12240040");
		Endereco rua1099 = new Endereco(null, "Rua das Artimisias", "Jardim das Indústrias", "Oeste", "12240050");
		Endereco rua1100 = new Endereco(null, "Rua João Ramos de Andrade", "Jardim das Indústrias", "Oeste",
				"12240060");
		Endereco rua1101 = new Endereco(null, "Rua Guarulhos", "Jardim das Indústrias", "Oeste", "12240070");
		Endereco rua1102 = new Endereco(null, "Rua dos Jacintos", "Jardim das Indústrias", "Oeste", "12240071");
		Endereco rua1103 = new Endereco(null, "Rua das Mamonas", "Jardim das Indústrias", "Oeste", "12240072");
		Endereco rua1104 = new Endereco(null, "Rua das Ambrósias", "Jardim das Indústrias", "Oeste", "12240080");
		Endereco rua1105 = new Endereco(null, "Rua Trajano Vieira de Macedo", "Jardim das Indústrias", "Oeste",
				"12240090");
		Endereco rua1106 = new Endereco(null, "Rua das Rogerias", "Jardim das Indústrias", "Oeste", "12240100");
		Endereco rua1107 = new Endereco(null, "Rua dos Lilazes", "Jardim das Indústrias", "Oeste", "12240110");
		Endereco rua1108 = new Endereco(null, "Rua das Crisandálias", "Jardim das Indústrias", "Oeste", "12240120");
		Endereco rua1109 = new Endereco(null, "Rua das Quaresmeiras", "Jardim das Indústrias", "Oeste", "12240130");
		Endereco rua1110 = new Endereco(null, "Rua das Açucenas", "Jardim das Indústrias", "Oeste", "12240140");
		Endereco rua1111 = new Endereco(null, "Rua dos Amores-Perfeitos", "Jardim das Indústrias", "Oeste", "12240150");
		Endereco rua1112 = new Endereco(null, "Rua Pirassununga", "Jardim das Indústrias", "Oeste", "12240160");
		Endereco rua1113 = new Endereco(null, "Rua Manoel Alves Cardoso", "Jardim das Indústrias", "Oeste", "12240170");
		Endereco rua1114 = new Endereco(null, "Rua Aimbire", "Jardim das Indústrias", "Oeste", "12240171");
		Endereco rua1115 = new Endereco(null, "Rua Leme", "Jardim das Indústrias", "Oeste", "12240180");
		Endereco rua1116 = new Endereco(null, "Rua Barretos", "Jardim das Indústrias", "Oeste", "12240190");
		Endereco rua1117 = new Endereco(null, "Rua Olímpia", "Jardim das Indústrias", "Oeste", "12240200");
		Endereco rua1118 = new Endereco(null, "Rua Arealva", "Jardim das Indústrias", "Oeste", "12240210");
		Endereco rua1119 = new Endereco(null, "Rua Nelson César de Oliveira", "Jardim das Indústrias", "Oeste",
				"12240220");
		Endereco rua1120 = new Endereco(null, "Rua São Carlos", "Jardim das Indústrias", "Oeste", "12240230");
		Endereco rua1121 = new Endereco(null, "Rua Matão", "Jardim das Indústrias", "Oeste", "12240240");
		Endereco rua1122 = new Endereco(null, "Rua Ibitinga", "Jardim das Indústrias", "Oeste", "12240250");
		Endereco rua1123 = new Endereco(null, "Rua Adamantina", "Jardim das Indústrias", "Oeste", "12240260");
		Endereco rua1124 = new Endereco(null, "Rua Araraquara", "Jardim das Indústrias", "Oeste", "12240270");
		Endereco rua1125 = new Endereco(null, "Rua Andradina", "Jardim das Indústrias", "Oeste", "12240280");
		Endereco rua1126 = new Endereco(null, "Rua Dracena", "Jardim das Indústrias", "Oeste", "12240290");
		Endereco rua1127 = new Endereco(null, "Rua Birigüi", "Jardim das Indústrias", "Oeste", "12240300");
		Endereco rua1128 = new Endereco(null, "Rua Presidente Epitâcio", "Jardim das Indústrias", "Oeste", "12240310");
		Endereco rua1129 = new Endereco(null, "Rua Presidente Alves", "Jardim das Indústrias", "Oeste", "12240320");
		Endereco rua1130 = new Endereco(null, "Rua Walter de Alencar Costa", "Jardim das Indústrias", "Oeste",
				"12240330");
		Endereco rua1131 = new Endereco(null, "Rua Professor Henrique Jorge Guedes", "Jardim das Indústrias", "Oeste",
				"12240340");
		Endereco rua1132 = new Endereco(null, "Rua das Zineas", "Jardim das Indústrias", "Oeste", "12240350");
		Endereco rua1133 = new Endereco(null, "Rua dos Girassóis", "Jardim das Indústrias", "Oeste", "12240360");
		Endereco rua1134 = new Endereco(null, "Rua das Madressilvas", "Jardim das Indústrias", "Oeste", "12240370");
		Endereco rua1135 = new Endereco(null, "Rua das Malvas", "Jardim das Indústrias", "Oeste", "12240380");
		Endereco rua1136 = new Endereco(null, "Rua dos Antúrios", "Jardim das Indústrias", "Oeste", "12240390");
		Endereco rua1137 = new Endereco(null, "Rua das Palmas", "Jardim das Indústrias", "Oeste", "12240400");
		Endereco rua1138 = new Endereco(null, "Rua das Valerianas", "Jardim das Indústrias", "Oeste", "12240410");
		Endereco rua1139 = new Endereco(null, "Rodovia Presidente Dutra", "Jardim das Indústrias", "Oeste", "12240420");
		Endereco rua1140 = new Endereco(null, "Rua Tenente Virgílio de Abreu Bolina", "Jardim das Indústrias", "Oeste",
				"12240430");
		Endereco rua1141 = new Endereco(null, "Rua dos Crisântemos", "Jardim das Indústrias", "Oeste", "12240440");
		Endereco rua1142 = new Endereco(null, "Rua Bakhos Yossef Alwan", "Jardim das Indústrias", "Oeste", "12240450");
		Endereco rua1143 = new Endereco(null, "Rua das Lobelias", "Jardim das Indústrias", "Oeste", "12240460");
		Endereco rua1144 = new Endereco(null, "Rua Estefania do Nascimento", "Jardim das Indústrias", "Oeste",
				"12240470");
		Endereco rua1145 = new Endereco(null, "Rua Durvalina Simões", "Jardim das Indústrias", "Oeste", "12240480");
		Endereco rua1146 = new Endereco(null, "Rua Egle Carnevali", "Jardim das Indústrias", "Oeste", "12240490");
		Endereco rua1147 = new Endereco(null, "Rua Catanduva", "Jardim das Indústrias", "Oeste", "12240500");
		Endereco rua1148 = new Endereco(null, "Avenida Engenheiro Francisco Prestes Maia", "Jardim das Indústrias",
				"Oeste", "12240680");
		Endereco rua1149 = new Endereco(null, "Rua Winston Churchill", "Jardim das Indústrias", "Oeste", "12240681");
		Endereco rua1150 = new Endereco(null, "Rua Antônio Domingues Vasconcelos", "Jardim das Indústrias", "Oeste",
				"12240690");
		Endereco rua1151 = new Endereco(null, "Rua Glicério Paula Galvão", "Jardim das Indústrias", "Oeste",
				"12240700");
		Endereco rua1152 = new Endereco(null, "Rua Manoel Bandeira", "Jardim das Indústrias", "Oeste", "12240710");
		Endereco rua1153 = new Endereco(null, "Rua Francisco Braúlio Filho", "Jardim das Indústrias", "Oeste",
				"12240720");
		Endereco rua1154 = new Endereco(null, "Rua Manoel Pio", "Jardim das Indústrias", "Oeste", "12240730");
		Endereco rua1155 = new Endereco(null, "Rua Dona Maria Augusta Fagundes Gomes", "Jardim das Indústrias", "Oeste",
				"12240740");
		Endereco rua1156 = new Endereco(null, "Rua Francisco Aguade Gils", "Jardim das Indústrias", "Oeste",
				"12240750");
		Endereco rua1157 = new Endereco(null, "Rua Jad'alah Chedid Salomão", "Jardim das Indústrias", "Oeste",
				"12240751");
		Endereco rua1158 = new Endereco(null, "Rua Bernardo de Grabois", "Jardim das Indústrias", "Oeste", "12240760");
		Endereco rua1159 = new Endereco(null, "Rua Corifeu de Azevedo Marques", "Jardim das Indústrias", "Oeste",
				"12240780");
		Endereco rua1160 = new Endereco(null, "Rua Andirá", "Jardim das Indústrias", "Oeste", "12240781");
		Endereco rua1161 = new Endereco(null, "Rodovia Presidente Dutra", " s/n", "Jardim das Indústrias", "Oeste");
		Endereco rua1162 = new Endereco(null, "Rodovia Presidente Dutra", " s/n", "Jardim das Indústrias", "Oeste");
		Endereco rua1163 = new Endereco(null, "Rodovia Presidente Dutra", " Km 154", "Jardim das Indústrias", "Oeste");
		Endereco rua1164 = new Endereco(null, "Rodovia Presidente Dutra", " Km 154", "Jardim das Indústrias", "Oeste");
		Endereco rua1165 = new Endereco(null, "Rodovia Presidente Dutra", " Km 154", "Jardim das Indústrias", "Oeste");
		Endereco rua1166 = new Endereco(null, "Rua Heitor de Andrade", "Jardim das Indústrias", "Oeste", "12241000");
		Endereco rua1167 = new Endereco(null, "Rua Leôncio Americano do Nascimento", "Jardim das Indústrias", "Oeste",
				"12241010");
		Endereco rua1168 = new Endereco(null, "Rua Benedito da Silva Maia", "Jardim das Indústrias", "Oeste",
				"12241020");
		Endereco rua1169 = new Endereco(null, "Rua Augusto Frederico Schimidt", "Jardim das Indústrias", "Oeste",
				"12241030");
		Endereco rua1170 = new Endereco(null, "Rua Corifeu de Azevedo Marques", "Jardim das Indústrias", "Oeste",
				"12241040");
		Endereco rua1171 = new Endereco(null, "Rua Ibate", "Jardim das Indústrias", "Oeste", "12241050");
		Endereco rua1172 = new Endereco(null, "Avenida Rio Claro", "Jardim das Indústrias", "Oeste", "12241060");
		Endereco rua1173 = new Endereco(null, "Rua Manoel Bosco Ribeiro", "Jardim das Indústrias", "Oeste", "12241070");
		Endereco rua1174 = new Endereco(null, "Rua Penápolis", "Jardim das Indústrias", "Oeste", "12241080");
		Endereco rua1175 = new Endereco(null, "Rua das Paineiras", "Jardim das Indústrias", "Oeste", "12241090");
		Endereco rua1176 = new Endereco(null, "Praça Flamboyant", "Jardim das Indústrias", "Oeste", "12241100");
		Endereco rua1177 = new Endereco(null, "Rua Registro", "Jardim das Indústrias", "Oeste", "12241110");
		Endereco rua1178 = new Endereco(null, "Rua Pitangueiras", "Jardim das Indústrias", "Oeste", "12241120");
		Endereco rua1179 = new Endereco(null, "Rua Tambaú", "Jardim das Indústrias", "Oeste", "12241130");
		Endereco rua1180 = new Endereco(null, "Rua Descalvado", "Jardim das Indústrias", "Oeste", "12241140");
		Endereco rua1181 = new Endereco(null, "Rua Osasco", "Jardim das Indústrias", "Oeste", "12241150");
		Endereco rua1182 = new Endereco(null, "Rua Sibipiruna", "Jardim das Indústrias", "Oeste", "12241160");
		Endereco rua1183 = new Endereco(null, "Rua Mamede Alves Cardoso", "Jardim das Indústrias", "Oeste", "12241170");
		Endereco rua1184 = new Endereco(null, "Rua das Seringueiras", "Jardim das Indústrias", "Oeste", "12241180");
		Endereco rua1185 = new Endereco(null, "Rua dos Cajueiros", "Jardim das Indústrias", "Oeste", "12241190");
		Endereco rua1186 = new Endereco(null, "Rua Emílio Marelo", "Jardim das Indústrias", "Oeste", "12241200");
		Endereco rua1187 = new Endereco(null, "Rua Imbuia", "Jardim das Indústrias", "Oeste", "12241210");
		Endereco rua1188 = new Endereco(null, "Rua Ipê", "Jardim das Indústrias", "Oeste", "12241220");
		Endereco rua1189 = new Endereco(null, "Rua Peroba", "Jardim das Indústrias", "Oeste", "12241230");
		Endereco rua1190 = new Endereco(null, "Rua Jequitibá", "Jardim das Indústrias", "Oeste", "12241240");
		Endereco rua1191 = new Endereco(null, "Rua Jacarandá", "Jardim das Indústrias", "Oeste", "12241250");
		Endereco rua1192 = new Endereco(null, "Rua dos Carvalhos", "Jardim das Indústrias", "Oeste", "12241260");
		Endereco rua1193 = new Endereco(null, "Rua Cedro", "Jardim das Indústrias", "Oeste", "12241270");
		Endereco rua1194 = new Endereco(null, "Rua Lazio", "Jardim das Paineiras I", "Leste", "12226083");
		Endereco rua1195 = new Endereco(null, "Rua Emilia-Romagna", "Jardim das Paineiras I", "Leste", "12226084");
		Endereco rua1196 = new Endereco(null, "Rua Veneto", "Jardim das Paineiras I", "Leste", "12226085");
		Endereco rua1197 = new Endereco(null, "Rua Liguria", "Jardim das Paineiras I", "Leste", "12226086");
		Endereco rua1198 = new Endereco(null, "Rua Friuli", "Jardim das Paineiras I", "Leste", "12226087");
		Endereco rua1199 = new Endereco(null, "Rua Lombardia", "Jardim das Paineiras I", "Leste", "12226088");
		Endereco rua1200 = new Endereco(null, "Rua Toscana", "Jardim das Paineiras I", "Leste", "12226089");
		Endereco rua1201 = new Endereco(null, "Rua Marche", "Jardim das Paineiras I", "Leste", "12226091");
		Endereco rua1202 = new Endereco(null, "Rua Trentino", "Jardim das Paineiras I", "Leste", "12226092");
		Endereco rua1203 = new Endereco(null, "Rua Seis", "Jardim das Paineiras I", "Leste", "12226093");
		Endereco rua1204 = new Endereco(null, "Rua Onze", "Jardim das Paineiras I", "Leste", "12226094");
		Endereco rua1205 = new Endereco(null, "Rua Doze", "Jardim das Paineiras I", "Leste", "12226095");
		Endereco rua1206 = new Endereco(null, "Avenida Sinaloa", "Jardim das Paineiras II", "Leste", "12226101");
		Endereco rua1207 = new Endereco(null, "Rua Los Mochis", "Jardim das Paineiras II", "Leste", "12226102");
		Endereco rua1208 = new Endereco(null, "Rua Borgofranco", "Jardim das Paineiras II", "Leste", "12226103");
		Endereco rua1209 = new Endereco(null, "Rua Zacatecas", "Jardim das Paineiras II", "Leste", "12226104");
		Endereco rua1210 = new Endereco(null, "Rua Durango", "Jardim das Paineiras II", "Leste", "12226105");
		Endereco rua1211 = new Endereco(null, "Rua Piemonte", "Jardim das Paineiras II", "Leste", "12226106");
		Endereco rua1212 = new Endereco(null, "Rua Cuernavaca", "Jardim das Paineiras II", "Leste", "12226107");
		Endereco rua1213 = new Endereco(null, "Rua Guadalajara", "Jardim das Paineiras II", "Leste", "12226108");
		Endereco rua1214 = new Endereco(null, "Rua Torino", "Jardim das Paineiras II", "Leste", "12226109");
		Endereco rua1215 = new Endereco(null, "Rua Monterrey", "Jardim das Paineiras II", "Leste", "12226112");
		Endereco rua1216 = new Endereco(null, "Rua Morelos", "Jardim das Paineiras II", "Leste", "12226113");
		Endereco rua1217 = new Endereco(null, "Rua Culiacán", "Jardim das Paineiras II", "Leste", "12226114");
		Endereco rua1218 = new Endereco(null, "Rua Manoel dos Santos Cabral", "Jardim Del Rey", "Sul", "12232231");
		Endereco rua1219 = new Endereco(null, "Rua Maria José Gonçalves", "Jardim Del Rey", "Sul", "12232232");
		Endereco rua1220 = new Endereco(null, "Rua João Benitez Gimenez", "Jardim Del Rey", "Sul", "12232233");
		Endereco rua1221 = new Endereco(null, "Rua João Cassiano da Silva", "Jardim Del Rey", "Sul", "12232234");
		Endereco rua1222 = new Endereco(null, "Rua João Rodrigues de Oliveira Figueiredo", "Jardim Del Rey", "Sul",
				"12232235");
		Endereco rua1223 = new Endereco(null, "Rua Cleto dos Santos", "Jardim Del Rey", "Sul", "12232236");
		Endereco rua1224 = new Endereco(null, "Rua Mário de Paula Ferreira", "Jardim Del Rey", "Sul", "12232237");
		Endereco rua1225 = new Endereco(null, "Rua Agenor Xavier de Oliveira", "Jardim Del Rey", "Sul", "12232238");
		Endereco rua1226 = new Endereco(null, "Rua José Bonifácio de Oliveira", "Jardim Del Rey", "Sul", "12232239");
		Endereco rua1227 = new Endereco(null, "Rua Noêmio Arruda de Carvalho", "Jardim Diamante", "Leste", "12223110");
		Endereco rua1228 = new Endereco(null, "Rua Plínio de Andrade", "Jardim Diamante", "Leste", "12223120");
		Endereco rua1229 = new Endereco(null, "Rua José Cândido de Melo", "Jardim Diamante", "Leste", "12223130");
		Endereco rua1230 = new Endereco(null, "Rua Gregório Gurevich", "Jardim Diamante", "Leste", "12223140");
		Endereco rua1231 = new Endereco(null, "Rua José Locatelli", "Jardim Diamante", "Leste", "12223150");
		Endereco rua1232 = new Endereco(null, "Rua Coronel Eurico Costa Souza", "Jardim Diamante", "Leste", "12223160");
		Endereco rua1233 = new Endereco(null, "Praça João Batista Peneluppi", "Jardim Diamante", "Leste", "12223170");
		Endereco rua1234 = new Endereco(null, "Rua Professora Ana Isabel Barbosa", "Jardim Diamante", "Leste",
				"12223180");
		Endereco rua1235 = new Endereco(null, "Rua Francisco Camilo", "Jardim Diamante", "Leste", "12223190");
		Endereco rua1236 = new Endereco(null, "Rua Benedito Rodrigues da Silva", "Jardim Diamante", "Leste",
				"12223200");
		Endereco rua1237 = new Endereco(null, "Rodovia Presidente Dutra", "Jardim Diamante", "Leste", "12223201");
		Endereco rua1238 = new Endereco(null, "Rua Rosa Coulicoff Diamante", "Jardim Diamante", "Leste", "12223210");
		Endereco rua1239 = new Endereco(null, "Rua Moisés Kremer", "Jardim Diamante", "Leste", "12223211");
		Endereco rua1240 = new Endereco(null, "Rua Benedita Cantinho de Moura", "Jardim do Céu", "Sul", "12236290");
		Endereco rua1241 = new Endereco(null, "Rua Cecília Simão", "Jardim do Céu", "Sul", "12236320");
		Endereco rua1242 = new Endereco(null, "Rua Belmiro Andrade", "Jardim do Céu", "Sul", "12236340");
		Endereco rua1243 = new Endereco(null, "Rua Antônio Chrispim Machado", "Jardim do Céu", "Sul", "12236350");
		Endereco rua1244 = new Endereco(null, "Rua Synesio Luiz Paiva Sapucahy", "Jardim do Céu", "Sul", "12236360");
		Endereco rua1245 = new Endereco(null, "Rua Nelson Costa", "Jardim do Céu", "Sul", "12236370");
		Endereco rua1246 = new Endereco(null, "Avenida Arnaldo dos Santos Cerdeira", "Jardim do Céu", "Sul",
				"12236380");
		Endereco rua1247 = new Endereco(null, "Praça Luiz Vaz de Camões", "Jardim do Céu", "Sul", "12236381");
		Endereco rua1248 = new Endereco(null, "Avenida Visconde de Pelotas", "Jardim do Lago", "Sudeste", "12228020");
		Endereco rua1249 = new Endereco(null, "Praça Hélio de Souza Lino", "Jardim do Lago", "Sudeste", "12228023");
		Endereco rua1250 = new Endereco(null, "Rua Visconde de São Lourenço", "Jardim do Lago", "Sudeste", "12228030");
		Endereco rua1251 = new Endereco(null, "Rua Visconde de Lamare", "Jardim do Lago", "Sudeste", "12228040");
		Endereco rua1252 = new Endereco(null, "Avenida Visconde de Caravelas", "Jardim do Lago", "Sudeste", "12228050");
		Endereco rua1253 = new Endereco(null, "Rua Visconde de Araxá", "Jardim do Lago", "Sudeste", "12228060");
		Endereco rua1254 = new Endereco(null, "Rua Visconde de Inhauma", "Jardim do Lago", "Sudeste", "12228070");
		Endereco rua1255 = new Endereco(null, "Avenida Um", "Jardim dos Bandeirantes", "Sul", "12234785");
		Endereco rua1256 = new Endereco(null, "Avenida Dois", "Jardim dos Bandeirantes", "Sul", "12234786");
		Endereco rua1257 = new Endereco(null, "Rua Benedito Ferreira dos Santos", "Jardim dos Bandeirantes", "Sul",
				"12234787");
		Endereco rua1258 = new Endereco(null, "Rua Osvaldo Gonçalves Toledo", "Jardim dos Bandeirantes", "Sul",
				"12234788");
		Endereco rua1259 = new Endereco(null, "Rua João da Rosa Alves", "Jardim dos Bandeirantes", "Sul", "12234789");
		Endereco rua1260 = new Endereco(null, "Rua Luiz Roberto dos Santos", "Jardim dos Bandeirantes", "Sul",
				"12234790");
		Endereco rua1261 = new Endereco(null, "Rua Urbano Ezequiel das Neves", "Jardim dos Bandeirantes", "Sul",
				"12234791");
		Endereco rua1262 = new Endereco(null, "Rua Benedita Marques das Neves", "Jardim dos Bandeirantes", "Sul",
				"12234792");
		Endereco rua1263 = new Endereco(null, "Rua Amado Conceição Silva Rosário", "Jardim dos Bandeirantes", "Sul",
				"12234793");
		Endereco rua1264 = new Endereco(null, "Rua Waldemar Oliveira", "Jardim dos Bandeirantes", "Sul", "12234794");
		Endereco rua1265 = new Endereco(null, "Rua Valentina da Conceição", "Jardim dos Bandeirantes", "Sul",
				"12234795");
		Endereco rua1266 = new Endereco(null, "Rua Claudnei Marcondes Cordeiro", "Jardim dos Bandeirantes", "Sul",
				"12234796");
		Endereco rua1267 = new Endereco(null, "Rua Toshiyassu Watanabe", "Jardim dos Bandeirantes", "Sul", "12234797");
		Endereco rua1268 = new Endereco(null, "Rua Isamu Hayashi", "Jardim dos Bandeirantes", "Sul", "12234798");
		Endereco rua1269 = new Endereco(null, "Rua Francisco Cassiano de Pontes", "Jardim dos Bandeirantes", "Sul",
				"12234799");
		Endereco rua1270 = new Endereco(null, "Rua Afonso Sardinha", "Jardim Esplanada", "Centro", "12242310");
		Endereco rua1271 = new Endereco(null, "Rua Pascoal Moreira", "Jardim Esplanada", "Centro", "12242311");
		Endereco rua1272 = new Endereco(null, "Rua Ana Maria Nardo Silva", "Jardim Esplanada", "Centro", "12242410");
		Endereco rua1273 = new Endereco(null, "Viaduto Reverendo José Pereira da Costa", "Jardim Esplanada", "Centro",
				"12242411");
		Endereco rua1274 = new Endereco(null, "Rotatória Monsenhor José Maria Escrivã", "Jardim Esplanada", "Centro",
				"12242412");
		Endereco rua1275 = new Endereco(null, "Rua Bartolomeu de Gusmão", "Jardim Esplanada", "Centro", "12242420");
		Endereco rua1276 = new Endereco(null, "Travessa Duque Estrada", "Jardim Esplanada", "Centro", "12242430");
		Endereco rua1277 = new Endereco(null, "Rua Laurent Martins", "Jardim Esplanada", "Centro", "12242431");
		Endereco rua1278 = new Endereco(null, "Rua Graça Aranha", "Jardim Esplanada", "Centro", "12242440");
		Endereco rua1279 = new Endereco(null, "Travessa Graça Aranha", "Jardim Esplanada", "Centro", "12242441");
		Endereco rua1280 = new Endereco(null, "Rua Carlos Sattelmayer", "Jardim Esplanada", "Centro", "12242450");
		Endereco rua1281 = new Endereco(null, "Rua Professor Roberval Froes", "Jardim Esplanada", "Centro", "12242460");
		Endereco rua1282 = new Endereco(null, "Avenida Paulista", "Jardim Esplanada", "Centro", "12242470");
		Endereco rua1283 = new Endereco(null, "Praça Floripes Bicudo Martins", "Jardim Esplanada", "Centro",
				"12242471");
		Endereco rua1284 = new Endereco(null, "Rua Professora Aparecida Azevedo Branco", "Jardim Esplanada", "Centro",
				"12242480");
		Endereco rua1285 = new Endereco(null, "Rua Henrique Mudat", "Jardim Esplanada", "Centro", "12242490");
		Endereco rua1286 = new Endereco(null, "Rua Irmã Maria Demetria Kfuri", "Jardim Esplanada", "Centro",
				"12242500");
		Endereco rua1287 = new Endereco(null, "Rua Nicola Lafaif", "Jardim Esplanada", "Centro", "12242520");
		Endereco rua1288 = new Endereco(null, "Travessa Nossa Senhora Auxiliadora", "Jardim Esplanada", "Centro",
				"12242521");
		Endereco rua1289 = new Endereco(null, "Rua João Bicudo", "Jardim Esplanada", "Centro", "12242530");
		Endereco rua1290 = new Endereco(null, "Rua Carlos de Campos", "Jardim Esplanada", "Centro", "12242540");
		Endereco rua1291 = new Endereco(null, "Travessa Felipe Camarão", "Jardim Esplanada", "Centro", "12242541");
		Endereco rua1292 = new Endereco(null, "Rua Victor Antônio Celeste", "Jardim Esplanada", "Centro", "12242550");
		Endereco rua1293 = new Endereco(null, "Praça Bartolomeu Bueno da Silva", "Jardim Esplanada", "Centro",
				"12242551");
		Endereco rua1294 = new Endereco(null, "Rua Joaquim de Moura Candelaria", "Jardim Esplanada", "Centro",
				"12242560");
		Endereco rua1295 = new Endereco(null, "Rua Doutor Fernando Costa", "Jardim Esplanada", "Centro", "12242570");
		Endereco rua1296 = new Endereco(null, "Rua Domingos Jorge Velho", "Jardim Esplanada", "Centro", "12242620");
		Endereco rua1297 = new Endereco(null, "Rua Antônio Dias Adorno", "Jardim Esplanada II", "Centro", "12242630");
		Endereco rua1298 = new Endereco(null, "Rua Sebastião Tourinho", "Jardim Esplanada II", "Centro", "12242640");
		Endereco rua1299 = new Endereco(null, "Rua Garcia Rodrigues Paes", "Jardim Esplanada II", "Centro", "12242641");
		Endereco rua1300 = new Endereco(null, "Rua Benedito da Silva Ramos", "Jardim Esplanada II", "Centro",
				"12242650");
		Endereco rua1301 = new Endereco(null, "Rua Leopoldo Rossi", "Jardim Esplanada II", "Centro", "12242660");
		Endereco rua1302 = new Endereco(null, "Travessa Maria Quitéria", "Jardim Esplanada II", "Centro", "12242671");
		Endereco rua1303 = new Endereco(null, "Rua dos Andradas", "Jardim Esplanada II", "Centro", "12242680");
		Endereco rua1304 = new Endereco(null, "Rua Barão de Mauá", "Jardim Esplanada II", "Centro", "12242690");
		Endereco rua1305 = new Endereco(null, "Praça Sinésio Martins", "Jardim Esplanada II", "Centro", "12242700");
		Endereco rua1306 = new Endereco(null, "Rua Pandiá Calógeras", "Jardim Esplanada II", "Centro", "12242710");
		Endereco rua1307 = new Endereco(null, "Rua Vital Brasil", "Jardim Esplanada II", "Centro", "12242720");
		Endereco rua1308 = new Endereco(null, "Rua Carlos Chagas", "Jardim Esplanada II", "Centro", "12242730");
		Endereco rua1309 = new Endereco(null, "Rua Marcilio Dias", "Jardim Esplanada II", "Centro", "12242731");
		Endereco rua1310 = new Endereco(null, "Rua Antônio de Queiroz Filho", "Jardim Esplanada II", "Centro",
				"12242740");
		Endereco rua1311 = new Endereco(null, "Rua Pio XII", "Jardim Esplanada II", "Centro", "12242750");
		Endereco rua1312 = new Endereco(null, "Rua Artur Neiva", "Jardim Esplanada II", "Centro", "12242760");
		Endereco rua1313 = new Endereco(null, "Rua Humberto de Campos", "Jardim Esplanada II", "Centro", "12242770");
		Endereco rua1314 = new Endereco(null, "Rua Presidente Wenceslau Braz", "Jardim Esplanada II", "Centro",
				"12242780");
		Endereco rua1315 = new Endereco(null, "Rua Clóvis Bevilacqua", "Jardim Esplanada II", "Centro", "12242790");
		Endereco rua1316 = new Endereco(null, "Avenida Barão do Rio Branco", "Jardim Esplanada II", "Centro",
				"12242800");
		Endereco rua1317 = new Endereco(null, "Rua Coronel Manoel Martins Júnior", "Jardim Esplanada II", "Centro",
				"12242810");
		Endereco rua1318 = new Endereco(null, "Travessa Pedro Dellias", "Jardim Esplanada II", "Centro", "12242820");
		Endereco rua1319 = new Endereco(null, "Praça Pedro David", "Jardim Esplanada II", "Centro", "12242830");
		Endereco rua1320 = new Endereco(null, "Avenida São João", "Jardim Esplanada", "Centro", "12242840");
		Endereco rua1321 = new Endereco(null, "Bulevar Villa-Lobos", " 41", "Jardim Esplanada", "Centro");
		Endereco rua1322 = new Endereco(null, "Avenida São João", " s/n", "Jardim Esplanada", "Centro");
		Endereco rua1323 = new Endereco(null, "Avenida São João", " 323", "Jardim Esplanada", "Centro");
		Endereco rua1324 = new Endereco(null, "Avenida São João", " 748", "Jardim Esplanada", "Centro");
		Endereco rua1325 = new Endereco(null, "Avenida São João", " 69", "Jardim Esplanada", "Centro");
		Endereco rua1326 = new Endereco(null, "Rua Antônio Dias Adorno", "Jardim Esplanada II", "Centro", "12242630");
		Endereco rua1327 = new Endereco(null, "Rua Sebastião Tourinho", "Jardim Esplanada II", "Centro", "12242640");
		Endereco rua1328 = new Endereco(null, "Rua Garcia Rodrigues Paes", "Jardim Esplanada II", "Centro", "12242641");
		Endereco rua1329 = new Endereco(null, "Rua Benedito da Silva Ramos", "Jardim Esplanada II", "Centro",
				"12242650");
		Endereco rua1330 = new Endereco(null, "Rua Leopoldo Rossi", "Jardim Esplanada II", "Centro", "12242660");
		Endereco rua1331 = new Endereco(null, "Travessa Maria Quitéria", "Jardim Esplanada II", "Centro", "12242671");
		Endereco rua1332 = new Endereco(null, "Rua dos Andradas", "Jardim Esplanada II", "Centro", "12242680");
		Endereco rua1333 = new Endereco(null, "Rua Barão de Mauá", "Jardim Esplanada II", "Centro", "12242690");
		Endereco rua1334 = new Endereco(null, "Praça Sinésio Martins", "Jardim Esplanada II", "Centro", "12242700");
		Endereco rua1335 = new Endereco(null, "Rua Pandiá Calógeras", "Jardim Esplanada II", "Centro", "12242710");
		Endereco rua1336 = new Endereco(null, "Rua Vital Brasil", "Jardim Esplanada II", "Centro", "12242720");
		Endereco rua1337 = new Endereco(null, "Rua Carlos Chagas", "Jardim Esplanada II", "Centro", "12242730");
		Endereco rua1338 = new Endereco(null, "Rua Marcilio Dias", "Jardim Esplanada II", "Centro", "12242731");
		Endereco rua1339 = new Endereco(null, "Rua Antônio de Queiroz Filho", "Jardim Esplanada II", "Centro",
				"12242740");
		Endereco rua1340 = new Endereco(null, "Rua Pio XII", "Jardim Esplanada II", "Centro", "12242750");
		Endereco rua1341 = new Endereco(null, "Rua Artur Neiva", "Jardim Esplanada II", "Centro", "12242760");
		Endereco rua1342 = new Endereco(null, "Rua Humberto de Campos", "Jardim Esplanada II", "Centro", "12242770");
		Endereco rua1343 = new Endereco(null, "Rua Presidente Wenceslau Braz", "Jardim Esplanada II", "Centro",
				"12242780");
		Endereco rua1344 = new Endereco(null, "Rua Clóvis Bevilacqua", "Jardim Esplanada II", "Centro", "12242790");
		Endereco rua1345 = new Endereco(null, "Avenida Barão do Rio Branco", "Jardim Esplanada II", "Centro",
				"12242800");
		Endereco rua1346 = new Endereco(null, "Rua Coronel Manoel Martins Júnior", "Jardim Esplanada II", "Centro",
				"12242810");
		Endereco rua1347 = new Endereco(null, "Travessa Pedro Dellias", "Jardim Esplanada II", "Centro", "12242820");
		Endereco rua1348 = new Endereco(null, "Praça Pedro David", "Jardim Esplanada II", "Centro", "12242830");
		Endereco rua1349 = new Endereco(null, "Rua Zildo Pimentel", "Jardim Estoril", "Sul", "12232010");
		Endereco rua1350 = new Endereco(null, "Rua José Firmino de Moraes", "Jardim Estoril", "Sul", "12232020");
		Endereco rua1351 = new Endereco(null, "Rua Paulino Blair", "Jardim Estoril", "Sul", "12232030");
		Endereco rua1352 = new Endereco(null, "Rua Breno de Moura", "Jardim Estoril", "Sul", "12232040");
		Endereco rua1353 = new Endereco(null, "Rua André Plusplatais", "Jardim Estoril", "Sul", "12232045");
		Endereco rua1354 = new Endereco(null, "Rua Elmano Ferreira Veloso", "Jardim Estoril", "Sul", "12232050");
		Endereco rua1355 = new Endereco(null, "Rua José Marini", "Jardim Estoril", "Sul", "12232053");
		Endereco rua1356 = new Endereco(null, "Rua Doutor Décio Lemes Campos", "Jardim Estoril", "Sul", "12232057");
		Endereco rua1357 = new Endereco(null, "Rua José Ivair de Souza", "Jardim Estoril", "Sul", "12232060");
		Endereco rua1358 = new Endereco(null, "Rua José Maria de Lima", "Jardim Estoril", "Sul", "12232070");
		Endereco rua1359 = new Endereco(null, "Rua Rosaria Rodrigues Alonso", "Jardim Estoril", "Sul", "12232080");
		Endereco rua1360 = new Endereco(null, "Rua Maria Francisca dos Santos", "Jardim Guimarães", "Norte",
				"12213130");
		Endereco rua1361 = new Endereco(null, "Rua Jaguari", "Jardim Guimarães", "Norte", "12213131");
		Endereco rua1362 = new Endereco(null, "Rua José Prianti Chaves", "Jardim Guimarães", "Norte", "12213140");
		Endereco rua1363 = new Endereco(null, "Rua Francisco Rodrigues Cardoso", "Jardim Guimarães", "Norte",
				"12213145");
		Endereco rua1364 = new Endereco(null, "Rua Vera Babo de Oliveira", "Jardim Guimarães", "Norte", "12213150");
		Endereco rua1365 = new Endereco(null, "Rua Cecílio Corrá", "Jardim Guimarães", "Norte", "12213160");
		Endereco rua1366 = new Endereco(null, "Rua Fernando Corrá", "Jardim Guimarães", "Norte", "12213170");
		Endereco rua1367 = new Endereco(null, "Rua Benedito da Costa Andrade", "Jardim Guimarães", "Norte", "12213180");
		Endereco rua1368 = new Endereco(null, "Rua Francisco Ribeiro da Costa", "Jardim Guimarães", "Norte",
				"12213190");
		Endereco rua1369 = new Endereco(null, "Rua Francisco de Assis Monteiro de Barros", "Jardim Guimarães", "Norte",
				"12213200");
		Endereco rua1370 = new Endereco(null, "Avenida Tomezo Morino", "Loteamento Jardim Helena", "Leste", "12226681");
		Endereco rua1371 = new Endereco(null, "Rua Joaquim Maia da Silva", "Loteamento Jardim Helena", "Leste",
				"12226684");
		Endereco rua1372 = new Endereco(null, "Rua Severo Cesar Leite", "Loteamento Jardim Helena", "Leste",
				"12226687");
		Endereco rua1373 = new Endereco(null, "Rua Telma Pacheco de Oliveira Silva", "Loteamento Jardim Helena",
				"Leste", "12226691");
		Endereco rua1374 = new Endereco(null, "Rua Miyoko Morino", "Loteamento Jardim Helena", "Leste", "12226694");
		Endereco rua1375 = new Endereco(null, "Rua João Alberto da Silva", "Loteamento Jardim Helena", "Leste",
				"12226697");
		Endereco rua1376 = new Endereco(null, "Rua Carlos Nunes de Paula", "Jardim Imperial", "Sul", "12234000");
		Endereco rua1377 = new Endereco(null, "Rua Marlene Aparecida de Jesus", "Jardim Imperial", "Sul", "12234007");
		Endereco rua1378 = new Endereco(null, "Avenida Dom Pedro I", "Jardim Imperial", "Sul", "12234010");
		Endereco rua1379 = new Endereco(null, "Rua Almirante Barroso", "Jardim Imperial", "Sul", "12234020");
		Endereco rua1380 = new Endereco(null, "Praça Antônio Moreira Vita", "Jardim Imperial", "Sul", "12234030");
		Endereco rua1381 = new Endereco(null, "Rua Ramon Ovalle", "Jardim Imperial", "Sul", "12234040");
		Endereco rua1382 = new Endereco(null, "Rua Fábio Schneider", "Jardim Imperial", "Sul", "12234050");
		Endereco rua1383 = new Endereco(null, "Rua Maria Aparecida Azevedo", "Jardim Imperial", "Sul", "12234051");
		Endereco rua1384 = new Endereco(null, "Rua Sílvio Gallicho", "Jardim Imperial", "Sul", "12234060");
		Endereco rua1385 = new Endereco(null, "Rua Felisbina de Souza Machado", "Jardim Imperial", "Sul", "12234070");
		Endereco rua1386 = new Endereco(null, "Rua Cônego José Romão da Rosa Góes", "Jardim Imperial", "Sul",
				"12234080");
		Endereco rua1387 = new Endereco(null, "Rua Gerôncio Marcondes", "Jardim Imperial", "Sul", "12234090");
		Endereco rua1388 = new Endereco(null, "Rua Dom João VI", "Jardim Imperial", "Sul", "12234100");
		Endereco rua1389 = new Endereco(null, "Praça Otávio Del Nero", "Jardim Imperial", "Sul", "12234110");
		Endereco rua1390 = new Endereco(null, "Praça Francisco Lopes Azevedo", "Jardim Imperial", "Sul", "12234120");
		Endereco rua1391 = new Endereco(null, "Rua José Aulisio", "Jardim Imperial", "Sul", "12234130");
		Endereco rua1392 = new Endereco(null, "Rua Padre Nóbrega", "Jardim Imperial", "Sul", "12234140");
		Endereco rua1393 = new Endereco(null, "Rua Júlio Baranov", "Jardim Imperial", "Sul", "12234150");
		Endereco rua1394 = new Endereco(null, "Praça Aurora Marcondes Pereira", "Jardim Imperial", "Sul", "12234160");
		Endereco rua1395 = new Endereco(null, "Rua Onofre José dos Reis", "Jardim Imperial", "Sul", "12234170");
		Endereco rua1396 = new Endereco(null, "Rua Luiz Gonzaga Azevedo", "Jardim Imperial", "Sul", "12234180");
		Endereco rua1397 = new Endereco(null, "Rua Roberto Baranov", "Jardim Imperial", "Sul", "12234190");
		Endereco rua1398 = new Endereco(null, "Rua Emanuel Rosemberg", "Jardim Imperial", "Sul", "12234210");
		Endereco rua1399 = new Endereco(null, "Rua Manoel Augusto Amaral", "Jardim Imperial", "Sul", "12234220");
		Endereco rua1400 = new Endereco(null, "Praça Francisco Silvério", "Jardim Imperial", "Sul", "12234230");
		Endereco rua1401 = new Endereco(null, "Rua Manoel Mariano", "Jardim Imperial", "Sul", "12234240");
		Endereco rua1402 = new Endereco(null, "Rua José Roberto Ferrari", "Jardim Imperial", "Sul", "12234250");
		Endereco rua1403 = new Endereco(null, "Rua Durval de Melo", "Jardim Imperial", "Sul", "12234260");
		Endereco rua1404 = new Endereco(null, "Rua Durval S Aguiar", "Jardim Imperial", "Sul", "12234261");
		Endereco rua1405 = new Endereco(null, "Rua Luís Gonzaga Alves", "Jardim Imperial", "Sul", "12234262");
		Endereco rua1406 = new Endereco(null, "Rua Três Irmãos", "Jardim Imperial", "Sul", "12234263");
		Endereco rua1407 = new Endereco(null, "Rua Ermerentina Carvalho Campos", "Jardim Imperial", "Sul", "12234380");
		Endereco rua1408 = new Endereco(null, "Rua Geraldo Chaves", "Jardim Imperial", "Sul", "12234390");
		Endereco rua1409 = new Endereco(null, "Rua Marquês de Maricá", "Jardim Imperial", "Sul", "12234400");
		Endereco rua1410 = new Endereco(null, "Rua Menotti Zeccheto", "Jardim Imperial", "Sul", "12234430");
		Endereco rua1411 = new Endereco(null, "Rua Maria Tereza Cardoso Batista", "Jardim Imperial", "Sul", "12234460");
		Endereco rua1412 = new Endereco(null, "Rua P", "Jardim Imperial", "Sul", "12234471");
		Endereco rua1413 = new Endereco(null, "Avenida Joaquim Ferreira Carpinteiro", "Jardim Ismênia", "Leste",
				"12220660");
		Endereco rua1414 = new Endereco(null, "Rua Sabara", "Jardim Ismênia", "Leste", "12220661");
		Endereco rua1415 = new Endereco(null, "Rua Ituiutaba", "Jardim Ismênia", "Leste", "12220662");
		Endereco rua1416 = new Endereco(null, "Rua Diamantina", "Jardim Ismênia", "Leste", "12220663");
		Endereco rua1417 = new Endereco(null, "Rua Araguari", "Jardim Ismênia", "Leste", "12220670");
		Endereco rua1418 = new Endereco(null, "Rua Abaeté", "Jardim Ismênia", "Leste", "12220680");
		Endereco rua1419 = new Endereco(null, "Rua Uberlândia", "Jardim Ismênia", "Leste", "12220690");
		Endereco rua1420 = new Endereco(null, "Rua Itacarambi", "Jardim Ismênia", "Leste", "12220700");
		Endereco rua1421 = new Endereco(null, "Rua Itanhandu", "Jardim Ismênia", "Leste", "12220710");
		Endereco rua1422 = new Endereco(null, "Rua Guaraciaba", "Jardim Ismênia", "Leste", "12220720");
		Endereco rua1423 = new Endereco(null, "Rua Pirapora", "Jardim Ismênia", "Leste", "12220730");
		Endereco rua1424 = new Endereco(null, "Avenida Uberaba", "Jardim Ismênia", "Leste", "12220740");
		Endereco rua1425 = new Endereco(null, "Rua Caparaó", "Jardim Ismênia", "Leste", "12220750");
		Endereco rua1426 = new Endereco(null, "Praça Caratinga", "Jardim Ismênia", "Leste", "12220760");
		Endereco rua1427 = new Endereco(null, "Rua Caxambu", "Jardim Ismênia", "Leste", "12220770");
		Endereco rua1428 = new Endereco(null, "Rua Baependi", "Jardim Ismênia", "Leste", "12220780");
		Endereco rua1429 = new Endereco(null, "Praça Ouro Preto", "Jardim Ismênia", "Leste", "12220790");
		Endereco rua1430 = new Endereco(null, "Rua Pedralva", "Jardim Ismênia", "Leste", "12220800");
		Endereco rua1431 = new Endereco(null, "Rua Guaxupé", "Jardim Ismênia", "Leste", "12220810");
		Endereco rua1432 = new Endereco(null, "Rua Itajubá", "Jardim Ismênia", "Leste", "12220820");
		Endereco rua1433 = new Endereco(null, "Rua Camanducaia", "Jardim Ismênia", "Leste", "12220830");
		Endereco rua1434 = new Endereco(null, "Rua Tebas", "Jardim Ismênia", "Leste", "12220831");
		Endereco rua1435 = new Endereco(null, "Avenida Servidão", "Jardim Ismênia", "Leste", "12220832");
		Endereco rua1436 = new Endereco(null, "Rua Sabara", " 30", "Jardim Ismênia", "Leste");
		Endereco rua1437 = new Endereco(null, "Avenida Barbacena", "Jardim Ismênia", "Leste", "12221000");
		Endereco rua1438 = new Endereco(null, "Rua João Quirino Pedrosa", "Jardim Ismênia", "Leste", "12221010");
		Endereco rua1439 = new Endereco(null, "Rua Rúbens Leitão Filho", "Jardim Ismênia", "Leste", "12221020");
		Endereco rua1440 = new Endereco(null, "Rua Abílio Pereira Dias", "Jardim Ismênia", "Leste", "12221030");
		Endereco rua1441 = new Endereco(null, "Rua Elza Regina Ferreira Bevilacqua", "Jardim Ismênia", "Leste",
				"12221040");
		Endereco rua1442 = new Endereco(null, "Rua Herondina de Almeida Alvarenga", "Jardim Ismênia", "Leste",
				"12221050");
		Endereco rua1443 = new Endereco(null, "Rua José Domingues dos Santos", "Jardim Ismênia", "Leste", "12221060");
		Endereco rua1444 = new Endereco(null, "Rua Hélio de Almeida Ferreira", "Jardim Ismênia", "Leste", "12221070");
		Endereco rua1445 = new Endereco(null, "Rua José Ferreira de Almeida", "Jardim Ismênia", "Leste", "12221080");
		Endereco rua1446 = new Endereco(null, "Rua Manacá", "Jardim Ismênia", "Leste", "12221090");
		Endereco rua1447 = new Endereco(null, "Rua Alteia", "Jardim Ismênia", "Leste", "12221100");
		Endereco rua1448 = new Endereco(null, "Rua Jabota", "Jardim Ismênia", "Leste", "12221110");
		Endereco rua1449 = new Endereco(null, "Rua Anis", "Jardim Ismênia", "Leste", "12221120");
		Endereco rua1450 = new Endereco(null, "Rua Gameleiras", "Jardim Ismênia", "Leste", "12221130");
		Endereco rua1451 = new Endereco(null, "Rua Perpetua", "Jardim Ismênia", "Leste", "12221140");
		Endereco rua1452 = new Endereco(null, "Praça Tatuaba", "Jardim Ismênia", "Leste", "12221141");
		Endereco rua1453 = new Endereco(null, "Praça Cambará", "Jardim Ismênia", "Leste", "12221142");
		Endereco rua1454 = new Endereco(null, "Rua Bento Pinto da Cunha", "Jardim Ismênia", "Leste", "12221143");
		Endereco rua1455 = new Endereco(null, "Rua Valentim Goll", "Jardim Juliana", "Sul", "12236841");
		Endereco rua1456 = new Endereco(null, "Rua Adolpho Goll", "Jardim Juliana", "Sul", "12236842");
		Endereco rua1457 = new Endereco(null, "Estrada Arcílio Moreira da Silva", "Jardim Juliana", "Sul", "12239870");
		Endereco rua1458 = new Endereco(null, "Rua Esmeralda Rondan", "Jardim Madureira", "Sul", "12232280");
		Endereco rua1459 = new Endereco(null, "Rua José Alves da Silva", "Jardim Madureira", "Sul", "12232281");
		Endereco rua1460 = new Endereco(null, "Rua Werner da Costa Coelho", "Jardim Madureira", "Sul", "12232290");
		Endereco rua1461 = new Endereco(null, "Rua Maria Ribeiro Martins", "Jardim Madureira", "Sul", "12232300");
		Endereco rua1462 = new Endereco(null, "Rua Mário Cesare Porto", "Jardim Maracanã", "Leste", "12221510");
		Endereco rua1463 = new Endereco(null, "Rua Projetada", "Jardim Maracanã", "Leste", "12221511");
		Endereco rua1464 = new Endereco(null, "Rua Messias Palmeira", "Jardim Maracanã", "Leste", "12221512");
		Endereco rua1465 = new Endereco(null, "Praça Tertuliano Moraes Delfim", "Jardim Margareth", "Centro",
				"12243530");
		Endereco rua1466 = new Endereco(null, "Rua Félicio Chiocchi", "Jardim Margareth", "Centro", "12243540");
		Endereco rua1467 = new Endereco(null, "Rua Luiz Gonzaga Teixeira Leite", "Jardim Margareth", "Centro",
				"12243550");
		Endereco rua1468 = new Endereco(null, "Rua Hamid Said Amim", "Jardim Margareth", "Centro", "12243560");
		Endereco rua1469 = new Endereco(null, "Rua José Cristiano da Fonseca", "Jardim Margareth", "Centro",
				"12243561");
		Endereco rua1470 = new Endereco(null, "Rua Rio Bonito", "Jardim Margareth", "Centro", "12243562");
		Endereco rua1471 = new Endereco(null, "Rua Rio Claro", "Jardim Margareth", "Centro", "12243563");
		Endereco rua1472 = new Endereco(null, "Avenida Joaquim Ribeiro Guedes", "Jardim Mariana I", "Leste",
				"12226850");
		Endereco rua1473 = new Endereco(null, "Rua Manoel Francisco de Moraes", "Jardim Mariana I", "Leste",
				"12226851");
		Endereco rua1474 = new Endereco(null, "Rua Antoinette Melhem El Khouri Nicolas", "Jardim Mariana I", "Leste",
				"12226852");
		Endereco rua1475 = new Endereco(null, "Rua Angelina de Souza Machado", "Jardim Mariana I", "Leste", "12226853");
		Endereco rua1476 = new Endereco(null, "Rua Aurélio Portilho Castellanos", "Jardim Mariana I", "Leste",
				"12226854");
		Endereco rua1477 = new Endereco(null, "Rua Engenheiro Pedro Paulo Cerqueira Lima", "Jardim Mariana I", "Leste",
				"12226856");
		Endereco rua1478 = new Endereco(null, "Rua Inês Maria do Nascimento", "Jardim Mariana I", "Leste", "12226857");
		Endereco rua1479 = new Endereco(null, "Rua Fátima Regina da Silva", "Jardim Mariana I", "Leste", "12226858");
		Endereco rua1480 = new Endereco(null, "Rua João Vicente Gomes Filho", "Jardim Mariana I", "Leste", "12226859");
		Endereco rua1481 = new Endereco(null, "Rua José Hermínio de Oliveira", "Jardim Mariana I", "Leste", "12226860");
		Endereco rua1482 = new Endereco(null, "Rua José Militão da Silva", "Jardim Mariana I", "Leste", "12226861");
		Endereco rua1483 = new Endereco(null, "Rua Silvia Aparecida da Silva Nascimento", "Jardim Mariana I", "Leste",
				"12226862");
		Endereco rua1484 = new Endereco(null, "Rua Venâncio Coelho da Silva", "Jardim Mariana I", "Leste", "12226864");
		Endereco rua1485 = new Endereco(null, "Rua Cleusa Maria Soares da Silva", "Jardim Mariana I", "Leste",
				"12226866");
		Endereco rua1486 = new Endereco(null, "Rua Quatorze", "Jardim Mariana I", "Leste", "12226868");
		Endereco rua1487 = new Endereco(null, "Rua Antonio Marcos de Oliveira", "Jardim Mariana II", "Leste",
				"12226870");
		Endereco rua1488 = new Endereco(null, "Rua Carmelindo Aparecido Correa", "Jardim Mariana II", "Leste",
				"12226872");
		Endereco rua1489 = new Endereco(null, "Rua Doutor Antônio Borges de Toledo", "Jardim Mariana II", "Leste",
				"12226874");
		Endereco rua1490 = new Endereco(null, "Rua Gonçalo Soares", "Jardim Mariana II", "Leste", "12226876");
		Endereco rua1491 = new Endereco(null, "Rua Joaquim Antonio Martins", "Jardim Mariana II", "Leste", "12226877");
		Endereco rua1492 = new Endereco(null, "Rua Maria Angélia Monteiro Rodrigues", "Jardim Mariana II", "Leste",
				"12226878");
		Endereco rua1493 = new Endereco(null, "Rua Ken Ishizucka", "Jardim Mariana II", "Leste", "12226879");
		Endereco rua1494 = new Endereco(null, "Rua Maurício Maldonado Júnior", "Jardim Mariana II", "Leste",
				"12226880");
		Endereco rua1495 = new Endereco(null, "Rua Sebastião Ramos Nogueira", "Jardim Mariana II", "Leste", "12226882");
		Endereco rua1496 = new Endereco(null, "Rua Alceu Andrade", "Jardim Mariana II", "Leste", "12226883");
		Endereco rua1497 = new Endereco(null, "Rua Maria de Andrade Vieira", "Jardim Mariana II", "Leste", "12226884");
		Endereco rua1498 = new Endereco(null, "Avenida Mariana Andrade", "Jardim Mariana II", "Leste", "12226886");
		Endereco rua1499 = new Endereco(null, "Rua Benedicto Rezende de Souza", "Jardim Mariana II", "Leste",
				"12226888");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		

		endRepository.saveAll(Arrays.asList(rua1, rua1, rua2, rua3, rua4, rua5, rua6, rua7, rua8, rua9, rua10, rua11,
				rua12, rua13, rua14, rua15, rua16, rua17, rua18, rua19, rua20, rua21, rua22, rua23, rua24, rua25, rua26,
				rua27, rua28, rua29, rua30, rua31, rua32, rua33, rua34, rua35, rua36, rua37, rua38, rua39, rua40, rua41,
				rua42, rua43, rua44, rua45, rua46, rua47, rua48, rua49, rua50, rua51, rua52, rua53, rua54, rua55, rua56,
				rua57, rua58, rua59, rua60, rua61, rua62, rua63, rua64, rua65, rua66, rua67, rua68, rua69, rua70, rua71,
				rua72, rua73, rua74, rua75, rua76, rua77, rua78, rua79, rua80, rua81, rua82, rua83, rua84, rua85, rua86,
				rua87, rua88, rua89, rua90, rua91, rua92, rua93, rua94, rua95, rua96, rua97, rua98, rua99, rua100,
				rua101, rua102, rua103, rua104, rua105, rua106, rua107, rua108, rua109, rua110, rua111, rua112, rua113,
				rua114, rua115, rua116, rua117, rua118, rua119, rua120, rua121, rua122, rua123, rua124, rua125, rua126,
				rua127, rua128, rua129, rua130, rua131, rua132, rua133, rua134, rua135, rua136, rua137, rua138, rua139,
				rua140, rua141, rua142, rua143, rua144, rua145, rua146, rua147, rua148, rua149, rua150, rua151, rua152,
				rua153, rua154, rua155, rua156, rua157, rua158, rua159, rua160, rua161, rua162, rua163, rua164, rua165,
				rua166, rua167, rua168, rua169, rua170, rua171, rua172, rua173, rua174, rua175, rua176, rua177, rua178,
				rua179, rua180, rua181, rua182, rua183, rua184, rua185, rua186, rua187, rua188, rua189, rua190, rua191,
				rua192, rua193, rua194, rua195, rua196, rua197, rua198, rua199, rua200, rua201, rua202, rua203, rua204,
				rua205, rua206, rua207, rua208, rua209, rua210, rua211, rua212, rua213, rua214, rua215, rua216, rua217,
				rua218, rua219, rua220, rua221, rua222, rua223, rua224, rua225, rua226, rua227, rua228, rua229, rua230,
				rua231, rua232, rua233, rua234, rua235, rua236, rua237, rua238, rua239, rua240, rua241, rua242, rua243,
				rua244, rua245, rua246, rua247, rua248, rua249, rua250, rua251, rua252, rua253, rua254, rua255, rua256,
				rua257, rua258, rua259, rua260, rua261, rua262, rua263, rua264, rua265, rua266, rua267, rua268, rua269,
				rua270, rua271, rua272, rua273, rua274, rua275, rua276, rua277, rua278, rua279, rua280, rua281, rua282,
				rua283, rua284, rua285, rua286, rua287, rua288, rua289, rua290, rua291, rua292, rua293, rua294, rua295,
				rua296, rua297, rua298, rua299, rua300, rua301, rua302, rua303, rua304, rua305, rua306, rua307, rua308,
				rua309, rua310, rua311, rua312, rua313, rua314, rua315, rua316, rua317, rua318, rua319, rua320, rua321,
				rua322, rua323, rua324, rua325, rua326, rua327, rua328, rua329, rua330, rua331, rua332, rua333, rua334,
				rua335, rua336, rua337, rua338, rua339, rua340, rua341, rua342, rua343, rua344, rua345, rua346, rua347,
				rua348, rua349, rua350, rua351, rua352, rua353, rua354, rua355, rua356, rua357, rua358, rua359, rua360,
				rua361, rua362, rua363, rua364, rua365, rua366, rua367, rua368, rua369, rua370, rua371, rua372, rua373,
				rua374, rua375, rua376, rua377, rua378, rua379, rua380, rua381, rua382, rua383, rua384, rua385, rua386,
				rua387, rua388, rua389, rua390, rua391, rua392, rua393, rua394, rua395, rua396, rua397, rua398, rua399,
				rua400, rua401, rua402, rua403, rua404, rua405, rua406, rua407, rua408, rua409, rua410, rua411, rua412,
				rua413, rua414, rua415, rua416, rua417, rua418, rua419, rua420, rua421, rua422, rua423, rua424, rua425,
				rua426, rua427, rua428, rua429, rua430, rua431, rua432, rua433, rua434, rua435, rua436, rua437, rua438,
				rua439, rua440, rua441, rua442, rua443, rua444, rua445, rua446, rua447, rua448, rua449, rua450, rua451,
				rua452, rua453, rua454, rua455, rua456, rua457, rua458, rua459, rua460, rua461, rua462, rua463, rua464,
				rua465, rua466, rua467, rua468, rua469, rua470, rua471, rua472, rua473, rua474, rua475, rua476, rua477,
				rua478, rua479, rua480, rua481, rua482, rua483, rua484, rua485, rua486, rua487, rua488, rua489, rua490,
				rua491, rua492, rua493, rua494, rua495, rua496, rua497, rua498, rua499, rua500, rua501, rua502, rua503,
				rua504, rua505, rua506, rua507, rua508, rua509, rua510, rua511, rua512, rua513, rua514, rua515, rua516,
				rua517, rua518, rua519, rua520, rua521, rua522, rua523, rua524, rua525, rua526, rua527, rua528, rua529,
				rua530, rua531, rua532, rua533, rua534, rua535, rua536, rua537, rua538, rua539, rua540, rua541, rua542,
				rua543, rua544, rua545, rua546, rua547, rua548, rua549, rua550, rua551, rua552, rua553, rua554, rua555,
				rua556, rua557, rua558, rua559, rua560, rua561, rua562, rua563, rua564, rua565, rua566, rua567, rua568,
				rua569, rua570, rua571, rua572, rua573, rua574, rua575, rua576, rua577, rua578, rua579, rua580, rua581,
				rua582, rua583, rua584, rua585, rua586, rua587, rua588, rua589, rua590, rua591, rua592, rua593, rua594,
				rua595, rua596, rua597, rua598, rua599, rua600, rua601, rua602, rua603, rua604, rua605, rua606, rua607,
				rua608, rua609, rua610, rua611, rua612, rua613, rua614, rua615, rua616, rua617, rua618, rua619, rua620,
				rua621, rua622, rua623, rua624, rua625, rua626, rua627, rua628, rua629, rua630, rua631, rua632, rua633,
				rua634, rua635, rua636, rua637, rua638, rua639, rua640, rua641, rua642, rua643, rua644, rua645, rua646,
				rua647, rua648, rua649, rua650, rua651, rua652, rua653, rua654, rua655, rua656, rua657, rua658, rua659,
				rua660, rua661, rua662, rua663, rua664, rua665, rua666, rua667, rua668, rua669, rua670, rua671, rua672,
				rua673, rua674, rua675, rua676, rua677, rua678, rua679, rua680, rua681, rua682, rua683, rua684, rua685,
				rua686, rua687, rua688, rua689, rua690, rua691, rua692, rua693, rua694, rua695, rua696, rua697, rua698,
				rua699, rua700, rua701, rua702, rua703, rua704, rua705, rua706, rua707, rua708, rua709, rua710, rua711,
				rua712, rua713, rua714, rua715, rua716, rua717, rua718, rua719, rua720, rua721, rua722, rua723, rua724,
				rua725, rua726, rua727, rua728, rua729, rua730, rua731, rua732, rua733, rua734, rua735, rua736, rua737,
				rua738, rua739, rua740, rua741, rua742, rua743, rua744, rua745, rua746, rua747, rua748, rua749, rua750,
				rua751, rua752, rua753, rua754, rua755, rua756, rua757, rua758, rua759, rua760, rua761, rua762, rua763,
				rua764, rua765, rua766, rua767, rua768, rua769, rua770, rua771, rua772, rua773, rua774, rua775, rua776,
				rua777, rua778, rua779, rua780, rua781, rua782, rua783, rua784, rua785, rua786, rua787, rua788, rua789,
				rua790, rua791, rua792, rua793, rua794, rua795, rua796, rua797, rua798, rua799, rua800, rua801, rua802,
				rua803, rua804, rua805, rua806, rua807, rua808, rua809, rua810, rua811, rua812, rua813, rua814, rua815,
				rua816, rua817, rua818, rua819, rua820, rua821, rua822, rua823, rua824, rua825, rua826, rua827, rua828,
				rua829, rua830, rua831, rua832, rua833, rua834, rua835, rua836, rua837, rua838, rua839, rua840, rua841,
				rua842, rua843, rua844, rua845, rua846, rua847, rua848, rua849, rua850, rua851, rua852, rua853, rua854,
				rua855, rua856, rua857, rua858, rua859, rua860, rua861, rua862, rua863, rua864, rua865, rua866, rua867,
				rua868, rua869, rua870, rua871, rua872, rua873, rua874, rua875, rua876, rua877, rua878, rua879, rua880,
				rua881, rua882, rua883, rua884, rua885, rua886, rua887, rua888, rua889, rua890, rua891, rua892, rua893,
				rua894, rua895, rua896, rua897, rua898, rua899, rua900, rua901, rua902, rua903, rua904, rua905, rua906,
				rua907, rua908, rua909, rua910, rua911, rua912, rua913, rua914, rua915, rua916, rua917, rua918, rua919,
				rua920, rua921, rua922, rua923, rua924, rua925, rua926, rua927, rua928, rua929, rua930, rua931, rua932,
				rua933, rua934, rua935, rua936, rua937, rua938, rua939, rua940, rua941, rua942, rua943, rua944, rua945,
				rua946, rua947, rua948, rua949, rua950, rua951, rua952, rua953, rua954, rua955, rua956, rua957, rua958,
				rua959, rua960, rua961, rua962, rua963, rua964, rua965, rua966, rua967, rua968, rua969, rua970, rua971,
				rua972, rua973, rua974, rua975, rua976, rua977, rua978, rua979, rua980, rua981, rua982, rua983, rua984,
				rua985, rua986, rua987, rua988, rua989, rua990, rua991, rua992, rua993, rua994, rua995, rua996, rua997,
				rua998, rua999, rua1000, rua1001, rua1002, rua1003, rua1004, rua1005, rua1006, rua1007, rua1008,
				rua1009, rua1010, rua1011, rua1012, rua1013, rua1014, rua1015, rua1016, rua1017, rua1018, rua1019,
				rua1020, rua1021, rua1022, rua1023, rua1024, rua1025, rua1026, rua1027, rua1028, rua1029, rua1030,
				rua1031, rua1032, rua1033, rua1034, rua1035, rua1036, rua1037, rua1038, rua1039, rua1040, rua1041,
				rua1042, rua1043, rua1044, rua1045, rua1046, rua1047, rua1048, rua1049, rua1050, rua1051, rua1052,
				rua1053, rua1054, rua1055, rua1056, rua1057, rua1058, rua1059, rua1060, rua1061, rua1062, rua1063,
				rua1064, rua1065, rua1066, rua1067, rua1068, rua1069, rua1070, rua1071, rua1072, rua1073, rua1074,
				rua1075, rua1076, rua1077, rua1078, rua1079, rua1080, rua1081, rua1082, rua1083, rua1084, rua1085,
				rua1086, rua1087, rua1088, rua1089, rua1090, rua1091, rua1092, rua1093, rua1094, rua1095, rua1096,
				rua1097, rua1098, rua1099, rua1100, rua1101, rua1102, rua1103, rua1104, rua1105, rua1106, rua1107,
				rua1108, rua1109, rua1110, rua1111, rua1112, rua1113, rua1114, rua1115, rua1116, rua1117, rua1118,
				rua1119, rua1120, rua1121, rua1122, rua1123, rua1124, rua1125, rua1126, rua1127, rua1128, rua1129,
				rua1130, rua1131, rua1132, rua1133, rua1134, rua1135, rua1136, rua1137, rua1138, rua1139, rua1140,
				rua1141, rua1142, rua1143, rua1144, rua1145, rua1146, rua1147, rua1148, rua1149, rua1150, rua1151,
				rua1152, rua1153, rua1154, rua1155, rua1156, rua1157, rua1158, rua1159, rua1160, rua1161, rua1162,
				rua1163, rua1164, rua1165, rua1166, rua1167, rua1168, rua1169, rua1170, rua1171, rua1172, rua1173,
				rua1174, rua1175, rua1176, rua1177, rua1178, rua1179, rua1180, rua1181, rua1182, rua1183, rua1184,
				rua1185, rua1186, rua1187, rua1188, rua1189, rua1190, rua1191, rua1192, rua1193, rua1194, rua1195,
				rua1196, rua1197, rua1198, rua1199, rua1200, rua1201, rua1202, rua1203, rua1204, rua1205, rua1206,
				rua1207, rua1208, rua1209, rua1210, rua1211, rua1212, rua1213, rua1214, rua1215, rua1216, rua1217,
				rua1218, rua1219, rua1220, rua1221, rua1222, rua1223, rua1224, rua1225, rua1226, rua1227, rua1228,
				rua1229, rua1230, rua1231, rua1232, rua1233, rua1234, rua1235, rua1236, rua1237, rua1238, rua1239,
				rua1240, rua1241, rua1242, rua1243, rua1244, rua1245, rua1246, rua1247, rua1248, rua1249, rua1250,
				rua1251, rua1252, rua1253, rua1254, rua1255, rua1256, rua1257, rua1258, rua1259, rua1260, rua1261,
				rua1262, rua1263, rua1264, rua1265, rua1266, rua1267, rua1268, rua1269, rua1270, rua1271, rua1272,
				rua1273, rua1274, rua1275, rua1276, rua1277, rua1278, rua1279, rua1280, rua1281, rua1282, rua1283,
				rua1284, rua1285, rua1286, rua1287, rua1288, rua1289, rua1290, rua1291, rua1292, rua1293, rua1294,
				rua1295, rua1296, rua1297, rua1298, rua1299, rua1300, rua1301, rua1302, rua1303, rua1304, rua1305,
				rua1306, rua1307, rua1308, rua1309, rua1310, rua1311, rua1312, rua1313, rua1314, rua1315, rua1316,
				rua1317, rua1318, rua1319, rua1320, rua1321, rua1322, rua1323, rua1324, rua1325, rua1326, rua1327,
				rua1328, rua1329, rua1330, rua1331, rua1332, rua1333, rua1334, rua1335, rua1336, rua1337, rua1338,
				rua1339, rua1340, rua1341, rua1342, rua1343, rua1344, rua1345, rua1346, rua1347, rua1348, rua1349,
				rua1350, rua1351, rua1352, rua1353, rua1354, rua1355, rua1356, rua1357, rua1358, rua1359, rua1360,
				rua1361, rua1362, rua1363, rua1364, rua1365, rua1366, rua1367, rua1368, rua1369, rua1370, rua1371,
				rua1372, rua1373, rua1374, rua1375, rua1376, rua1377, rua1378, rua1379, rua1380, rua1381, rua1382,
				rua1383, rua1384, rua1385, rua1386, rua1387, rua1388, rua1389, rua1390, rua1391, rua1392, rua1393,
				rua1394, rua1395, rua1396, rua1397, rua1398, rua1399, rua1400, rua1401, rua1402, rua1403, rua1404,
				rua1405, rua1406, rua1407, rua1408, rua1409, rua1410, rua1411, rua1412, rua1413, rua1414, rua1415,
				rua1416, rua1417, rua1418, rua1419, rua1420, rua1421, rua1422, rua1423, rua1424, rua1425, rua1426,
				rua1427, rua1428, rua1429, rua1430, rua1431, rua1432, rua1433, rua1434, rua1435, rua1436, rua1437,
				rua1438, rua1439, rua1440, rua1441, rua1442, rua1443, rua1444, rua1445, rua1446, rua1447, rua1448,
				rua1449, rua1450, rua1451, rua1452, rua1453, rua1454, rua1455, rua1456, rua1457, rua1458, rua1459,
				rua1460, rua1461, rua1462, rua1463, rua1464, rua1465, rua1466, rua1467, rua1468, rua1469, rua1470,
				rua1471, rua1472, rua1473, rua1474, rua1475, rua1476, rua1477, rua1478, rua1479, rua1480, rua1481,
				rua1482, rua1483, rua1484, rua1485, rua1486, rua1487, rua1488, rua1489, rua1490, rua1491, rua1492,
				rua1493, rua1494, rua1495, rua1496, rua1497, rua1498, rua1499));

		
		TipoSolicitante tipoSol1= new TipoSolicitante(null,"MUNICIPE");
		TipoSolicitante tipoSol2= new TipoSolicitante(null,"FUNCIONARIO");
		TipoSolicitante tipoSol3= new TipoSolicitante(null,"DEPARTAMENTO");
		
		tipoSolRepository.saveAll(Arrays.asList(tipoSol1,tipoSol2,tipoSol3));
		
		
		
		Solicitante sol1 = new Solicitante(null, "José", "programacaoacm@gmail.com", tipoSol1, 101,rua1);
		Solicitante sol2 = new Solicitante(null, "Antonio", "programacaoacm@gmail.com", tipoSol2,
				102, rua2);
		Solicitante sol3 = new Solicitante(null, "Samu", "programacaoacm@gmail.com", tipoSol3, 1003,
				rua3);
		Solicitante sol4 = new Solicitante(null, "Felipe", "programacaoacm@gmail.com", tipoSol1, 101,
				rua4);
		Solicitante sol5 = new Solicitante(null, "Claudio", "programacaoacm@gmail.com", tipoSol2,
				102, rua5);
		Solicitante sol6 = new Solicitante(null, "UBS", "programacaoacm@gmail.com", tipoSol3, 1003,
				rua6);

		sol1.getTelefones().addAll(Arrays.asList("78536966", "78749855", "4263541"));
		sol2.getTelefones().addAll(Arrays.asList("78549525"));
		sol3.getTelefones().addAll(Arrays.asList("463254154"));
		sol3.getTelefones().addAll(Arrays.asList("78549417", "78369855", "4782541"));
		sol4.getTelefones().addAll(Arrays.asList("78146925"));
		sol5.getTelefones().addAll(Arrays.asList("462687154"));
		sol6.getTelefones().addAll(Arrays.asList("461463154"));

		solicitanteRepository.saveAll(Arrays.asList(sol1, sol2, sol3, sol4, sol5, sol6));
		
		Funcionario func1= new Funcionario(null, "Antonio Alves", "capablanca1@bol.com.br", pe.encode("123"));
		Funcionario func2= new Funcionario(null, "Joao carlos", "programacaoacm@gmail.com", pe.encode("123"));
		Funcionario func3= new Funcionario(null, "Pedro Tiago", "pedroTiago@ex.com.br", pe.encode("123"));
		Funcionario func4= new Funcionario(null, "Andre Simão", "andre@ex.com.br", pe.encode("123"));
		Funcionario func5= new Funcionario(null, "Felipe Bartolomeu", "fb@ex.com.br", pe.encode("123"));
		Funcionario func6= new Funcionario(null, "Marisa", "marisae@ex.com.br", pe.encode("123"));
		Funcionario func7= new Funcionario(null, "Sebastiana", "sebastiana@ex.com.br", pe.encode("123"));
		Funcionario func8= new Funcionario(null, "Fernanda", "fernanda@ex.com.br", pe.encode("123"));
		func1.addPerfil(Perfil.ADMIN);
		func2.addPerfil(Perfil.AGENTE);
		func3.addPerfil(Perfil.AGENTE);
		func4.addPerfil(Perfil.AGENTE);
		func5.addPerfil(Perfil.CADASTRADOR);
		func6.addPerfil(Perfil.CADASTRADOR);		
		func7.addPerfil(Perfil.AGENTE);
		func8.addPerfil(Perfil.ADMIN);
		
		
		funcionarioRepository.saveAll(Arrays.asList(func1,func2,func3,func4,func5,func6,func7,func8));
		
		
		OrigemOcorrencia ori1= new OrigemOcorrencia(null,"PESSOALMENTE");
		OrigemOcorrencia ori2= new OrigemOcorrencia(null,"VIA_RADIO");
		OrigemOcorrencia ori3= new OrigemOcorrencia(null,"TEL_156");
		OrigemOcorrencia ori4= new OrigemOcorrencia(null,"VIA_FONE");
		OrigemOcorrencia ori5= new OrigemOcorrencia(null,"VIA_COI");
		OrigemOcorrencia ori6= new OrigemOcorrencia(null,"OUTROS");
		
		oriOcoRepository.saveAll(Arrays.asList(ori1,ori2,ori3,ori4,ori5,ori6));
		
		
		TipoOcorrencia tipooco1= new TipoOcorrencia(null,"AV1","ALAGAMENTO DE VIA");
		TipoOcorrencia tipooco2= new TipoOcorrencia(null,"AA1", "APOIO AMBULANCIA EVENTOS");
		TipoOcorrencia tipooco3= new TipoOcorrencia(null,"AR1","ARVORE RISCO QUEDA");
		TipoOcorrencia tipooco4= new TipoOcorrencia(null,"AE1", "ATENDIMENTO EM EVENTOS");
		TipoOcorrencia tipooco5= new TipoOcorrencia(null,"AV1","BURACO NA VIA");
		TipoOcorrencia tipooco6= new TipoOcorrencia(null,"CA1", "CASA ALAGADA");
		TipoOcorrencia tipooco7= new TipoOcorrencia(null,"CD1","CASA DESTELHADA");
		TipoOcorrencia tipooco8= new TipoOcorrencia(null,"CG1", "CHEIRO DE GAS OU OCR PRODUTO QUIMICO");
		TipoOcorrencia tipooco9= new TipoOcorrencia(null,"DT1","DESLIZAMENTO DE TERRA");
		TipoOcorrencia tipooco10= new TipoOcorrencia(null,"EN1", "ENCHENTE");
		TipoOcorrencia tipooco11= new TipoOcorrencia(null,"FE1","FIO ENERGIZADO");
		TipoOcorrencia tipooco12= new TipoOcorrencia(null,"FM1", "FOGO NO MATO");
		TipoOcorrencia tipooco13= new TipoOcorrencia(null,"IE1","INCENDIO EM EDIFICACAO");
		TipoOcorrencia tipooco14= new TipoOcorrencia(null,"MLA", "MONITORAMENTO DE AREA DE RISCO");
		TipoOcorrencia tipooco15= new TipoOcorrencia(null,"MI1", "MORADIA INTERDITADA");
		TipoOcorrencia tipooco16= new TipoOcorrencia(null,"MR1", "MURO COM RISCO DE QUEDA");
		TipoOcorrencia tipooco17= new TipoOcorrencia(null,"OU1","OUTROS");
		TipoOcorrencia tipooco18= new TipoOcorrencia(null,"QA1", "QUEDA DE ARVORE OU GALHO");
		TipoOcorrencia tipooco19= new TipoOcorrencia(null,"QC1", "QUEDA DE CASA OU PARTE");
		TipoOcorrencia tipooco20= new TipoOcorrencia(null,"QM1", "QUEDA DE MURO");
		TipoOcorrencia tipooco21= new TipoOcorrencia(null,"QP1", "QUEDA DE POSTE OU COM RISCO");
		TipoOcorrencia tipooco22= new TipoOcorrencia(null,"RA1","RETIRADA DE ABELHAS");
		TipoOcorrencia tipooco23= new TipoOcorrencia(null,"RE1", "RETORNO DE ESGOTO OU VAZAMENTO DE AGUA");
		TipoOcorrencia tipooco24= new TipoOcorrencia(null,"TP1", "TRANSPORTE DE PACIENTE");
		TipoOcorrencia tipooco25= new TipoOcorrencia(null,"VR1", "VISTORIA EM RESIDENCIA");
		
		
		tipoOcoRepository.saveAll(Arrays.asList(tipooco1,tipooco2,tipooco3,tipooco4,tipooco5,tipooco6,tipooco7,tipooco8,tipooco9,tipooco10,tipooco11,tipooco12,tipooco13,tipooco14,tipooco15,tipooco16,tipooco17,tipooco18,tipooco19,tipooco20,tipooco21,tipooco22,tipooco23,tipooco24,tipooco25));

		SimpleDateFormat dat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Ocorrencia oco1 = new Ocorrencia(null, dat.parse("20/10/2017 00:00"), null, dat.parse("20/10/2017 00:00"),
				"Aberta", "Deslizamento pos chuvas", ori1, tipooco1, 101, func4,
				sol1, rua1,func2);
		Ocorrencia oco2 = new Ocorrencia(null, dat.parse("21/10/2017 00:00"), null, dat.parse("22/10/2017 00:00"),
				"Aberta", "Mato muito alto", ori1, tipooco12, 102, func2, sol2, rua2,func2);
		Ocorrencia oco3 = new Ocorrencia(null, dat.parse("22/10/2017 00:00"), null, null, "Fechada",
				"Chuvas em excesso", ori3, tipooco15, 103, func1, sol3, rua3,func7);
		Ocorrencia oco4 = new Ocorrencia(null, dat.parse("22/10/2017 00:00"), null, dat.parse("23/10/2017 00:00"),
				"Aberta", "Deslizamento pos chuvas", ori1 ,tipooco6, 104, func4,
				sol1, rua400,func7);
		Ocorrencia oco5 = new Ocorrencia(null, dat.parse("23/10/2017 00:00"), null, null, "Aberta", "Mato muito alto",
				ori1, tipooco19, 105, func2, sol2, rua5,func2);
		Ocorrencia oco6 = new Ocorrencia(null, dat.parse("23/10/2017 00:00"), null, dat.parse("23/10/2017 00:00"),
				"Fechada", "Chuvas em excesso", ori2, tipooco7, 106, func3, sol3,
				rua600,func7);
		Ocorrencia oco7 = new Ocorrencia(null, dat.parse("24/11/2017 00:00"), null, dat.parse("25/11/2017 00:00"),
				"Aberta", "Deslizamento pos chuvas", ori1, tipooco3, 107, func4,
				sol1, rua7,func2);
		Ocorrencia oco8 = new Ocorrencia(null, dat.parse("24/11/2017 00:00"), null, dat.parse("25/11/2017 00:00"),
				"Aberta", "Mato muito alto", ori1, tipooco16, 108, func2, sol2,
				rua80,func7);
		Ocorrencia oco9 = new Ocorrencia(null, dat.parse("25/11/2017 00:00"), null, dat.parse("26/11/2017 00:00"),
				"Fechada", "Chuvas em excesso", ori2, tipooco17, 109, func1, sol2,
				rua1250,func2);

		
		/////////////////////
		oco6.setDataConclusao(dat.parse("26/10/2017 00:00"));
		oco9.setDataConclusao(dat.parse("26/10/2017 00:00"));
		ocoRepository.save(oco1);
		ocoRepository.save(oco2);
		ocoRepository.save(oco3);
		ocoRepository.save(oco4);
		ocoRepository.save(oco5);
		ocoRepository.save(oco6);
		ocoRepository.save(oco7);
		ocoRepository.save(oco8);
		ocoRepository.save(oco9);

		String vistoria1 = "Lorem ipsum placerat netus vel tempor volutpat rutrum, convallis sodales etiam ultrices suscipit neque mi inceptos, sapien odio condimentum primis malesuada mattis. "
				+ "accumsan velit maecenas condimentum tincidunt pellentesque fermentum sagittis porta curae mattis curabitur phasellus blandit mollis, "
				+ "semper dui orci quisque interdum quam torquent tincidunt imperdiet suscipit amet sapien malesuada. pretium volutpat cursus ultricies per malesuada, lorem sodales rutrum ad.";

		String vistoria2 = "Odio auctor sagittis quisque laoreet dui vulputate quisque tellus nisi nulla, fermentum pulvinar eget vulputate hac dui tellus quis sagittis. eros potenti "
				+ "fermentum non gravida habitant, nibh aenean etiam quisque non, amet sapien purus class. interdum molestie mollis risus lacinia feugiat per eget, sociosqu blandit "
				+ "hac morbi ornare sit dictum, non nec magna augue ullamcorper nisl. tortor lacinia risus non est fames nam, fames mi feugiat velit porttitor blandit nisi, potenti vivamus taciti commodo sociosqu. "
				+ "erat aptent taciti vehicula urna suscipit habitasse hac phasellus aenean nisi ut dictum eget, duis et sodales auctor cursus turpis dictum lorem phasellus varius libero. ";
		String obs1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse tincidunt vel nisi sit amet hendrerit. Mauris porttitor neque lacus, at sollicitudin urna mattis a. "
				+ "Duis in orci vel purus tempor mattis. Lorem ipsum dolor sit amet, "
				+ "consectetur adipiscing elit. In at porttitor nunc. Integer non tortor ornare, porttitor felis vitae, bibendum nisi. Suspendisse sollicitudin, massa ut porta congue, leo sem.";
		String obs2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ornare finibus neque et tristique. Curabitur velit magna, consequat ac magna at, commodo vulputate elit."
				+ " Phasellus ullamcorper dictum elit, eget blandit metus placerat ut. Sed sit amet finibus dolor, nec semper est. Nam eu maximus erat. Donec a orci imperdiet, semper augue id, tristique nulla."
				+ " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sodales magna augue. Nulla consequat nisi et lorem sodales aliquam. Integer quis est risus. Ut nisl tortor.";
		////////////////////////////////////////////////////////////////////////

		Tramitacao trami1= new Tramitacao(null,1,"PENDENTE");
		Tramitacao trami2= new Tramitacao(null,2,"PARA_PROV_DC");
		Tramitacao trami3= new Tramitacao(null,3,"RESOLVIDO");
		Tramitacao trami4= new Tramitacao(null,4,"ARQUIVO");
		Tramitacao trami5= new Tramitacao(null,5,"PARA_PROV_OUTROS");
				
		tramitacaoRepository.saveAll(Arrays.asList(trami1,trami2,trami3,trami4,trami5));
		
		Relatorio rel1 = new Relatorio(101, vistoria1, obs1, func1, rua1, oco1,trami1);
		Relatorio rel2 = new Relatorio(102, vistoria2, obs2, func2, rua1, oco2,trami1);
		Relatorio rel3 = new Relatorio(103, vistoria2, obs1, func3, rua1, oco3,trami1);
		Relatorio rel4 = new Relatorio(104, vistoria2, obs2, func4, rua1, oco4,trami1);
		Relatorio rel5 = new Relatorio(105, vistoria1, obs1, func7, rua1, oco5,trami1);
		Relatorio rel6 = new Relatorio(106, vistoria2, obs2, func2, rua1, oco6,trami1);
		Relatorio rel7 = new Relatorio(107, vistoria2, obs1, func1, rua1, oco7,trami1);
		Relatorio rel8 = new Relatorio(108, vistoria1, obs2, func4, rua1, oco8,trami1);
		Relatorio rel9 = new Relatorio(109, vistoria1, obs1, func7, rua1, oco9,trami1);
		Relatorio rel10 = new Relatorio(110, vistoria2, obs2, func1, rua1, oco1,trami1);
		
		rel1.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio1-1.jpg");
		rel1.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio1-2.jpg");
		rel1.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio1-3.jpg");
		rel1.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio1-4.jpg");
		
		rel2.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio2-1.jpg");
		rel2.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio2-2.jpg");
		rel2.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio2-3.jpg");
		rel2.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio2-4.jpg");
		
		rel3.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio3-1.jpg");
		rel3.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio3-2.jpg");
		rel3.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio3-3.jpg");
		rel3.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio3-4.jpg");
		
		rel4.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio4-1.jpg");
		
		
		rel5.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio5-1.jpg");
		rel5.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio5-2.jpg");
		rel5.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio5-3.jpg");
		rel5.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio5-4.jpg");
		
		rel6.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio6-1.jpg");
		rel6.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio6-2.jpg");
		rel6.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio6-3.jpg");
		rel6.addFoto("https://s3-sa-east-1.amazonaws.com/projeto-defesacivil-sjc/relatorio6-4.jpg");
		
		
		
		
		

		relatorioRepository.save(rel1);
		relatorioRepository.save(rel2);
		relatorioRepository.save(rel3);
		relatorioRepository.save(rel4);
		relatorioRepository.save(rel5);
		relatorioRepository.save(rel6);
		relatorioRepository.save(rel7);
		relatorioRepository.save(rel8);
		relatorioRepository.save(rel9);
		relatorioRepository.save(rel10);
		
		
		Departamento dep1= new Departamento(null,"SAMU","samu@prefeiturasjc.com",100, "192");
		Departamento dep2= new Departamento(null,"COI","COI@prefeiturasjc.com",100, "156");
		Departamento dep3= new Departamento(null,"Mobilidade Urbana","transp@sjc.sp.gov.br",400, "3925-2000");
		Departamento dep4= new Departamento(null,"Defesa Civil","transp@sjc.sp.gov.br",10, "3929-1012");
		
		dep1.setEndereco(rua1020);
		dep2.setEndereco(rua10);
		dep3.setEndereco(rua102);
		dep4.setEndereco(rua109);
		departamentoRepository.save(dep1);
		departamentoRepository.save(dep2);
		departamentoRepository.save(dep3);
		departamentoRepository.save(dep4);
		
	}

	protected void instantiateTestDatabase2() throws ParseException {
		Endereco rua1500 = new Endereco(null, "Rua Antonio Marcos de Oliveira", "Jardim Mariana II", "Leste",
				"12226870");
		Endereco rua1501 = new Endereco(null, "Rua Carmelindo Aparecido Correa", "Jardim Mariana II", "Leste",
				"12226872");
		Endereco rua1502 = new Endereco(null, "Rua Doutor Antônio Borges de Toledo", "Jardim Mariana II", "Leste",
				"12226874");
		Endereco rua1503 = new Endereco(null, "Rua Gonçalo Soares", "Jardim Mariana II", "Leste", "12226876");
		Endereco rua1504 = new Endereco(null, "Rua Joaquim Antonio Martins", "Jardim Mariana II", "Leste", "12226877");
		Endereco rua1505 = new Endereco(null, "Rua Maria Angélia Monteiro Rodrigues", "Jardim Mariana II", "Leste",
				"12226878");
		Endereco rua1506 = new Endereco(null, "Rua Ken Ishizucka", "Jardim Mariana II", "Leste", "12226879");
		Endereco rua1507 = new Endereco(null, "Rua Maurício Maldonado Júnior", "Jardim Mariana II", "Leste",
				"12226880");
		Endereco rua1508 = new Endereco(null, "Rua Sebastião Ramos Nogueira", "Jardim Mariana II", "Leste", "12226882");
		Endereco rua1509 = new Endereco(null, "Rua Alceu Andrade", "Jardim Mariana II", "Leste", "12226883");
		Endereco rua1510 = new Endereco(null, "Rua Maria de Andrade Vieira", "Jardim Mariana II", "Leste", "12226884");
		Endereco rua1511 = new Endereco(null, "Avenida Mariana Andrade", "Jardim Mariana II", "Leste", "12226886");
		Endereco rua1512 = new Endereco(null, "Rua Benedicto Rezende de Souza", "Jardim Mariana II", "Leste",
				"12226888");
		Endereco rua1513 = new Endereco(null, "Praça Pedro Americo", "Jardim Maringá", "Centro", "12243570");
		Endereco rua1514 = new Endereco(null, "Rua Euclides da Cunha", "Jardim Maringá", "Centro", "12243580");
		Endereco rua1515 = new Endereco(null, "Rua General Osório", "Jardim Maringá", "Centro", "12243590");
		Endereco rua1516 = new Endereco(null, "Rua Casemiro de Abreu", "Jardim Maringá", "Centro", "12243600");
		Endereco rua1517 = new Endereco(null, "Rua Décio Camargo Vieira", "Jardim Maringá", "Centro", "12245534");
		Endereco rua1518 = new Endereco(null, "Rua Minervina de Campos Nascimento", "Jardim Maritéia", "Norte",
				"12212440");
		Endereco rua1519 = new Endereco(null, "Rua Virgílio Emídio Bispo", "Jardim Maritéia", "Norte", "12212450");
		Endereco rua1520 = new Endereco(null, "Rua Cândido Gonçalves de Bem", "Jardim Maritéia", "Norte", "12212460");
		Endereco rua1521 = new Endereco(null, "Rua Sargento Sílvio Guizão", "Jardim Maritéia", "Norte", "12212470");
		Endereco rua1522 = new Endereco(null, "Rua Verona", "Jardim Mesquita", "Sul", "12229004");
		Endereco rua1523 = new Endereco(null, "Rua Turim", "Jardim Mesquita", "Sul", "12229381");
		Endereco rua1524 = new Endereco(null, "Rua Blumenau", "Jardim Mesquita", "Sul", "12229382");
		Endereco rua1525 = new Endereco(null, "Rua Barcelona", "Jardim Mesquita", "Sul", "12229490");
		Endereco rua1526 = new Endereco(null, "Rua Veneza", "Jardim Mesquita", "Sul", "12229500");
		Endereco rua1527 = new Endereco(null, "Rodovia Presidente Dutra", " km 143", "Jardim Motorama", "Leste");
		Endereco rua1528 = new Endereco(null, "Avenida das Rosas", "Jardim Motorama", "Leste", "12224000");
		Endereco rua1529 = new Endereco(null, "Avenida Segundo-Sargento Clarismundo da Silva", "Jardim Motorama",
				"Leste", "12224001");
		Endereco rua1530 = new Endereco(null, "Rua dos Lírios", "Jardim Motorama", "Leste", "12224010");
		Endereco rua1531 = new Endereco(null, "Praça Benedito Antônio de Oliveira", "Jardim Motorama", "Leste",
				"12224011");
		Endereco rua1532 = new Endereco(null, "Rua Projetada", "Jardim Motorama", "Leste", "12224012");
		Endereco rua1533 = new Endereco(null, "Rua das Maravilhas", "Jardim Motorama", "Leste", "12224020");
		Endereco rua1534 = new Endereco(null, "Rua das Papoulas", "Jardim Motorama", "Leste", "12224030");
		Endereco rua1535 = new Endereco(null, "Rua das Sensitivas", "Jardim Motorama", "Leste", "12224040");
		Endereco rua1536 = new Endereco(null, "Rua dos Trevos", "Jardim Motorama", "Leste", "12224050");
		Endereco rua1537 = new Endereco(null, "Rua das Azaléas", "Jardim Motorama", "Leste", "12224060");
		Endereco rua1538 = new Endereco(null, "Rua dos Ciclames", "Jardim Motorama", "Leste", "12224070");
		Endereco rua1539 = new Endereco(null, "Rua das Dâlias", "Jardim Motorama", "Leste", "12224080");
		Endereco rua1540 = new Endereco(null, "Rua das Margaridas", "Jardim Motorama", "Leste", "12224090");
		Endereco rua1541 = new Endereco(null, "Rua dos Miosótis", "Jardim Motorama", "Leste", "12224100");
		Endereco rua1542 = new Endereco(null, "Rua das Peonias", "Jardim Motorama", "Leste", "12224110");
		Endereco rua1543 = new Endereco(null, "Avenida Camerino Pereira dos Santos", "Jardim Motorama", "Leste",
				"12224120");
		Endereco rua1544 = new Endereco(null, "Rua das Orquídeas", "Jardim Motorama", "Leste", "12224130");
		Endereco rua1545 = new Endereco(null, "Rua das Verbenas", "Jardim Motorama", "Leste", "12224140");
		Endereco rua1546 = new Endereco(null, "Travessa Gabriel Alves Freire", "Jardim Motorama", "Leste", "12224150");
		Endereco rua1547 = new Endereco(null, "Rua das Violetas", "Jardim Motorama", "Leste", "12224160");
		Endereco rua1548 = new Endereco(null, "Rua das Glicínias", "Jardim Motorama", "Leste", "12224170");
		Endereco rua1549 = new Endereco(null, "Avenida Vitória Régia", "Jardim Motorama", "Leste", "12224180");
		Endereco rua1550 = new Endereco(null, "Rua das Cravinas", "Jardim Motorama", "Leste", "12224190");
		Endereco rua1551 = new Endereco(null, "Rua das Hortencias", "Jardim Motorama", "Leste", "12224200");
		Endereco rua1552 = new Endereco(null, "Rua dos Heliotrópios", "Jardim Motorama", "Leste", "12224210");
		Endereco rua1553 = new Endereco(null, "Rua dos Jasmins", "Jardim Motorama", "Leste", "12224220");
		Endereco rua1554 = new Endereco(null, "Rua das Gardenias", "Jardim Motorama", "Leste", "12224230");
		Endereco rua1555 = new Endereco(null, "Rua das Petúnias", "Jardim Motorama", "Leste", "12224240");
		Endereco rua1556 = new Endereco(null, "Praça Virginio Valias de Resende", "Jardim Motorama", "Leste",
				"12224245");
		Endereco rua1557 = new Endereco(null, "Rua dos Gerânios", "Jardim Motorama", "Leste", "12224250");
		Endereco rua1558 = new Endereco(null, "Rua das Angelicas", "Jardim Motorama", "Leste", "12224260");
		Endereco rua1559 = new Endereco(null, "Avenida dos Narcisos", "Jardim Motorama", "Leste", "12224270");
		Endereco rua1560 = new Endereco(null, "Praça Primavera", "Jardim Motorama", "Leste", "12224280");
		Endereco rua1561 = new Endereco(null, "Avenida das Tulipas", "Jardim Motorama", "Leste", "12224290");
		Endereco rua1562 = new Endereco(null, "Rodovia Presidente Dutra", "Jardim Motorama", "Leste", "12224300");
		Endereco rua1563 = new Endereco(null, "Avenida Manoel Borba Gato", "Jardim Nova América", "Centro", "12242270");
		Endereco rua1564 = new Endereco(null, "Praça Nossa Senhora de Fátima", "Jardim Nova América", "Centro",
				"12242271");
		Endereco rua1565 = new Endereco(null, "Avenida Anchieta", "Jardim Nova América", "Centro", "12242280");
		Endereco rua1566 = new Endereco(null, "Praça Alexandra Diacov", "Jardim Nova América", "Centro", "12242281");
		Endereco rua1567 = new Endereco(null, "Rua Brás Cubas", "Jardim Nova América", "Centro", "12242300");
		Endereco rua1568 = new Endereco(null, "Rua Fernão Dias", "Jardim Nova América", "Centro", "12242580");
		Endereco rua1569 = new Endereco(null, "Rua Antônio Rodrigues Arzão", "Jardim Nova América", "Centro",
				"12242600");
		Endereco rua1570 = new Endereco(null, "Rua Raposo Tavares", "Jardim Nova América", "Centro", "12242610");
		Endereco rua1571 = new Endereco(null, "Rua Domingos Jorge Velho", "Jardim Nova América", "Centro", "12242615");
		Endereco rua1572 = new Endereco(null, "Rua Pascoal Moreira", "Jardim Nova América", "Centro", "12242670");
		Endereco rua1573 = new Endereco(null, "Avenida Benedito Friggi", "Jardim Nova Detroit", "Leste", "12224480");
		Endereco rua1574 = new Endereco(null, "Rua Júlio Ferreira dos Santos", "Jardim Nova Detroit", "Leste",
				"12224490");
		Endereco rua1575 = new Endereco(null, "Rua Doutor Max Michaelis", "Jardim Nova Detroit", "Leste", "12224500");
		Endereco rua1576 = new Endereco(null, "Rua Antero Cursino dos Santos", "Jardim Nova Detroit", "Leste",
				"12224510");
		Endereco rua1577 = new Endereco(null, "Rua Ângelo Pintus", "Jardim Nova Detroit", "Leste", "12224520");
		Endereco rua1578 = new Endereco(null, "Rua Jorge Pereira de Melo", "Jardim Nova Detroit", "Leste", "12224530");
		Endereco rua1579 = new Endereco(null, "Rua Mathilde Neme Bagdad", "Jardim Nova Detroit", "Leste", "12224540");
		Endereco rua1580 = new Endereco(null, "Rua Cândido Barbosa", "Jardim Nova Detroit", "Leste", "12224550");
		Endereco rua1581 = new Endereco(null, "Avenida Brás Domingos de Arantes", "Jardim Nova Detroit", "Leste",
				"12224555");
		Endereco rua1582 = new Endereco(null, "Rua Procópio Ferreira", "Jardim Nova Detroit", "Leste", "12224570");
		Endereco rua1583 = new Endereco(null, "Rua Orlando Silva", "Jardim Nova Detroit", "Leste", "12224580");
		Endereco rua1584 = new Endereco(null, "Rua Luiz Monteiro", "Jardim Nova Detroit", "Leste", "12224590");
		Endereco rua1585 = new Endereco(null, "Rua Izaltino Silva", "Jardim Nova Detroit", "Leste", "12224600");
		Endereco rua1586 = new Endereco(null, "Rua Alcidia Medeiros Ragazzini", "Jardim Nova Detroit", "Leste",
				"12224610");
		Endereco rua1587 = new Endereco(null, "Rua Pedro Venuto Ragazini", "Jardim Nova Detroit", "Leste", "12224620");
		Endereco rua1588 = new Endereco(null, "Rua Inesia Pinheiro Soares", "Jardim Nova Detroit", "Leste", "12224630");
		Endereco rua1589 = new Endereco(null, "Rua André Lourenço Loubet", "Jardim Nova Detroit", "Leste", "12224640");
		Endereco rua1590 = new Endereco(null, "Rua Segundo-Sargento Clarismundo Silva", "Jardim Nova Detroit", "Leste",
				"12224650");
		Endereco rua1591 = new Endereco(null, "Rua Benedito Gomes dos Santos", "Jardim Nova Detroit", "Leste",
				"12224660");
		Endereco rua1592 = new Endereco(null, "Rua Alexandrina Maria da Conceição", "Jardim Nova Detroit", "Leste",
				"12224670");
		Endereco rua1593 = new Endereco(null, "Rua Anésio Rodrigues Araújo", "Jardim Nova Detroit", "Leste",
				"12224680");
		Endereco rua1594 = new Endereco(null, "Rua Doutor Waldomiro Martins Pinheiro", "Jardim Nova Detroit", "Leste",
				"12224690");
		Endereco rua1595 = new Endereco(null, "Rua Maria Salena de Assis", "Jardim Nova Detroit", "Leste", "12224700");
		Endereco rua1596 = new Endereco(null, "Rua Dezesseis", "Jardim Nova Detroit", "Leste", "12224701");
		Endereco rua1597 = new Endereco(null, "Avenida João Pedro", "Jardim Nova Detroit", "Leste", "12224702");
		Endereco rua1598 = new Endereco(null, "Avenida Monsenhor Dutra", "Jardim Nova Flórida", "Leste", "12225055");
		Endereco rua1599 = new Endereco(null, "Rua Cirilo Pereira da Silva", "Jardim Nova Flórida", "Leste",
				"12225065");
		Endereco rua1600 = new Endereco(null, "Rua Jorge Leite da Silva", "Jardim Nova Flórida", "Leste", "12225075");
		Endereco rua1601 = new Endereco(null, "Rua Francisca Paula de Jesus Izabel", "Jardim Nova Flórida", "Leste",
				"12225085");
		Endereco rua1602 = new Endereco(null, "Rua Elio Corazza Júnior", "Jardim Nova Flórida", "Leste", "12225095");
		Endereco rua1603 = new Endereco(null, "Rua Francisco Miele", "Jardim Nova Flórida", "Leste", "12225096");
		Endereco rua1604 = new Endereco(null, "Rua Carmem Franklin", "Jardim Nova Flórida", "Leste", "12225097");
		Endereco rua1605 = new Endereco(null, "Rua Aparecida Maria Consiglio", "Jardim Nova Michigan", "Leste",
				"12225400");
		Endereco rua1606 = new Endereco(null, "Rua Crisante Barbosa Miranda", "Jardim Nova Michigan", "Leste",
				"12225410");
		Endereco rua1607 = new Endereco(null, "Rua Francisco Moreira de Souza", "Jardim Nova Michigan", "Leste",
				"12225420");
		Endereco rua1608 = new Endereco(null, "Avenida Presidente Tancredo Neves", "Jardim Nova Michigan", "Leste",
				"12225421");
		Endereco rua1609 = new Endereco(null, "Travessa Aparecida Maria Consiglio", "Jardim Nova Michigan II", "Leste",
				"12225422");
		Endereco rua1610 = new Endereco(null, "Rua Ruy Pereira Gomes", "Jardim Nova Michigan II", "Leste", "12225423");
		Endereco rua1611 = new Endereco(null, "Travessa Luiz Carlos Ossamu Kishi", "Jardim Nova Michigan II", "Leste",
				"12225424");
		Endereco rua1612 = new Endereco(null, "Travessa Dimas Moreira dos Santos", "Jardim Nova Michigan II", "Leste",
				"12225425");
		Endereco rua1613 = new Endereco(null, "Rua Fernanda Paula Silva Duarte", "Jardim Nova Michigan II", "Leste",
				"12225426");
		Endereco rua1614 = new Endereco(null, "Rua Professora Maria José de Oliveira", "Jardim Nova Michigan", "Leste",
				"12225430");
		Endereco rua1615 = new Endereco(null, "Rua Professora Maria Helena Moreira de Queiroz", "Jardim Nova Michigan",
				"Leste", "12225440");
		Endereco rua1616 = new Endereco(null, "Rua Maria Isabel Mendes", "Jardim Nova Michigan", "Leste", "12225450");
		Endereco rua1617 = new Endereco(null, "Rua Giovanni Batista Capellotto", "Jardim Nova Michigan", "Leste",
				"12225460");
		Endereco rua1618 = new Endereco(null, "Estrada do Mato Dentro", "Jardim Nova Michigan", "Leste", "12225470");
		Endereco rua1619 = new Endereco(null, "Rua Dominga Senhora de Jesus", "Jardim Nova República", "Sul",
				"12234850");
		Endereco rua1620 = new Endereco(null, "Rua Patrícia Maria Hipólito", "Jardim Nova República", "Sul",
				"12234852");
		Endereco rua1621 = new Endereco(null, "Rua David Felix de Souza", "Jardim Nova República", "Sul", "12234854");
		Endereco rua1622 = new Endereco(null, "Rua José de Anchieta Carvalho", "Jardim Nova República", "Sul",
				"12234856");
		Endereco rua1623 = new Endereco(null, "Rua Amanda Gabrielle Friggi", "Jardim Nova República", "Sul",
				"12234858");
		Endereco rua1624 = new Endereco(null, "Rua Nelson Karatanasov", "Jardim Nova República", "Sul", "12234860");
		Endereco rua1625 = new Endereco(null, "Avenida Cabo Lúcio Mauro da Silva Moreira", "Jardim Nova República",
				"Sul", "12234862");
		Endereco rua1626 = new Endereco(null, "Avenida Três", "Jardim Nova República", "Sul", "12234864");
		Endereco rua1627 = new Endereco(null, "Rua Mario Cordeiro", "Jardim Nova República", "Sul", "12234866");
		Endereco rua1628 = new Endereco(null, "Rua Voluntários do Rotary", "Jardim Nova República", "Sul", "12234868");
		Endereco rua1629 = new Endereco(null, "Rua Osvaldo Caldardo", "Jardim Nova República", "Sul", "12234870");
		Endereco rua1630 = new Endereco(null, "Avenida Cecilia Lucio de Almeida Mota", "Jardim Nova República", "Sul",
				"12234874");
		Endereco rua1631 = new Endereco(null, "Rua Adelmo Liberato", "Jardim Nova República", "Sul", "12234876");
		Endereco rua1632 = new Endereco(null, "Rua Maestro Darcy Rogériio Claudino", "Jardim Nova República", "Sul",
				"12234878");
		Endereco rua1633 = new Endereco(null, "Rua Julio Tognetti", "Jardim Nova República", "Sul", "12234880");
		Endereco rua1634 = new Endereco(null, "Rua Maria Del Pilar Rozas Rozados Theodoro", "Jardim Nova República",
				"Sul", "12234882");
		Endereco rua1635 = new Endereco(null, "Rua Sebastião José Garcia", "Jardim Nova República", "Sul", "12234884");
		Endereco rua1636 = new Endereco(null, "Rua José Carlos das Neves", "Jardim Nova República", "Sul", "12234886");
		Endereco rua1637 = new Endereco(null, "Rua Adilson Carlos Alves", "Jardim Nova República", "Sul", "12234888");
		Endereco rua1638 = new Endereco(null, "Rua Julia Mola Maldos", "Jardim Nova República", "Sul", "12234890");
		Endereco rua1639 = new Endereco(null, "Rua José Santana Mariano", "Jardim Nova República", "Sul", "12234892");
		Endereco rua1640 = new Endereco(null, "Rua Maria Otília Araújo Lima de Oliveira", "Jardim Nova República",
				"Sul", "12234894");
		Endereco rua1641 = new Endereco(null, "Rua Cabo Antonio Rodrigues de Souza", "Jardim Nova República", "Sul",
				"12234896");
		Endereco rua1642 = new Endereco(null, "Rua Adelino Mendonça", "Jardim Olímpia", "Leste", "12221250");
		Endereco rua1643 = new Endereco(null, "Praça Natanael Mariano da Silva", "Jardim Olímpia", "Leste", "12221261");
		Endereco rua1644 = new Endereco(null, "Rua Brinda Guida Filho", "Jardim Olímpia", "Leste", "12221270");
		Endereco rua1645 = new Endereco(null, "Rua Nazareth de Moura Veronese", "Jardim Olímpia", "Leste", "12221280");
		Endereco rua1646 = new Endereco(null, "Rua Mamede Firmino de Morais", "Jardim Olímpia", "Leste", "12221290");
		Endereco rua1647 = new Endereco(null, "Avenida Tokio", "Jardim Oriente", "Sul", "12236000");
		Endereco rua1648 = new Endereco(null, "Rua Alfredo Nobel", "Jardim Oriente", "Sul", "12236010");
		Endereco rua1649 = new Endereco(null, "Rua Tottoni", "Jardim Oriente", "Sul", "12236020");
		Endereco rua1650 = new Endereco(null, "Praça Yamagata", "Jardim Oriente", "Sul", "12236021");
		Endereco rua1651 = new Endereco(null, "Rua Hokaido", "Jardim Oriente", "Sul", "12236030");
		Endereco rua1652 = new Endereco(null, "Avenida Hiroshima", "Jardim Oriente", "Sul", "12236040");
		Endereco rua1653 = new Endereco(null, "Rua das Chácaras", "Jardim Oriente", "Sul", "12236080");
		Endereco rua1654 = new Endereco(null, "Rua Yamaguti", "Jardim Oriente", "Sul", "12236081");
		Endereco rua1655 = new Endereco(null, "Rua Particular", "Jardim Oriente", "Sul", "12236082");
		Endereco rua1656 = new Endereco(null, "Rua Nagano", "Jardim Oriente", "Sul", "12236090");
		Endereco rua1657 = new Endereco(null, "Rua Hondo", "Jardim Oriente", "Sul", "12236100");
		Endereco rua1658 = new Endereco(null, "Rua Marco Túlio Cícero", "Jardim Oriente", "Sul", "12236110");
		Endereco rua1659 = new Endereco(null, "Rua Colombo", "Jardim Oriente", "Sul", "12236120");
		Endereco rua1660 = new Endereco(null, "Rua Tupi", "Jardim Oriente", "Sul", "12236121");
		Endereco rua1661 = new Endereco(null, "Rua Taru", "Jardim Oriente", "Sul", "12236130");
		Endereco rua1662 = new Endereco(null, "Rua Saitama", "Jardim Oriente", "Sul", "12236140");
		Endereco rua1663 = new Endereco(null, "Rua Osaka", "Jardim Oriente", "Sul", "12236150");
		Endereco rua1664 = new Endereco(null, "Praça Mikado", "Jardim Oriente", "Sul", "12236160");
		Endereco rua1665 = new Endereco(null, "Avenida Saga", "Jardim Oriente", "Sul", "12236170");
		Endereco rua1666 = new Endereco(null, "Rua Kumamoto", "Jardim Oriente", "Sul", "12236180");
		Endereco rua1667 = new Endereco(null, "Rua do Comércio", "Jardim Oriente", "Sul", "12236181");
		Endereco rua1668 = new Endereco(null, "Praça Alexandre Magno", "Jardim Oriente", "Sul", "12236190");
		Endereco rua1669 = new Endereco(null, "Rua Leonardo da Vinci", "Jardim Oriente", "Sul", "12236200");
		Endereco rua1670 = new Endereco(null, "Rua Miguel Ângelo", "Jardim Oriente", "Sul", "12236210");
		Endereco rua1671 = new Endereco(null, "Rua Marco Polo", "Jardim Oriente", "Sul", "12236220");
		Endereco rua1672 = new Endereco(null, "Rua Santo Inácio de Loyola", "Jardim Oriente", "Sul", "12236230");
		Endereco rua1673 = new Endereco(null, "Praça Victor Hugo", "Jardim Oriente", "Sul", "12236231");
		Endereco rua1674 = new Endereco(null, "Rua Isaac Newton", "Jardim Oriente", "Sul", "12236240");
		Endereco rua1675 = new Endereco(null, "Rua Guilherme Marconi", "Jardim Oriente", "Sul", "12236250");
		Endereco rua1676 = new Endereco(null, "Rua Benjamim Franklin", "Jardim Oriente", "Sul", "12236260");
		Endereco rua1677 = new Endereco(null, "Rua George Washington", "Jardim Oriente", "Sul", "12236390");
		Endereco rua1678 = new Endereco(null, "Rua Júlio Cezar", "Jardim Oriente", "Sul", "12236400");
		Endereco rua1679 = new Endereco(null, "Rua São Tomás de Aquino", "Jardim Oriente", "Sul", "12236410");
		Endereco rua1680 = new Endereco(null, "Rua Taru", " s/n", "Jardim Oriente", "Sul");
		Endereco rua1681 = new Endereco(null, "Rua Siria", "Jardim Oswaldo Cruz", "Centro", "12216530");
		Endereco rua1682 = new Endereco(null, "Rua República do Iraque", "Jardim Oswaldo Cruz", "Centro", "12216540");
		Endereco rua1683 = new Endereco(null, "Rua Jordânia", "Jardim Oswaldo Cruz", "Centro", "12216550");
		Endereco rua1684 = new Endereco(null, "Rua Bélgica", "Jardim Oswaldo Cruz", "Centro", "12216560");
		Endereco rua1685 = new Endereco(null, "Rua Holanda", "Jardim Oswaldo Cruz", "Centro", "12216570");
		Endereco rua1686 = new Endereco(null, "Avenida Deputado Benedito Matarazzo", "Jardim Oswaldo Cruz", "Centro",
				"12216580");
		Endereco rua1687 = new Endereco(null, "Rua República do Líbano", "Jardim Oswaldo Cruz", "Centro", "12216590");
		Endereco rua1688 = new Endereco(null, "Praça República Arabe Unida", "Jardim Oswaldo Cruz", "Centro",
				"12216591");
		Endereco rua1689 = new Endereco(null, "Rua Iran", "Jardim Oswaldo Cruz", "Centro", "12216600");
		Endereco rua1690 = new Endereco(null, "Rua República de Israel", "Jardim Oswaldo Cruz", "Centro", "12216620");
		Endereco rua1691 = new Endereco(null, "Rua Turquia", "Jardim Oswaldo Cruz", "Centro", "12216623");
		Endereco rua1692 = new Endereco(null, "Rua Moscou", "Jardim Oswaldo Cruz", "Centro", "12216700");
		Endereco rua1693 = new Endereco(null, "Rua Viena", "Jardim Oswaldo Cruz", "Centro", "12216720");
		Endereco rua1694 = new Endereco(null, "Rua Bucareste", "Jardim Oswaldo Cruz", "Centro", "12216740");
		Endereco rua1695 = new Endereco(null, "Rua Oswaldo da Silva Chaves", "Jardim Ouro Preto", "Norte", "12211470");
		Endereco rua1696 = new Endereco(null, "Rua João Di Mônaco", "Jardim Paraíso do Sol", "Sul", "12225120");
		Endereco rua1697 = new Endereco(null, "Avenida Jupira do Amaral Rangel", "Jardim Paraíso do Sol", "Sul",
				"12225130");
		Endereco rua1698 = new Endereco(null, "Rua Aldo Madureira", "Jardim Paraíso do Sol", "Sul", "12225140");
		Endereco rua1699 = new Endereco(null, "Rua Vantuilde José Brandão", "Jardim Paraíso do Sol", "Sul", "12225150");
		Endereco rua1700 = new Endereco(null, "Rua Padre José Maria da Silva Ramos", "Jardim Paraíso do Sol", "Sul",
				"12225160");
		Endereco rua1701 = new Endereco(null, "Rua Doutor João Gomes Batista Neto", "Jardim Paraíso do Sol", "Sul",
				"12225170");
		Endereco rua1702 = new Endereco(null, "Rua Nelson Alves de Oliveira", "Jardim Paraíso do Sol", "Sul",
				"12225180");
		Endereco rua1703 = new Endereco(null, "Rua Pastor Jair Alves da Costa", "Jardim Paraíso do Sol", "Sul",
				"12225190");
		Endereco rua1704 = new Endereco(null, "Rua Mantura Neme", "Jardim Paraíso do Sol", "Sul", "12225200");
		Endereco rua1705 = new Endereco(null, "Rua Guedes Diamante", "Jardim Paraíso do Sol", "Sul", "12225210");
		Endereco rua1706 = new Endereco(null, "Avenida Presidente Tancredo Neves", "Jardim Paraíso do Sol", "Sul",
				"12225211");
		Endereco rua1707 = new Endereco(null, "Rua Benedicto Albino Tomaz", "Jardim Paraíso do Sol", "Sul", "12225212");
		Endereco rua1708 = new Endereco(null, "Rua Rita Teixeira Leite", "Jardim Paraíso do Sol", "Sul", "12225220");
		Endereco rua1709 = new Endereco(null, "Rua Paulo Salem", "Jardim Paraíso do Sol", "Sul", "12225230");
		Endereco rua1710 = new Endereco(null, "Avenida Maria Adolfina de Almeida Tomaz", "Jardim Paraíso do Sol", "Sul",
				"12225240");
		Endereco rua1711 = new Endereco(null, "Rua Professor Luiz Antônio Ribeiro de Macedo", "Jardim Paraíso do Sol",
				"Sul", "12225250");
		Endereco rua1712 = new Endereco(null, "Estrada para Piedade", "Jardim Paraíso do Sol", "Sul", "12225390");
		Endereco rua1713 = new Endereco(null, "Rua Sumatra", "Jardim Paraíso", "Sul", "12235410");
		Endereco rua1714 = new Endereco(null, "Rua Mindanau", "Jardim Paraíso", "Sul", "12235430");
		Endereco rua1715 = new Endereco(null, "Rua Cosmos", "Jardim Paraíso", "Sul", "12235440");
		Endereco rua1716 = new Endereco(null, "Rua Madagascar", "Jardim Paraíso", "Sul", "12235450");
		Endereco rua1717 = new Endereco(null, "Avenida Paraiso", "Jardim Paraíso", "Sul", "12235460");
		Endereco rua1718 = new Endereco(null, "Rua Ilha do Norte", "Jardim Paraíso", "Sul", "12235470");
		Endereco rua1719 = new Endereco(null, "Rua Islândia", "Jardim Paraíso", "Sul", "12235480");
		Endereco rua1720 = new Endereco(null, "Rua Ilha do Sul", "Jardim Paraíso", "Sul", "12235490");
		Endereco rua1721 = new Endereco(null, "Rua Java", "Jardim Paraíso", "Sul", "12235500");
		Endereco rua1722 = new Endereco(null, "Rua Nova Guine", "Jardim Paraíso", "Sul", "12235501");
		Endereco rua1723 = new Endereco(null, "Rua João Di Mônaco", "Jardim Paraíso do Sol", "Leste", "12225120");
		Endereco rua1724 = new Endereco(null, "Avenida Jupira do Amaral Rangel", "Jardim Paraíso do Sol", "Leste",
				"12225130");
		Endereco rua1725 = new Endereco(null, "Rua Aldo Madureira", "Jardim Paraíso do Sol", "Leste", "12225140");
		Endereco rua1726 = new Endereco(null, "Rua Vantuilde José Brandão", "Jardim Paraíso do Sol", "Leste",
				"12225150");
		Endereco rua1727 = new Endereco(null, "Rua Padre José Maria da Silva Ramos", "Jardim Paraíso do Sol", "Leste",
				"12225160");
		Endereco rua1728 = new Endereco(null, "Rua Doutor João Gomes Batista Neto", "Jardim Paraíso do Sol", "Leste",
				"12225170");
		Endereco rua1729 = new Endereco(null, "Rua Nelson Alves de Oliveira", "Jardim Paraíso do Sol", "Leste",
				"12225180");
		Endereco rua1730 = new Endereco(null, "Rua Pastor Jair Alves da Costa", "Jardim Paraíso do Sol", "Leste",
				"12225190");
		Endereco rua1731 = new Endereco(null, "Rua Mantura Neme", "Jardim Paraíso do Sol", "Leste", "12225200");
		Endereco rua1732 = new Endereco(null, "Rua Guedes Diamante", "Jardim Paraíso do Sol", "Leste", "12225210");
		Endereco rua1733 = new Endereco(null, "Avenida Presidente Tancredo Neves", "Jardim Paraíso do Sol", "Leste",
				"12225211");
		Endereco rua1734 = new Endereco(null, "Rua Benedicto Albino Tomaz", "Jardim Paraíso do Sol", "Leste",
				"12225212");
		Endereco rua1735 = new Endereco(null, "Rua Rita Teixeira Leite", "Jardim Paraíso do Sol", "Leste", "12225220");
		Endereco rua1736 = new Endereco(null, "Rua Paulo Salem", "Jardim Paraíso do Sol", "Leste", "12225230");
		Endereco rua1737 = new Endereco(null, "Avenida Maria Adolfina de Almeida Tomaz", "Jardim Paraíso do Sol",
				"Leste", "12225240");
		Endereco rua1738 = new Endereco(null, "Rua Professor Luiz Antônio Ribeiro de Macedo", "Jardim Paraíso do Sol",
				"Leste", "12225250");
		Endereco rua1739 = new Endereco(null, "Estrada para Piedade", "Jardim Paraíso do Sol", "Leste", "12225390");
		Endereco rua1740 = new Endereco(null, "Rua Rio Guaiba", "Jardim Pararangaba", "Leste", "12224710");
		Endereco rua1741 = new Endereco(null, "Rua Rio Una", "Jardim Pararangaba", "Leste", "12224720");
		Endereco rua1742 = new Endereco(null, "Rua Rio São Francisco", "Jardim Pararangaba", "Leste", "12224730");
		Endereco rua1743 = new Endereco(null, "Rua Rio Paraíba do Sul", "Jardim Pararangaba", "Leste", "12224740");
		Endereco rua1744 = new Endereco(null, "Rua Rio Trombetas", "Jardim Pararangaba", "Leste", "12224750");
		Endereco rua1745 = new Endereco(null, "Rua Rio Tietê", "Jardim Pararangaba", "Leste", "12224760");
		Endereco rua1746 = new Endereco(null, "Rua Rio Jurubatuba", "Jardim Pararangaba", "Leste", "12224770");
		Endereco rua1747 = new Endereco(null, "Avenida Sansão Peres de Andrade", "Jardim Pararangaba", "Leste",
				"12224775");
		Endereco rua1748 = new Endereco(null, "Avenida Rio Madeira", "Jardim Pararangaba", "Leste", "12224780");
		Endereco rua1749 = new Endereco(null, "Rua Anna Rosa de Moraes", "Jardim Pararangaba", "Leste", "12224781");
		Endereco rua1750 = new Endereco(null, "Rua José Pardo", "Jardim Pararangaba", "Leste", "12224783");
		Endereco rua1751 = new Endereco(null, "Rua Maria Aparecida do Carmo Silva", "Jardim Pararangaba", "Leste",
				"12224784");
		Endereco rua1752 = new Endereco(null, "Rua Milton Rodrigues", "Jardim Pararangaba", "Leste", "12224785");
		Endereco rua1753 = new Endereco(null, "Rua Benedita Alves de Carvalho", "Jardim Pararangaba", "Leste",
				"12224786");
		Endereco rua1754 = new Endereco(null, "Rua Angelina Borgo Gregório", "Jardim Pararangaba", "Leste", "12224788");
		Endereco rua1755 = new Endereco(null, "Rua Sebastião Messias da Silva", "Jardim Pararangaba", "Leste",
				"12224789");
		Endereco rua1756 = new Endereco(null, "Avenida Pararangaba", "Jardim Pararangaba", "Leste", "12224790");
		Endereco rua1757 = new Endereco(null, "Rua Elton Sebastião da Silva", "Jardim Pararangaba", "Leste",
				"12224791");
		Endereco rua1758 = new Endereco(null, "Rua Enéas Silva Machado", "Jardim Pararangaba", "Leste", "12224792");
		Endereco rua1759 = new Endereco(null, "Rua Marcílio Benedito Costa", "Jardim Pararangaba", "Leste", "12224793");
		Endereco rua1760 = new Endereco(null, "Rua José Barreto Silva", "Jardim Pararangaba", "Leste", "12224794");
		Endereco rua1761 = new Endereco(null, "Rua Jorge Pires de Camargo", "Jardim Pararangaba", "Leste", "12224799");
		Endereco rua1762 = new Endereco(null, "Rua Rio Paru", "Jardim Pararangaba", "Leste", "12224800");
		Endereco rua1763 = new Endereco(null, "Rua Rio Tibagi", "Jardim Pararangaba", "Leste", "12224801");
		Endereco rua1764 = new Endereco(null, "Rua Rio Natuba", "Jardim Pararangaba", "Leste", "12224810");
		Endereco rua1765 = new Endereco(null, "Praça Capitão Pedro Pinto da Cunha", "Jardim Paulista", "Centro",
				"12215650");
		Endereco rua1766 = new Endereco(null, "Avenida Santos Dumont", "Jardim Paulista", "Centro", "12215651");
		Endereco rua1767 = new Endereco(null, "Avenida Nair Toledo de Mira", "Jardim Paulista", "Centro", "12215656");
		Endereco rua1768 = new Endereco(null, "Rua Tupã", "Jardim Paulista", "Centro", "12215660");
		Endereco rua1769 = new Endereco(null, "Rua Umuarama", "Jardim Paulista", "Centro", "12215730");
		Endereco rua1770 = new Endereco(null, "Travessa Pastor João Vera Pelegrino", "Jardim Paulista", "Centro",
				"12215740");
		Endereco rua1771 = new Endereco(null, "Viaduto Bandeirante", "Jardim Paulista", "Centro", "12215760");
		Endereco rua1772 = new Endereco(null, "Rua Iara", "Jardim Paulista", "Centro", "12215840");
		Endereco rua1773 = new Endereco(null, "Avenida Deputado Benedito Matarazzo", " 9403", "Jardim Paulista",
				"Centro");
		Endereco rua1774 = new Endereco(null, "Avenida Pedro Álvares Cabral", "Jardim Paulista", "Centro", "12216000");
		Endereco rua1775 = new Endereco(null, "Rua Mem de Sá", "Jardim Paulista", "Centro", "12216001");
		Endereco rua1776 = new Endereco(null, "Rua José Diogo de Faria", "Jardim Paulista", "Centro", "12216002");
		Endereco rua1777 = new Endereco(null, "Praça Carlos Gomes", "Jardim Paulista", "Centro", "12216010");
		Endereco rua1778 = new Endereco(null, "Rua Castro Alves", "Jardim Paulista", "Centro", "12216020");
		Endereco rua1779 = new Endereco(null, "Rua Cristóvão Colombo", "Jardim Paulista", "Centro", "12216030");
		Endereco rua1780 = new Endereco(null, "Rua Riachuelo", "Jardim Paulista", "Centro", "12216040");
		Endereco rua1781 = new Endereco(null, "Praça Duque de Caxias", "Jardim Paulista", "Centro", "12216050");
		Endereco rua1782 = new Endereco(null, "Rua João Francisco de Paula", "Jardim Paulista", "Centro", "12216051");
		Endereco rua1783 = new Endereco(null, "Rua Antônio Costa Rosendo", "Jardim Paulista", "Centro", "12216060");
		Endereco rua1784 = new Endereco(null, "Rua Presidente Vargas", "Jardim Paulista", "Centro", "12216070");
		Endereco rua1785 = new Endereco(null, "Rua Ademar Guedes de Oliveira", "Jardim Paulista", "Centro", "12216080");
		Endereco rua1786 = new Endereco(null, "Travessa Luiz de Azevedo Castro", "Jardim Paulista", "Centro",
				"12216081");
		Endereco rua1787 = new Endereco(null, "Rua Dumitilde Marcondes", "Jardim Paulista", "Centro", "12216090");
		Endereco rua1788 = new Endereco(null, "Rua José Francisco Monteiro", "Jardim Paulista", "Centro", "12216100");
		Endereco rua1789 = new Endereco(null, "Rua Coronel Pacheco Neto", "Jardim Paulista", "Centro", "12216110");
		Endereco rua1790 = new Endereco(null, "Rua Capitão José Dellias", "Jardim Paulista", "Centro", "12216120");
		Endereco rua1791 = new Endereco(null, "Rua Presidente Bernardes", "Jardim Paulista", "Centro", "12216130");
		Endereco rua1792 = new Endereco(null, "Rua Alcindo de Marchi", "Jardim Paulista", "Centro", "12216131");
		Endereco rua1793 = new Endereco(null, "Rua Engenheiro Pedro Sinisgalli", "Jardim Paulista", "Centro",
				"12216140");
		Endereco rua1794 = new Endereco(null, "Rua Professora Maria Lima Cesar", "Jardim Paulista", "Centro",
				"12216141");
		Endereco rua1795 = new Endereco(null, "Rua Frankilina Monteiro de Oliveira", "Jardim Paulista", "Centro",
				"12216150");
		Endereco rua1796 = new Endereco(null, "Rua Frederico Miacci", "Jardim Paulista", "Centro", "12216160");
		Endereco rua1797 = new Endereco(null, "Rua Samuel Antônio Rodrigues", "Jardim Paulista", "Centro", "12216161");
		Endereco rua1798 = new Endereco(null, "Rua Leopoldo Drews", "Jardim Paulista", "Centro", "12216170");
		Endereco rua1799 = new Endereco(null, "Rua Cônego José Francisco Monteiro", "Jardim Paulista", "Centro",
				"12216180");
		Endereco rua1800 = new Endereco(null, "Rua Lola Roberto Batista Rocco", "Jardim Paulista", "Centro",
				"12216191");
		Endereco rua1801 = new Endereco(null, "Praça das Nações Unidas", "Jardim Paulista", "Centro", "12216192");
		Endereco rua1802 = new Endereco(null, "Rua Caio Madureira", "Jardim Paulista", "Centro", "12216200");
		Endereco rua1803 = new Endereco(null, "Praça America Pinto de Andrade", "Jardim Paulista", "Centro",
				"12216210");
		Endereco rua1804 = new Endereco(null, "Rua Genesia Berardinelli Tarantino", "Jardim Paulista", "Centro",
				"12216220");
		Endereco rua1805 = new Endereco(null, "Rua Professor Alfredo Cesar", "Jardim Paulista", "Centro", "12216221");
		Endereco rua1806 = new Endereco(null, "Viaduto Raquel Marcondes", "Jardim Paulista", "Centro", "12216222");
		Endereco rua1807 = new Endereco(null, "Rua Antônio Porfírio da Silva", "Jardim Paulista", "Centro", "12216230");
		Endereco rua1808 = new Endereco(null, "Rua Tenente Aécio Lemes de Souza", "Jardim Paulista", "Centro",
				"12216240");
		Endereco rua1809 = new Endereco(null, "Avenida Deputado Benedito Matarazzo", "Jardim Paulista", "Centro",
				"12216340");
		Endereco rua1810 = new Endereco(null, "Rua Projetada", "Jardim Paulista", "Centro", "12216361");
		Endereco rua1811 = new Endereco(null, "Rua Projetada B", "Jardim Paulista", "Centro", "12216362");
		Endereco rua1812 = new Endereco(null, "Rodovia Presidente Dutra", "Jardim Paulista", "Centro", "12216430");
		Endereco rua1813 = new Endereco(null, "Rua Itororó", "Jardim Paulista", "Centro", "12216440");
		Endereco rua1814 = new Endereco(null, "Rua Dom Carmine Rocco", "Jardim Paulista", "Centro", "12216450");
		Endereco rua1815 = new Endereco(null, "Rua Riachuelo", " 57", "Jardim Paulista", "Centro");
		Endereco rua1816 = new Endereco(null, "Rua Nilson Herminio Consiglio", "Jardim Petrópolis", "Sul", "12237400");
		Endereco rua1817 = new Endereco(null, "Rua José Cobra", "Jardim Petrópolis", "Sul", "12237401");
		Endereco rua1818 = new Endereco(null, "Rua Joana Maria Correa Laranjeira", "Jardim Petrópolis", "Sul",
				"12237410");
		Endereco rua1819 = new Endereco(null, "Rua João José da Silva", "Jardim Petrópolis", "Sul", "12237430");
		Endereco rua1820 = new Endereco(null, "Rua Delfim Antônio Pinto", "Jardim Petrópolis", "Sul", "12237440");
		Endereco rua1821 = new Endereco(null, "Rua Elio Del Chiaro", "Jardim Petrópolis", "Sul", "12237450");
		Endereco rua1822 = new Endereco(null, "Rua João Alves Cardoso", "Jardim Petrópolis", "Sul", "12237451");
		Endereco rua1823 = new Endereco(null, "Rua Itabaiana", "Jardim Petrópolis", "Sul", "12237540");
		Endereco rua1824 = new Endereco(null, "Avenida Cidade Jardim", "Jardim Portugal", "Sul", "12232000");
		Endereco rua1825 = new Endereco(null, "Rua Geraldo Ferreira Tavares", "Jardim Portugal", "Sul", "12232081");
		Endereco rua1826 = new Endereco(null, "Travessa dos Portugueses", "Jardim Portugal", "Sul", "12232140");
		Endereco rua1827 = new Endereco(null, "Rua Aparecida Boreli Melo", "Jardim Portugal", "Sul", "12232150");
		Endereco rua1828 = new Endereco(null, "Rua Zeferino Inácio Vieira", "Jardim Portugal", "Sul", "12232151");
		Endereco rua1829 = new Endereco(null, "Rua Tereza Alves Cursino", "Jardim Portugal", "Sul", "12232160");
		Endereco rua1830 = new Endereco(null, "Rua Wilma Vinhas Santos", "Jardim Portugal", "Sul", "12232170");
		Endereco rua1831 = new Endereco(null, "Rua Doutor Sérgio Santos", "Jardim Portugal", "Sul", "12232180");
		Endereco rua1832 = new Endereco(null, "Praça José Benedito Monteiro", "Jardim Portugal", "Sul", "12232181");
		Endereco rua1833 = new Endereco(null, "Rua Guilherme Lourenço", "Jardim Portugal", "Sul", "12232182");
		Endereco rua1834 = new Endereco(null, "Rua Luiz Marchetti", "Jardim Portugal", "Sul", "12232190");
		Endereco rua1835 = new Endereco(null, "Rua Doutor Milton Parodi", "Jardim Portugal", "Sul", "12232200");
		Endereco rua1836 = new Endereco(null, "Rua Alípio Ferreira Lourenço", "Jardim Portugal", "Sul", "12232210");
		Endereco rua1837 = new Endereco(null, "Rua Antônio Alves", "Jardim Portugal", "Sul", "12232220");
		Endereco rua1838 = new Endereco(null, "Rua Capitão Alípio Neves Barbosa", "Jardim Portugal", "Sul", "12232230");
		Endereco rua1839 = new Endereco(null, "Rua Lazara Menezes de Oliveira", "Jardim Portugal", "Sul", "12232240");
		Endereco rua1840 = new Endereco(null, "Rua Benedito Alexandre Trindade", "Jardim Portugal", "Sul", "12232250");
		Endereco rua1841 = new Endereco(null, "Rua Doutor Carlos Alberto Fontenelle Moreira", "Jardim Portugal", "Sul",
				"12232260");
		Endereco rua1842 = new Endereco(null, "Rua José Domingos Auricchio", "Jardim Portugal", "Sul", "12232270");
		Endereco rua1843 = new Endereco(null, "Rua Vítor Alves Rabelo", "Jardim Portugal", "Sul", "12232271");
		Endereco rua1844 = new Endereco(null, "Rua José Rodrigues Maia", "Jardim Portugal", "Sul", "12232310");
		Endereco rua1845 = new Endereco(null, "Rua Arnaldo Ricardo Monteiro", "Jardim Renata", "Centro", "12245110");
		Endereco rua1846 = new Endereco(null, "Rua Benedito Ivo", "Jardim Renata", "Centro", "12245531");
		Endereco rua1847 = new Endereco(null, "Rua Ataulfo Alves", "Jardim Renata", "Centro", "12245532");
		Endereco rua1848 = new Endereco(null, "Rua Benedito Teixeira", "Jardim Renata", "Centro", "12245551");
		Endereco rua1849 = new Endereco(null, "Rua Elias Paiotti", "Jardim Renata", "Centro", "12245561");
		Endereco rua1850 = new Endereco(null, "Avenida Eugênia da Silva", "Jardim República", "Sul", "12234825");
		Endereco rua1851 = new Endereco(null, "Rua João de Aquino", "Jardim República", "Sul", "12234826");
		Endereco rua1852 = new Endereco(null, "Rua Josefa Paulino Ramos da Silva", "Jardim República", "Sul",
				"12234827");
		Endereco rua1853 = new Endereco(null, "Rua Alcides Moreira de Paula", "Jardim República", "Sul", "12234828");
		Endereco rua1854 = new Endereco(null, "Rua Orlandino de Paula Pereira", "Jardim República", "Sul", "12234829");
		Endereco rua1855 = new Endereco(null, "Avenida José Benedicto Marinho de Souza", "Jardim República", "Sul",
				"12234830");
		Endereco rua1856 = new Endereco(null, "Rua Oscar Ferreira Silva", "Jardim República", "Sul", "12234831");
		Endereco rua1857 = new Endereco(null, "Rua Confrade João Pereira dos Santos", "Jardim República", "Sul",
				"12234832");
		Endereco rua1858 = new Endereco(null, "Rua Confrade José Simão Viana", "Jardim República", "Sul", "12234833");
		Endereco rua1859 = new Endereco(null, "Rua Rômulo Séllos Rodrigues", "Jardim República", "Sul", "12234834");
		Endereco rua1860 = new Endereco(null, "Rua Vanderlei Alexandre da Silva", "Jardim República", "Sul",
				"12234835");
		Endereco rua1861 = new Endereco(null, "Rua Almir Arnaldo de Alencar", "Jardim República", "Sul", "12234836");
		Endereco rua1862 = new Endereco(null, "Rua José Marinho do Nascimento", "Jardim República", "Sul", "12234837");
		Endereco rua1863 = new Endereco(null, "Rua Jacira Barbosa de Araújo", "Jardim República", "Sul", "12234838");
		Endereco rua1864 = new Endereco(null, "Avenida Confrade Geraldino Gabriel da Silva", "Jardim República", "Sul",
				"12234840");
		Endereco rua1865 = new Endereco(null, "Rua Aruichi Sakita", "Jardim Rosário", "Sul", "12236270");
		Endereco rua1866 = new Endereco(null, "Rua Torataro Takitani", "Jardim Rosário", "Sul", "12236280");
		Endereco rua1867 = new Endereco(null, "Rua Professor Francisco Juliano", "Jardim Rosário", "Sul", "12236300");
		Endereco rua1868 = new Endereco(null, "Rua Luiz Reis", "Jardim Rosário", "Sul", "12236310");
		Endereco rua1869 = new Endereco(null, "Rua Doutor João Batista Nogueira", "Jardim Rosário", "Sul", "12236330");
		Endereco rua1870 = new Endereco(null, "Rua Bertolino Cursino dos Santos", "Jardim San Rafael", "Leste",
				"12225592");
		Endereco rua1871 = new Endereco(null, "Avenida Presidente Tancredo Neves", "Jardim San Rafael", "Leste",
				"12225593");
		Endereco rua1872 = new Endereco(null, "Rua Benedito Fernandes de Andrade", "Jardim San Rafael", "Leste",
				"12225599");
		Endereco rua1873 = new Endereco(null, "Rua Francisco de Melo", "Jardim Santa Inês II", "Leste", "12224795");
		Endereco rua1874 = new Endereco(null, "Rua Rio Canindé", "Jardim Santa Inês II", "Leste", "12224797");
		Endereco rua1875 = new Endereco(null, "Rua José Pires de Camargo", "Jardim Santa Inês II", "Leste", "12224798");
		Endereco rua1876 = new Endereco(null, "Rua Cecília Bueno de Alvarenga", "Jardim Santa Inês II", "Leste",
				"12248090");
		Endereco rua1877 = new Endereco(null, "Rua Benedito Hilário", "Jardim Santa Inês II", "Leste", "12248100");
		Endereco rua1878 = new Endereco(null, "Rua José de Paula Silva Neves", "Jardim Santa Inês II", "Leste",
				"12248110");
		Endereco rua1879 = new Endereco(null, "Rua José Assis da Fonseca", "Jardim Santa Inês II", "Leste", "12248120");
		Endereco rua1880 = new Endereco(null, "Rua Benedito Marcondes Pereira", "Jardim Santa Inês II", "Leste",
				"12248140");
		Endereco rua1881 = new Endereco(null, "Rua Zelfira Bianchi", "Jardim Santa Inês II", "Leste", "12248150");
		Endereco rua1882 = new Endereco(null, "Rua Carlos Galhardo", "Jardim Santa Inês II", "Leste", "12248160");
		Endereco rua1883 = new Endereco(null, "Rua Antoun Melhen El Kouri", "Jardim Santa Inês II", "Leste",
				"12248170");
		Endereco rua1884 = new Endereco(null, "Rua Rodolfo Mayer", "Jardim Santa Inês II", "Leste", "12248180");
		Endereco rua1885 = new Endereco(null, "Rua Deocleciano Borges de Oliveira", "Jardim Santa Inês II", "Leste",
				"12248190");
		Endereco rua1886 = new Endereco(null, "Rua Taiwan", "Jardim Santa Inês II", "Leste", "12248193");
		Endereco rua1887 = new Endereco(null, "Rua Gilda Garrido Purcini", "Jardim Santa Inês II", "Leste", "12248194");
		Endereco rua1888 = new Endereco(null, "Rua José Lia", "Jardim Santa Inês II", "Leste", "12248195");
		Endereco rua1889 = new Endereco(null, "Avenida Professor Milton Santos", "Jardim Santa Inês I", "Leste",
				"12248200");
		Endereco rua1890 = new Endereco(null, "Rua Durvalina Silva Aguiar", "Jardim Santa Inês I", "Leste", "12248210");
		Endereco rua1891 = new Endereco(null, "Rua Narciza Moreti Ribeiro", "Jardim Santa Inês I", "Leste", "12248215");
		Endereco rua1892 = new Endereco(null, "Rua Virgulino de Carvalho", "Jardim Santa Inês I", "Leste", "12248220");
		Endereco rua1893 = new Endereco(null, "Rua Carlos Saloni", "Jardim Santa Inês I", "Leste", "12248230");
		Endereco rua1894 = new Endereco(null, "Rua Alberto Renart", "Jardim Santa Inês I", "Leste", "12248240");
		Endereco rua1895 = new Endereco(null, "Rua José de Paula", "Jardim Santa Inês I", "Leste", "12248241");
		Endereco rua1896 = new Endereco(null, "Rua Augusto Antônio de Magalhães", "Jardim Santa Inês I", "Leste",
				"12248250");
		Endereco rua1897 = new Endereco(null, "Rua Florival Adalberto Nucci", "Jardim Santa Inês III", "Leste",
				"12248254");
		Endereco rua1898 = new Endereco(null, "Rua Albenzio Romancini", "Jardim Santa Inês III", "Leste", "12248255");
		Endereco rua1899 = new Endereco(null, "Rua Padre Guilherme Hopp", "Jardim Santa Inês I", "Leste", "12248260");
		Endereco rua1900 = new Endereco(null, "Rua Nelson Amaral", "Jardim Santa Inês I", "Leste", "12248270");
		Endereco rua1901 = new Endereco(null, "Rua Maria Cândida Leite de Castro", "Jardim Santa Inês I", "Leste",
				"12248280");
		Endereco rua1902 = new Endereco(null, "Rua José Lino de Souza", "Jardim Santa Inês I", "Leste", "12248290");
		Endereco rua1903 = new Endereco(null, "Rua Joaquim Caetano de Jesus", "Jardim Santa Inês I", "Leste",
				"12248300");
		Endereco rua1904 = new Endereco(null, "Praça Marlene Baldez da Silva", "Jardim Santa Inês I", "Leste",
				"12248305");
		Endereco rua1905 = new Endereco(null, "Rua Argesio Dias Ferreira", "Jardim Santa Inês I", "Leste", "12248310");
		Endereco rua1906 = new Endereco(null, "Rua Emílio Tonglet", "Jardim Santa Inês I", "Leste", "12248320");
		Endereco rua1907 = new Endereco(null, "Avenida Doutor Domingos de Macedo Custódio", "Jardim Santa Inês I",
				"Leste", "12248330");
		Endereco rua1908 = new Endereco(null, "Praça Letícia Meira de Castro", "Jardim Santa Inês I", "Leste",
				"12248335");
		Endereco rua1909 = new Endereco(null, "Rua Abel Cursino dos Santos", "Jardim Santa Inês I", "Leste",
				"12248340");
		Endereco rua1910 = new Endereco(null, "Rua Herundina Figueira de Andrade Oliveira", "Jardim Santa Inês I",
				"Leste", "12248350");
		Endereco rua1911 = new Endereco(null, "Rua Antônio Barbosa de Oliveira", "Jardim Santa Inês I", "Leste",
				"12248360");
		Endereco rua1912 = new Endereco(null, "Rua Professor Rúbens Oscar Guelli", "Jardim Santa Inês I", "Leste",
				"12248370");
		Endereco rua1913 = new Endereco(null, "Rua Maria Aparecida Veríssimo Madureira Ramos", "Jardim Santa Inês I",
				"Leste", "12248380");
		Endereco rua1914 = new Endereco(null, "Rua Joaquim Batista Carvalho", "Jardim Santa Inês I", "Leste",
				"12248390");
		Endereco rua1915 = new Endereco(null, "Rua Maria Alice Pasquarelli", "Jardim Santa Inês I", "Leste",
				"12248400");
		Endereco rua1916 = new Endereco(null, "Rua Lázaro Floriano Barbosa", "Jardim Santa Inês I", "Leste",
				"12248410");
		Endereco rua1917 = new Endereco(null, "Rua Carlos Eurico de Breyme Montenegro", "Jardim Santa Inês I", "Leste",
				"12248420");
		Endereco rua1918 = new Endereco(null, "Rua João Moreira Borges", "Jardim Santa Inês I", "Leste", "12248430");
		Endereco rua1919 = new Endereco(null, "Rua Antônio Júlio Cavalcanti", "Jardim Santa Inês I", "Leste",
				"12248440");
		Endereco rua1920 = new Endereco(null, "Rua José de Paula Ferreira", "Jardim Santa Inês I", "Leste", "12248450");
		Endereco rua1921 = new Endereco(null, "Rua Fauze Dimas Lumumba Gonçalves", "Jardim Santa Inês I", "Leste",
				"12248460");
		Endereco rua1922 = new Endereco(null, "Rua Francisco Teixeira de Almeida Filho", "Jardim Santa Inês I", "Leste",
				"12248470");
		Endereco rua1923 = new Endereco(null, "Rua Francisco Ferreira Santos", "Jardim Santa Inês I", "Leste",
				"12248480");
		Endereco rua1924 = new Endereco(null, "Rua Abelardo Alves de Paiva", "Jardim Santa Inês I", "Leste",
				"12248490");
		Endereco rua1925 = new Endereco(null, "Avenida Pedro Domingues Affonso", "Jardim Santa Inês III", "Leste",
				"12248498");
		Endereco rua1926 = new Endereco(null, "Rua Célia Regina de Oliveira", "Jardim Santa Inês III", "Leste",
				"12248499");
		Endereco rua1927 = new Endereco(null, "Rua Ricardo Paiva Vieira", "Jardim Santa Inês I", "Leste", "12248500");
		Endereco rua1928 = new Endereco(null, "Rua Giovanna Maria Apparecida D'Amato Lima", "Jardim Santa Inês III",
				"Leste", "12248502");
		Endereco rua1929 = new Endereco(null, "Rua José Cesário Cerqueira", "Jardim Santa Inês III", "Leste",
				"12248503");
		Endereco rua1930 = new Endereco(null, "Rua Sebastião Paulo Siqueira", "Jardim Santa Inês III", "Leste",
				"12248504");
		Endereco rua1931 = new Endereco(null, "Rua Robson Ricardo da Silva", "Jardim Santa Inês II", "Leste",
				"12248505");
		Endereco rua1932 = new Endereco(null, "Rua Três", "Jardim Santa Inês III", "Leste", "12248506");
		Endereco rua1933 = new Endereco(null, "Rua Therezinha da Piedade Beraldo Goulart Oliveira",
				"Jardim Santa Inês III", "Leste", "12248507");
		Endereco rua1934 = new Endereco(null, "Rua Maria Benedita Gama", "Jardim Santa Inês III", "Leste", "12248508");
		Endereco rua1935 = new Endereco(null, "Rua José Custódio da Silveira", "Jardim Santa Inês III", "Leste",
				"12248509");
		Endereco rua1936 = new Endereco(null, "Avenida Constância da Cunha Paiva", "Jardim Santa Inês II", "Leste",
				"12248510");
		Endereco rua1937 = new Endereco(null, "Rua José Alves de Paiva", "Jardim Santa Inês II", "Leste", "12248511");
		Endereco rua1938 = new Endereco(null, "Rua Luiz Calvo", "Jardim Santa Inês II", "Leste", "12248512");
		Endereco rua1939 = new Endereco(null, "Rua Benedito Albano Pereira", "Jardim Santa Inês II", "Leste",
				"12248513");
		Endereco rua1940 = new Endereco(null, "Rua Mário Guimarães Ferri", "Jardim Santa Inês II", "Leste", "12248514");
		Endereco rua1941 = new Endereco(null, "Rua dos Cirurgiões Dentistas", "Jardim Santa Inês II", "Leste",
				"12248515");
		Endereco rua1942 = new Endereco(null, "Rua Capitão Paulo José de Menezes Filho", "Jardim Santa Inês II",
				"Leste", "12248516");
		Endereco rua1943 = new Endereco(null, "Rua Doutor Euclides Froes", "Jardim Santa Inês II", "Leste", "12248517");
		Endereco rua1944 = new Endereco(null, "Avenida Iracy Pires da Almeida Puccini", "Jardim Santa Inês II", "Leste",
				"12248520");
		Endereco rua1945 = new Endereco(null, "Rua Francisco de Melo", "Jardim Santa Inês II", "Leste", "12224795");
		Endereco rua1946 = new Endereco(null, "Rua Rio Canindé", "Jardim Santa Inês II", "Leste", "12224797");
		Endereco rua1947 = new Endereco(null, "Rua José Pires de Camargo", "Jardim Santa Inês II", "Leste", "12224798");
		Endereco rua1948 = new Endereco(null, "Rua Cecília Bueno de Alvarenga", "Jardim Santa Inês II", "Leste",
				"12248090");
		Endereco rua1949 = new Endereco(null, "Rua Benedito Hilário", "Jardim Santa Inês II", "Leste", "12248100");
		Endereco rua1950 = new Endereco(null, "Rua José de Paula Silva Neves", "Jardim Santa Inês II", "Leste",
				"12248110");
		Endereco rua1951 = new Endereco(null, "Rua José Assis da Fonseca", "Jardim Santa Inês II", "Leste", "12248120");
		Endereco rua1952 = new Endereco(null, "Rua Benedito Marcondes Pereira", "Jardim Santa Inês II", "Leste",
				"12248140");
		Endereco rua1953 = new Endereco(null, "Rua Zelfira Bianchi", "Jardim Santa Inês II", "Leste", "12248150");
		Endereco rua1954 = new Endereco(null, "Rua Carlos Galhardo", "Jardim Santa Inês II", "Leste", "12248160");
		Endereco rua1955 = new Endereco(null, "Rua Antoun Melhen El Kouri", "Jardim Santa Inês II", "Leste",
				"12248170");
		Endereco rua1956 = new Endereco(null, "Rua Rodolfo Mayer", "Jardim Santa Inês II", "Leste", "12248180");
		Endereco rua1957 = new Endereco(null, "Rua Deocleciano Borges de Oliveira", "Jardim Santa Inês II", "Leste",
				"12248190");
		Endereco rua1958 = new Endereco(null, "Rua Taiwan", "Jardim Santa Inês II", "Leste", "12248193");
		Endereco rua1959 = new Endereco(null, "Rua Gilda Garrido Purcini", "Jardim Santa Inês II", "Leste", "12248194");
		Endereco rua1960 = new Endereco(null, "Rua José Lia", "Jardim Santa Inês II", "Leste", "12248195");
		Endereco rua1961 = new Endereco(null, "Rua Florival Adalberto Nucci", "Jardim Santa Inês III", "Leste",
				"12248254");
		Endereco rua1962 = new Endereco(null, "Rua Albenzio Romancini", "Jardim Santa Inês III", "Leste", "12248255");
		Endereco rua1963 = new Endereco(null, "Avenida Pedro Domingues Affonso", "Jardim Santa Inês III", "Leste",
				"12248498");
		Endereco rua1964 = new Endereco(null, "Rua Célia Regina de Oliveira", "Jardim Santa Inês III", "Leste",
				"12248499");
		Endereco rua1965 = new Endereco(null, "Rua Giovanna Maria Apparecida D'Amato Lima", "Jardim Santa Inês III",
				"Leste", "12248502");
		Endereco rua1966 = new Endereco(null, "Rua José Cesário Cerqueira", "Jardim Santa Inês III", "Leste",
				"12248503");
		Endereco rua1967 = new Endereco(null, "Rua Sebastião Paulo Siqueira", "Jardim Santa Inês III", "Leste",
				"12248504");
		Endereco rua1968 = new Endereco(null, "Rua Robson Ricardo da Silva", "Jardim Santa Inês II", "Leste",
				"12248505");
		Endereco rua1969 = new Endereco(null, "Rua Três", "Jardim Santa Inês III", "Leste", "12248506");
		Endereco rua1970 = new Endereco(null, "Rua Therezinha da Piedade Beraldo Goulart Oliveira",
				"Jardim Santa Inês III", "Leste", "12248507");
		Endereco rua1971 = new Endereco(null, "Rua Maria Benedita Gama", "Jardim Santa Inês III", "Leste", "12248508");
		Endereco rua1972 = new Endereco(null, "Rua José Custódio da Silveira", "Jardim Santa Inês III", "Leste",
				"12248509");
		Endereco rua1973 = new Endereco(null, "Avenida Constância da Cunha Paiva", "Jardim Santa Inês II", "Leste",
				"12248510");
		Endereco rua1974 = new Endereco(null, "Rua José Alves de Paiva", "Jardim Santa Inês II", "Leste", "12248511");
		Endereco rua1975 = new Endereco(null, "Rua Luiz Calvo", "Jardim Santa Inês II", "Leste", "12248512");
		Endereco rua1976 = new Endereco(null, "Rua Benedito Albano Pereira", "Jardim Santa Inês II", "Leste",
				"12248513");
		Endereco rua1977 = new Endereco(null, "Rua Mário Guimarães Ferri", "Jardim Santa Inês II", "Leste", "12248514");
		Endereco rua1978 = new Endereco(null, "Rua dos Cirurgiões Dentistas", "Jardim Santa Inês II", "Leste",
				"12248515");
		Endereco rua1979 = new Endereco(null, "Rua Capitão Paulo José de Menezes Filho", "Jardim Santa Inês II",
				"Leste", "12248516");
		Endereco rua1980 = new Endereco(null, "Rua Doutor Euclides Froes", "Jardim Santa Inês II", "Leste", "12248517");
		Endereco rua1981 = new Endereco(null, "Avenida Iracy Pires da Almeida Puccini", "Jardim Santa Inês II", "Leste",
				"12248520");
		Endereco rua1982 = new Endereco(null, "Rua Florival Adalberto Nucci", "Jardim Santa Inês III", "Leste",
				"12248254");
		Endereco rua1983 = new Endereco(null, "Rua Albenzio Romancini", "Jardim Santa Inês III", "Leste", "12248255");
		Endereco rua1984 = new Endereco(null, "Avenida Pedro Domingues Affonso", "Jardim Santa Inês III", "Leste",
				"12248498");
		Endereco rua1985 = new Endereco(null, "Rua Célia Regina de Oliveira", "Jardim Santa Inês III", "Leste",
				"12248499");
		Endereco rua1986 = new Endereco(null, "Rua Giovanna Maria Apparecida D'Amato Lima", "Jardim Santa Inês III",
				"Leste", "12248502");
		Endereco rua1987 = new Endereco(null, "Rua José Cesário Cerqueira", "Jardim Santa Inês III", "Leste",
				"12248503");
		Endereco rua1988 = new Endereco(null, "Rua Sebastião Paulo Siqueira", "Jardim Santa Inês III", "Leste",
				"12248504");
		Endereco rua1989 = new Endereco(null, "Rua Três", "Jardim Santa Inês III", "Leste", "12248506");
		Endereco rua1990 = new Endereco(null, "Rua Therezinha da Piedade Beraldo Goulart Oliveira",
				"Jardim Santa Inês III", "Leste", "12248507");
		Endereco rua1991 = new Endereco(null, "Rua Maria Benedita Gama", "Jardim Santa Inês III", "Leste", "12248508");
		Endereco rua1992 = new Endereco(null, "Rua José Custódio da Silveira", "Jardim Santa Inês III", "Leste",
				"12248509");
		Endereco rua1993 = new Endereco(null, "Avenida Laudelino Gonçalves de Miranda", "Jardim Santa Júlia", "Sudeste",
				"12228271");
		Endereco rua1994 = new Endereco(null, "Avenida José Antônio Silvério", "Jardim Santa Júlia", "Sudeste",
				"12228272");
		Endereco rua1995 = new Endereco(null, "Avenida Maria Hipólita de Souza", "Jardim Santa Júlia", "Sudeste",
				"12228273");
		Endereco rua1996 = new Endereco(null, "Avenida Valter de Oliveira", "Jardim Santa Júlia", "Sudeste",
				"12228274");
		Endereco rua1997 = new Endereco(null, "Rua Sargento Antonio Celso de Souza", "Jardim Santa Júlia", "Sudeste",
				"12228275");
		Endereco rua1998 = new Endereco(null, "Rua Arlindo Flauzino Pereira", "Jardim Santa Júlia", "Sudeste",
				"12228276");
		Endereco rua1999 = new Endereco(null, "Rua Luiz Claudio Monteiro", "Jardim Santa Júlia", "Sudeste", "12228277");
		Endereco rua2000 = new Endereco(null, "Rua Albino Raimundo Nunes", "Jardim Santa Júlia", "Sudeste", "12228278");
		Endereco rua2001 = new Endereco(null, "Rua Joaquim Silvério Filho", "Jardim Santa Júlia", "Sudeste",
				"12228279");
		Endereco rua2002 = new Endereco(null, "Rua Luzia Griecco", "Jardim Santa Júlia", "Sudeste", "12228281");
		Endereco rua2003 = new Endereco(null, "Rua Cid Moreira Rangel", "Jardim Santa Júlia", "Sudeste", "12228282");
		Endereco rua2004 = new Endereco(null, "Rua Carlos Eduardo Godoi Dellu", "Jardim Santa Júlia", "Sudeste",
				"12228283");
		Endereco rua2005 = new Endereco(null, "Rua José Alencar Ribeiro", "Jardim Santa Júlia", "Sudeste", "12228284");
		Endereco rua2006 = new Endereco(null, "Rua dos Bombeiros", "Jardim Santa Júlia", "Sudeste", "12228285");
		Endereco rua2007 = new Endereco(null, "Rua Lázaro Inácio Ribeiro", "Jardim Santa Júlia", "Sudeste", "12228286");
		Endereco rua2008 = new Endereco(null, "Rua Aparecida Nogueira Rossi", "Jardim Santa Júlia", "Sudeste",
				"12228287");
		Endereco rua2009 = new Endereco(null, "Rua Miguel Batista Rangel", "Jardim Santa Júlia", "Sudeste", "12228288");
		Endereco rua2010 = new Endereco(null, "Rua Ricardo Sérgio Mimessi", "Jardim Santa Júlia", "Sudeste",
				"12228289");
		Endereco rua2011 = new Endereco(null, "Rua Pedro Benedito Ferreira", "Jardim Santa Júlia", "Sudeste",
				"12228291");
		Endereco rua2012 = new Endereco(null, "Rua Galileu Lopes da Silva", "Jardim Santa Júlia", "Sudeste",
				"12228292");
		Endereco rua2013 = new Endereco(null, "Rua Cleide Veloso de Souza", "Jardim Santa Júlia", "Sudeste",
				"12228293");
		Endereco rua2014 = new Endereco(null, "Rua João Felix da Rosa", "Jardim Santa Júlia", "Sudeste", "12228294");
		Endereco rua2015 = new Endereco(null, "Rua Osvaldo da Graça Almeida Júnior", "Jardim Santa Júlia", "Sudeste",
				"12228295");
		Endereco rua2016 = new Endereco(null, "Rua Benedito Fernandes das Neves", "Jardim Santa Júlia", "Sudeste",
				"12228296");
		Endereco rua2017 = new Endereco(null, "Rua Aparecida Francisco Fávaro", "Jardim Santa Júlia", "Sudeste",
				"12228297");
		Endereco rua2018 = new Endereco(null, "Rua Doutor Roberto Fregoni", "Jardim Santa Júlia", "Sudeste",
				"12228298");
		Endereco rua2019 = new Endereco(null, "Rua Humberto Severo Miacci", "Jardim Santa Júlia", "Sudeste",
				"12228299");
		Endereco rua2020 = new Endereco(null, "Rua Pedro Alves Faria", "Jardim Santa Júlia", "Sudeste", "12228301");
		Endereco rua2021 = new Endereco(null, "Rua Nerval Monstans Costa", "Jardim Santa Júlia", "Sudeste", "12228302");
		Endereco rua2022 = new Endereco(null, "Rua Tadao Shinhe", "Jardim Santa Júlia", "Sudeste", "12228303");
		Endereco rua2023 = new Endereco(null, "Rua Francisco Pires de Moraes", "Jardim Santa Júlia", "Sudeste",
				"12228304");
		Endereco rua2024 = new Endereco(null, "Rua Aldo Moreira dos Santos", "Jardim Santa Júlia", "Sudeste",
				"12228305");
		Endereco rua2025 = new Endereco(null, "Rua Vinte e Nove", "Jardim Santa Júlia", "Sudeste", "12228306");
		Endereco rua2026 = new Endereco(null, "Rua Tereza do Espírito Santo da Paz", "Jardim Santa Júlia", "Sudeste",
				"12228307");
		Endereco rua2027 = new Endereco(null, "Rua Edezio Penellupi", "Jardim Santa Júlia", "Sudeste", "12228308");
		Endereco rua2028 = new Endereco(null, "Rua José Edvaldo Ramos", "Jardim Santa Júlia", "Sudeste", "12228309");
		Endereco rua2029 = new Endereco(null, "Rua Maria Rosa de Oliveira Silva", "Jardim Santa Júlia", "Sudeste",
				"12228311");
		Endereco rua2030 = new Endereco(null, "Rua Julia Batista da Silva", "Jardim Santa Júlia", "Sudeste",
				"12228312");
		Endereco rua2031 = new Endereco(null, "Rua Luiz Pereira Leite", "Jardim Santa Júlia", "Sudeste", "12228313");
		Endereco rua2032 = new Endereco(null, "Rua Maria Benedita", "Jardim Santa Júlia", "Sudeste", "12228314");
		Endereco rua2033 = new Endereco(null, "Rua Falec Rodrigues da Cunha", "Jardim Santa Júlia", "Sudeste",
				"12228315");
		Endereco rua2034 = new Endereco(null, "Rua Paulo Nunes dos Reis", "Jardim Santa Júlia", "Sudeste", "12228316");
		Endereco rua2035 = new Endereco(null, "Rua Luís José dos Santos", "Jardim Santa Júlia", "Sudeste", "12228317");
		Endereco rua2036 = new Endereco(null, "Rua Maria Apparecida Rodrigues", "Jardim Santa Júlia", "Sudeste",
				"12228318");
		Endereco rua2037 = new Endereco(null, "Rua João Soares dos Santos", "Jardim Santa Júlia", "Sudeste",
				"12228319");
		Endereco rua2038 = new Endereco(null, "Rua Sebastiana Francisca de Souza", "Jardim Santa Júlia", "Sudeste",
				"12228321");
		Endereco rua2039 = new Endereco(null, "Rua Rezende Alcalde", "Jardim Santa Júlia", "Sudeste", "12228322");
		Endereco rua2040 = new Endereco(null, "Avenida Jeanete Aparecida Silvério", "Jardim Santa Júlia", "Sudeste",
				"12228323");
		Endereco rua2041 = new Endereco(null, "Rua Terezinha Cezar de Souza", "Jardim Santa Júlia", "Sudeste",
				"12228324");
		Endereco rua2042 = new Endereco(null, "Rua Benedito Pinhal dos Anjos", "Jardim Santa Júlia", "Sudeste",
				"12228325");
		Endereco rua2043 = new Endereco(null, "Rua Maria Pompilio dos Santos", "Jardim Santa Júlia", "Sudeste",
				"12228326");
		Endereco rua2044 = new Endereco(null, "Rua Quarenta e Sete", "Jardim Santa Júlia", "Sudeste", "12228327");
		Endereco rua2045 = new Endereco(null, "Avenida Roberto Sebastião Consiglio", "Jardim Santa Júlia", "Sudeste",
				"12228328");
		Endereco rua2046 = new Endereco(null, "Avenida Vicente Brandão Ferreira", "Jardim Santa Luzia", "Sudeste",
				"12228004");
		Endereco rua2047 = new Endereco(null, "Avenida Júlio Cezar Villaça", "Jardim Santa Luzia", "Sudeste",
				"12228005");
		Endereco rua2048 = new Endereco(null, "Rua Henrique Bráulio de Melo Sobrinho", "Jardim Santa Luzia", "Sudeste",
				"12228850");
		Endereco rua2049 = new Endereco(null, "Rua Miguel Cunha Barbosa", "Jardim Santa Luzia", "Sudeste", "12228851");
		Endereco rua2050 = new Endereco(null, "Rua Gusmão Pinto da Cunha", "Jardim Santa Luzia", "Sudeste", "12228852");
		Endereco rua2051 = new Endereco(null, "Rua Graziela Café de Oliveira", "Jardim Santa Luzia", "Sudeste",
				"12228853");
		Endereco rua2052 = new Endereco(null, "Rua Confrade Nelson Pereira Lima", "Jardim Santa Luzia", "Sudeste",
				"12228854");
		Endereco rua2053 = new Endereco(null, "Rua Professora Terezinha de Jesus Alves da Silva Vadô",
				"Jardim Santa Luzia", "Sudeste", "12228855");
		Endereco rua2054 = new Endereco(null, "Rua Teresa Antonio", "Jardim Santa Luzia", "Sudeste", "12228856");
		Endereco rua2055 = new Endereco(null, "Rua Américo Filipe de Azevedo", "Jardim Santa Luzia", "Sudeste",
				"12228857");
		Endereco rua2056 = new Endereco(null, "Rua José Benedito de Almeida Pena", "Jardim Santa Luzia", "Sudeste",
				"12228858");
		Endereco rua2057 = new Endereco(null, "Rua Juvenal Agostinho da Cunha", "Jardim Santa Luzia", "Sudeste",
				"12228859");
		Endereco rua2058 = new Endereco(null, "Rua Ana Lúcia Cherubini e Silva", "Jardim Santa Luzia", "Sudeste",
				"12228860");
		Endereco rua2059 = new Endereco(null, "Rua Djalma Sebastião Henze Alves", "Jardim Santa Luzia", "Sudeste",
				"12228861");
		Endereco rua2060 = new Endereco(null, "Rua Benedito Antônio Liesack da Cunha", "Jardim Santa Luzia", "Sudeste",
				"12228862");
		Endereco rua2061 = new Endereco(null, "Rua Ida do Nascimento", "Jardim Santa Luzia", "Sudeste", "12228863");
		Endereco rua2062 = new Endereco(null, "Rua José da Cunha", "Jardim Santa Luzia", "Sudeste", "12228864");
		Endereco rua2063 = new Endereco(null, "Rua Dezessete", "Jardim Santa Luzia", "Sudeste", "12228865");
		Endereco rua2064 = new Endereco(null, "Rua Benedito Rodrigues Moreira", "Jardim Santa Luzia", "Sudeste",
				"12228866");
		Endereco rua2065 = new Endereco(null, "Rua Antonio Germano dos Santos", "Jardim Santa Luzia", "Sudeste",
				"12228867");
		Endereco rua2066 = new Endereco(null, "Rua Santa Margarida", "Jardim Santa Madalena", "Centro", "12243270");
		Endereco rua2067 = new Endereco(null, "Rua Santa Luzia", "Jardim Santa Madalena", "Centro", "12243280");
		Endereco rua2068 = new Endereco(null, "Travessa Santa Inês", "Jardim Santa Madalena", "Centro", "12243290");
		Endereco rua2069 = new Endereco(null, "Rua Santa Madalena", "Jardim Santa Madalena", "Centro", "12243300");
		Endereco rua2070 = new Endereco(null, "Rua Santa Sofia", "Jardim Santa Madalena", "Centro", "12243310");
		Endereco rua2071 = new Endereco(null, "Rua Engenheiro Flávio Marcondes", "Jardim Santa Maria II", "Leste",
				"12225161");
		Endereco rua2072 = new Endereco(null, "Rua Engenheiro Flávio Marcondes", "Jardim Santa Maria", "Leste",
				"12225171");
		Endereco rua2073 = new Endereco(null, "Rua Raimundo Monte Regis", "Jardim Santa Maria", "Leste", "12225172");
		Endereco rua2074 = new Endereco(null, "Rua José Donizetti dos Santos", "Jardim Santa Maria IV", "Leste",
				"12225271");
		Endereco rua2075 = new Endereco(null, "Travessa Um A", "Jardim Santa Maria", "Leste", "12225371");
		Endereco rua2076 = new Endereco(null, "Travessa Dois", "Jardim Santa Maria", "Leste", "12225372");
		Endereco rua2077 = new Endereco(null, "Travessa Três", "Jardim Santa Maria", "Leste", "12225373");
		Endereco rua2078 = new Endereco(null, "Rua Celso Gomes Negrão", "Jardim Santa Maria III", "Leste", "12225374");
		Endereco rua2079 = new Endereco(null, "Rua Engenheiro Flávio Marcondes", "Jardim Santa Maria III", "Leste",
				"12225375");
		Endereco rua2080 = new Endereco(null, "Rua Santa Maria", "Jardim Santa Maria", "Leste", "12225391");
		Endereco rua2081 = new Endereco(null, "Rua Alisson Geraldo da Silva Vitor", "Jardim Santa Maria", "Leste",
				"12225392");
		Endereco rua2082 = new Endereco(null, "Rua Três", "Jardim Santa Maria", "Leste", "12225393");
		Endereco rua2083 = new Endereco(null, "Rua Antonio Fernando Batista", "Jardim Santa Maria III", "Leste",
				"12225394");
		Endereco rua2084 = new Endereco(null, "Rua Cinco", "Jardim Santa Maria", "Leste", "12225395");
		Endereco rua2085 = new Endereco(null, "Rua Seis", "Jardim Santa Maria", "Leste", "12225396");
		Endereco rua2086 = new Endereco(null, "Rua das Flores", "Jardim Santa Maria", "Leste", "12225397");
		Endereco rua2087 = new Endereco(null, "Rua José Leite Filho", "Jardim Santa Maria", "Leste", "12225398");
		Endereco rua2088 = new Endereco(null, "Estrada do Joaquim Gonçalves da Silva", "Jardim Santa Maria", "Leste",
				"12225833");
		Endereco rua2089 = new Endereco(null, "Rua Santa Matilde", "Jardim Santa Matilde", "Norte", "12213570");
		Endereco rua2090 = new Endereco(null, "Avenida Maria Cândida Delgado", "Jardim Santa Matilde", "Norte",
				"12213573");
		Endereco rua2091 = new Endereco(null, "Rua Nossa Senhora da Salete", "Jardim Santa Matilde", "Norte",
				"12213580");
		Endereco rua2092 = new Endereco(null, "Travessa Maria Marta", "Jardim Santa Matilde", "Norte", "12213590");
		Endereco rua2093 = new Endereco(null, "Rua Santa Cecília", "Jardim Santa Matilde", "Norte", "12213600");
		Endereco rua2094 = new Endereco(null, "Rua Professor Adjacy Sampaio Murity", "Jardim Santa Matilde", "Norte",
				"12213610");
		Endereco rua2095 = new Endereco(null, "Praça Santa Efigênia", "Jardim Santa Matilde", "Norte", "12213620");
		Endereco rua2096 = new Endereco(null, "Avenida Nadyr Mota Cortês", "Jardim Santa Rosa", "Sudeste", "12228870");
		Endereco rua2097 = new Endereco(null, "Rua Paulo Sérgio Kacuta", "Jardim Santa Rosa", "Sudeste", "12228872");
		Endereco rua2098 = new Endereco(null, "Rua Abel de Paula", "Jardim Santa Rosa", "Sudeste", "12228874");
		Endereco rua2099 = new Endereco(null, "Rua José de Oliveira Rocha", "Jardim Santa Rosa", "Sudeste", "12228876");
		Endereco rua2100 = new Endereco(null, "Rua Sebastião Ricardo Filho", "Jardim Santa Rosa", "Sudeste",
				"12228878");
		Endereco rua2101 = new Endereco(null, "Rua Mogi-Mirim", "Jardim Santa Rosa", "Sudeste", "12228880");
		Endereco rua2102 = new Endereco(null, "Rua Herotildes Ramos", "Jardim Santa Rosa", "Sudeste", "12228882");
		Endereco rua2103 = new Endereco(null, "Rua Ana Maria de Jesus Lúcio", "Jardim Santa Rosa", "Sudeste",
				"12228884");
		Endereco rua2104 = new Endereco(null, "Rua Josildo Arnulfo dos Santos", "Jardim Santa Rosa", "Sudeste",
				"12228886");
		Endereco rua2105 = new Endereco(null, "Rua João Batista Cabral", "Jardim Santa Rosa", "Sudeste", "12228888");
		Endereco rua2106 = new Endereco(null, "Rua Alex Daniel de Souza", "Jardim Santa Rosa", "Sudeste", "12228890");
		Endereco rua2107 = new Endereco(null, "Rua João Silva de Aguiar", "Jardim Santa Rosa", "Sudeste", "12228892");
		Endereco rua2108 = new Endereco(null, "Rua Hilda Roda de Jesus", "Jardim Santa Rosa", "Sudeste", "12228894");
		Endereco rua2109 = new Endereco(null, "Rua Maria Aparecida Martins", "Jardim Santa Rosa", "Sudeste",
				"12228896");
		Endereco rua2110 = new Endereco(null, "Rua Nelsidio Felix", "Jardim Santa Rosa", "Sudeste", "12228897");
		Endereco rua2111 = new Endereco(null, "Rua Engenheiro Demilton Floriano Teixeira", "Jardim Santa Rosa",
				"Sudeste", "12228898");
		Endereco rua2112 = new Endereco(null, "Rua Umbelina Melo Romeu", "Jardim Santo Onofre", "Sudeste", "12228002");
		Endereco rua2113 = new Endereco(null, "Rua Norma Sueli Junqueira Pereira", "Jardim Santo Onofre", "Sudeste",
				"12228003");
		Endereco rua2114 = new Endereco(null, "Rua Maria José Ribeiro", "Jardim Santo Onofre", "Sudeste", "12228006");
		Endereco rua2115 = new Endereco(null, "Rua Maria Amélia de Oliveira", "Jardim Santo Onofre", "Sudeste",
				"12228007");
		Endereco rua2116 = new Endereco(null, "Viela Albertina Constância Trindade", "Jardim Santo Onofre", "Sudeste",
				"12228008");
		Endereco rua2117 = new Endereco(null, "Rua Alberto Coltro", "Jardim Santo Onofre", "Sudeste", "12228009");
		Endereco rua2118 = new Endereco(null, "Rua Manabu Mabe", "Jardim Santo Onofre", "Sudeste", "12228011");
		Endereco rua2119 = new Endereco(null, "Rua Frederico Miacci Natalici", "Jardim Santo Onofre", "Sudeste",
				"12228012");
		Endereco rua2120 = new Endereco(null, "Rua Donatéllo Mammoli", "Jardim Santo Onofre", "Sudeste", "12228013");
		Endereco rua2121 = new Endereco(null, "Rua Maria de Lourdes de Andrade Coltro", "Jardim Santo Onofre",
				"Sudeste", "12228014");
		Endereco rua2122 = new Endereco(null, "Rua Luiza dos Santos Bernardes", "Jardim Santo Onofre", "Sudeste",
				"12228015");
		Endereco rua2123 = new Endereco(null, "Rua Irajá Andrade Santos", "Jardim Santo Onofre", "Sudeste", "12228016");
		Endereco rua2124 = new Endereco(null, "Viela José Siriaco da Silva", "Jardim Santo Onofre", "Sudeste",
				"12228017");
		Endereco rua2125 = new Endereco(null, "Rua José Ferreira de Lira", "Jardim Santo Onofre", "Sudeste",
				"12228018");
		Endereco rua2126 = new Endereco(null, "Viela Geralda da Silva de Oliveira", "Jardim Santo Onofre", "Sudeste",
				"12228019");
		Endereco rua2127 = new Endereco(null, "Viela Leonardo Francisco dos Santos", "Jardim Santo Onofre", "Sudeste",
				"12228071");
		Endereco rua2128 = new Endereco(null, "Rua José Benedito Alves Cursino", "Jardim Santo Onofre", "Sudeste",
				"12228073");
		Endereco rua2129 = new Endereco(null, "Rua Artur Cursino", "Jardim Santo Onofre", "Sudeste", "12228075");
		Endereco rua2130 = new Endereco(null, "Rua Roberto Aparecido Cruz", "Jardim Santo Onofre", "Sudeste",
				"12228077");
		Endereco rua2131 = new Endereco(null, "Avenida Engenheiro Francisco José Longo", "Jardim São Dimas", "Centro",
				"12245000");
		Endereco rua2132 = new Endereco(null, "Avenida Engenheiro Francisco José Longo", "Jardim São Dimas", "Centro",
				"12245001");
		Endereco rua2133 = new Endereco(null, "Avenida Doutor Adhemar de Barros", "Jardim São Dimas", "Centro",
				"12245010");
		Endereco rua2134 = new Endereco(null, "Avenida Doutor Adhemar de Barros", "Jardim São Dimas", "Centro",
				"12245011");
		Endereco rua2135 = new Endereco(null, "Rua Turquia", "Jardim São Dimas", "Centro", "12245019");
		Endereco rua2136 = new Endereco(null, "Rua Paraibuna", "Jardim São Dimas", "Centro", "12245020");
		Endereco rua2137 = new Endereco(null, "Rua Paraibuna", "Jardim São Dimas", "Centro", "12245021");
		Endereco rua2138 = new Endereco(null, "Viaduto Sérgio Sobral de Oliveira", "Jardim São Dimas", "Centro",
				"12245022");
		Endereco rua2139 = new Endereco(null, "Avenida Doutor Nelson D'Avila", "Jardim São Dimas", "Centro",
				"12245030");
		Endereco rua2140 = new Endereco(null, "Avenida Doutor Nelson D'Avila", "Jardim São Dimas", "Centro",
				"12245031");
		Endereco rua2141 = new Endereco(null, "Travessa Darcy de Oliveira", "Jardim São Dimas", "Centro", "12245051");
		Endereco rua2142 = new Endereco(null, "Rua Manoel Ricardo Júnior", "Jardim São Dimas", "Centro", "12245061");
		Endereco rua2143 = new Endereco(null, "Travessa João Friggi", "Jardim São Dimas", "Centro", "12245070");
		Endereco rua2144 = new Endereco(null, "Travessa Rocha Pombo", "Jardim São Dimas", "Centro", "12245080");
		Endereco rua2145 = new Endereco(null, "Rua Doutor Mário Sampaio Martins", "Jardim São Dimas", "Centro",
				"12245100");
		Endereco rua2146 = new Endereco(null, "Praça Corretor de Imóveis", "Jardim São Dimas", "Centro", "12245105");
		Endereco rua2147 = new Endereco(null, "Travessa Manoel da Nóbrega", "Jardim São Dimas", "Centro", "12245112");
		Endereco rua2148 = new Endereco(null, "Rua Antônio da Silva Santos", "Jardim São Dimas", "Centro", "12245120");
		Endereco rua2149 = new Endereco(null, "Rua Leonildo Ramos Cruz", "Jardim São Dimas", "Centro", "12245130");
		Endereco rua2150 = new Endereco(null, "Rua Maestro Egydio Pinto", "Jardim São Dimas", "Centro", "12245190");
		Endereco rua2151 = new Endereco(null, "Rua Brigadeiro Osvaldo Nascimento Leal", "Jardim São Dimas", "Centro",
				"12245200");
		Endereco rua2152 = new Endereco(null, "Avenida Heitor Villa Lobos", "Jardim São Dimas", "Centro", "12245280");
		Endereco rua2153 = new Endereco(null, "Rua Tufi Simão Filho", "Jardim São Dimas", "Centro", "12245290");
		Endereco rua2154 = new Endereco(null, "Rua Ezra", "Jardim São Dimas", "Centro", "12245300");
		Endereco rua2155 = new Endereco(null, "Rua Helena David Neme", "Jardim São Dimas", "Centro", "12245310");
		Endereco rua2156 = new Endereco(null, "Rua Professor Frederico Eyer", "Jardim São Dimas", "Centro", "12245330");
		Endereco rua2157 = new Endereco(null, "Praça Elza Ferreira Rahal", "Jardim São Dimas", "Centro", "12245340");
		Endereco rua2158 = new Endereco(null, "Praça Melvin Jones", "Jardim São Dimas", "Centro", "12245360");
		Endereco rua2159 = new Endereco(null, "Rua Inconfidência", "Jardim São Dimas", "Centro", "12245370");
		Endereco rua2160 = new Endereco(null, "Rua Eliza Costa Santos", "Jardim São Dimas", "Centro", "12245380");
		Endereco rua2161 = new Endereco(null, "Rua Jorge de Moraes Barros", "Jardim São Dimas", "Centro", "12245390");
		Endereco rua2162 = new Endereco(null, "Rua José Antônio Romeno Neme", "Jardim São Dimas", "Centro", "12245400");
		Endereco rua2163 = new Endereco(null, "Rua Maria Francisca Froes", "Jardim São Dimas", "Centro", "12245410");
		Endereco rua2164 = new Endereco(null, "Rua Amin Assad", "Jardim São Dimas", "Centro", "12245411");
		Endereco rua2165 = new Endereco(null, "Travessa Senador Accyoli Filho", "Jardim São Dimas", "Centro",
				"12245420");
		Endereco rua2166 = new Endereco(null, "Rua Ilza Irma Moeller Coppio", "Jardim São Dimas", "Centro", "12245430");
		Endereco rua2167 = new Endereco(null, "Praça Monsenhor Ascânio Brandão", "Jardim São Dimas", "Centro",
				"12245440");
		Endereco rua2168 = new Endereco(null, "Rua José Mattar", "Jardim São Dimas", "Centro", "12245450");
		Endereco rua2169 = new Endereco(null, "Rua Paulo Setúbal", "Jardim São Dimas", "Centro", "12245460");
		Endereco rua2170 = new Endereco(null, "Avenida Engenheiro Francisco José Longo", " 149", "Jardim São Dimas",
				"Centro");
		Endereco rua2171 = new Endereco(null, "Rua Euclides Miragaia", " 374", "Jardim São Dimas", "Centro");
		Endereco rua2172 = new Endereco(null, "Rua Euclides Miragaia", " 433", "Jardim São Dimas", "Centro");
		Endereco rua2173 = new Endereco(null, "Avenida Doutor Nelson D'Avila", " 1125", "Jardim São Dimas", "Centro");
		Endereco rua2174 = new Endereco(null, "Avenida Engenheiro Francisco José Longo", " 555", "Jardim São Dimas",
				"Centro");
		Endereco rua2175 = new Endereco(null, "Avenida Engenheiro Francisco José Longo", " 633", "Jardim São Dimas",
				"Centro");
		Endereco rua2176 = new Endereco(null, "Avenida Engenheiro Francisco José Longo", " 622", "Jardim São Dimas",
				"Centro");
		Endereco rua2177 = new Endereco(null, "Rua Inconfidência", " 212", "Jardim São Dimas", "Centro");
		Endereco rua2178 = new Endereco(null, "Rua Maestro Egydio Pinto", " 169", "Jardim São Dimas", "Centro");
		Endereco rua2179 = new Endereco(null, "Rua Helena David Neme", " 94", "Jardim São Dimas", "Centro");
		Endereco rua2180 = new Endereco(null, "Rua Helena David Neme", " 110", "Jardim São Dimas", "Centro");
		Endereco rua2181 = new Endereco(null, "Rua Paulo Setúbal", " 220", "Jardim São Dimas", "Centro");
		Endereco rua2182 = new Endereco(null, "Praça Cândido Dias Castejon", " 26", "Jardim São Dimas", "Centro");
		Endereco rua2183 = new Endereco(null, "Avenida Doutor Nelson D'Avila", " 90", "Jardim São Dimas", "Centro");
		Endereco rua2184 = new Endereco(null, "Rua Paraibuna", " 767", "Jardim São Dimas", "Centro");
		Endereco rua2185 = new Endereco(null, "Rua Vicente Mota Corrêa", "Jardim São Jorge", "Leste", "12221160");
		Endereco rua2186 = new Endereco(null, "Rua Benedito Pacheco Salgado", "Jardim São Jorge", "Leste", "12221170");
		Endereco rua2187 = new Endereco(null, "Rua Eurípedes Mascarenhas", "Jardim São Jorge", "Leste", "12221180");
		Endereco rua2188 = new Endereco(null, "Rua Cristóvão de Alencar", "Jardim São Jorge", "Leste", "12221190");
		Endereco rua2189 = new Endereco(null, "Praça das Árvores", "Jardim São Jorge", "Leste", "12221195");
		Endereco rua2190 = new Endereco(null, "Rua Milton Cruz", "Jardim São Jorge", "Leste", "12221200");
		Endereco rua2191 = new Endereco(null, "Rua Afonso Galvão", "Jardim São Jorge", "Leste", "12221500");
		Endereco rua2192 = new Endereco(null, "Rua Tesouro", "Jardim São Jorge", "Leste", "12221501");
		Endereco rua2193 = new Endereco(null, "Rua Turmalina", "Jardim São José Centro", "Leste", "12215750");
		Endereco rua2194 = new Endereco(null, "Rua Jaspe", "Jardim São José Centro", "Leste", "12215770");
		Endereco rua2195 = new Endereco(null, "Rua Cristal", "Jardim São José Centro", "Leste", "12215780");
		Endereco rua2196 = new Endereco(null, "Rua Sardonica", "Jardim São José Centro", "Leste", "12215790");
		Endereco rua2197 = new Endereco(null, "Rua Jade", "Jardim São José Centro", "Leste", "12215805");
		Endereco rua2198 = new Endereco(null, "Rua Granada", "Jardim São José Centro", "Leste", "12215810");
		Endereco rua2199 = new Endereco(null, "Rua Jacinto", "Jardim São José Centro", "Leste", "12215820");
		Endereco rua2200 = new Endereco(null, "Praça Platina", "Jardim São José Centro", "Leste", "12215830");
		Endereco rua2201 = new Endereco(null, "Rua Água Marinha", "Jardim São José Centro", "Leste", "12216250");
		Endereco rua2202 = new Endereco(null, "Rua Alabastro", "Jardim São José Centro", "Leste", "12216260");
		Endereco rua2203 = new Endereco(null, "Rua Ametista", "Jardim São José Centro", "Leste", "12216270");
		Endereco rua2204 = new Endereco(null, "Rua Topázio", "Jardim São José Centro", "Leste", "12216290");
		Endereco rua2205 = new Endereco(null, "Rua Opala", "Jardim São José Centro", "Leste", "12216300");
		Endereco rua2206 = new Endereco(null, "Rua Pérola", "Jardim São José Centro", "Leste", "12216310");
		Endereco rua2207 = new Endereco(null, "Rua Rubi", "Jardim São José Centro", "Leste", "12216320");
		Endereco rua2208 = new Endereco(null, "Rua Safira", "Jardim São José Centro", "Leste", "12216330");
		Endereco rua2209 = new Endereco(null, "Rua Turquesa", "Jardim São José Centro", "Leste", "12216350");
		Endereco rua2210 = new Endereco(null, "Rua Danilo Eduardo Rios Ramos", "Jardim São José Leste", "Leste",
				"12248610");
		Endereco rua2211 = new Endereco(null, "Rua Adelaide Louzada Franco do Amaral", "Jardim São José Leste", "Leste",
				"12248611");
		Endereco rua2212 = new Endereco(null, "Rua Laura Pereira Rios", "Jardim São José Leste", "Leste", "12248613");
		Endereco rua2213 = new Endereco(null, "Avenida João Gomes da Silva", "Jardim São José Leste", "Leste",
				"12248616");
		Endereco rua2214 = new Endereco(null, "Rua Benedicta Maria da Conceição", "Jardim São José Leste", "Leste",
				"12248619");
		Endereco rua2215 = new Endereco(null, "Rua Maximiano dos Santos", "Jardim São José Leste", "Leste", "12248622");
		Endereco rua2216 = new Endereco(null, "Rua Elias Anacleto do Prado", "Jardim São José Leste", "Leste",
				"12248625");
		Endereco rua2217 = new Endereco(null, "Rua Padre Cícero Romão Batista", "Jardim São José Leste", "Leste",
				"12248628");
		Endereco rua2218 = new Endereco(null, "Rua Sebastião Martins Ramos", "Jardim São José Leste", "Leste",
				"12248631");
		Endereco rua2219 = new Endereco(null, "Rua João Pereira de Castro", "Jardim São José Leste", "Leste",
				"12248634");
		Endereco rua2220 = new Endereco(null, "Rua Genilda Maria Almeida de Oliveira", "Jardim São José Leste", "Leste",
				"12248637");
		Endereco rua2221 = new Endereco(null, "Rua Noêmia dos Santos Barbosa", "Jardim São José Leste", "Leste",
				"12248640");
		Endereco rua2222 = new Endereco(null, "Rua José Hélio do Nascimento", "Jardim São José Leste", "Leste",
				"12248643");
		Endereco rua2223 = new Endereco(null, "Praça José Marcelino de Sousa", "Jardim São José Leste", "Leste",
				"12248646");
		Endereco rua2224 = new Endereco(null, "Rua Tom Jobim", "Jardim São José II", "Leste", "12248660");
		Endereco rua2225 = new Endereco(null, "Rua Tim Lopes", "Jardim São José II", "Leste", "12248662");
		Endereco rua2226 = new Endereco(null, "Rua Jorge Amado", "Jardim São José II", "Leste", "12248666");
		Endereco rua2227 = new Endereco(null, "Rua Armagedon", "Jardim São José II", "Leste", "12248670");
		Endereco rua2228 = new Endereco(null, "Rua Frediano Bianchi Filho", "Jardim São José II", "Leste", "12248674");
		Endereco rua2229 = new Endereco(null, "Rua Ayrton Senna da Silva", "Jardim São José II", "Leste", "12248678");
		Endereco rua2230 = new Endereco(null, "Avenida João Gomes da Silva", "Jardim São José II", "Leste", "12248682");
		Endereco rua2231 = new Endereco(null, "Rua Vinícius de Moraes", "Jardim São José II", "Leste", "12248685");
		Endereco rua2232 = new Endereco(null, "Rua Danilo Eduardo Rios Ramos", "Jardim São José II", "Leste",
				"12248686");
		Endereco rua2233 = new Endereco(null, "Avenida São Cristóvão", "Jardim São Judas Tadeu", "Sudeste", "12228260");
		Endereco rua2234 = new Endereco(null, "Praça Carla Marcela Pereira dos Santos", "Jardim São Judas Tadeu",
				"Sudeste", "12228267");
		Endereco rua2235 = new Endereco(null, "Rua São Tomé", "Jardim São Judas Tadeu", "Sudeste", "12228270");
		Endereco rua2236 = new Endereco(null, "Rua São Bento", "Jardim São Judas Tadeu", "Sudeste", "12228280");
		Endereco rua2237 = new Endereco(null, "Rua São Felipe", "Jardim São Judas Tadeu", "Sudeste", "12228290");
		Endereco rua2238 = new Endereco(null, "Rua São Bartolomeu", "Jardim São Judas Tadeu", "Sudeste", "12228300");
		Endereco rua2239 = new Endereco(null, "Rua São Vitalino", "Jardim São Judas Tadeu", "Sudeste", "12228310");
		Endereco rua2240 = new Endereco(null, "Rua São Geraldo", "Jardim São Judas Tadeu", "Sudeste", "12228320");
		Endereco rua2241 = new Endereco(null, "Rua São Teófilo", "Jardim São Judas Tadeu", "Sudeste", "12228330");
		Endereco rua2242 = new Endereco(null, "Avenida São Afonso Maria", "Jardim São Judas Tadeu", "Sudeste",
				"12228340");
		Endereco rua2243 = new Endereco(null, "Avenida São Jerônimo", "Jardim São Judas Tadeu", "Sudeste", "12228350");
		Endereco rua2244 = new Endereco(null, "Avenida São Francisco de Assis", "Jardim São Judas Tadeu", "Sudeste",
				"12228360");
		Endereco rua2245 = new Endereco(null, "Avenida São Vicente de Paulo", "Jardim São Judas Tadeu", "Sudeste",
				"12228370");
		Endereco rua2246 = new Endereco(null, "Rua Osberre Bassi", "Jardim São Judas Tadeu", "Sudeste", "12228371");
		Endereco rua2247 = new Endereco(null, "Praça Frei Galvão", "Jardim São Judas Tadeu", "Sudeste", "12228373");
		Endereco rua2248 = new Endereco(null, "Rua São Damião", "Jardim São Judas Tadeu", "Sudeste", "12228380");
		Endereco rua2249 = new Endereco(null, "Rua São Cosme", "Jardim São Judas Tadeu", "Sudeste", "12228390");
		Endereco rua2250 = new Endereco(null, "Rua São Germano", "Jardim São Judas Tadeu", "Sudeste", "12228400");
		Endereco rua2251 = new Endereco(null, "Rua Santa Rita de Cássia", "Jardim São Judas Tadeu", "Sudeste",
				"12228408");
		Endereco rua2252 = new Endereco(null, "Rua São Lucas", "Jardim São Judas Tadeu", "Sudeste", "12228410");
		Endereco rua2253 = new Endereco(null, "Rua São Gabriel", "Jardim São Judas Tadeu", "Sudeste", "12228411");
		Endereco rua2254 = new Endereco(null, "Rua Santa Mônica", "Jardim São Judas Tadeu", "Sudeste", "12228412");
		Endereco rua2255 = new Endereco(null, "Rua São Mateus", "Jardim São Judas Tadeu", "Sudeste", "12228420");
		Endereco rua2256 = new Endereco(null, "Rua Nossa Senhora Do Loretto", "Jardim São Judas Tadeu", "Sudeste",
				"12228422");
		Endereco rua2257 = new Endereco(null, "Rua B", "Jardim São Judas Tadeu", "Sudeste", "12228423");
		Endereco rua2258 = new Endereco(null, "Rua São Guido", "Jardim São Judas Tadeu", "Sudeste", "12228424");
		Endereco rua2259 = new Endereco(null, "Travessa Santa Paulina", "Jardim São Judas Tadeu", "Sudeste",
				"12228425");
		Endereco rua2260 = new Endereco(null, "Avenida São Nicolau", "Jardim São Judas Tadeu", "Sudeste", "12228430");
		Endereco rua2261 = new Endereco(null, "Rua São Tiago", "Jardim São Judas Tadeu", "Sudeste", "12228440");
		Endereco rua2262 = new Endereco(null, "Rua São Januário", "Jardim São Judas Tadeu", "Sudeste", "12228450");
		Endereco rua2263 = new Endereco(null, "Rua São Afonso Maria", "Jardim São Judas Tadeu", "Sudeste", "12228451");
		Endereco rua2264 = new Endereco(null, "Avenida José Ignacio Bicudo", "Jardim São Leopoldo", "Sudeste",
				"12228180");
		Endereco rua2265 = new Endereco(null, "Rua Alexandrino Machado", "Jardim São Leopoldo", "Sudeste", "12228181");
		Endereco rua2266 = new Endereco(null, "Rua Cesarina Rodrigues Eras Soares", "Jardim São Leopoldo", "Sudeste",
				"12228182");
		Endereco rua2267 = new Endereco(null, "Travessa Maria Alves Gonçalves", "Jardim São Leopoldo", "Sudeste",
				"12228184");
		Endereco rua2268 = new Endereco(null, "Viela Antônio Luiz da Silva", "Jardim São Leopoldo", "Sudeste",
				"12228186");
		Endereco rua2269 = new Endereco(null, "Viela Maria Alves Gonçalves", "Jardim São Leopoldo", "Sudeste",
				"12228188");
		Endereco rua2270 = new Endereco(null, "Avenida José Gonçalves de Campos", "Jardim São Leopoldo", "Sudeste",
				"12228190");
		Endereco rua2271 = new Endereco(null, "Rua Natalio Ângelo Stabeli", "Jardim São Leopoldo", "Sudeste",
				"12228191");
		Endereco rua2272 = new Endereco(null, "Rua Aníbal Berardinelli Tarantino", "Jardim São Leopoldo", "Sudeste",
				"12228200");
		Endereco rua2273 = new Endereco(null, "Rua Deolino Bueno de Camargo", "Jardim São Leopoldo", "Sudeste",
				"12228210");
		Endereco rua2274 = new Endereco(null, "Rua Maria Olímpia Rodrigues de Toledo", "Jardim São Leopoldo", "Sudeste",
				"12228220");
		Endereco rua2275 = new Endereco(null, "Rua Riva Idesis", "Jardim São Leopoldo", "Sudeste", "12228230");
		Endereco rua2276 = new Endereco(null, "Rua Moacir de Siqueira", "Jardim São Leopoldo", "Sudeste", "12228240");
		Endereco rua2277 = new Endereco(null, "Estrada Pernambucano", "Jardim São Leopoldo", "Sudeste", "12228250");
		Endereco rua2278 = new Endereco(null, "Avenida Ilidio Meinberg Porto", "Jardim São Vicente", "Leste",
				"12224310");
		Endereco rua2279 = new Endereco(null, "Rua Pedro Daniel", "Jardim São Vicente", "Leste", "12224320");
		Endereco rua2280 = new Endereco(null, "Rua Erotides Teixeira de Souza", "Jardim São Vicente", "Leste",
				"12224330");
		Endereco rua2281 = new Endereco(null, "Rua José Benedito Calil", "Jardim São Vicente", "Leste", "12224340");
		Endereco rua2282 = new Endereco(null, "Avenida José Francisco Marcondes", "Jardim São Vicente", "Leste",
				"12224350");
		Endereco rua2283 = new Endereco(null, "Rua Judite Machado Cursino", "Jardim São Vicente", "Leste", "12224360");
		Endereco rua2284 = new Endereco(null, "Avenida José Pedro", "Jardim São Vicente", "Leste", "12224370");
		Endereco rua2285 = new Endereco(null, "Avenida Carmelina Alves dos Santos", "Jardim São Vicente", "Leste",
				"12224380");
		Endereco rua2286 = new Endereco(null, "Rua Doutor João Tranchesi", "Jardim São Vicente", "Leste", "12224390");
		Endereco rua2287 = new Endereco(null, "Avenida Professor Possidonio Salles", "Jardim São Vicente", "Leste",
				"12224400");
		Endereco rua2288 = new Endereco(null, "Rua Doutor Cláudio Martins Miranda Chaves", "Jardim São Vicente",
				"Leste", "12224410");
		Endereco rua2289 = new Endereco(null, "Rua Edward Wilson Kimbask", "Jardim São Vicente", "Leste", "12224420");
		Endereco rua2290 = new Endereco(null, "Rua Elídio Memberg Porto", "Jardim São Vicente", "Leste", "12224421");
		Endereco rua2291 = new Endereco(null, "Rua Esmeraldo Baptista Santana", "Jardim São Vicente", "Leste",
				"12224430");
		Endereco rua2292 = new Endereco(null, "Rua Nalva Paiva da Mata", "Jardim São Vicente", "Leste", "12224440");
		Endereco rua2293 = new Endereco(null, "Avenida Ruth Merrik Kimbask", "Jardim São Vicente", "Leste", "12224450");
		Endereco rua2294 = new Endereco(null, "Rua Mohabe Anisse Cury", "Jardim São Vicente", "Leste", "12224460");
		Endereco rua2295 = new Endereco(null, "Rua Professora Otavia Raimundo da Silva", "Jardim São Vicente", "Leste",
				"12224470");
		Endereco rua2296 = new Endereco(null, "Avenida Andrômeda", "Jardim Satélite", "Sul", "12230000");
		Endereco rua2297 = new Endereco(null, "Avenida Andrômeda", "Jardim Satélite", "Sul", "12230001");
		Endereco rua2298 = new Endereco(null, "Rodovia Presidente Dutra", "Jardim Satélite", "Sul", "12230002");
		Endereco rua2299 = new Endereco(null, "Avenida Cassiopéia", "Jardim Satélite", "Sul", "12230010");
		Endereco rua2300 = new Endereco(null, "Avenida Cassiopéia", "Jardim Satélite", "Sul", "12230011");
		Endereco rua2301 = new Endereco(null, "Rua Tijuca", "Jardim Satélite", "Sul", "12230020");
		Endereco rua2302 = new Endereco(null, "Rua Leblon", "Jardim Satélite", "Sul", "12230021");
		Endereco rua2303 = new Endereco(null, "Rua Copacabana", "Jardim Satélite", "Sul", "12230030");
		Endereco rua2304 = new Endereco(null, "Rua Arpoador", "Jardim Satélite", "Sul", "12230040");
		Endereco rua2305 = new Endereco(null, "Rua Reverendo Américo de Castro", "Jardim Satélite", "Sul", "12230050");
		Endereco rua2306 = new Endereco(null, "Rua Porto Novo", "Jardim Satélite", "Sul", "12230060");
		Endereco rua2307 = new Endereco(null, "Rua Ipanema", "Jardim Satélite", "Sul", "12230070");
		Endereco rua2308 = new Endereco(null, "Rua Pedro Tursi", "Jardim Satélite", "Sul", "12230075");
		Endereco rua2309 = new Endereco(null, "Rua Patrício Santana", "Jardim Satélite", "Sul", "12230080");
		Endereco rua2310 = new Endereco(null, "Rua Maricá", "Jardim Satélite", "Sul", "12230100");
		Endereco rua2311 = new Endereco(null, "Rua Barra Velha", "Jardim Satélite", "Sul", "12230110");
		Endereco rua2312 = new Endereco(null, "Rua Lagoinha", "Jardim Satélite", "Sul", "12230111");
		Endereco rua2313 = new Endereco(null, "Rua das Cigarras", "Jardim Satélite", "Sul", "12230120");
		Endereco rua2314 = new Endereco(null, "Rua Bambui", "Jardim Satélite", "Sul", "12230130");
		Endereco rua2315 = new Endereco(null, "Rua Cisne", "Jardim Satélite", "Sul", "12230140");
		Endereco rua2316 = new Endereco(null, "Rua Sapoti", "Jardim Satélite", "Sul", "12230150");
		Endereco rua2317 = new Endereco(null, "Rua Regulus", "Jardim Satélite", "Sul", "12230160");
		Endereco rua2318 = new Endereco(null, "Rua Tucuma", "Jardim Satélite", "Sul", "12230170");
		Endereco rua2319 = new Endereco(null, "Rua Gemini", "Jardim Satélite", "Sul", "12230180");
		Endereco rua2320 = new Endereco(null, "Rua Procion", "Jardim Satélite", "Sul", "12230190");
		Endereco rua2321 = new Endereco(null, "Rua Arturus", "Jardim Satélite", "Sul", "12230200");
		Endereco rua2322 = new Endereco(null, "Rua Aires", "Jardim Satélite", "Sul", "12230210");
		Endereco rua2323 = new Endereco(null, "Rua Libra", "Jardim Satélite", "Sul", "12230220");
		Endereco rua2324 = new Endereco(null, "Rua Altair", "Jardim Satélite", "Sul", "12230230");
		Endereco rua2325 = new Endereco(null, "Rua Polar", "Jardim Satélite", "Sul", "12230240");
		Endereco rua2326 = new Endereco(null, "Rua Antares", "Jardim Satélite", "Sul", "12230250");
		Endereco rua2327 = new Endereco(null, "Rua Pegaso", "Jardim Satélite", "Sul", "12230260");
		Endereco rua2328 = new Endereco(null, "Rua Carangola", "Jardim Satélite", "Sul", "12230270");
		Endereco rua2329 = new Endereco(null, "Rua Sirius", "Jardim Satélite", "Sul", "12230280");
		Endereco rua2330 = new Endereco(null, "Rua Andaraí", "Jardim Satélite", "Sul", "12230290");
		Endereco rua2331 = new Endereco(null, "Avenida Doutor Sebastião Henrique da Cunha Pontes", "Jardim Satélite",
				"Sul", "12230300");
		Endereco rua2332 = new Endereco(null, "Rua Pleiades", "Jardim Satélite", "Sul", "12230310");
		Endereco rua2333 = new Endereco(null, "Rua Castor", "Jardim Satélite", "Sul", "12230320");
		Endereco rua2334 = new Endereco(null, "Rua Auriflama", "Jardim Satélite", "Sul", "12230330");
		Endereco rua2335 = new Endereco(null, "Rua Gravataí", "Jardim Satélite", "Sul", "12230340");
		Endereco rua2336 = new Endereco(null, "Travessa Pirituba", "Jardim Satélite", "Sul", "12230341");
		Endereco rua2337 = new Endereco(null, "Rua Araribóia", "Jardim Satélite", "Sul", "12230350");
		Endereco rua2338 = new Endereco(null, "Rua Boituva", "Jardim Satélite", "Sul", "12230351");
		Endereco rua2339 = new Endereco(null, "Rua Apeninos", "Jardim Satélite", "Sul", "12230360");
		Endereco rua2340 = new Endereco(null, "Rua Pollux", "Jardim Satélite", "Sul", "12230370");
		Endereco rua2341 = new Endereco(null, "Rua Auriga", "Jardim Satélite", "Sul", "12230380");
		Endereco rua2342 = new Endereco(null, "Rua Eridanus", "Jardim Satélite", "Sul", "12230390");
		Endereco rua2343 = new Endereco(null, "Rua Aldebaram", "Jardim Satélite", "Sul", "12230400");
		Endereco rua2344 = new Endereco(null, "Rua Delfim", "Jardim Satélite", "Sul", "12230410");
		Endereco rua2345 = new Endereco(null, "Rua Virgem", "Jardim Satélite", "Sul", "12230420");
		Endereco rua2346 = new Endereco(null, "Rua Vega", "Jardim Satélite", "Sul", "12230430");
		Endereco rua2347 = new Endereco(null, "Rua Carina", "Jardim Satélite", "Sul", "12230440");
		Endereco rua2348 = new Endereco(null, "Rua Draco", "Jardim Satélite", "Sul", "12230450");
		Endereco rua2349 = new Endereco(null, "Rua Canopus", "Jardim Satélite", "Sul", "12230460");
		Endereco rua2350 = new Endereco(null, "Avenida Perseu", "Jardim Satélite", "Sul", "12230470");
		Endereco rua2351 = new Endereco(null, "Rua Estrela Dalva", "Jardim Satélite", "Sul", "12230480");
		Endereco rua2352 = new Endereco(null, "Rua Volans", "Jardim Satélite", "Sul", "12230490");
		Endereco rua2353 = new Endereco(null, "Praça Arlindo Fernandes", "Jardim Satélite", "Sul", "12230491");
		Endereco rua2354 = new Endereco(null, "Praça Pireu", "Jardim Satélite", "Sul", "12230492");
		Endereco rua2355 = new Endereco(null, "Rua Botelhos", "Jardim Satélite", "Sul", "12230493");
		Endereco rua2356 = new Endereco(null, "Rua Caeté", "Jardim Satélite", "Sul", "12230494");
		Endereco rua2357 = new Endereco(null, "Rua Galícia", "Jardim Satélite", "Sul", "12230500");
		Endereco rua2358 = new Endereco(null, "Avenida Urupês", "Jardim Satélite", "Sul", "12230510");
		Endereco rua2359 = new Endereco(null, "Rua Licorne", "Jardim Satélite", "Sul", "12230520");
		Endereco rua2360 = new Endereco(null, "Rua Scutum", "Jardim Satélite", "Sul", "12230530");
		Endereco rua2361 = new Endereco(null, "Rua Brasópolis", "Jardim Satélite", "Sul", "12230531");
		Endereco rua2362 = new Endereco(null, "Praça Deolinda de Abreu Lima", "Jardim Satélite", "Sul", "12230532");
		Endereco rua2363 = new Endereco(null, "Rua Pisces", "Jardim Satélite", "Sul", "12230540");
		Endereco rua2364 = new Endereco(null, "Rua Crater", "Jardim Satélite", "Sul", "12230550");
		Endereco rua2365 = new Endereco(null, "Rua Cotegipe", "Jardim Satélite", "Sul", "12230551");
		Endereco rua2366 = new Endereco(null, "Rua Galgos", "Jardim Satélite", "Sul", "12230560");
		Endereco rua2367 = new Endereco(null, "Rua Scorpius", "Jardim Satélite", "Sul", "12230570");
		Endereco rua2368 = new Endereco(null, "Rua Cataguazes", "Jardim Satélite", "Sul", "12230571");
		Endereco rua2369 = new Endereco(null, "Rua Marcabe", "Jardim Satélite", "Sul", "12230580");
		Endereco rua2370 = new Endereco(null, "Rua Scultor", "Jardim Satélite", "Sul", "12230590");
		Endereco rua2371 = new Endereco(null, "Rua Lira", "Jardim Satélite", "Sul", "12230600");
		Endereco rua2372 = new Endereco(null, "Rua Cefeu", "Jardim Satélite", "Sul", "12230610");
		Endereco rua2373 = new Endereco(null, "Rua Hiades", "Jardim Satélite", "Sul", "12230611");
		Endereco rua2374 = new Endereco(null, "Rua Bogari", "Jardim Satélite", "Sul", "12230612");
		Endereco rua2375 = new Endereco(null, "Rua Leão", "Jardim Satélite", "Sul", "12230620");
		Endereco rua2376 = new Endereco(null, "Praça Cândido Bertolini", "Jardim Satélite", "Sul", "12230621");
		Endereco rua2377 = new Endereco(null, "Rua Enseada", "Jardim Satélite", "Sul", "12230630");
		Endereco rua2378 = new Endereco(null, "Rua Cocanha", "Jardim Satélite", "Sul", "12230640");
		Endereco rua2379 = new Endereco(null, "Rua Massaguacu", "Jardim Satélite", "Sul", "12230650");
		Endereco rua2380 = new Endereco(null, "Rua Itambé", "Jardim Satélite", "Sul", "12230660");
		Endereco rua2381 = new Endereco(null, "Rua Nazaré", "Jardim Satélite", "Sul", "12230670");
		Endereco rua2382 = new Endereco(null, "Rua Maranduba", "Jardim Satélite", "Sul", "12230680");
		Endereco rua2383 = new Endereco(null, "Rua Martim de Sá", "Jardim Satélite", "Sul", "12230690");
		Endereco rua2384 = new Endereco(null, "Rua Iporanga", "Jardim Satélite", "Sul", "12230700");
		Endereco rua2385 = new Endereco(null, "Rua Bertioga", "Jardim Satélite", "Sul", "12230710");
		Endereco rua2386 = new Endereco(null, "Avenida Iguape", "Jardim Satélite", "Sul", "12230720");
		Endereco rua2387 = new Endereco(null, "Rua Cedral", "Jardim Satélite", "Sul", "12230730");
		Endereco rua2388 = new Endereco(null, "Rua Itapetinga", "Jardim Satélite", "Sul", "12230740");
		Endereco rua2389 = new Endereco(null, "Rua Ipiau", "Jardim Satélite", "Sul", "12230750");
		Endereco rua2390 = new Endereco(null, "Rua Buerarema", "Jardim Satélite", "Sul", "12230760");
		Endereco rua2391 = new Endereco(null, "Rua Ilhéus", "Jardim Satélite", "Sul", "12230770");
		Endereco rua2392 = new Endereco(null, "Rua Jequie", "Jardim Satélite", "Sul", "12230780");
		Endereco rua2393 = new Endereco(null, "Rua Itabuna", "Jardim Satélite", "Sul", "12230790");
		Endereco rua2394 = new Endereco(null, "Rua Cabo Frio", "Jardim Satélite", "Sul", "12230800");
		Endereco rua2395 = new Endereco(null, "Rua Itapoã", "Jardim Satélite", "Sul", "12230810");
		Endereco rua2396 = new Endereco(null, "Rua Pituba", "Jardim Satélite", "Sul", "12230820");
		Endereco rua2397 = new Endereco(null, "Rua Cruzália", "Jardim Satélite", "Sul", "12230830");
		Endereco rua2398 = new Endereco(null, "Rua Leticia", "Jardim Satélite", "Sul", "12230840");
		Endereco rua2399 = new Endereco(null, "Rua Antônio Ferro", "Jardim Satélite", "Sul", "12230841");
		Endereco rua2400 = new Endereco(null, "Rua Araxá", "Jardim Satélite", "Sul", "12230842");
		Endereco rua2401 = new Endereco(null, "Rua Benedito Ivo Filho", "Jardim Satélite", "Sul", "12230843");
		Endereco rua2402 = new Endereco(null, "Rua Ceteus", "Jardim Satélite", "Sul", "12230844");
		Endereco rua2403 = new Endereco(null, "Rua Coronel Delfino Ramos", "Jardim Satélite", "Sul", "12230845");
		Endereco rua2404 = new Endereco(null, "Rua Humberto Pinotti", "Jardim Satélite", "Sul", "12230846");
		Endereco rua2405 = new Endereco(null, "Rua Pedro Tursi", " 200", "Jardim Satélite", "Sul");
		Endereco rua2406 = new Endereco(null, "Rua Porto Novo", " 300", "Jardim Satélite", "Sul");
		Endereco rua2407 = new Endereco(null, "Rua Porto Novo", " 40", "Jardim Satélite", "Sul");
		Endereco rua2408 = new Endereco(null, "Rua Porto Novo", " 220", "Jardim Satélite", "Sul");
		Endereco rua2409 = new Endereco(null, "Rua Antares", " 115", "Jardim Satélite", "Sul");
		Endereco rua2410 = new Endereco(null, "Rua Polar", " 20", "Jardim Satélite", "Sul");
		Endereco rua2411 = new Endereco(null, "Avenida Andrômeda", " 287", "Jardim Satélite", "Sul");
		Endereco rua2412 = new Endereco(null, "Avenida Perseu", " 683", "Jardim Satélite", "Sul");
		Endereco rua2413 = new Endereco(null, "Avenida Andrômeda", " 1469", "Jardim Satélite", "Sul");
		Endereco rua2414 = new Endereco(null, "Rua Osvaldo Macedo Lecques", "Jardim Satélite", "Sul", "12231610");
		Endereco rua2415 = new Endereco(null, "Rua Luiz Gonzaga Sendretti", "Jardim Satélite", "Sul", "12231630");
		Endereco rua2416 = new Endereco(null, "Rua Pedro Martins de Toledo", "Jardim Satélite", "Sul", "12231640");
		Endereco rua2417 = new Endereco(null, "Rua Vasomiro Malaquias de Barros", "Jardim Satélite", "Sul", "12231642");
		Endereco rua2418 = new Endereco(null, "Rua Antônio Aleixo da Silva", "Jardim Satélite", "Sul", "12231650");
		Endereco rua2419 = new Endereco(null, "Rua Zacarias Silva", "Jardim Satélite", "Sul", "12231660");
		Endereco rua2420 = new Endereco(null, "Rua Antônio Joaquim de Alvarenga", "Jardim Satélite", "Sul", "12231670");
		Endereco rua2421 = new Endereco(null, "Avenida Cidade Jardim", "Jardim Satélite", "Sul", "12231675");
		Endereco rua2422 = new Endereco(null, "Rua Antônio Constantino", "Jardim Satélite", "Sul", "12231680");
		Endereco rua2423 = new Endereco(null, "Rua Mário Alves de Almeida", "Jardim Satélite", "Sul", "12231690");
		Endereco rua2424 = new Endereco(null, "Rua Demétrio Diacov", "Jardim Satélite", "Sul", "12231700");
		Endereco rua2425 = new Endereco(null, "Avenida Papa João Paulo I", "Jardim Satélite", "Sul", "12231710");
		Endereco rua2426 = new Endereco(null, "Rua Osvaldo Faria", "Jardim Satélite", "Sul", "12231720");
		Endereco rua2427 = new Endereco(null, "Rua Adolpho Castanho", "Jardim Satélite", "Sul", "12231730");
		Endereco rua2428 = new Endereco(null, "Rua Cesarina Della Dea Betti", "Jardim Satélite", "Sul", "12231740");
		Endereco rua2429 = new Endereco(null, "Rua Benedito Alves Moreira", "Jardim Satélite", "Sul", "12231750");
		Endereco rua2430 = new Endereco(null, "Rua Margarida F. dos Santos", "Jardim Satélite", "Sul", "12231760");
		Endereco rua2431 = new Endereco(null, "Rua Jaime Martins Xavier", "Jardim Satélite", "Sul", "12231770");
		Endereco rua2432 = new Endereco(null, "Rua Delfino Alves dos Santos", "Jardim Satélite", "Sul", "12231780");
		Endereco rua2433 = new Endereco(null, "Rua Avelina Faria Cursino", "Jardim Satélite", "Sul", "12231790");
		Endereco rua2434 = new Endereco(null, "Rua Marco Antônio dos Santos", "Jardim Satélite", "Sul", "12231800");
		Endereco rua2435 = new Endereco(null, "Rua José Guilherme de Almeida", "Jardim Satélite", "Sul", "12231810");
		Endereco rua2436 = new Endereco(null, "Rua Maria Asdente Rosin", "Jardim Satélite", "Sul", "12231814");
		Endereco rua2437 = new Endereco(null, "Rua Nelson Augusto Dalprat", "Jardim Satélite", "Sul", "12231815");
		Endereco rua2438 = new Endereco(null, "Rua Léa Maria Brandão Russo", "Jardim Satélite", "Sul", "12231820");
		Endereco rua2439 = new Endereco(null, "Rua José Pedro Perotti", "Jardim Satélite", "Sul", "12231830");
		Endereco rua2440 = new Endereco(null, "Avenida Papa João Paulo I", " 501", "Jardim Satélite", "Sul");
		Endereco rua2441 = new Endereco(null, "Avenida Cidade Jardim", " 2261", "Jardim Satélite", "Sul");
		Endereco rua2442 = new Endereco(null, "Rua Avião Ipanema", "Jardim Souto", "Sudeste", "12227080");
		Endereco rua2443 = new Endereco(null, "Rua Avião Paulistinha", "Jardim Souto", "Sudeste", "12227081");
		Endereco rua2444 = new Endereco(null, "Avenida dos Astronautas", "Jardim Souto", "Sudeste", "12227082");
		Endereco rua2445 = new Endereco(null, "Rua Avião Brasília", "Jardim Souto", "Sudeste", "12227083");
		Endereco rua2446 = new Endereco(null, "Rua Avião Aribu", "Jardim Souto", "Sudeste", "12227090");
		Endereco rua2447 = new Endereco(null, "Rua Avião Muniz", "Jardim Souto", "Sudeste", "12227100");
		Endereco rua2448 = new Endereco(null, "Rua Avião Universal", "Jardim Souto", "Sudeste", "12227110");
		Endereco rua2449 = new Endereco(null, "Rua Avião Alvear", "Jardim Souto", "Sudeste", "12227120");
		Endereco rua2450 = new Endereco(null, "Rua Avião Uirapuru", "Jardim Souto", "Sudeste", "12227130");
		Endereco rua2451 = new Endereco(null, "Praça Quatorze Bis", "Jardim Souto", "Sudeste", "12227140");
		Endereco rua2452 = new Endereco(null, "Rua Avião Regente", "Jardim Souto", "Sudeste", "12227150");
		Endereco rua2453 = new Endereco(null, "Rua Avião Tangará", "Jardim Souto", "Sudeste", "12227160");
		Endereco rua2454 = new Endereco(null, "Rua Avião Bandeirantes", "Jardim Souto", "Sudeste", "12227170");
		Endereco rua2455 = new Endereco(null, "Avenida Rui Barbosa", "Jardim Bela Vista", "Sul", "12209000");
		Endereco rua2456 = new Endereco(null, "Avenida Marechal Castelo Branco", "Jardim Bela Vista", "Sul",
				"12209002");
		Endereco rua2457 = new Endereco(null, "Rua Capitão Roberto Ferreira Maldos", "Jardim Bela Vista", "Sul",
				"12209003");
		Endereco rua2458 = new Endereco(null, "Avenida Doutor Mário Galvão", "Jardim Bela Vista", "Sul", "12209004");
		Endereco rua2459 = new Endereco(null, "Rua Romeu Carnevalli", "Jardim Bela Vista", "Sul", "12209005");
		Endereco rua2460 = new Endereco(null, "Avenida São José", "Jardim Bela Vista", "Sul", "12209010");
		Endereco rua2461 = new Endereco(null, "Avenida Tenente Névio Baracho", "Jardim Bela Vista", "Sul", "12209020");
		Endereco rua2462 = new Endereco(null, "Praça do Expedicionário", "Jardim Bela Vista", "Sul", "12209030");
		Endereco rua2463 = new Endereco(null, "Rua Ana Eufrásia", "Jardim Bela Vista", "Sul", "12209071");
		Endereco rua2464 = new Endereco(null, "Rua Sebastião Felício", "Jardim Bela Vista", "Sul", "12209090");
		Endereco rua2465 = new Endereco(null, "Rua Laudelino Nogueira", "Jardim Bela Vista", "Sul", "12209100");
		Endereco rua2466 = new Endereco(null, "Rua José Leite da Silva", "Jardim Bela Vista", "Sul", "12209110");
		Endereco rua2467 = new Endereco(null, "Rua Geraldo Augusto dos Santos", "Jardim Bela Vista", "Sul", "12209120");
		Endereco rua2468 = new Endereco(null, "Praça Vicente Batista", "Jardim Bela Vista", "Sul", "12209130");
		Endereco rua2469 = new Endereco(null, "Rua Doutor Gaspar Resende", "Jardim Bela Vista", "Sul", "12209140");
		Endereco rua2470 = new Endereco(null, "Rua Delfino Mascarenhas", "Jardim Bela Vista", "Sul", "12209150");
		Endereco rua2471 = new Endereco(null, "Travessa Claudionor Chaves Itacaramby", "Jardim Bela Vista", "Sul",
				"12209155");
		Endereco rua2472 = new Endereco(null, "Rua Padre Antônio Vieira", "Jardim Bela Vista", "Sul", "12209160");
		Endereco rua2473 = new Endereco(null, "Viaduto dos Expedicionários", "Jardim Bela Vista", "Sul", "12209162");
		Endereco rua2474 = new Endereco(null, "Rua Joaquim Nabuco", "Jardim Bela Vista", "Sul", "12209170");
		Endereco rua2475 = new Endereco(null, "Viaduto Tenente João Alves Cardoso", "Jardim Bela Vista", "Sul",
				"12209171");
		Endereco rua2476 = new Endereco(null, "Rua José Fonseca dos Santos", "Jardim Bela Vista", "Sul", "12209180");
		Endereco rua2477 = new Endereco(null, "Rua Silvino Guedes", "Jardim Bela Vista", "Sul", "12209190");
		Endereco rua2478 = new Endereco(null, "Rua Cônego José Fortunato da Silva Ramos", "Jardim Bela Vista", "Sul",
				"12209200");
		Endereco rua2479 = new Endereco(null, "Travessa Inocêncio Alves da Silva", "Jardim Bela Vista", "Sul",
				"12209210");
		Endereco rua2480 = new Endereco(null, "Travessa Contantino Pinto", "Jardim Bela Vista", "Sul", "12209211");
		Endereco rua2481 = new Endereco(null, "Avenida Tenente Névio Baracho", " 330", "Jardim Bela Vista", "Sul");
		Endereco rua2482 = new Endereco(null, "Avenida Marechal Castelo Branco", " 439", "Jardim Bela Vista", "Sul");
		Endereco rua2483 = new Endereco(null, "Rua Oswaldo da Silva Chaves", "Jardim Ouro Preto", "Sul", "12211470");
		Endereco rua2484 = new Endereco(null, "Rua Minervina de Campos Nascimento", "Jardim Maritéia", "Sul",
				"12212440");
		Endereco rua2485 = new Endereco(null, "Rua Virgílio Emídio Bispo", "Jardim Maritéia", "Sul", "12212450");
		Endereco rua2486 = new Endereco(null, "Travessa Dourados", "Jardim Beira Rio", "Sul", "12212453");
		Endereco rua2487 = new Endereco(null, "Travessa das Piabas", "Jardim Beira Rio", "Sul", "12212455");
		Endereco rua2488 = new Endereco(null, "Rua Cândido Gonçalves de Bem", "Jardim Maritéia", "Sul", "12212460");
		Endereco rua2489 = new Endereco(null, "Rua Sargento Sílvio Guizão", "Jardim Maritéia", "Sul", "12212470");
		Endereco rua2490 = new Endereco(null, "Rua São Benedito", "Jardim Santarém", "Sul", "12212530");
		Endereco rua2491 = new Endereco(null, "Rua Santa Rita", "Jardim Santarém", "Sul", "12212540");
		Endereco rua2492 = new Endereco(null, "Rua São Sebastião", "Jardim Santarém", "Sul", "12212550");
		Endereco rua2493 = new Endereco(null, "Avenida Doutor Numa de Oliveira", "Jardim Telespark", "Sul", "12212660");
		Endereco rua2494 = new Endereco(null, "Rua Anacleto Veneziani", "Jardim Telespark", "Sul", "12212670");
		Endereco rua2495 = new Endereco(null, "Rua Zoraide Siqueira", "Jardim Telespark", "Sul", "12212680");
		Endereco rua2496 = new Endereco(null, "Rua Luiz Borges Filho", "Jardim Telespark", "Sul", "12212690");
		Endereco rua2497 = new Endereco(null, "Rua Benedito Pereira Lima", "Jardim Telespark", "Sul", "12212700");
		Endereco rua2498 = new Endereco(null, "Avenida Conde Francisco Matarazzo", "Jardim Telespark", "Sul",
				"12212710");
		Endereco rua2499 = new Endereco(null, "Rua Schaia Feigenson", "Jardim Telespark", "Sul", "12212720");
		Endereco rua2500 = new Endereco(null, "Rua Chana Baskin Feigenson", "Jardim Telespark", "Sul", "12212730");
		Endereco rua2501 = new Endereco(null, "Rua Paulo Hunger", "Jardim Telespark", "Sul", "12212740");
		Endereco rua2502 = new Endereco(null, "Rua Augusto Luiz de Almeida", "Jardim Telespark", "Sul", "12212750");
		Endereco rua2503 = new Endereco(null, "Rua Pedro David Filho", "Jardim Telespark", "Sul", "12212760");
		Endereco rua2504 = new Endereco(null, "Rua Taquaral", "Jardim Telespark", "Sul", "12212770");
		Endereco rua2505 = new Endereco(null, "Rua Doutor Edgard de Souza", "Jardim Telespark", "Sul", "12212780");
		Endereco rua2506 = new Endereco(null, "Rua Uruana", "Jardim Telespark", "Sul", "12212790");
		Endereco rua2507 = new Endereco(null, "Rua Urati", "Jardim Telespark", "Sul", "12212800");
		Endereco rua2508 = new Endereco(null, "Praça César Traballi", "Jardim Telespark", "Sul", "12212810");
		Endereco rua2509 = new Endereco(null, "Rua Maria Francisca dos Santos", "Jardim Guimarães", "Sul", "12213130");
		Endereco rua2510 = new Endereco(null, "Rua Jaguari", "Jardim Guimarães", "Sul", "12213131");
		Endereco rua2511 = new Endereco(null, "Rua José Prianti Chaves", "Jardim Guimarães", "Sul", "12213140");
		Endereco rua2512 = new Endereco(null, "Rua Francisco Rodrigues Cardoso", "Jardim Guimarães", "Sul", "12213145");
		Endereco rua2513 = new Endereco(null, "Rua Vera Babo de Oliveira", "Jardim Guimarães", "Sul", "12213150");
		Endereco rua2514 = new Endereco(null, "Rua Cecílio Corrá", "Jardim Guimarães", "Sul", "12213160");
		Endereco rua2515 = new Endereco(null, "Rua Fernando Corrá", "Jardim Guimarães", "Sul", "12213170");
		Endereco rua2516 = new Endereco(null, "Rua Benedito da Costa Andrade", "Jardim Guimarães", "Sul", "12213180");
		Endereco rua2517 = new Endereco(null, "Rua Francisco Ribeiro da Costa", "Jardim Guimarães", "Sul", "12213190");
		Endereco rua2518 = new Endereco(null, "Rua Francisco de Assis Monteiro de Barros", "Jardim Guimarães", "Sul",
				"12213200");
		Endereco rua2519 = new Endereco(null, "Rua Alice Nogueira Machado", "Jardim Minas Gerais", "Sul", "12213251");
		Endereco rua2520 = new Endereco(null, "Rua Três", "Jardim Minas Gerais", "Sul", "12213252");
		Endereco rua2521 = new Endereco(null, "Rua Avelina Dias de Souza", "Jardim Minas Gerais", "Sul", "12213253");
		Endereco rua2522 = new Endereco(null, "Rua Lázaro Gomes de Moraes", "Jardim Minas Gerais", "Sul", "12213254");
		Endereco rua2523 = new Endereco(null, "Avenida Otaviano Alves de Siqueira", "Jardim Minas Gerais", "Sul",
				"12213255");
		Endereco rua2524 = new Endereco(null, "Rua José Araújo de Andrade", "Jardim Minas Gerais", "Sul", "12213256");
		Endereco rua2525 = new Endereco(null, "Rua Fátima Benedita de Brito Profício", "Jardim Minas Gerais", "Sul",
				"12213257");
		Endereco rua2526 = new Endereco(null, "Rua Valter Luiz Pereira", "Jardim Minas Gerais", "Sul", "12213258");
		Endereco rua2527 = new Endereco(null, "Rua Dez", "Jardim Minas Gerais", "Sul", "12213259");
		Endereco rua2528 = new Endereco(null, "Rua Cid Cardozo de Andrade", "Jardim Minas Gerais", "Sul", "12213261");
		Endereco rua2529 = new Endereco(null, "Rua Rodrigo Donizetti de Souza", "Jardim Minas Gerais", "Sul",
				"12213262");
		Endereco rua2530 = new Endereco(null, "Rua Vinícius Machado Mendes", "Jardim Minas Gerais", "Sul", "12213263");
		Endereco rua2531 = new Endereco(null, "Rua Deroniz Ribeiro Nunes", "Jardim Minas Gerais", "Sul", "12213264");
		Endereco rua2532 = new Endereco(null, "Rua Reinaldo Carneiro", "Jardim Minas Gerais", "Sul", "12213265");
		Endereco rua2533 = new Endereco(null, "Avenida Joaquim Moreira Ávila", "Jardim Minas Gerais", "Sul",
				"12213266");
		Endereco rua2534 = new Endereco(null, "Rua Manoel Ferreira de Souza", "Jardim Minas Gerais", "Sul", "12213267");
		Endereco rua2535 = new Endereco(null, "Avenida José Geraldo Machado", "Jardim Minas Gerais", "Sul", "12213268");
		Endereco rua2536 = new Endereco(null, "Rua Santa Matilde", "Jardim Santa Matilde", "Sul", "12213570");
		Endereco rua2537 = new Endereco(null, "Avenida Maria Cândida Delgado", "Jardim Santa Matilde", "Sul",
				"12213573");
		Endereco rua2538 = new Endereco(null, "Rua Nossa Senhora da Salete", "Jardim Santa Matilde", "Sul", "12213580");
		Endereco rua2539 = new Endereco(null, "Travessa Maria Marta", "Jardim Santa Matilde", "Sul", "12213590");
		Endereco rua2540 = new Endereco(null, "Rua Santa Cecília", "Jardim Santa Matilde", "Sul", "12213600");
		Endereco rua2541 = new Endereco(null, "Rua Professor Adjacy Sampaio Murity", "Jardim Santa Matilde", "Sul",
				"12213610");
		Endereco rua2542 = new Endereco(null, "Praça Santa Efigênia", "Jardim Santa Matilde", "Sul", "12213620");
		Endereco rua2543 = new Endereco(null, "Rua Maria Luiza Rodrigues Costa", "Jardim Boa Vista", "Sul", "12213630");
		Endereco rua2544 = new Endereco(null, "Rua Ângelo Miguel Scavazzini", "Jardim Boa Vista", "Sul", "12213640");
		Endereco rua2545 = new Endereco(null, "Rua Amâncio Bráulio de Melo", "Jardim Boa Vista", "Sul", "12213650");
		Endereco rua2546 = new Endereco(null, "Rua José Duarte Júnior", "Jardim Boa Vista", "Sul", "12213660");
		Endereco rua2547 = new Endereco(null, "Rua João Vilaça de Oliveira", "Jardim Boa Vista", "Sul", "12213670");
		Endereco rua2548 = new Endereco(null, "Rua Sebastião Alves de Almeida", "Jardim Boa Vista", "Sul", "12213680");
		Endereco rua2549 = new Endereco(null, "Largo da Boa Vista", "Jardim Boa Vista", "Sul", "12213690");
		Endereco rua2550 = new Endereco(null, "Rua Maria Fausta de Souza", "Jardim Boa Vista", "Sul", "12213700");
		Endereco rua2551 = new Endereco(null, "Rua José Vieira da Silva", "Jardim Boa Vista", "Sul", "12213710");
		Endereco rua2552 = new Endereco(null, "Rua João Pereira Costa", "Jardim Boa Vista", "Sul", "12213711");
		Endereco rua2553 = new Endereco(null, "Avenida João Pereira Costa", "Jardim Boa Vista", "Sul", "12213720");
		Endereco rua2554 = new Endereco(null, "Avenida Pico das Agulhas Negras", "Jardim Altos de Santana", "Sul",
				"12214000");
		Endereco rua2555 = new Endereco(null, "Rua Horto Florestal", "Jardim Altos de Santana", "Sul", "12214001");
		Endereco rua2556 = new Endereco(null, "Avenida Alto do Rio Doce", "Jardim Altos de Santana", "Sul", "12214010");
		Endereco rua2557 = new Endereco(null, "Rua Pico Cruzeiro", "Jardim Altos de Santana", "Sul", "12214020");
		Endereco rua2558 = new Endereco(null, "Rua Pico do Pulpito", "Jardim Altos de Santana", "Sul", "12214030");
		Endereco rua2559 = new Endereco(null, "Rua Pico Juliana", "Jardim Altos de Santana", "Sul", "12214040");
		Endereco rua2560 = new Endereco(null, "Rua Pico do Selado", "Jardim Altos de Santana", "Sul", "12214050");
		Endereco rua2561 = new Endereco(null, "Rua Serra da Ibitipoca", "Jardim Altos de Santana", "Sul", "12214060");
		Endereco rua2562 = new Endereco(null, "Rua Pedra Vermelha", "Jardim Altos de Santana", "Sul", "12214070");
		Endereco rua2563 = new Endereco(null, "Rua Pedra Redonda", "Jardim Altos de Santana", "Sul", "12214080");
		Endereco rua2564 = new Endereco(null, "Rua Monte Paschoal", "Jardim Altos de Santana", "Sul", "12214090");
		Endereco rua2565 = new Endereco(null, "Rua Monte das Oliveiras", "Jardim Altos de Santana", "Sul", "12214100");
		Endereco rua2566 = new Endereco(null, "Rua Monte Castelo", "Jardim Altos de Santana", "Sul", "12214110");
		Endereco rua2567 = new Endereco(null, "Rua Serra das Araras", "Jardim Altos de Santana", "Sul", "12214120");
		Endereco rua2568 = new Endereco(null, "Rua Serra Dourada", "Jardim Altos de Santana", "Sul", "12214130");
		Endereco rua2569 = new Endereco(null, "Rua Pico do Jaraguá", "Jardim Altos de Santana", "Sul", "12214140");
		Endereco rua2570 = new Endereco(null, "Rua Alto da Boa Vista", "Jardim Altos de Santana", "Sul", "12214150");
		Endereco rua2571 = new Endereco(null, "Rua Pico Marins", "Jardim Altos de Santana", "Sul", "12214160");
		Endereco rua2572 = new Endereco(null, "Rua Montanha Fuji", "Jardim Altos de Santana", "Sul", "12214170");
		Endereco rua2573 = new Endereco(null, "Rua Monte Sinai", "Jardim Altos de Santana", "Sul", "12214180");
		Endereco rua2574 = new Endereco(null, "Rua Pico dos Três Estados", "Jardim Altos de Santana", "Sul",
				"12214190");
		Endereco rua2575 = new Endereco(null, "Rua Pico do Bugil", "Jardim Altos de Santana", "Sul", "12214200");
		Endereco rua2576 = new Endereco(null, "Rua Pedra do Sino", "Jardim Altos de Santana", "Sul", "12214210");
		Endereco rua2577 = new Endereco(null, "Rua Serra de Santa Bárbara", "Jardim Altos de Santana", "Sul",
				"12214220");
		Endereco rua2578 = new Endereco(null, "Rua Monte Roraima", "Jardim Altos de Santana", "Sul", "12214230");
		Endereco rua2579 = new Endereco(null, "Rua Pico Cristal", "Jardim Altos de Santana", "Sul", "12214240");
		Endereco rua2580 = new Endereco(null, "Rua Pico da Neblina", "Jardim Altos de Santana", "Sul", "12214250");
		Endereco rua2581 = new Endereco(null, "Rua Pedra do Capim Azul", "Jardim Altos de Santana", "Sul", "12214260");
		Endereco rua2582 = new Endereco(null, "Rua Pico do Aconcagua", "Jardim Altos de Santana", "Sul", "12214270");
		Endereco rua2583 = new Endereco(null, "Rua Pedra Pouso do Rochedo", "Jardim Altos de Santana", "Sul",
				"12214280");
		Endereco rua2584 = new Endereco(null, "Rua Pico da Bandeira", "Jardim Altos de Santana", "Sul", "12214290");
		Endereco rua2585 = new Endereco(null, "Rua Serra da Canastra", "Jardim Altos de Santana", "Sul", "12214300");
		Endereco rua2586 = new Endereco(null, "Rua Vinte e Nove", "Jardim Altos de Santana", "Sul", "12214310");
		Endereco rua2587 = new Endereco(null, "Rua Serra de Jambeiro", "Jardim Altos de Santana", "Sul", "12214320");
		Endereco rua2588 = new Endereco(null, "Rua Alto do Araguaia", "Jardim Altos de Santana", "Sul", "12214330");
		Endereco rua2589 = new Endereco(null, "Rua Pico Itapevi", "Jardim Altos de Santana", "Sul", "12214340");
		Endereco rua2590 = new Endereco(null, "Rua Serra do Japi", "Jardim Altos de Santana", "Sul", "12214350");
		Endereco rua2591 = new Endereco(null, "Rua Monte Kilimanjaro", "Jardim Altos de Santana", "Sul", "12214370");
		Endereco rua2592 = new Endereco(null, "Rua Pedra do Baú", "Jardim Altos de Santana", "Sul", "12214380");
		Endereco rua2593 = new Endereco(null, "Rua Serra dos Carajás", "Jardim Altos de Santana", "Sul", "12214390");
		Endereco rua2594 = new Endereco(null, "Rua Pedra Alta", "Jardim Altos de Santana", "Sul", "12214391");
		Endereco rua2595 = new Endereco(null, "Rua Serra dos Aimorés", "Jardim Altos de Santana", "Sul", "12214400");
		Endereco rua2596 = new Endereco(null, "Rua Serra da Saudade", "Jardim Altos de Santana", "Sul", "12214410");
		Endereco rua2597 = new Endereco(null, "Rua Jaguari", " s/n", "Jardim Altos de Santana", "Sul");
		Endereco rua2598 = new Endereco(null, "Praça Capitão Pedro Pinto da Cunha", "Jardim Paulista", "Sul",
				"12215650");
		Endereco rua2599 = new Endereco(null, "Avenida Santos Dumont", "Jardim Paulista", "Sul", "12215651");
		Endereco rua2600 = new Endereco(null, "Avenida Nair Toledo de Mira", "Jardim Paulista", "Sul", "12215656");
		Endereco rua2601 = new Endereco(null, "Rua Tupã", "Jardim Paulista", "Sul", "12215660");
		Endereco rua2602 = new Endereco(null, "Rua Umuarama", "Jardim Paulista", "Sul", "12215730");
		Endereco rua2603 = new Endereco(null, "Travessa Pastor João Vera Pelegrino", "Jardim Paulista", "Sul",
				"12215740");
		Endereco rua2604 = new Endereco(null, "Rua Turmalina", "Jardim São José Centro", "Sul", "12215750");
		Endereco rua2605 = new Endereco(null, "Viaduto Bandeirante", "Jardim Paulista", "Sul", "12215760");
		Endereco rua2606 = new Endereco(null, "Rua Jaspe", "Jardim São José Centro", "Sul", "12215770");
		Endereco rua2607 = new Endereco(null, "Rua Cristal", "Jardim São José Centro", "Sul", "12215780");
		Endereco rua2608 = new Endereco(null, "Rua Sardonica", "Jardim São José Centro", "Sul", "12215790");
		Endereco rua2609 = new Endereco(null, "Rua Jade", "Jardim São José Centro", "Sul", "12215805");
		Endereco rua2610 = new Endereco(null, "Rua Granada", "Jardim São José Centro", "Sul", "12215810");
		Endereco rua2611 = new Endereco(null, "Rua Jacinto", "Jardim São José Centro", "Sul", "12215820");
		Endereco rua2612 = new Endereco(null, "Praça Platina", "Jardim São José Centro", "Sul", "12215830");
		Endereco rua2613 = new Endereco(null, "Rua Iara", "Jardim Paulista", "Sul", "12215840");
		Endereco rua2614 = new Endereco(null, "Avenida Deputado Benedito Matarazzo", " 9403", "Jardim Paulista", "Sul");
		Endereco rua2615 = new Endereco(null, "Avenida Pedro Álvares Cabral", "Jardim Paulista", "Sul", "12216000");
		Endereco rua2616 = new Endereco(null, "Rua Mem de Sá", "Jardim Paulista", "Sul", "12216001");
		Endereco rua2617 = new Endereco(null, "Rua José Diogo de Faria", "Jardim Paulista", "Sul", "12216002");
		Endereco rua2618 = new Endereco(null, "Praça Carlos Gomes", "Jardim Paulista", "Sul", "12216010");
		Endereco rua2619 = new Endereco(null, "Rua Castro Alves", "Jardim Paulista", "Sul", "12216020");
		Endereco rua2620 = new Endereco(null, "Rua Cristóvão Colombo", "Jardim Paulista", "Sul", "12216030");
		Endereco rua2621 = new Endereco(null, "Rua Riachuelo", "Jardim Paulista", "Sul", "12216040");
		Endereco rua2622 = new Endereco(null, "Praça Duque de Caxias", "Jardim Paulista", "Sul", "12216050");
		Endereco rua2623 = new Endereco(null, "Rua João Francisco de Paula", "Jardim Paulista", "Sul", "12216051");
		Endereco rua2624 = new Endereco(null, "Rua Antônio Costa Rosendo", "Jardim Paulista", "Sul", "12216060");
		Endereco rua2625 = new Endereco(null, "Rua Presidente Vargas", "Jardim Paulista", "Sul", "12216070");
		Endereco rua2626 = new Endereco(null, "Rua Ademar Guedes de Oliveira", "Jardim Paulista", "Sul", "12216080");
		Endereco rua2627 = new Endereco(null, "Travessa Luiz de Azevedo Castro", "Jardim Paulista", "Sul", "12216081");
		Endereco rua2628 = new Endereco(null, "Rua Dumitilde Marcondes", "Jardim Paulista", "Sul", "12216090");
		Endereco rua2629 = new Endereco(null, "Rua José Francisco Monteiro", "Jardim Paulista", "Sul", "12216100");
		Endereco rua2630 = new Endereco(null, "Rua Coronel Pacheco Neto", "Jardim Paulista", "Sul", "12216110");
		Endereco rua2631 = new Endereco(null, "Rua Capitão José Dellias", "Jardim Paulista", "Sul", "12216120");
		Endereco rua2632 = new Endereco(null, "Rua Presidente Bernardes", "Jardim Paulista", "Sul", "12216130");
		Endereco rua2633 = new Endereco(null, "Rua Alcindo de Marchi", "Jardim Paulista", "Sul", "12216131");
		Endereco rua2634 = new Endereco(null, "Rua Engenheiro Pedro Sinisgalli", "Jardim Paulista", "Sul", "12216140");
		Endereco rua2635 = new Endereco(null, "Rua Professora Maria Lima Cesar", "Jardim Paulista", "Sul", "12216141");
		Endereco rua2636 = new Endereco(null, "Rua Frankilina Monteiro de Oliveira", "Jardim Paulista", "Sul",
				"12216150");
		Endereco rua2637 = new Endereco(null, "Rua Frederico Miacci", "Jardim Paulista", "Sul", "12216160");
		Endereco rua2638 = new Endereco(null, "Rua Samuel Antônio Rodrigues", "Jardim Paulista", "Sul", "12216161");
		Endereco rua2639 = new Endereco(null, "Rua Leopoldo Drews", "Jardim Paulista", "Sul", "12216170");
		Endereco rua2640 = new Endereco(null, "Rua Cônego José Francisco Monteiro", "Jardim Paulista", "Sul",
				"12216180");
		Endereco rua2641 = new Endereco(null, "Rua Jordão Monteiro Ferreira", "Jardim Topázio", "Sul", "12216190");
		Endereco rua2642 = new Endereco(null, "Rua Lola Roberto Batista Rocco", "Jardim Paulista", "Sul", "12216191");
		Endereco rua2643 = new Endereco(null, "Praça das Nações Unidas", "Jardim Paulista", "Sul", "12216192");
		Endereco rua2644 = new Endereco(null, "Rua Caio Madureira", "Jardim Paulista", "Sul", "12216200");
		Endereco rua2645 = new Endereco(null, "Praça America Pinto de Andrade", "Jardim Paulista", "Sul", "12216210");
		Endereco rua2646 = new Endereco(null, "Rua Genesia Berardinelli Tarantino", "Jardim Paulista", "Sul",
				"12216220");
		Endereco rua2647 = new Endereco(null, "Rua Professor Alfredo Cesar", "Jardim Paulista", "Sul", "12216221");
		Endereco rua2648 = new Endereco(null, "Viaduto Raquel Marcondes", "Jardim Paulista", "Sul", "12216222");
		Endereco rua2649 = new Endereco(null, "Rua Antônio Porfírio da Silva", "Jardim Paulista", "Sul", "12216230");
		Endereco rua2650 = new Endereco(null, "Rua Tenente Aécio Lemes de Souza", "Jardim Paulista", "Sul", "12216240");
		Endereco rua2651 = new Endereco(null, "Rua Água Marinha", "Jardim São José Centro", "Sul", "12216250");
		Endereco rua2652 = new Endereco(null, "Rua Alabastro", "Jardim São José Centro", "Sul", "12216260");
		Endereco rua2653 = new Endereco(null, "Rua Ametista", "Jardim São José Centro", "Sul", "12216270");
		Endereco rua2654 = new Endereco(null, "Rua Topázio", "Jardim São José Centro", "Sul", "12216290");
		Endereco rua2655 = new Endereco(null, "Rua Opala", "Jardim São José Centro", "Sul", "12216300");
		Endereco rua2656 = new Endereco(null, "Rua Pérola", "Jardim São José Centro", "Sul", "12216310");
		Endereco rua2657 = new Endereco(null, "Rua Rubi", "Jardim São José Centro", "Sul", "12216320");
		Endereco rua2658 = new Endereco(null, "Rua Safira", "Jardim São José Centro", "Sul", "12216330");
		Endereco rua2659 = new Endereco(null, "Avenida Deputado Benedito Matarazzo", "Jardim Paulista", "Sul",
				"12216340");
		Endereco rua2660 = new Endereco(null, "Rua Turquesa", "Jardim São José Centro", "Sul", "12216350");
		Endereco rua2661 = new Endereco(null, "Rua Projetada", "Jardim Paulista", "Sul", "12216361");
		Endereco rua2662 = new Endereco(null, "Rua Projetada B", "Jardim Paulista", "Sul", "12216362");
		Endereco rua2663 = new Endereco(null, "Rodovia Presidente Dutra", "Jardim Paulista", "Sul", "12216430");
		Endereco rua2664 = new Endereco(null, "Rua Itororó", "Jardim Paulista", "Sul", "12216440");
		Endereco rua2665 = new Endereco(null, "Rua Dom Carmine Rocco", "Jardim Paulista", "Sul", "12216450");
		Endereco rua2666 = new Endereco(null, "Rua Jaraguá", "Jardim Topázio", "Sul", "12216460");
		Endereco rua2667 = new Endereco(null, "Praça Francisco Antônio dos Santos", "Jardim Topázio", "Sul",
				"12216465");
		Endereco rua2668 = new Endereco(null, "Rua Jussara", "Jardim Topázio", "Sul", "12216470");
		Endereco rua2669 = new Endereco(null, "Rua Jaguarete", "Jardim Topázio", "Sul", "12216480");
		Endereco rua2670 = new Endereco(null, "Rua Jaú", "Jardim Topázio", "Sul", "12216490");
		Endereco rua2671 = new Endereco(null, "Rua Roma", "Jardim Augusta", "Sul", "12216510");
		Endereco rua2672 = new Endereco(null, "Rua Siria", "Jardim Oswaldo Cruz", "Sul", "12216530");
		Endereco rua2673 = new Endereco(null, "Rua República do Iraque", "Jardim Oswaldo Cruz", "Sul", "12216540");
		Endereco rua2674 = new Endereco(null, "Rua Jordânia", "Jardim Oswaldo Cruz", "Sul", "12216550");
		Endereco rua2675 = new Endereco(null, "Rua Bélgica", "Jardim Oswaldo Cruz", "Sul", "12216560");
		Endereco rua2676 = new Endereco(null, "Rua Holanda", "Jardim Oswaldo Cruz", "Sul", "12216570");
		Endereco rua2677 = new Endereco(null, "Avenida Deputado Benedito Matarazzo", "Jardim Oswaldo Cruz", "Sul",
				"12216580");
		Endereco rua2678 = new Endereco(null, "Rua República do Líbano", "Jardim Oswaldo Cruz", "Sul", "12216590");
		Endereco rua2679 = new Endereco(null, "Praça República Arabe Unida", "Jardim Oswaldo Cruz", "Sul", "12216591");
		Endereco rua2680 = new Endereco(null, "Rua Iran", "Jardim Oswaldo Cruz", "Sul", "12216600");
		Endereco rua2681 = new Endereco(null, "Praça Arábia", "Jardim Augusta", "Sul", "12216610");
		Endereco rua2682 = new Endereco(null, "Rua República de Israel", "Jardim Oswaldo Cruz", "Sul", "12216620");
		Endereco rua2683 = new Endereco(null, "Rua Turquia", "Jardim Oswaldo Cruz", "Sul", "12216623");
		Endereco rua2684 = new Endereco(null, "Avenida Lisboa", "Jardim Augusta", "Sul", "12216630");
		Endereco rua2685 = new Endereco(null, "Praça Berlim", "Jardim Augusta", "Sul", "12216631");
		Endereco rua2686 = new Endereco(null, "Rua Haia", "Jardim Augusta", "Sul", "12216650");
		Endereco rua2687 = new Endereco(null, "Rua Copenhague", "Jardim Augusta", "Sul", "12216660");
		Endereco rua2688 = new Endereco(null, "Rua Budapest", "Jardim Augusta", "Sul", "12216670");
		Endereco rua2689 = new Endereco(null, "Rua Berna", "Jardim Augusta", "Sul", "12216680");
		Endereco rua2690 = new Endereco(null, "Rua Estocolmo", "Jardim Augusta", "Sul", "12216690");
		Endereco rua2691 = new Endereco(null, "Rua Moscou", "Jardim Oswaldo Cruz", "Sul", "12216700");
		Endereco rua2692 = new Endereco(null, "Avenida Samuel Wainer", "Jardim Augusta", "Sul", "12216710");
		Endereco rua2693 = new Endereco(null, "Rua Viena", "Jardim Oswaldo Cruz", "Sul", "12216720");
		Endereco rua2694 = new Endereco(null, "Rua Varsóvia", "Jardim Augusta", "Sul", "12216730");
		Endereco rua2695 = new Endereco(null, "Rua Bucareste", "Jardim Oswaldo Cruz", "Sul", "12216740");
		Endereco rua2696 = new Endereco(null, "Rua Madrid", "Jardim Augusta", "Sul", "12216750");
		Endereco rua2697 = new Endereco(null, "Praça Londres", "Jardim Augusta", "Sul", "12216760");
		Endereco rua2698 = new Endereco(null, "Rua Atenas", "Jardim Augusta", "Sul", "12216770");
		Endereco rua2699 = new Endereco(null, "Praça Paris", "Jardim Augusta", "Sul", "12216780");
		Endereco rua2700 = new Endereco(null, "Rua Riachuelo", " 57", "Jardim Paulista", "Sul");
		Endereco rua2701 = new Endereco(null, "Avenida Joaquim Ferreira Carpinteiro", "Jardim Ismênia", "Sul",
				"12220660");
		Endereco rua2702 = new Endereco(null, "Rua Sabara", "Jardim Ismênia", "Sul", "12220661");
		Endereco rua2703 = new Endereco(null, "Rua Ituiutaba", "Jardim Ismênia", "Sul", "12220662");
		Endereco rua2704 = new Endereco(null, "Rua Diamantina", "Jardim Ismênia", "Sul", "12220663");
		Endereco rua2705 = new Endereco(null, "Rua Araguari", "Jardim Ismênia", "Sul", "12220670");
		Endereco rua2706 = new Endereco(null, "Rua Abaeté", "Jardim Ismênia", "Sul", "12220680");
		Endereco rua2707 = new Endereco(null, "Rua Uberlândia", "Jardim Ismênia", "Sul", "12220690");
		Endereco rua2708 = new Endereco(null, "Rua Itacarambi", "Jardim Ismênia", "Sul", "12220700");
		Endereco rua2709 = new Endereco(null, "Rua Itanhandu", "Jardim Ismênia", "Sul", "12220710");
		Endereco rua2710 = new Endereco(null, "Rua Guaraciaba", "Jardim Ismênia", "Sul", "12220720");
		Endereco rua2711 = new Endereco(null, "Rua Pirapora", "Jardim Ismênia", "Sul", "12220730");
		Endereco rua2712 = new Endereco(null, "Avenida Uberaba", "Jardim Ismênia", "Sul", "12220740");
		Endereco rua2713 = new Endereco(null, "Rua Caparaó", "Jardim Ismênia", "Sul", "12220750");
		Endereco rua2714 = new Endereco(null, "Praça Caratinga", "Jardim Ismênia", "Sul", "12220760");
		Endereco rua2715 = new Endereco(null, "Rua Caxambu", "Jardim Ismênia", "Sul", "12220770");
		Endereco rua2716 = new Endereco(null, "Rua Baependi", "Jardim Ismênia", "Sul", "12220780");
		Endereco rua2717 = new Endereco(null, "Praça Ouro Preto", "Jardim Ismênia", "Sul", "12220790");
		Endereco rua2718 = new Endereco(null, "Rua Pedralva", "Jardim Ismênia", "Sul", "12220800");
		Endereco rua2719 = new Endereco(null, "Rua Guaxupé", "Jardim Ismênia", "Sul", "12220810");
		Endereco rua2720 = new Endereco(null, "Rua Itajubá", "Jardim Ismênia", "Sul", "12220820");
		Endereco rua2721 = new Endereco(null, "Rua Camanducaia", "Jardim Ismênia", "Sul", "12220830");
		Endereco rua2722 = new Endereco(null, "Rua Tebas", "Jardim Ismênia", "Sul", "12220831");
		Endereco rua2723 = new Endereco(null, "Avenida Servidão", "Jardim Ismênia", "Sul", "12220832");
		Endereco rua2724 = new Endereco(null, "Rua Sabara", " 30", "Jardim Ismênia", "Sul");
		Endereco rua2725 = new Endereco(null, "Avenida Barbacena", "Jardim Ismênia", "Sul", "12221000");
		Endereco rua2726 = new Endereco(null, "Rua João Quirino Pedrosa", "Jardim Ismênia", "Sul", "12221010");
		Endereco rua2727 = new Endereco(null, "Rua Rúbens Leitão Filho", "Jardim Ismênia", "Sul", "12221020");
		Endereco rua2728 = new Endereco(null, "Rua Abílio Pereira Dias", "Jardim Ismênia", "Sul", "12221030");
		Endereco rua2729 = new Endereco(null, "Rua Elza Regina Ferreira Bevilacqua", "Jardim Ismênia", "Sul",
				"12221040");
		Endereco rua2730 = new Endereco(null, "Rua Herondina de Almeida Alvarenga", "Jardim Ismênia", "Sul",
				"12221050");
		Endereco rua2731 = new Endereco(null, "Rua José Domingues dos Santos", "Jardim Ismênia", "Sul", "12221060");
		Endereco rua2732 = new Endereco(null, "Rua Hélio de Almeida Ferreira", "Jardim Ismênia", "Sul", "12221070");
		Endereco rua2733 = new Endereco(null, "Rua José Ferreira de Almeida", "Jardim Ismênia", "Sul", "12221080");
		Endereco rua2734 = new Endereco(null, "Rua Manacá", "Jardim Ismênia", "Sul", "12221090");
		Endereco rua2735 = new Endereco(null, "Rua Alteia", "Jardim Ismênia", "Sul", "12221100");
		Endereco rua2736 = new Endereco(null, "Rua Jabota", "Jardim Ismênia", "Sul", "12221110");
		Endereco rua2737 = new Endereco(null, "Rua Anis", "Jardim Ismênia", "Sul", "12221120");
		Endereco rua2738 = new Endereco(null, "Rua Gameleiras", "Jardim Ismênia", "Sul", "12221130");
		Endereco rua2739 = new Endereco(null, "Rua Perpetua", "Jardim Ismênia", "Sul", "12221140");
		Endereco rua2740 = new Endereco(null, "Praça Tatuaba", "Jardim Ismênia", "Sul", "12221141");
		Endereco rua2741 = new Endereco(null, "Praça Cambará", "Jardim Ismênia", "Sul", "12221142");
		Endereco rua2742 = new Endereco(null, "Rua Bento Pinto da Cunha", "Jardim Ismênia", "Sul", "12221143");
		Endereco rua2743 = new Endereco(null, "Rua Charles Diamond", "Jardim Copacabana", "Sul", "12221150");
		Endereco rua2744 = new Endereco(null, "Rua Vicente Mota Corrêa", "Jardim São Jorge", "Sul", "12221160");
		Endereco rua2745 = new Endereco(null, "Rua Benedito Pacheco Salgado", "Jardim São Jorge", "Sul", "12221170");
		Endereco rua2746 = new Endereco(null, "Rua Eurípedes Mascarenhas", "Jardim São Jorge", "Sul", "12221180");
		Endereco rua2747 = new Endereco(null, "Rua Cristóvão de Alencar", "Jardim São Jorge", "Sul", "12221190");
		Endereco rua2748 = new Endereco(null, "Praça das Árvores", "Jardim São Jorge", "Sul", "12221195");
		Endereco rua2749 = new Endereco(null, "Rua Milton Cruz", "Jardim São Jorge", "Sul", "12221200");
		Endereco rua2750 = new Endereco(null, "Rua João Lindemberg", "Jardim Copacabana", "Sul", "12221220");
		Endereco rua2751 = new Endereco(null, "Praça Joaquim Figueira de Andrade", "Jardim Copacabana", "Sul",
				"12221221");
		Endereco rua2752 = new Endereco(null, "Rua Newton Ferreira Ivo", "Jardim Copacabana", "Sul", "12221230");
		Endereco rua2753 = new Endereco(null, "Rua Sidney Antônio Moreira da Silva", "Jardim Copacabana", "Sul",
				"12221240");
		Endereco rua2754 = new Endereco(null, "Rua Adelino Mendonça", "Jardim Olímpia", "Sul", "12221250");
		Endereco rua2755 = new Endereco(null, "Rua Messias Palmeira", "Jardim Brasília", "Sul", "12221260");
		Endereco rua2756 = new Endereco(null, "Praça Natanael Mariano da Silva", "Jardim Olímpia", "Sul", "12221261");
		Endereco rua2757 = new Endereco(null, "Rua Brinda Guida Filho", "Jardim Olímpia", "Sul", "12221270");
		Endereco rua2758 = new Endereco(null, "Rua Nazareth de Moura Veronese", "Jardim Olímpia", "Sul", "12221280");
		Endereco rua2759 = new Endereco(null, "Rua Mamede Firmino de Morais", "Jardim Olímpia", "Sul", "12221290");
		Endereco rua2760 = new Endereco(null, "Rua das Enfermeiras", "Jardim Valparaíba", "Sul", "12221300");
		Endereco rua2761 = new Endereco(null, "Rua dos Economistas", "Jardim Valparaíba", "Sul", "12221310");
		Endereco rua2762 = new Endereco(null, "Rua dos Cientistas", "Jardim Valparaíba", "Sul", "12221320");
		Endereco rua2763 = new Endereco(null, "Rua das Telefonistas", "Jardim Valparaíba", "Sul", "12221330");
		Endereco rua2764 = new Endereco(null, "Praça dos Jornalistas", "Jardim Valparaíba", "Sul", "12221331");
		Endereco rua2765 = new Endereco(null, "Rua dos Marceneiros", "Jardim Valparaíba", "Sul", "12221340");
		Endereco rua2766 = new Endereco(null, "Rua dos Motoristas", "Jardim Valparaíba", "Sul", "12221350");
		Endereco rua2767 = new Endereco(null, "Rua dos Tecelões", "Jardim Valparaíba", "Sul", "12221360");
		Endereco rua2768 = new Endereco(null, "Rua dos Estudantes", "Jardim Valparaíba", "Sul", "12221370");
		Endereco rua2769 = new Endereco(null, "Praça dos Musicos", "Jardim Valparaíba", "Sul", "12221371");
		Endereco rua2770 = new Endereco(null, "Rua dos Metalurgicos", "Jardim Valparaíba", "Sul", "12221380");
		Endereco rua2771 = new Endereco(null, "Rua dos Bancários", "Jardim Valparaíba", "Sul", "12221390");
		Endereco rua2772 = new Endereco(null, "Rua das Secretarias", "Jardim Valparaíba", "Sul", "12221400");
		Endereco rua2773 = new Endereco(null, "Rua dos Gráficos", "Jardim Valparaíba", "Sul", "12221401");
		Endereco rua2774 = new Endereco(null, "Rua dos Aviadores", "Jardim Valparaíba", "Sul", "12221410");
		Endereco rua2775 = new Endereco(null, "Rua Afonso Galvão", "Jardim São Jorge", "Sul", "12221500");
		Endereco rua2776 = new Endereco(null, "Rua Tesouro", "Jardim São Jorge", "Sul", "12221501");
		Endereco rua2777 = new Endereco(null, "Rua Mário Cesare Porto", "Jardim Maracanã", "Sul", "12221510");
		Endereco rua2778 = new Endereco(null, "Rua Projetada", "Jardim Maracanã", "Sul", "12221511");
		Endereco rua2779 = new Endereco(null, "Rua Messias Palmeira", "Jardim Maracanã", "Sul", "12221512");
		Endereco rua2780 = new Endereco(null, "Rua dos Engenheiros", "Jardim Valparaíba", "Sul", "12221780");
		Endereco rua2781 = new Endereco(null, "Rua dos Medicos", "Jardim Valparaíba", "Sul", "12221790");
		Endereco rua2782 = new Endereco(null, "Rua dos Radialistas", "Jardim Valparaíba", "Sul", "12221800");
		Endereco rua2783 = new Endereco(null, "Rua dos Advogados", "Jardim Valparaíba", "Sul", "12221810");
		Endereco rua2784 = new Endereco(null, "Praça dos Professores", "Jardim Valparaíba", "Sul", "12221820");
		Endereco rua2785 = new Endereco(null, "Avenida dos Operarios", "Jardim Valparaíba", "Sul", "12221830");
		Endereco rua2786 = new Endereco(null, "Rua dos Comerciantes", "Jardim Valparaíba", "Sul", "12221840");
		Endereco rua2787 = new Endereco(null, "Rua Noêmio Arruda de Carvalho", "Jardim Diamante", "Sul", "12223110");
		Endereco rua2788 = new Endereco(null, "Rua Plínio de Andrade", "Jardim Diamante", "Sul", "12223120");
		Endereco rua2789 = new Endereco(null, "Rua José Cândido de Melo", "Jardim Diamante", "Sul", "12223130");
		Endereco rua2790 = new Endereco(null, "Rua Gregório Gurevich", "Jardim Diamante", "Sul", "12223140");
		Endereco rua2791 = new Endereco(null, "Rua José Locatelli", "Jardim Diamante", "Sul", "12223150");
		Endereco rua2792 = new Endereco(null, "Rua Coronel Eurico Costa Souza", "Jardim Diamante", "Sul", "12223160");
		Endereco rua2793 = new Endereco(null, "Praça João Batista Peneluppi", "Jardim Diamante", "Sul", "12223170");
		Endereco rua2794 = new Endereco(null, "Rua Professora Ana Isabel Barbosa", "Jardim Diamante", "Sul",
				"12223180");
		Endereco rua2795 = new Endereco(null, "Rua Francisco Camilo", "Jardim Diamante", "Sul", "12223190");
		Endereco rua2796 = new Endereco(null, "Rua Benedito Rodrigues da Silva", "Jardim Diamante", "Sul", "12223200");
		Endereco rua2797 = new Endereco(null, "Rodovia Presidente Dutra", "Jardim Diamante", "Sul", "12223201");
		Endereco rua2798 = new Endereco(null, "Rua Rosa Coulicoff Diamante", "Jardim Diamante", "Sul", "12223210");
		Endereco rua2799 = new Endereco(null, "Rua Moisés Kremer", "Jardim Diamante", "Sul", "12223211");
		Endereco rua2800 = new Endereco(null, "Rodovia Presidente Dutra", " km 143", "Jardim Motorama", "Sul");
		Endereco rua2801 = new Endereco(null, "Avenida das Rosas", "Jardim Motorama", "Sul", "12224000");
		Endereco rua2802 = new Endereco(null, "Avenida Segundo-Sargento Clarismundo da Silva", "Jardim Motorama", "Sul",
				"12224001");
		Endereco rua2803 = new Endereco(null, "Rua dos Lírios", "Jardim Motorama", "Sul", "12224010");
		Endereco rua2804 = new Endereco(null, "Praça Benedito Antônio de Oliveira", "Jardim Motorama", "Sul",
				"12224011");
		Endereco rua2805 = new Endereco(null, "Rua Projetada", "Jardim Motorama", "Sul", "12224012");
		Endereco rua2806 = new Endereco(null, "Rua das Maravilhas", "Jardim Motorama", "Sul", "12224020");
		Endereco rua2807 = new Endereco(null, "Rua das Papoulas", "Jardim Motorama", "Sul", "12224030");
		Endereco rua2808 = new Endereco(null, "Rua das Sensitivas", "Jardim Motorama", "Sul", "12224040");
		Endereco rua2809 = new Endereco(null, "Rua dos Trevos", "Jardim Motorama", "Sul", "12224050");
		Endereco rua2810 = new Endereco(null, "Rua das Azaléas", "Jardim Motorama", "Sul", "12224060");
		Endereco rua2811 = new Endereco(null, "Rua dos Ciclames", "Jardim Motorama", "Sul", "12224070");
		Endereco rua2812 = new Endereco(null, "Rua das Dâlias", "Jardim Motorama", "Sul", "12224080");
		Endereco rua2813 = new Endereco(null, "Rua das Margaridas", "Jardim Motorama", "Sul", "12224090");
		Endereco rua2814 = new Endereco(null, "Rua dos Miosótis", "Jardim Motorama", "Sul", "12224100");
		Endereco rua2815 = new Endereco(null, "Rua das Peonias", "Jardim Motorama", "Sul", "12224110");
		Endereco rua2816 = new Endereco(null, "Avenida Camerino Pereira dos Santos", "Jardim Motorama", "Sul",
				"12224120");
		Endereco rua2817 = new Endereco(null, "Rua das Orquídeas", "Jardim Motorama", "Sul", "12224130");
		Endereco rua2818 = new Endereco(null, "Rua das Verbenas", "Jardim Motorama", "Sul", "12224140");
		Endereco rua2819 = new Endereco(null, "Travessa Gabriel Alves Freire", "Jardim Motorama", "Sul", "12224150");
		Endereco rua2820 = new Endereco(null, "Rua das Violetas", "Jardim Motorama", "Sul", "12224160");
		Endereco rua2821 = new Endereco(null, "Rua das Glicínias", "Jardim Motorama", "Sul", "12224170");
		Endereco rua2822 = new Endereco(null, "Avenida Vitória Régia", "Jardim Motorama", "Sul", "12224180");
		Endereco rua2823 = new Endereco(null, "Rua das Cravinas", "Jardim Motorama", "Sul", "12224190");
		Endereco rua2824 = new Endereco(null, "Rua das Hortencias", "Jardim Motorama", "Sul", "12224200");
		Endereco rua2825 = new Endereco(null, "Rua dos Heliotrópios", "Jardim Motorama", "Sul", "12224210");
		Endereco rua2826 = new Endereco(null, "Rua dos Jasmins", "Jardim Motorama", "Sul", "12224220");
		Endereco rua2827 = new Endereco(null, "Rua das Gardenias", "Jardim Motorama", "Sul", "12224230");
		Endereco rua2828 = new Endereco(null, "Rua das Petúnias", "Jardim Motorama", "Sul", "12224240");
		Endereco rua2829 = new Endereco(null, "Praça Virginio Valias de Resende", "Jardim Motorama", "Sul", "12224245");
		Endereco rua2830 = new Endereco(null, "Rua dos Gerânios", "Jardim Motorama", "Sul", "12224250");
		Endereco rua2831 = new Endereco(null, "Rua das Angelicas", "Jardim Motorama", "Sul", "12224260");
		Endereco rua2832 = new Endereco(null, "Avenida dos Narcisos", "Jardim Motorama", "Sul", "12224270");
		Endereco rua2833 = new Endereco(null, "Praça Primavera", "Jardim Motorama", "Sul", "12224280");
		Endereco rua2834 = new Endereco(null, "Avenida das Tulipas", "Jardim Motorama", "Sul", "12224290");
		Endereco rua2835 = new Endereco(null, "Rodovia Presidente Dutra", "Jardim Motorama", "Sul", "12224300");
		Endereco rua2836 = new Endereco(null, "Avenida Ilidio Meinberg Porto", "Jardim São Vicente", "Sul", "12224310");
		Endereco rua2837 = new Endereco(null, "Rua Pedro Daniel", "Jardim São Vicente", "Sul", "12224320");
		Endereco rua2838 = new Endereco(null, "Rua Erotides Teixeira de Souza", "Jardim São Vicente", "Sul",
				"12224330");
		Endereco rua2839 = new Endereco(null, "Rua José Benedito Calil", "Jardim São Vicente", "Sul", "12224340");
		Endereco rua2840 = new Endereco(null, "Avenida José Francisco Marcondes", "Jardim São Vicente", "Sul",
				"12224350");
		Endereco rua2841 = new Endereco(null, "Rua Judite Machado Cursino", "Jardim São Vicente", "Sul", "12224360");
		Endereco rua2842 = new Endereco(null, "Avenida José Pedro", "Jardim São Vicente", "Sul", "12224370");
		Endereco rua2843 = new Endereco(null, "Avenida Carmelina Alves dos Santos", "Jardim São Vicente", "Sul",
				"12224380");
		Endereco rua2844 = new Endereco(null, "Rua Doutor João Tranchesi", "Jardim São Vicente", "Sul", "12224390");
		Endereco rua2845 = new Endereco(null, "Avenida Professor Possidonio Salles", "Jardim São Vicente", "Sul",
				"12224400");
		Endereco rua2846 = new Endereco(null, "Rua Doutor Cláudio Martins Miranda Chaves", "Jardim São Vicente", "Sul",
				"12224410");
		Endereco rua2847 = new Endereco(null, "Rua Edward Wilson Kimbask", "Jardim São Vicente", "Sul", "12224420");
		Endereco rua2848 = new Endereco(null, "Rua Elídio Memberg Porto", "Jardim São Vicente", "Sul", "12224421");
		Endereco rua2849 = new Endereco(null, "Rua Esmeraldo Baptista Santana", "Jardim São Vicente", "Sul",
				"12224430");
		Endereco rua2850 = new Endereco(null, "Rua Nalva Paiva da Mata", "Jardim São Vicente", "Sul", "12224440");
		Endereco rua2851 = new Endereco(null, "Avenida Ruth Merrik Kimbask", "Jardim São Vicente", "Sul", "12224450");
		Endereco rua2852 = new Endereco(null, "Rua Mohabe Anisse Cury", "Jardim São Vicente", "Sul", "12224460");
		Endereco rua2853 = new Endereco(null, "Rua Professora Otavia Raimundo da Silva", "Jardim São Vicente", "Sul",
				"12224470");
		Endereco rua2854 = new Endereco(null, "Avenida Benedito Friggi", "Jardim Nova Detroit", "Sul", "12224480");
		Endereco rua2855 = new Endereco(null, "Rua Júlio Ferreira dos Santos", "Jardim Nova Detroit", "Sul",
				"12224490");
		Endereco rua2856 = new Endereco(null, "Rua Doutor Max Michaelis", "Jardim Nova Detroit", "Sul", "12224500");
		Endereco rua2857 = new Endereco(null, "Rua Antero Cursino dos Santos", "Jardim Nova Detroit", "Sul",
				"12224510");
		Endereco rua2858 = new Endereco(null, "Rua Ângelo Pintus", "Jardim Nova Detroit", "Sul", "12224520");
		Endereco rua2859 = new Endereco(null, "Rua Jorge Pereira de Melo", "Jardim Nova Detroit", "Sul", "12224530");
		Endereco rua2860 = new Endereco(null, "Rua Mathilde Neme Bagdad", "Jardim Nova Detroit", "Sul", "12224540");
		Endereco rua2861 = new Endereco(null, "Rua Cândido Barbosa", "Jardim Nova Detroit", "Sul", "12224550");
		Endereco rua2862 = new Endereco(null, "Avenida Brás Domingos de Arantes", "Jardim Nova Detroit", "Sul",
				"12224555");
		Endereco rua2863 = new Endereco(null, "Rua Procópio Ferreira", "Jardim Nova Detroit", "Sul", "12224570");
		Endereco rua2864 = new Endereco(null, "Rua Orlando Silva", "Jardim Nova Detroit", "Sul", "12224580");
		Endereco rua2865 = new Endereco(null, "Rua Luiz Monteiro", "Jardim Nova Detroit", "Sul", "12224590");
		Endereco rua2866 = new Endereco(null, "Rua Izaltino Silva", "Jardim Nova Detroit", "Sul", "12224600");
		Endereco rua2867 = new Endereco(null, "Rua Alcidia Medeiros Ragazzini", "Jardim Nova Detroit", "Sul",
				"12224610");
		Endereco rua2868 = new Endereco(null, "Rua Pedro Venuto Ragazini", "Jardim Nova Detroit", "Sul", "12224620");
		Endereco rua2869 = new Endereco(null, "Rua Inesia Pinheiro Soares", "Jardim Nova Detroit", "Sul", "12224630");
		Endereco rua2870 = new Endereco(null, "Rua André Lourenço Loubet", "Jardim Nova Detroit", "Sul", "12224640");
		Endereco rua2871 = new Endereco(null, "Rua Segundo-Sargento Clarismundo Silva", "Jardim Nova Detroit", "Sul",
				"12224650");
		Endereco rua2872 = new Endereco(null, "Rua Benedito Gomes dos Santos", "Jardim Nova Detroit", "Sul",
				"12224660");
		Endereco rua2873 = new Endereco(null, "Rua Alexandrina Maria da Conceição", "Jardim Nova Detroit", "Sul",
				"12224670");
		Endereco rua2874 = new Endereco(null, "Rua Anésio Rodrigues Araújo", "Jardim Nova Detroit", "Sul", "12224680");
		Endereco rua2875 = new Endereco(null, "Rua Doutor Waldomiro Martins Pinheiro", "Jardim Nova Detroit", "Sul",
				"12224690");
		Endereco rua2876 = new Endereco(null, "Rua Maria Salena de Assis", "Jardim Nova Detroit", "Sul", "12224700");
		Endereco rua2877 = new Endereco(null, "Rua Dezesseis", "Jardim Nova Detroit", "Sul", "12224701");
		Endereco rua2878 = new Endereco(null, "Avenida João Pedro", "Jardim Nova Detroit", "Sul", "12224702");
		Endereco rua2879 = new Endereco(null, "Rua Rio Guaiba", "Jardim Pararangaba", "Sul", "12224710");
		Endereco rua2880 = new Endereco(null, "Rua Rio Una", "Jardim Pararangaba", "Sul", "12224720");
		Endereco rua2881 = new Endereco(null, "Rua Rio São Francisco", "Jardim Pararangaba", "Sul", "12224730");
		Endereco rua2882 = new Endereco(null, "Rua Rio Paraíba do Sul", "Jardim Pararangaba", "Sul", "12224740");
		Endereco rua2883 = new Endereco(null, "Rua Rio Trombetas", "Jardim Pararangaba", "Sul", "12224750");
		Endereco rua2884 = new Endereco(null, "Rua Rio Tietê", "Jardim Pararangaba", "Sul", "12224760");
		Endereco rua2885 = new Endereco(null, "Rua Rio Jurubatuba", "Jardim Pararangaba", "Sul", "12224770");
		Endereco rua2886 = new Endereco(null, "Avenida Sansão Peres de Andrade", "Jardim Pararangaba", "Sul",
				"12224775");
		Endereco rua2887 = new Endereco(null, "Avenida Rio Madeira", "Jardim Pararangaba", "Sul", "12224780");
		Endereco rua2888 = new Endereco(null, "Rua Anna Rosa de Moraes", "Jardim Pararangaba", "Sul", "12224781");
		Endereco rua2889 = new Endereco(null, "Rua José Pardo", "Jardim Pararangaba", "Sul", "12224783");
		Endereco rua2890 = new Endereco(null, "Rua Maria Aparecida do Carmo Silva", "Jardim Pararangaba", "Sul",
				"12224784");
		Endereco rua2891 = new Endereco(null, "Rua Milton Rodrigues", "Jardim Pararangaba", "Sul", "12224785");
		Endereco rua2892 = new Endereco(null, "Rua Benedita Alves de Carvalho", "Jardim Pararangaba", "Sul",
				"12224786");
		Endereco rua2893 = new Endereco(null, "Rua Angelina Borgo Gregório", "Jardim Pararangaba", "Sul", "12224788");
		Endereco rua2894 = new Endereco(null, "Rua Sebastião Messias da Silva", "Jardim Pararangaba", "Sul",
				"12224789");
		Endereco rua2895 = new Endereco(null, "Avenida Pararangaba", "Jardim Pararangaba", "Sul", "12224790");
		Endereco rua2896 = new Endereco(null, "Rua Elton Sebastião da Silva", "Jardim Pararangaba", "Sul", "12224791");
		Endereco rua2897 = new Endereco(null, "Rua Enéas Silva Machado", "Jardim Pararangaba", "Sul", "12224792");
		Endereco rua2898 = new Endereco(null, "Rua Marcílio Benedito Costa", "Jardim Pararangaba", "Sul", "12224793");
		Endereco rua2899 = new Endereco(null, "Rua José Barreto Silva", "Jardim Pararangaba", "Sul", "12224794");
		Endereco rua2900 = new Endereco(null, "Rua Francisco de Melo", "Jardim Santa Inês II", "Sul", "12224795");
		Endereco rua2901 = new Endereco(null, "Rua Rio Canindé", "Jardim Santa Inês II", "Sul", "12224797");
		Endereco rua2902 = new Endereco(null, "Rua José Pires de Camargo", "Jardim Santa Inês II", "Sul", "12224798");
		Endereco rua2903 = new Endereco(null, "Rua Jorge Pires de Camargo", "Jardim Pararangaba", "Sul", "12224799");
		Endereco rua2904 = new Endereco(null, "Rua Rio Paru", "Jardim Pararangaba", "Sul", "12224800");
		Endereco rua2905 = new Endereco(null, "Rua Rio Tibagi", "Jardim Pararangaba", "Sul", "12224801");
		Endereco rua2906 = new Endereco(null, "Rua Rio Natuba", "Jardim Pararangaba", "Sul", "12224810");
		Endereco rua2907 = new Endereco(null, "Praça Natália Martins dos Santos", "Jardim Rodolfo", "Sul", "12224830");
		Endereco rua2908 = new Endereco(null, "Rua Amado Ribeiro de Miranda", "Jardim Rodolfo", "Sul", "12224832");
		Endereco rua2909 = new Endereco(null, "Rua Otacílio Alves Caldeira", "Jardim Rodolfo", "Sul", "12224834");
		Endereco rua2910 = new Endereco(null, "Rua João de Deus Santos", "Jardim Rodolfo", "Sul", "12224836");
		Endereco rua2911 = new Endereco(null, "Rua Rodolfo Scarpa", "Jardim Rodolfo", "Sul", "12224838");
		Endereco rua2912 = new Endereco(null, "Rua Joice Nazaré Calixto", "Jardim Rodolfo", "Sul", "12224840");
		Endereco rua2913 = new Endereco(null, "Rua Carolina Silva Dias", "Jardim Rodolfo", "Sul", "12224842");
		Endereco rua2914 = new Endereco(null, "Rua Iracema", "Jardim Três José", "Sul", "12225010");
		Endereco rua2915 = new Endereco(null, "Avenida Presidente Tancredo Neves", "Jardim Americano", "Sul",
				"12225011");
		Endereco rua2916 = new Endereco(null, "Rua Iraci", "Jardim Três José", "Sul", "12225020");
		Endereco rua2917 = new Endereco(null, "Rua João Rodolfo Castelli", "Jardim Três José", "Sul", "12225030");
		Endereco rua2918 = new Endereco(null, "Rua Otávio Moraes Lopes", "Jardim Americano", "Sul", "12225040");
		Endereco rua2919 = new Endereco(null, "Praça José Carlos Pace", "Jardim Americano", "Sul", "12225050");
		Endereco rua2920 = new Endereco(null, "Avenida Monsenhor Dutra", "Jardim Nova Flórida", "Sul", "12225055");
		Endereco rua2921 = new Endereco(null, "Rua José Duarte Simões", "Jardim Americano", "Sul", "12225060");
		Endereco rua2922 = new Endereco(null, "Rua Cirilo Pereira da Silva", "Jardim Nova Flórida", "Sul", "12225065");
		Endereco rua2923 = new Endereco(null, "Rua Benedito Eras", "Jardim Americano", "Sul", "12225070");
		Endereco rua2924 = new Endereco(null, "Rua Jorge Leite da Silva", "Jardim Nova Flórida", "Sul", "12225075");
		Endereco rua2925 = new Endereco(null, "Rua Frei Bertholdo Vah Der Mee", "Jardim Americano", "Sul", "12225080");
		Endereco rua2926 = new Endereco(null, "Rua Francisca Paula de Jesus Izabel", "Jardim Nova Flórida", "Sul",
				"12225085");
		Endereco rua2927 = new Endereco(null, "Rua Julia Cursino", "Jardim Americano", "Sul", "12225090");
		Endereco rua2928 = new Endereco(null, "Rua Elio Corazza Júnior", "Jardim Nova Flórida", "Sul", "12225095");
		Endereco rua2929 = new Endereco(null, "Rua Francisco Miele", "Jardim Nova Flórida", "Sul", "12225096");
		Endereco rua2930 = new Endereco(null, "Rua Carmem Franklin", "Jardim Nova Flórida", "Sul", "12225097");
		Endereco rua2931 = new Endereco(null, "Rua Maria Carolina de Jesus", "Jardim Americano", "Sul", "12225100");
		Endereco rua2932 = new Endereco(null, "Rua Padre Joaquim Franca", "Jardim Americano", "Sul", "12225110");
		Endereco rua2933 = new Endereco(null, "Rua João Di Mônaco", "Jardim Paraíso do Sol", "Sul", "12225120");
		Endereco rua2934 = new Endereco(null, "Avenida Jupira do Amaral Rangel", "Jardim Paraíso do Sol", "Sul",
				"12225130");
		Endereco rua2935 = new Endereco(null, "Rua Aldo Madureira", "Jardim Paraíso do Sol", "Sul", "12225140");
		Endereco rua2936 = new Endereco(null, "Rua Vantuilde José Brandão", "Jardim Paraíso do Sol", "Sul", "12225150");
		Endereco rua2937 = new Endereco(null, "Rua Padre José Maria da Silva Ramos", "Jardim Paraíso do Sol", "Sul",
				"12225160");
		Endereco rua2938 = new Endereco(null, "Rua Engenheiro Flávio Marcondes", "Jardim Santa Maria II", "Sul",
				"12225161");
		Endereco rua2939 = new Endereco(null, "Rua Doutor João Gomes Batista Neto", "Jardim Paraíso do Sol", "Sul",
				"12225170");
		Endereco rua2940 = new Endereco(null, "Rua Engenheiro Flávio Marcondes", "Jardim Santa Maria", "Sul",
				"12225171");
		Endereco rua2941 = new Endereco(null, "Rua Raimundo Monte Regis", "Jardim Santa Maria", "Sul", "12225172");
		Endereco rua2942 = new Endereco(null, "Rua Nelson Alves de Oliveira", "Jardim Paraíso do Sol", "Sul",
				"12225180");
		Endereco rua2943 = new Endereco(null, "Rua Pastor Jair Alves da Costa", "Jardim Paraíso do Sol", "Sul",
				"12225190");
		Endereco rua2944 = new Endereco(null, "Rua Mantura Neme", "Jardim Paraíso do Sol", "Sul", "12225200");
		Endereco rua2945 = new Endereco(null, "Rua Guedes Diamante", "Jardim Paraíso do Sol", "Sul", "12225210");
		Endereco rua2946 = new Endereco(null, "Avenida Presidente Tancredo Neves", "Jardim Paraíso do Sol", "Sul",
				"12225211");
		Endereco rua2947 = new Endereco(null, "Rua Benedicto Albino Tomaz", "Jardim Paraíso do Sol", "Sul", "12225212");
		Endereco rua2948 = new Endereco(null, "Rua Rita Teixeira Leite", "Jardim Paraíso do Sol", "Sul", "12225220");
		Endereco rua2949 = new Endereco(null, "Rua Paulo Salem", "Jardim Paraíso do Sol", "Sul", "12225230");
		Endereco rua2950 = new Endereco(null, "Avenida Maria Adolfina de Almeida Tomaz", "Jardim Paraíso do Sol", "Sul",
				"12225240");
		Endereco rua2951 = new Endereco(null, "Rua Professor Luiz Antônio Ribeiro de Macedo", "Jardim Paraíso do Sol",
				"Sul", "12225250");
		Endereco rua2952 = new Endereco(null, "Avenida Josefina Pozzi Bondesan", "Jardim Castanheira", "Sul",
				"12225270");
		Endereco rua2953 = new Endereco(null, "Rua José Donizetti dos Santos", "Jardim Santa Maria IV", "Sul",
				"12225271");
		Endereco rua2954 = new Endereco(null, "Rua Joaquim Vieira", "Jardim Castanheira", "Sul", "12225280");
		Endereco rua2955 = new Endereco(null, "Rua Aníbal Ferri", "Jardim Castanheira", "Sul", "12225290");
		Endereco rua2956 = new Endereco(null, "Rua Anita Ferreira Lazarini", "Jardim Castanheira", "Sul", "12225291");
		Endereco rua2957 = new Endereco(null, "Rua Fritz Gerber", "Jardim Castanheira", "Sul", "12225300");
		Endereco rua2958 = new Endereco(null, "Rua João Ávila", "Jardim Castanheira", "Sul", "12225310");
		Endereco rua2959 = new Endereco(null, "Rua Maria Montezi Santana", "Jardim Castanheira", "Sul", "12225320");
		Endereco rua2960 = new Endereco(null, "Rua Mansueto Brandi", "Jardim Castanheira", "Sul", "12225330");
		Endereco rua2961 = new Endereco(null, "Rua Miguel Neme", "Jardim Castanheira", "Sul", "12225340");
		Endereco rua2962 = new Endereco(null, "Avenida João Bassi", "Jardim Castanheira", "Sul", "12225350");
		Endereco rua2963 = new Endereco(null, "Rua Thesis Gaia", "Jardim Castanheira", "Sul", "12225360");
		Endereco rua2964 = new Endereco(null, "Avenida Joaquim Bernardes Neto", "Jardim Castanheira", "Sul",
				"12225370");
		Endereco rua2965 = new Endereco(null, "Travessa Um A", "Jardim Santa Maria", "Sul", "12225371");
		Endereco rua2966 = new Endereco(null, "Travessa Dois", "Jardim Santa Maria", "Sul", "12225372");
		Endereco rua2967 = new Endereco(null, "Travessa Três", "Jardim Santa Maria", "Sul", "12225373");
		Endereco rua2968 = new Endereco(null, "Rua Celso Gomes Negrão", "Jardim Santa Maria III", "Sul", "12225374");
		Endereco rua2969 = new Endereco(null, "Rua Engenheiro Flávio Marcondes", "Jardim Santa Maria III", "Sul",
				"12225375");
		Endereco rua2970 = new Endereco(null, "Estrada para Piedade", "Jardim Paraíso do Sol", "Sul", "12225390");
		Endereco rua2971 = new Endereco(null, "Rua Santa Maria", "Jardim Santa Maria", "Sul", "12225391");
		Endereco rua2972 = new Endereco(null, "Rua Alisson Geraldo da Silva Vitor", "Jardim Santa Maria", "Sul",
				"12225392");
		Endereco rua2973 = new Endereco(null, "Rua Três", "Jardim Santa Maria", "Sul", "12225393");
		Endereco rua2974 = new Endereco(null, "Rua Antonio Fernando Batista", "Jardim Santa Maria III", "Sul",
				"12225394");
		Endereco rua2975 = new Endereco(null, "Rua Cinco", "Jardim Santa Maria", "Sul", "12225395");
		Endereco rua2976 = new Endereco(null, "Rua Seis", "Jardim Santa Maria", "Sul", "12225396");
		Endereco rua2977 = new Endereco(null, "Rua das Flores", "Jardim Santa Maria", "Sul", "12225397");
		Endereco rua2978 = new Endereco(null, "Rua José Leite Filho", "Jardim Santa Maria", "Sul", "12225398");
		Endereco rua2979 = new Endereco(null, "Rua Hum-A", "Jardim das Cerejeiras", "Sul", "12225399");
		Endereco rua2980 = new Endereco(null, "Rua Aparecida Maria Consiglio", "Jardim Nova Michigan", "Sul",
				"12225400");
		Endereco rua2981 = new Endereco(null, "Rua Hum B", "Jardim das Cerejeiras", "Sul", "12225401");
		Endereco rua2982 = new Endereco(null, "Rua Hum-C", "Jardim das Cerejeiras", "Sul", "12225402");
		Endereco rua2983 = new Endereco(null, "Rua Dois", "Jardim das Cerejeiras", "Sul", "12225403");
		Endereco rua2984 = new Endereco(null, "Rua Três", "Jardim das Cerejeiras", "Sul", "12225404");
		Endereco rua2985 = new Endereco(null, "Rua Quatro", "Jardim das Cerejeiras", "Sul", "12225405");
		Endereco rua2986 = new Endereco(null, "Rua Cinco", "Jardim das Cerejeiras", "Sul", "12225406");
		Endereco rua2987 = new Endereco(null, "Rua Seis", "Jardim das Cerejeiras", "Sul", "12225407");
		Endereco rua2988 = new Endereco(null, "Rua Sete", "Jardim das Cerejeiras", "Sul", "12225408");
		Endereco rua2989 = new Endereco(null, "Rua Oito", "Jardim das Cerejeiras", "Sul", "12225409");
		Endereco rua2990 = new Endereco(null, "Rua Crisante Barbosa Miranda", "Jardim Nova Michigan", "Sul",
				"12225410");
		Endereco rua2991 = new Endereco(null, "Rua Nove", "Jardim das Cerejeiras", "Sul", "12225411");
		Endereco rua2992 = new Endereco(null, "Rua Dez", "Jardim das Cerejeiras", "Sul", "12225412");
		Endereco rua2993 = new Endereco(null, "Rua Onze", "Jardim das Cerejeiras", "Sul", "12225413");
		Endereco rua2994 = new Endereco(null, "Avenida Central", "Jardim das Cerejeiras", "Sul", "12225414");
		Endereco rua2995 = new Endereco(null, "Avenida Guaramirim", "Jardim Majestic", "Sul", "12225415");
		Endereco rua2996 = new Endereco(null, "Travessa Guaramirim", "Jardim Majestic", "Sul", "12225416");
		Endereco rua2997 = new Endereco(null, "Rua Lobo Guará", "Jardim das Cerejeiras", "Sul", "12225417");
		Endereco rua2998 = new Endereco(null, "Rua Francisco Moreira de Souza", "Jardim Nova Michigan", "Sul",
				"12225420");
		Endereco rua2999 = new Endereco(null, "Avenida Presidente Tancredo Neves", "Jardim Nova Michigan", "Sul",
				"12225421");

		endRepository.saveAll(Arrays.asList(rua1500, rua1501, rua1502, rua1503, rua1504, rua1505, rua1506, rua1507,
				rua1508, rua1509, rua1510, rua1511, rua1512, rua1513, rua1514, rua1515, rua1516, rua1517, rua1518,
				rua1519, rua1520, rua1521, rua1522, rua1523, rua1524, rua1525, rua1526, rua1527, rua1528, rua1529,
				rua1530, rua1531, rua1532, rua1533, rua1534, rua1535, rua1536, rua1537, rua1538, rua1539, rua1540,
				rua1541, rua1542, rua1543, rua1544, rua1545, rua1546, rua1547, rua1548, rua1549, rua1550, rua1551,
				rua1552, rua1553, rua1554, rua1555, rua1556, rua1557, rua1558, rua1559, rua1560, rua1561, rua1562,
				rua1563, rua1564, rua1565, rua1566, rua1567, rua1568, rua1569, rua1570, rua1571, rua1572, rua1573,
				rua1574, rua1575, rua1576, rua1577, rua1578, rua1579, rua1580, rua1581, rua1582, rua1583, rua1584,
				rua1585, rua1586, rua1587, rua1588, rua1589, rua1590, rua1591, rua1592, rua1593, rua1594, rua1595,
				rua1596, rua1597, rua1598, rua1599, rua1600, rua1601, rua1602, rua1603, rua1604, rua1605, rua1606,
				rua1607, rua1608, rua1609, rua1610, rua1611, rua1612, rua1613, rua1614, rua1615, rua1616, rua1617,
				rua1618, rua1619, rua1620, rua1621, rua1622, rua1623, rua1624, rua1625, rua1626, rua1627, rua1628,
				rua1629, rua1630, rua1631, rua1632, rua1633, rua1634, rua1635, rua1636, rua1637, rua1638, rua1639,
				rua1640, rua1641, rua1642, rua1643, rua1644, rua1645, rua1646, rua1647, rua1648, rua1649, rua1650,
				rua1651, rua1652, rua1653, rua1654, rua1655, rua1656, rua1657, rua1658, rua1659, rua1660, rua1661,
				rua1662, rua1663, rua1664, rua1665, rua1666, rua1667, rua1668, rua1669, rua1670, rua1671, rua1672,
				rua1673, rua1674, rua1675, rua1676, rua1677, rua1678, rua1679, rua1680, rua1681, rua1682, rua1683,
				rua1684, rua1685, rua1686, rua1687, rua1688, rua1689, rua1690, rua1691, rua1692, rua1693, rua1694,
				rua1695, rua1696, rua1697, rua1698, rua1699, rua1700, rua1701, rua1702, rua1703, rua1704, rua1705,
				rua1706, rua1707, rua1708, rua1709, rua1710, rua1711, rua1712, rua1713, rua1714, rua1715, rua1716,
				rua1717, rua1718, rua1719, rua1720, rua1721, rua1722, rua1723, rua1724, rua1725, rua1726, rua1727,
				rua1728, rua1729, rua1730, rua1731, rua1732, rua1733, rua1734, rua1735, rua1736, rua1737, rua1738,
				rua1739, rua1740, rua1741, rua1742, rua1743, rua1744, rua1745, rua1746, rua1747, rua1748, rua1749,
				rua1750, rua1751, rua1752, rua1753, rua1754, rua1755, rua1756, rua1757, rua1758, rua1759, rua1760,
				rua1761, rua1762, rua1763, rua1764, rua1765, rua1766, rua1767, rua1768, rua1769, rua1770, rua1771,
				rua1772, rua1773, rua1774, rua1775, rua1776, rua1777, rua1778, rua1779, rua1780, rua1781, rua1782,
				rua1783, rua1784, rua1785, rua1786, rua1787, rua1788, rua1789, rua1790, rua1791, rua1792, rua1793,
				rua1794, rua1795, rua1796, rua1797, rua1798, rua1799, rua1800, rua1801, rua1802, rua1803, rua1804,
				rua1805, rua1806, rua1807, rua1808, rua1809, rua1810, rua1811, rua1812, rua1813, rua1814, rua1815,
				rua1816, rua1817, rua1818, rua1819, rua1820, rua1821, rua1822, rua1823, rua1824, rua1825, rua1826,
				rua1827, rua1828, rua1829, rua1830, rua1831, rua1832, rua1833, rua1834, rua1835, rua1836, rua1837,
				rua1838, rua1839, rua1840, rua1841, rua1842, rua1843, rua1844, rua1845, rua1846, rua1847, rua1848,
				rua1849, rua1850, rua1851, rua1852, rua1853, rua1854, rua1855, rua1856, rua1857, rua1858, rua1859,
				rua1860, rua1861, rua1862, rua1863, rua1864, rua1865, rua1866, rua1867, rua1868, rua1869, rua1870,
				rua1871, rua1872, rua1873, rua1874, rua1875, rua1876, rua1877, rua1878, rua1879, rua1880, rua1881,
				rua1882, rua1883, rua1884, rua1885, rua1886, rua1887, rua1888, rua1889, rua1890, rua1891, rua1892,
				rua1893, rua1894, rua1895, rua1896, rua1897, rua1898, rua1899, rua1900, rua1901, rua1902, rua1903,
				rua1904, rua1905, rua1906, rua1907, rua1908, rua1909, rua1910, rua1911, rua1912, rua1913, rua1914,
				rua1915, rua1916, rua1917, rua1918, rua1919, rua1920, rua1921, rua1922, rua1923, rua1924, rua1925,
				rua1926, rua1927, rua1928, rua1929, rua1930, rua1931, rua1932, rua1933, rua1934, rua1935, rua1936,
				rua1937, rua1938, rua1939, rua1940, rua1941, rua1942, rua1943, rua1944, rua1945, rua1946, rua1947,
				rua1948, rua1949, rua1950, rua1951, rua1952, rua1953, rua1954, rua1955, rua1956, rua1957, rua1958,
				rua1959, rua1960, rua1961, rua1962, rua1963, rua1964, rua1965, rua1966, rua1967, rua1968, rua1969,
				rua1970, rua1971, rua1972, rua1973, rua1974, rua1975, rua1976, rua1977, rua1978, rua1979, rua1980,
				rua1981, rua1982, rua1983, rua1984, rua1985, rua1986, rua1987, rua1988, rua1989, rua1990, rua1991,
				rua1992, rua1993, rua1994, rua1995, rua1996, rua1997, rua1998, rua1999, rua2000, rua2001, rua2002,
				rua2003, rua2004, rua2005, rua2006, rua2007, rua2008, rua2009, rua2010, rua2011, rua2012, rua2013,
				rua2014, rua2015, rua2016, rua2017, rua2018, rua2019, rua2020, rua2021, rua2022, rua2023, rua2024,
				rua2025, rua2026, rua2027, rua2028, rua2029, rua2030, rua2031, rua2032, rua2033, rua2034, rua2035,
				rua2036, rua2037, rua2038, rua2039, rua2040, rua2041, rua2042, rua2043, rua2044, rua2045, rua2046,
				rua2047, rua2048, rua2049, rua2050, rua2051, rua2052, rua2053, rua2054, rua2055, rua2056, rua2057,
				rua2058, rua2059, rua2060, rua2061, rua2062, rua2063, rua2064, rua2065, rua2066, rua2067, rua2068,
				rua2069, rua2070, rua2071, rua2072, rua2073, rua2074, rua2075, rua2076, rua2077, rua2078, rua2079,
				rua2080, rua2081, rua2082, rua2083, rua2084, rua2085, rua2086, rua2087, rua2088, rua2089, rua2090,
				rua2091, rua2092, rua2093, rua2094, rua2095, rua2096, rua2097, rua2098, rua2099, rua2100, rua2101,
				rua2102, rua2103, rua2104, rua2105, rua2106, rua2107, rua2108, rua2109, rua2110, rua2111, rua2112,
				rua2113, rua2114, rua2115, rua2116, rua2117, rua2118, rua2119, rua2120, rua2121, rua2122, rua2123,
				rua2124, rua2125, rua2126, rua2127, rua2128, rua2129, rua2130, rua2131, rua2132, rua2133, rua2134,
				rua2135, rua2136, rua2137, rua2138, rua2139, rua2140, rua2141, rua2142, rua2143, rua2144, rua2145,
				rua2146, rua2147, rua2148, rua2149, rua2150, rua2151, rua2152, rua2153, rua2154, rua2155, rua2156,
				rua2157, rua2158, rua2159, rua2160, rua2161, rua2162, rua2163, rua2164, rua2165, rua2166, rua2167,
				rua2168, rua2169, rua2170, rua2171, rua2172, rua2173, rua2174, rua2175, rua2176, rua2177, rua2178,
				rua2179, rua2180, rua2181, rua2182, rua2183, rua2184, rua2185, rua2186, rua2187, rua2188, rua2189,
				rua2190, rua2191, rua2192, rua2193, rua2194, rua2195, rua2196, rua2197, rua2198, rua2199, rua2200,
				rua2201, rua2202, rua2203, rua2204, rua2205, rua2206, rua2207, rua2208, rua2209, rua2210, rua2211,
				rua2212, rua2213, rua2214, rua2215, rua2216, rua2217, rua2218, rua2219, rua2220, rua2221, rua2222,
				rua2223, rua2224, rua2225, rua2226, rua2227, rua2228, rua2229, rua2230, rua2231, rua2232, rua2233,
				rua2234, rua2235, rua2236, rua2237, rua2238, rua2239, rua2240, rua2241, rua2242, rua2243, rua2244,
				rua2245, rua2246, rua2247, rua2248, rua2249, rua2250, rua2251, rua2252, rua2253, rua2254, rua2255,
				rua2256, rua2257, rua2258, rua2259, rua2260, rua2261, rua2262, rua2263, rua2264, rua2265, rua2266,
				rua2267, rua2268, rua2269, rua2270, rua2271, rua2272, rua2273, rua2274, rua2275, rua2276, rua2277,
				rua2278, rua2279, rua2280, rua2281, rua2282, rua2283, rua2284, rua2285, rua2286, rua2287, rua2288,
				rua2289, rua2290, rua2291, rua2292, rua2293, rua2294, rua2295, rua2296, rua2297, rua2298, rua2299,
				rua2300, rua2301, rua2302, rua2303, rua2304, rua2305, rua2306, rua2307, rua2308, rua2309, rua2310,
				rua2311, rua2312, rua2313, rua2314, rua2315, rua2316, rua2317, rua2318, rua2319, rua2320, rua2321,
				rua2322, rua2323, rua2324, rua2325, rua2326, rua2327, rua2328, rua2329, rua2330, rua2331, rua2332,
				rua2333, rua2334, rua2335, rua2336, rua2337, rua2338, rua2339, rua2340, rua2341, rua2342, rua2343,
				rua2344, rua2345, rua2346, rua2347, rua2348, rua2349, rua2350, rua2351, rua2352, rua2353, rua2354,
				rua2355, rua2356, rua2357, rua2358, rua2359, rua2360, rua2361, rua2362, rua2363, rua2364, rua2365,
				rua2366, rua2367, rua2368, rua2369, rua2370, rua2371, rua2372, rua2373, rua2374, rua2375, rua2376,
				rua2377, rua2378, rua2379, rua2380, rua2381, rua2382, rua2383, rua2384, rua2385, rua2386, rua2387,
				rua2388, rua2389, rua2390, rua2391, rua2392, rua2393, rua2394, rua2395, rua2396, rua2397, rua2398,
				rua2399, rua2400, rua2401, rua2402, rua2403, rua2404, rua2405, rua2406, rua2407, rua2408, rua2409,
				rua2410, rua2411, rua2412, rua2413, rua2414, rua2415, rua2416, rua2417, rua2418, rua2419, rua2420,
				rua2421, rua2422, rua2423, rua2424, rua2425, rua2426, rua2427, rua2428, rua2429, rua2430, rua2431,
				rua2432, rua2433, rua2434, rua2435, rua2436, rua2437, rua2438, rua2439, rua2440, rua2441, rua2442,
				rua2443, rua2444, rua2445, rua2446, rua2447, rua2448, rua2449, rua2450, rua2451, rua2452, rua2453,
				rua2454, rua2455, rua2456, rua2457, rua2458, rua2459, rua2460, rua2461, rua2462, rua2463, rua2464,
				rua2465, rua2466, rua2467, rua2468, rua2469, rua2470, rua2471, rua2472, rua2473, rua2474, rua2475,
				rua2476, rua2477, rua2478, rua2479, rua2480, rua2481, rua2482, rua2483, rua2484, rua2485, rua2486,
				rua2487, rua2488, rua2489, rua2490, rua2491, rua2492, rua2493, rua2494, rua2495, rua2496, rua2497,
				rua2498, rua2499, rua2500, rua2501, rua2502, rua2503, rua2504, rua2505, rua2506, rua2507, rua2508,
				rua2509, rua2510, rua2511, rua2512, rua2513, rua2514, rua2515, rua2516, rua2517, rua2518, rua2519,
				rua2520, rua2521, rua2522, rua2523, rua2524, rua2525, rua2526, rua2527, rua2528, rua2529, rua2530,
				rua2531, rua2532, rua2533, rua2534, rua2535, rua2536, rua2537, rua2538, rua2539, rua2540, rua2541,
				rua2542, rua2543, rua2544, rua2545, rua2546, rua2547, rua2548, rua2549, rua2550, rua2551, rua2552,
				rua2553, rua2554, rua2555, rua2556, rua2557, rua2558, rua2559, rua2560, rua2561, rua2562, rua2563,
				rua2564, rua2565, rua2566, rua2567, rua2568, rua2569, rua2570, rua2571, rua2572, rua2573, rua2574,
				rua2575, rua2576, rua2577, rua2578, rua2579, rua2580, rua2581, rua2582, rua2583, rua2584, rua2585,
				rua2586, rua2587, rua2588, rua2589, rua2590, rua2591, rua2592, rua2593, rua2594, rua2595, rua2596,
				rua2597, rua2598, rua2599, rua2600, rua2601, rua2602, rua2603, rua2604, rua2605, rua2606, rua2607,
				rua2608, rua2609, rua2610, rua2611, rua2612, rua2613, rua2614, rua2615, rua2616, rua2617, rua2618,
				rua2619, rua2620, rua2621, rua2622, rua2623, rua2624, rua2625, rua2626, rua2627, rua2628, rua2629,
				rua2630, rua2631, rua2632, rua2633, rua2634, rua2635, rua2636, rua2637, rua2638, rua2639, rua2640,
				rua2641, rua2642, rua2643, rua2644, rua2645, rua2646, rua2647, rua2648, rua2649, rua2650, rua2651,
				rua2652, rua2653, rua2654, rua2655, rua2656, rua2657, rua2658, rua2659, rua2660, rua2661, rua2662,
				rua2663, rua2664, rua2665, rua2666, rua2667, rua2668, rua2669, rua2670, rua2671, rua2672, rua2673,
				rua2674, rua2675, rua2676, rua2677, rua2678, rua2679, rua2680, rua2681, rua2682, rua2683, rua2684,
				rua2685, rua2686, rua2687, rua2688, rua2689, rua2690, rua2691, rua2692, rua2693, rua2694, rua2695,
				rua2696, rua2697, rua2698, rua2699, rua2700, rua2701, rua2702, rua2703, rua2704, rua2705, rua2706,
				rua2707, rua2708, rua2709, rua2710, rua2711, rua2712, rua2713, rua2714, rua2715, rua2716, rua2717,
				rua2718, rua2719, rua2720, rua2721, rua2722, rua2723, rua2724, rua2725, rua2726, rua2727, rua2728,
				rua2729, rua2730, rua2731, rua2732, rua2733, rua2734, rua2735, rua2736, rua2737, rua2738, rua2739,
				rua2740, rua2741, rua2742, rua2743, rua2744, rua2745, rua2746, rua2747, rua2748, rua2749, rua2750,
				rua2751, rua2752, rua2753, rua2754, rua2755, rua2756, rua2757, rua2758, rua2759, rua2760, rua2761,
				rua2762, rua2763, rua2764, rua2765, rua2766, rua2767, rua2768, rua2769, rua2770, rua2771, rua2772,
				rua2773, rua2774, rua2775, rua2776, rua2777, rua2778, rua2779, rua2780, rua2781, rua2782, rua2783,
				rua2784, rua2785, rua2786, rua2787, rua2788, rua2789, rua2790, rua2791, rua2792, rua2793, rua2794,
				rua2795, rua2796, rua2797, rua2798, rua2799, rua2800, rua2801, rua2802, rua2803, rua2804, rua2805,
				rua2806, rua2807, rua2808, rua2809, rua2810, rua2811, rua2812, rua2813, rua2814, rua2815, rua2816,
				rua2817, rua2818, rua2819, rua2820, rua2821, rua2822, rua2823, rua2824, rua2825, rua2826, rua2827,
				rua2828, rua2829, rua2830, rua2831, rua2832, rua2833, rua2834, rua2835, rua2836, rua2837, rua2838,
				rua2839, rua2840, rua2841, rua2842, rua2843, rua2844, rua2845, rua2846, rua2847, rua2848, rua2849,
				rua2850, rua2851, rua2852, rua2853, rua2854, rua2855, rua2856, rua2857, rua2858, rua2859, rua2860,
				rua2861, rua2862, rua2863, rua2864, rua2865, rua2866, rua2867, rua2868, rua2869, rua2870, rua2871,
				rua2872, rua2873, rua2874, rua2875, rua2876, rua2877, rua2878, rua2879, rua2880, rua2881, rua2882,
				rua2883, rua2884, rua2885, rua2886, rua2887, rua2888, rua2889, rua2890, rua2891, rua2892, rua2893,
				rua2894, rua2895, rua2896, rua2897, rua2898, rua2899, rua2900, rua2901, rua2902, rua2903, rua2904,
				rua2905, rua2906, rua2907, rua2908, rua2909, rua2910, rua2911, rua2912, rua2913, rua2914, rua2915,
				rua2916, rua2917, rua2918, rua2919, rua2920, rua2921, rua2922, rua2923, rua2924, rua2925, rua2926,
				rua2927, rua2928, rua2929, rua2930, rua2931, rua2932, rua2933, rua2934, rua2935, rua2936, rua2937,
				rua2938, rua2939, rua2940, rua2941, rua2942, rua2943, rua2944, rua2945, rua2946, rua2947, rua2948,
				rua2949, rua2950, rua2951, rua2952, rua2953, rua2954, rua2955, rua2956, rua2957, rua2958, rua2959,
				rua2960, rua2961, rua2962, rua2963, rua2964, rua2965, rua2966, rua2967, rua2968, rua2969, rua2970,
				rua2971, rua2972, rua2973, rua2974, rua2975, rua2976, rua2977, rua2978, rua2979, rua2980, rua2981,
				rua2982, rua2983, rua2984, rua2985, rua2986, rua2987, rua2988, rua2989, rua2990, rua2991, rua2992,
				rua2993, rua2994, rua2995, rua2996, rua2997, rua2998, rua2999));

	}

	protected void insere3() throws ParseException {
		Endereco rua3000 = new Endereco(null, "Travessa Aparecida Maria Consiglio", "Jardim Nova Michigan II", "Sul",
				"12225422");
		Endereco rua3001 = new Endereco(null, "Rua Ruy Pereira Gomes", "Jardim Nova Michigan II", "Sul", "12225423");
		Endereco rua3002 = new Endereco(null, "Travessa Luiz Carlos Ossamu Kishi", "Jardim Nova Michigan II", "Sul",
				"12225424");
		Endereco rua3003 = new Endereco(null, "Travessa Dimas Moreira dos Santos", "Jardim Nova Michigan II", "Sul",
				"12225425");
		Endereco rua3004 = new Endereco(null, "Rua Fernanda Paula Silva Duarte", "Jardim Nova Michigan II", "Sul",
				"12225426");
		Endereco rua3005 = new Endereco(null, "Rua Professora Maria José de Oliveira", "Jardim Nova Michigan", "Sul",
				"12225430");
		Endereco rua3006 = new Endereco(null, "Rua Professora Maria Helena Moreira de Queiroz", "Jardim Nova Michigan",
				"Sul", "12225440");
		Endereco rua3007 = new Endereco(null, "Rua Maria Isabel Mendes", "Jardim Nova Michigan", "Sul", "12225450");
		Endereco rua3008 = new Endereco(null, "Rua Giovanni Batista Capellotto", "Jardim Nova Michigan", "Sul",
				"12225460");
		Endereco rua3009 = new Endereco(null, "Estrada do Mato Dentro", "Jardim Nova Michigan", "Sul", "12225470");
		Endereco rua3010 = new Endereco(null, "Avenida Vinte e Três de Dezembro", "Jardim das Cerejeiras", "Sul",
				"12225480");
		Endereco rua3011 = new Endereco(null, "Avenida Oito de Dezembro", "Jardim das Cerejeiras", "Sul", "12225490");
		Endereco rua3012 = new Endereco(null, "Rua Quinze de Outubro", "Jardim das Cerejeiras", "Sul", "12225500");
		Endereco rua3013 = new Endereco(null, "Rua Vinte e Cinco de Agosto", "Jardim das Cerejeiras", "Sul",
				"12225510");
		Endereco rua3014 = new Endereco(null, "Rua Vinte e Nove de Junho", "Jardim das Cerejeiras", "Sul", "12225520");
		Endereco rua3015 = new Endereco(null, "Viela Onze de Agosto", "Jardim das Cerejeiras", "Sul", "12225521");
		Endereco rua3016 = new Endereco(null, "Rua Quinze de Julho", "Jardim das Cerejeiras", "Sul", "12225530");
		Endereco rua3017 = new Endereco(null, "Viela Dezenove de Fevereiro", "Jardim das Cerejeiras", "Sul",
				"12225531");
		Endereco rua3018 = new Endereco(null, "Avenida Presidente Tancredo Neves", "Jardim das Cerejeiras", "Sul",
				"12225532");
		Endereco rua3019 = new Endereco(null, "Rua Vinte e Cinco de Julho", "Jardim das Cerejeiras", "Sul", "12225540");
		Endereco rua3020 = new Endereco(null, "Viela Vinte e Um de Setembro", "Jardim das Cerejeiras", "Sul",
				"12225541");
		Endereco rua3021 = new Endereco(null, "Rua Vinte de Janeiro", "Jardim das Cerejeiras", "Sul", "12225550");
		Endereco rua3022 = new Endereco(null, "Praça Oito de Março", "Jardim das Cerejeiras", "Sul", "12225551");
		Endereco rua3023 = new Endereco(null, "Rua Vinte e Sete de Abril", "Jardim das Cerejeiras", "Sul", "12225560");
		Endereco rua3024 = new Endereco(null, "Rua Quatro de Março", "Jardim das Cerejeiras", "Sul", "12225570");
		Endereco rua3025 = new Endereco(null, "Avenida Nove de Novembro", "Jardim das Cerejeiras", "Sul", "12225580");
		Endereco rua3026 = new Endereco(null, "Rua Cinco de Maio", "Jardim das Cerejeiras", "Sul", "12225581");
		Endereco rua3027 = new Endereco(null, "Rua Dezenove de Março", "Jardim das Cerejeiras", "Sul", "12225590");
		Endereco rua3028 = new Endereco(null, "Rua Vinte e Cinco de Maio", "Jardim das Cerejeiras", "Sul", "12225591");
		Endereco rua3029 = new Endereco(null, "Rua Bertolino Cursino dos Santos", "Jardim San Rafael", "Sul",
				"12225592");
		Endereco rua3030 = new Endereco(null, "Avenida Presidente Tancredo Neves", "Jardim San Rafael", "Sul",
				"12225593");
		Endereco rua3031 = new Endereco(null, "Rua Benedito Fernandes de Andrade", "Jardim San Rafael", "Sul",
				"12225599");
		Endereco rua3032 = new Endereco(null, "Estrada do Joaquim Gonçalves da Silva", "Jardim Santa Maria", "Sul",
				"12225833");
		Endereco rua3033 = new Endereco(null, "Rua Lazio", "Jardim das Paineiras I", "Sul", "12226083");
		Endereco rua3034 = new Endereco(null, "Rua Emilia-Romagna", "Jardim das Paineiras I", "Sul", "12226084");
		Endereco rua3035 = new Endereco(null, "Rua Veneto", "Jardim das Paineiras I", "Sul", "12226085");
		Endereco rua3036 = new Endereco(null, "Rua Liguria", "Jardim das Paineiras I", "Sul", "12226086");
		Endereco rua3037 = new Endereco(null, "Rua Friuli", "Jardim das Paineiras I", "Sul", "12226087");
		Endereco rua3038 = new Endereco(null, "Rua Lombardia", "Jardim das Paineiras I", "Sul", "12226088");
		Endereco rua3039 = new Endereco(null, "Rua Toscana", "Jardim das Paineiras I", "Sul", "12226089");
		Endereco rua3040 = new Endereco(null, "Rua Marche", "Jardim das Paineiras I", "Sul", "12226091");
		Endereco rua3041 = new Endereco(null, "Rua Trentino", "Jardim das Paineiras I", "Sul", "12226092");
		Endereco rua3042 = new Endereco(null, "Rua Seis", "Jardim das Paineiras I", "Sul", "12226093");
		Endereco rua3043 = new Endereco(null, "Rua Onze", "Jardim das Paineiras I", "Sul", "12226094");
		Endereco rua3044 = new Endereco(null, "Rua Doze", "Jardim das Paineiras I", "Sul", "12226095");
		Endereco rua3045 = new Endereco(null, "Avenida Sinaloa", "Jardim das Paineiras II", "Sul", "12226101");
		Endereco rua3046 = new Endereco(null, "Rua Los Mochis", "Jardim das Paineiras II", "Sul", "12226102");
		Endereco rua3047 = new Endereco(null, "Rua Borgofranco", "Jardim das Paineiras II", "Sul", "12226103");
		Endereco rua3048 = new Endereco(null, "Rua Zacatecas", "Jardim das Paineiras II", "Sul", "12226104");
		Endereco rua3049 = new Endereco(null, "Rua Durango", "Jardim das Paineiras II", "Sul", "12226105");
		Endereco rua3050 = new Endereco(null, "Rua Piemonte", "Jardim das Paineiras II", "Sul", "12226106");
		Endereco rua3051 = new Endereco(null, "Rua Cuernavaca", "Jardim das Paineiras II", "Sul", "12226107");
		Endereco rua3052 = new Endereco(null, "Rua Guadalajara", "Jardim das Paineiras II", "Sul", "12226108");
		Endereco rua3053 = new Endereco(null, "Rua Torino", "Jardim das Paineiras II", "Sul", "12226109");
		Endereco rua3054 = new Endereco(null, "Rua Monterrey", "Jardim das Paineiras II", "Sul", "12226112");
		Endereco rua3055 = new Endereco(null, "Rua Morelos", "Jardim das Paineiras II", "Sul", "12226113");
		Endereco rua3056 = new Endereco(null, "Rua Culiacán", "Jardim das Paineiras II", "Sul", "12226114");
		Endereco rua3057 = new Endereco(null, "Rua Mirim", "Jardim Ebenézer", "Sul", "12226199");
		Endereco rua3058 = new Endereco(null, "Rua Shalon", "Jardim Ebenézer", "Sul", "12226203");
		Endereco rua3059 = new Endereco(null, "Rua Um", "Jardim Primavera II", "Sul", "12226260");
		Endereco rua3060 = new Endereco(null, "Rua Tres", "Jardim Primavera II", "Sul", "12226261");
		Endereco rua3061 = new Endereco(null, "Rua Quatro", "Jardim Primavera II", "Sul", "12226264");
		Endereco rua3062 = new Endereco(null, "Rua Cinco", "Jardim Primavera II", "Sul", "12226266");
		Endereco rua3063 = new Endereco(null, "Rua Dois", "Jardim Primavera II", "Sul", "12226270");
		Endereco rua3064 = new Endereco(null, "Rua Lobo Guará", "Jardim Majestic", "Sul", "12226271");
		Endereco rua3065 = new Endereco(null, "Estrada Dom José Antonio do Couto", "Jardim Allah", "Sul", "12226311");
		Endereco rua3066 = new Endereco(null, "Rua Professor Alcides Savastano Junior", "Jardim Santa Cecília I", "Sul",
				"12226651");
		Endereco rua3067 = new Endereco(null, "Estrada Dom José Antonio do Couto", "Jardim Santa Cecília I", "Sul",
				"12226652");
		Endereco rua3068 = new Endereco(null, "Rua Maria Goulart da Silva", "Jardim Santa Cecília I", "Sul",
				"12226653");
		Endereco rua3069 = new Endereco(null, "Avenida Tomezo Morino", "Loteamento Jardim Helena", "Sul", "12226681");
		Endereco rua3070 = new Endereco(null, "Rua Joaquim Maia da Silva", "Loteamento Jardim Helena", "Sul",
				"12226684");
		Endereco rua3071 = new Endereco(null, "Rua Severo Cesar Leite", "Loteamento Jardim Helena", "Sul", "12226687");
		Endereco rua3072 = new Endereco(null, "Rua Telma Pacheco de Oliveira Silva", "Loteamento Jardim Helena", "Sul",
				"12226691");
		Endereco rua3073 = new Endereco(null, "Rua Miyoko Morino", "Loteamento Jardim Helena", "Sul", "12226694");
		Endereco rua3074 = new Endereco(null, "Rua João Alberto da Silva", "Loteamento Jardim Helena", "Sul",
				"12226697");
		Endereco rua3075 = new Endereco(null, "Estrada Municipal Jardim de Allah", "Cajuru", "Sul", "12226770");
		Endereco rua3076 = new Endereco(null, "Rua N", "Jardim Santa Hermínia", "Sul", "12226801");
		Endereco rua3077 = new Endereco(null, "Rua Dez", "Jardim Santa Hermínia", "Sul", "12226802");
		Endereco rua3078 = new Endereco(null, "Rua Ágata", "Jardim Santa Hermínia", "Sul", "12226803");
		Endereco rua3079 = new Endereco(null, "Rua Carlota Batista Pereira", "Jardim Santa Hermínia", "Sul",
				"12226819");
		Endereco rua3080 = new Endereco(null, "Rua Dois", "Jardim Santa Hermínia", "Sul", "12226825");
		Endereco rua3081 = new Endereco(null, "Rua Hum", "Jardim Santa Hermínia", "Sul", "12226827");
		Endereco rua3082 = new Endereco(null, "Estrada Municipal Antônio Frederico Ozanam", "Jardim Santa Hermínia",
				"Sul", "12226830");
		Endereco rua3083 = new Endereco(null, "Rua F", "Jardim Santa Hermínia", "Sul", "12226831");
		Endereco rua3084 = new Endereco(null, "Rua L", "Jardim Santa Hermínia", "Sul", "12226832");
		Endereco rua3085 = new Endereco(null, "Rua Pedro Bertolino", "Jardim Santa Hermínia", "Sul", "12226833");
		Endereco rua3086 = new Endereco(null, "Rua M", "Jardim Santa Hermínia", "Sul", "12226834");
		Endereco rua3087 = new Endereco(null, "Rua G", "Jardim Santa Hermínia", "Sul", "12226835");
		Endereco rua3088 = new Endereco(null, "Rua José Frankilin de Sant'Ana", "Jardim Santa Hermínia", "Sul",
				"12226836");
		Endereco rua3089 = new Endereco(null, "Rua Francisco Cunha Laranjeira", "Jardim Santa Hermínia", "Sul",
				"12226837");
		Endereco rua3090 = new Endereco(null, "Rua Pedra do Sol", "Jardim Santa Hermínia", "Sul", "12226838");
		Endereco rua3091 = new Endereco(null, "Rua D", "Jardim Santa Hermínia", "Sul", "12226839");
		Endereco rua3092 = new Endereco(null, "Rua Pedra da Lua", "Jardim Santa Hermínia", "Sul", "12226840");
		Endereco rua3093 = new Endereco(null, "Rua Ônix", "Jardim Santa Hermínia", "Sul", "12226841");
		Endereco rua3094 = new Endereco(null, "Rua Espinela", "Jardim Santa Hermínia", "Sul", "12226842");
		Endereco rua3095 = new Endereco(null, "Rua Flávia Rosana dos Santos Rosa Cabral", "Jardim Santa Hermínia",
				"Sul", "12226843");
		Endereco rua3096 = new Endereco(null, "Estrada Roseli Aparecida de Almeida Ferreira", "Jardim Santa Hermínia",
				"Sul", "12226844");
		Endereco rua3097 = new Endereco(null, "Rua Um", "Jardim Allah", "Sul", "12226845");
		Endereco rua3098 = new Endereco(null, "Avenida Joaquim Ribeiro Guedes", "Jardim Mariana I", "Sul", "12226850");
		Endereco rua3099 = new Endereco(null, "Rua Manoel Francisco de Moraes", "Jardim Mariana I", "Sul", "12226851");
		Endereco rua3100 = new Endereco(null, "Rua Antoinette Melhem El Khouri Nicolas", "Jardim Mariana I", "Sul",
				"12226852");
		Endereco rua3101 = new Endereco(null, "Rua Angelina de Souza Machado", "Jardim Mariana I", "Sul", "12226853");
		Endereco rua3102 = new Endereco(null, "Rua Aurélio Portilho Castellanos", "Jardim Mariana I", "Sul",
				"12226854");
		Endereco rua3103 = new Endereco(null, "Rua Engenheiro Pedro Paulo Cerqueira Lima", "Jardim Mariana I", "Sul",
				"12226856");
		Endereco rua3104 = new Endereco(null, "Rua Inês Maria do Nascimento", "Jardim Mariana I", "Sul", "12226857");
		Endereco rua3105 = new Endereco(null, "Rua Fátima Regina da Silva", "Jardim Mariana I", "Sul", "12226858");
		Endereco rua3106 = new Endereco(null, "Rua João Vicente Gomes Filho", "Jardim Mariana I", "Sul", "12226859");
		Endereco rua3107 = new Endereco(null, "Rua José Hermínio de Oliveira", "Jardim Mariana I", "Sul", "12226860");
		Endereco rua3108 = new Endereco(null, "Rua José Militão da Silva", "Jardim Mariana I", "Sul", "12226861");
		Endereco rua3109 = new Endereco(null, "Rua Silvia Aparecida da Silva Nascimento", "Jardim Mariana I", "Sul",
				"12226862");
		Endereco rua3110 = new Endereco(null, "Rua Venâncio Coelho da Silva", "Jardim Mariana I", "Sul", "12226864");
		Endereco rua3111 = new Endereco(null, "Rua Cleusa Maria Soares da Silva", "Jardim Mariana I", "Sul",
				"12226866");
		Endereco rua3112 = new Endereco(null, "Rua Quatorze", "Jardim Mariana I", "Sul", "12226868");
		Endereco rua3113 = new Endereco(null, "Rua Antonio Marcos de Oliveira", "Jardim Mariana II", "Sul", "12226870");
		Endereco rua3114 = new Endereco(null, "Rua Carmelindo Aparecido Correa", "Jardim Mariana II", "Sul",
				"12226872");
		Endereco rua3115 = new Endereco(null, "Rua Doutor Antônio Borges de Toledo", "Jardim Mariana II", "Sul",
				"12226874");
		Endereco rua3116 = new Endereco(null, "Rua Gonçalo Soares", "Jardim Mariana II", "Sul", "12226876");
		Endereco rua3117 = new Endereco(null, "Rua Joaquim Antonio Martins", "Jardim Mariana II", "Sul", "12226877");
		Endereco rua3118 = new Endereco(null, "Rua Maria Angélia Monteiro Rodrigues", "Jardim Mariana II", "Sul",
				"12226878");
		Endereco rua3119 = new Endereco(null, "Rua Ken Ishizucka", "Jardim Mariana II", "Sul", "12226879");
		Endereco rua3120 = new Endereco(null, "Rua Maurício Maldonado Júnior", "Jardim Mariana II", "Sul", "12226880");
		Endereco rua3121 = new Endereco(null, "Rua Sebastião Ramos Nogueira", "Jardim Mariana II", "Sul", "12226882");
		Endereco rua3122 = new Endereco(null, "Rua Alceu Andrade", "Jardim Mariana II", "Sul", "12226883");
		Endereco rua3123 = new Endereco(null, "Rua Maria de Andrade Vieira", "Jardim Mariana II", "Sul", "12226884");
		Endereco rua3124 = new Endereco(null, "Avenida Mariana Andrade", "Jardim Mariana II", "Sul", "12226886");
		Endereco rua3125 = new Endereco(null, "Rua Benedicto Rezende de Souza", "Jardim Mariana II", "Sul", "12226888");
		Endereco rua3126 = new Endereco(null, "Avenida Doutor Amin Simão", "Jardim da Granja", "Sul", "12227001");
		Endereco rua3127 = new Endereco(null, "Avenida dos Astronautas", "Jardim da Granja", "Sul", "12227010");
		Endereco rua3128 = new Endereco(null, "Rua Avião Ipanema", "Jardim Souto", "Sul", "12227080");
		Endereco rua3129 = new Endereco(null, "Rua Avião Paulistinha", "Jardim Souto", "Sul", "12227081");
		Endereco rua3130 = new Endereco(null, "Avenida dos Astronautas", "Jardim Souto", "Sul", "12227082");
		Endereco rua3131 = new Endereco(null, "Rua Avião Brasília", "Jardim Souto", "Sul", "12227083");
		Endereco rua3132 = new Endereco(null, "Rua Avião Aribu", "Jardim Souto", "Sul", "12227090");
		Endereco rua3133 = new Endereco(null, "Rua Avião Muniz", "Jardim Souto", "Sul", "12227100");
		Endereco rua3134 = new Endereco(null, "Rua Avião Universal", "Jardim Souto", "Sul", "12227110");
		Endereco rua3135 = new Endereco(null, "Rua Avião Alvear", "Jardim Souto", "Sul", "12227120");
		Endereco rua3136 = new Endereco(null, "Rua Avião Uirapuru", "Jardim Souto", "Sul", "12227130");
		Endereco rua3137 = new Endereco(null, "Praça Quatorze Bis", "Jardim Souto", "Sul", "12227140");
		Endereco rua3138 = new Endereco(null, "Rua Avião Regente", "Jardim Souto", "Sul", "12227150");
		Endereco rua3139 = new Endereco(null, "Rua Avião Tangará", "Jardim Souto", "Sul", "12227160");
		Endereco rua3140 = new Endereco(null, "Rua Avião Bandeirantes", "Jardim Souto", "Sul", "12227170");
		Endereco rua3141 = new Endereco(null, "Rua Madre Maria Gema de Jesus", "Jardim da Granja", "Sul", "12227180");
		Endereco rua3142 = new Endereco(null, "Rua José Alves Moreira", "Jardim da Granja", "Sul", "12227190");
		Endereco rua3143 = new Endereco(null, "Rua Odete Mimessi", "Jardim da Granja", "Sul", "12227200");
		Endereco rua3144 = new Endereco(null, "Rua Primo Betti", "Jardim da Granja", "Sul", "12227210");
		Endereco rua3145 = new Endereco(null, "Rua Carolina Antunes Stetener", "Jardim da Granja", "Sul", "12227220");
		Endereco rua3146 = new Endereco(null, "Praça Hélio Dias", "Jardim da Granja", "Sul", "12227230");
		Endereco rua3147 = new Endereco(null, "Rua Orlando Saes", "Jardim da Granja", "Sul", "12227240");
		Endereco rua3148 = new Endereco(null, "Rua Herminio José Friggi", "Jardim da Granja", "Sul", "12227250");
		Endereco rua3149 = new Endereco(null, "Rua Dom Gabriel Paulino Bueno do Couto", "Jardim da Granja", "Sul",
				"12227260");
		Endereco rua3150 = new Endereco(null, "Rua José Busato", "Jardim da Granja", "Sul", "12227270");
		Endereco rua3151 = new Endereco(null, "Rua Centaurus", "Jardim da Granja", "Sul", "12227280");
		Endereco rua3152 = new Endereco(null, "Praça Áquila", "Jardim da Granja", "Sul", "12227290");
		Endereco rua3153 = new Endereco(null, "Rua Fênix", "Jardim da Granja", "Sul", "12227300");
		Endereco rua3154 = new Endereco(null, "Rua Sagitarios", "Jardim da Granja", "Sul", "12227310");
		Endereco rua3155 = new Endereco(null, "Rua Aquarius", "Jardim da Granja", "Sul", "12227320");
		Endereco rua3156 = new Endereco(null, "Rua Áries", "Jardim da Granja", "Sul", "12227330");
		Endereco rua3157 = new Endereco(null, "Rua Taurus", "Jardim da Granja", "Sul", "12227340");
		Endereco rua3158 = new Endereco(null, "Rua Orion", "Jardim da Granja", "Sul", "12227350");
		Endereco rua3159 = new Endereco(null, "Praça Hércules", "Jardim da Granja", "Sul", "12227360");
		Endereco rua3160 = new Endereco(null, "Rua Capricórnio", "Jardim da Granja", "Sul", "12227370");
		Endereco rua3161 = new Endereco(null, "Rua Netuno", "Jardim da Granja", "Sul", "12227380");
		Endereco rua3162 = new Endereco(null, "Rua Hidra", "Jardim da Granja", "Sul", "12227390");
		Endereco rua3163 = new Endereco(null, "Rua Lupus", "Jardim da Granja", "Sul", "12227400");
		Endereco rua3164 = new Endereco(null, "Rua Lince", "Jardim da Granja", "Sul", "12227410");
		Endereco rua3165 = new Endereco(null, "Rua Vênus", "Jardim da Granja", "Sul", "12227420");
		Endereco rua3166 = new Endereco(null, "Praça Marte", "Jardim da Granja", "Sul", "12227430");
		Endereco rua3167 = new Endereco(null, "Rua Plutão", "Jardim da Granja", "Sul", "12227440");
		Endereco rua3168 = new Endereco(null, "Rua Vesta", "Jardim da Granja", "Sul", "12227450");
		Endereco rua3169 = new Endereco(null, "Rua Jupiter", "Jardim da Granja", "Sul", "12227460");
		Endereco rua3170 = new Endereco(null, "Rua Juno", "Jardim da Granja", "Sul", "12227470");
		Endereco rua3171 = new Endereco(null, "Rua Saturno", "Jardim da Granja", "Sul", "12227480");
		Endereco rua3172 = new Endereco(null, "Rua Ceres", "Jardim da Granja", "Sul", "12227490");
		Endereco rua3173 = new Endereco(null, "Rua Palas", "Jardim da Granja", "Sul", "12227500");
		Endereco rua3174 = new Endereco(null, "Praça Columba", "Jardim da Granja", "Sul", "12227510");
		Endereco rua3175 = new Endereco(null, "Rua Urano", "Jardim da Granja", "Sul", "12227520");
		Endereco rua3176 = new Endereco(null, "Rua Mercúrio", "Jardim da Granja", "Sul", "12227530");
		Endereco rua3177 = new Endereco(null, "Avenida dos Tangarás", "Jardim Uirá", "Sul", "12227580");
		Endereco rua3178 = new Endereco(null, "Rua dos Macucos", "Jardim Uirá", "Sul", "12227590");
		Endereco rua3179 = new Endereco(null, "Rua das Tuíras", "Jardim Uirá", "Sul", "12227600");
		Endereco rua3180 = new Endereco(null, "Viela João Pereira da Silva", "Jardim Uirá", "Sul", "12227601");
		Endereco rua3181 = new Endereco(null, "Rua Sitio Bom Jesus", "Jardim Uirá", "Sul", "12227610");
		Endereco rua3182 = new Endereco(null, "Avenida das Curruiras", "Jardim Uirá", "Sul", "12227620");
		Endereco rua3183 = new Endereco(null, "Rua dos Canindés", "Jardim Uirá", "Sul", "12227621");
		Endereco rua3184 = new Endereco(null, "Rua dos Mutuns", "Jardim Uirá", "Sul", "12227630");
		Endereco rua3185 = new Endereco(null, "Rua das Jacutingas", "Jardim Uirá", "Sul", "12227640");
		Endereco rua3186 = new Endereco(null, "Rua dos Jaburus", "Jardim Uirá", "Sul", "12227650");
		Endereco rua3187 = new Endereco(null, "Praça Benedita Francisca da Rosa", "Jardim Uirá", "Sul", "12227651");
		Endereco rua3188 = new Endereco(null, "Rua Uiramiris", "Jardim Uirá", "Sul", "12227660");
		Endereco rua3189 = new Endereco(null, "Rua dos Socos", "Jardim Uirá", "Sul", "12227670");
		Endereco rua3190 = new Endereco(null, "Rua dos Cuitelos", "Jardim Uirá", "Sul", "12227680");
		Endereco rua3191 = new Endereco(null, "Rua dos Jaçanãs", "Jardim Uirá", "Sul", "12227690");
		Endereco rua3192 = new Endereco(null, "Rua dos Curiós", "Jardim Uirá", "Sul", "12227700");
		Endereco rua3193 = new Endereco(null, "Rua das Seriemas", "Jardim Uirá", "Sul", "12227710");
		Endereco rua3194 = new Endereco(null, "Avenida das Saíras", "Jardim Uirá", "Sul", "12227720");
		Endereco rua3195 = new Endereco(null, "Rua José Machado Faria", "Jardim Colorado", "Sul", "12227730");
		Endereco rua3196 = new Endereco(null, "Rua Cinco", "Jardim Colorado", "Sul", "12227733");
		Endereco rua3197 = new Endereco(null, "Rua Francisco Cipriano do Amaral", "Jardim Colorado", "Sul", "12227740");
		Endereco rua3198 = new Endereco(null, "Rua Tenente Benedito Dias Pereira", "Jardim Colorado", "Sul",
				"12227760");
		Endereco rua3199 = new Endereco(null, "Rua Professor Luiz Gonzaga Rios", "Jardim Colorado", "Sul", "12227771");
		Endereco rua3200 = new Endereco(null, "Avenida Um", "Jardim Uirá", "Sul", "12227802");
		Endereco rua3201 = new Endereco(null, "Avenida Brigadeiro Faria Lima", " 1758", "Jardim da Granja", "Sul");
		Endereco rua3202 = new Endereco(null, "Rua Umbelina Melo Romeu", "Jardim Santo Onofre", "Sul", "12228002");
		Endereco rua3203 = new Endereco(null, "Rua Norma Sueli Junqueira Pereira", "Jardim Santo Onofre", "Sul",
				"12228003");
		Endereco rua3204 = new Endereco(null, "Avenida Vicente Brandão Ferreira", "Jardim Santa Luzia", "Sul",
				"12228004");
		Endereco rua3205 = new Endereco(null, "Avenida Júlio Cezar Villaça", "Jardim Santa Luzia", "Sul", "12228005");
		Endereco rua3206 = new Endereco(null, "Rua Maria José Ribeiro", "Jardim Santo Onofre", "Sul", "12228006");
		Endereco rua3207 = new Endereco(null, "Rua Maria Amélia de Oliveira", "Jardim Santo Onofre", "Sul", "12228007");
		Endereco rua3208 = new Endereco(null, "Viela Albertina Constância Trindade", "Jardim Santo Onofre", "Sul",
				"12228008");
		Endereco rua3209 = new Endereco(null, "Rua Alberto Coltro", "Jardim Santo Onofre", "Sul", "12228009");
		Endereco rua3210 = new Endereco(null, "Rua Manabu Mabe", "Jardim Santo Onofre", "Sul", "12228011");
		Endereco rua3211 = new Endereco(null, "Rua Frederico Miacci Natalici", "Jardim Santo Onofre", "Sul",
				"12228012");
		Endereco rua3212 = new Endereco(null, "Rua Donatéllo Mammoli", "Jardim Santo Onofre", "Sul", "12228013");
		Endereco rua3213 = new Endereco(null, "Rua Maria de Lourdes de Andrade Coltro", "Jardim Santo Onofre", "Sul",
				"12228014");
		Endereco rua3214 = new Endereco(null, "Rua Luiza dos Santos Bernardes", "Jardim Santo Onofre", "Sul",
				"12228015");
		Endereco rua3215 = new Endereco(null, "Rua Irajá Andrade Santos", "Jardim Santo Onofre", "Sul", "12228016");
		Endereco rua3216 = new Endereco(null, "Viela José Siriaco da Silva", "Jardim Santo Onofre", "Sul", "12228017");
		Endereco rua3217 = new Endereco(null, "Rua José Ferreira de Lira", "Jardim Santo Onofre", "Sul", "12228018");
		Endereco rua3218 = new Endereco(null, "Viela Geralda da Silva de Oliveira", "Jardim Santo Onofre", "Sul",
				"12228019");
		Endereco rua3219 = new Endereco(null, "Avenida Visconde de Pelotas", "Jardim do Lago", "Sul", "12228020");
		Endereco rua3220 = new Endereco(null, "Praça Hélio de Souza Lino", "Jardim do Lago", "Sul", "12228023");
		Endereco rua3221 = new Endereco(null, "Rua Visconde de São Lourenço", "Jardim do Lago", "Sul", "12228030");
		Endereco rua3222 = new Endereco(null, "Rua Visconde de Lamare", "Jardim do Lago", "Sul", "12228040");
		Endereco rua3223 = new Endereco(null, "Avenida Visconde de Caravelas", "Jardim do Lago", "Sul", "12228050");
		Endereco rua3224 = new Endereco(null, "Rua Visconde de Araxá", "Jardim do Lago", "Sul", "12228060");
		Endereco rua3225 = new Endereco(null, "Rua Visconde de Inhauma", "Jardim do Lago", "Sul", "12228070");
		Endereco rua3226 = new Endereco(null, "Viela Leonardo Francisco dos Santos", "Jardim Santo Onofre", "Sul",
				"12228071");
		Endereco rua3227 = new Endereco(null, "Rua José Benedito Alves Cursino", "Jardim Santo Onofre", "Sul",
				"12228073");
		Endereco rua3228 = new Endereco(null, "Rua Artur Cursino", "Jardim Santo Onofre", "Sul", "12228075");
		Endereco rua3229 = new Endereco(null, "Rua Roberto Aparecido Cruz", "Jardim Santo Onofre", "Sul", "12228077");
		Endereco rua3230 = new Endereco(null, "Avenida José Ignacio Bicudo", "Jardim São Leopoldo", "Sul", "12228180");
		Endereco rua3231 = new Endereco(null, "Rua Alexandrino Machado", "Jardim São Leopoldo", "Sul", "12228181");
		Endereco rua3232 = new Endereco(null, "Rua Cesarina Rodrigues Eras Soares", "Jardim São Leopoldo", "Sul",
				"12228182");
		Endereco rua3233 = new Endereco(null, "Travessa Maria Alves Gonçalves", "Jardim São Leopoldo", "Sul",
				"12228184");
		Endereco rua3234 = new Endereco(null, "Viela Antônio Luiz da Silva", "Jardim São Leopoldo", "Sul", "12228186");
		Endereco rua3235 = new Endereco(null, "Viela Maria Alves Gonçalves", "Jardim São Leopoldo", "Sul", "12228188");
		Endereco rua3236 = new Endereco(null, "Avenida José Gonçalves de Campos", "Jardim São Leopoldo", "Sul",
				"12228190");
		Endereco rua3237 = new Endereco(null, "Rua Natalio Ângelo Stabeli", "Jardim São Leopoldo", "Sul", "12228191");
		Endereco rua3238 = new Endereco(null, "Rua Aníbal Berardinelli Tarantino", "Jardim São Leopoldo", "Sul",
				"12228200");
		Endereco rua3239 = new Endereco(null, "Rua Deolino Bueno de Camargo", "Jardim São Leopoldo", "Sul", "12228210");
		Endereco rua3240 = new Endereco(null, "Rua Maria Olímpia Rodrigues de Toledo", "Jardim São Leopoldo", "Sul",
				"12228220");
		Endereco rua3241 = new Endereco(null, "Rua Riva Idesis", "Jardim São Leopoldo", "Sul", "12228230");
		Endereco rua3242 = new Endereco(null, "Rua Moacir de Siqueira", "Jardim São Leopoldo", "Sul", "12228240");
		Endereco rua3243 = new Endereco(null, "Estrada Pernambucano", "Jardim São Leopoldo", "Sul", "12228250");
		Endereco rua3244 = new Endereco(null, "Avenida São Cristóvão", "Jardim São Judas Tadeu", "Sul", "12228260");
		Endereco rua3245 = new Endereco(null, "Praça Carla Marcela Pereira dos Santos", "Jardim São Judas Tadeu", "Sul",
				"12228267");
		Endereco rua3246 = new Endereco(null, "Rua São Tomé", "Jardim São Judas Tadeu", "Sul", "12228270");
		Endereco rua3247 = new Endereco(null, "Avenida Laudelino Gonçalves de Miranda", "Jardim Santa Júlia", "Sul",
				"12228271");
		Endereco rua3248 = new Endereco(null, "Avenida José Antônio Silvério", "Jardim Santa Júlia", "Sul", "12228272");
		Endereco rua3249 = new Endereco(null, "Avenida Maria Hipólita de Souza", "Jardim Santa Júlia", "Sul",
				"12228273");
		Endereco rua3250 = new Endereco(null, "Avenida Valter de Oliveira", "Jardim Santa Júlia", "Sul", "12228274");
		Endereco rua3251 = new Endereco(null, "Rua Sargento Antonio Celso de Souza", "Jardim Santa Júlia", "Sul",
				"12228275");
		Endereco rua3252 = new Endereco(null, "Rua Arlindo Flauzino Pereira", "Jardim Santa Júlia", "Sul", "12228276");
		Endereco rua3253 = new Endereco(null, "Rua Luiz Claudio Monteiro", "Jardim Santa Júlia", "Sul", "12228277");
		Endereco rua3254 = new Endereco(null, "Rua Albino Raimundo Nunes", "Jardim Santa Júlia", "Sul", "12228278");
		Endereco rua3255 = new Endereco(null, "Rua Joaquim Silvério Filho", "Jardim Santa Júlia", "Sul", "12228279");
		Endereco rua3256 = new Endereco(null, "Rua São Bento", "Jardim São Judas Tadeu", "Sul", "12228280");
		Endereco rua3257 = new Endereco(null, "Rua Luzia Griecco", "Jardim Santa Júlia", "Sul", "12228281");
		Endereco rua3258 = new Endereco(null, "Rua Cid Moreira Rangel", "Jardim Santa Júlia", "Sul", "12228282");
		Endereco rua3259 = new Endereco(null, "Rua Carlos Eduardo Godoi Dellu", "Jardim Santa Júlia", "Sul",
				"12228283");
		Endereco rua3260 = new Endereco(null, "Rua José Alencar Ribeiro", "Jardim Santa Júlia", "Sul", "12228284");
		Endereco rua3261 = new Endereco(null, "Rua dos Bombeiros", "Jardim Santa Júlia", "Sul", "12228285");
		Endereco rua3262 = new Endereco(null, "Rua Lázaro Inácio Ribeiro", "Jardim Santa Júlia", "Sul", "12228286");
		Endereco rua3263 = new Endereco(null, "Rua Aparecida Nogueira Rossi", "Jardim Santa Júlia", "Sul", "12228287");
		Endereco rua3264 = new Endereco(null, "Rua Miguel Batista Rangel", "Jardim Santa Júlia", "Sul", "12228288");
		Endereco rua3265 = new Endereco(null, "Rua Ricardo Sérgio Mimessi", "Jardim Santa Júlia", "Sul", "12228289");
		Endereco rua3266 = new Endereco(null, "Rua São Felipe", "Jardim São Judas Tadeu", "Sul", "12228290");
		Endereco rua3267 = new Endereco(null, "Rua Pedro Benedito Ferreira", "Jardim Santa Júlia", "Sul", "12228291");
		Endereco rua3268 = new Endereco(null, "Rua Galileu Lopes da Silva", "Jardim Santa Júlia", "Sul", "12228292");
		Endereco rua3269 = new Endereco(null, "Rua Cleide Veloso de Souza", "Jardim Santa Júlia", "Sul", "12228293");
		Endereco rua3270 = new Endereco(null, "Rua João Felix da Rosa", "Jardim Santa Júlia", "Sul", "12228294");
		Endereco rua3271 = new Endereco(null, "Rua Osvaldo da Graça Almeida Júnior", "Jardim Santa Júlia", "Sul",
				"12228295");
		Endereco rua3272 = new Endereco(null, "Rua Benedito Fernandes das Neves", "Jardim Santa Júlia", "Sul",
				"12228296");
		Endereco rua3273 = new Endereco(null, "Rua Aparecida Francisco Fávaro", "Jardim Santa Júlia", "Sul",
				"12228297");
		Endereco rua3274 = new Endereco(null, "Rua Doutor Roberto Fregoni", "Jardim Santa Júlia", "Sul", "12228298");
		Endereco rua3275 = new Endereco(null, "Rua Humberto Severo Miacci", "Jardim Santa Júlia", "Sul", "12228299");
		Endereco rua3276 = new Endereco(null, "Rua São Bartolomeu", "Jardim São Judas Tadeu", "Sul", "12228300");
		Endereco rua3277 = new Endereco(null, "Rua Pedro Alves Faria", "Jardim Santa Júlia", "Sul", "12228301");
		Endereco rua3278 = new Endereco(null, "Rua Nerval Monstans Costa", "Jardim Santa Júlia", "Sul", "12228302");
		Endereco rua3279 = new Endereco(null, "Rua Tadao Shinhe", "Jardim Santa Júlia", "Sul", "12228303");
		Endereco rua3280 = new Endereco(null, "Rua Francisco Pires de Moraes", "Jardim Santa Júlia", "Sul", "12228304");
		Endereco rua3281 = new Endereco(null, "Rua Aldo Moreira dos Santos", "Jardim Santa Júlia", "Sul", "12228305");
		Endereco rua3282 = new Endereco(null, "Rua Vinte e Nove", "Jardim Santa Júlia", "Sul", "12228306");
		Endereco rua3283 = new Endereco(null, "Rua Tereza do Espírito Santo da Paz", "Jardim Santa Júlia", "Sul",
				"12228307");
		Endereco rua3284 = new Endereco(null, "Rua Edezio Penellupi", "Jardim Santa Júlia", "Sul", "12228308");
		Endereco rua3285 = new Endereco(null, "Rua José Edvaldo Ramos", "Jardim Santa Júlia", "Sul", "12228309");
		Endereco rua3286 = new Endereco(null, "Rua São Vitalino", "Jardim São Judas Tadeu", "Sul", "12228310");
		Endereco rua3287 = new Endereco(null, "Rua Maria Rosa de Oliveira Silva", "Jardim Santa Júlia", "Sul",
				"12228311");
		Endereco rua3288 = new Endereco(null, "Rua Julia Batista da Silva", "Jardim Santa Júlia", "Sul", "12228312");
		Endereco rua3289 = new Endereco(null, "Rua Luiz Pereira Leite", "Jardim Santa Júlia", "Sul", "12228313");
		Endereco rua3290 = new Endereco(null, "Rua Maria Benedita", "Jardim Santa Júlia", "Sul", "12228314");
		Endereco rua3291 = new Endereco(null, "Rua Falec Rodrigues da Cunha", "Jardim Santa Júlia", "Sul", "12228315");
		Endereco rua3292 = new Endereco(null, "Rua Paulo Nunes dos Reis", "Jardim Santa Júlia", "Sul", "12228316");
		Endereco rua3293 = new Endereco(null, "Rua Luís José dos Santos", "Jardim Santa Júlia", "Sul", "12228317");
		Endereco rua3294 = new Endereco(null, "Rua Maria Apparecida Rodrigues", "Jardim Santa Júlia", "Sul",
				"12228318");
		Endereco rua3295 = new Endereco(null, "Rua João Soares dos Santos", "Jardim Santa Júlia", "Sul", "12228319");
		Endereco rua3296 = new Endereco(null, "Rua São Geraldo", "Jardim São Judas Tadeu", "Sul", "12228320");
		Endereco rua3297 = new Endereco(null, "Rua Sebastiana Francisca de Souza", "Jardim Santa Júlia", "Sul",
				"12228321");
		Endereco rua3298 = new Endereco(null, "Rua Rezende Alcalde", "Jardim Santa Júlia", "Sul", "12228322");
		Endereco rua3299 = new Endereco(null, "Avenida Jeanete Aparecida Silvério", "Jardim Santa Júlia", "Sul",
				"12228323");
		Endereco rua3300 = new Endereco(null, "Rua Terezinha Cezar de Souza", "Jardim Santa Júlia", "Sul", "12228324");
		Endereco rua3301 = new Endereco(null, "Rua Benedito Pinhal dos Anjos", "Jardim Santa Júlia", "Sul", "12228325");
		Endereco rua3302 = new Endereco(null, "Rua Maria Pompilio dos Santos", "Jardim Santa Júlia", "Sul", "12228326");
		Endereco rua3303 = new Endereco(null, "Rua Quarenta e Sete", "Jardim Santa Júlia", "Sul", "12228327");
		Endereco rua3304 = new Endereco(null, "Avenida Roberto Sebastião Consiglio", "Jardim Santa Júlia", "Sul",
				"12228328");
		Endereco rua3305 = new Endereco(null, "Rua São Teófilo", "Jardim São Judas Tadeu", "Sul", "12228330");
		Endereco rua3306 = new Endereco(null, "Avenida São Afonso Maria", "Jardim São Judas Tadeu", "Sul", "12228340");
		Endereco rua3307 = new Endereco(null, "Avenida São Jerônimo", "Jardim São Judas Tadeu", "Sul", "12228350");
		Endereco rua3308 = new Endereco(null, "Avenida São Francisco de Assis", "Jardim São Judas Tadeu", "Sul",
				"12228360");
		Endereco rua3309 = new Endereco(null, "Avenida São Vicente de Paulo", "Jardim São Judas Tadeu", "Sul",
				"12228370");
		Endereco rua3310 = new Endereco(null, "Rua Osberre Bassi", "Jardim São Judas Tadeu", "Sul", "12228371");
		Endereco rua3311 = new Endereco(null, "Praça Frei Galvão", "Jardim São Judas Tadeu", "Sul", "12228373");
		Endereco rua3312 = new Endereco(null, "Rua São Damião", "Jardim São Judas Tadeu", "Sul", "12228380");
		Endereco rua3313 = new Endereco(null, "Rua São Cosme", "Jardim São Judas Tadeu", "Sul", "12228390");
		Endereco rua3314 = new Endereco(null, "Rua São Germano", "Jardim São Judas Tadeu", "Sul", "12228400");
		Endereco rua3315 = new Endereco(null, "Rua Santa Rita de Cássia", "Jardim São Judas Tadeu", "Sul", "12228408");
		Endereco rua3316 = new Endereco(null, "Rua São Lucas", "Jardim São Judas Tadeu", "Sul", "12228410");
		Endereco rua3317 = new Endereco(null, "Rua São Gabriel", "Jardim São Judas Tadeu", "Sul", "12228411");
		Endereco rua3318 = new Endereco(null, "Rua Santa Mônica", "Jardim São Judas Tadeu", "Sul", "12228412");
		Endereco rua3319 = new Endereco(null, "Rua São Mateus", "Jardim São Judas Tadeu", "Sul", "12228420");
		Endereco rua3320 = new Endereco(null, "Rua Nossa Senhora Do Loretto", "Jardim São Judas Tadeu", "Sul",
				"12228422");
		Endereco rua3321 = new Endereco(null, "Rua B", "Jardim São Judas Tadeu", "Sul", "12228423");
		Endereco rua3322 = new Endereco(null, "Rua São Guido", "Jardim São Judas Tadeu", "Sul", "12228424");
		Endereco rua3323 = new Endereco(null, "Travessa Santa Paulina", "Jardim São Judas Tadeu", "Sul", "12228425");
		Endereco rua3324 = new Endereco(null, "Avenida São Nicolau", "Jardim São Judas Tadeu", "Sul", "12228430");
		Endereco rua3325 = new Endereco(null, "Rua São Tiago", "Jardim São Judas Tadeu", "Sul", "12228440");
		Endereco rua3326 = new Endereco(null, "Rua São Januário", "Jardim São Judas Tadeu", "Sul", "12228450");
		Endereco rua3327 = new Endereco(null, "Rua São Afonso Maria", "Jardim São Judas Tadeu", "Sul", "12228451");
		Endereco rua3328 = new Endereco(null, "Rua Henrique Bráulio de Melo Sobrinho", "Jardim Santa Luzia", "Sul",
				"12228850");
		Endereco rua3329 = new Endereco(null, "Rua Miguel Cunha Barbosa", "Jardim Santa Luzia", "Sul", "12228851");
		Endereco rua3330 = new Endereco(null, "Rua Gusmão Pinto da Cunha", "Jardim Santa Luzia", "Sul", "12228852");
		Endereco rua3331 = new Endereco(null, "Rua Graziela Café de Oliveira", "Jardim Santa Luzia", "Sul", "12228853");
		Endereco rua3332 = new Endereco(null, "Rua Confrade Nelson Pereira Lima", "Jardim Santa Luzia", "Sul",
				"12228854");
		Endereco rua3333 = new Endereco(null, "Rua Professora Terezinha de Jesus Alves da Silva Vadô",
				"Jardim Santa Luzia", "Sul", "12228855");
		Endereco rua3334 = new Endereco(null, "Rua Teresa Antonio", "Jardim Santa Luzia", "Sul", "12228856");
		Endereco rua3335 = new Endereco(null, "Rua Américo Filipe de Azevedo", "Jardim Santa Luzia", "Sul", "12228857");
		Endereco rua3336 = new Endereco(null, "Rua José Benedito de Almeida Pena", "Jardim Santa Luzia", "Sul",
				"12228858");
		Endereco rua3337 = new Endereco(null, "Rua Juvenal Agostinho da Cunha", "Jardim Santa Luzia", "Sul",
				"12228859");
		Endereco rua3338 = new Endereco(null, "Rua Ana Lúcia Cherubini e Silva", "Jardim Santa Luzia", "Sul",
				"12228860");
		Endereco rua3339 = new Endereco(null, "Rua Djalma Sebastião Henze Alves", "Jardim Santa Luzia", "Sul",
				"12228861");
		Endereco rua3340 = new Endereco(null, "Rua Benedito Antônio Liesack da Cunha", "Jardim Santa Luzia", "Sul",
				"12228862");
		Endereco rua3341 = new Endereco(null, "Rua Ida do Nascimento", "Jardim Santa Luzia", "Sul", "12228863");
		Endereco rua3342 = new Endereco(null, "Rua José da Cunha", "Jardim Santa Luzia", "Sul", "12228864");
		Endereco rua3343 = new Endereco(null, "Rua Dezessete", "Jardim Santa Luzia", "Sul", "12228865");
		Endereco rua3344 = new Endereco(null, "Rua Benedito Rodrigues Moreira", "Jardim Santa Luzia", "Sul",
				"12228866");
		Endereco rua3345 = new Endereco(null, "Rua Antonio Germano dos Santos", "Jardim Santa Luzia", "Sul",
				"12228867");
		Endereco rua3346 = new Endereco(null, "Avenida Nadyr Mota Cortês", "Jardim Santa Rosa", "Sul", "12228870");
		Endereco rua3347 = new Endereco(null, "Rua Paulo Sérgio Kacuta", "Jardim Santa Rosa", "Sul", "12228872");
		Endereco rua3348 = new Endereco(null, "Rua Abel de Paula", "Jardim Santa Rosa", "Sul", "12228874");
		Endereco rua3349 = new Endereco(null, "Rua José de Oliveira Rocha", "Jardim Santa Rosa", "Sul", "12228876");
		Endereco rua3350 = new Endereco(null, "Rua Sebastião Ricardo Filho", "Jardim Santa Rosa", "Sul", "12228878");
		Endereco rua3351 = new Endereco(null, "Rua Mogi-Mirim", "Jardim Santa Rosa", "Sul", "12228880");
		Endereco rua3352 = new Endereco(null, "Rua Herotildes Ramos", "Jardim Santa Rosa", "Sul", "12228882");
		Endereco rua3353 = new Endereco(null, "Rua Ana Maria de Jesus Lúcio", "Jardim Santa Rosa", "Sul", "12228884");
		Endereco rua3354 = new Endereco(null, "Rua Josildo Arnulfo dos Santos", "Jardim Santa Rosa", "Sul", "12228886");
		Endereco rua3355 = new Endereco(null, "Rua João Batista Cabral", "Jardim Santa Rosa", "Sul", "12228888");
		Endereco rua3356 = new Endereco(null, "Rua Alex Daniel de Souza", "Jardim Santa Rosa", "Sul", "12228890");
		Endereco rua3357 = new Endereco(null, "Rua João Silva de Aguiar", "Jardim Santa Rosa", "Sul", "12228892");
		Endereco rua3358 = new Endereco(null, "Rua Hilda Roda de Jesus", "Jardim Santa Rosa", "Sul", "12228894");
		Endereco rua3359 = new Endereco(null, "Rua Maria Aparecida Martins", "Jardim Santa Rosa", "Sul", "12228896");
		Endereco rua3360 = new Endereco(null, "Rua Nelsidio Felix", "Jardim Santa Rosa", "Sul", "12228897");
		Endereco rua3361 = new Endereco(null, "Rua Engenheiro Demilton Floriano Teixeira", "Jardim Santa Rosa", "Sul",
				"12228898");
		Endereco rua3362 = new Endereco(null, "Avenida Nicanor Reis", "Jardim Torrão de Ouro", "Sul", "12229000");
		Endereco rua3363 = new Endereco(null, "Rua Ubirajara Raimundo de Souza", "Jardim Torrão de Ouro", "Sul",
				"12229001");
		Endereco rua3364 = new Endereco(null, "Viela Benedita da Silva Dantas", "Jardim Torrão de Ouro", "Sul",
				"12229002");
		Endereco rua3365 = new Endereco(null, "Rua Ana Elisabete Martinelli Godinho", "Jardim Torrão de Ouro", "Sul",
				"12229003");
		Endereco rua3366 = new Endereco(null, "Rua Verona", "Jardim Mesquita", "Sul", "12229004");
		Endereco rua3367 = new Endereco(null, "Travessa Quatro", "Jardim Torrão de Ouro", "Sul", "12229005");
		Endereco rua3368 = new Endereco(null, "Travessa Um", "Jardim Torrão de Ouro", "Sul", "12229006");
		Endereco rua3369 = new Endereco(null, "Travessa Dois", "Jardim Torrão de Ouro", "Sul", "12229007");
		Endereco rua3370 = new Endereco(null, "Praça Gunther Zolko", "Jardim Torrão de Ouro", "Sul", "12229008");
		Endereco rua3371 = new Endereco(null, "Travessa Três", "Jardim Torrão de Ouro", "Sul", "12229009");
		Endereco rua3372 = new Endereco(null, "Rua Waldemar Teixeira", "Jardim Torrão de Ouro", "Sul", "12229010");
		Endereco rua3373 = new Endereco(null, "Rua Rogério Monteiro", "Jardim Torrão de Ouro", "Sul", "12229020");
		Endereco rua3374 = new Endereco(null, "Rua José Lopes de Oliveira Filho", "Jardim Torrão de Ouro", "Sul",
				"12229030");
		Endereco rua3375 = new Endereco(null, "Rua Honório Pereira da Silva", "Jardim Torrão de Ouro", "Sul",
				"12229040");
		Endereco rua3376 = new Endereco(null, "Rua Benedito Machado de Arantes", "Jardim Torrão de Ouro", "Sul",
				"12229050");
		Endereco rua3377 = new Endereco(null, "Rua Fernando Sacilotti", "Jardim Torrão de Ouro", "Sul", "12229060");
		Endereco rua3378 = new Endereco(null, "Rua Roberto Rossi", "Jardim Torrão de Ouro", "Sul", "12229070");
		Endereco rua3379 = new Endereco(null, "Rua Professor João Luiz Galvão Ribeiro", "Jardim Torrão de Ouro", "Sul",
				"12229080");
		Endereco rua3380 = new Endereco(null, "Rua Agenor de Oliveira", "Jardim Torrão de Ouro", "Sul", "12229090");
		Endereco rua3381 = new Endereco(null, "Rua Trindade Monteiro de Oliveira", "Jardim Torrão de Ouro", "Sul",
				"12229100");
		Endereco rua3382 = new Endereco(null, "Rua Vicente Pavanelli", "Jardim Torrão de Ouro", "Sul", "12229110");
		Endereco rua3383 = new Endereco(null, "Rua Wlamir Rogério Friggi", "Jardim Torrão de Ouro", "Sul", "12229120");
		Endereco rua3384 = new Endereco(null, "Rua Antônio Boarini", "Jardim Torrão de Ouro", "Sul", "12229130");
		Endereco rua3385 = new Endereco(null, "Rua Olavo Augusto Andrade", "Jardim Torrão de Ouro", "Sul", "12229135");
		Endereco rua3386 = new Endereco(null, "Rua Roberto Verdussen", "Jardim Torrão de Ouro", "Sul", "12229140");
		Endereco rua3387 = new Endereco(null, "Rua Oscar Florentino", "Jardim Torrão de Ouro", "Sul", "12229150");
		Endereco rua3388 = new Endereco(null, "Rua Cid Morel", "Jardim Torrão de Ouro", "Sul", "12229155");
		Endereco rua3389 = new Endereco(null, "Rua Mikolaj Torba", "Jardim Torrão de Ouro", "Sul", "12229160");
		Endereco rua3390 = new Endereco(null, "Praça Luiz Carlos Martins", "Jardim Torrão de Ouro", "Sul", "12229165");
		Endereco rua3391 = new Endereco(null, "Rua José Honório Ribeiro", "Jardim Torrão de Ouro", "Sul", "12229170");
		Endereco rua3392 = new Endereco(null, "Rua Tereza de Jesus Silva", "Jardim Torrão de Ouro", "Sul", "12229180");
		Endereco rua3393 = new Endereco(null, "Rua Professora Joana de Camargo Fonseca", "Jardim Torrão de Ouro", "Sul",
				"12229190");
		Endereco rua3394 = new Endereco(null, "Rua Ruy Jacques de Moraes", "Jardim Torrão de Ouro", "Sul", "12229200");
		Endereco rua3395 = new Endereco(null, "Rua Danilo Monteiro", "Jardim Torrão de Ouro", "Sul", "12229210");
		Endereco rua3396 = new Endereco(null, "Rua Pedro Gonçalves Reis", "Jardim Torrão de Ouro", "Sul", "12229220");
		Endereco rua3397 = new Endereco(null, "Rua José Cândido de Oliveira", "Jardim Torrão de Ouro", "Sul",
				"12229221");
		Endereco rua3398 = new Endereco(null, "Rua Renato Costa Rodrigues", "Jardim Torrão de Ouro", "Sul", "12229230");
		Endereco rua3399 = new Endereco(null, "Rua Doutor Raphael Faro Netto", "Jardim Torrão de Ouro", "Sul",
				"12229240");
		Endereco rua3400 = new Endereco(null, "Rua José Roberto Joaquim", "Jardim Torrão de Ouro", "Sul", "12229250");
		Endereco rua3401 = new Endereco(null, "Rua Vicente Cardoso", "Jardim Torrão de Ouro", "Sul", "12229260");
		Endereco rua3402 = new Endereco(null, "Rua Manoel de Souza Peixoto", "Jardim Torrão de Ouro", "Sul",
				"12229270");
		Endereco rua3403 = new Endereco(null, "Rua Annibal Lopes Simões", "Jardim Torrão de Ouro", "Sul", "12229280");
		Endereco rua3404 = new Endereco(null, "Rua Doutor José Ferreira Guimarães", "Jardim Torrão de Ouro", "Sul",
				"12229290");
		Endereco rua3405 = new Endereco(null, "Rua Getúlio Vargas de Araújo", "Jardim Torrão de Ouro", "Sul",
				"12229291");
		Endereco rua3406 = new Endereco(null, "Rua Dinamérico Trombeta", "Jardim Torrão de Ouro", "Sul", "12229310");
		Endereco rua3407 = new Endereco(null, "Travessa dos Coqueiros", "Jardim Torrão de Ouro", "Sul", "12229316");
		Endereco rua3408 = new Endereco(null, "Rua dos Pinheiros", "Jardim Torrão de Ouro", "Sul", "12229318");
		Endereco rua3409 = new Endereco(null, "Rua Engenheiro José Ricardo Daniel", "Jardim Torrão de Ouro", "Sul",
				"12229320");
		Endereco rua3410 = new Endereco(null, "Rua Luiz Roberto Rodrigues", "Jardim Torrão de Ouro", "Sul", "12229330");
		Endereco rua3411 = new Endereco(null, "Rua Domilheta de Morais", "Jardim Torrão de Ouro", "Sul", "12229340");
		Endereco rua3412 = new Endereco(null, "Rua Elizabeth Avelino Muniz", "Jardim Torrão de Ouro", "Sul",
				"12229350");
		Endereco rua3413 = new Endereco(null, "Rua Antenor Paglione", "Jardim Torrão de Ouro", "Sul", "12229360");
		Endereco rua3414 = new Endereco(null, "Rua Alexandre Teodoro Eras", "Jardim Torrão de Ouro", "Sul", "12229370");
		Endereco rua3415 = new Endereco(null, "Estrada Doutor Bezerra de Menezes", "Jardim Torrão de Ouro", "Sul",
				"12229380");
		Endereco rua3416 = new Endereco(null, "Rua Turim", "Jardim Mesquita", "Sul", "12229381");
		Endereco rua3417 = new Endereco(null, "Rua Blumenau", "Jardim Mesquita", "Sul", "12229382");
		Endereco rua3418 = new Endereco(null, "Rua João Miacci", "Jardim Torrão de Ouro", "Sul", "12229391");
		Endereco rua3419 = new Endereco(null, "Rua Barcelona", "Jardim Mesquita", "Sul", "12229490");
		Endereco rua3420 = new Endereco(null, "Rua Veneza", "Jardim Mesquita", "Sul", "12229500");
		Endereco rua3421 = new Endereco(null, "Rua Aurora de Paula Ribeiro", "Jardim Torrão de Ouro", "Sul",
				"12229813");
		Endereco rua3422 = new Endereco(null, "Rua Benedito Procópio dos Santos", "Jardim Torrão de Ouro", "Sul",
				"12229816");
		Endereco rua3423 = new Endereco(null, "Rua Dias Gomes", "Jardim Torrão de Ouro", "Sul", "12229821");
		Endereco rua3424 = new Endereco(null, "Rua José Nunes de Figueiredo", "Jardim Torrão de Ouro", "Sul",
				"12229830");
		Endereco rua3425 = new Endereco(null, "Rua Elza Silva de Figueiredo", "Jardim Torrão de Ouro", "Sul",
				"12229831");
		Endereco rua3426 = new Endereco(null, "Rua Maria Helena da Silva", "Jardim Torrão de Ouro", "Sul", "12229833");
		Endereco rua3427 = new Endereco(null, "Rua Luiz Veneziani", "Jardim Torrão de Ouro", "Sul", "12229834");
		Endereco rua3428 = new Endereco(null, "Rua Corina Pedrosa Púpio", "Jardim Torrão de Ouro", "Sul", "12229835");
		Endereco rua3429 = new Endereco(null, "Avenida Andrômeda", "Jardim Satélite", "Sul", "12230000");
		Endereco rua3430 = new Endereco(null, "Avenida Andrômeda", "Jardim Satélite", "Sul", "12230001");
		Endereco rua3431 = new Endereco(null, "Rodovia Presidente Dutra", "Jardim Satélite", "Sul", "12230002");
		Endereco rua3432 = new Endereco(null, "Avenida Cassiopéia", "Jardim Satélite", "Sul", "12230010");
		Endereco rua3433 = new Endereco(null, "Avenida Cassiopéia", "Jardim Satélite", "Sul", "12230011");
		Endereco rua3434 = new Endereco(null, "Rua Tijuca", "Jardim Satélite", "Sul", "12230020");
		Endereco rua3435 = new Endereco(null, "Rua Leblon", "Jardim Satélite", "Sul", "12230021");
		Endereco rua3436 = new Endereco(null, "Rua Copacabana", "Jardim Satélite", "Sul", "12230030");
		Endereco rua3437 = new Endereco(null, "Rua Arpoador", "Jardim Satélite", "Sul", "12230040");
		Endereco rua3438 = new Endereco(null, "Rua Reverendo Américo de Castro", "Jardim Satélite", "Sul", "12230050");
		Endereco rua3439 = new Endereco(null, "Rua Porto Novo", "Jardim Satélite", "Sul", "12230060");
		Endereco rua3440 = new Endereco(null, "Rua Ipanema", "Jardim Satélite", "Sul", "12230070");
		Endereco rua3441 = new Endereco(null, "Rua Pedro Tursi", "Jardim Satélite", "Sul", "12230075");
		Endereco rua3442 = new Endereco(null, "Rua Patrício Santana", "Jardim Satélite", "Sul", "12230080");
		Endereco rua3443 = new Endereco(null, "Rua Maricá", "Jardim Satélite", "Sul", "12230100");
		Endereco rua3444 = new Endereco(null, "Rua Barra Velha", "Jardim Satélite", "Sul", "12230110");
		Endereco rua3445 = new Endereco(null, "Rua Lagoinha", "Jardim Satélite", "Sul", "12230111");
		Endereco rua3446 = new Endereco(null, "Rua das Cigarras", "Jardim Satélite", "Sul", "12230120");
		Endereco rua3447 = new Endereco(null, "Rua Bambui", "Jardim Satélite", "Sul", "12230130");
		Endereco rua3448 = new Endereco(null, "Rua Cisne", "Jardim Satélite", "Sul", "12230140");
		Endereco rua3449 = new Endereco(null, "Rua Sapoti", "Jardim Satélite", "Sul", "12230150");
		Endereco rua3450 = new Endereco(null, "Rua Regulus", "Jardim Satélite", "Sul", "12230160");
		Endereco rua3451 = new Endereco(null, "Rua Tucuma", "Jardim Satélite", "Sul", "12230170");
		Endereco rua3452 = new Endereco(null, "Rua Gemini", "Jardim Satélite", "Sul", "12230180");
		Endereco rua3453 = new Endereco(null, "Rua Procion", "Jardim Satélite", "Sul", "12230190");
		Endereco rua3454 = new Endereco(null, "Rua Arturus", "Jardim Satélite", "Sul", "12230200");
		Endereco rua3455 = new Endereco(null, "Rua Aires", "Jardim Satélite", "Sul", "12230210");
		Endereco rua3456 = new Endereco(null, "Rua Libra", "Jardim Satélite", "Sul", "12230220");
		Endereco rua3457 = new Endereco(null, "Rua Altair", "Jardim Satélite", "Sul", "12230230");
		Endereco rua3458 = new Endereco(null, "Rua Polar", "Jardim Satélite", "Sul", "12230240");
		Endereco rua3459 = new Endereco(null, "Rua Antares", "Jardim Satélite", "Sul", "12230250");
		Endereco rua3460 = new Endereco(null, "Rua Pegaso", "Jardim Satélite", "Sul", "12230260");
		Endereco rua3461 = new Endereco(null, "Rua Carangola", "Jardim Satélite", "Sul", "12230270");
		Endereco rua3462 = new Endereco(null, "Rua Sirius", "Jardim Satélite", "Sul", "12230280");
		Endereco rua3463 = new Endereco(null, "Rua Andaraí", "Jardim Satélite", "Sul", "12230290");
		Endereco rua3464 = new Endereco(null, "Avenida Doutor Sebastião Henrique da Cunha Pontes", "Jardim Satélite",
				"Sul", "12230300");
		Endereco rua3465 = new Endereco(null, "Rua Pleiades", "Jardim Satélite", "Sul", "12230310");
		Endereco rua3466 = new Endereco(null, "Rua Castor", "Jardim Satélite", "Sul", "12230320");
		Endereco rua3467 = new Endereco(null, "Rua Auriflama", "Jardim Satélite", "Sul", "12230330");
		Endereco rua3468 = new Endereco(null, "Rua Gravataí", "Jardim Satélite", "Sul", "12230340");
		Endereco rua3469 = new Endereco(null, "Travessa Pirituba", "Jardim Satélite", "Sul", "12230341");
		Endereco rua3470 = new Endereco(null, "Rua Araribóia", "Jardim Satélite", "Sul", "12230350");
		Endereco rua3471 = new Endereco(null, "Rua Boituva", "Jardim Satélite", "Sul", "12230351");
		Endereco rua3472 = new Endereco(null, "Rua Apeninos", "Jardim Satélite", "Sul", "12230360");
		Endereco rua3473 = new Endereco(null, "Rua Pollux", "Jardim Satélite", "Sul", "12230370");
		Endereco rua3474 = new Endereco(null, "Rua Auriga", "Jardim Satélite", "Sul", "12230380");
		Endereco rua3475 = new Endereco(null, "Rua Eridanus", "Jardim Satélite", "Sul", "12230390");
		Endereco rua3476 = new Endereco(null, "Rua Aldebaram", "Jardim Satélite", "Sul", "12230400");
		Endereco rua3477 = new Endereco(null, "Rua Delfim", "Jardim Satélite", "Sul", "12230410");
		Endereco rua3478 = new Endereco(null, "Rua Virgem", "Jardim Satélite", "Sul", "12230420");
		Endereco rua3479 = new Endereco(null, "Rua Vega", "Jardim Satélite", "Sul", "12230430");
		Endereco rua3480 = new Endereco(null, "Rua Carina", "Jardim Satélite", "Sul", "12230440");
		Endereco rua3481 = new Endereco(null, "Rua Draco", "Jardim Satélite", "Sul", "12230450");
		Endereco rua3482 = new Endereco(null, "Rua Canopus", "Jardim Satélite", "Sul", "12230460");
		Endereco rua3483 = new Endereco(null, "Avenida Perseu", "Jardim Satélite", "Sul", "12230470");
		Endereco rua3484 = new Endereco(null, "Rua Estrela Dalva", "Jardim Satélite", "Sul", "12230480");
		Endereco rua3485 = new Endereco(null, "Rua Volans", "Jardim Satélite", "Sul", "12230490");
		Endereco rua3486 = new Endereco(null, "Praça Arlindo Fernandes", "Jardim Satélite", "Sul", "12230491");
		Endereco rua3487 = new Endereco(null, "Praça Pireu", "Jardim Satélite", "Sul", "12230492");
		Endereco rua3488 = new Endereco(null, "Rua Botelhos", "Jardim Satélite", "Sul", "12230493");
		Endereco rua3489 = new Endereco(null, "Rua Caeté", "Jardim Satélite", "Sul", "12230494");
		Endereco rua3490 = new Endereco(null, "Rua Galícia", "Jardim Satélite", "Sul", "12230500");
		Endereco rua3491 = new Endereco(null, "Avenida Urupês", "Jardim Satélite", "Sul", "12230510");
		Endereco rua3492 = new Endereco(null, "Rua Licorne", "Jardim Satélite", "Sul", "12230520");
		Endereco rua3493 = new Endereco(null, "Rua Scutum", "Jardim Satélite", "Sul", "12230530");
		Endereco rua3494 = new Endereco(null, "Rua Brasópolis", "Jardim Satélite", "Sul", "12230531");
		Endereco rua3495 = new Endereco(null, "Praça Deolinda de Abreu Lima", "Jardim Satélite", "Sul", "12230532");
		Endereco rua3496 = new Endereco(null, "Rua Pisces", "Jardim Satélite", "Sul", "12230540");
		Endereco rua3497 = new Endereco(null, "Rua Crater", "Jardim Satélite", "Sul", "12230550");
		Endereco rua3498 = new Endereco(null, "Rua Cotegipe", "Jardim Satélite", "Sul", "12230551");
		Endereco rua3499 = new Endereco(null, "Rua Galgos", "Jardim Satélite", "Sul", "12230560");
		Endereco rua3500 = new Endereco(null, "Rua Scorpius", "Jardim Satélite", "Sul", "12230570");
		Endereco rua3501 = new Endereco(null, "Rua Cataguazes", "Jardim Satélite", "Sul", "12230571");
		Endereco rua3502 = new Endereco(null, "Rua Marcabe", "Jardim Satélite", "Sul", "12230580");
		Endereco rua3503 = new Endereco(null, "Rua Scultor", "Jardim Satélite", "Sul", "12230590");
		Endereco rua3504 = new Endereco(null, "Rua Lira", "Jardim Satélite", "Sul", "12230600");
		Endereco rua3505 = new Endereco(null, "Rua Cefeu", "Jardim Satélite", "Sul", "12230610");
		Endereco rua3506 = new Endereco(null, "Rua Hiades", "Jardim Satélite", "Sul", "12230611");
		Endereco rua3507 = new Endereco(null, "Rua Bogari", "Jardim Satélite", "Sul", "12230612");
		Endereco rua3508 = new Endereco(null, "Rua Leão", "Jardim Satélite", "Sul", "12230620");
		Endereco rua3509 = new Endereco(null, "Praça Cândido Bertolini", "Jardim Satélite", "Sul", "12230621");
		Endereco rua3510 = new Endereco(null, "Rua Enseada", "Jardim Satélite", "Sul", "12230630");
		Endereco rua3511 = new Endereco(null, "Rua Cocanha", "Jardim Satélite", "Sul", "12230640");
		Endereco rua3512 = new Endereco(null, "Rua Massaguacu", "Jardim Satélite", "Sul", "12230650");
		Endereco rua3513 = new Endereco(null, "Rua Itambé", "Jardim Satélite", "Sul", "12230660");
		Endereco rua3514 = new Endereco(null, "Rua Nazaré", "Jardim Satélite", "Sul", "12230670");
		Endereco rua3515 = new Endereco(null, "Rua Maranduba", "Jardim Satélite", "Sul", "12230680");
		Endereco rua3516 = new Endereco(null, "Rua Martim de Sá", "Jardim Satélite", "Sul", "12230690");
		Endereco rua3517 = new Endereco(null, "Rua Iporanga", "Jardim Satélite", "Sul", "12230700");
		Endereco rua3518 = new Endereco(null, "Rua Bertioga", "Jardim Satélite", "Sul", "12230710");
		Endereco rua3519 = new Endereco(null, "Avenida Iguape", "Jardim Satélite", "Sul", "12230720");
		Endereco rua3520 = new Endereco(null, "Rua Cedral", "Jardim Satélite", "Sul", "12230730");
		Endereco rua3521 = new Endereco(null, "Rua Itapetinga", "Jardim Satélite", "Sul", "12230740");
		Endereco rua3522 = new Endereco(null, "Rua Ipiau", "Jardim Satélite", "Sul", "12230750");
		Endereco rua3523 = new Endereco(null, "Rua Buerarema", "Jardim Satélite", "Sul", "12230760");
		Endereco rua3524 = new Endereco(null, "Rua Ilhéus", "Jardim Satélite", "Sul", "12230770");
		Endereco rua3525 = new Endereco(null, "Rua Jequie", "Jardim Satélite", "Sul", "12230780");
		Endereco rua3526 = new Endereco(null, "Rua Itabuna", "Jardim Satélite", "Sul", "12230790");
		Endereco rua3527 = new Endereco(null, "Rua Cabo Frio", "Jardim Satélite", "Sul", "12230800");
		Endereco rua3528 = new Endereco(null, "Rua Itapoã", "Jardim Satélite", "Sul", "12230810");
		Endereco rua3529 = new Endereco(null, "Rua Pituba", "Jardim Satélite", "Sul", "12230820");
		Endereco rua3530 = new Endereco(null, "Rua Cruzália", "Jardim Satélite", "Sul", "12230830");
		Endereco rua3531 = new Endereco(null, "Rua Leticia", "Jardim Satélite", "Sul", "12230840");
		Endereco rua3532 = new Endereco(null, "Rua Antônio Ferro", "Jardim Satélite", "Sul", "12230841");
		Endereco rua3533 = new Endereco(null, "Rua Araxá", "Jardim Satélite", "Sul", "12230842");
		Endereco rua3534 = new Endereco(null, "Rua Benedito Ivo Filho", "Jardim Satélite", "Sul", "12230843");
		Endereco rua3535 = new Endereco(null, "Rua Ceteus", "Jardim Satélite", "Sul", "12230844");
		Endereco rua3536 = new Endereco(null, "Rua Coronel Delfino Ramos", "Jardim Satélite", "Sul", "12230845");
		Endereco rua3537 = new Endereco(null, "Rua Humberto Pinotti", "Jardim Satélite", "Sul", "12230846");
		Endereco rua3538 = new Endereco(null, "Rua Pedro Tursi", " 200", "Jardim Satélite", "Sul");
		Endereco rua3539 = new Endereco(null, "Rua Porto Novo", " 300", "Jardim Satélite", "Sul");
		Endereco rua3540 = new Endereco(null, "Rua Porto Novo", " 40", "Jardim Satélite", "Sul");
		Endereco rua3541 = new Endereco(null, "Rua Porto Novo", " 220", "Jardim Satélite", "Sul");
		Endereco rua3542 = new Endereco(null, "Rua Antares", " 115", "Jardim Satélite", "Sul");
		Endereco rua3543 = new Endereco(null, "Rua Polar", " 20", "Jardim Satélite", "Sul");
		Endereco rua3544 = new Endereco(null, "Avenida Andrômeda", " 287", "Jardim Satélite", "Sul");
		Endereco rua3545 = new Endereco(null, "Avenida Perseu", " 683", "Jardim Satélite", "Sul");
		Endereco rua3546 = new Endereco(null, "Avenida Andrômeda", " 1469", "Jardim Satélite", "Sul");
		Endereco rua3547 = new Endereco(null, "Rua Noruega", "Jardim Aeroporto", "Sul", "12231140");
		Endereco rua3548 = new Endereco(null, "Rua Letônia", "Jardim Aeroporto", "Sul", "12231150");
		Endereco rua3549 = new Endereco(null, "Rua Estônia", "Jardim Aeroporto", "Sul", "12231160");
		Endereco rua3550 = new Endereco(null, "Avenida Governador Mário Covas Júnior", "Jardim Aeroporto", "Sul",
				"12231168");
		Endereco rua3551 = new Endereco(null, "Rua Finlândia", "Jardim Aeroporto", "Sul", "12231170");
		Endereco rua3552 = new Endereco(null, "Rua Dinamarca", "Jardim Aeroporto", "Sul", "12231200");
		Endereco rua3553 = new Endereco(null, "Rua Talim", "Jardim Aeroporto", "Sul", "12231280");
		Endereco rua3554 = new Endereco(null, "Praça Professor José Vieira de Macedo", "Jardim Aeroporto", "Sul",
				"12231281");
		Endereco rua3555 = new Endereco(null, "Rua Dublim", "Jardim Aeroporto", "Sul", "12231300");
		Endereco rua3556 = new Endereco(null, "Avenida Um", "Jardim Aeroporto", "Sul", "12231301");
		Endereco rua3557 = new Endereco(null, "Rua Osvaldo Macedo Lecques", "Jardim Satélite", "Sul", "12231610");
		Endereco rua3558 = new Endereco(null, "Rua Luiz Gonzaga Sendretti", "Jardim Satélite", "Sul", "12231630");
		Endereco rua3559 = new Endereco(null, "Rua Pedro Martins de Toledo", "Jardim Satélite", "Sul", "12231640");
		Endereco rua3560 = new Endereco(null, "Rua Vasomiro Malaquias de Barros", "Jardim Satélite", "Sul", "12231642");
		Endereco rua3561 = new Endereco(null, "Rua Antônio Aleixo da Silva", "Jardim Satélite", "Sul", "12231650");
		Endereco rua3562 = new Endereco(null, "Rua Zacarias Silva", "Jardim Satélite", "Sul", "12231660");
		Endereco rua3563 = new Endereco(null, "Rua Antônio Joaquim de Alvarenga", "Jardim Satélite", "Sul", "12231670");
		Endereco rua3564 = new Endereco(null, "Avenida Cidade Jardim", "Jardim Satélite", "Sul", "12231675");
		Endereco rua3565 = new Endereco(null, "Rua Antônio Constantino", "Jardim Satélite", "Sul", "12231680");
		Endereco rua3566 = new Endereco(null, "Rua Mário Alves de Almeida", "Jardim Satélite", "Sul", "12231690");
		Endereco rua3567 = new Endereco(null, "Rua Demétrio Diacov", "Jardim Satélite", "Sul", "12231700");
		Endereco rua3568 = new Endereco(null, "Avenida Papa João Paulo I", "Jardim Satélite", "Sul", "12231710");
		Endereco rua3569 = new Endereco(null, "Rua Osvaldo Faria", "Jardim Satélite", "Sul", "12231720");
		Endereco rua3570 = new Endereco(null, "Rua Adolpho Castanho", "Jardim Satélite", "Sul", "12231730");
		Endereco rua3571 = new Endereco(null, "Rua Cesarina Della Dea Betti", "Jardim Satélite", "Sul", "12231740");
		Endereco rua3572 = new Endereco(null, "Rua Benedito Alves Moreira", "Jardim Satélite", "Sul", "12231750");
		Endereco rua3573 = new Endereco(null, "Rua Margarida F. dos Santos", "Jardim Satélite", "Sul", "12231760");
		Endereco rua3574 = new Endereco(null, "Rua Jaime Martins Xavier", "Jardim Satélite", "Sul", "12231770");
		Endereco rua3575 = new Endereco(null, "Rua Delfino Alves dos Santos", "Jardim Satélite", "Sul", "12231780");
		Endereco rua3576 = new Endereco(null, "Rua Avelina Faria Cursino", "Jardim Satélite", "Sul", "12231790");
		Endereco rua3577 = new Endereco(null, "Rua Marco Antônio dos Santos", "Jardim Satélite", "Sul", "12231800");
		Endereco rua3578 = new Endereco(null, "Rua José Guilherme de Almeida", "Jardim Satélite", "Sul", "12231810");
		Endereco rua3579 = new Endereco(null, "Rua Maria Asdente Rosin", "Jardim Satélite", "Sul", "12231814");
		Endereco rua3580 = new Endereco(null, "Rua Nelson Augusto Dalprat", "Jardim Satélite", "Sul", "12231815");
		Endereco rua3581 = new Endereco(null, "Rua Léa Maria Brandão Russo", "Jardim Satélite", "Sul", "12231820");
		Endereco rua3582 = new Endereco(null, "Rua José Pedro Perotti", "Jardim Satélite", "Sul", "12231830");
		Endereco rua3583 = new Endereco(null, "Avenida Papa João Paulo I", " 501", "Jardim Satélite", "Sul");
		Endereco rua3584 = new Endereco(null, "Avenida Cidade Jardim", " 2261", "Jardim Satélite", "Sul");
		Endereco rua3585 = new Endereco(null, "Avenida Cidade Jardim", "Jardim Portugal", "Sul", "12232000");
		Endereco rua3586 = new Endereco(null, "Rua Zildo Pimentel", "Jardim Estoril", "Sul", "12232010");
		Endereco rua3587 = new Endereco(null, "Rua José Firmino de Moraes", "Jardim Estoril", "Sul", "12232020");
		Endereco rua3588 = new Endereco(null, "Rua Paulino Blair", "Jardim Estoril", "Sul", "12232030");
		Endereco rua3589 = new Endereco(null, "Rua Breno de Moura", "Jardim Estoril", "Sul", "12232040");
		Endereco rua3590 = new Endereco(null, "Rua André Plusplatais", "Jardim Estoril", "Sul", "12232045");
		Endereco rua3591 = new Endereco(null, "Rua Elmano Ferreira Veloso", "Jardim Estoril", "Sul", "12232050");
		Endereco rua3592 = new Endereco(null, "Rua José Marini", "Jardim Estoril", "Sul", "12232053");
		Endereco rua3593 = new Endereco(null, "Rua Doutor Décio Lemes Campos", "Jardim Estoril", "Sul", "12232057");
		Endereco rua3594 = new Endereco(null, "Rua José Ivair de Souza", "Jardim Estoril", "Sul", "12232060");
		Endereco rua3595 = new Endereco(null, "Rua José Maria de Lima", "Jardim Estoril", "Sul", "12232070");
		Endereco rua3596 = new Endereco(null, "Rua Rosaria Rodrigues Alonso", "Jardim Estoril", "Sul", "12232080");
		Endereco rua3597 = new Endereco(null, "Rua Geraldo Ferreira Tavares", "Jardim Portugal", "Sul", "12232081");
		Endereco rua3598 = new Endereco(null, "Travessa dos Portugueses", "Jardim Portugal", "Sul", "12232140");
		Endereco rua3599 = new Endereco(null, "Rua Aparecida Boreli Melo", "Jardim Portugal", "Sul", "12232150");
		Endereco rua3600 = new Endereco(null, "Rua Zeferino Inácio Vieira", "Jardim Portugal", "Sul", "12232151");
		Endereco rua3601 = new Endereco(null, "Rua Tereza Alves Cursino", "Jardim Portugal", "Sul", "12232160");
		Endereco rua3602 = new Endereco(null, "Rua Wilma Vinhas Santos", "Jardim Portugal", "Sul", "12232170");
		Endereco rua3603 = new Endereco(null, "Rua Doutor Sérgio Santos", "Jardim Portugal", "Sul", "12232180");
		Endereco rua3604 = new Endereco(null, "Praça José Benedito Monteiro", "Jardim Portugal", "Sul", "12232181");
		Endereco rua3605 = new Endereco(null, "Rua Guilherme Lourenço", "Jardim Portugal", "Sul", "12232182");
		Endereco rua3606 = new Endereco(null, "Rua Luiz Marchetti", "Jardim Portugal", "Sul", "12232190");
		Endereco rua3607 = new Endereco(null, "Rua Doutor Milton Parodi", "Jardim Portugal", "Sul", "12232200");
		Endereco rua3608 = new Endereco(null, "Rua Alípio Ferreira Lourenço", "Jardim Portugal", "Sul", "12232210");
		Endereco rua3609 = new Endereco(null, "Rua Antônio Alves", "Jardim Portugal", "Sul", "12232220");
		Endereco rua3610 = new Endereco(null, "Rua Capitão Alípio Neves Barbosa", "Jardim Portugal", "Sul", "12232230");
		Endereco rua3611 = new Endereco(null, "Rua Manoel dos Santos Cabral", "Jardim Del Rey", "Sul", "12232231");
		Endereco rua3612 = new Endereco(null, "Rua Maria José Gonçalves", "Jardim Del Rey", "Sul", "12232232");
		Endereco rua3613 = new Endereco(null, "Rua João Benitez Gimenez", "Jardim Del Rey", "Sul", "12232233");
		Endereco rua3614 = new Endereco(null, "Rua João Cassiano da Silva", "Jardim Del Rey", "Sul", "12232234");
		Endereco rua3615 = new Endereco(null, "Rua João Rodrigues de Oliveira Figueiredo", "Jardim Del Rey", "Sul",
				"12232235");
		Endereco rua3616 = new Endereco(null, "Rua Cleto dos Santos", "Jardim Del Rey", "Sul", "12232236");
		Endereco rua3617 = new Endereco(null, "Rua Mário de Paula Ferreira", "Jardim Del Rey", "Sul", "12232237");
		Endereco rua3618 = new Endereco(null, "Rua Agenor Xavier de Oliveira", "Jardim Del Rey", "Sul", "12232238");
		Endereco rua3619 = new Endereco(null, "Rua José Bonifácio de Oliveira", "Jardim Del Rey", "Sul", "12232239");
		Endereco rua3620 = new Endereco(null, "Rua Lazara Menezes de Oliveira", "Jardim Portugal", "Sul", "12232240");
		Endereco rua3621 = new Endereco(null, "Rua Benedito Alexandre Trindade", "Jardim Portugal", "Sul", "12232250");
		Endereco rua3622 = new Endereco(null, "Rua Doutor Carlos Alberto Fontenelle Moreira", "Jardim Portugal", "Sul",
				"12232260");
		Endereco rua3623 = new Endereco(null, "Rua José Domingos Auricchio", "Jardim Portugal", "Sul", "12232270");
		Endereco rua3624 = new Endereco(null, "Rua Vítor Alves Rabelo", "Jardim Portugal", "Sul", "12232271");
		Endereco rua3625 = new Endereco(null, "Rua Esmeralda Rondan", "Jardim Madureira", "Sul", "12232280");
		Endereco rua3626 = new Endereco(null, "Rua José Alves da Silva", "Jardim Madureira", "Sul", "12232281");
		Endereco rua3627 = new Endereco(null, "Rua Werner da Costa Coelho", "Jardim Madureira", "Sul", "12232290");
		Endereco rua3628 = new Endereco(null, "Rua Maria Ribeiro Martins", "Jardim Madureira", "Sul", "12232300");
		Endereco rua3629 = new Endereco(null, "Rua José Rodrigues Maia", "Jardim Portugal", "Sul", "12232310");
		Endereco rua3630 = new Endereco(null, "Avenida Cidade Jardim", "Bosque dos Eucaliptos", "Sul", "12233002");
		Endereco rua3631 = new Endereco(null, "Avenida Cidade Jardim", " 3141", "Bosque dos Eucaliptos", "Sul");
		Endereco rua3632 = new Endereco(null, "Rua Carlos Nunes de Paula", "Jardim Imperial", "Sul", "12234000");
		Endereco rua3633 = new Endereco(null, "Estrada do Imperador", "Jardim Colonial", "Sul", "12234001");
		Endereco rua3634 = new Endereco(null, "Rua Edesio Soares", "Jardim Colonial", "Sul", "12234002");
		Endereco rua3635 = new Endereco(null, "Rua Ester de Oliveira", "Jardim Colonial", "Sul", "12234003");
		Endereco rua3636 = new Endereco(null, "Rua Álvaro Lordello", "Jardim Colonial", "Sul", "12234004");
		Endereco rua3637 = new Endereco(null, "Rua Iran Faria Siqueira", "Jardim Colonial", "Sul", "12234005");
		Endereco rua3638 = new Endereco(null, "Rua Edesia Gonçalves Neves", "Jardim Colonial", "Sul", "12234006");
		Endereco rua3639 = new Endereco(null, "Rua Marlene Aparecida de Jesus", "Jardim Imperial", "Sul", "12234007");
		Endereco rua3640 = new Endereco(null, "Rua São Fidélis", "Jardim Colonial", "Sul", "12234008");
		Endereco rua3641 = new Endereco(null, "Avenida Dom Pedro I", "Jardim Imperial", "Sul", "12234010");
		Endereco rua3642 = new Endereco(null, "Rua Almirante Barroso", "Jardim Imperial", "Sul", "12234020");
		Endereco rua3643 = new Endereco(null, "Praça Antônio Moreira Vita", "Jardim Imperial", "Sul", "12234030");
		Endereco rua3644 = new Endereco(null, "Rua Ramon Ovalle", "Jardim Imperial", "Sul", "12234040");
		Endereco rua3645 = new Endereco(null, "Rua Fábio Schneider", "Jardim Imperial", "Sul", "12234050");
		Endereco rua3646 = new Endereco(null, "Rua Maria Aparecida Azevedo", "Jardim Imperial", "Sul", "12234051");
		Endereco rua3647 = new Endereco(null, "Rua Sílvio Gallicho", "Jardim Imperial", "Sul", "12234060");
		Endereco rua3648 = new Endereco(null, "Rua Felisbina de Souza Machado", "Jardim Imperial", "Sul", "12234070");
		Endereco rua3649 = new Endereco(null, "Rua Cônego José Romão da Rosa Góes", "Jardim Imperial", "Sul",
				"12234080");
		Endereco rua3650 = new Endereco(null, "Rua Gerôncio Marcondes", "Jardim Imperial", "Sul", "12234090");
		Endereco rua3651 = new Endereco(null, "Rua Dom João VI", "Jardim Imperial", "Sul", "12234100");
		Endereco rua3652 = new Endereco(null, "Praça Otávio Del Nero", "Jardim Imperial", "Sul", "12234110");
		Endereco rua3653 = new Endereco(null, "Praça Francisco Lopes Azevedo", "Jardim Imperial", "Sul", "12234120");
		Endereco rua3654 = new Endereco(null, "Rua José Aulisio", "Jardim Imperial", "Sul", "12234130");
		Endereco rua3655 = new Endereco(null, "Rua Padre Nóbrega", "Jardim Imperial", "Sul", "12234140");
		Endereco rua3656 = new Endereco(null, "Rua Júlio Baranov", "Jardim Imperial", "Sul", "12234150");
		Endereco rua3657 = new Endereco(null, "Praça Aurora Marcondes Pereira", "Jardim Imperial", "Sul", "12234160");
		Endereco rua3658 = new Endereco(null, "Rua Onofre José dos Reis", "Jardim Imperial", "Sul", "12234170");
		Endereco rua3659 = new Endereco(null, "Rua Luiz Gonzaga Azevedo", "Jardim Imperial", "Sul", "12234180");
		Endereco rua3660 = new Endereco(null, "Rua Roberto Baranov", "Jardim Imperial", "Sul", "12234190");
		Endereco rua3661 = new Endereco(null, "Rua Caramuru", "Jardim Colonial", "Sul", "12234201");
		Endereco rua3662 = new Endereco(null, "Rua Emanuel Rosemberg", "Jardim Imperial", "Sul", "12234210");
		Endereco rua3663 = new Endereco(null, "Rua Manoel Augusto Amaral", "Jardim Imperial", "Sul", "12234220");
		Endereco rua3664 = new Endereco(null, "Praça Francisco Silvério", "Jardim Imperial", "Sul", "12234230");
		Endereco rua3665 = new Endereco(null, "Rua Manoel Mariano", "Jardim Imperial", "Sul", "12234240");
		Endereco rua3666 = new Endereco(null, "Rua José Roberto Ferrari", "Jardim Imperial", "Sul", "12234250");
		Endereco rua3667 = new Endereco(null, "Rua Durval de Melo", "Jardim Imperial", "Sul", "12234260");
		Endereco rua3668 = new Endereco(null, "Rua Durval S Aguiar", "Jardim Imperial", "Sul", "12234261");
		Endereco rua3669 = new Endereco(null, "Rua Luís Gonzaga Alves", "Jardim Imperial", "Sul", "12234262");
		Endereco rua3670 = new Endereco(null, "Rua Três Irmãos", "Jardim Imperial", "Sul", "12234263");
		Endereco rua3671 = new Endereco(null, "Avenida Napoleão Bonaparte", "Jardim Colonial", "Sul", "12234270");
		Endereco rua3672 = new Endereco(null, "Praça Moreira Vita", "Jardim Colonial", "Sul", "12234271");
		Endereco rua3673 = new Endereco(null, "Rua Joaquim Bueno de Vasconcelos", "Jardim Colonial", "Sul", "12234280");
		Endereco rua3674 = new Endereco(null, "Rua José Simão", "Jardim Colonial", "Sul", "12234290");
		Endereco rua3675 = new Endereco(null, "Rua Anacleto Deolindo Liberato", "Jardim Colonial", "Sul", "12234300");
		Endereco rua3676 = new Endereco(null, "Rua Gustavo Sonnewend Filho", "Jardim Colonial", "Sul", "12234310");
		Endereco rua3677 = new Endereco(null, "Rua Cantagalo", "Jardim Colonial", "Sul", "12234320");
		Endereco rua3678 = new Endereco(null, "Rua Coronel Palimerico Resende", "Jardim Colonial", "Sul", "12234330");
		Endereco rua3679 = new Endereco(null, "Rua Monte Verde", "Jardim Colonial", "Sul", "12234331");
		Endereco rua3680 = new Endereco(null, "Rua Pureza", "Jardim Colonial", "Sul", "12234350");
		Endereco rua3681 = new Endereco(null, "Rua Baltazar", "Jardim Colonial", "Sul", "12234360");
		Endereco rua3682 = new Endereco(null, "Rua Celina", "Jardim Colonial", "Sul", "12234370");
		Endereco rua3683 = new Endereco(null, "Rua Ermerentina Carvalho Campos", "Jardim Imperial", "Sul", "12234380");
		Endereco rua3684 = new Endereco(null, "Rua Geraldo Chaves", "Jardim Imperial", "Sul", "12234390");
		Endereco rua3685 = new Endereco(null, "Rua Marquês de Maricá", "Jardim Imperial", "Sul", "12234400");
		Endereco rua3686 = new Endereco(null, "Rua João Muzzaco", "Jardim Colonial", "Sul", "12234420");
		Endereco rua3687 = new Endereco(null, "Rua Menotti Zeccheto", "Jardim Imperial", "Sul", "12234430");
		Endereco rua3688 = new Endereco(null, "Praça Bertolino Claudio", "Jardim Colonial", "Sul", "12234440");
		Endereco rua3689 = new Endereco(null, "Rua Maria Tereza Cardoso Batista", "Jardim Imperial", "Sul", "12234460");
		Endereco rua3690 = new Endereco(null, "Rua José Anconi", "Jardim Colonial", "Sul", "12234470");
		Endereco rua3691 = new Endereco(null, "Rua P", "Jardim Imperial", "Sul", "12234471");
		Endereco rua3692 = new Endereco(null, "Avenida Um", "Jardim dos Bandeirantes", "Sul", "12234785");
		Endereco rua3693 = new Endereco(null, "Avenida Dois", "Jardim dos Bandeirantes", "Sul", "12234786");
		Endereco rua3694 = new Endereco(null, "Rua Benedito Ferreira dos Santos", "Jardim dos Bandeirantes", "Sul",
				"12234787");
		Endereco rua3695 = new Endereco(null, "Rua Osvaldo Gonçalves Toledo", "Jardim dos Bandeirantes", "Sul",
				"12234788");
		Endereco rua3696 = new Endereco(null, "Rua João da Rosa Alves", "Jardim dos Bandeirantes", "Sul", "12234789");
		Endereco rua3697 = new Endereco(null, "Rua Luiz Roberto dos Santos", "Jardim dos Bandeirantes", "Sul",
				"12234790");
		Endereco rua3698 = new Endereco(null, "Rua Urbano Ezequiel das Neves", "Jardim dos Bandeirantes", "Sul",
				"12234791");
		Endereco rua3699 = new Endereco(null, "Rua Benedita Marques das Neves", "Jardim dos Bandeirantes", "Sul",
				"12234792");
		Endereco rua3700 = new Endereco(null, "Rua Amado Conceição Silva Rosário", "Jardim dos Bandeirantes", "Sul",
				"12234793");
		Endereco rua3701 = new Endereco(null, "Rua Waldemar Oliveira", "Jardim dos Bandeirantes", "Sul", "12234794");
		Endereco rua3702 = new Endereco(null, "Rua Valentina da Conceição", "Jardim dos Bandeirantes", "Sul",
				"12234795");
		Endereco rua3703 = new Endereco(null, "Rua Claudnei Marcondes Cordeiro", "Jardim dos Bandeirantes", "Sul",
				"12234796");
		Endereco rua3704 = new Endereco(null, "Rua Toshiyassu Watanabe", "Jardim dos Bandeirantes", "Sul", "12234797");
		Endereco rua3705 = new Endereco(null, "Rua Isamu Hayashi", "Jardim dos Bandeirantes", "Sul", "12234798");
		Endereco rua3706 = new Endereco(null, "Rua Francisco Cassiano de Pontes", "Jardim dos Bandeirantes", "Sul",
				"12234799");
		Endereco rua3707 = new Endereco(null, "Avenida Orlando Ferreira Rebouças", "Jardim Cruzeiro do Sul", "Sul",
				"12234801");
		Endereco rua3708 = new Endereco(null, "Rua Octávio Bertti", "Jardim Cruzeiro do Sul", "Sul", "12234806");
		Endereco rua3709 = new Endereco(null, "Rua Isaac Guilherme Gonçalves", "Jardim Cruzeiro do Sul", "Sul",
				"12234807");
		Endereco rua3710 = new Endereco(null, "Rua Aparecida da Silva Alves", "Jardim Cruzeiro do Sul", "Sul",
				"12234808");
		Endereco rua3711 = new Endereco(null, "Rua Vítor Pinto Ribeiro", "Jardim Cruzeiro do Sul", "Sul", "12234809");
		Endereco rua3712 = new Endereco(null, "Rua Amélia Maria da Conceição", "Jardim Cruzeiro do Sul", "Sul",
				"12234810");
		Endereco rua3713 = new Endereco(null, "Rua Fernando Bráulio de Melo", "Jardim Cruzeiro do Sul", "Sul",
				"12234811");
		Endereco rua3714 = new Endereco(null, "Rua Romeu Gonçalves Mendes", "Jardim Cruzeiro do Sul", "Sul",
				"12234812");
		Endereco rua3715 = new Endereco(null, "Rua Honorato Gonçalves Teixeira", "Jardim Cruzeiro do Sul", "Sul",
				"12234813");
		Endereco rua3716 = new Endereco(null, "Rua José Eduardo Ferreira dos Santos", "Jardim Cruzeiro do Sul", "Sul",
				"12234814");
		Endereco rua3717 = new Endereco(null, "Rua João Francisco da Silva", "Jardim Cruzeiro do Sul", "Sul",
				"12234815");
		Endereco rua3718 = new Endereco(null, "Rua Francisco Alexandre Buck", "Jardim Cruzeiro do Sul", "Sul",
				"12234816");
		Endereco rua3719 = new Endereco(null, "Rua Theodoro José Sampaio", "Jardim Cruzeiro do Sul", "Sul", "12234817");
		Endereco rua3720 = new Endereco(null, "Rua Sebastião Borges Leal", "Jardim Cruzeiro do Sul", "Sul", "12234818");
		Endereco rua3721 = new Endereco(null, "Avenida Eugênia da Silva", "Jardim República", "Sul", "12234825");
		Endereco rua3722 = new Endereco(null, "Rua João de Aquino", "Jardim República", "Sul", "12234826");
		Endereco rua3723 = new Endereco(null, "Rua Josefa Paulino Ramos da Silva", "Jardim República", "Sul",
				"12234827");
		Endereco rua3724 = new Endereco(null, "Rua Alcides Moreira de Paula", "Jardim República", "Sul", "12234828");
		Endereco rua3725 = new Endereco(null, "Rua Orlandino de Paula Pereira", "Jardim República", "Sul", "12234829");
		Endereco rua3726 = new Endereco(null, "Avenida José Benedicto Marinho de Souza", "Jardim República", "Sul",
				"12234830");
		Endereco rua3727 = new Endereco(null, "Rua Oscar Ferreira Silva", "Jardim República", "Sul", "12234831");
		Endereco rua3728 = new Endereco(null, "Rua Confrade João Pereira dos Santos", "Jardim República", "Sul",
				"12234832");
		Endereco rua3729 = new Endereco(null, "Rua Confrade José Simão Viana", "Jardim República", "Sul", "12234833");
		Endereco rua3730 = new Endereco(null, "Rua Rômulo Séllos Rodrigues", "Jardim República", "Sul", "12234834");
		Endereco rua3731 = new Endereco(null, "Rua Vanderlei Alexandre da Silva", "Jardim República", "Sul",
				"12234835");
		Endereco rua3732 = new Endereco(null, "Rua Almir Arnaldo de Alencar", "Jardim República", "Sul", "12234836");
		Endereco rua3733 = new Endereco(null, "Rua José Marinho do Nascimento", "Jardim República", "Sul", "12234837");
		Endereco rua3734 = new Endereco(null, "Rua Jacira Barbosa de Araújo", "Jardim República", "Sul", "12234838");
		Endereco rua3735 = new Endereco(null, "Avenida Confrade Geraldino Gabriel da Silva", "Jardim República", "Sul",
				"12234840");
		Endereco rua3736 = new Endereco(null, "Rua Dominga Senhora de Jesus", "Jardim Nova República", "Sul",
				"12234850");
		Endereco rua3737 = new Endereco(null, "Rua Patrícia Maria Hipólito", "Jardim Nova República", "Sul",
				"12234852");
		Endereco rua3738 = new Endereco(null, "Rua David Felix de Souza", "Jardim Nova República", "Sul", "12234854");
		Endereco rua3739 = new Endereco(null, "Rua José de Anchieta Carvalho", "Jardim Nova República", "Sul",
				"12234856");
		Endereco rua3740 = new Endereco(null, "Rua Amanda Gabrielle Friggi", "Jardim Nova República", "Sul",
				"12234858");
		Endereco rua3741 = new Endereco(null, "Rua Nelson Karatanasov", "Jardim Nova República", "Sul", "12234860");
		Endereco rua3742 = new Endereco(null, "Avenida Cabo Lúcio Mauro da Silva Moreira", "Jardim Nova República",
				"Sul", "12234862");
		Endereco rua3743 = new Endereco(null, "Avenida Três", "Jardim Nova República", "Sul", "12234864");
		Endereco rua3744 = new Endereco(null, "Rua Mario Cordeiro", "Jardim Nova República", "Sul", "12234866");
		Endereco rua3745 = new Endereco(null, "Rua Voluntários do Rotary", "Jardim Nova República", "Sul", "12234868");
		Endereco rua3746 = new Endereco(null, "Rua Osvaldo Caldardo", "Jardim Nova República", "Sul", "12234870");
		Endereco rua3747 = new Endereco(null, "Avenida Cecilia Lucio de Almeida Mota", "Jardim Nova República", "Sul",
				"12234874");
		Endereco rua3748 = new Endereco(null, "Rua Adelmo Liberato", "Jardim Nova República", "Sul", "12234876");
		Endereco rua3749 = new Endereco(null, "Rua Maestro Darcy Rogériio Claudino", "Jardim Nova República", "Sul",
				"12234878");
		Endereco rua3750 = new Endereco(null, "Rua Julio Tognetti", "Jardim Nova República", "Sul", "12234880");
		Endereco rua3751 = new Endereco(null, "Rua Maria Del Pilar Rozas Rozados Theodoro", "Jardim Nova República",
				"Sul", "12234882");
		Endereco rua3752 = new Endereco(null, "Rua Sebastião José Garcia", "Jardim Nova República", "Sul", "12234884");
		Endereco rua3753 = new Endereco(null, "Rua José Carlos das Neves", "Jardim Nova República", "Sul", "12234886");
		Endereco rua3754 = new Endereco(null, "Rua Adilson Carlos Alves", "Jardim Nova República", "Sul", "12234888");
		Endereco rua3755 = new Endereco(null, "Rua Julia Mola Maldos", "Jardim Nova República", "Sul", "12234890");
		Endereco rua3756 = new Endereco(null, "Rua José Santana Mariano", "Jardim Nova República", "Sul", "12234892");
		Endereco rua3757 = new Endereco(null, "Rua Maria Otília Araújo Lima de Oliveira", "Jardim Nova República",
				"Sul", "12234894");
		Endereco rua3758 = new Endereco(null, "Rua Cabo Antonio Rodrigues de Souza", "Jardim Nova República", "Sul",
				"12234896");
		Endereco rua3759 = new Endereco(null, "Avenida Guadalupe", "Jardim América", "Sul", "12235000");
		Endereco rua3760 = new Endereco(null, "Rua Cali", "Jardim América", "Sul", "12235010");
		Endereco rua3761 = new Endereco(null, "Rua Paissandu", "Jardim América", "Sul", "12235020");
		Endereco rua3762 = new Endereco(null, "Rua Patagones", "Jardim América", "Sul", "12235031");
		Endereco rua3763 = new Endereco(null, "Rua Principado de Mônaco", "Jardim América", "Sul", "12235040");
		Endereco rua3764 = new Endereco(null, "Rua Andorra", "Jardim América", "Sul", "12235050");
		Endereco rua3765 = new Endereco(null, "Rua Shizuko Iida", "Jardim América", "Sul", "12235051");
		Endereco rua3766 = new Endereco(null, "Rua Pedro Tatimoto", "Jardim América", "Sul", "12235060");
		Endereco rua3767 = new Endereco(null, "Rua Haiti", "Jardim América", "Sul", "12235070");
		Endereco rua3768 = new Endereco(null, "Rua San Marino", "Jardim América", "Sul", "12235080");
		Endereco rua3769 = new Endereco(null, "Rua Groelândia", "Jardim América", "Sul", "12235090");
		Endereco rua3770 = new Endereco(null, "Rua Equador", "Jardim América", "Sul", "12235100");
		Endereco rua3771 = new Endereco(null, "Rua João de Paula", "Jardim América", "Sul", "12235101");
		Endereco rua3772 = new Endereco(null, "Rua Arequipa", "Jardim América", "Sul", "12235110");
		Endereco rua3773 = new Endereco(null, "Rua Costa Rica", "Jardim América", "Sul", "12235120");
		Endereco rua3774 = new Endereco(null, "Rua Ryokichi Asanome", "Jardim América", "Sul", "12235130");
		Endereco rua3775 = new Endereco(null, "Rua Nelson Cavaquinho", "Jardim América", "Sul", "12235140");
		Endereco rua3776 = new Endereco(null, "Rua Irmã Emília Michelin", "Jardim América", "Sul", "12235150");
		Endereco rua3777 = new Endereco(null, "Rua Benedito Pinto da Cunha", "Jardim América", "Sul", "12235160");
		Endereco rua3778 = new Endereco(null, "Rua Professor Luiz Eurico Ferreira", "Jardim América", "Sul",
				"12235170");
		Endereco rua3779 = new Endereco(null, "Rua Koichi Matsumura", "Jardim América", "Sul", "12235180");
		Endereco rua3780 = new Endereco(null, "Rua Iraci Gonçalves Ferreira", "Jardim América", "Sul", "12235181");
		Endereco rua3781 = new Endereco(null, "Rua Aurora Pinto da Cunha", "Jardim América", "Sul", "12235190");
		Endereco rua3782 = new Endereco(null, "Rua Benedicto de Alvarenga", "Jardim América", "Sul", "12235191");
		Endereco rua3783 = new Endereco(null, "Rua Vicente Venâncio da Silva", "Jardim América", "Sul", "12235192");
		Endereco rua3784 = new Endereco(null, "Avenida João Batista de Souza Soares", "Jardim América", "Sul",
				"12235200");
		Endereco rua3785 = new Endereco(null, "Rua Serra do Parima", "Jardim Anhembi", "Sul", "12235210");
		Endereco rua3786 = new Endereco(null, "Rua Serra dos Pirineus", "Jardim Anhembi", "Sul", "12235220");
		Endereco rua3787 = new Endereco(null, "Rua Serra dos Órgãos", "Jardim Anhembi", "Sul", "12235230");
		Endereco rua3788 = new Endereco(null, "Rua Serra do Roncador", "Jardim Anhembi", "Sul", "12235240");
		Endereco rua3789 = new Endereco(null, "Rua Serra da Mantiqueira", "Jardim Anhembi", "Sul", "12235250");
		Endereco rua3790 = new Endereco(null, "Rua Serra do Paranapiacaba", "Jardim Anhembi", "Sul", "12235251");
		Endereco rua3791 = new Endereco(null, "Praça Serra Formosa", "Jardim Anhembi", "Sul", "12235260");
		Endereco rua3792 = new Endereco(null, "Rua Serra do Pacaraima", "Jardim Anhembi", "Sul", "12235270");
		Endereco rua3793 = new Endereco(null, "Praça Serra do Acarai", "Jardim Anhembi", "Sul", "12235280");
		Endereco rua3794 = new Endereco(null, "Rua Serra do Ibiacaba", "Jardim Anhembi", "Sul", "12235290");
		Endereco rua3795 = new Endereco(null, "Rua Serra do Mar", "Jardim Anhembi", "Sul", "12235310");
		Endereco rua3796 = new Endereco(null, "Avenida Marginal B", "Jardim América", "Sul", "12235311");
		Endereco rua3797 = new Endereco(null, "Rua Bariloche", "Jardim América", "Sul", "12235320");
		Endereco rua3798 = new Endereco(null, "Rua Tucuman", "Jardim América", "Sul", "12235330");
		Endereco rua3799 = new Endereco(null, "Rua Mar Del Plata", "Jardim América", "Sul", "12235340");
		Endereco rua3800 = new Endereco(null, "Praça Kadoma", "Jardim América", "Sul", "12235341");
		Endereco rua3801 = new Endereco(null, "Rua Arica", "Jardim América", "Sul", "12235350");
		Endereco rua3802 = new Endereco(null, "Rua Professor José Antônio Coutinho Condino", "Jardim América", "Sul",
				"12235361");
		Endereco rua3803 = new Endereco(null, "Rua Maracaibo", "Jardim América", "Sul", "12235370");
		Endereco rua3804 = new Endereco(null, "Rua Alcides Barbosa", "Jardim América", "Sul", "12235371");
		Endereco rua3805 = new Endereco(null, "Rua Valparaiso", "Jardim América", "Sul", "12235380");
		Endereco rua3806 = new Endereco(null, "Rua Cordoba", "Jardim América", "Sul", "12235390");
		Endereco rua3807 = new Endereco(null, "Rua Merida", "Jardim América", "Sul", "12235400");
		Endereco rua3808 = new Endereco(null, "Rua Sumatra", "Jardim Paraíso", "Sul", "12235410");
		Endereco rua3809 = new Endereco(null, "Rua Rosario", "Jardim América", "Sul", "12235420");
		Endereco rua3810 = new Endereco(null, "Rua Particular", "Jardim América", "Sul", "12235421");
		Endereco rua3811 = new Endereco(null, "Rua Mindanau", "Jardim Paraíso", "Sul", "12235430");
		Endereco rua3812 = new Endereco(null, "Rua Cosmos", "Jardim Paraíso", "Sul", "12235440");
		Endereco rua3813 = new Endereco(null, "Rua Madagascar", "Jardim Paraíso", "Sul", "12235450");
		Endereco rua3814 = new Endereco(null, "Avenida Paraiso", "Jardim Paraíso", "Sul", "12235460");
		Endereco rua3815 = new Endereco(null, "Rua Ilha do Norte", "Jardim Paraíso", "Sul", "12235470");
		Endereco rua3816 = new Endereco(null, "Rua Islândia", "Jardim Paraíso", "Sul", "12235480");
		Endereco rua3817 = new Endereco(null, "Rua Ilha do Sul", "Jardim Paraíso", "Sul", "12235490");
		Endereco rua3818 = new Endereco(null, "Rua Java", "Jardim Paraíso", "Sul", "12235500");
		Endereco rua3819 = new Endereco(null, "Rua Nova Guine", "Jardim Paraíso", "Sul", "12235501");
		Endereco rua3820 = new Endereco(null, "Rua Kiyoshi Enomoto", "Jardim San Marino", "Sul", "12235831");
		Endereco rua3821 = new Endereco(null, "Rua Confrade José Paulino do Nascimento", "Jardim San Marino", "Sul",
				"12235835");
		Endereco rua3822 = new Endereco(null, "Rua Epaminondas de Paula Freitas", "Jardim San Marino", "Sul",
				"12235840");
		Endereco rua3823 = new Endereco(null, "Rua Antônio Hideto Kobayashi", "Jardim San Marino", "Sul", "12235845");
		Endereco rua3824 = new Endereco(null, "Rua Luiz Ruffa", "Jardim San Marino", "Sul", "12235850");
		Endereco rua3825 = new Endereco(null, "Avenida Guadalupe", " 11", "Jardim América", "Sul");
		Endereco rua3826 = new Endereco(null, "Avenida Tokio", "Jardim Oriente", "Sul", "12236000");
		Endereco rua3827 = new Endereco(null, "Rua Alfredo Nobel", "Jardim Oriente", "Sul", "12236010");
		Endereco rua3828 = new Endereco(null, "Rua Tottoni", "Jardim Oriente", "Sul", "12236020");
		Endereco rua3829 = new Endereco(null, "Praça Yamagata", "Jardim Oriente", "Sul", "12236021");
		Endereco rua3830 = new Endereco(null, "Rua Hokaido", "Jardim Oriente", "Sul", "12236030");
		Endereco rua3831 = new Endereco(null, "Avenida Hiroshima", "Jardim Oriente", "Sul", "12236040");
		Endereco rua3832 = new Endereco(null, "Avenida José César de Souza", "Jardim Terras do Sul", "Sul", "12236062");
		Endereco rua3833 = new Endereco(null, "Rua Ângelo Bravini", "Jardim Terras do Sul", "Sul", "12236063");
		Endereco rua3834 = new Endereco(null, "Rua Guiomar Jordão Lobo", "Jardim Terras do Sul", "Sul", "12236064");
		Endereco rua3835 = new Endereco(null, "Rua Renato Carneiro da Costa Guimarães", "Jardim Terras do Sul", "Sul",
				"12236065");
		Endereco rua3836 = new Endereco(null, "Rua Doutor Octávio Monteiro Becker", "Jardim Terras do Sul", "Sul",
				"12236066");
		Endereco rua3837 = new Endereco(null, "Rua Pedro Nunes de Souza", "Jardim Terras do Sul", "Sul", "12236067");
		Endereco rua3838 = new Endereco(null, "Rua Gercino Francisco Pereira", "Jardim Terras do Sul", "Sul",
				"12236068");
		Endereco rua3839 = new Endereco(null, "Rua Maria de Lourdes Pereira", "Jardim Terras do Sul", "Sul",
				"12236069");
		Endereco rua3840 = new Endereco(null, "Rua Orlando Balbino da Silva", "Jardim Terras do Sul", "Sul",
				"12236073");
		Endereco rua3841 = new Endereco(null, "Rua Joaquin Benedito Costa", "Jardim Terras do Sul", "Sul", "12236074");
		Endereco rua3842 = new Endereco(null, "Avenida Fusanobu Yokota", "Jardim Terras do Sul", "Sul", "12236075");
		Endereco rua3843 = new Endereco(null, "Rua das Chácaras", "Jardim Oriente", "Sul", "12236080");
		Endereco rua3844 = new Endereco(null, "Rua Yamaguti", "Jardim Oriente", "Sul", "12236081");
		Endereco rua3845 = new Endereco(null, "Rua Particular", "Jardim Oriente", "Sul", "12236082");
		Endereco rua3846 = new Endereco(null, "Rua Nagano", "Jardim Oriente", "Sul", "12236090");
		Endereco rua3847 = new Endereco(null, "Rua Hondo", "Jardim Oriente", "Sul", "12236100");
		Endereco rua3848 = new Endereco(null, "Rua Marco Túlio Cícero", "Jardim Oriente", "Sul", "12236110");
		Endereco rua3849 = new Endereco(null, "Rua Colombo", "Jardim Oriente", "Sul", "12236120");
		Endereco rua3850 = new Endereco(null, "Rua Tupi", "Jardim Oriente", "Sul", "12236121");
		Endereco rua3851 = new Endereco(null, "Rua Taru", "Jardim Oriente", "Sul", "12236130");
		Endereco rua3852 = new Endereco(null, "Rua Saitama", "Jardim Oriente", "Sul", "12236140");
		Endereco rua3853 = new Endereco(null, "Rua Osaka", "Jardim Oriente", "Sul", "12236150");
		Endereco rua3854 = new Endereco(null, "Praça Mikado", "Jardim Oriente", "Sul", "12236160");
		Endereco rua3855 = new Endereco(null, "Avenida Saga", "Jardim Oriente", "Sul", "12236170");
		Endereco rua3856 = new Endereco(null, "Rua Kumamoto", "Jardim Oriente", "Sul", "12236180");
		Endereco rua3857 = new Endereco(null, "Rua do Comércio", "Jardim Oriente", "Sul", "12236181");
		Endereco rua3858 = new Endereco(null, "Praça Alexandre Magno", "Jardim Oriente", "Sul", "12236190");
		Endereco rua3859 = new Endereco(null, "Rua Leonardo da Vinci", "Jardim Oriente", "Sul", "12236200");
		Endereco rua3860 = new Endereco(null, "Rua Miguel Ângelo", "Jardim Oriente", "Sul", "12236210");
		Endereco rua3861 = new Endereco(null, "Rua Marco Polo", "Jardim Oriente", "Sul", "12236220");
		Endereco rua3862 = new Endereco(null, "Rua Santo Inácio de Loyola", "Jardim Oriente", "Sul", "12236230");
		Endereco rua3863 = new Endereco(null, "Praça Victor Hugo", "Jardim Oriente", "Sul", "12236231");
		Endereco rua3864 = new Endereco(null, "Rua Isaac Newton", "Jardim Oriente", "Sul", "12236240");
		Endereco rua3865 = new Endereco(null, "Rua Guilherme Marconi", "Jardim Oriente", "Sul", "12236250");
		Endereco rua3866 = new Endereco(null, "Rua Benjamim Franklin", "Jardim Oriente", "Sul", "12236260");
		Endereco rua3867 = new Endereco(null, "Rua Aruichi Sakita", "Jardim Rosário", "Sul", "12236270");
		Endereco rua3868 = new Endereco(null, "Rua Torataro Takitani", "Jardim Rosário", "Sul", "12236280");
		Endereco rua3869 = new Endereco(null, "Rua Benedita Cantinho de Moura", "Jardim do Céu", "Sul", "12236290");
		Endereco rua3870 = new Endereco(null, "Rua Professor Francisco Juliano", "Jardim Rosário", "Sul", "12236300");
		Endereco rua3871 = new Endereco(null, "Rua Luiz Reis", "Jardim Rosário", "Sul", "12236310");
		Endereco rua3872 = new Endereco(null, "Rua Cecília Simão", "Jardim do Céu", "Sul", "12236320");
		Endereco rua3873 = new Endereco(null, "Rua Doutor João Batista Nogueira", "Jardim Rosário", "Sul", "12236330");
		Endereco rua3874 = new Endereco(null, "Rua Belmiro Andrade", "Jardim do Céu", "Sul", "12236340");
		Endereco rua3875 = new Endereco(null, "Rua Antônio Chrispim Machado", "Jardim do Céu", "Sul", "12236350");
		Endereco rua3876 = new Endereco(null, "Rua Synesio Luiz Paiva Sapucahy", "Jardim do Céu", "Sul", "12236360");
		Endereco rua3877 = new Endereco(null, "Rua Nelson Costa", "Jardim do Céu", "Sul", "12236370");
		Endereco rua3878 = new Endereco(null, "Avenida Arnaldo dos Santos Cerdeira", "Jardim do Céu", "Sul",
				"12236380");
		Endereco rua3879 = new Endereco(null, "Praça Luiz Vaz de Camões", "Jardim do Céu", "Sul", "12236381");
		Endereco rua3880 = new Endereco(null, "Rua George Washington", "Jardim Oriente", "Sul", "12236390");
		Endereco rua3881 = new Endereco(null, "Rua Júlio Cezar", "Jardim Oriente", "Sul", "12236400");
		Endereco rua3882 = new Endereco(null, "Rua São Tomás de Aquino", "Jardim Oriente", "Sul", "12236410");
		Endereco rua3883 = new Endereco(null, "Rua Roberto Romeo Nogueira", "Jardim Sul", "Sul", "12236481");
		Endereco rua3884 = new Endereco(null, "Rua Tenente-Coronel José Antônio Marques", "Jardim Sul", "Sul",
				"12236482");
		Endereco rua3885 = new Endereco(null, "Rua José dos Santos Nogueira", "Jardim Sul", "Sul", "12236483");
		Endereco rua3886 = new Endereco(null, "Rua Benedito Milton Simão", "Jardim Sul", "Sul", "12236484");
		Endereco rua3887 = new Endereco(null, "Rua Benedita Aparecida Bento Leopoldino", "Jardim Sul", "Sul",
				"12236485");
		Endereco rua3888 = new Endereco(null, "Rua Javel Fagundes dos Santos", "Jardim Sul", "Sul", "12236486");
		Endereco rua3889 = new Endereco(null, "Rua Miquelina Adamo", "Jardim Sul", "Sul", "12236487");
		Endereco rua3890 = new Endereco(null, "Rua José Benedito da Costa Pereira", "Jardim Sul", "Sul", "12236488");
		Endereco rua3891 = new Endereco(null, "Avenida José de Resende", "Jardim Sul", "Sul", "12236489");
		Endereco rua3892 = new Endereco(null, "Rua Cristiane de Souza Ramos", "Jardim Sul", "Sul", "12236491");
		Endereco rua3893 = new Endereco(null, "Rua Antonio Maia Filho", "Jardim Sul", "Sul", "12236492");
		Endereco rua3894 = new Endereco(null, "Rua Lenine Rebelo", "Jardim Sul", "Sul", "12236493");
		Endereco rua3895 = new Endereco(null, "Rua Geralda dos Santos Nunes", "Jardim Sul", "Sul", "12236494");
		Endereco rua3896 = new Endereco(null, "Rua Maurício Cardoso", "Jardim Sul", "Sul", "12236495");
		Endereco rua3897 = new Endereco(null, "Estrada Natan Sampaio de Almeida", "Jardim Capitingal", "Sul",
				"12236840");
		Endereco rua3898 = new Endereco(null, "Rua Valentim Goll", "Jardim Juliana", "Sul", "12236841");
		Endereco rua3899 = new Endereco(null, "Rua Adolpho Goll", "Jardim Juliana", "Sul", "12236842");
		Endereco rua3900 = new Endereco(null, "Rua Taru", " s/n", "Jardim Oriente", "Sul");
		Endereco rua3901 = new Endereco(null, "Rua Florença", "Jardim Veneza", "Sul", "12237060");
		Endereco rua3902 = new Endereco(null, "Rua José Cobra", "Jardim Veneza", "Sul", "12237061");
		Endereco rua3903 = new Endereco(null, "Rua Icatu", "Jardim Veneza", "Sul", "12237062");
		Endereco rua3904 = new Endereco(null, "Rua Penedo", "Jardim Veneza", "Sul", "12237070");
		Endereco rua3905 = new Endereco(null, "Rua Ravena", "Jardim Veneza", "Sul", "12237072");
		Endereco rua3906 = new Endereco(null, "Rua Bolonha", "Jardim Veneza", "Sul", "12237073");
		Endereco rua3907 = new Endereco(null, "Rua Genova", "Jardim Veneza", "Sul", "12237080");
		Endereco rua3908 = new Endereco(null, "Rua José Francisco Pereira Sales", "Jardim Veneza", "Sul", "12237090");
		Endereco rua3909 = new Endereco(null, "Rua Milão", "Jardim Veneza", "Sul", "12237092");
		Endereco rua3910 = new Endereco(null, "Rua Napolis", "Jardim Veneza", "Sul", "12237093");
		Endereco rua3911 = new Endereco(null, "Rua Nilson Herminio Consiglio", "Jardim Petrópolis", "Sul", "12237400");
		Endereco rua3912 = new Endereco(null, "Rua José Cobra", "Jardim Petrópolis", "Sul", "12237401");
		Endereco rua3913 = new Endereco(null, "Rua Joana Maria Correa Laranjeira", "Jardim Petrópolis", "Sul",
				"12237410");
		Endereco rua3914 = new Endereco(null, "Rua João José da Silva", "Jardim Petrópolis", "Sul", "12237430");
		Endereco rua3915 = new Endereco(null, "Rua Delfim Antônio Pinto", "Jardim Petrópolis", "Sul", "12237440");
		Endereco rua3916 = new Endereco(null, "Rua Elio Del Chiaro", "Jardim Petrópolis", "Sul", "12237450");
		Endereco rua3917 = new Endereco(null, "Rua João Alves Cardoso", "Jardim Petrópolis", "Sul", "12237451");
		Endereco rua3918 = new Endereco(null, "Rua Itabaiana", "Jardim Petrópolis", "Sul", "12237540");
		Endereco rua3919 = new Endereco(null, "Avenida Feira de Santana", "Jardim Vale do Sol", "Sul", "12238000");
		Endereco rua3920 = new Endereco(null, "Rua Candeias", "Jardim Vale do Sol", "Sul", "12238010");
		Endereco rua3921 = new Endereco(null, "Rua Alagoinhas", "Jardim Vale do Sol", "Sul", "12238020");
		Endereco rua3922 = new Endereco(null, "Rua Mucuri", "Jardim Vale do Sol", "Sul", "12238030");
		Endereco rua3923 = new Endereco(null, "Rua Gandu", "Jardim Vale do Sol", "Sul", "12238040");
		Endereco rua3924 = new Endereco(null, "Rua Almadina", "Jardim Vale do Sol", "Sul", "12238050");
		Endereco rua3925 = new Endereco(null, "Rua Anage", "Jardim Vale do Sol", "Sul", "12238060");
		Endereco rua3926 = new Endereco(null, "Rua Amargosa", "Jardim Vale do Sol", "Sul", "12238070");
		Endereco rua3927 = new Endereco(null, "Rua Juazeiro", "Jardim Vale do Sol", "Sul", "12238080");
		Endereco rua3928 = new Endereco(null, "Praça Bahia de São Salvador", "Jardim Vale do Sol", "Sul", "12238090");
		Endereco rua3929 = new Endereco(null, "Rua Quice", "Jardim Vale do Sol", "Sul", "12238100");
		Endereco rua3930 = new Endereco(null, "Rua Angical", "Jardim Vale do Sol", "Sul", "12238110");
		Endereco rua3931 = new Endereco(null, "Travessa Pataiba", "Jardim Vale do Sol", "Sul", "12238120");
		Endereco rua3932 = new Endereco(null, "Rua Caetité", "Jardim Vale do Sol", "Sul", "12238130");
		Endereco rua3933 = new Endereco(null, "Rua Ibicarai", "Jardim Vale do Sol", "Sul", "12238140");
		Endereco rua3934 = new Endereco(null, "Rua Catu", "Jardim Vale do Sol", "Sul", "12238150");
		Endereco rua3935 = new Endereco(null, "Rua Brumado", "Jardim Vale do Sol", "Sul", "12238160");
		Endereco rua3936 = new Endereco(null, "Rua Caravelas", "Jardim Vale do Sol", "Sul", "12238170");
		Endereco rua3937 = new Endereco(null, "Travessa Muritiba", "Jardim Vale do Sol", "Sul", "12238180");
		Endereco rua3938 = new Endereco(null, "Rua Vitória", "Jardim Vale do Sol", "Sul", "12238190");
		Endereco rua3939 = new Endereco(null, "Rua Alcocaba", "Jardim Vale do Sol", "Sul", "12238200");
		Endereco rua3940 = new Endereco(null, "Rua Aiquara", "Jardim Vale do Sol", "Sul", "12238210");
		Endereco rua3941 = new Endereco(null, "Rua Salvador Lahoz", "Jardim Vale do Sol", "Sul", "12238220");
		Endereco rua3942 = new Endereco(null, "Rua Abaré", "Jardim Vale do Sol", "Sul", "12238230");
		Endereco rua3943 = new Endereco(null, "Travessa Mataripe", "Jardim Vale do Sol", "Sul", "12238240");
		Endereco rua3944 = new Endereco(null, "Travessa Maracas", "Jardim Vale do Sol", "Sul", "12238250");
		Endereco rua3945 = new Endereco(null, "Estrada Arcílio Moreira da Silva", "Jardim Juliana", "Sul", "12239870");
		Endereco rua3946 = new Endereco(null, "Avenida Doutor João Batista Soares de Queiroz Júnior",
				"Jardim das Indústrias", "Sul", "12240000");
		Endereco rua3947 = new Endereco(null, "Rua Braúlio de Melo", "Jardim das Indústrias", "Sul", "12240001");
		Endereco rua3948 = new Endereco(null, "Praça da Criança", "Jardim das Indústrias", "Sul", "12240002");
		Endereco rua3949 = new Endereco(null, "Praça Professor Hélio Augusto de Souza", "Jardim das Indústrias", "Sul",
				"12240003");
		Endereco rua3950 = new Endereco(null, "Rua das Amariliseas", "Jardim das Indústrias", "Sul", "12240010");
		Endereco rua3951 = new Endereco(null, "Rua dos Cravos", "Jardim das Indústrias", "Sul", "12240020");
		Endereco rua3952 = new Endereco(null, "Rua dos Alecrins", "Jardim das Indústrias", "Sul", "12240030");
		Endereco rua3953 = new Endereco(null, "Rua das Felandrias", "Jardim das Indústrias", "Sul", "12240040");
		Endereco rua3954 = new Endereco(null, "Rua das Artimisias", "Jardim das Indústrias", "Sul", "12240050");
		Endereco rua3955 = new Endereco(null, "Rua João Ramos de Andrade", "Jardim das Indústrias", "Sul", "12240060");
		Endereco rua3956 = new Endereco(null, "Rua Guarulhos", "Jardim das Indústrias", "Sul", "12240070");
		Endereco rua3957 = new Endereco(null, "Rua dos Jacintos", "Jardim das Indústrias", "Sul", "12240071");
		Endereco rua3958 = new Endereco(null, "Rua das Mamonas", "Jardim das Indústrias", "Sul", "12240072");
		Endereco rua3959 = new Endereco(null, "Rua das Ambrósias", "Jardim das Indústrias", "Sul", "12240080");
		Endereco rua3960 = new Endereco(null, "Rua Trajano Vieira de Macedo", "Jardim das Indústrias", "Sul",
				"12240090");
		Endereco rua3961 = new Endereco(null, "Rua das Rogerias", "Jardim das Indústrias", "Sul", "12240100");
		Endereco rua3962 = new Endereco(null, "Rua dos Lilazes", "Jardim das Indústrias", "Sul", "12240110");
		Endereco rua3963 = new Endereco(null, "Rua das Crisandálias", "Jardim das Indústrias", "Sul", "12240120");
		Endereco rua3964 = new Endereco(null, "Rua das Quaresmeiras", "Jardim das Indústrias", "Sul", "12240130");
		Endereco rua3965 = new Endereco(null, "Rua das Açucenas", "Jardim das Indústrias", "Sul", "12240140");
		Endereco rua3966 = new Endereco(null, "Rua dos Amores-Perfeitos", "Jardim das Indústrias", "Sul", "12240150");
		Endereco rua3967 = new Endereco(null, "Rua Pirassununga", "Jardim das Indústrias", "Sul", "12240160");
		Endereco rua3968 = new Endereco(null, "Rua Manoel Alves Cardoso", "Jardim das Indústrias", "Sul", "12240170");
		Endereco rua3969 = new Endereco(null, "Rua Aimbire", "Jardim das Indústrias", "Sul", "12240171");
		Endereco rua3970 = new Endereco(null, "Rua Leme", "Jardim das Indústrias", "Sul", "12240180");
		Endereco rua3971 = new Endereco(null, "Rua Barretos", "Jardim das Indústrias", "Sul", "12240190");
		Endereco rua3972 = new Endereco(null, "Rua Olímpia", "Jardim das Indústrias", "Sul", "12240200");
		Endereco rua3973 = new Endereco(null, "Rua Arealva", "Jardim das Indústrias", "Sul", "12240210");
		Endereco rua3974 = new Endereco(null, "Rua Nelson César de Oliveira", "Jardim das Indústrias", "Sul",
				"12240220");
		Endereco rua3975 = new Endereco(null, "Rua São Carlos", "Jardim das Indústrias", "Sul", "12240230");
		Endereco rua3976 = new Endereco(null, "Rua Matão", "Jardim das Indústrias", "Sul", "12240240");
		Endereco rua3977 = new Endereco(null, "Rua Ibitinga", "Jardim das Indústrias", "Sul", "12240250");
		Endereco rua3978 = new Endereco(null, "Rua Adamantina", "Jardim das Indústrias", "Sul", "12240260");
		Endereco rua3979 = new Endereco(null, "Rua Araraquara", "Jardim das Indústrias", "Sul", "12240270");
		Endereco rua3980 = new Endereco(null, "Rua Andradina", "Jardim das Indústrias", "Sul", "12240280");
		Endereco rua3981 = new Endereco(null, "Rua Dracena", "Jardim das Indústrias", "Sul", "12240290");
		Endereco rua3982 = new Endereco(null, "Rua Birigüi", "Jardim das Indústrias", "Sul", "12240300");
		Endereco rua3983 = new Endereco(null, "Rua Presidente Epitâcio", "Jardim das Indústrias", "Sul", "12240310");
		Endereco rua3984 = new Endereco(null, "Rua Presidente Alves", "Jardim das Indústrias", "Sul", "12240320");
		Endereco rua3985 = new Endereco(null, "Rua Walter de Alencar Costa", "Jardim das Indústrias", "Sul",
				"12240330");
		Endereco rua3986 = new Endereco(null, "Rua Professor Henrique Jorge Guedes", "Jardim das Indústrias", "Sul",
				"12240340");
		Endereco rua3987 = new Endereco(null, "Rua das Zineas", "Jardim das Indústrias", "Sul", "12240350");
		Endereco rua3988 = new Endereco(null, "Rua dos Girassóis", "Jardim das Indústrias", "Sul", "12240360");
		Endereco rua3989 = new Endereco(null, "Rua das Madressilvas", "Jardim das Indústrias", "Sul", "12240370");
		Endereco rua3990 = new Endereco(null, "Rua das Malvas", "Jardim das Indústrias", "Sul", "12240380");
		Endereco rua3991 = new Endereco(null, "Rua dos Antúrios", "Jardim das Indústrias", "Sul", "12240390");
		Endereco rua3992 = new Endereco(null, "Rua das Palmas", "Jardim das Indústrias", "Sul", "12240400");
		Endereco rua3993 = new Endereco(null, "Rua das Valerianas", "Jardim das Indústrias", "Sul", "12240410");
		Endereco rua3994 = new Endereco(null, "Rodovia Presidente Dutra", "Jardim das Indústrias", "Sul", "12240420");
		Endereco rua3995 = new Endereco(null, "Rua Tenente Virgílio de Abreu Bolina", "Jardim das Indústrias", "Sul",
				"12240430");
		Endereco rua3996 = new Endereco(null, "Rua dos Crisântemos", "Jardim das Indústrias", "Sul", "12240440");
		Endereco rua3997 = new Endereco(null, "Rua Bakhos Yossef Alwan", "Jardim das Indústrias", "Sul", "12240450");
		Endereco rua3998 = new Endereco(null, "Rua das Lobelias", "Jardim das Indústrias", "Sul", "12240460");
		Endereco rua3999 = new Endereco(null, "Rua Estefania do Nascimento", "Jardim das Indústrias", "Sul",
				"12240470");
		Endereco rua4000 = new Endereco(null, "Rua Durvalina Simões", "Jardim das Indústrias", "Sul", "12240480");
		Endereco rua4001 = new Endereco(null, "Rua Egle Carnevali", "Jardim das Indústrias", "Sul", "12240490");
		Endereco rua4002 = new Endereco(null, "Rua Catanduva", "Jardim das Indústrias", "Sul", "12240500");
		Endereco rua4003 = new Endereco(null, "Rua São Caetano do Sul", "Jardim Alvorada", "Sul", "12240510");
		Endereco rua4004 = new Endereco(null, "Rua Ourinhos", "Jardim Alvorada", "Sul", "12240511");
		Endereco rua4005 = new Endereco(null, "Rua São Bernardo do Campo", "Jardim Alvorada", "Sul", "12240520");
		Endereco rua4006 = new Endereco(null, "Rua Santo André", "Jardim Alvorada", "Sul", "12240521");
		Endereco rua4007 = new Endereco(null, "Avenida Campos Elíseos", "Jardim Alvorada", "Sul", "12240530");
		Endereco rua4008 = new Endereco(null, "Avenida Cassiano Ricardo", "Jardim Alvorada", "Sul", "12240540");
		Endereco rua4009 = new Endereco(null, "Avenida da Liberdade", "Jardim Alvorada", "Sul", "12240550");
		Endereco rua4010 = new Endereco(null, "Rua Araçatuba", "Jardim Alvorada", "Sul", "12240560");
		Endereco rua4011 = new Endereco(null, "Avenida Aclimação", "Jardim Alvorada", "Sul", "12240570");
		Endereco rua4012 = new Endereco(null, "Rua Itapetininga", "Jardim Alvorada", "Sul", "12240571");
		Endereco rua4013 = new Endereco(null, "Rua Santos", "Jardim Alvorada", "Sul", "12240580");
		Endereco rua4014 = new Endereco(null, "Rua Itu", "Jardim Alvorada", "Sul", "12240590");
		Endereco rua4015 = new Endereco(null, "Rua Sorocaba", "Jardim Alvorada", "Sul", "12240600");
		Endereco rua4016 = new Endereco(null, "Rua Avaré", "Jardim Alvorada", "Sul", "12240601");
		Endereco rua4017 = new Endereco(null, "Rua Campinas", "Jardim Alvorada", "Sul", "12240620");
		Endereco rua4018 = new Endereco(null, "Rua Ribeirão Preto", "Jardim Alvorada", "Sul", "12240630");
		Endereco rua4019 = new Endereco(null, "Rua Botucatu", "Jardim Alvorada", "Sul", "12240640");
		Endereco rua4020 = new Endereco(null, "Rua Limeira", "Jardim Alvorada", "Sul", "12240650");
		Endereco rua4021 = new Endereco(null, "Rua Jundiai", "Jardim Alvorada", "Sul", "12240651");
		Endereco rua4022 = new Endereco(null, "Praça Alvorada", "Jardim Alvorada", "Sul", "12240652");
		Endereco rua4023 = new Endereco(null, "Rua Marília", "Jardim Alvorada", "Sul", "12240660");
		Endereco rua4024 = new Endereco(null, "Rua Bauru", "Jardim Alvorada", "Sul", "12240670");
		Endereco rua4025 = new Endereco(null, "Avenida Engenheiro Francisco Prestes Maia", "Jardim das Indústrias",
				"Sul", "12240680");
		Endereco rua4026 = new Endereco(null, "Rua Winston Churchill", "Jardim das Indústrias", "Sul", "12240681");
		Endereco rua4027 = new Endereco(null, "Rua Antônio Domingues Vasconcelos", "Jardim das Indústrias", "Sul",
				"12240690");
		Endereco rua4028 = new Endereco(null, "Rua Glicério Paula Galvão", "Jardim das Indústrias", "Sul", "12240700");
		Endereco rua4029 = new Endereco(null, "Rua Manoel Bandeira", "Jardim das Indústrias", "Sul", "12240710");
		Endereco rua4030 = new Endereco(null, "Rua Francisco Braúlio Filho", "Jardim das Indústrias", "Sul",
				"12240720");
		Endereco rua4031 = new Endereco(null, "Rua Manoel Pio", "Jardim das Indústrias", "Sul", "12240730");
		Endereco rua4032 = new Endereco(null, "Rua Dona Maria Augusta Fagundes Gomes", "Jardim das Indústrias", "Sul",
				"12240740");
		Endereco rua4033 = new Endereco(null, "Rua Francisco Aguade Gils", "Jardim das Indústrias", "Sul", "12240750");
		Endereco rua4034 = new Endereco(null, "Rua Jad'alah Chedid Salomão", "Jardim das Indústrias", "Sul",
				"12240751");
		Endereco rua4035 = new Endereco(null, "Rua Bernardo de Grabois", "Jardim das Indústrias", "Sul", "12240760");
		Endereco rua4036 = new Endereco(null, "Rua Corifeu de Azevedo Marques", "Jardim das Indústrias", "Sul",
				"12240780");
		Endereco rua4037 = new Endereco(null, "Rua Andirá", "Jardim das Indústrias", "Sul", "12240781");
		Endereco rua4038 = new Endereco(null, "Avenida Cassiano Ricardo", " 179", "Jardim Alvorada", "Sul");
		Endereco rua4039 = new Endereco(null, "Avenida Cassiano Ricardo", " 761", "Jardim Alvorada", "Sul");
		Endereco rua4040 = new Endereco(null, "Rodovia Presidente Dutra", " s/n", "Jardim das Indústrias", "Sul");
		Endereco rua4041 = new Endereco(null, "Rodovia Presidente Dutra", " s/n", "Jardim das Indústrias", "Sul");
		Endereco rua4042 = new Endereco(null, "Rodovia Presidente Dutra", " Km 154", "Jardim das Indústrias", "Sul");
		Endereco rua4043 = new Endereco(null, "Rodovia Presidente Dutra", " Km 154", "Jardim das Indústrias", "Sul");
		Endereco rua4044 = new Endereco(null, "Rodovia Presidente Dutra", " Km 154", "Jardim das Indústrias", "Sul");
		Endereco rua4045 = new Endereco(null, "Rua Heitor de Andrade", "Jardim das Indústrias", "Sul", "12241000");
		Endereco rua4046 = new Endereco(null, "Rua Leôncio Americano do Nascimento", "Jardim das Indústrias", "Sul",
				"12241010");
		Endereco rua4047 = new Endereco(null, "Rua Benedito da Silva Maia", "Jardim das Indústrias", "Sul", "12241020");
		Endereco rua4048 = new Endereco(null, "Rua Augusto Frederico Schimidt", "Jardim das Indústrias", "Sul",
				"12241030");
		Endereco rua4049 = new Endereco(null, "Rua Corifeu de Azevedo Marques", "Jardim das Indústrias", "Sul",
				"12241040");
		Endereco rua4050 = new Endereco(null, "Rua Ibate", "Jardim das Indústrias", "Sul", "12241050");
		Endereco rua4051 = new Endereco(null, "Avenida Rio Claro", "Jardim das Indústrias", "Sul", "12241060");
		Endereco rua4052 = new Endereco(null, "Rua Manoel Bosco Ribeiro", "Jardim das Indústrias", "Sul", "12241070");
		Endereco rua4053 = new Endereco(null, "Rua Penápolis", "Jardim das Indústrias", "Sul", "12241080");
		Endereco rua4054 = new Endereco(null, "Rua das Paineiras", "Jardim das Indústrias", "Sul", "12241090");
		Endereco rua4055 = new Endereco(null, "Praça Flamboyant", "Jardim das Indústrias", "Sul", "12241100");
		Endereco rua4056 = new Endereco(null, "Rua Registro", "Jardim das Indústrias", "Sul", "12241110");
		Endereco rua4057 = new Endereco(null, "Rua Pitangueiras", "Jardim das Indústrias", "Sul", "12241120");
		Endereco rua4058 = new Endereco(null, "Rua Tambaú", "Jardim das Indústrias", "Sul", "12241130");
		Endereco rua4059 = new Endereco(null, "Rua Descalvado", "Jardim das Indústrias", "Sul", "12241140");
		Endereco rua4060 = new Endereco(null, "Rua Osasco", "Jardim das Indústrias", "Sul", "12241150");
		Endereco rua4061 = new Endereco(null, "Rua Sibipiruna", "Jardim das Indústrias", "Sul", "12241160");
		Endereco rua4062 = new Endereco(null, "Rua Mamede Alves Cardoso", "Jardim das Indústrias", "Sul", "12241170");
		Endereco rua4063 = new Endereco(null, "Rua das Seringueiras", "Jardim das Indústrias", "Sul", "12241180");
		Endereco rua4064 = new Endereco(null, "Rua dos Cajueiros", "Jardim das Indústrias", "Sul", "12241190");
		Endereco rua4065 = new Endereco(null, "Rua Emílio Marelo", "Jardim das Indústrias", "Sul", "12241200");
		Endereco rua4066 = new Endereco(null, "Rua Imbuia", "Jardim das Indústrias", "Sul", "12241210");
		Endereco rua4067 = new Endereco(null, "Rua Ipê", "Jardim das Indústrias", "Sul", "12241220");
		Endereco rua4068 = new Endereco(null, "Rua Peroba", "Jardim das Indústrias", "Sul", "12241230");
		Endereco rua4069 = new Endereco(null, "Rua Jequitibá", "Jardim das Indústrias", "Sul", "12241240");
		Endereco rua4070 = new Endereco(null, "Rua Jacarandá", "Jardim das Indústrias", "Sul", "12241250");
		Endereco rua4071 = new Endereco(null, "Rua dos Carvalhos", "Jardim das Indústrias", "Sul", "12241260");
		Endereco rua4072 = new Endereco(null, "Rua Cedro", "Jardim das Indústrias", "Sul", "12241270");
		Endereco rua4073 = new Endereco(null, "Rua Matsustoco Taira", "Jardim Limoeiro", "Sul", "12241280");
		Endereco rua4074 = new Endereco(null, "Rua Renato Alves da Cunha", "Jardim Limoeiro", "Sul", "12241290");
		Endereco rua4075 = new Endereco(null, "Rua Olga Rocha de Moraes", "Jardim Limoeiro", "Sul", "12241300");
		Endereco rua4076 = new Endereco(null, "Rua Pedro Soares de Moraes", "Jardim Limoeiro", "Sul", "12241310");
		Endereco rua4077 = new Endereco(null, "Rua Benedito Joaquim Pereira", "Jardim Limoeiro", "Sul", "12241320");
		Endereco rua4078 = new Endereco(null, "Rua Valdir Guratti", "Jardim Limoeiro", "Sul", "12241330");
		Endereco rua4079 = new Endereco(null, "Rua Sérgio Gonzaga Azevedo", "Jardim Limoeiro", "Sul", "12241340");
		Endereco rua4080 = new Endereco(null, "Rua Hélio José Bertolini Freire", "Jardim Limoeiro", "Sul", "12241350");
		Endereco rua4081 = new Endereco(null, "Rua Estácio José do Nascimento", "Jardim Limoeiro", "Sul", "12241360");
		Endereco rua4082 = new Endereco(null, "Rodovia Presidente Dutra", "Jardim Limoeiro", "Sul", "12241361");
		Endereco rua4083 = new Endereco(null, "Avenida Tecsat", "Jardim Limoeiro", "Sul", "12241365");
		Endereco rua4084 = new Endereco(null, "Rua Amauri de Oliveira", "Jardim Limoeiro", "Sul", "12241370");
		Endereco rua4085 = new Endereco(null, "Rua Oswaldo de Pinto Guimarães", "Jardim Limoeiro", "Sul", "12241380");
		Endereco rua4086 = new Endereco(null, "Rua Jairo Pinto Figueredo", "Jardim Limoeiro", "Sul", "12241390");
		Endereco rua4087 = new Endereco(null, "Estrada Municipal do Limoeiro", "Jardim Limoeiro", "Sul", "12241400");
		Endereco rua4088 = new Endereco(null, "Travessa Municipal do Limoeiro", "Jardim Limoeiro", "Sul", "12241410");
		Endereco rua4089 = new Endereco(null, "Rua Pedro Luiz de Oliveira Costa", "Jardim Limoeiro", "Sul", "12241420");
		Endereco rua4090 = new Endereco(null, "Rua Carlos Marcondes", "Jardim Limoeiro", "Sul", "12241421");
		Endereco rua4091 = new Endereco(null, "Praça Mário Malta Guimarães", "Jardim Limoeiro", "Sul", "12241422");
		Endereco rua4092 = new Endereco(null, "Rua Doutor Pedro Luiz de Oliveira Costa", "Jardim Limoeiro", "Sul",
				"12241430");
		Endereco rua4093 = new Endereco(null, "Rua da Palha", "Jardim Limoeiro", "Sul", "12241440");
		Endereco rua4094 = new Endereco(null, "Rua Alberto de Moraes Bittencourt Simões", "Jardim Limoeiro", "Sul",
				"12241450");
		Endereco rua4095 = new Endereco(null, "Rua Particular", "Jardim Limoeiro", "Sul", "12241460");
		Endereco rua4096 = new Endereco(null, "Rua Projetada", "Jardim Limoeiro", "Sul", "12241470");
		Endereco rua4097 = new Endereco(null, "Rua Carlos Marcondes", " 1200", "Jardim Limoeiro", "Sul");
		Endereco rua4098 = new Endereco(null, "Rodovia Presidente Dutra", " Km 159", "Jardim Limoeiro", "Sul");
		Endereco rua4099 = new Endereco(null, "Avenida São João", "Jardim das Colinas", "Sul", "12242000");
		Endereco rua4100 = new Endereco(null, "Avenida Doutor Eduardo Cury", "Jardim das Colinas", "Sul", "12242001");
		Endereco rua4101 = new Endereco(null, "Rua Professora Lila Barboza", "Jardim das Colinas", "Sul", "12242005");
		Endereco rua4102 = new Endereco(null, "Avenida Deputado Benedito Matarazzo", "Jardim das Colinas", "Sul",
				"12242010");
		Endereco rua4103 = new Endereco(null, "Avenida Engenheiro Florestan Fernandes", "Jardim Serimbura", "Sul",
				"12242012");
		Endereco rua4104 = new Endereco(null, "Avenida Rodrigo Reis Tuy", "Jardim Serimbura", "Sul", "12242014");
		Endereco rua4105 = new Endereco(null, "Avenida Jorge Zarur", "Jardim Aquárius", "Sul", "12242020");
		Endereco rua4106 = new Endereco(null, "Bulevar Villa-Lobos", "Jardim Aquárius", "Sul", "12242021");
		Endereco rua4107 = new Endereco(null, "Alameda Chopin", "Jardim Aquárius", "Sul", "12242030");
		Endereco rua4108 = new Endereco(null, "Alameda Beethoven", "Jardim Aquárius", "Sul", "12242031");
		Endereco rua4109 = new Endereco(null, "Alameda Mozart", "Jardim Aquárius", "Sul", "12242032");
		Endereco rua4110 = new Endereco(null, "Alameda Vivaldi", "Jardim Aquárius", "Sul", "12242033");
		Endereco rua4111 = new Endereco(null, "Alameda Ravel", "Jardim Aquárius", "Sul", "12242034");
		Endereco rua4112 = new Endereco(null, "Rua Calisto", "Jardim das Colinas", "Sul", "12242035");
		Endereco rua4113 = new Endereco(null, "Avenida João Tuca", "Jardim das Colinas", "Sul", "12242050");
		Endereco rua4114 = new Endereco(null, "Avenida Major Miguel Naked", "Jardim das Colinas", "Sul", "12242051");
		Endereco rua4115 = new Endereco(null, "Rua Professor Carlos Alberto de Buarque Borges", "Jardim das Colinas",
				"Sul", "12242060");
		Endereco rua4116 = new Endereco(null, "Rua Francisco de Oliveira Pinto", "Jardim das Colinas", "Sul",
				"12242070");
		Endereco rua4117 = new Endereco(null, "Rua Marechal-do-Ar Benjamim Manoel Amarante", "Jardim das Colinas",
				"Sul", "12242071");
		Endereco rua4118 = new Endereco(null, "Rua Professora Renê Maria Vandaele", "Jardim das Colinas", "Sul",
				"12242080");
		Endereco rua4119 = new Endereco(null, "Rua Professor Richard Robert Wallauchek", "Jardim das Colinas", "Sul",
				"12242090");
		Endereco rua4120 = new Endereco(null, "Rua Coronel Hildebrando Pralon Ferreira Leite", "Jardim das Colinas",
				"Sul", "12242100");
		Endereco rua4121 = new Endereco(null, "Rua Doutor Paulo Felizardo", "Jardim das Colinas", "Sul", "12242110");
		Endereco rua4122 = new Endereco(null, "Rua Major Dietrich Ott", "Jardim das Colinas", "Sul", "12242111");
		Endereco rua4123 = new Endereco(null, "Rua José Raimundo da Silva", "Jardim das Colinas", "Sul", "12242120");
		Endereco rua4124 = new Endereco(null, "Rua Doutor Pedro Popini Mascarenhas", "Jardim das Colinas", "Sul",
				"12242130");
		Endereco rua4125 = new Endereco(null, "Praça Jorge Vieira da Silva", "Jardim das Colinas", "Sul", "12242131");
		Endereco rua4126 = new Endereco(null, "Avenida Saul Vieira", "Jardim das Colinas", "Sul", "12242140");
		Endereco rua4127 = new Endereco(null, "Rua Victório Peneluppi", "Jardim das Colinas", "Sul", "12242150");
		Endereco rua4128 = new Endereco(null, "Rua Ceramista Roberto Weiss", "Jardim das Colinas", "Sul", "12242160");
		Endereco rua4129 = new Endereco(null, "Avenida Paul Harris", "Jardim das Colinas", "Sul", "12242170");
		Endereco rua4130 = new Endereco(null, "Avenida Jornalista Napoleão Monteiro", "Jardim das Colinas", "Sul",
				"12242180");
		Endereco rua4131 = new Endereco(null, "Rua Salim Felizardo", "Jardim das Colinas", "Sul", "12242181");
		Endereco rua4132 = new Endereco(null, "Rua Antônio Eras", "Jardim das Colinas", "Sul", "12242190");
		Endereco rua4133 = new Endereco(null, "Rua Ângelo Rodrigues Alves", "Jardim das Colinas", "Sul", "12242200");
		Endereco rua4134 = new Endereco(null, "Avenida Ulisses Dias Costa", "Jardim das Colinas", "Sul", "12242210");
		Endereco rua4135 = new Endereco(null, "Avenida Professor José Luiz Pereira Garcez", "Jardim das Colinas", "Sul",
				"12242220");
		Endereco rua4136 = new Endereco(null, "Rua Antônio Cara", "Jardim das Colinas", "Sul", "12242221");
		Endereco rua4137 = new Endereco(null, "Rua Valdemar Raimundo da Silva", "Jardim das Colinas", "Sul",
				"12242222");
		Endereco rua4138 = new Endereco(null, "Rua Flaminio Vaz de Lima", "Jardim das Colinas", "Sul", "12242230");
		Endereco rua4139 = new Endereco(null, "Rua Professor João Batista Ortiz Monteiro", "Jardim das Colinas", "Sul",
				"12242240");
		Endereco rua4140 = new Endereco(null, "Rua Padre José Maria da Silva Ramos", "Jardim das Colinas", "Sul",
				"12242250");
		Endereco rua4141 = new Endereco(null, "Avenida Hellmuth P. Schicker", "Jardim das Colinas", "Sul", "12242260");
		Endereco rua4142 = new Endereco(null, "Avenida Manoel Borba Gato", "Jardim Nova América", "Sul", "12242270");
		Endereco rua4143 = new Endereco(null, "Praça Nossa Senhora de Fátima", "Jardim Nova América", "Sul",
				"12242271");
		Endereco rua4144 = new Endereco(null, "Avenida Anchieta", "Jardim Nova América", "Sul", "12242280");
		Endereco rua4145 = new Endereco(null, "Praça Alexandra Diacov", "Jardim Nova América", "Sul", "12242281");
		Endereco rua4146 = new Endereco(null, "Rua Brás Cubas", "Jardim Nova América", "Sul", "12242300");
		Endereco rua4147 = new Endereco(null, "Rua Afonso Sardinha", "Jardim Esplanada", "Sul", "12242310");
		Endereco rua4148 = new Endereco(null, "Rua Pascoal Moreira", "Jardim Esplanada", "Sul", "12242311");
		Endereco rua4149 = new Endereco(null, "Rua Ana Maria Nardo Silva", "Jardim Esplanada", "Sul", "12242410");
		Endereco rua4150 = new Endereco(null, "Viaduto Reverendo José Pereira da Costa", "Jardim Esplanada", "Sul",
				"12242411");
		Endereco rua4151 = new Endereco(null, "Rotatória Monsenhor José Maria Escrivã", "Jardim Esplanada", "Sul",
				"12242412");
		Endereco rua4152 = new Endereco(null, "Rua Bartolomeu de Gusmão", "Jardim Esplanada", "Sul", "12242420");
		Endereco rua4153 = new Endereco(null, "Travessa Duque Estrada", "Jardim Esplanada", "Sul", "12242430");
		Endereco rua4154 = new Endereco(null, "Rua Laurent Martins", "Jardim Esplanada", "Sul", "12242431");
		Endereco rua4155 = new Endereco(null, "Rua Graça Aranha", "Jardim Esplanada", "Sul", "12242440");
		Endereco rua4156 = new Endereco(null, "Travessa Graça Aranha", "Jardim Esplanada", "Sul", "12242441");
		Endereco rua4157 = new Endereco(null, "Rua Carlos Sattelmayer", "Jardim Esplanada", "Sul", "12242450");
		Endereco rua4158 = new Endereco(null, "Rua Professor Roberval Froes", "Jardim Esplanada", "Sul", "12242460");
		Endereco rua4159 = new Endereco(null, "Avenida Paulista", "Jardim Esplanada", "Sul", "12242470");
		Endereco rua4160 = new Endereco(null, "Praça Floripes Bicudo Martins", "Jardim Esplanada", "Sul", "12242471");
		Endereco rua4161 = new Endereco(null, "Rua Professora Aparecida Azevedo Branco", "Jardim Esplanada", "Sul",
				"12242480");
		Endereco rua4162 = new Endereco(null, "Rua Henrique Mudat", "Jardim Esplanada", "Sul", "12242490");
		Endereco rua4163 = new Endereco(null, "Rua Irmã Maria Demetria Kfuri", "Jardim Esplanada", "Sul", "12242500");
		Endereco rua4164 = new Endereco(null, "Rua Nicola Lafaif", "Jardim Esplanada", "Sul", "12242520");
		Endereco rua4165 = new Endereco(null, "Travessa Nossa Senhora Auxiliadora", "Jardim Esplanada", "Sul",
				"12242521");
		Endereco rua4166 = new Endereco(null, "Rua João Bicudo", "Jardim Esplanada", "Sul", "12242530");
		Endereco rua4167 = new Endereco(null, "Rua Carlos de Campos", "Jardim Esplanada", "Sul", "12242540");
		Endereco rua4168 = new Endereco(null, "Travessa Felipe Camarão", "Jardim Esplanada", "Sul", "12242541");
		Endereco rua4169 = new Endereco(null, "Rua Victor Antônio Celeste", "Jardim Esplanada", "Sul", "12242550");
		Endereco rua4170 = new Endereco(null, "Praça Bartolomeu Bueno da Silva", "Jardim Esplanada", "Sul", "12242551");
		Endereco rua4171 = new Endereco(null, "Rua Joaquim de Moura Candelaria", "Jardim Esplanada", "Sul", "12242560");
		Endereco rua4172 = new Endereco(null, "Rua Doutor Fernando Costa", "Jardim Esplanada", "Sul", "12242570");
		Endereco rua4173 = new Endereco(null, "Rua Fernão Dias", "Jardim Nova América", "Sul", "12242580");
		Endereco rua4174 = new Endereco(null, "Rua Antônio Rodrigues Arzão", "Jardim Nova América", "Sul", "12242600");
		Endereco rua4175 = new Endereco(null, "Rua Raposo Tavares", "Jardim Nova América", "Sul", "12242610");
		Endereco rua4176 = new Endereco(null, "Rua Domingos Jorge Velho", "Jardim Nova América", "Sul", "12242615");
		Endereco rua4177 = new Endereco(null, "Rua Domingos Jorge Velho", "Jardim Esplanada", "Sul", "12242620");
		Endereco rua4178 = new Endereco(null, "Rua Antônio Dias Adorno", "Jardim Esplanada II", "Sul", "12242630");
		Endereco rua4179 = new Endereco(null, "Rua Sebastião Tourinho", "Jardim Esplanada II", "Sul", "12242640");
		Endereco rua4180 = new Endereco(null, "Rua Garcia Rodrigues Paes", "Jardim Esplanada II", "Sul", "12242641");
		Endereco rua4181 = new Endereco(null, "Rua Benedito da Silva Ramos", "Jardim Esplanada II", "Sul", "12242650");
		Endereco rua4182 = new Endereco(null, "Rua Leopoldo Rossi", "Jardim Esplanada II", "Sul", "12242660");
		Endereco rua4183 = new Endereco(null, "Rua Pascoal Moreira", "Jardim Nova América", "Sul", "12242670");
		Endereco rua4184 = new Endereco(null, "Travessa Maria Quitéria", "Jardim Esplanada II", "Sul", "12242671");
		Endereco rua4185 = new Endereco(null, "Rua dos Andradas", "Jardim Esplanada II", "Sul", "12242680");
		Endereco rua4186 = new Endereco(null, "Rua Barão de Mauá", "Jardim Esplanada II", "Sul", "12242690");
		Endereco rua4187 = new Endereco(null, "Praça Sinésio Martins", "Jardim Esplanada II", "Sul", "12242700");
		Endereco rua4188 = new Endereco(null, "Rua Pandiá Calógeras", "Jardim Esplanada II", "Sul", "12242710");
		Endereco rua4189 = new Endereco(null, "Rua Vital Brasil", "Jardim Esplanada II", "Sul", "12242720");
		Endereco rua4190 = new Endereco(null, "Rua Carlos Chagas", "Jardim Esplanada II", "Sul", "12242730");
		Endereco rua4191 = new Endereco(null, "Rua Marcilio Dias", "Jardim Esplanada II", "Sul", "12242731");
		Endereco rua4192 = new Endereco(null, "Rua Antônio de Queiroz Filho", "Jardim Esplanada II", "Sul", "12242740");
		Endereco rua4193 = new Endereco(null, "Rua Pio XII", "Jardim Esplanada II", "Sul", "12242750");
		Endereco rua4194 = new Endereco(null, "Rua Artur Neiva", "Jardim Esplanada II", "Sul", "12242760");
		Endereco rua4195 = new Endereco(null, "Rua Humberto de Campos", "Jardim Esplanada II", "Sul", "12242770");
		Endereco rua4196 = new Endereco(null, "Rua Presidente Wenceslau Braz", "Jardim Esplanada II", "Sul",
				"12242780");
		Endereco rua4197 = new Endereco(null, "Rua Clóvis Bevilacqua", "Jardim Esplanada II", "Sul", "12242790");
		Endereco rua4198 = new Endereco(null, "Avenida Barão do Rio Branco", "Jardim Esplanada II", "Sul", "12242800");
		Endereco rua4199 = new Endereco(null, "Rua Coronel Manoel Martins Júnior", "Jardim Esplanada II", "Sul",
				"12242810");
		Endereco rua4200 = new Endereco(null, "Travessa Pedro Dellias", "Jardim Esplanada II", "Sul", "12242820");
		Endereco rua4201 = new Endereco(null, "Praça Pedro David", "Jardim Esplanada II", "Sul", "12242830");
		Endereco rua4202 = new Endereco(null, "Avenida São João", "Jardim Esplanada", "Sul", "12242840");
		Endereco rua4203 = new Endereco(null, "Bulevar Villa-Lobos", " 41", "Jardim Esplanada", "Sul");
		Endereco rua4204 = new Endereco(null, "Avenida Jorge Zarur", " 274", "Jardim Aquárius", "Sul");
		Endereco rua4205 = new Endereco(null, "Avenida São João", " s/n", "Jardim Esplanada", "Sul");
		Endereco rua4206 = new Endereco(null, "Avenida São João", " 323", "Jardim Esplanada", "Sul");
		Endereco rua4207 = new Endereco(null, "Avenida São João", " 748", "Jardim Esplanada", "Sul");
		Endereco rua4208 = new Endereco(null, "Avenida Deputado Benedito Matarazzo", " 7007", "Jardim das Colinas",
				"Sul");
		Endereco rua4209 = new Endereco(null, "Avenida São João", " 2200", "Jardim das Colinas", "Sul");
		Endereco rua4210 = new Endereco(null, "Avenida São João", " 69", "Jardim Esplanada", "Sul");
		Endereco rua4211 = new Endereco(null, "Avenida Nove de Julho", "Jardim Apolo", "Sul", "12243000");
		Endereco rua4212 = new Endereco(null, "Avenida Nove de Julho", "Jardim Apolo", "Sul", "12243001");
		Endereco rua4213 = new Endereco(null, "Rua Euclides Figueiredo", "Jardim Apolo I", "Sul", "12243002");
		Endereco rua4214 = new Endereco(null, "Praça Cândida Maria César Sawaya Giana", "Jardim Apolo I", "Sul",
				"12243003");
		Endereco rua4215 = new Endereco(null, "Rua Coronel Francisco Américo Fontenele", "Jardim Apolo I", "Sul",
				"12243004");
		Endereco rua4216 = new Endereco(null, "Rua Assuntina Ciocchi Blair", "Jardim Apolo II", "Sul", "12243090");
		Endereco rua4217 = new Endereco(null, "Rua Paulo Edson Blair", "Jardim Apolo II", "Sul", "12243100");
		Endereco rua4218 = new Endereco(null, "Rua Augusto Edson Ehlke", "Jardim Apolo II", "Sul", "12243110");
		Endereco rua4219 = new Endereco(null, "Rua Pedro Rabelo de Araújo", "Jardim Apolo II", "Sul", "12243111");
		Endereco rua4220 = new Endereco(null, "Rua Amparo", "Jardim Apolo I", "Sul", "12243120");
		Endereco rua4221 = new Endereco(null, "Rua Ubatuba", "Jardim Apolo I", "Sul", "12243130");
		Endereco rua4222 = new Endereco(null, "Rua Lindoia", "Jardim Apolo I", "Sul", "12243140");
		Endereco rua4223 = new Endereco(null, "Rua Caraguatatuba", "Jardim Apolo I", "Sul", "12243150");
		Endereco rua4224 = new Endereco(null, "Rua Itanhaém", "Jardim Apolo I", "Sul", "12243160");
		Endereco rua4225 = new Endereco(null, "Rua Assis", "Jardim Apolo I", "Sul", "12243170");
		Endereco rua4226 = new Endereco(null, "Rua Taquaritinga", "Jardim Apolo I", "Sul", "12243180");
		Endereco rua4227 = new Endereco(null, "Rua Serra Negra", "Jardim Apolo I", "Sul", "12243190");
		Endereco rua4228 = new Endereco(null, "Rua Itatiba", "Jardim Apolo I", "Sul", "12243200");
		Endereco rua4229 = new Endereco(null, "Rua Atibaia", "Jardim Apolo I", "Sul", "12243210");
		Endereco rua4230 = new Endereco(null, "Rua Itapira", "Jardim Apolo I", "Sul", "12243220");
		Endereco rua4231 = new Endereco(null, "Rua Guarujá", "Jardim Apolo I", "Sul", "12243230");
		Endereco rua4232 = new Endereco(null, "Rua Socorro", "Jardim Apolo I", "Sul", "12243240");
		Endereco rua4233 = new Endereco(null, "Rua Santa Margarida", "Jardim Santa Madalena", "Sul", "12243270");
		Endereco rua4234 = new Endereco(null, "Rua Santa Luzia", "Jardim Santa Madalena", "Sul", "12243280");
		Endereco rua4235 = new Endereco(null, "Travessa Santa Inês", "Jardim Santa Madalena", "Sul", "12243290");
		Endereco rua4236 = new Endereco(null, "Rua Santa Madalena", "Jardim Santa Madalena", "Sul", "12243300");
		Endereco rua4237 = new Endereco(null, "Rua Santa Sofia", "Jardim Santa Madalena", "Sul", "12243310");
		Endereco rua4238 = new Endereco(null, "Praça Chuí", "Jardim Fátima", "Sul", "12243380");
		Endereco rua4239 = new Endereco(null, "Rua Ribeirão Vermelho", "Jardim Fátima", "Sul", "12243390");
		Endereco rua4240 = new Endereco(null, "Rua Ipiranga", "Jardim Fátima", "Sul", "12243400");
		Endereco rua4241 = new Endereco(null, "Rua Ribeirão Claro", "Jardim Fátima", "Sul", "12243500");
		Endereco rua4242 = new Endereco(null, "Rua Ribeirão Bonito", "Jardim Fátima", "Sul", "12243510");
		Endereco rua4243 = new Endereco(null, "Rua Maria Lima Antunes Ribeiro", "Jardim Fátima", "Sul", "12243520");
		Endereco rua4244 = new Endereco(null, "Praça Tertuliano Moraes Delfim", "Jardim Margareth", "Sul", "12243530");
		Endereco rua4245 = new Endereco(null, "Rua Félicio Chiocchi", "Jardim Margareth", "Sul", "12243540");
		Endereco rua4246 = new Endereco(null, "Rua Luiz Gonzaga Teixeira Leite", "Jardim Margareth", "Sul", "12243550");
		Endereco rua4247 = new Endereco(null, "Rua Hamid Said Amim", "Jardim Margareth", "Sul", "12243560");
		Endereco rua4248 = new Endereco(null, "Rua José Cristiano da Fonseca", "Jardim Margareth", "Sul", "12243561");
		Endereco rua4249 = new Endereco(null, "Rua Rio Bonito", "Jardim Margareth", "Sul", "12243562");
		Endereco rua4250 = new Endereco(null, "Rua Rio Claro", "Jardim Margareth", "Sul", "12243563");
		Endereco rua4251 = new Endereco(null, "Praça Pedro Americo", "Jardim Maringá", "Sul", "12243570");
		Endereco rua4252 = new Endereco(null, "Rua Euclides da Cunha", "Jardim Maringá", "Sul", "12243580");
		Endereco rua4253 = new Endereco(null, "Rua General Osório", "Jardim Maringá", "Sul", "12243590");
		Endereco rua4254 = new Endereco(null, "Rua Casemiro de Abreu", "Jardim Maringá", "Sul", "12243600");
		Endereco rua4255 = new Endereco(null, "Avenida Nove de Julho", " 579", "Jardim Apolo", "Sul");
		Endereco rua4256 = new Endereco(null, "Avenida Nove de Julho", " 34", "Jardim Apolo", "Sul");
		Endereco rua4257 = new Endereco(null, "Rua Francisco Marques dos Santos", "Jardim do Golfe", "Sul", "12244631");
		Endereco rua4258 = new Endereco(null, "Rua Ivan Mimessi", "Jardim do Golfe", "Sul", "12244632");
		Endereco rua4259 = new Endereco(null, "Rua José Fábio Tau", "Jardim do Golfe", "Sul", "12244633");
		Endereco rua4260 = new Endereco(null, "Rua José Salgado Cesar", "Jardim do Golfe", "Sul", "12244634");
		Endereco rua4261 = new Endereco(null, "Rua Marcos Beig", "Jardim do Golfe", "Sul", "12244635");
		Endereco rua4262 = new Endereco(null, "Avenida Mario Fowler", "Jardim do Golfe", "Sul", "12244636");
		Endereco rua4263 = new Endereco(null, "Rua Miguel Liberato", "Jardim do Golfe", "Sul", "12244637");
		Endereco rua4264 = new Endereco(null, "Rua Roberto Celeste", "Jardim do Golfe", "Sul", "12244638");
		Endereco rua4265 = new Endereco(null, "Rua Rubens Savastano", "Jardim do Golfe", "Sul", "12244639");
		Endereco rua4266 = new Endereco(null, "Rua Simão Chuster", "Jardim do Golfe", "Sul", "12244641");
		Endereco rua4267 = new Endereco(null, "Rua José Rocha da Silva", "Jardim do Golfe", "Sul", "12244642");
		Endereco rua4268 = new Endereco(null, "Avenida Loth Bagunha Maldos", "Jardim do Golfe", "Sul", "12244643");
		Endereco rua4269 = new Endereco(null, "Rua François Armand Christophe", "Jardim do Golfe", "Sul", "12244644");
		Endereco rua4270 = new Endereco(null, "Rua Ailda Fartes de Paiva", "Jardim do Golfe", "Sul", "12244645");
		Endereco rua4271 = new Endereco(null, "Rua José Amin Daher Neto", "Jardim do Golfe", "Sul", "12244646");
		Endereco rua4272 = new Endereco(null, "Rua Geraldo Patricio", "Jardim do Golfe", "Sul", "12244647");
		Endereco rua4273 = new Endereco(null, "Rua Guilherme Rosa da Silva", "Jardim do Golfe", "Sul", "12244648");
		Endereco rua4274 = new Endereco(null, "Rua Irineu de Mello", "Jardim do Golfe", "Sul", "12244649");
		Endereco rua4275 = new Endereco(null, "Rua Narciso da Silva Araújo", "Jardim do Golfe", "Sul", "12244651");
		Endereco rua4276 = new Endereco(null, "Rua Tarcília Gomes Ribeiro", "Jardim do Golfe", "Sul", "12244652");
		Endereco rua4277 = new Endereco(null, "Rua Mildes Agripina Junqueira Pereira", "Jardim do Golfe", "Sul",
				"12244653");
		Endereco rua4278 = new Endereco(null, "Rua José Ribeiro Homem Alves", "Jardim do Golfe", "Sul", "12244654");
		Endereco rua4279 = new Endereco(null, "Rua Eriberto Monteiro", "Jardim do Golfe", "Sul", "12244655");
		Endereco rua4280 = new Endereco(null, "Rua José Cesar Filho", "Jardim do Golfe", "Sul", "12244656");
		Endereco rua4281 = new Endereco(null, "Rua Theresinha Mello Peneluppi", "Jardim do Golfe", "Sul", "12244657");
		Endereco rua4282 = new Endereco(null, "Rua Jorge Pinto de Souza", "Jardim do Golfe", "Sul", "12244658");
		Endereco rua4283 = new Endereco(null, "Rua Lucia Nunes Vieira Rosa", "Jardim do Golfe", "Sul", "12244659");
		Endereco rua4284 = new Endereco(null, "Rua Caio Nelson de Almeida", "Jardim do Golfe", "Sul", "12244671");
		Endereco rua4285 = new Endereco(null, "Rua Nelson Gonçalves Bem", "Jardim do Golfe", "Sul", "12244676");
		Endereco rua4286 = new Endereco(null, "Rua Gabriel Gil Lopes", "Jardim do Golfe", "Sul", "12244677");
		Endereco rua4287 = new Endereco(null, "Rua Paulo de Faria", "Jardim do Golfe", "Sul", "12244678");
		Endereco rua4288 = new Endereco(null, "Avenida Engenheiro Francisco José Longo", "Jardim São Dimas", "Sul",
				"12245000");
		Endereco rua4289 = new Endereco(null, "Avenida Engenheiro Francisco José Longo", "Jardim São Dimas", "Sul",
				"12245001");
		Endereco rua4290 = new Endereco(null, "Avenida Doutor Adhemar de Barros", "Jardim São Dimas", "Sul",
				"12245010");
		Endereco rua4291 = new Endereco(null, "Avenida Doutor Adhemar de Barros", "Jardim São Dimas", "Sul",
				"12245011");
		Endereco rua4292 = new Endereco(null, "Rua Turquia", "Jardim São Dimas", "Sul", "12245019");
		Endereco rua4293 = new Endereco(null, "Rua Paraibuna", "Jardim São Dimas", "Sul", "12245020");
		Endereco rua4294 = new Endereco(null, "Rua Paraibuna", "Jardim São Dimas", "Sul", "12245021");
		Endereco rua4295 = new Endereco(null, "Viaduto Sérgio Sobral de Oliveira", "Jardim São Dimas", "Sul",
				"12245022");
		Endereco rua4296 = new Endereco(null, "Avenida Doutor Nelson D'Avila", "Jardim São Dimas", "Sul", "12245030");
		Endereco rua4297 = new Endereco(null, "Avenida Doutor Nelson D'Avila", "Jardim São Dimas", "Sul", "12245031");
		Endereco rua4298 = new Endereco(null, "Rua Ismael Vieira das Neves", "Jardim Aparecida", "Sul", "12245040");
		Endereco rua4299 = new Endereco(null, "Travessa Gisberto Ballarini", "Jardim Aparecida", "Sul", "12245050");
		Endereco rua4300 = new Endereco(null, "Travessa Darcy de Oliveira", "Jardim São Dimas", "Sul", "12245051");
		Endereco rua4301 = new Endereco(null, "Rua Manoel Ricardo Júnior", "Jardim São Dimas", "Sul", "12245061");
		Endereco rua4302 = new Endereco(null, "Travessa João Friggi", "Jardim São Dimas", "Sul", "12245070");
		Endereco rua4303 = new Endereco(null, "Travessa Rocha Pombo", "Jardim São Dimas", "Sul", "12245080");
		Endereco rua4304 = new Endereco(null, "Rua Jordão Monteiro Ferreira", "Jardim Aparecida", "Sul", "12245089");
		Endereco rua4305 = new Endereco(null, "Rua Doutor Mário Sampaio Martins", "Jardim São Dimas", "Sul",
				"12245100");
		Endereco rua4306 = new Endereco(null, "Praça Corretor de Imóveis", "Jardim São Dimas", "Sul", "12245105");
		Endereco rua4307 = new Endereco(null, "Rua Arnaldo Ricardo Monteiro", "Jardim Renata", "Sul", "12245110");
		Endereco rua4308 = new Endereco(null, "Travessa Manoel da Nóbrega", "Jardim São Dimas", "Sul", "12245112");
		Endereco rua4309 = new Endereco(null, "Rua Antônio da Silva Santos", "Jardim São Dimas", "Sul", "12245120");
		Endereco rua4310 = new Endereco(null, "Rua Leonildo Ramos Cruz", "Jardim São Dimas", "Sul", "12245130");
		Endereco rua4311 = new Endereco(null, "Rua Maestro Egydio Pinto", "Jardim São Dimas", "Sul", "12245190");
		Endereco rua4312 = new Endereco(null, "Rua Brigadeiro Osvaldo Nascimento Leal", "Jardim São Dimas", "Sul",
				"12245200");
		Endereco rua4313 = new Endereco(null, "Avenida Heitor Villa Lobos", "Jardim São Dimas", "Sul", "12245280");
		Endereco rua4314 = new Endereco(null, "Rua Tufi Simão Filho", "Jardim São Dimas", "Sul", "12245290");
		Endereco rua4315 = new Endereco(null, "Rua Ezra", "Jardim São Dimas", "Sul", "12245300");
		Endereco rua4316 = new Endereco(null, "Rua Helena David Neme", "Jardim São Dimas", "Sul", "12245310");
		Endereco rua4317 = new Endereco(null, "Rua Professor Frederico Eyer", "Jardim São Dimas", "Sul", "12245330");
		Endereco rua4318 = new Endereco(null, "Praça Elza Ferreira Rahal", "Jardim São Dimas", "Sul", "12245340");
		Endereco rua4319 = new Endereco(null, "Praça Melvin Jones", "Jardim São Dimas", "Sul", "12245360");
		Endereco rua4320 = new Endereco(null, "Rua Inconfidência", "Jardim São Dimas", "Sul", "12245370");
		Endereco rua4321 = new Endereco(null, "Rua Eliza Costa Santos", "Jardim São Dimas", "Sul", "12245380");
		Endereco rua4322 = new Endereco(null, "Rua Elza Bierfeld D'Avila", "Jardim Aparecida", "Sul", "12245381");
		Endereco rua4323 = new Endereco(null, "Rua Jorge de Moraes Barros", "Jardim São Dimas", "Sul", "12245390");
		Endereco rua4324 = new Endereco(null, "Rua José Antônio Romeno Neme", "Jardim São Dimas", "Sul", "12245400");
		Endereco rua4325 = new Endereco(null, "Rua Maria Francisca Froes", "Jardim São Dimas", "Sul", "12245410");
		Endereco rua4326 = new Endereco(null, "Rua Amin Assad", "Jardim São Dimas", "Sul", "12245411");
		Endereco rua4327 = new Endereco(null, "Travessa Senador Accyoli Filho", "Jardim São Dimas", "Sul", "12245420");
		Endereco rua4328 = new Endereco(null, "Rua Ilza Irma Moeller Coppio", "Jardim São Dimas", "Sul", "12245430");
		Endereco rua4329 = new Endereco(null, "Praça Monsenhor Ascânio Brandão", "Jardim São Dimas", "Sul", "12245440");
		Endereco rua4330 = new Endereco(null, "Rua José Mattar", "Jardim São Dimas", "Sul", "12245450");
		Endereco rua4331 = new Endereco(null, "Rua Paulo Setúbal", "Jardim São Dimas", "Sul", "12245460");
		Endereco rua4332 = new Endereco(null, "Rua Benedito Ivo", "Jardim Renata", "Sul", "12245531");
		Endereco rua4333 = new Endereco(null, "Rua Ataulfo Alves", "Jardim Renata", "Sul", "12245532");
		Endereco rua4334 = new Endereco(null, "Rua Décio Camargo Vieira", "Jardim Maringá", "Sul", "12245534");
		Endereco rua4335 = new Endereco(null, "Rua Benedito Teixeira", "Jardim Renata", "Sul", "12245551");
		Endereco rua4336 = new Endereco(null, "Rua Elias Paiotti", "Jardim Renata", "Sul", "12245561");
		Endereco rua4337 = new Endereco(null, "Loteamento Jardim Nova Esperança", "Centro", "Sul", "12245700");
		Endereco rua4338 = new Endereco(null, "Avenida Engenheiro Francisco José Longo", " 149", "Jardim São Dimas",
				"Sul");
		Endereco rua4339 = new Endereco(null, "Rua Euclides Miragaia", " 374", "Jardim São Dimas", "Sul");
		Endereco rua4340 = new Endereco(null, "Rua Euclides Miragaia", " 433", "Jardim São Dimas", "Sul");
		Endereco rua4341 = new Endereco(null, "Avenida Doutor Nelson D'Avila", " 1125", "Jardim São Dimas", "Sul");
		Endereco rua4342 = new Endereco(null, "Avenida Engenheiro Francisco José Longo", " 555", "Jardim São Dimas",
				"Sul");
		Endereco rua4343 = new Endereco(null, "Avenida Engenheiro Francisco José Longo", " 633", "Jardim São Dimas",
				"Sul");
		Endereco rua4344 = new Endereco(null, "Avenida Engenheiro Francisco José Longo", " 622", "Jardim São Dimas",
				"Sul");
		Endereco rua4345 = new Endereco(null, "Rua Inconfidência", " 212", "Jardim São Dimas", "Sul");
		Endereco rua4346 = new Endereco(null, "Rua Maestro Egydio Pinto", " 169", "Jardim São Dimas", "Sul");
		Endereco rua4347 = new Endereco(null, "Rua Helena David Neme", " 94", "Jardim São Dimas", "Sul");
		Endereco rua4348 = new Endereco(null, "Rua Helena David Neme", " 110", "Jardim São Dimas", "Sul");
		Endereco rua4349 = new Endereco(null, "Rua Paulo Setúbal", " 220", "Jardim São Dimas", "Sul");
		Endereco rua4350 = new Endereco(null, "Praça Cândido Dias Castejon", " 26", "Jardim São Dimas", "Sul");
		Endereco rua4351 = new Endereco(null, "Avenida Doutor Nelson D'Avila", " 90", "Jardim São Dimas", "Sul");
		Endereco rua4352 = new Endereco(null, "Rua Paraibuna", " 767", "Jardim São Dimas", "Sul");
		Endereco rua4353 = new Endereco(null, "Rua Emiliano Alves de Paula", "Jardim Itapoã", "Sul", "12247290");
		Endereco rua4354 = new Endereco(null, "Rua Augusto Cesar Neto", "Jardim Itapoã", "Sul", "12247300");
		Endereco rua4355 = new Endereco(null, "Rua José Carlos Fernandes da Silva", "Jardim Itapoã", "Sul", "12247310");
		Endereco rua4356 = new Endereco(null, "Rua Orlando Machado de Araújo", "Jardim Itapoã", "Sul", "12247320");
		Endereco rua4357 = new Endereco(null, "Rua Angélica de Barros Porto", "Jardim Itapoã", "Sul", "12247330");
		Endereco rua4358 = new Endereco(null, "Rua José de Paula da Silva", "Jardim Itapoã", "Sul", "12247340");
		Endereco rua4359 = new Endereco(null, "Rua Ulisses de Paula Filho", "Jardim Itapoã", "Sul", "12247350");
		Endereco rua4360 = new Endereco(null, "Rua Jair Venâncio de Paiva", "Jardim Itapoã", "Sul", "12247360");
		Endereco rua4361 = new Endereco(null, "Rua Benedito Lopes Chaves", "Jardim Itapoã", "Sul", "12247370");
		Endereco rua4362 = new Endereco(null, "Rua Arnaldo Machado de Araújo", "Jardim Itapoã", "Sul", "12247380");
		Endereco rua4363 = new Endereco(null, "Rua Virgílio Alves de Oliveira", "Jardim Itapoã", "Sul", "12247390");
		Endereco rua4364 = new Endereco(null, "Rua Paulo Venâncio de Paiva", "Jardim Itapoã", "Sul", "12247400");
		Endereco rua4365 = new Endereco(null, "Rua das Campanulas", "Jardim das Flores", "Sul", "12247620");
		Endereco rua4366 = new Endereco(null, "Rua das Mimosas", "Jardim das Flores", "Sul", "12247630");
		Endereco rua4367 = new Endereco(null, "Rua das Alfazemas", "Jardim das Flores", "Sul", "12247631");
		Endereco rua4368 = new Endereco(null, "Rua das Iris", "Jardim das Flores", "Sul", "12247640");
		Endereco rua4369 = new Endereco(null, "Rua Flor de Lis", "Jardim das Flores", "Sul", "12247650");
		Endereco rua4370 = new Endereco(null, "Rua das Primulas", "Jardim das Flores", "Sul", "12247660");
		Endereco rua4371 = new Endereco(null, "Rua das Sempre-Vivas", "Jardim das Flores", "Sul", "12247670");
		Endereco rua4372 = new Endereco(null, "Praça Ronaldo Davoli", "Jardim das Flores", "Sul", "12247680");
		Endereco rua4373 = new Endereco(null, "Rua das Avencas", "Jardim das Flores", "Sul", "12247690");
		Endereco rua4374 = new Endereco(null, "Rua dos Cronópios", "Jardim das Flores", "Sul", "12247700");
		Endereco rua4375 = new Endereco(null, "Rua das Melissas", "Jardim das Flores", "Sul", "12247710");
		Endereco rua4376 = new Endereco(null, "Rua das Aliseas", "Jardim das Flores", "Sul", "12247720");
		Endereco rua4377 = new Endereco(null, "Rua dos Álamos", "Jardim das Flores", "Sul", "12247730");
		Endereco rua4378 = new Endereco(null, "Rua das Aleluias", "Jardim das Flores", "Sul", "12247740");
		Endereco rua4379 = new Endereco(null, "Rua dos Acantos", "Jardim das Flores", "Sul", "12247750");
		Endereco rua4380 = new Endereco(null, "Rua das Begônias", "Jardim das Flores", "Sul", "12247770");
		Endereco rua4381 = new Endereco(null, "Rua das Heras", "Jardim das Flores", "Sul", "12247780");
		Endereco rua4382 = new Endereco(null, "Rua Cecília Bueno de Alvarenga", "Jardim Santa Inês II", "Sul",
				"12248090");
		Endereco rua4383 = new Endereco(null, "Rua Benedito Hilário", "Jardim Santa Inês II", "Sul", "12248100");
		Endereco rua4384 = new Endereco(null, "Rua José de Paula Silva Neves", "Jardim Santa Inês II", "Sul",
				"12248110");
		Endereco rua4385 = new Endereco(null, "Rua José Assis da Fonseca", "Jardim Santa Inês II", "Sul", "12248120");
		Endereco rua4386 = new Endereco(null, "Rua Benedito Marcondes Pereira", "Jardim Santa Inês II", "Sul",
				"12248140");
		Endereco rua4387 = new Endereco(null, "Rua Zelfira Bianchi", "Jardim Santa Inês II", "Sul", "12248150");
		Endereco rua4388 = new Endereco(null, "Rua Carlos Galhardo", "Jardim Santa Inês II", "Sul", "12248160");
		Endereco rua4389 = new Endereco(null, "Rua Antoun Melhen El Kouri", "Jardim Santa Inês II", "Sul", "12248170");
		Endereco rua4390 = new Endereco(null, "Rua Rodolfo Mayer", "Jardim Santa Inês II", "Sul", "12248180");
		Endereco rua4391 = new Endereco(null, "Rua Deocleciano Borges de Oliveira", "Jardim Santa Inês II", "Sul",
				"12248190");
		Endereco rua4392 = new Endereco(null, "Rua Taiwan", "Jardim Santa Inês II", "Sul", "12248193");
		Endereco rua4393 = new Endereco(null, "Rua Gilda Garrido Purcini", "Jardim Santa Inês II", "Sul", "12248194");
		Endereco rua4394 = new Endereco(null, "Rua José Lia", "Jardim Santa Inês II", "Sul", "12248195");
		Endereco rua4395 = new Endereco(null, "Avenida Professor Milton Santos", "Jardim Santa Inês I", "Sul",
				"12248200");
		Endereco rua4396 = new Endereco(null, "Rua Durvalina Silva Aguiar", "Jardim Santa Inês I", "Sul", "12248210");
		Endereco rua4397 = new Endereco(null, "Rua Narciza Moreti Ribeiro", "Jardim Santa Inês I", "Sul", "12248215");
		Endereco rua4398 = new Endereco(null, "Rua Virgulino de Carvalho", "Jardim Santa Inês I", "Sul", "12248220");
		Endereco rua4399 = new Endereco(null, "Rua Carlos Saloni", "Jardim Santa Inês I", "Sul", "12248230");
		Endereco rua4400 = new Endereco(null, "Rua Alberto Renart", "Jardim Santa Inês I", "Sul", "12248240");
		Endereco rua4401 = new Endereco(null, "Rua José de Paula", "Jardim Santa Inês I", "Sul", "12248241");
		Endereco rua4402 = new Endereco(null, "Rua Augusto Antônio de Magalhães", "Jardim Santa Inês I", "Sul",
				"12248250");
		Endereco rua4403 = new Endereco(null, "Rua Florival Adalberto Nucci", "Jardim Santa Inês III", "Sul",
				"12248254");
		Endereco rua4404 = new Endereco(null, "Rua Albenzio Romancini", "Jardim Santa Inês III", "Sul", "12248255");
		Endereco rua4405 = new Endereco(null, "Rua Padre Guilherme Hopp", "Jardim Santa Inês I", "Sul", "12248260");
		Endereco rua4406 = new Endereco(null, "Rua Nelson Amaral", "Jardim Santa Inês I", "Sul", "12248270");
		Endereco rua4407 = new Endereco(null, "Rua Maria Cândida Leite de Castro", "Jardim Santa Inês I", "Sul",
				"12248280");
		Endereco rua4408 = new Endereco(null, "Rua José Lino de Souza", "Jardim Santa Inês I", "Sul", "12248290");
		Endereco rua4409 = new Endereco(null, "Rua Joaquim Caetano de Jesus", "Jardim Santa Inês I", "Sul", "12248300");
		Endereco rua4410 = new Endereco(null, "Praça Marlene Baldez da Silva", "Jardim Santa Inês I", "Sul",
				"12248305");
		Endereco rua4411 = new Endereco(null, "Rua Argesio Dias Ferreira", "Jardim Santa Inês I", "Sul", "12248310");
		Endereco rua4412 = new Endereco(null, "Rua Emílio Tonglet", "Jardim Santa Inês I", "Sul", "12248320");
		Endereco rua4413 = new Endereco(null, "Avenida Doutor Domingos de Macedo Custódio", "Jardim Santa Inês I",
				"Sul", "12248330");
		Endereco rua4414 = new Endereco(null, "Praça Letícia Meira de Castro", "Jardim Santa Inês I", "Sul",
				"12248335");
		Endereco rua4415 = new Endereco(null, "Rua Abel Cursino dos Santos", "Jardim Santa Inês I", "Sul", "12248340");
		Endereco rua4416 = new Endereco(null, "Rua Herundina Figueira de Andrade Oliveira", "Jardim Santa Inês I",
				"Sul", "12248350");
		Endereco rua4417 = new Endereco(null, "Rua Antônio Barbosa de Oliveira", "Jardim Santa Inês I", "Sul",
				"12248360");
		Endereco rua4418 = new Endereco(null, "Rua Professor Rúbens Oscar Guelli", "Jardim Santa Inês I", "Sul",
				"12248370");
		Endereco rua4419 = new Endereco(null, "Rua Maria Aparecida Veríssimo Madureira Ramos", "Jardim Santa Inês I",
				"Sul", "12248380");
		Endereco rua4420 = new Endereco(null, "Rua Joaquim Batista Carvalho", "Jardim Santa Inês I", "Sul", "12248390");
		Endereco rua4421 = new Endereco(null, "Rua Maria Alice Pasquarelli", "Jardim Santa Inês I", "Sul", "12248400");
		Endereco rua4422 = new Endereco(null, "Rua Lázaro Floriano Barbosa", "Jardim Santa Inês I", "Sul", "12248410");
		Endereco rua4423 = new Endereco(null, "Rua Carlos Eurico de Breyme Montenegro", "Jardim Santa Inês I", "Sul",
				"12248420");
		Endereco rua4424 = new Endereco(null, "Rua João Moreira Borges", "Jardim Santa Inês I", "Sul", "12248430");
		Endereco rua4425 = new Endereco(null, "Rua Antônio Júlio Cavalcanti", "Jardim Santa Inês I", "Sul", "12248440");
		Endereco rua4426 = new Endereco(null, "Rua José de Paula Ferreira", "Jardim Santa Inês I", "Sul", "12248450");
		Endereco rua4427 = new Endereco(null, "Rua Fauze Dimas Lumumba Gonçalves", "Jardim Santa Inês I", "Sul",
				"12248460");
		Endereco rua4428 = new Endereco(null, "Rua Francisco Teixeira de Almeida Filho", "Jardim Santa Inês I", "Sul",
				"12248470");
		Endereco rua4429 = new Endereco(null, "Rua Francisco Ferreira Santos", "Jardim Santa Inês I", "Sul",
				"12248480");
		Endereco rua4430 = new Endereco(null, "Rua Abelardo Alves de Paiva", "Jardim Santa Inês I", "Sul", "12248490");
		Endereco rua4431 = new Endereco(null, "Avenida Pedro Domingues Affonso", "Jardim Santa Inês III", "Sul",
				"12248498");
		Endereco rua4432 = new Endereco(null, "Rua Célia Regina de Oliveira", "Jardim Santa Inês III", "Sul",
				"12248499");
		Endereco rua4433 = new Endereco(null, "Rua Ricardo Paiva Vieira", "Jardim Santa Inês I", "Sul", "12248500");
		Endereco rua4434 = new Endereco(null, "Rua Giovanna Maria Apparecida D'Amato Lima", "Jardim Santa Inês III",
				"Sul", "12248502");
		Endereco rua4435 = new Endereco(null, "Rua José Cesário Cerqueira", "Jardim Santa Inês III", "Sul", "12248503");
		Endereco rua4436 = new Endereco(null, "Rua Sebastião Paulo Siqueira", "Jardim Santa Inês III", "Sul",
				"12248504");
		Endereco rua4437 = new Endereco(null, "Rua Robson Ricardo da Silva", "Jardim Santa Inês II", "Sul", "12248505");
		Endereco rua4438 = new Endereco(null, "Rua Três", "Jardim Santa Inês III", "Sul", "12248506");
		Endereco rua4439 = new Endereco(null, "Rua Therezinha da Piedade Beraldo Goulart Oliveira",
				"Jardim Santa Inês III", "Sul", "12248507");
		Endereco rua4440 = new Endereco(null, "Rua Maria Benedita Gama", "Jardim Santa Inês III", "Sul", "12248508");
		Endereco rua4441 = new Endereco(null, "Rua José Custódio da Silveira", "Jardim Santa Inês III", "Sul",
				"12248509");
		Endereco rua4442 = new Endereco(null, "Avenida Constância da Cunha Paiva", "Jardim Santa Inês II", "Sul",
				"12248510");
		Endereco rua4443 = new Endereco(null, "Rua José Alves de Paiva", "Jardim Santa Inês II", "Sul", "12248511");
		Endereco rua4444 = new Endereco(null, "Rua Luiz Calvo", "Jardim Santa Inês II", "Sul", "12248512");
		Endereco rua4445 = new Endereco(null, "Rua Benedito Albano Pereira", "Jardim Santa Inês II", "Sul", "12248513");
		Endereco rua4446 = new Endereco(null, "Rua Mário Guimarães Ferri", "Jardim Santa Inês II", "Sul", "12248514");
		Endereco rua4447 = new Endereco(null, "Rua dos Cirurgiões Dentistas", "Jardim Santa Inês II", "Sul",
				"12248515");
		Endereco rua4448 = new Endereco(null, "Rua Capitão Paulo José de Menezes Filho", "Jardim Santa Inês II", "Sul",
				"12248516");
		Endereco rua4449 = new Endereco(null, "Rua Doutor Euclides Froes", "Jardim Santa Inês II", "Sul", "12248517");
		Endereco rua4450 = new Endereco(null, "Avenida Iracy Pires da Almeida Puccini", "Jardim Santa Inês II", "Sul",
				"12248520");
		Endereco rua4451 = new Endereco(null, "Rua Danilo Eduardo Rios Ramos", "Jardim São José Leste", "Sul",
				"12248610");
		Endereco rua4452 = new Endereco(null, "Rua Adelaide Louzada Franco do Amaral", "Jardim São José Leste", "Sul",
				"12248611");
		Endereco rua4453 = new Endereco(null, "Rua Laura Pereira Rios", "Jardim São José Leste", "Sul", "12248613");
		Endereco rua4454 = new Endereco(null, "Avenida João Gomes da Silva", "Jardim São José Leste", "Sul",
				"12248616");
		Endereco rua4455 = new Endereco(null, "Rua Benedicta Maria da Conceição", "Jardim São José Leste", "Sul",
				"12248619");
		Endereco rua4456 = new Endereco(null, "Rua Maximiano dos Santos", "Jardim São José Leste", "Sul", "12248622");
		Endereco rua4457 = new Endereco(null, "Rua Elias Anacleto do Prado", "Jardim São José Leste", "Sul",
				"12248625");
		Endereco rua4458 = new Endereco(null, "Rua Padre Cícero Romão Batista", "Jardim São José Leste", "Sul",
				"12248628");
		Endereco rua4459 = new Endereco(null, "Rua Sebastião Martins Ramos", "Jardim São José Leste", "Sul",
				"12248631");
		Endereco rua4460 = new Endereco(null, "Rua João Pereira de Castro", "Jardim São José Leste", "Sul", "12248634");
		Endereco rua4461 = new Endereco(null, "Rua Genilda Maria Almeida de Oliveira", "Jardim São José Leste", "Sul",
				"12248637");
		Endereco rua4462 = new Endereco(null, "Rua Noêmia dos Santos Barbosa", "Jardim São José Leste", "Sul",
				"12248640");
		Endereco rua4463 = new Endereco(null, "Rua José Hélio do Nascimento", "Jardim São José Leste", "Sul",
				"12248643");
		Endereco rua4464 = new Endereco(null, "Praça José Marcelino de Sousa", "Jardim São José Leste", "Sul",
				"12248646");
		Endereco rua4465 = new Endereco(null, "Rua Tom Jobim", "Jardim São José II", "Sul", "12248660");
		Endereco rua4466 = new Endereco(null, "Rua Tim Lopes", "Jardim São José II", "Sul", "12248662");
		Endereco rua4467 = new Endereco(null, "Rua Jorge Amado", "Jardim São José II", "Sul", "12248666");
		Endereco rua4468 = new Endereco(null, "Rua Armagedon", "Jardim São José II", "Sul", "12248670");
		Endereco rua4469 = new Endereco(null, "Rua Frediano Bianchi Filho", "Jardim São José II", "Sul", "12248674");
		Endereco rua4470 = new Endereco(null, "Rua Ayrton Senna da Silva", "Jardim São José II", "Sul", "12248678");
		Endereco rua4471 = new Endereco(null, "Avenida João Gomes da Silva", "Jardim São José II", "Sul", "12248682");
		Endereco rua4472 = new Endereco(null, "Rua Vinícius de Moraes", "Jardim São José II", "Sul", "12248685");
		Endereco rua4473 = new Endereco(null, "Rua Danilo Eduardo Rios Ramos", "Jardim São José II", "Sul", "12248686");
		Endereco rua4474 = new Endereco(null, "Avenida Doutor Numa de Oliveira", "Jardim Telespark", "Norte",
				"12212660");
		Endereco rua4475 = new Endereco(null, "Rua Anacleto Veneziani", "Jardim Telespark", "Norte", "12212670");
		Endereco rua4476 = new Endereco(null, "Rua Zoraide Siqueira", "Jardim Telespark", "Norte", "12212680");
		Endereco rua4477 = new Endereco(null, "Rua Luiz Borges Filho", "Jardim Telespark", "Norte", "12212690");
		Endereco rua4478 = new Endereco(null, "Rua Benedito Pereira Lima", "Jardim Telespark", "Norte", "12212700");
		Endereco rua4479 = new Endereco(null, "Avenida Conde Francisco Matarazzo", "Jardim Telespark", "Norte",
				"12212710");
		Endereco rua4480 = new Endereco(null, "Rua Schaia Feigenson", "Jardim Telespark", "Norte", "12212720");
		Endereco rua4481 = new Endereco(null, "Rua Chana Baskin Feigenson", "Jardim Telespark", "Norte", "12212730");
		Endereco rua4482 = new Endereco(null, "Rua Paulo Hunger", "Jardim Telespark", "Norte", "12212740");
		Endereco rua4483 = new Endereco(null, "Rua Augusto Luiz de Almeida", "Jardim Telespark", "Norte", "12212750");
		Endereco rua4484 = new Endereco(null, "Rua Pedro David Filho", "Jardim Telespark", "Norte", "12212760");
		Endereco rua4485 = new Endereco(null, "Rua Taquaral", "Jardim Telespark", "Norte", "12212770");
		Endereco rua4486 = new Endereco(null, "Rua Doutor Edgard de Souza", "Jardim Telespark", "Norte", "12212780");
		Endereco rua4487 = new Endereco(null, "Rua Uruana", "Jardim Telespark", "Norte", "12212790");
		Endereco rua4488 = new Endereco(null, "Rua Urati", "Jardim Telespark", "Norte", "12212800");
		Endereco rua4489 = new Endereco(null, "Praça César Traballi", "Jardim Telespark", "Norte", "12212810");
		Endereco rua4490 = new Endereco(null, "Rua Jordão Monteiro Ferreira", "Jardim Topázio", "Centro", "12216190");
		Endereco rua4491 = new Endereco(null, "Rua Jaraguá", "Jardim Topázio", "Centro", "12216460");
		Endereco rua4492 = new Endereco(null, "Praça Francisco Antônio dos Santos", "Jardim Topázio", "Centro",
				"12216465");
		Endereco rua4493 = new Endereco(null, "Rua Jussara", "Jardim Topázio", "Centro", "12216470");
		Endereco rua4494 = new Endereco(null, "Rua Jaguarete", "Jardim Topázio", "Centro", "12216480");
		Endereco rua4495 = new Endereco(null, "Rua Jaú", "Jardim Topázio", "Centro", "12216490");
		Endereco rua4496 = new Endereco(null, "Rua Iracema", "Jardim Três José", "Leste", "12225010");
		Endereco rua4497 = new Endereco(null, "Rua Iraci", "Jardim Três José", "Leste", "12225020");
		Endereco rua4498 = new Endereco(null, "Rua João Rodolfo Castelli", "Jardim Três José", "Leste", "12225030");
		Endereco rua4499 = new Endereco(null, "Avenida dos Tangarás", "Jardim Uirá", "Sudeste", "12227580");

		endRepository.saveAll(Arrays.asList(rua3000, rua3001, rua3002, rua3003, rua3004, rua3005, rua3006, rua3007,
				rua3008, rua3009, rua3010, rua3011, rua3012, rua3013, rua3014, rua3015, rua3016, rua3017, rua3018,
				rua3019, rua3020, rua3021, rua3022, rua3023, rua3024, rua3025, rua3026, rua3027, rua3028, rua3029,
				rua3030, rua3031, rua3032, rua3033, rua3034, rua3035, rua3036, rua3037, rua3038, rua3039, rua3040,
				rua3041, rua3042, rua3043, rua3044, rua3045, rua3046, rua3047, rua3048, rua3049, rua3050, rua3051,
				rua3052, rua3053, rua3054, rua3055, rua3056, rua3057, rua3058, rua3059, rua3060, rua3061, rua3062,
				rua3063, rua3064, rua3065, rua3066, rua3067, rua3068, rua3069, rua3070, rua3071, rua3072, rua3073,
				rua3074, rua3075, rua3076, rua3077, rua3078, rua3079, rua3080, rua3081, rua3082, rua3083, rua3084,
				rua3085, rua3086, rua3087, rua3088, rua3089, rua3090, rua3091, rua3092, rua3093, rua3094, rua3095,
				rua3096, rua3097, rua3098, rua3099, rua3100, rua3101, rua3102, rua3103, rua3104, rua3105, rua3106,
				rua3107, rua3108, rua3109, rua3110, rua3111, rua3112, rua3113, rua3114, rua3115, rua3116, rua3117,
				rua3118, rua3119, rua3120, rua3121, rua3122, rua3123, rua3124, rua3125, rua3126, rua3127, rua3128,
				rua3129, rua3130, rua3131, rua3132, rua3133, rua3134, rua3135, rua3136, rua3137, rua3138, rua3139,
				rua3140, rua3141, rua3142, rua3143, rua3144, rua3145, rua3146, rua3147, rua3148, rua3149, rua3150,
				rua3151, rua3152, rua3153, rua3154, rua3155, rua3156, rua3157, rua3158, rua3159, rua3160, rua3161,
				rua3162, rua3163, rua3164, rua3165, rua3166, rua3167, rua3168, rua3169, rua3170, rua3171, rua3172,
				rua3173, rua3174, rua3175, rua3176, rua3177, rua3178, rua3179, rua3180, rua3181, rua3182, rua3183,
				rua3184, rua3185, rua3186, rua3187, rua3188, rua3189, rua3190, rua3191, rua3192, rua3193, rua3194,
				rua3195, rua3196, rua3197, rua3198, rua3199, rua3200, rua3201, rua3202, rua3203, rua3204, rua3205,
				rua3206, rua3207, rua3208, rua3209, rua3210, rua3211, rua3212, rua3213, rua3214, rua3215, rua3216,
				rua3217, rua3218, rua3219, rua3220, rua3221, rua3222, rua3223, rua3224, rua3225, rua3226, rua3227,
				rua3228, rua3229, rua3230, rua3231, rua3232, rua3233, rua3234, rua3235, rua3236, rua3237, rua3238,
				rua3239, rua3240, rua3241, rua3242, rua3243, rua3244, rua3245, rua3246, rua3247, rua3248, rua3249,
				rua3250, rua3251, rua3252, rua3253, rua3254, rua3255, rua3256, rua3257, rua3258, rua3259, rua3260,
				rua3261, rua3262, rua3263, rua3264, rua3265, rua3266, rua3267, rua3268, rua3269, rua3270, rua3271,
				rua3272, rua3273, rua3274, rua3275, rua3276, rua3277, rua3278, rua3279, rua3280, rua3281, rua3282,
				rua3283, rua3284, rua3285, rua3286, rua3287, rua3288, rua3289, rua3290, rua3291, rua3292, rua3293,
				rua3294, rua3295, rua3296, rua3297, rua3298, rua3299, rua3300, rua3301, rua3302, rua3303, rua3304,
				rua3305, rua3306, rua3307, rua3308, rua3309, rua3310, rua3311, rua3312, rua3313, rua3314, rua3315,
				rua3316, rua3317, rua3318, rua3319, rua3320, rua3321, rua3322, rua3323, rua3324, rua3325, rua3326,
				rua3327, rua3328, rua3329, rua3330, rua3331, rua3332, rua3333, rua3334, rua3335, rua3336, rua3337,
				rua3338, rua3339, rua3340, rua3341, rua3342, rua3343, rua3344, rua3345, rua3346, rua3347, rua3348,
				rua3349, rua3350, rua3351, rua3352, rua3353, rua3354, rua3355, rua3356, rua3357, rua3358, rua3359,
				rua3360, rua3361, rua3362, rua3363, rua3364, rua3365, rua3366, rua3367, rua3368, rua3369, rua3370,
				rua3371, rua3372, rua3373, rua3374, rua3375, rua3376, rua3377, rua3378, rua3379, rua3380, rua3381,
				rua3382, rua3383, rua3384, rua3385, rua3386, rua3387, rua3388, rua3389, rua3390, rua3391, rua3392,
				rua3393, rua3394, rua3395, rua3396, rua3397, rua3398, rua3399, rua3400, rua3401, rua3402, rua3403,
				rua3404, rua3405, rua3406, rua3407, rua3408, rua3409, rua3410, rua3411, rua3412, rua3413, rua3414,
				rua3415, rua3416, rua3417, rua3418, rua3419, rua3420, rua3421, rua3422, rua3423, rua3424, rua3425,
				rua3426, rua3427, rua3428, rua3429, rua3430, rua3431, rua3432, rua3433, rua3434, rua3435, rua3436,
				rua3437, rua3438, rua3439, rua3440, rua3441, rua3442, rua3443, rua3444, rua3445, rua3446, rua3447,
				rua3448, rua3449, rua3450, rua3451, rua3452, rua3453, rua3454, rua3455, rua3456, rua3457, rua3458,
				rua3459, rua3460, rua3461, rua3462, rua3463, rua3464, rua3465, rua3466, rua3467, rua3468, rua3469,
				rua3470, rua3471, rua3472, rua3473, rua3474, rua3475, rua3476, rua3477, rua3478, rua3479, rua3480,
				rua3481, rua3482, rua3483, rua3484, rua3485, rua3486, rua3487, rua3488, rua3489, rua3490, rua3491,
				rua3492, rua3493, rua3494, rua3495, rua3496, rua3497, rua3498, rua3499, rua3500, rua3501, rua3502,
				rua3503, rua3504, rua3505, rua3506, rua3507, rua3508, rua3509, rua3510, rua3511, rua3512, rua3513,
				rua3514, rua3515, rua3516, rua3517, rua3518, rua3519, rua3520, rua3521, rua3522, rua3523, rua3524,
				rua3525, rua3526, rua3527, rua3528, rua3529, rua3530, rua3531, rua3532, rua3533, rua3534, rua3535,
				rua3536, rua3537, rua3538, rua3539, rua3540, rua3541, rua3542, rua3543, rua3544, rua3545, rua3546,
				rua3547, rua3548, rua3549, rua3550, rua3551, rua3552, rua3553, rua3554, rua3555, rua3556, rua3557,
				rua3558, rua3559, rua3560, rua3561, rua3562, rua3563, rua3564, rua3565, rua3566, rua3567, rua3568,
				rua3569, rua3570, rua3571, rua3572, rua3573, rua3574, rua3575, rua3576, rua3577, rua3578, rua3579,
				rua3580, rua3581, rua3582, rua3583, rua3584, rua3585, rua3586, rua3587, rua3588, rua3589, rua3590,
				rua3591, rua3592, rua3593, rua3594, rua3595, rua3596, rua3597, rua3598, rua3599, rua3600, rua3601,
				rua3602, rua3603, rua3604, rua3605, rua3606, rua3607, rua3608, rua3609, rua3610, rua3611, rua3612,
				rua3613, rua3614, rua3615, rua3616, rua3617, rua3618, rua3619, rua3620, rua3621, rua3622, rua3623,
				rua3624, rua3625, rua3626, rua3627, rua3628, rua3629, rua3630, rua3631, rua3632, rua3633, rua3634,
				rua3635, rua3636, rua3637, rua3638, rua3639, rua3640, rua3641, rua3642, rua3643, rua3644, rua3645,
				rua3646, rua3647, rua3648, rua3649, rua3650, rua3651, rua3652, rua3653, rua3654, rua3655, rua3656,
				rua3657, rua3658, rua3659, rua3660, rua3661, rua3662, rua3663, rua3664, rua3665, rua3666, rua3667,
				rua3668, rua3669, rua3670, rua3671, rua3672, rua3673, rua3674, rua3675, rua3676, rua3677, rua3678,
				rua3679, rua3680, rua3681, rua3682, rua3683, rua3684, rua3685, rua3686, rua3687, rua3688, rua3689,
				rua3690, rua3691, rua3692, rua3693, rua3694, rua3695, rua3696, rua3697, rua3698, rua3699, rua3700,
				rua3701, rua3702, rua3703, rua3704, rua3705, rua3706, rua3707, rua3708, rua3709, rua3710, rua3711,
				rua3712, rua3713, rua3714, rua3715, rua3716, rua3717, rua3718, rua3719, rua3720, rua3721, rua3722,
				rua3723, rua3724, rua3725, rua3726, rua3727, rua3728, rua3729, rua3730, rua3731, rua3732, rua3733,
				rua3734, rua3735, rua3736, rua3737, rua3738, rua3739, rua3740, rua3741, rua3742, rua3743, rua3744,
				rua3745, rua3746, rua3747, rua3748, rua3749, rua3750, rua3751, rua3752, rua3753, rua3754, rua3755,
				rua3756, rua3757, rua3758, rua3759, rua3760, rua3761, rua3762, rua3763, rua3764, rua3765, rua3766,
				rua3767, rua3768, rua3769, rua3770, rua3771, rua3772, rua3773, rua3774, rua3775, rua3776, rua3777,
				rua3778, rua3779, rua3780, rua3781, rua3782, rua3783, rua3784, rua3785, rua3786, rua3787, rua3788,
				rua3789, rua3790, rua3791, rua3792, rua3793, rua3794, rua3795, rua3796, rua3797, rua3798, rua3799,
				rua3800, rua3801, rua3802, rua3803, rua3804, rua3805, rua3806, rua3807, rua3808, rua3809, rua3810,
				rua3811, rua3812, rua3813, rua3814, rua3815, rua3816, rua3817, rua3818, rua3819, rua3820, rua3821,
				rua3822, rua3823, rua3824, rua3825, rua3826, rua3827, rua3828, rua3829, rua3830, rua3831, rua3832,
				rua3833, rua3834, rua3835, rua3836, rua3837, rua3838, rua3839, rua3840, rua3841, rua3842, rua3843,
				rua3844, rua3845, rua3846, rua3847, rua3848, rua3849, rua3850, rua3851, rua3852, rua3853, rua3854,
				rua3855, rua3856, rua3857, rua3858, rua3859, rua3860, rua3861, rua3862, rua3863, rua3864, rua3865,
				rua3866, rua3867, rua3868, rua3869, rua3870, rua3871, rua3872, rua3873, rua3874, rua3875, rua3876,
				rua3877, rua3878, rua3879, rua3880, rua3881, rua3882, rua3883, rua3884, rua3885, rua3886, rua3887,
				rua3888, rua3889, rua3890, rua3891, rua3892, rua3893, rua3894, rua3895, rua3896, rua3897, rua3898,
				rua3899, rua3900, rua3901, rua3902, rua3903, rua3904, rua3905, rua3906, rua3907, rua3908, rua3909,
				rua3910, rua3911, rua3912, rua3913, rua3914, rua3915, rua3916, rua3917, rua3918, rua3919, rua3920,
				rua3921, rua3922, rua3923, rua3924, rua3925, rua3926, rua3927, rua3928, rua3929, rua3930, rua3931,
				rua3932, rua3933, rua3934, rua3935, rua3936, rua3937, rua3938, rua3939, rua3940, rua3941, rua3942,
				rua3943, rua3944, rua3945, rua3946, rua3947, rua3948, rua3949, rua3950, rua3951, rua3952, rua3953,
				rua3954, rua3955, rua3956, rua3957, rua3958, rua3959, rua3960, rua3961, rua3962, rua3963, rua3964,
				rua3965, rua3966, rua3967, rua3968, rua3969, rua3970, rua3971, rua3972, rua3973, rua3974, rua3975,
				rua3976, rua3977, rua3978, rua3979, rua3980, rua3981, rua3982, rua3983, rua3984, rua3985, rua3986,
				rua3987, rua3988, rua3989, rua3990, rua3991, rua3992, rua3993, rua3994, rua3995, rua3996, rua3997,
				rua3998, rua3999, rua4000, rua4001, rua4002, rua4003, rua4004, rua4005, rua4006, rua4007, rua4008,
				rua4009, rua4010, rua4011, rua4012, rua4013, rua4014, rua4015, rua4016, rua4017, rua4018, rua4019,
				rua4020, rua4021, rua4022, rua4023, rua4024, rua4025, rua4026, rua4027, rua4028, rua4029, rua4030,
				rua4031, rua4032, rua4033, rua4034, rua4035, rua4036, rua4037, rua4038, rua4039, rua4040, rua4041,
				rua4042, rua4043, rua4044, rua4045, rua4046, rua4047, rua4048, rua4049, rua4050, rua4051, rua4052,
				rua4053, rua4054, rua4055, rua4056, rua4057, rua4058, rua4059, rua4060, rua4061, rua4062, rua4063,
				rua4064, rua4065, rua4066, rua4067, rua4068, rua4069, rua4070, rua4071, rua4072, rua4073, rua4074,
				rua4075, rua4076, rua4077, rua4078, rua4079, rua4080, rua4081, rua4082, rua4083, rua4084, rua4085,
				rua4086, rua4087, rua4088, rua4089, rua4090, rua4091, rua4092, rua4093, rua4094, rua4095, rua4096,
				rua4097, rua4098, rua4099, rua4100, rua4101, rua4102, rua4103, rua4104, rua4105, rua4106, rua4107,
				rua4108, rua4109, rua4110, rua4111, rua4112, rua4113, rua4114, rua4115, rua4116, rua4117, rua4118,
				rua4119, rua4120, rua4121, rua4122, rua4123, rua4124, rua4125, rua4126, rua4127, rua4128, rua4129,
				rua4130, rua4131, rua4132, rua4133, rua4134, rua4135, rua4136, rua4137, rua4138, rua4139, rua4140,
				rua4141, rua4142, rua4143, rua4144, rua4145, rua4146, rua4147, rua4148, rua4149, rua4150, rua4151,
				rua4152, rua4153, rua4154, rua4155, rua4156, rua4157, rua4158, rua4159, rua4160, rua4161, rua4162,
				rua4163, rua4164, rua4165, rua4166, rua4167, rua4168, rua4169, rua4170, rua4171, rua4172, rua4173,
				rua4174, rua4175, rua4176, rua4177, rua4178, rua4179, rua4180, rua4181, rua4182, rua4183, rua4184,
				rua4185, rua4186, rua4187, rua4188, rua4189, rua4190, rua4191, rua4192, rua4193, rua4194, rua4195,
				rua4196, rua4197, rua4198, rua4199, rua4200, rua4201, rua4202, rua4203, rua4204, rua4205, rua4206,
				rua4207, rua4208, rua4209, rua4210, rua4211, rua4212, rua4213, rua4214, rua4215, rua4216, rua4217,
				rua4218, rua4219, rua4220, rua4221, rua4222, rua4223, rua4224, rua4225, rua4226, rua4227, rua4228,
				rua4229, rua4230, rua4231, rua4232, rua4233, rua4234, rua4235, rua4236, rua4237, rua4238, rua4239,
				rua4240, rua4241, rua4242, rua4243, rua4244, rua4245, rua4246, rua4247, rua4248, rua4249, rua4250,
				rua4251, rua4252, rua4253, rua4254, rua4255, rua4256, rua4257, rua4258, rua4259, rua4260, rua4261,
				rua4262, rua4263, rua4264, rua4265, rua4266, rua4267, rua4268, rua4269, rua4270, rua4271, rua4272,
				rua4273, rua4274, rua4275, rua4276, rua4277, rua4278, rua4279, rua4280, rua4281, rua4282, rua4283,
				rua4284, rua4285, rua4286, rua4287, rua4288, rua4289, rua4290, rua4291, rua4292, rua4293, rua4294,
				rua4295, rua4296, rua4297, rua4298, rua4299, rua4300, rua4301, rua4302, rua4303, rua4304, rua4305,
				rua4306, rua4307, rua4308, rua4309, rua4310, rua4311, rua4312, rua4313, rua4314, rua4315, rua4316,
				rua4317, rua4318, rua4319, rua4320, rua4321, rua4322, rua4323, rua4324, rua4325, rua4326, rua4327,
				rua4328, rua4329, rua4330, rua4331, rua4332, rua4333, rua4334, rua4335, rua4336, rua4337, rua4338,
				rua4339, rua4340, rua4341, rua4342, rua4343, rua4344, rua4345, rua4346, rua4347, rua4348, rua4349,
				rua4350, rua4351, rua4352, rua4353, rua4354, rua4355, rua4356, rua4357, rua4358, rua4359, rua4360,
				rua4361, rua4362, rua4363, rua4364, rua4365, rua4366, rua4367, rua4368, rua4369, rua4370, rua4371,
				rua4372, rua4373, rua4374, rua4375, rua4376, rua4377, rua4378, rua4379, rua4380, rua4381, rua4382,
				rua4383, rua4384, rua4385, rua4386, rua4387, rua4388, rua4389, rua4390, rua4391, rua4392, rua4393,
				rua4394, rua4395, rua4396, rua4397, rua4398, rua4399, rua4400, rua4401, rua4402, rua4403, rua4404,
				rua4405, rua4406, rua4407, rua4408, rua4409, rua4410, rua4411, rua4412, rua4413, rua4414, rua4415,
				rua4416, rua4417, rua4418, rua4419, rua4420, rua4421, rua4422, rua4423, rua4424, rua4425, rua4426,
				rua4427, rua4428, rua4429, rua4430, rua4431, rua4432, rua4433, rua4434, rua4435, rua4436, rua4437,
				rua4438, rua4439, rua4440, rua4441, rua4442, rua4443, rua4444, rua4445, rua4446, rua4447, rua4448,
				rua4449, rua4450, rua4451, rua4452, rua4453, rua4454, rua4455, rua4456, rua4457, rua4458, rua4459,
				rua4460, rua4461, rua4462, rua4463, rua4464, rua4465, rua4466, rua4467, rua4468, rua4469, rua4470,
				rua4471, rua4472, rua4473, rua4474, rua4475, rua4476, rua4477, rua4478, rua4479, rua4480, rua4481,
				rua4482, rua4483, rua4484, rua4485, rua4486, rua4487, rua4488, rua4489, rua4490, rua4491, rua4492,
				rua4493, rua4494, rua4495, rua4496, rua4497, rua4498, rua4499));

	}

	protected void insere4() throws ParseException {

		Endereco rua4500 = new Endereco(null, "Rua dos Macucos", "Jardim Uirá", "Sudeste", "12227590");
		Endereco rua4501 = new Endereco(null, "Rua das Tuíras", "Jardim Uirá", "Sudeste", "12227600");
		Endereco rua4502 = new Endereco(null, "Viela João Pereira da Silva", "Jardim Uirá", "Sudeste", "12227601");
		Endereco rua4503 = new Endereco(null, "Rua Sitio Bom Jesus", "Jardim Uirá", "Sudeste", "12227610");
		Endereco rua4504 = new Endereco(null, "Avenida das Curruiras", "Jardim Uirá", "Sudeste", "12227620");
		Endereco rua4505 = new Endereco(null, "Rua dos Canindés", "Jardim Uirá", "Sudeste", "12227621");
		Endereco rua4506 = new Endereco(null, "Rua dos Mutuns", "Jardim Uirá", "Sudeste", "12227630");
		Endereco rua4507 = new Endereco(null, "Rua das Jacutingas", "Jardim Uirá", "Sudeste", "12227640");
		Endereco rua4508 = new Endereco(null, "Rua dos Jaburus", "Jardim Uirá", "Sudeste", "12227650");
		Endereco rua4509 = new Endereco(null, "Praça Benedita Francisca da Rosa", "Jardim Uirá", "Sudeste", "12227651");
		Endereco rua4510 = new Endereco(null, "Rua Uiramiris", "Jardim Uirá", "Sudeste", "12227660");
		Endereco rua4511 = new Endereco(null, "Rua dos Socos", "Jardim Uirá", "Sudeste", "12227670");
		Endereco rua4512 = new Endereco(null, "Rua dos Cuitelos", "Jardim Uirá", "Sudeste", "12227680");
		Endereco rua4513 = new Endereco(null, "Rua dos Jaçanãs", "Jardim Uirá", "Sudeste", "12227690");
		Endereco rua4514 = new Endereco(null, "Rua dos Curiós", "Jardim Uirá", "Sudeste", "12227700");
		Endereco rua4515 = new Endereco(null, "Rua das Seriemas", "Jardim Uirá", "Sudeste", "12227710");
		Endereco rua4516 = new Endereco(null, "Avenida das Saíras", "Jardim Uirá", "Sudeste", "12227720");
		Endereco rua4517 = new Endereco(null, "Avenida Um", "Jardim Uirá", "Sudeste", "12227802");
		Endereco rua4518 = new Endereco(null, "Avenida Feira de Santana", "Jardim Vale do Sol", "Sul", "12238000");
		Endereco rua4519 = new Endereco(null, "Rua Candeias", "Jardim Vale do Sol", "Sul", "12238010");
		Endereco rua4520 = new Endereco(null, "Rua Alagoinhas", "Jardim Vale do Sol", "Sul", "12238020");
		Endereco rua4521 = new Endereco(null, "Rua Mucuri", "Jardim Vale do Sol", "Sul", "12238030");
		Endereco rua4522 = new Endereco(null, "Rua Gandu", "Jardim Vale do Sol", "Sul", "12238040");
		Endereco rua4523 = new Endereco(null, "Rua Almadina", "Jardim Vale do Sol", "Sul", "12238050");
		Endereco rua4524 = new Endereco(null, "Rua Anage", "Jardim Vale do Sol", "Sul", "12238060");
		Endereco rua4525 = new Endereco(null, "Rua Amargosa", "Jardim Vale do Sol", "Sul", "12238070");
		Endereco rua4526 = new Endereco(null, "Rua Juazeiro", "Jardim Vale do Sol", "Sul", "12238080");
		Endereco rua4527 = new Endereco(null, "Praça Bahia de São Salvador", "Jardim Vale do Sol", "Sul", "12238090");
		Endereco rua4528 = new Endereco(null, "Rua Quice", "Jardim Vale do Sol", "Sul", "12238100");
		Endereco rua4529 = new Endereco(null, "Rua Angical", "Jardim Vale do Sol", "Sul", "12238110");
		Endereco rua4530 = new Endereco(null, "Travessa Pataiba", "Jardim Vale do Sol", "Sul", "12238120");
		Endereco rua4531 = new Endereco(null, "Rua Caetité", "Jardim Vale do Sol", "Sul", "12238130");
		Endereco rua4532 = new Endereco(null, "Rua Ibicarai", "Jardim Vale do Sol", "Sul", "12238140");
		Endereco rua4533 = new Endereco(null, "Rua Catu", "Jardim Vale do Sol", "Sul", "12238150");
		Endereco rua4534 = new Endereco(null, "Rua Brumado", "Jardim Vale do Sol", "Sul", "12238160");
		Endereco rua4535 = new Endereco(null, "Rua Caravelas", "Jardim Vale do Sol", "Sul", "12238170");
		Endereco rua4536 = new Endereco(null, "Travessa Muritiba", "Jardim Vale do Sol", "Sul", "12238180");
		Endereco rua4537 = new Endereco(null, "Rua Vitória", "Jardim Vale do Sol", "Sul", "12238190");
		Endereco rua4538 = new Endereco(null, "Rua Alcocaba", "Jardim Vale do Sol", "Sul", "12238200");
		Endereco rua4539 = new Endereco(null, "Rua Aiquara", "Jardim Vale do Sol", "Sul", "12238210");
		Endereco rua4540 = new Endereco(null, "Rua Salvador Lahoz", "Jardim Vale do Sol", "Sul", "12238220");
		Endereco rua4541 = new Endereco(null, "Rua Abaré", "Jardim Vale do Sol", "Sul", "12238230");
		Endereco rua4542 = new Endereco(null, "Travessa Mataripe", "Jardim Vale do Sol", "Sul", "12238240");
		Endereco rua4543 = new Endereco(null, "Travessa Maracas", "Jardim Vale do Sol", "Sul", "12238250");
		Endereco rua4544 = new Endereco(null, "Rua das Enfermeiras", "Jardim Valparaíba", "Leste", "12221300");
		Endereco rua4545 = new Endereco(null, "Rua dos Economistas", "Jardim Valparaíba", "Leste", "12221310");
		Endereco rua4546 = new Endereco(null, "Rua dos Cientistas", "Jardim Valparaíba", "Leste", "12221320");
		Endereco rua4547 = new Endereco(null, "Rua das Telefonistas", "Jardim Valparaíba", "Leste", "12221330");
		Endereco rua4548 = new Endereco(null, "Praça dos Jornalistas", "Jardim Valparaíba", "Leste", "12221331");
		Endereco rua4549 = new Endereco(null, "Rua dos Marceneiros", "Jardim Valparaíba", "Leste", "12221340");
		Endereco rua4550 = new Endereco(null, "Rua dos Motoristas", "Jardim Valparaíba", "Leste", "12221350");
		Endereco rua4551 = new Endereco(null, "Rua dos Tecelões", "Jardim Valparaíba", "Leste", "12221360");
		Endereco rua4552 = new Endereco(null, "Rua dos Estudantes", "Jardim Valparaíba", "Leste", "12221370");
		Endereco rua4553 = new Endereco(null, "Praça dos Musicos", "Jardim Valparaíba", "Leste", "12221371");
		Endereco rua4554 = new Endereco(null, "Rua dos Metalurgicos", "Jardim Valparaíba", "Leste", "12221380");
		Endereco rua4555 = new Endereco(null, "Rua dos Bancários", "Jardim Valparaíba", "Leste", "12221390");
		Endereco rua4556 = new Endereco(null, "Rua das Secretarias", "Jardim Valparaíba", "Leste", "12221400");
		Endereco rua4557 = new Endereco(null, "Rua dos Gráficos", "Jardim Valparaíba", "Leste", "12221401");
		Endereco rua4558 = new Endereco(null, "Rua dos Aviadores", "Jardim Valparaíba", "Leste", "12221410");
		Endereco rua4559 = new Endereco(null, "Rua dos Engenheiros", "Jardim Valparaíba", "Leste", "12221780");
		Endereco rua4560 = new Endereco(null, "Rua dos Medicos", "Jardim Valparaíba", "Leste", "12221790");
		Endereco rua4561 = new Endereco(null, "Rua dos Radialistas", "Jardim Valparaíba", "Leste", "12221800");
		Endereco rua4562 = new Endereco(null, "Rua dos Advogados", "Jardim Valparaíba", "Leste", "12221810");
		Endereco rua4563 = new Endereco(null, "Praça dos Professores", "Jardim Valparaíba", "Leste", "12221820");
		Endereco rua4564 = new Endereco(null, "Avenida dos Operarios", "Jardim Valparaíba", "Leste", "12221830");
		Endereco rua4565 = new Endereco(null, "Rua dos Comerciantes", "Jardim Valparaíba", "Leste", "12221840");
		Endereco rua4566 = new Endereco(null, "Rua Florença", "Jardim Veneza", "Sul", "12237060");
		Endereco rua4567 = new Endereco(null, "Rua José Cobra", "Jardim Veneza", "Sul", "12237061");
		Endereco rua4568 = new Endereco(null, "Rua Icatu", "Jardim Veneza", "Sul", "12237062");
		Endereco rua4569 = new Endereco(null, "Rua Penedo", "Jardim Veneza", "Sul", "12237070");
		Endereco rua4570 = new Endereco(null, "Rua Ravena", "Jardim Veneza", "Sul", "12237072");
		Endereco rua4571 = new Endereco(null, "Rua Bolonha", "Jardim Veneza", "Sul", "12237073");
		Endereco rua4572 = new Endereco(null, "Rua Genova", "Jardim Veneza", "Sul", "12237080");
		Endereco rua4573 = new Endereco(null, "Rua José Francisco Pereira Sales", "Jardim Veneza", "Sul", "12237090");
		Endereco rua4574 = new Endereco(null, "Rua Milão", "Jardim Veneza", "Sul", "12237092");
		Endereco rua4575 = new Endereco(null, "Rua Napolis", "Jardim Veneza", "Sul", "12237093");
		Endereco rua4576 = new Endereco(null, "Rua Matsustoco Taira", "Jardim Limoeiro", "Oeste", "12241280");
		Endereco rua4577 = new Endereco(null, "Rua Renato Alves da Cunha", "Jardim Limoeiro", "Oeste", "12241290");
		Endereco rua4578 = new Endereco(null, "Rua Olga Rocha de Moraes", "Jardim Limoeiro", "Oeste", "12241300");
		Endereco rua4579 = new Endereco(null, "Rua Pedro Soares de Moraes", "Jardim Limoeiro", "Oeste", "12241310");
		Endereco rua4580 = new Endereco(null, "Rua Benedito Joaquim Pereira", "Jardim Limoeiro", "Oeste", "12241320");
		Endereco rua4581 = new Endereco(null, "Rua Valdir Guratti", "Jardim Limoeiro", "Oeste", "12241330");
		Endereco rua4582 = new Endereco(null, "Rua Sérgio Gonzaga Azevedo", "Jardim Limoeiro", "Oeste", "12241340");
		Endereco rua4583 = new Endereco(null, "Rua Hélio José Bertolini Freire", "Jardim Limoeiro", "Oeste",
				"12241350");
		Endereco rua4584 = new Endereco(null, "Rua Estácio José do Nascimento", "Jardim Limoeiro", "Oeste", "12241360");
		Endereco rua4585 = new Endereco(null, "Rodovia Presidente Dutra", "Jardim Limoeiro", "Oeste", "12241361");
		Endereco rua4586 = new Endereco(null, "Avenida Tecsat", "Jardim Limoeiro", "Oeste", "12241365");
		Endereco rua4587 = new Endereco(null, "Rua Amauri de Oliveira", "Jardim Limoeiro", "Oeste", "12241370");
		Endereco rua4588 = new Endereco(null, "Rua Oswaldo de Pinto Guimarães", "Jardim Limoeiro", "Oeste", "12241380");
		Endereco rua4589 = new Endereco(null, "Rua Jairo Pinto Figueredo", "Jardim Limoeiro", "Oeste", "12241390");
		Endereco rua4590 = new Endereco(null, "Estrada Municipal do Limoeiro", "Jardim Limoeiro", "Oeste", "12241400");
		Endereco rua4591 = new Endereco(null, "Travessa Municipal do Limoeiro", "Jardim Limoeiro", "Oeste", "12241410");
		Endereco rua4592 = new Endereco(null, "Rua Pedro Luiz de Oliveira Costa", "Jardim Limoeiro", "Oeste",
				"12241420");
		Endereco rua4593 = new Endereco(null, "Rua Carlos Marcondes", "Jardim Limoeiro", "Oeste", "12241421");
		Endereco rua4594 = new Endereco(null, "Praça Mário Malta Guimarães", "Jardim Limoeiro", "Oeste", "12241422");
		Endereco rua4595 = new Endereco(null, "Rua Doutor Pedro Luiz de Oliveira Costa", "Jardim Limoeiro", "Oeste",
				"12241430");
		Endereco rua4596 = new Endereco(null, "Rua da Palha", "Jardim Limoeiro", "Oeste", "12241440");
		Endereco rua4597 = new Endereco(null, "Rua Alberto de Moraes Bittencourt Simões", "Jardim Limoeiro", "Oeste",
				"12241450");
		Endereco rua4598 = new Endereco(null, "Rua Particular", "Jardim Limoeiro", "Oeste", "12241460");
		Endereco rua4599 = new Endereco(null, "Rua Projetada", "Jardim Limoeiro", "Oeste", "12241470");
		Endereco rua4600 = new Endereco(null, "Rua Carlos Marcondes", " 1200", "Jardim Limoeiro", "Oeste");
		Endereco rua4601 = new Endereco(null, "Rodovia Presidente Dutra", " Km 159", "Jardim Limoeiro", "Oeste");
		Endereco rua4602 = new Endereco(null, "Rua Carmem Miranda", "Vila Ester", "Norte", "12221710");
		Endereco rua4603 = new Endereco(null, "Rua Doutor Cláudio Martins Miranda Chaves", "Jardim São Vicente",
				"Norte", "12224410");
		Endereco rua4604 = new Endereco(null, "Rua Amado Ribeiro de Miranda", "Jardim Rodolfo", "Norte", "12224832");
		Endereco rua4605 = new Endereco(null, "Rua Crisante Barbosa Miranda", "Jardim Nova Michigan", "Norte",
				"12225410");
		Endereco rua4606 = new Endereco(null, "Rua Missionário David Martins de Miranda", "Chácaras Boa Esperança",
				"Norte", "12226301");
		Endereco rua4607 = new Endereco(null, "Avenida Laudelino Gonçalves de Miranda", "Jardim Santa Júlia", "Norte",
				"12228271");
		Endereco rua4608 = new Endereco(null, "Rua Maria do Carmo de Miranda Castelo Branco",
				"Conjunto Residencial Trinta e Um de Março", "Norte", "12237491");
		Endereco rua4609 = new Endereco(null, "Praça Darcy Miranda", "Condomínio Loteamento Reserva das Figueiras",
				"Norte", "12242333");
		Endereco rua4610 = new Endereco(null, "Rua Professor Everardo Miranda Passos", "Vila Betânia", "Norte",
				"12245604");
		Endereco rua4611 = new Endereco(null, "Rua Monte Castelo", "Jardim Altos de Santana", "Centro", "12214110");
		Endereco rua4612 = new Endereco(null, "Avenida Brasil", "Monte Castelo", "Centro", "12215000");
		Endereco rua4613 = new Endereco(null, "Praça Professor Estevão Ferri", "Monte Castelo", "Centro", "12215010");
		Endereco rua4614 = new Endereco(null, "Rua Emílio de Menezes", "Monte Castelo", "Centro", "12215020");
		Endereco rua4615 = new Endereco(null, "Rua Capitão Raul Fagundes", "Monte Castelo", "Centro", "12215030");
		Endereco rua4616 = new Endereco(null, "Rua Domingos Campoy Bernal", "Monte Castelo", "Centro", "12215040");
		Endereco rua4617 = new Endereco(null, "Rua Josino Bernardes Ferreira", "Monte Castelo", "Centro", "12215050");
		Endereco rua4618 = new Endereco(null, "Rua Coronel Donato Mascarenhas", "Monte Castelo", "Centro", "12215060");
		Endereco rua4619 = new Endereco(null, "Rua Marechal Rondon", "Monte Castelo", "Centro", "12215070");
		Endereco rua4620 = new Endereco(null, "Rua Machado de Assis", "Monte Castelo", "Centro", "12215080");
		Endereco rua4621 = new Endereco(null, "Rua Vinte e Sete de Julho", "Monte Castelo", "Centro", "12215100");
		Endereco rua4622 = new Endereco(null, "Rua Cantidio Miragaia", "Monte Castelo", "Centro", "12215110");
		Endereco rua4623 = new Endereco(null, "Rua Gomide Santos", "Monte Castelo", "Centro", "12215120");
		Endereco rua4624 = new Endereco(null, "Rua Luiz Pasteur", "Monte Castelo", "Centro", "12215140");
		Endereco rua4625 = new Endereco(null, "Rua Antenor Nascimento", "Monte Castelo", "Centro", "12215150");
		Endereco rua4626 = new Endereco(null, "Praça Francisco Escobar", "Monte Castelo", "Centro", "12215170");
		Endereco rua4627 = new Endereco(null, "Rua José Pedro Baracho", "Monte Castelo", "Centro", "12215180");
		Endereco rua4628 = new Endereco(null, "Rua Dezenove de Novembro", "Monte Castelo", "Centro", "12215190");
		Endereco rua4629 = new Endereco(null, "Rua Treze de Maio", "Monte Castelo", "Centro", "12215200");
		Endereco rua4630 = new Endereco(null, "Rua Doze de Outubro", "Monte Castelo", "Centro", "12215210");
		Endereco rua4631 = new Endereco(null, "Rua Vinte e Cinco de Dezembro", "Monte Castelo", "Centro", "12215220");
		Endereco rua4632 = new Endereco(null, "Rua Primeiro de Maio", "Monte Castelo", "Centro", "12215230");
		Endereco rua4633 = new Endereco(null, "Rua José Silveira Campanati", "Monte Castelo", "Centro", "12215240");
		Endereco rua4634 = new Endereco(null, "Rua Guararapes", "Monte Castelo", "Centro", "12215250");
		Endereco rua4635 = new Endereco(null, "Rua Henrique Dias", "Monte Castelo", "Centro", "12215260");
		Endereco rua4636 = new Endereco(null, "Avenida Senador Teotônio Vilela", "Monte Castelo", "Centro", "12215261");
		Endereco rua4637 = new Endereco(null, "Rua Martins Fontes", "Monte Castelo", "Centro", "12215280");
		Endereco rua4638 = new Endereco(null, "Rua Vinte e Um de Abril", "Monte Castelo", "Centro", "12215290");
		Endereco rua4639 = new Endereco(null, "Rua Maestro Francisco Gaia", "Monte Castelo", "Centro", "12215310");
		Endereco rua4640 = new Endereco(null, "Praça da República", "Monte Castelo", "Centro", "12215320");
		Endereco rua4641 = new Endereco(null, "Rua Doutor Clemente Ferreira", "Monte Castelo", "Centro", "12215330");
		Endereco rua4642 = new Endereco(null, "Praça Terezinha Teixeira da Silva", "Monte Castelo", "Centro",
				"12215340");
		Endereco rua4643 = new Endereco(null, "Praça Tobias Barreto", "Monte Castelo", "Centro", "12215360");
		Endereco rua4644 = new Endereco(null, "Rua Trinta e Um de Março", "Monte Castelo", "Centro", "12215370");
		Endereco rua4645 = new Endereco(null, "Avenida Presidente Juscelino Kubitschek", "Monte Castelo", "Centro",
				"12215380");
		Endereco rua4646 = new Endereco(null, "Rua Ana Gonçalves da Cunha", "Monte Castelo", "Centro", "12215390");
		Endereco rua4647 = new Endereco(null, "Rua Magnólia", "Monte Castelo", "Centro", "12215400");
		Endereco rua4648 = new Endereco(null, "Rua Camélia", "Monte Castelo", "Centro", "12215410");
		Endereco rua4649 = new Endereco(null, "Praça Custódio Bento de Souza", "Monte Castelo", "Centro", "12215420");
		Endereco rua4650 = new Endereco(null, "Rua Francisco José de Souza", "Monte Castelo", "Centro", "12215440");
		Endereco rua4651 = new Endereco(null, "Rua Gladiolo", "Monte Castelo", "Centro", "12215450");
		Endereco rua4652 = new Endereco(null, "Praça Olívio Augusto da Silva", "Monte Castelo", "Centro", "12215451");
		Endereco rua4653 = new Endereco(null, "Rua Nenufar", "Monte Castelo", "Centro", "12215460");
		Endereco rua4654 = new Endereco(null, "Rua Amaranto", "Monte Castelo", "Centro", "12215470");
		Endereco rua4655 = new Endereco(null, "Rua Adonis", "Monte Castelo", "Centro", "12215480");
		Endereco rua4656 = new Endereco(null, "Rua Doutor Astrogildo Machado", "Monte Castelo", "Centro", "12215490");
		Endereco rua4657 = new Endereco(null, "Rua Lupércio Ramos", "Monte Castelo", "Centro", "12215500");
		Endereco rua4658 = new Endereco(null, "Rua Professora Rosa Soares Penido", "Monte Castelo", "Centro",
				"12215510");
		Endereco rua4659 = new Endereco(null, "Rua Doutor Paulo Barbosa Lima", "Monte Castelo", "Centro", "12215520");
		Endereco rua4660 = new Endereco(null, "Praça Ana Berling Macedo", "Monte Castelo", "Centro", "12215530");
		Endereco rua4661 = new Endereco(null, "Rua Maria Mercedes Ferreira Maldos", "Monte Castelo", "Centro",
				"12215540");
		Endereco rua4662 = new Endereco(null, "Rua Professor Ayres Amâncio de Moura", "Monte Castelo", "Centro",
				"12215550");
		Endereco rua4663 = new Endereco(null, "Rua Oscar da Silva Santos", "Monte Castelo", "Centro", "12215560");
		Endereco rua4664 = new Endereco(null, "Rua Francisco Rodrigues de Moraes", "Monte Castelo", "Centro",
				"12215570");
		Endereco rua4665 = new Endereco(null, "Rua Ferze Abdul Ahad Tau", "Monte Castelo", "Centro", "12215571");
		Endereco rua4666 = new Endereco(null, "Rua Waldir Gaioso", "Monte Castelo", "Centro", "12215580");
		Endereco rua4667 = new Endereco(null, "Rua Vitória da Conquista", "Monte Castelo", "Centro", "12215581");
		Endereco rua4668 = new Endereco(null, "Rua Nemésio Flávio Queiroz Júnior", "Monte Castelo", "Centro",
				"12215582");
		Endereco rua4669 = new Endereco(null, "Rua Pedro Pinto da Cunha Filho", "Monte Castelo", "Centro", "12215590");
		Endereco rua4670 = new Endereco(null, "Rua Martins Pereira", "Monte Castelo", "Centro", "12215600");
		Endereco rua4671 = new Endereco(null, "Rua Dois", "Monte Castelo", "Centro", "12215610");
		Endereco rua4672 = new Endereco(null, "Rua Um", "Monte Castelo", "Centro", "12215620");
		Endereco rua4673 = new Endereco(null, "Rua Augusto de Sá Leite", "Monte Castelo", "Centro", "12215630");
		Endereco rua4674 = new Endereco(null, "Rua Benedito Fernandes César Leite Júnior", "Monte Castelo", "Centro",
				"12215640");
		Endereco rua4675 = new Endereco(null, "Rua Carlos Izino Pereira", "Morada do Sol", "Leste", "12237570");
		Endereco rua4676 = new Endereco(null, "Praça Benedito Domingos Ramos", "Morada do Sol", "Leste", "12237575");
		Endereco rua4677 = new Endereco(null, "Rua Icatu", "Morada do Sol", "Leste", "12237576");
		Endereco rua4678 = new Endereco(null, "Rua Antônio Rosin", "Morada do Sol", "Leste", "12237580");
		Endereco rua4679 = new Endereco(null, "Rua Raul Estefano", "Loteamento Conjunto Morada do Sol II", "Leste",
				"12237590");
		Endereco rua4680 = new Endereco(null, "Rua Raimundo Batista Conceição", "Loteamento Conjunto Morada do Sol II",
				"Leste", "12237591");
		Endereco rua4681 = new Endereco(null, "Travessa Aparecida Maria Consiglio", "Jardim Nova Michigan II", "Leste",
				"12225422");
		Endereco rua4682 = new Endereco(null, "Rua Ruy Pereira Gomes", "Jardim Nova Michigan II", "Leste", "12225423");
		Endereco rua4683 = new Endereco(null, "Travessa Luiz Carlos Ossamu Kishi", "Jardim Nova Michigan II", "Leste",
				"12225424");
		Endereco rua4684 = new Endereco(null, "Travessa Dimas Moreira dos Santos", "Jardim Nova Michigan II", "Leste",
				"12225425");
		Endereco rua4685 = new Endereco(null, "Rua Fernanda Paula Silva Duarte", "Jardim Nova Michigan II", "Leste",
				"12225426");
		Endereco rua4686 = new Endereco(null, "Rua Um", "Chácaras Oliveiras", "Norte", "12213271");
		Endereco rua4687 = new Endereco(null, "Rua Dois", "Chácaras Oliveiras", "Norte", "12213272");
		Endereco rua4688 = new Endereco(null, "Rua Três", "Chácaras Oliveiras", "Norte", "12213273");
		Endereco rua4689 = new Endereco(null, "Rua Quatro", "Chácaras Oliveiras", "Norte", "12213274");
		Endereco rua4690 = new Endereco(null, "Rua Cinco", "Chácaras Oliveiras", "Norte", "12213276");
		Endereco rua4691 = new Endereco(null, "Rua Monte das Oliveiras", "Jardim Altos de Santana", "Norte",
				"12214100");
		Endereco rua4692 = new Endereco(null, "Avenida das Oliveiras", "Residencial Frei Galvão", "Norte", "12248703");
		Endereco rua4693 = new Endereco(null, "Rua Oros", "Palmeiras de São José", "Sul", "12237150");
		Endereco rua4694 = new Endereco(null, "Rua José Cobra", "Palmeiras de São José", "Sul", "12237821");
		Endereco rua4695 = new Endereco(null, "Rodovia Presidente Dutra", "Palmeiras de São José", "Sul", "12237822");
		Endereco rua4696 = new Endereco(null, "Avenida Doutor Sebastião Henrique da Cunha Pontes",
				"Palmeiras de São José", "Sul", "12237823");
		Endereco rua4697 = new Endereco(null, "Rua Valença", "Palmeiras de São José", "Sul", "12237824");
		Endereco rua4698 = new Endereco(null, "Travessa Poty", "Palmeiras de São José", "Sul", "12237825");
		Endereco rua4699 = new Endereco(null, "Travessa Potengy", "Palmeiras de São José", "Sul", "12237826");
		Endereco rua4700 = new Endereco(null, "Travessa Assu", "Palmeiras de São José", "Sul", "12237827");
		Endereco rua4701 = new Endereco(null, "Rua Raimundo Barbosa Nogueira", "Palmeiras de São José", "Sul",
				"12237828");
		Endereco rua4702 = new Endereco(null, "Rua Gilberto Menotti Eugênio Cara", "Palmeiras de São José", "Sul",
				"12237829");
		Endereco rua4703 = new Endereco(null, "Rua Cidade de Bagé", "Palmeiras de São José", "Sul", "12237831");
		Endereco rua4704 = new Endereco(null, "Rua Saudades da Querência", "Palmeiras de São José", "Sul", "12237832");
		Endereco rua4705 = new Endereco(null, "Rua Brasília Ragazzini Saes", "Palmeiras de São José", "Sul",
				"12237833");
		Endereco rua4706 = new Endereco(null, "Rua Cidade Lageado", "Palmeiras de São José", "Sul", "12237834");
		Endereco rua4707 = new Endereco(null, "Rua Antônio Pedro", "Palmeiras de São José", "Sul", "12237836");
		Endereco rua4708 = new Endereco(null, "Rua Mehgy Moanna Metene", "Palmeiras de São José", "Sul", "12237837");
		Endereco rua4709 = new Endereco(null, "Rua Olinto de Aquino", "Palmeiras de São José", "Sul", "12237838");
		Endereco rua4710 = new Endereco(null, "Praça Farroupilha", "Palmeiras de São José", "Sul", "12237839");
		Endereco rua4711 = new Endereco(null, "Rua Osiris Costa Monteiro de Barros", "Palmeiras de São José", "Sul",
				"12237841");
		Endereco rua4712 = new Endereco(null, "Rua Nove", "Palmeiras de São José", "Sul", "12237850");
		Endereco rua4713 = new Endereco(null, "Praça Altamira", "Palmeiras de São José", "Sul", "12237851");
		Endereco rua4714 = new Endereco(null, "Rua Cidade de Bento Gonçalves", "Palmeiras de São José", "Sul",
				"12237865");
		Endereco rua4715 = new Endereco(null, "Rua Helena Tirello Alvarenga Souza", "Palmeiras de São José", "Sul",
				"12237870");
		Endereco rua4716 = new Endereco(null, "Rodovia Presidente Dutra km 156", "Palmeiras de São José", "Sul",
				"12237900");
		Endereco rua4717 = new Endereco(null, "Rodovia Presidente Dutra Km 154", "7", "Palmeiras de São José", "Sul");
		Endereco rua4718 = new Endereco(null, "Avenida Doutor Sebastião Henrique da Cunha Pontes", " 4450",
				"Palmeiras de São José", "Sul");
		Endereco rua4719 = new Endereco(null, "Avenida Doutor Sebastião Henrique da Cunha Pontes", " 4450",
				"Palmeiras de São José", "Sul");
		Endereco rua4720 = new Endereco(null, "Avenida Doutor Sebastião Henrique da Cunha Pontes", " 4450",
				"Palmeiras de São José", "Sul");
		Endereco rua4721 = new Endereco(null, "Rua Alziro Claro de Oliveira", "Parque dos Ipês", "Sul", "12236856");
		Endereco rua4722 = new Endereco(null, "Rua Messias Thomaz de Freitas", "Parque dos Ipês", "Sul", "12236857");
		Endereco rua4723 = new Endereco(null, "Rua Alberto Pinto Ferreira", "Parque dos Ipês", "Sul", "12236858");
		Endereco rua4724 = new Endereco(null, "Rua João Adão", "Parque dos Ipês", "Sul", "12236859");
		Endereco rua4725 = new Endereco(null, "Avenida Antônio de Pádua Santos", "Parque dos Ipês", "Sul", "12236860");
		Endereco rua4726 = new Endereco(null, "Rua Felício Alves de Araújo", "Parque dos Ipês", "Sul", "12236861");
		Endereco rua4727 = new Endereco(null, "Rua Regina Maria Carvalho", "Parque dos Ipês", "Sul", "12236862");
		Endereco rua4728 = new Endereco(null, "Rua Pastor Miguel Cornélio de Morais", "Parque dos Ipês", "Sul",
				"12236865");
		Endereco rua4729 = new Endereco(null, "Rua Josephina Cury", "Parque Independencia", "Sul", "12237600");
		Endereco rua4730 = new Endereco(null, "Rua Icatu", "Parque Independencia", "Sul", "12237601");
		Endereco rua4731 = new Endereco(null, "Rua José Felipe", "Parque Independencia", "Sul", "12237610");
		Endereco rua4732 = new Endereco(null, "Rua Antônio Augusto Carvalho Santos Pinto", "Parque Independencia",
				"Sul", "12237620");
		Endereco rua4733 = new Endereco(null, "Rua Francisco Broglioto", "Parque Independencia", "Sul", "12237630");
		Endereco rua4734 = new Endereco(null, "Rua Traipu", "Parque Industrial", "Sul", "12235510");
		Endereco rua4735 = new Endereco(null, "Rua Camocim", "Parque Industrial", "Sul", "12235520");
		Endereco rua4736 = new Endereco(null, "Rua Caruaru", "Parque Industrial", "Sul", "12235530");
		Endereco rua4737 = new Endereco(null, "Rua Bragança", "Parque Industrial", "Sul", "12235540");
		Endereco rua4738 = new Endereco(null, "Rua Santarem", "Parque Industrial", "Sul", "12235550");
		Endereco rua4739 = new Endereco(null, "Rua Arcoverde", "Parque Industrial", "Sul", "12235551");
		Endereco rua4740 = new Endereco(null, "Rua Coroatá", "Parque Industrial", "Sul", "12235552");
		Endereco rua4741 = new Endereco(null, "Praça Padre Leon Dehon", "Parque Industrial", "Sul", "12235553");
		Endereco rua4742 = new Endereco(null, "Avenida Fortaleza", "Parque Industrial", "Sul", "12235560");
		Endereco rua4743 = new Endereco(null, "Rua Macau", "Parque Industrial", "Sul", "12235561");
		Endereco rua4744 = new Endereco(null, "Rua Pombal", "Parque Industrial", "Sul", "12235562");
		Endereco rua4745 = new Endereco(null, "Rua Macapa", "Parque Industrial", "Sul", "12235570");
		Endereco rua4746 = new Endereco(null, "Rua Crato", "Parque Industrial", "Sul", "12235580");
		Endereco rua4747 = new Endereco(null, "Rua Aquidaba", "Parque Industrial", "Sul", "12235581");
		Endereco rua4748 = new Endereco(null, "Rua Igaci", "Parque Industrial", "Sul", "12235582");
		Endereco rua4749 = new Endereco(null, "Rua Tutóia", "Parque Industrial", "Sul", "12235583");
		Endereco rua4750 = new Endereco(null, "Rua Tefe", "Parque Industrial", "Sul", "12235590");
		Endereco rua4751 = new Endereco(null, "Rua Codajas", "Parque Industrial", "Sul", "12235591");
		Endereco rua4752 = new Endereco(null, "Rua Maues", "Parque Industrial", "Sul", "12235600");
		Endereco rua4753 = new Endereco(null, "Rua Teresina", "Parque Industrial", "Sul", "12235610");
		Endereco rua4754 = new Endereco(null, "Rua Palmares", "Parque Industrial", "Sul", "12235620");
		Endereco rua4755 = new Endereco(null, "Praça Natal", "Parque Industrial", "Sul", "12235621");
		Endereco rua4756 = new Endereco(null, "Rua Goiânia", "Parque Industrial", "Sul", "12235625");
		Endereco rua4757 = new Endereco(null, "Rua Baturité", "Parque Industrial", "Sul", "12235630");
		Endereco rua4758 = new Endereco(null, "Rua Mossoro", "Parque Industrial", "Sul", "12235640");
		Endereco rua4759 = new Endereco(null, "Rua Icatu", "Parque Industrial", "Sul", "12235649");
		Endereco rua4760 = new Endereco(null, "Rua Turiacu", "Parque Industrial", "Sul", "12235650");
		Endereco rua4761 = new Endereco(null, "Rua Óbidos", "Parque Industrial", "Sul", "12235651");
		Endereco rua4762 = new Endereco(null, "Praça José Henrique", "Parque Industrial", "Sul", "12235652");
		Endereco rua4763 = new Endereco(null, "Rua Álvaro Gonçalves Júnior", "Parque Industrial", "Sul", "12235670");
		Endereco rua4764 = new Endereco(null, "Rua Lucia de Almeida Barreto", "Parque Industrial", "Sul", "12235671");
		Endereco rua4765 = new Endereco(null, "Rua Liege Alexandre Cosme do Nascimento", "Parque Industrial", "Sul",
				"12235672");
		Endereco rua4766 = new Endereco(null, "Rua Raul Seixas", "Parque Industrial", "Sul", "12235673");
		Endereco rua4767 = new Endereco(null, "Rua Bacabal", "Parque Industrial", "Sul", "12235680");
		Endereco rua4768 = new Endereco(null, "Rua Bacabal", "Parque Industrial", "Sul", "12235681");
		Endereco rua4769 = new Endereco(null, "Rua Anápolis", "Parque Industrial", "Sul", "12235690");
		Endereco rua4770 = new Endereco(null, "Rua George Williams", "Parque Industrial", "Sul", "12235691");
		Endereco rua4771 = new Endereco(null, "Rua Quixada", "Parque Industrial", "Sul", "12235700");
		Endereco rua4772 = new Endereco(null, "Rua Oeiras", "Parque Industrial", "Sul", "12235710");
		Endereco rua4773 = new Endereco(null, "Rua Itamaracá", "Parque Industrial", "Sul", "12235720");
		Endereco rua4774 = new Endereco(null, "Rua Manicoré", "Parque Industrial", "Sul", "12235730");
		Endereco rua4775 = new Endereco(null, "Rua Itumbiara", "Parque Industrial", "Sul", "12235740");
		Endereco rua4776 = new Endereco(null, "Rua Ingá", "Parque Industrial", "Sul", "12235741");
		Endereco rua4777 = new Endereco(null, "Rua Aracati", "Parque Industrial", "Sul", "12235742");
		Endereco rua4778 = new Endereco(null, "Rua Pimenteiras", "Parque Industrial", "Sul", "12235750");
		Endereco rua4779 = new Endereco(null, "Rua Jataí", "Parque Industrial", "Sul", "12235760");
		Endereco rua4780 = new Endereco(null, "Rua Coari", "Parque Industrial", "Sul", "12235770");
		Endereco rua4781 = new Endereco(null, "Rua Parintins", "Parque Industrial", "Sul", "12235771");
		Endereco rua4782 = new Endereco(null, "Rua Marabas", "Parque Industrial", "Sul", "12235780");
		Endereco rua4783 = new Endereco(null, "Rua Xapuri", "Parque Industrial", "Sul", "12235781");
		Endereco rua4784 = new Endereco(null, "Rua Juazeiro do Norte", "Parque Industrial", "Sul", "12235790");
		Endereco rua4785 = new Endereco(null, "Rua Alenquer", "Parque Industrial", "Sul", "12235800");
		Endereco rua4786 = new Endereco(null, "Rua João Naina", "Parque Industrial", "Sul", "12235810");
		Endereco rua4787 = new Endereco(null, "Rua Treze", "Parque Industrial", "Sul", "12235820");
		Endereco rua4788 = new Endereco(null, "Rua Olinda", "Parque Industrial", "Sul", "12235830");
		Endereco rua4789 = new Endereco(null, "Rua Goiânia", " 15", "Parque Industrial", "Sul");
		Endereco rua4790 = new Endereco(null, "Rua Sena Madureira", "Parque Industrial", "Sul", "12237020");
		Endereco rua4791 = new Endereco(null, "Rua RC 3", "Parque Interlagos", "Sul", "12229011");
		Endereco rua4792 = new Endereco(null, "Praça Darci Alves", "Parque Interlagos", "Sul", "12229071");
		Endereco rua4793 = new Endereco(null, "Praça Jonathan Guilherme Pereira dos Reis", "Parque Interlagos", "Sul",
				"12229081");
		Endereco rua4794 = new Endereco(null, "Condomínio Residencial Interlagos", "Parque Interlagos", "Sul",
				"12229082");
		Endereco rua4795 = new Endereco(null, "Travessa Ida de Castro Nascimento", "Parque Interlagos", "Sul",
				"12229083");
		Endereco rua4796 = new Endereco(null, "Rua NC 6", "Parque Interlagos", "Sul", "12229321");
		Endereco rua4797 = new Endereco(null, "Travessa Um", "Parque Interlagos", "Sul", "12229383");
		Endereco rua4798 = new Endereco(null, "Rua Seis", "Parque Interlagos", "Sul", "12229386");
		Endereco rua4799 = new Endereco(null, "Estrada Municipal Sul", "Parque Interlagos", "Sul", "12229390");
		Endereco rua4800 = new Endereco(null, "Estrada Municipal SJC-145", "Parque Interlagos", "Sul", "12229392");
		Endereco rua4801 = new Endereco(null, "Rua Maria Amélia Nogueira", "Parque Interlagos", "Sul", "12229440");
		Endereco rua4802 = new Endereco(null, "Rua Nl", "Parque Interlagos", "Sul", "12229450");
		Endereco rua4803 = new Endereco(null, "Travessa Municipal", "Parque Interlagos", "Sul", "12229460");
		Endereco rua4804 = new Endereco(null, "Rua Municipal SJC-482", "Parque Interlagos", "Sul", "12229510");
		Endereco rua4805 = new Endereco(null, "Rua A", "Parque Interlagos", "Sul", "12229520");
		Endereco rua4806 = new Endereco(null, "Rua de Servidão", "Parque Interlagos", "Sul", "12229530");
		Endereco rua4807 = new Endereco(null, "Rua Robert Marden Oliveira de Mello", "Parque Interlagos", "Sul",
				"12229810");
		Endereco rua4808 = new Endereco(null, "Rua Ivan Maria da Motta", "Parque Interlagos", "Sul", "12229822");
		Endereco rua4809 = new Endereco(null, "Rua SC 3", "Parque Interlagos", "Sul", "12229823");
		Endereco rua4810 = new Endereco(null, "Rua Valdir Pereira dos Santos", "Parque Interlagos", "Sul", "12229824");
		Endereco rua4811 = new Endereco(null, "Rua SC 5", "Parque Interlagos", "Sul", "12229825");
		Endereco rua4812 = new Endereco(null, "Rua Paulo Roberto Ferreira de Moura", "Parque Interlagos", "Sul",
				"12229826");
		Endereco rua4813 = new Endereco(null, "Rua Maria Vera Prado Machado", "Parque Interlagos", "Sul", "12229827");
		Endereco rua4814 = new Endereco(null, "Rua Sebastião Damas dos Santos", "Parque Interlagos", "Sul", "12229828");
		Endereco rua4815 = new Endereco(null, "Rua Anna Benedicta Dias Pedrosa", "Parque Interlagos", "Sul",
				"12229829");
		Endereco rua4816 = new Endereco(null, "Rua Ananias Cândido de Lima", "Parque Interlagos", "Sul", "12229832");
		Endereco rua4817 = new Endereco(null, "Avenida Brigadeiro Faria Lima", "Parque Martim Cererê", "Sudeste",
				"12227000");
		Endereco rua4818 = new Endereco(null, "Rua Oswaldo Ricci", "Parque Martim Cererê", "Sudeste", "12227750");
		Endereco rua4819 = new Endereco(null, "Rua Doutora Tânia Lis Tizzoni Nogueira", "Parque Martim Cererê",
				"Sudeste", "12227751");
		Endereco rua4820 = new Endereco(null, "Praça Andrelina Barbosa de Moura", "Parque Martim Cererê", "Sudeste",
				"12227770");
		Endereco rua4821 = new Endereco(null, "Rua Professor Waldemar Ramos", "Parque Martim Cererê", "Sudeste",
				"12227772");
		Endereco rua4822 = new Endereco(null, "Rua Chackler Elhage", "Parque Martim Cererê", "Sudeste", "12227773");
		Endereco rua4823 = new Endereco(null, "Avenida José Scarpel", "Parque Nova Esperança", "Leste", "12226010");
		Endereco rua4824 = new Endereco(null, "Rua Anésia Emília da Silva", "Parque Nova Esperança", "Leste",
				"12226020");
		Endereco rua4825 = new Endereco(null, "Rua Geraldo Fernandes da Silva", "Parque Nova Esperança", "Leste",
				"12226030");
		Endereco rua4826 = new Endereco(null, "Rua João Mariano de Assis", "Parque Nova Esperança", "Leste",
				"12226040");
		Endereco rua4827 = new Endereco(null, "Rua Carlos Alberto Pereira da Silva", "Parque Nova Esperança", "Leste",
				"12226050");
		Endereco rua4828 = new Endereco(null, "Rua Vicente Antônio de Araújo", "Parque Nova Esperança", "Leste",
				"12226060");
		Endereco rua4829 = new Endereco(null, "Rua Benedito Pereira da Silva", "Parque Nova Esperança", "Leste",
				"12226070");
		Endereco rua4830 = new Endereco(null, "Rua Doutor José Luiz Buck Ferreira", "Parque Nova Esperança", "Leste",
				"12226080");
		Endereco rua4831 = new Endereco(null, "Rua Elio de Castro", "Parque Nova Esperança", "Leste", "12226081");
		Endereco rua4832 = new Endereco(null, "Rua Maria Helena Friggi de Lima", "Parque Nova Esperança", "Leste",
				"12226082");
		Endereco rua4833 = new Endereco(null, "Rua Cândida Costa da Silva", "Parque Nova Esperança", "Leste",
				"12226090");
		Endereco rua4834 = new Endereco(null, "Rua José Benedito Pereira da Silva", "Parque Nova Esperança", "Leste",
				"12226100");
		Endereco rua4835 = new Endereco(null, "Rua José Tomaz", "Parque Nova Esperança", "Leste", "12226110");
		Endereco rua4836 = new Endereco(null, "Rua Doutor Vítor Machado Carvalho", "Parque Nova Esperança", "Leste",
				"12226111");
		Endereco rua4837 = new Endereco(null, "Rua Ana Moreira de Oliveira", "Parque Nova Esperança", "Leste",
				"12226120");
		Endereco rua4838 = new Endereco(null, "Rua José Antônio Quirino", "Parque Nova Esperança", "Leste", "12226130");
		Endereco rua4839 = new Endereco(null, "Rua Maria Agda de Jesus", "Parque Nova Esperança", "Leste", "12226140");
		Endereco rua4840 = new Endereco(null, "Avenida Carlos Alberto de Andrade Silva", "Parque Nova Esperança",
				"Leste", "12226150");
		Endereco rua4841 = new Endereco(null, "Rua José Castrioto", "Parque Nova Esperança", "Leste", "12226160");
		Endereco rua4842 = new Endereco(null, "Rua Ângelo Scarpel", "Parque Nova Esperança", "Leste", "12226170");
		Endereco rua4843 = new Endereco(null, "Rua Emerson Rodolfo Rodrigues da Silva", "Parque Nova Esperança",
				"Leste", "12226180");
		Endereco rua4844 = new Endereco(null, "Rua Aprigio Bernardino Salles Filho", "Parque Nova Esperança", "Leste",
				"12226190");
		Endereco rua4845 = new Endereco(null, "Rua Armando Veneziani de Toledo", "Parque Nova Esperança", "Leste",
				"12226200");
		Endereco rua4846 = new Endereco(null, "Rua Albert Sabin", "Parque Nova Esperança", "Leste", "12226201");
		Endereco rua4847 = new Endereco(null, "Rua dos Ferreiros", "Parque Novo Horizonte", "Leste", "12225600");
		Endereco rua4848 = new Endereco(null, "Rua dos Mecânicos", "Parque Novo Horizonte", "Leste", "12225610");
		Endereco rua4849 = new Endereco(null, "Rua dos Lavradores", "Parque Novo Horizonte", "Leste", "12225620");
		Endereco rua4850 = new Endereco(null, "Rua dos Farmacêuticos", "Parque Novo Horizonte", "Leste", "12225630");
		Endereco rua4851 = new Endereco(null, "Rua dos Armadores", "Parque Novo Horizonte", "Leste", "12225640");
		Endereco rua4852 = new Endereco(null, "Rua Carpinteiros", "Parque Novo Horizonte", "Leste", "12225650");
		Endereco rua4853 = new Endereco(null, "Rua dos Pedreiros", "Parque Novo Horizonte", "Leste", "12225660");
		Endereco rua4854 = new Endereco(null, "Praça Primeiro de Maio", "Parque Novo Horizonte", "Leste", "12225661");
		Endereco rua4855 = new Endereco(null, "Estrada do Paiol", "Parque Novo Horizonte", "Leste", "12225662");
		Endereco rua4856 = new Endereco(null, "Rua dos Encanadores", "Parque Novo Horizonte", "Leste", "12225670");
		Endereco rua4857 = new Endereco(null, "Rua dos Desenhistas", "Parque Novo Horizonte", "Leste", "12225680");
		Endereco rua4858 = new Endereco(null, "Rua dos Funileiros", "Parque Novo Horizonte", "Leste", "12225690");
		Endereco rua4859 = new Endereco(null, "Rua dos Carteiros", "Parque Novo Horizonte", "Leste", "12225700");
		Endereco rua4860 = new Endereco(null, "Rua dos Eletricistas", "Parque Novo Horizonte", "Leste", "12225710");
		Endereco rua4861 = new Endereco(null, "Rua dos Pintores", "Parque Novo Horizonte", "Leste", "12225720");
		Endereco rua4862 = new Endereco(null, "Rua dos Serralheiros", "Parque Novo Horizonte", "Leste", "12225730");
		Endereco rua4863 = new Endereco(null, "Avenida Presidente Tancredo Neves", "Parque Novo Horizonte", "Leste",
				"12225731");
		Endereco rua4864 = new Endereco(null, "Avenida Presidente Tancredo Neves", "Parque Novo Horizonte", "Leste",
				"12225732");
		Endereco rua4865 = new Endereco(null, "Rua dos Alfaiates", "Parque Novo Horizonte", "Leste", "12225740");
		Endereco rua4866 = new Endereco(null, "Rua dos Sapateiros", "Parque Novo Horizonte", "Leste", "12225750");
		Endereco rua4867 = new Endereco(null, "Rua dos Topógrafos", "Parque Novo Horizonte", "Leste", "12225751");
		Endereco rua4868 = new Endereco(null, "Rua dos Ceramistas", "Parque Novo Horizonte", "Leste", "12225760");
		Endereco rua4869 = new Endereco(null, "Rua dos Vidraceiros", "Parque Novo Horizonte", "Leste", "12225761");
		Endereco rua4870 = new Endereco(null, "Rua dos Jardineiros", "Parque Novo Horizonte", "Leste", "12225770");
		Endereco rua4871 = new Endereco(null, "Rua dos Oleiros", "Parque Novo Horizonte", "Leste", "12225771");
		Endereco rua4872 = new Endereco(null, "Rua dos Artesãs", "Parque Novo Horizonte", "Leste", "12225780");
		Endereco rua4873 = new Endereco(null, "Rua dos Balconistas", "Parque Novo Horizonte", "Leste", "12225790");
		Endereco rua4874 = new Endereco(null, "Rua das Costureiras", "Parque Novo Horizonte", "Leste", "12225801");
		Endereco rua4875 = new Endereco(null, "Rua das Floristas", "Parque Novo Horizonte", "Leste", "12225802");
		Endereco rua4876 = new Endereco(null, "Estrada Santo Antônio do Alto", "Parque Novo Horizonte", "Leste",
				"12225810");
		Endereco rua4877 = new Endereco(null, "Rua das Datilográfas", "Parque Novo Horizonte", "Leste", "12225820");
		Endereco rua4878 = new Endereco(null, "Rua dos Agronomos", "Parque Novo Horizonte", "Leste", "12225830");
		Endereco rua4879 = new Endereco(null, "Rua dos Padeiros", "Parque Novo Horizonte", "Leste", "12225831");
		Endereco rua4880 = new Endereco(null, "Praça Milton Antônio Pereira", "Parque Novo Horizonte", "Leste",
				"12225832");
		Endereco rua4881 = new Endereco(null, "Rua dos Construtores", "Parque Novo Horizonte", "Leste", "12225834");
		Endereco rua4882 = new Endereco(null, "Rua dos Dentistas", "Parque Novo Horizonte", "Leste", "12225835");
		Endereco rua4883 = new Endereco(null, "Estrada Municipal Novo Horizonte", "Parque Novo Horizonte", "Leste",
				"12225836");
		Endereco rua4884 = new Endereco(null, "Avenida Alfredo Ignácio Nogueira Penido", "Parque Residencial Aquarius",
				"Oeste", "12246000");
		Endereco rua4885 = new Endereco(null, "Rua Doutor Tertuliano Delphim Júnior", "Parque Residencial Aquarius",
				"Oeste", "12246001");
		Endereco rua4886 = new Endereco(null, "Rua Armando de Oliveira Cobra", "Parque Residencial Aquarius", "Oeste",
				"12246002");
		Endereco rua4887 = new Endereco(null, "Alameda dos Acarás", "Parque Residencial Aquarius", "Oeste", "12246010");
		Endereco rua4888 = new Endereco(null, "Rua dos Piquiroes", "Parque Residencial Aquarius", "Oeste", "12246020");
		Endereco rua4889 = new Endereco(null, "Rua Benedito Osvaldo Lecques", "Parque Residencial Aquarius", "Oeste",
				"12246021");
		Endereco rua4890 = new Endereco(null, "Rua José Pulga", "Parque Residencial Aquarius", "Oeste", "12246022");
		Endereco rua4891 = new Endereco(null, "Rua Célio José dos Santos", "Parque Residencial Aquarius", "Oeste",
				"12246023");
		Endereco rua4892 = new Endereco(null, "Rua Geraldo Vieira", "Parque Residencial Aquarius", "Oeste", "12246024");
		Endereco rua4893 = new Endereco(null, "Rua das Piabas", "Parque Residencial Aquarius", "Oeste", "12246030");
		Endereco rua4894 = new Endereco(null, "Avenida Vinte e Quatro", "Parque Residencial Aquarius", "Oeste",
				"12246031");
		Endereco rua4895 = new Endereco(null, "Avenida Vinte e Cinco", "Parque Residencial Aquarius", "Oeste",
				"12246032");
		Endereco rua4896 = new Endereco(null, "Avenida Dez", "Parque Residencial Aquarius", "Oeste", "12246033");
		Endereco rua4897 = new Endereco(null, "Rua das Piracanjubas", "Parque Residencial Aquarius", "Oeste",
				"12246040");
		Endereco rua4898 = new Endereco(null, "Rua Emílio Manoel Pereira", "Parque Residencial Aquarius", "Oeste",
				"12246041");
		Endereco rua4899 = new Endereco(null, "Rua Vitório Friggi", "Parque Residencial Aquarius", "Oeste", "12246046");
		Endereco rua4900 = new Endereco(null, "Rua das Tilápias", "Parque Residencial Aquarius", "Oeste", "12246050");
		Endereco rua4901 = new Endereco(null, "Rua Antonia Monteiro Afonso Reichelant", "Parque Residencial Aquarius",
				"Oeste", "12246051");
		Endereco rua4902 = new Endereco(null, "Rua Maria Isabel Pistilni Mendonça", "Parque Residencial Aquarius",
				"Oeste", "12246052");
		Endereco rua4903 = new Endereco(null, "Rua Gentil Otoboni", "Parque Residencial Aquarius", "Oeste", "12246053");
		Endereco rua4904 = new Endereco(null, "Rua Doutor Jorge de Oliveira Coutinho", "Parque Residencial Aquarius",
				"Oeste", "12246060");
		Endereco rua4905 = new Endereco(null, "Rua Engenheiro Carlos Gonçalves", "Parque Residencial Aquarius", "Oeste",
				"12246070");
		Endereco rua4906 = new Endereco(null, "Rua Cyro Guimarães", "Parque Residencial Aquarius", "Oeste", "12246071");
		Endereco rua4907 = new Endereco(null, "Praça Deputado Ulisses Guimarães", "Parque Residencial Aquarius",
				"Oeste", "12246080");
		Endereco rua4908 = new Endereco(null, "Rua Maria Elizabeth Schicker", "Parque Residencial Aquarius", "Oeste",
				"12246090");
		Endereco rua4909 = new Endereco(null, "Rua Engenheiro Alexandre Cóppio Ramos", "Parque Residencial Aquarius",
				"Oeste", "12246091");
		Endereco rua4910 = new Endereco(null, "Praça Senador Severo Gomes", "Parque Residencial Aquarius", "Oeste",
				"12246100");
		Endereco rua4911 = new Endereco(null, "Rua Roberto Augusto Tavares", "Parque Residencial Aquarius", "Oeste",
				"12246110");
		Endereco rua4912 = new Endereco(null, "Rua Fernando Garcia Biruel", "Parque Residencial Aquarius", "Oeste",
				"12246111");
		Endereco rua4913 = new Endereco(null, "Rua Benedito Alvarenga Carvalho", "Parque Residencial Aquarius", "Oeste",
				"12246120");
		Endereco rua4914 = new Endereco(null, "Rua Fuad Cury", "Parque Residencial Aquarius", "Oeste", "12246121");
		Endereco rua4915 = new Endereco(null, "Rua José Sergio Faria", "Parque Residencial Aquarius", "Oeste",
				"12246122");
		Endereco rua4916 = new Endereco(null, "Rua Victorio Friggi", "Parque Residencial Aquarius", "Oeste",
				"12246123");
		Endereco rua4917 = new Endereco(null, "Praça Professora Lila Barboza", "Parque Residencial Aquarius", "Oeste",
				"12246128");
		Endereco rua4918 = new Endereco(null, "Rua Ruivo", "Parque Residencial Aquarius", "Oeste", "12246130");
		Endereco rua4919 = new Endereco(null, "Avenida do Tubarão", "Parque Residencial Aquarius", "Oeste", "12246140");
		Endereco rua4920 = new Endereco(null, "Avenida Dezenove", "Parque Residencial Aquarius", "Oeste", "12246141");
		Endereco rua4921 = new Endereco(null, "Avenida Vinte", "Parque Residencial Aquarius", "Oeste", "12246142");
		Endereco rua4922 = new Endereco(null, "Avenida Vinte e Dois", "Parque Residencial Aquarius", "Oeste",
				"12246143");
		Endereco rua4923 = new Endereco(null, "Avenida Vinte e Três", "Parque Residencial Aquarius", "Oeste",
				"12246144");
		Endereco rua4924 = new Endereco(null, "Rua Doutor Tito Roberto Liberato", "Parque Residencial Aquarius",
				"Oeste", "12246150");
		Endereco rua4925 = new Endereco(null, "Rua João Teixeira Neto", "Parque Residencial Aquarius", "Oeste",
				"12246160");
		Endereco rua4926 = new Endereco(null, "Rua Benedito de Moura Sá", "Parque Residencial Aquarius", "Oeste",
				"12246170");
		Endereco rua4927 = new Endereco(null, "Rua Jurema Vieira Medrado", "Parque Residencial Aquarius", "Oeste",
				"12246180");
		Endereco rua4928 = new Endereco(null, "Rua Adalbert Bogsan", "Parque Residencial Aquarius", "Oeste",
				"12246181");
		Endereco rua4929 = new Endereco(null, "Rua Doutor Orlando Feirabend Filho", "Parque Residencial Aquarius",
				"Oeste", "12246190");
		Endereco rua4930 = new Endereco(null, "Rua Juiz David Barrilli", "Parque Residencial Aquarius", "Oeste",
				"12246200");
		Endereco rua4931 = new Endereco(null, "Rua das Corvinas", "Parque Residencial Aquarius", "Oeste", "12246210");
		Endereco rua4932 = new Endereco(null, "Rua das Tainhas", "Parque Residencial Aquarius", "Oeste", "12246220");
		Endereco rua4933 = new Endereco(null, "Rua das Sardinhas", "Parque Residencial Aquarius", "Oeste", "12246230");
		Endereco rua4934 = new Endereco(null, "Rua das Enchovas", "Parque Residencial Aquarius", "Oeste", "12246240");
		Endereco rua4935 = new Endereco(null, "Rua do Aruana", "Parque Residencial Aquarius", "Oeste", "12246250");
		Endereco rua4936 = new Endereco(null, "Praça da Justiça", "Parque Residencial Aquarius", "Oeste", "12246259");
		Endereco rua4937 = new Endereco(null, "Avenida Salmão", "Parque Residencial Aquarius", "Oeste", "12246260");
		Endereco rua4938 = new Endereco(null, "Rua Doutor Wilson Marques Maciel", "Parque Residencial Aquarius",
				"Oeste", "12246261");
		Endereco rua4939 = new Endereco(null, "Rua dos Dourados", "Parque Residencial Aquarius", "Oeste", "12246270");
		Endereco rua4940 = new Endereco(null, "Rua dos Lambaris", "Parque Residencial Aquarius", "Oeste", "12246280");
		Endereco rua4941 = new Endereco(null, "Rua das Baleias", "Parque Residencial Aquarius", "Oeste", "12246290");
		Endereco rua4942 = new Endereco(null, "Rua das Pescadas", "Parque Residencial Aquarius", "Oeste", "12246291");
		Endereco rua4943 = new Endereco(null, "Rua das Carpas", "Parque Residencial Aquarius", "Oeste", "12246292");
		Endereco rua4944 = new Endereco(null, "Avenida Professor Ovilio Panziera", "Parque Residencial Aquarius",
				"Oeste", "12246300");
		Endereco rua4945 = new Endereco(null, "Rua dos Arenques", "Parque Residencial Aquarius", "Oeste", "12246310");
		Endereco rua4946 = new Endereco(null, "Rua dos Atuns", "Parque Residencial Aquarius", "Oeste", "12246320");
		Endereco rua4947 = new Endereco(null, "Rua das Arraias", "Parque Residencial Aquarius", "Oeste", "12246330");
		Endereco rua4948 = new Endereco(null, "Alameda dos Platis", "Parque Residencial Aquarius", "Oeste", "12246340");
		Endereco rua4949 = new Endereco(null, "Alameda dos Neons", "Parque Residencial Aquarius", "Oeste", "12246350");
		Endereco rua4950 = new Endereco(null, "Alameda dos Betas", "Parque Residencial Aquarius", "Oeste", "12246360");
		Endereco rua4951 = new Endereco(null, "Alameda dos Kings", "Parque Residencial Aquarius", "Oeste", "12246370");
		Endereco rua4952 = new Endereco(null, "Avenida dos Tanictis", "Parque Residencial Aquarius", "Oeste",
				"12246380");
		Endereco rua4953 = new Endereco(null, "Praça dos Golfinhos", "Parque Residencial Aquarius", "Oeste",
				"12246400");
		Endereco rua4954 = new Endereco(null, "Rua Janus", "Parque Residencial Aquarius", "Oeste", "12246410");
		Endereco rua4955 = new Endereco(null, "Praça Pirapema", "Parque Residencial Aquarius", "Oeste", "12246420");
		Endereco rua4956 = new Endereco(null, "Avenida Deputado Benedito Matarazzo", "Parque Residencial Aquarius",
				"Oeste", "12246840");
		Endereco rua4957 = new Endereco(null, "Avenida Vinte e Nove", "Parque Residencial Aquarius", "Oeste",
				"12246851");
		Endereco rua4958 = new Endereco(null, "Avenida Onze", "Parque Residencial Aquarius", "Oeste", "12246852");
		Endereco rua4959 = new Endereco(null, "Avenida Vinte e Oito", "Parque Residencial Aquarius", "Oeste",
				"12246853");
		Endereco rua4960 = new Endereco(null, "Praça Luzia Aparecida Vilela", "Parque Residencial Aquarius", "Oeste",
				"12246854");
		Endereco rua4961 = new Endereco(null, "Avenida Cinco", "Parque Residencial Aquarius", "Oeste", "12246855");
		Endereco rua4962 = new Endereco(null, "Avenida Comendador de Vicente Paulo Penido",
				"Parque Residencial Aquarius", "Oeste", "12246856");
		Endereco rua4963 = new Endereco(null, "Avenida Cassiano Ricardo", "Parque Residencial Aquarius", "Oeste",
				"12246870");
		Endereco rua4964 = new Endereco(null, "Avenida Alfredo Ignácio Nogueira Penido", " 255",
				"Parque Residencial Aquarius", "Oeste");
		Endereco rua4965 = new Endereco(null, "Avenida Cassiano Ricardo", " 681", "Parque Residencial Aquarius",
				"Oeste");
		Endereco rua4966 = new Endereco(null, "Rua José Vicente de Paula", "Parque Santos Dumont", "Sudeste",
				"12227810");
		Endereco rua4967 = new Endereco(null, "Rua Engenheiro Ricardo Hausen", "Parque Santos Dumont", "Sudeste",
				"12227820");
		Endereco rua4968 = new Endereco(null, "Rua Durvalino Marciano Leite", "Parque Santos Dumont", "Sudeste",
				"12227830");
		Endereco rua4969 = new Endereco(null, "Rua João Mariano", "Parque Santos Dumont", "Sudeste", "12227840");
		Endereco rua4970 = new Endereco(null, "Rua Cícero Inácio da Silva", "Residencial Pinheirinho dos Palmares II",
				"Sul", "12228031");
		Endereco rua4971 = new Endereco(null, "Rua Dois", "Residencial Pinheirinho dos Palmares II", "Sul", "12228032");
		Endereco rua4972 = new Endereco(null, "Rua Três", "Residencial Pinheirinho dos Palmares II", "Sul", "12228033");
		Endereco rua4973 = new Endereco(null, "Rua Quatro", "Residencial Pinheirinho dos Palmares II", "Sul",
				"12228034");
		Endereco rua4974 = new Endereco(null, "Rua Cinco", "Residencial Pinheirinho dos Palmares II", "Sul",
				"12228035");
		Endereco rua4975 = new Endereco(null, "Rua Seis", "Residencial Pinheirinho dos Palmares II", "Sul", "12228036");
		Endereco rua4976 = new Endereco(null, "Rua Sete", "Residencial Pinheirinho dos Palmares II", "Sul", "12228037");
		Endereco rua4977 = new Endereco(null, "Rua Oito", "Residencial Pinheirinho dos Palmares II", "Sul", "12228038");
		Endereco rua4978 = new Endereco(null, "Rua Nove", "Residencial Pinheirinho dos Palmares II", "Sul", "12228039");
		Endereco rua4979 = new Endereco(null, "Rua Dez", "Residencial Pinheirinho dos Palmares II", "Sul", "12228041");
		Endereco rua4980 = new Endereco(null, "Rua Onze", "Residencial Pinheirinho dos Palmares II", "Sul", "12228042");
		Endereco rua4981 = new Endereco(null, "Rua Doze", "Residencial Pinheirinho dos Palmares II", "Sul", "12228043");
		Endereco rua4982 = new Endereco(null, "Rua Treze", "Residencial Pinheirinho dos Palmares II", "Sul",
				"12228044");
		Endereco rua4983 = new Endereco(null, "Rua Catorze", "Residencial Pinheirinho dos Palmares II", "Sul",
				"12228045");
		Endereco rua4984 = new Endereco(null, "Rua Quinze", "Residencial Pinheirinho dos Palmares II", "Sul",
				"12228046");
		Endereco rua4985 = new Endereco(null, "Rua Dezesseis", "Residencial Pinheirinho dos Palmares II", "Sul",
				"12228047");
		Endereco rua4986 = new Endereco(null, "Rua Dezessete", "Residencial Pinheirinho dos Palmares II", "Sul",
				"12228048");
		Endereco rua4987 = new Endereco(null, "Rua Dezoito", "Residencial Pinheirinho dos Palmares II", "Sul",
				"12228049");
		Endereco rua4988 = new Endereco(null, "Rua Dezenove", "Residencial Pinheirinho dos Palmares II", "Sul",
				"12228051");
		Endereco rua4989 = new Endereco(null, "Rua Vinte", "Residencial Pinheirinho dos Palmares II", "Sul",
				"12228052");
		Endereco rua4990 = new Endereco(null, "Rua Vinte e Um", "Residencial Pinheirinho dos Palmares II", "Sul",
				"12228053");
		Endereco rua4991 = new Endereco(null, "Rua Pérsio Lorenci da Assunção",
				"Residencial Pinheirinho dos Palmares II", "Sul", "12228054");
		Endereco rua4992 = new Endereco(null, "Rua Priscila Bertolino", "Residencial Pinheirinho dos Palmares II",
				"Sul", "12228055");
		Endereco rua4993 = new Endereco(null, "Rua Benedito Aparecido Ribeiro",
				"Residencial Pinheirinho dos Palmares II", "Sul", "12228056");
		Endereco rua4994 = new Endereco(null, "Rua Vinte e Cinco", "Residencial Pinheirinho dos Palmares II", "Sul",
				"12228057");
		Endereco rua4995 = new Endereco(null, "Rua Vinte e Seis", "Residencial Pinheirinho dos Palmares II", "Sul",
				"12228058");
		Endereco rua4996 = new Endereco(null, "Rua Vinte e Sete", "Residencial Pinheirinho dos Palmares II", "Sul",
				"12228059");
		Endereco rua4997 = new Endereco(null, "Rua Vinte e Oito", "Residencial Pinheirinho dos Palmares II", "Sul",
				"12228081");
		Endereco rua4998 = new Endereco(null, "Rua Vinte e Nove", "Residencial Pinheirinho dos Palmares II", "Sul",
				"12228082");
		Endereco rua4999 = new Endereco(null, "Rua Trinta", "Residencial Pinheirinho dos Palmares II", "Sul",
				"12228083");
		Endereco rua5000 = new Endereco(null, "Avenida João Maroun Boueri", "Residencial Pinheirinho dos Palmares II",
				"Sul", "12228084");
		Endereco rua5001 = new Endereco(null, "Avenida Dois", "Residencial Pinheirinho dos Palmares II", "Sul",
				"12228085");
		Endereco rua5002 = new Endereco(null, "Avenida Marcos Antônio de Araújo", "Portal do Céu", "Leste", "12226231");
		Endereco rua5003 = new Endereco(null, "Rua José Ivo Mendes", "Portal do Céu", "Leste", "12226232");
		Endereco rua5004 = new Endereco(null, "Rua Diego Yudi Omura", "Portal do Céu", "Leste", "12226233");
		Endereco rua5005 = new Endereco(null, "Rua Tereza Maria Lima dos Santos", "Portal do Céu", "Leste", "12226235");
		Endereco rua5006 = new Endereco(null, "Rua Doutor Luis Arturo Arevalo Crisóstomo", "Portal do Céu", "Leste",
				"12226237");
		Endereco rua5007 = new Endereco(null, "Rua José João Moreira", "Portal do Céu", "Leste", "12226239");
		Endereco rua5008 = new Endereco(null, "Rua Engenheiro Nelson Martins", "Portal do Céu", "Leste", "12226241");
		Endereco rua5009 = new Endereco(null, "Rua Heleodora Pereira Lemes", "Portal do Céu", "Leste", "12226243");
		Endereco rua5010 = new Endereco(null, "Estrada Dom José Antonio do Couto", "Chácaras Pousada do Vale", "Leste",
				"12226722");
		Endereco rua5011 = new Endereco(null, "Rua Josefa Maria da Silva", "Chácaras Pousada do Vale", "Leste",
				"12226730");
		Endereco rua5012 = new Endereco(null, "Rua Maria Júlia Dias Veneziani", "Chácaras Pousada do Vale", "Leste",
				"12226731");
		Endereco rua5013 = new Endereco(null, "Rua Joaquim Gonçalves", "Chácaras Pousada do Vale", "Leste", "12226732");
		Endereco rua5014 = new Endereco(null, "Rua Maurílio Calvo", "Chácaras Pousada do Vale", "Leste", "12226733");
		Endereco rua5015 = new Endereco(null, "Rua Jurubeba", "Chácaras Pousada do Vale", "Leste", "12226734");
		Endereco rua5016 = new Endereco(null, "Rua Manjerona", "Chácaras Pousada do Vale", "Leste", "12226735");
		Endereco rua5017 = new Endereco(null, "Rua Cerejeira", "Chácaras Pousada do Vale", "Leste", "12226740");
		Endereco rua5018 = new Endereco(null, "Rua Manjericão", "Chácaras Pousada do Vale", "Leste", "12226741");
		Endereco rua5019 = new Endereco(null, "Rua Mastruz", "Chácaras Pousada do Vale", "Leste", "12226742");
		Endereco rua5020 = new Endereco(null, "Rua Panacéia", "Chácaras Pousada do Vale", "Leste", "12226743");
		Endereco rua5021 = new Endereco(null, "Rua Poeijo", "Chácaras Pousada do Vale", "Leste", "12226744");
		Endereco rua5022 = new Endereco(null, "Rua Carqueijo", "Chácaras Pousada do Vale", "Leste", "12226745");
		Endereco rua5023 = new Endereco(null, "Rua Romã", "Chácaras Pousada do Vale", "Leste", "12226746");
		Endereco rua5024 = new Endereco(null, "Rua Sésamo", "Chácaras Pousada do Vale", "Leste", "12226747");
		Endereco rua5025 = new Endereco(null, "Rua Taioba", "Chácaras Pousada do Vale", "Leste", "12226750");
		Endereco rua5026 = new Endereco(null, "Rua Vinagreira", "Chácaras Pousada do Vale", "Leste", "12226751");
		Endereco rua5027 = new Endereco(null, "Rua Tasneira", "Chácaras Pousada do Vale", "Leste", "12226752");
		Endereco rua5028 = new Endereco(null, "Rua Sassafrás", "Chácaras Pousada do Vale", "Leste", "12226753");
		Endereco rua5029 = new Endereco(null, "Rua Quelidônia", "Chácaras Pousada do Vale", "Leste", "12226754");
		Endereco rua5030 = new Endereco(null, "Rua Leopoldo Fernandes Neves", "Chácaras Pousada do Vale", "Leste",
				"12226755");
		Endereco rua5031 = new Endereco(null, "Rua Absínio", "Chácaras Pousada do Vale", "Leste", "12226756");
		Endereco rua5032 = new Endereco(null, "Rua Arruda", "Chácaras Pousada do Vale", "Leste", "12226757");
		Endereco rua5033 = new Endereco(null, "Rua Algodoeiro", "Chácaras Pousada do Vale", "Leste", "12226760");
		Endereco rua5034 = new Endereco(null, "Rua Bálsamo", "Chácaras Pousada do Vale", "Leste", "12226761");
		Endereco rua5035 = new Endereco(null, "Rua Beijoeiro", "Chácaras Pousada do Vale", "Leste", "12226762");
		Endereco rua5036 = new Endereco(null, "Rua Camomila", "Chácaras Pousada do Vale", "Leste", "12226763");
		Endereco rua5037 = new Endereco(null, "Rua Coronel Antônio Lepiane", "Chácaras Pousada do Vale", "Leste",
				"12226764");
		Endereco rua5038 = new Endereco(null, "Rua Caetano Manzi Sobrinho", "Chácaras Pousada do Vale", "Leste",
				"12226765");
		Endereco rua5039 = new Endereco(null, "Rua Francisco Marcondes dos Santos", "Chácaras Pousada do Vale", "Leste",
				"12226766");
		Endereco rua5040 = new Endereco(null, "Rua Um", "Jardim Primavera II", "Leste", "12226260");
		Endereco rua5041 = new Endereco(null, "Rua Tres", "Jardim Primavera II", "Leste", "12226261");
		Endereco rua5042 = new Endereco(null, "Rua Quatro", "Jardim Primavera II", "Leste", "12226264");
		Endereco rua5043 = new Endereco(null, "Rua Cinco", "Jardim Primavera II", "Leste", "12226266");
		Endereco rua5044 = new Endereco(null, "Rua Dois", "Jardim Primavera II", "Leste", "12226270");
		Endereco rua5045 = new Endereco(null, "Rua Um", "Jardim Primavera II", "Leste", "12226260");
		Endereco rua5046 = new Endereco(null, "Rua Tres", "Jardim Primavera II", "Leste", "12226261");
		Endereco rua5047 = new Endereco(null, "Rua Quatro", "Jardim Primavera II", "Leste", "12226264");
		Endereco rua5048 = new Endereco(null, "Rua Cinco", "Jardim Primavera II", "Leste", "12226266");
		Endereco rua5049 = new Endereco(null, "Rua Dois", "Jardim Primavera II", "Leste", "12226270");
		Endereco rua5050 = new Endereco(null, "Rua Ribeirão do Putim", "Altos da Vila Paiva", "Sudeste", "12213110");
		Endereco rua5051 = new Endereco(null, "Avenida Brigadeiro Faria Lima", " 2170", "Putim", "Sudeste");
		Endereco rua5052 = new Endereco(null, "Avenida João Rodolfo Castelli", "Putim", "Sudeste", "12228000");
		Endereco rua5053 = new Endereco(null, "Trevo Coronel Aviador José Alberto Albano do Amarante", "Putim",
				"Sudeste", "12228001");
		Endereco rua5054 = new Endereco(null, "Estrada Municipal Glaudiston Pereira de Oliveira", "Putim", "Sudeste",
				"12228010");
		Endereco rua5055 = new Endereco(null, "Rua Doze", "Putim", "Sudeste", "12228258");
		Endereco rua5056 = new Endereco(null, "Estrada Municipal Ubirajara de Oliveira Pinto", "Putim", "Sudeste",
				"12228840");
		Endereco rua5057 = new Endereco(null, "Rua Ângelo Galo", "Recanto Caeté", "Norte", "12213220");
		Endereco rua5058 = new Endereco(null, "Rua João Teodoro de Souza", "Recanto Caeté", "Norte", "12213240");
		Endereco rua5059 = new Endereco(null, "Rua Primavera", "Recanto Caeté", "Norte", "12213250");
		Endereco rua5060 = new Endereco(null, "Rua Verão", "Recanto Caeté", "Norte", "12213260");
		Endereco rua5061 = new Endereco(null, "Rua Olivia Maria dos Santos", "Recanto dos Eucaliptos", "Sudeste",
				"12228061");
		Endereco rua5062 = new Endereco(null, "Rua Maria Conceição dos Santos", "Recanto dos Eucaliptos", "Sudeste",
				"12228063");
		Endereco rua5063 = new Endereco(null, "Avenida Doutor Renato Toledo de Mira", "Recanto dos Eucaliptos",
				"Sudeste", "12228065");
		Endereco rua5064 = new Endereco(null, "Rua Doutor Marco Antonio Sala", "Recanto dos Eucaliptos", "Sudeste",
				"12228067");
		Endereco rua5065 = new Endereco(null, "Rua Córrego da Ressaca", "Altos da Vila Paiva", "Leste", "12213068");
		Endereco rua5066 = new Endereco(null, "Rua Rio Comprido", "Altos da Vila Paiva", "Sul", "12213100");
		Endereco rua5067 = new Endereco(null, "Avenida Um", "Rio Comprido", "Sul", "12238531");
		Endereco rua5068 = new Endereco(null, "Rua Sete", "Rio Comprido", "Sul", "12238532");
		Endereco rua5069 = new Endereco(null, "Rua Quatro", "Rio Comprido", "Sul", "12238533");
		Endereco rua5070 = new Endereco(null, "Travessa da Rua Quatro", "Rio Comprido", "Sul", "12238534");
		Endereco rua5071 = new Endereco(null, "Rua 9", "Rio Comprido", "Sul", "12238535");
		Endereco rua5072 = new Endereco(null, "Viela da Rua 4", "Rio Comprido", "Sul", "12238536");
		Endereco rua5073 = new Endereco(null, "Rua Nova Esperança", "Rio Comprido", "Sul", "12238537");
		Endereco rua5074 = new Endereco(null, "Viela São Miguel", "Rio Comprido", "Sul", "12238538");
		Endereco rua5075 = new Endereco(null, "Travessa da Rua 2", "Rio Comprido", "Sul", "12238539");
		Endereco rua5076 = new Endereco(null, "Rua 5", "Rio Comprido", "Sul", "12238540");
		Endereco rua5077 = new Endereco(null, "Rua 3", "Rio Comprido", "Sul", "12238541");
		Endereco rua5078 = new Endereco(null, "Rua 1", "Rio Comprido", "Sul", "12238542");
		Endereco rua5079 = new Endereco(null, "Rua São Luiz", "Rio Comprido", "Sul", "12238543");
		Endereco rua5080 = new Endereco(null, "Rua Fortaleza", "Rio Comprido", "Sul", "12238544");
		Endereco rua5081 = new Endereco(null, "Rua 6", "Rio Comprido", "Sul", "12238545");
		Endereco rua5082 = new Endereco(null, "Avenida Doutor Sebastião Henrique da Cunha Pontes", "Rio Comprido",
				"Sul", "12238551");
		Endereco rua5083 = new Endereco(null, "Rua Benedita Simões de Almeida", "Condomínio Royal Park", "Oeste",
				"12246871");
		Endereco rua5084 = new Endereco(null, "Rua Doutor Izaias Andrade Sobrinho", "Condomínio Royal Park", "Oeste",
				"12246873");
		Endereco rua5085 = new Endereco(null, "Rua Jesus Garcia", "Condomínio Royal Park", "Oeste", "12246875");
		Endereco rua5086 = new Endereco(null, "Rua Carlos Maria Auricchio", "Condomínio Royal Park", "Oeste",
				"12246876");
		Endereco rua5087 = new Endereco(null, "Rua Yukiko Ishida", "Condomínio Royal Park", "Oeste", "12246877");
		Endereco rua5088 = new Endereco(null, "Via Local 5", "Condomínio Royal Park", "Oeste", "12246878");
		Endereco rua5089 = new Endereco(null, "Rua Professor Alcides Savastano Junior", "Jardim Santa Cecília I",
				"Leste", "12226651");
		Endereco rua5090 = new Endereco(null, "Estrada Dom José Antonio do Couto", "Jardim Santa Cecília I", "Leste",
				"12226652");
		Endereco rua5091 = new Endereco(null, "Rua Maria Goulart da Silva", "Jardim Santa Cecília I", "Leste",
				"12226653");
		Endereco rua5092 = new Endereco(null, "Estrada Dom José Antonio Couto", "Santa Cecília I", "Leste", "12226991");
		Endereco rua5093 = new Endereco(null, "Rua Tenente Manuel Pedro de Carvalho", "Vila Santa Helena", "Leste",
				"12209060");
		Endereco rua5094 = new Endereco(null, "Rua Flávio Berling Macedo", "Vila Santa Helena", "Leste", "12209080");
		Endereco rua5095 = new Endereco(null, "Rua Oito", "Santa Helena", "Leste", "12225868");
		Endereco rua5096 = new Endereco(null, "Rua Cláudia Pombo da Silva Carvalho de Melo", "Santa Helena", "Leste",
				"12225885");
		Endereco rua5097 = new Endereco(null, "Rua Isabel Ferreira Dell Aquila", "Santa Helena", "Leste", "12225886");
		Endereco rua5098 = new Endereco(null, "Rua Agenor Antonio de Morais", "Santa Helena", "Leste", "12225887");
		Endereco rua5099 = new Endereco(null, "Avenida Saulo Antunes de Carvalho", "Santa Helena", "Leste", "12225889");
		Endereco rua5100 = new Endereco(null, "Rua Dois", " nº 160 - Chácaras Santa Helena", "Leste", "12225991");
		Endereco rua5101 = new Endereco(null, "Rua N", "Jardim Santa Hermínia", "Leste", "12226801");
		Endereco rua5102 = new Endereco(null, "Rua Dez", "Jardim Santa Hermínia", "Leste", "12226802");
		Endereco rua5103 = new Endereco(null, "Rua Ágata", "Jardim Santa Hermínia", "Leste", "12226803");
		Endereco rua5104 = new Endereco(null, "Rua Carlota Batista Pereira", "Jardim Santa Hermínia", "Leste",
				"12226819");
		Endereco rua5105 = new Endereco(null, "Rua Dois", "Jardim Santa Hermínia", "Leste", "12226825");
		Endereco rua5106 = new Endereco(null, "Rua Hum", "Jardim Santa Hermínia", "Leste", "12226827");
		Endereco rua5107 = new Endereco(null, "Estrada Municipal Antônio Frederico Ozanam", "Jardim Santa Hermínia",
				"Leste", "12226830");
		Endereco rua5108 = new Endereco(null, "Rua F", "Jardim Santa Hermínia", "Leste", "12226831");
		Endereco rua5109 = new Endereco(null, "Rua L", "Jardim Santa Hermínia", "Leste", "12226832");
		Endereco rua5110 = new Endereco(null, "Rua Pedro Bertolino", "Jardim Santa Hermínia", "Leste", "12226833");
		Endereco rua5111 = new Endereco(null, "Rua M", "Jardim Santa Hermínia", "Leste", "12226834");
		Endereco rua5112 = new Endereco(null, "Rua G", "Jardim Santa Hermínia", "Leste", "12226835");
		Endereco rua5113 = new Endereco(null, "Rua José Frankilin de Sant'Ana", "Jardim Santa Hermínia", "Leste",
				"12226836");
		Endereco rua5114 = new Endereco(null, "Rua Francisco Cunha Laranjeira", "Jardim Santa Hermínia", "Leste",
				"12226837");
		Endereco rua5115 = new Endereco(null, "Rua Pedra do Sol", "Jardim Santa Hermínia", "Leste", "12226838");
		Endereco rua5116 = new Endereco(null, "Rua D", "Jardim Santa Hermínia", "Leste", "12226839");
		Endereco rua5117 = new Endereco(null, "Rua Pedra da Lua", "Jardim Santa Hermínia", "Leste", "12226840");
		Endereco rua5118 = new Endereco(null, "Rua Ônix", "Jardim Santa Hermínia", "Leste", "12226841");
		Endereco rua5119 = new Endereco(null, "Rua Espinela", "Jardim Santa Hermínia", "Leste", "12226842");
		Endereco rua5120 = new Endereco(null, "Rua Flávia Rosana dos Santos Rosa Cabral", "Jardim Santa Hermínia",
				"Leste", "12226843");
		Endereco rua5121 = new Endereco(null, "Estrada Roseli Aparecida de Almeida Ferreira", "Jardim Santa Hermínia",
				"Leste", "12226844");
		Endereco rua5122 = new Endereco(null, "Rua Engenheiro Flávio Marcondes", "Jardim Santa Maria II", "Leste",
				"12225161");
		Endereco rua5123 = new Endereco(null, "Rua José Donizetti dos Santos", "Jardim Santa Maria IV", "Leste",
				"12225271");
		Endereco rua5124 = new Endereco(null, "Rua Celso Gomes Negrão", "Jardim Santa Maria III", "Leste", "12225374");
		Endereco rua5125 = new Endereco(null, "Rua Engenheiro Flávio Marcondes", "Jardim Santa Maria III", "Leste",
				"12225375");
		Endereco rua5126 = new Endereco(null, "Rua Antonio Fernando Batista", "Jardim Santa Maria III", "Leste",
				"12225394");
		Endereco rua5127 = new Endereco(null, "Rua Santa Rita", "Jardim Santarém", "Leste", "12212540");
		Endereco rua5128 = new Endereco(null, "Avenida Ana Fortunato Rodrigues", "Santa Rita", "Leste", "12226251");
		Endereco rua5129 = new Endereco(null, "Rua José Augusto Lemes", "Santa Rita", "Leste", "12226253");
		Endereco rua5130 = new Endereco(null, "Rua Mirtes Spadari Corsi", "Santa Rita", "Leste", "12226255");
		Endereco rua5131 = new Endereco(null, "Rua Santa Rita de Cássia", "Jardim São Judas Tadeu", "Leste",
				"12228408");
		Endereco rua5132 = new Endereco(null, "Rua Belchior Dias Moréia", "Vila Santa Rita", "Leste", "12242282");
		Endereco rua5133 = new Endereco(null, "Rua Marcos de Azeredo", "Vila Santa Rita", "Leste", "12242283");
		Endereco rua5134 = new Endereco(null, "Rua Doutor Francisco de Souza", "Vila Santa Rita", "Leste", "12242290");
		Endereco rua5135 = new Endereco(null, "Rua Luiz Martins", "Vila Santa Rita", "Leste", "12242320");
		Endereco rua5136 = new Endereco(null, "Rua Afonso José de Santana", "Vila Rossi", "Norte", "12211040");
		Endereco rua5137 = new Endereco(null, "Avenida Olivo Gomes", "Santana", "Norte", "12211115");
		Endereco rua5138 = new Endereco(null, "Travessa Deolinda Soares", "Santana", "Norte", "12211170");
		Endereco rua5139 = new Endereco(null, "Rua Pedro Rachid", "Santana", "Norte", "12211180");
		Endereco rua5140 = new Endereco(null, "Travessa Quirino Custódio da Silva", "Santana", "Norte", "12211181");
		Endereco rua5141 = new Endereco(null, "Praça Antônio Prado", "Santana", "Norte", "12211210");
		Endereco rua5142 = new Endereco(null, "Praça Santa Cruz", "Santana", "Norte", "12211220");
		Endereco rua5143 = new Endereco(null, "Rua Franz de Castro Holzwarth", "Santana", "Norte", "12211230");
		Endereco rua5144 = new Endereco(null, "Rua Manoel Lemes Palmeira", "Santana", "Norte", "12211241");
		Endereco rua5145 = new Endereco(null, "Rua Benedito de Paula", "Santana", "Norte", "12211242");
		Endereco rua5146 = new Endereco(null, "Travessa Antônio de Souza Neves", "Santana", "Norte", "12211243");
		Endereco rua5147 = new Endereco(null, "Rua Mário de Araújo Cesar", "Santana", "Norte", "12211250");
		Endereco rua5148 = new Endereco(null, "Rua Benedito Alves da Silva", "Santana", "Norte", "12211260");
		Endereco rua5149 = new Endereco(null, "Rua Frei Henrique de Coimbra", "Santana", "Norte", "12211280");
		Endereco rua5150 = new Endereco(null, "Travessa Francisco Rodrigues Freire", "Santana", "Norte", "12211291");
		Endereco rua5151 = new Endereco(null, "Rua Tupinambás", "Santana", "Norte", "12211300");
		Endereco rua5152 = new Endereco(null, "Rua Alexandrino José de Souza", "Santana", "Norte", "12211310");
		Endereco rua5153 = new Endereco(null, "Rua Julio César Filho", "Santana", "Norte", "12211320");
		Endereco rua5154 = new Endereco(null, "Rua João José do Nascimento", "Santana", "Norte", "12211330");
		Endereco rua5155 = new Endereco(null, "Rua Augusto Ferreira Vinhas", "Santana", "Norte", "12211340");
		Endereco rua5156 = new Endereco(null, "Rua Frediano Bianchi", "Santana", "Norte", "12211350");
		Endereco rua5157 = new Endereco(null, "Avenida Princesa Isabel", "Santana", "Norte", "12211620");
		Endereco rua5158 = new Endereco(null, "Rua da Grama", "Santana", "Norte", "12211622");
		Endereco rua5159 = new Endereco(null, "Praça Luís de Andrade Rodrigues", "Santana", "Norte", "12211623");
		Endereco rua5160 = new Endereco(null, "Rua Manoel Rodrigues de Moraes", "Santana", "Norte", "12211640");
		Endereco rua5161 = new Endereco(null, "Praça Anchieta", "Santana", "Norte", "12211650");
		Endereco rua5162 = new Endereco(null, "Rua Coronel Afro Marcondes", "Santana", "Norte", "12211660");
		Endereco rua5163 = new Endereco(null, "Rua Mário Pulga", "Santana", "Norte", "12211670");
		Endereco rua5164 = new Endereco(null, "Rua José da Costa Pinheiro", "Santana", "Norte", "12211680");
		Endereco rua5165 = new Endereco(null, "Rua Avaristo Borges", "Santana", "Norte", "12211690");
		Endereco rua5166 = new Endereco(null, "Rua Peri", "Santana", "Norte", "12211691");
		Endereco rua5167 = new Endereco(null, "Rua José do Patrocínio", "Santana", "Norte", "12211700");
		Endereco rua5168 = new Endereco(null, "Rua Guaianazes", "Santana", "Norte", "12211710");
		Endereco rua5169 = new Endereco(null, "Rua Manoel Prianti", "Santana", "Norte", "12211720");
		Endereco rua5170 = new Endereco(null, "Praça Santana", "Santana", "Norte", "12211730");
		Endereco rua5171 = new Endereco(null, "Rua Guarani", "Santana", "Norte", "12211740");
		Endereco rua5172 = new Endereco(null, "Rua Jaci", "Santana", "Norte", "12211750");
		Endereco rua5173 = new Endereco(null, "Rua Raul Ramos de Araújo", "Santana", "Norte", "12211760");
		Endereco rua5174 = new Endereco(null, "Rua Vaz Caminha", "Santana", "Norte", "12211770");
		Endereco rua5175 = new Endereco(null, "Rua Francisco José da Costa", "Santana", "Norte", "12211780");
		Endereco rua5176 = new Endereco(null, "Praça Bandeirantes", "Santana", "Norte", "12211790");
		Endereco rua5177 = new Endereco(null, "Rua Capitão Elisiário", "Santana", "Norte", "12211800");
		Endereco rua5178 = new Endereco(null, "Rua Manoel Ramos Machado", "Santana", "Norte", "12211810");
		Endereco rua5179 = new Endereco(null, "Rua Maria Pinotti Bicudo", "Santana", "Norte", "12211820");
		Endereco rua5180 = new Endereco(null, "Praça Monsenhor Luiz Gonzaga Alves Cavalheiro", "Santana", "Norte",
				"12211830");
		Endereco rua5181 = new Endereco(null, "Rua Antônio Vieira de Souza", "Santana", "Norte", "12211840");
		Endereco rua5182 = new Endereco(null, "Rua Maria Luiza Espírito Santo", "Santana", "Norte", "12211841");
		Endereco rua5183 = new Endereco(null, "Ponte Minas Gerais", "Santana", "Norte", "12211842");
		Endereco rua5184 = new Endereco(null, "Travessa Bom Sucesso", "Santana", "Norte", "12211843");
		Endereco rua5185 = new Endereco(null, "Avenida Rui Barbosa", "Santana", "Norte", "12212000");
		Endereco rua5186 = new Endereco(null, "Travessa Atílio Roberti", "Santana", "Norte", "12212001");
		Endereco rua5187 = new Endereco(null, "Travessa Rodolfo Ferrianci", "Santana", "Norte", "12212002");
		Endereco rua5188 = new Endereco(null, "Rua Nhumirim", "Santana", "Norte", "12212010");
		Endereco rua5189 = new Endereco(null, "Rua Licínio Leite Machado", "Santana", "Norte", "12212020");
		Endereco rua5190 = new Endereco(null, "Rua Antônio da Costa Pinheiro", "Santana", "Norte", "12212030");
		Endereco rua5191 = new Endereco(null, "Rua Aristoteles Cirilo", "Santana", "Norte", "12212031");
		Endereco rua5192 = new Endereco(null, "Rua Professor Jacir Madureira", "Santana", "Norte", "12212040");
		Endereco rua5193 = new Endereco(null, "Rua Carlos Belmiro dos Santos", "Santana", "Norte", "12212050");
		Endereco rua5194 = new Endereco(null, "Rua São Jorge", "Santana", "Norte", "12212060");
		Endereco rua5195 = new Endereco(null, "Travessa José Fernandes Queiroz", "Santana", "Norte", "12212070");
		Endereco rua5196 = new Endereco(null, "Rua José Dias de Aguiar", "Santana", "Norte", "12212080");
		Endereco rua5197 = new Endereco(null, "Travessa Pedro Rachid", "Santana", "Norte", "12212090");
		Endereco rua5198 = new Endereco(null, "Rua Pedro Rachid", "Santana", "Norte", "12212100");
		Endereco rua5199 = new Endereco(null, "Rua Paraguassu", "Santana", "Norte", "12212110");
		Endereco rua5200 = new Endereco(null, "Rua Presidente Prudente de Morais", "Santana", "Norte", "12212120");
		Endereco rua5201 = new Endereco(null, "Rua Presidente Nilo Peçanha", "Santana", "Norte", "12212130");
		Endereco rua5202 = new Endereco(null, "Rua Presidente Campos Salles", "Santana", "Norte", "12212140");
		Endereco rua5203 = new Endereco(null, "Rua Presidente Washington Luís", "Santana", "Norte", "12212150");
		Endereco rua5204 = new Endereco(null, "Praça Armando Sales de Oliveira", "Santana", "Norte", "12212160");
		Endereco rua5205 = new Endereco(null, "Rua Presidente Júlio Prestes", "Santana", "Norte", "12212170");
		Endereco rua5206 = new Endereco(null, "Rua da Consolação", "Santana", "Norte", "12212180");
		Endereco rua5207 = new Endereco(null, "Rua São Luiz Gonzaga", "Santana", "Norte", "12212200");
		Endereco rua5208 = new Endereco(null, "Rua Sebastião Benedito Dias", "Santana", "Norte", "12212210");
		Endereco rua5209 = new Endereco(null, "Vila Pena", "Santana", "Norte", "12212220");
		Endereco rua5210 = new Endereco(null, "Passarela Manoel Ramos Machado", "Santana", "Norte", "12212230");
		Endereco rua5211 = new Endereco(null, "Rua India Paraguassu", "Santana", "Norte", "12212240");
		Endereco rua5212 = new Endereco(null, "Rua Roberto de Paula Ferreira", "Santana", "Norte", "12212250");
		Endereco rua5213 = new Endereco(null, "Rua Nossa Senhora Auxiliadora", "Santana", "Norte", "12212260");
		Endereco rua5214 = new Endereco(null, "Rua Santa Terezinha", "Santana", "Norte", "12212270");
		Endereco rua5215 = new Endereco(null, "Travessa Porto Grande", "Santana", "Norte", "12212280");
		Endereco rua5216 = new Endereco(null, "Praça Pedro Ribeiro Godoy", "Santana", "Norte", "12212281");
		Endereco rua5217 = new Endereco(null, "Rua Aristeu Rodrigues de Santana", "Santana", "Norte", "12212290");
		Endereco rua5218 = new Endereco(null, "Avenida Rui Barbosa", " 2376", "Santana", "Norte");
		Endereco rua5219 = new Endereco(null, "Avenida Pico das Agulhas Negras", "Jardim Altos de Santana", "Norte",
				"12214000");
		Endereco rua5220 = new Endereco(null, "Rua Horto Florestal", "Jardim Altos de Santana", "Norte", "12214001");
		Endereco rua5221 = new Endereco(null, "Avenida Alto do Rio Doce", "Jardim Altos de Santana", "Norte",
				"12214010");
		Endereco rua5222 = new Endereco(null, "Rua Pico Cruzeiro", "Jardim Altos de Santana", "Norte", "12214020");
		Endereco rua5223 = new Endereco(null, "Rua Pico do Pulpito", "Jardim Altos de Santana", "Norte", "12214030");
		Endereco rua5224 = new Endereco(null, "Rua Pico Juliana", "Jardim Altos de Santana", "Norte", "12214040");
		Endereco rua5225 = new Endereco(null, "Rua Pico do Selado", "Jardim Altos de Santana", "Norte", "12214050");
		Endereco rua5226 = new Endereco(null, "Rua Serra da Ibitipoca", "Jardim Altos de Santana", "Norte", "12214060");
		Endereco rua5227 = new Endereco(null, "Rua Pedra Vermelha", "Jardim Altos de Santana", "Norte", "12214070");
		Endereco rua5228 = new Endereco(null, "Rua Pedra Redonda", "Jardim Altos de Santana", "Norte", "12214080");
		Endereco rua5229 = new Endereco(null, "Rua Monte Paschoal", "Jardim Altos de Santana", "Norte", "12214090");
		Endereco rua5230 = new Endereco(null, "Rua Monte das Oliveiras", "Jardim Altos de Santana", "Norte",
				"12214100");
		Endereco rua5231 = new Endereco(null, "Rua Monte Castelo", "Jardim Altos de Santana", "Norte", "12214110");
		Endereco rua5232 = new Endereco(null, "Rua Serra das Araras", "Jardim Altos de Santana", "Norte", "12214120");
		Endereco rua5233 = new Endereco(null, "Rua Serra Dourada", "Jardim Altos de Santana", "Norte", "12214130");
		Endereco rua5234 = new Endereco(null, "Rua Pico do Jaraguá", "Jardim Altos de Santana", "Norte", "12214140");
		Endereco rua5235 = new Endereco(null, "Rua Alto da Boa Vista", "Jardim Altos de Santana", "Norte", "12214150");
		Endereco rua5236 = new Endereco(null, "Rua Pico Marins", "Jardim Altos de Santana", "Norte", "12214160");
		Endereco rua5237 = new Endereco(null, "Rua Montanha Fuji", "Jardim Altos de Santana", "Norte", "12214170");
		Endereco rua5238 = new Endereco(null, "Rua Monte Sinai", "Jardim Altos de Santana", "Norte", "12214180");
		Endereco rua5239 = new Endereco(null, "Rua Pico dos Três Estados", "Jardim Altos de Santana", "Norte",
				"12214190");
		Endereco rua5240 = new Endereco(null, "Rua Pico do Bugil", "Jardim Altos de Santana", "Norte", "12214200");
		Endereco rua5241 = new Endereco(null, "Rua Pedra do Sino", "Jardim Altos de Santana", "Norte", "12214210");
		Endereco rua5242 = new Endereco(null, "Rua Serra de Santa Bárbara", "Jardim Altos de Santana", "Norte",
				"12214220");
		Endereco rua5243 = new Endereco(null, "Rua Monte Roraima", "Jardim Altos de Santana", "Norte", "12214230");
		Endereco rua5244 = new Endereco(null, "Rua Pico Cristal", "Jardim Altos de Santana", "Norte", "12214240");
		Endereco rua5245 = new Endereco(null, "Rua Pico da Neblina", "Jardim Altos de Santana", "Norte", "12214250");
		Endereco rua5246 = new Endereco(null, "Rua Pedra do Capim Azul", "Jardim Altos de Santana", "Norte",
				"12214260");
		Endereco rua5247 = new Endereco(null, "Rua Pico do Aconcagua", "Jardim Altos de Santana", "Norte", "12214270");
		Endereco rua5248 = new Endereco(null, "Rua Pedra Pouso do Rochedo", "Jardim Altos de Santana", "Norte",
				"12214280");
		Endereco rua5249 = new Endereco(null, "Rua Pico da Bandeira", "Jardim Altos de Santana", "Norte", "12214290");
		Endereco rua5250 = new Endereco(null, "Rua Serra da Canastra", "Jardim Altos de Santana", "Norte", "12214300");
		Endereco rua5251 = new Endereco(null, "Rua Vinte e Nove", "Jardim Altos de Santana", "Norte", "12214310");
		Endereco rua5252 = new Endereco(null, "Rua Serra de Jambeiro", "Jardim Altos de Santana", "Norte", "12214320");
		Endereco rua5253 = new Endereco(null, "Rua Alto do Araguaia", "Jardim Altos de Santana", "Norte", "12214330");
		Endereco rua5254 = new Endereco(null, "Rua Pico Itapevi", "Jardim Altos de Santana", "Norte", "12214340");
		Endereco rua5255 = new Endereco(null, "Rua Serra do Japi", "Jardim Altos de Santana", "Norte", "12214350");
		Endereco rua5256 = new Endereco(null, "Rua Monte Kilimanjaro", "Jardim Altos de Santana", "Norte", "12214370");
		Endereco rua5257 = new Endereco(null, "Rua Pedra do Baú", "Jardim Altos de Santana", "Norte", "12214380");
		Endereco rua5258 = new Endereco(null, "Rua Serra dos Carajás", "Jardim Altos de Santana", "Norte", "12214390");
		Endereco rua5259 = new Endereco(null, "Rua Pedra Alta", "Jardim Altos de Santana", "Norte", "12214391");
		Endereco rua5260 = new Endereco(null, "Rua Serra dos Aimorés", "Jardim Altos de Santana", "Norte", "12214400");
		Endereco rua5261 = new Endereco(null, "Rua Serra da Saudade", "Jardim Altos de Santana", "Norte", "12214410");
		Endereco rua5262 = new Endereco(null, "Rua Jaguari", " s/n", "Jardim Altos de Santana", "Norte");
		Endereco rua5263 = new Endereco(null, "Rua Esmeraldo Baptista Santana", "Jardim São Vicente", "Norte",
				"12224430");
		Endereco rua5264 = new Endereco(null, "Rua Maria Montezi Santana", "Jardim Castanheira", "Norte", "12225320");
		Endereco rua5265 = new Endereco(null, "Rua Hilário Santana", "Parque Residencial Flamboyant", "Norte",
				"12227796");
		Endereco rua5266 = new Endereco(null, "Rua Patrício Santana", "Jardim Satélite", "Norte", "12230080");
		Endereco rua5267 = new Endereco(null, "Rua José Santana Mariano", "Jardim Nova República", "Norte", "12234892");
		Endereco rua5268 = new Endereco(null, "Avenida Feira de Santana", "Jardim Vale do Sol", "Norte", "12238000");
		Endereco rua5269 = new Endereco(null, "Rua Ismael Lemes Santana", "Urbanova V", "Norte", "12244871");
		Endereco rua5270 = new Endereco(null, "Rua São Francisco Xavier", "Vila Rangel", "Norte", "12211440");
		Endereco rua5271 = new Endereco(null, "Rua São Sebastião", "Jardim Santarém", "Norte", "12212550");
		Endereco rua5272 = new Endereco(null, "Rua Um", "Chácara São Sebastião", "Norte", "12221291");
		Endereco rua5273 = new Endereco(null, "Estrada Municipal Francisco de Morais", "Serrote", "Leste", "12226723");
		Endereco rua5274 = new Endereco(null, "Rua Sitio Bom Jesus", "Jardim Uirá", "Sudeste", "12227610");
		Endereco rua5275 = new Endereco(null, "Via de Acesso Dezesseis", "Condomínio Residencial Terra Nova", "Leste",
				"12247761");
		Endereco rua5276 = new Endereco(null, "Via de Acesso Dezessete", "Condomínio Residencial Terra Nova", "Leste",
				"12247762");
		Endereco rua5277 = new Endereco(null, "Alameda Um", "Condomínio Residencial Terra Nova", "Leste", "12247763");
		Endereco rua5278 = new Endereco(null, "Via de Acesso Um", "Condomínio Residencial Terra Nova", "Leste",
				"12247771");
		Endereco rua5279 = new Endereco(null, "Via de Acesso Dois", "Condomínio Residencial Terra Nova", "Leste",
				"12247773");
		Endereco rua5280 = new Endereco(null, "Via de Acesso Três", "Condomínio Residencial Terra Nova", "Leste",
				"12247775");
		Endereco rua5281 = new Endereco(null, "Via de Acesso Quatro", "Condomínio Residencial Terra Nova", "Leste",
				"12247776");
		Endereco rua5282 = new Endereco(null, "Via de Acesso Cinco", "Condomínio Residencial Terra Nova", "Leste",
				"12247777");
		Endereco rua5283 = new Endereco(null, "Via de Acesso Seis", "Condomínio Residencial Terra Nova", "Leste",
				"12247778");
		Endereco rua5284 = new Endereco(null, "Via de Acesso Sete", "Condomínio Residencial Terra Nova", "Leste",
				"12247779");
		Endereco rua5285 = new Endereco(null, "Via de Acesso Oito", "Condomínio Residencial Terra Nova", "Leste",
				"12247782");
		Endereco rua5286 = new Endereco(null, "Via de Acesso Nove", "Condomínio Residencial Terra Nova", "Leste",
				"12247783");
		Endereco rua5287 = new Endereco(null, "Via de Acesso Dez", "Condomínio Residencial Terra Nova", "Leste",
				"12247784");
		Endereco rua5288 = new Endereco(null, "Via de Acesso Onze", "Condomínio Residencial Terra Nova", "Leste",
				"12247785");
		Endereco rua5289 = new Endereco(null, "Via de Acesso Doze", "Condomínio Residencial Terra Nova", "Leste",
				"12247786");
		Endereco rua5290 = new Endereco(null, "Via de Acesso Treze", "Condomínio Residencial Terra Nova", "Leste",
				"12247787");
		Endereco rua5291 = new Endereco(null, "Via de Acesso Quatorze", "Condomínio Residencial Terra Nova", "Leste",
				"12247788");
		Endereco rua5292 = new Endereco(null, "Via de Acesso Quinze", "Condomínio Residencial Terra Nova", "Leste",
				"12247789");
		Endereco rua5293 = new Endereco(null, "Avenida Nicanor Reis", "Jardim Torrão de Ouro", "Sul", "12229000");
		Endereco rua5294 = new Endereco(null, "Rua Ubirajara Raimundo de Souza", "Jardim Torrão de Ouro", "Sul",
				"12229001");
		Endereco rua5295 = new Endereco(null, "Viela Benedita da Silva Dantas", "Jardim Torrão de Ouro", "Sul",
				"12229002");
		Endereco rua5296 = new Endereco(null, "Rua Ana Elisabete Martinelli Godinho", "Jardim Torrão de Ouro", "Sul",
				"12229003");
		Endereco rua5297 = new Endereco(null, "Travessa Quatro", "Jardim Torrão de Ouro", "Sul", "12229005");
		Endereco rua5298 = new Endereco(null, "Travessa Um", "Jardim Torrão de Ouro", "Sul", "12229006");
		Endereco rua5299 = new Endereco(null, "Travessa Dois", "Jardim Torrão de Ouro", "Sul", "12229007");
		Endereco rua5300 = new Endereco(null, "Praça Gunther Zolko", "Jardim Torrão de Ouro", "Sul", "12229008");
		Endereco rua5301 = new Endereco(null, "Travessa Três", "Jardim Torrão de Ouro", "Sul", "12229009");
		Endereco rua5302 = new Endereco(null, "Rua Waldemar Teixeira", "Jardim Torrão de Ouro", "Sul", "12229010");
		Endereco rua5303 = new Endereco(null, "Rua Rogério Monteiro", "Jardim Torrão de Ouro", "Sul", "12229020");
		Endereco rua5304 = new Endereco(null, "Rua José Lopes de Oliveira Filho", "Jardim Torrão de Ouro", "Sul",
				"12229030");
		Endereco rua5305 = new Endereco(null, "Rua Honório Pereira da Silva", "Jardim Torrão de Ouro", "Sul",
				"12229040");
		Endereco rua5306 = new Endereco(null, "Rua Benedito Machado de Arantes", "Jardim Torrão de Ouro", "Sul",
				"12229050");
		Endereco rua5307 = new Endereco(null, "Rua Fernando Sacilotti", "Jardim Torrão de Ouro", "Sul", "12229060");
		Endereco rua5308 = new Endereco(null, "Rua Roberto Rossi", "Jardim Torrão de Ouro", "Sul", "12229070");
		Endereco rua5309 = new Endereco(null, "Rua Professor João Luiz Galvão Ribeiro", "Jardim Torrão de Ouro", "Sul",
				"12229080");
		Endereco rua5310 = new Endereco(null, "Rua Agenor de Oliveira", "Jardim Torrão de Ouro", "Sul", "12229090");
		Endereco rua5311 = new Endereco(null, "Rua Trindade Monteiro de Oliveira", "Jardim Torrão de Ouro", "Sul",
				"12229100");
		Endereco rua5312 = new Endereco(null, "Rua Vicente Pavanelli", "Jardim Torrão de Ouro", "Sul", "12229110");
		Endereco rua5313 = new Endereco(null, "Rua Wlamir Rogério Friggi", "Jardim Torrão de Ouro", "Sul", "12229120");
		Endereco rua5314 = new Endereco(null, "Rua Antônio Boarini", "Jardim Torrão de Ouro", "Sul", "12229130");
		Endereco rua5315 = new Endereco(null, "Rua Olavo Augusto Andrade", "Jardim Torrão de Ouro", "Sul", "12229135");
		Endereco rua5316 = new Endereco(null, "Rua Roberto Verdussen", "Jardim Torrão de Ouro", "Sul", "12229140");
		Endereco rua5317 = new Endereco(null, "Rua Oscar Florentino", "Jardim Torrão de Ouro", "Sul", "12229150");
		Endereco rua5318 = new Endereco(null, "Rua Cid Morel", "Jardim Torrão de Ouro", "Sul", "12229155");
		Endereco rua5319 = new Endereco(null, "Rua Mikolaj Torba", "Jardim Torrão de Ouro", "Sul", "12229160");
		Endereco rua5320 = new Endereco(null, "Praça Luiz Carlos Martins", "Jardim Torrão de Ouro", "Sul", "12229165");
		Endereco rua5321 = new Endereco(null, "Rua José Honório Ribeiro", "Jardim Torrão de Ouro", "Sul", "12229170");
		Endereco rua5322 = new Endereco(null, "Rua Tereza de Jesus Silva", "Jardim Torrão de Ouro", "Sul", "12229180");
		Endereco rua5323 = new Endereco(null, "Rua Professora Joana de Camargo Fonseca", "Jardim Torrão de Ouro", "Sul",
				"12229190");
		Endereco rua5324 = new Endereco(null, "Rua Ruy Jacques de Moraes", "Jardim Torrão de Ouro", "Sul", "12229200");
		Endereco rua5325 = new Endereco(null, "Rua Danilo Monteiro", "Jardim Torrão de Ouro", "Sul", "12229210");
		Endereco rua5326 = new Endereco(null, "Rua Pedro Gonçalves Reis", "Jardim Torrão de Ouro", "Sul", "12229220");
		Endereco rua5327 = new Endereco(null, "Rua José Cândido de Oliveira", "Jardim Torrão de Ouro", "Sul",
				"12229221");
		Endereco rua5328 = new Endereco(null, "Rua Renato Costa Rodrigues", "Jardim Torrão de Ouro", "Sul", "12229230");
		Endereco rua5329 = new Endereco(null, "Rua Doutor Raphael Faro Netto", "Jardim Torrão de Ouro", "Sul",
				"12229240");
		Endereco rua5330 = new Endereco(null, "Rua José Roberto Joaquim", "Jardim Torrão de Ouro", "Sul", "12229250");
		Endereco rua5331 = new Endereco(null, "Rua Vicente Cardoso", "Jardim Torrão de Ouro", "Sul", "12229260");
		Endereco rua5332 = new Endereco(null, "Rua Manoel de Souza Peixoto", "Jardim Torrão de Ouro", "Sul",
				"12229270");
		Endereco rua5333 = new Endereco(null, "Rua Annibal Lopes Simões", "Jardim Torrão de Ouro", "Sul", "12229280");
		Endereco rua5334 = new Endereco(null, "Rua Doutor José Ferreira Guimarães", "Jardim Torrão de Ouro", "Sul",
				"12229290");
		Endereco rua5335 = new Endereco(null, "Rua Getúlio Vargas de Araújo", "Jardim Torrão de Ouro", "Sul",
				"12229291");
		Endereco rua5336 = new Endereco(null, "Rua Dinamérico Trombeta", "Jardim Torrão de Ouro", "Sul", "12229310");
		Endereco rua5337 = new Endereco(null, "Travessa dos Coqueiros", "Jardim Torrão de Ouro", "Sul", "12229316");
		Endereco rua5338 = new Endereco(null, "Rua dos Pinheiros", "Jardim Torrão de Ouro", "Sul", "12229318");
		Endereco rua5339 = new Endereco(null, "Rua Engenheiro José Ricardo Daniel", "Jardim Torrão de Ouro", "Sul",
				"12229320");
		Endereco rua5340 = new Endereco(null, "Rua Luiz Roberto Rodrigues", "Jardim Torrão de Ouro", "Sul", "12229330");
		Endereco rua5341 = new Endereco(null, "Rua Domilheta de Morais", "Jardim Torrão de Ouro", "Sul", "12229340");
		Endereco rua5342 = new Endereco(null, "Rua Elizabeth Avelino Muniz", "Jardim Torrão de Ouro", "Sul",
				"12229350");
		Endereco rua5343 = new Endereco(null, "Rua Antenor Paglione", "Jardim Torrão de Ouro", "Sul", "12229360");
		Endereco rua5344 = new Endereco(null, "Rua Alexandre Teodoro Eras", "Jardim Torrão de Ouro", "Sul", "12229370");
		Endereco rua5345 = new Endereco(null, "Estrada Doutor Bezerra de Menezes", "Jardim Torrão de Ouro", "Sul",
				"12229380");
		Endereco rua5346 = new Endereco(null, "Rua João Miacci", "Jardim Torrão de Ouro", "Sul", "12229391");
		Endereco rua5347 = new Endereco(null, "Rua Aurora de Paula Ribeiro", "Jardim Torrão de Ouro", "Sul",
				"12229813");
		Endereco rua5348 = new Endereco(null, "Rua Benedito Procópio dos Santos", "Jardim Torrão de Ouro", "Sul",
				"12229816");
		Endereco rua5349 = new Endereco(null, "Rua Dias Gomes", "Jardim Torrão de Ouro", "Sul", "12229821");
		Endereco rua5350 = new Endereco(null, "Rua José Nunes de Figueiredo", "Jardim Torrão de Ouro", "Sul",
				"12229830");
		Endereco rua5351 = new Endereco(null, "Rua Elza Silva de Figueiredo", "Jardim Torrão de Ouro", "Sul",
				"12229831");
		Endereco rua5352 = new Endereco(null, "Rua Maria Helena da Silva", "Jardim Torrão de Ouro", "Sul", "12229833");
		Endereco rua5353 = new Endereco(null, "Rua Luiz Veneziani", "Jardim Torrão de Ouro", "Sul", "12229834");
		Endereco rua5354 = new Endereco(null, "Rua Corina Pedrosa Púpio", "Jardim Torrão de Ouro", "Sul", "12229835");
		Endereco rua5355 = new Endereco(null, "Avenida José Augusto Teixeira", "Torrão de Ouro II", "Sul", "12229840");
		Endereco rua5356 = new Endereco(null, "Rua Quatorze", "Torrão de Ouro II", "Sul", "12229841");
		Endereco rua5357 = new Endereco(null, "Rua Quinze", "Torrão de Ouro II", "Sul", "12229842");
		Endereco rua5358 = new Endereco(null, "Rua Dezesseis", "Torrão de Ouro II", "Sul", "12229843");
		Endereco rua5359 = new Endereco(null, "Condomínio Residencial Altos da Quinta", "Torrão de Ouro II", "Sul",
				"12229844");
		Endereco rua5360 = new Endereco(null, "Rodovia Governador Carvalho Pinto", "Torrão de Ouro II", "Sul",
				"12229849");
		Endereco rua5361 = new Endereco(null, "Avenida José Augusto Teixeira", "Torrão de Ouro II", "Sul", "12229840");
		Endereco rua5362 = new Endereco(null, "Rua Quatorze", "Torrão de Ouro II", "Sul", "12229841");
		Endereco rua5363 = new Endereco(null, "Rua Quinze", "Torrão de Ouro II", "Sul", "12229842");
		Endereco rua5364 = new Endereco(null, "Rua Dezesseis", "Torrão de Ouro II", "Sul", "12229843");
		Endereco rua5365 = new Endereco(null, "Condomínio Residencial Altos da Quinta", "Torrão de Ouro II", "Sul",
				"12229844");
		Endereco rua5366 = new Endereco(null, "Rodovia Governador Carvalho Pinto", "Torrão de Ouro II", "Sul",
				"12229849");
		Endereco rua5367 = new Endereco(null, "Avenida José Augusto Teixeira", "Torrão de Ouro II", "Sul", "12229840");
		Endereco rua5368 = new Endereco(null, "Rua Quatorze", "Torrão de Ouro II", "Sul", "12229841");
		Endereco rua5369 = new Endereco(null, "Rua Quinze", "Torrão de Ouro II", "Sul", "12229842");
		Endereco rua5370 = new Endereco(null, "Rua Dezesseis", "Torrão de Ouro II", "Sul", "12229843");
		Endereco rua5371 = new Endereco(null, "Condomínio Residencial Altos da Quinta", "Torrão de Ouro II", "Sul",
				"12229844");
		Endereco rua5372 = new Endereco(null, "Rodovia Governador Carvalho Pinto", "Torrão de Ouro II", "Sul",
				"12229849");
		Endereco rua5373 = new Endereco(null, "Avenida Shishima Hifumi", "Urbanova", "Oeste", "12244000");
		Endereco rua5374 = new Endereco(null, "Avenida Possidonio José de Freitas", "Urbanova", "Oeste", "12244010");
		Endereco rua5375 = new Endereco(null, "Rua Afonsina Peloia Simão", "Urbanova", "Oeste", "12244020");
		Endereco rua5376 = new Endereco(null, "Rua Benedito Machado Figueiredo", "Urbanova I", "Oeste", "12244030");
		Endereco rua5377 = new Endereco(null, "Rua Rosa Barbieri Paiotti", "Urbanova", "Oeste", "12244050");
		Endereco rua5378 = new Endereco(null, "Rua Tania Maria de Carvalho", "Urbanova I", "Oeste", "12244060");
		Endereco rua5379 = new Endereco(null, "Rua Nacim Anis Mimessi", "Urbanova", "Oeste", "12244070");
		Endereco rua5380 = new Endereco(null, "Rua Luiz Barbosa", "Urbanova", "Oeste", "12244080");
		Endereco rua5381 = new Endereco(null, "Rua Diogo Pinto da Cunha", "Urbanova", "Oeste", "12244090");
		Endereco rua5382 = new Endereco(null, "Rua Heli Adilson de Oliveira", "Urbanova", "Oeste", "12244100");
		Endereco rua5383 = new Endereco(null, "Rua Ângela Maria Carvalho Faria Basílio", "Urbanova I", "Oeste",
				"12244110");
		Endereco rua5384 = new Endereco(null, "Rua Benedicto Elias Guedes", "Urbanova I", "Oeste", "12244120");
		Endereco rua5385 = new Endereco(null, "Avenida Moema Resende Viega", "Urbanova", "Oeste", "12244130");
		Endereco rua5386 = new Endereco(null, "Praça Fukuoka", "Urbanova I", "Oeste", "12244140");
		Endereco rua5387 = new Endereco(null, "Rua Francisco José Sampaio Coelho", "Urbanova I", "Oeste", "12244150");
		Endereco rua5388 = new Endereco(null, "Rua Antônio Francisco do Nascimento", "Urbanova I", "Oeste", "12244160");
		Endereco rua5389 = new Endereco(null, "Rua Dorival Domingos da Silva", "Urbanova I", "Oeste", "12244170");
		Endereco rua5390 = new Endereco(null, "Rua Karina Gomes Faria", "Urbanova I", "Oeste", "12244172");
		Endereco rua5391 = new Endereco(null, "Rua Joaquim Borges", "Urbanova", "Oeste", "12244180");
		Endereco rua5392 = new Endereco(null, "Rua Severino Arcanjo de Oliveira", "Urbanova", "Oeste", "12244190");
		Endereco rua5393 = new Endereco(null, "Rua Norival Russiano Vieira", "Urbanova", "Oeste", "12244200");
		Endereco rua5394 = new Endereco(null, "Rua Hélio Chaves Monteiro", "Urbanova I", "Oeste", "12244210");
		Endereco rua5395 = new Endereco(null, "Rua Maria da Conceição Chaves Monteiro", "Urbanova I", "Oeste",
				"12244220");
		Endereco rua5396 = new Endereco(null, "Rua Plínio de Camargo Júnior", "Urbanova I", "Oeste", "12244230");
		Endereco rua5397 = new Endereco(null, "Rua Benedito Pinotti", "Urbanova I", "Oeste", "12244240");
		Endereco rua5398 = new Endereco(null, "Rua Cônego Ruy Amaral de Mello", "Urbanova I", "Oeste", "12244250");
		Endereco rua5399 = new Endereco(null, "Rua Professora Antônia Amaral Mello", "Urbanova I", "Oeste", "12244260");
		Endereco rua5400 = new Endereco(null, "Rua Maria Aparecida de Faria", "Urbanova I", "Oeste", "12244270");
		Endereco rua5401 = new Endereco(null, "Rua João Stener", "Urbanova I", "Oeste", "12244280");
		Endereco rua5402 = new Endereco(null, "Rua Waldemar Anhaias", "Urbanova I", "Oeste", "12244290");
		Endereco rua5403 = new Endereco(null, "Rua Vera Lúcia Cardoso Silva Barros", "Urbanova I", "Oeste", "12244300");
		Endereco rua5404 = new Endereco(null, "Rua Arnaldo Pinto Pereira", "Urbanova I", "Oeste", "12244310");
		Endereco rua5405 = new Endereco(null, "Rua Vicente de Finis", "Urbanova I", "Oeste", "12244320");
		Endereco rua5406 = new Endereco(null, "Rua Onofre do Prado", "Urbanova I", "Oeste", "12244330");
		Endereco rua5407 = new Endereco(null, "Rua Professor João Bernardo da Silva", "Urbanova I", "Oeste",
				"12244340");
		Endereco rua5408 = new Endereco(null, "Rua Evandro Tuy Júnior", "Urbanova", "Oeste", "12244350");
		Endereco rua5409 = new Endereco(null, "Rua Marcos Salgado de Araújo", "Urbanova", "Oeste", "12244360");
		Endereco rua5410 = new Endereco(null, "Rua João Carlos de Oliveira", "Urbanova", "Oeste", "12244370");
		Endereco rua5411 = new Endereco(null, "Avenida Lineu de Moura", "Urbanova", "Oeste", "12244380");
		Endereco rua5412 = new Endereco(null, "Travessa Lineu de Moura", "Urbanova", "Oeste", "12244381");
		Endereco rua5413 = new Endereco(null, "Avenida Shishina Hifumi", "Urbanova", "Oeste", "12244390");
		Endereco rua5414 = new Endereco(null, "Avenida Ironman Victor Garrido", "Loteamento Urbanova II", "Oeste",
				"12244392");
		Endereco rua5415 = new Endereco(null, "Avenida C 31", "Urbanova", "Oeste", "12244394");
		Endereco rua5416 = new Endereco(null, "Rua Piedade Martins Pereira", "Loteamento Urbanova II", "Oeste",
				"12244395");
		Endereco rua5417 = new Endereco(null, "Avenida Omar Fonseca", "Urbanova", "Oeste", "12244396");
		Endereco rua5418 = new Endereco(null, "Rua Doutor Oswaldo Couto", "Urbanova", "Oeste", "12244400");
		Endereco rua5419 = new Endereco(null, "Rua João Evangelista de Carvalho", "Urbanova", "Oeste", "12244410");
		Endereco rua5420 = new Endereco(null, "Rua Benedicta Lopes Vieira Henriques", "Urbanova", "Oeste", "12244420");
		Endereco rua5421 = new Endereco(null, "Rua Abigail Brogliato Carnevalli", "Urbanova", "Oeste", "12244430");
		Endereco rua5422 = new Endereco(null, "Rua Maria José Guido Brogliato Freire", "Urbanova", "Oeste", "12244440");
		Endereco rua5423 = new Endereco(null, "Rua José Murilo Freire", "Urbanova", "Oeste", "12244450");
		Endereco rua5424 = new Endereco(null, "Rua Artur Carlos Ferreira", "Urbanova", "Oeste", "12244451");
		Endereco rua5425 = new Endereco(null, "Rua Ignacio Kasper", "Urbanova", "Oeste", "12244453");
		Endereco rua5426 = new Endereco(null, "Rua Ana Ribeiro dos Santos", "Urbanova", "Oeste", "12244455");
		Endereco rua5427 = new Endereco(null, "Rua Hermínia Carlos Fortunato", "Loteamento Urbanova II", "Oeste",
				"12244456");
		Endereco rua5428 = new Endereco(null, "Rua Major Manoel Villela Lopes", "Urbanova", "Oeste", "12244457");
		Endereco rua5429 = new Endereco(null, "Praça Doutor Adelmo de Oliveira", "Urbanova IV-A", "Oeste", "12244460");
		Endereco rua5430 = new Endereco(null, "Rua Condelac Chaves de Andrade", "Urbanova III", "Oeste", "12244461");
		Endereco rua5431 = new Endereco(null, "Rua Rui Sérgio Rodrigues de Moura", "Urbanova", "Oeste", "12244465");
		Endereco rua5432 = new Endereco(null, "Rua Elvira Pereira de Camargo", "Loteamento Urbanova II", "Oeste",
				"12244470");
		Endereco rua5433 = new Endereco(null, "Rua Francisco Galvão Freire", "Loteamento Urbanova II", "Oeste",
				"12244479");
		Endereco rua5434 = new Endereco(null, "Rua VR 15", "Urbanova", "Oeste", "12244480");
		Endereco rua5435 = new Endereco(null, "Rua Doutor Antônio Carlos Ribas Branco", "Loteamento Urbanova II",
				"Oeste", "12244481");
		Endereco rua5436 = new Endereco(null, "Rua Victória Maluf Elias", "Urbanova", "Oeste", "12244482");
		Endereco rua5437 = new Endereco(null, "Rua José Pereira dos Santos", "Urbanova", "Oeste", "12244484");
		Endereco rua5438 = new Endereco(null, "Rua Scylla Bicudo", "Urbanova", "Oeste", "12244485");
		Endereco rua5439 = new Endereco(null, "Rua Dirce Elias", "Urbanova", "Oeste", "12244486");
		Endereco rua5440 = new Endereco(null, "Rua Waldomiro Ferraz", "Urbanova", "Oeste", "12244488");
		Endereco rua5441 = new Endereco(null, "Rua Francisco Pandolfi", "Urbanova", "Oeste", "12244491");
		Endereco rua5442 = new Endereco(null, "Rua Ricardo Brito Campoy", "Urbanova", "Oeste", "12244492");
		Endereco rua5443 = new Endereco(null, "Rua Máximo Brogliato", "Urbanova", "Oeste", "12244493");
		Endereco rua5444 = new Endereco(null, "Rua Isaurinha Garcia", "Urbanova", "Oeste", "12244501");
		Endereco rua5445 = new Endereco(null, "Avenida Major Aviador Jorge Mesquita", "Urbanova III", "Oeste",
				"12244510");
		Endereco rua5446 = new Endereco(null, "Avenida Ub-31", "Urbanova", "Oeste", "12244511");
		Endereco rua5447 = new Endereco(null, "Rua SC-2A", "Urbanova", "Oeste", "12244512");
		Endereco rua5448 = new Endereco(null, "Rua SC-2B", "Urbanova", "Oeste", "12244513");
		Endereco rua5449 = new Endereco(null, "Rua Ana Rosa de Almeida Carvalho", "Urbanova III", "Oeste", "12244514");
		Endereco rua5450 = new Endereco(null, "Rua Paulo Renato da Cunha Santos", "Urbanova III", "Oeste", "12244515");
		Endereco rua5451 = new Endereco(null, "Rua Fernando Fagundes", "Urbanova", "Oeste", "12244516");
		Endereco rua5452 = new Endereco(null, "Rua Ana Soares da Silveira", "Urbanova", "Oeste", "12244517");
		Endereco rua5453 = new Endereco(null, "Rua Ana Maria Prianti Aidar", "Urbanova", "Oeste", "12244518");
		Endereco rua5454 = new Endereco(null, "Rua Augusto Silvério dos Santos", "Urbanova", "Oeste", "12244519");
		Endereco rua5455 = new Endereco(null, "Rua Sidnei Roger Corrá", "Urbanova III", "Oeste", "12244520");
		Endereco rua5456 = new Endereco(null, "Rua Cláudio Lemes", "Urbanova III", "Oeste", "12244521");
		Endereco rua5457 = new Endereco(null, "Rua José Lemes", "Urbanova III", "Oeste", "12244522");
		Endereco rua5458 = new Endereco(null, "Rua Eudócio de Paula", "Urbanova III", "Oeste", "12244523");
		Endereco rua5459 = new Endereco(null, "Rua João da Silva Porto", "Urbanova III", "Oeste", "12244524");
		Endereco rua5460 = new Endereco(null, "Rua Antenor Raimundo da Silva", "Urbanova III", "Oeste", "12244525");
		Endereco rua5461 = new Endereco(null, "Rua Conrado Cruz", "Urbanova", "Oeste", "12244530");
		Endereco rua5462 = new Endereco(null, "Rua Marcos Rogério Deolindo da Silva", "Urbanova IV-A", "Oeste",
				"12244540");
		Endereco rua5463 = new Endereco(null, "Rua Professor Walter de Almeida Monteiro", "Urbanova", "Oeste",
				"12244550");
		Endereco rua5464 = new Endereco(null, "Rua Paulo Wagner Dinamarco", "Urbanova", "Oeste", "12244560");
		Endereco rua5465 = new Endereco(null, "Rua Paulo Haruyoshi Hayashi", "Urbanova IV-A", "Oeste", "12244570");
		Endereco rua5466 = new Endereco(null, "Rua José Bonetti", "Urbanova IV-A", "Oeste", "12244573");
		Endereco rua5467 = new Endereco(null, "Rua Pedro Synesio Vanzella", "Urbanova III", "Oeste", "12244574");
		Endereco rua5468 = new Endereco(null, "Rua Ilma Mendonça", "Urbanova IV-A", "Oeste", "12244576");
		Endereco rua5469 = new Endereco(null, "Rua Pedro Lopes da Silva", "Urbanova IV-A", "Oeste", "12244580");
		Endereco rua5470 = new Endereco(null, "Rua Ércia Maria Ribeiro Pereira", "Urbanova IV-A", "Oeste", "12244583");
		Endereco rua5471 = new Endereco(null, "Avenida Celuta Barbosa Mendonça", "Urbanova IV-A", "Oeste", "12244586");
		Endereco rua5472 = new Endereco(null, "Rua Helena Reis Gomes Morais", "Urbanova", "Oeste", "12244589");
		Endereco rua5473 = new Endereco(null, "Rua João Justo Pereira", "Urbanova IV-A", "Oeste", "12244590");
		Endereco rua5474 = new Endereco(null, "Rua Sérgio Rodrigues Moura", "Urbanova", "Oeste", "12244592");
		Endereco rua5475 = new Endereco(null, "Rua José da Fonseca Lima", "Urbanova VI", "Oeste", "12244593");
		Endereco rua5476 = new Endereco(null, "Avenida Carlos Alberto Ribeiro de Souza", "Urbanova VI", "Oeste",
				"12244595");
		Endereco rua5477 = new Endereco(null, "Avenida Papa João Paulo II", "Urbanova VI", "Oeste", "12244597");
		Endereco rua5478 = new Endereco(null, "Rua Benedita Bueno Ribeiro", "Urbanova VI", "Oeste", "12244599");
		Endereco rua5479 = new Endereco(null, "Rua Marcos Sattelmayer Aguiar", "Urbanova", "Oeste", "12244602");
		Endereco rua5480 = new Endereco(null, "Rua Cleonice Diniz Barbosa", "Urbanova VI", "Oeste", "12244604");
		Endereco rua5481 = new Endereco(null, "Rua Padre Jonas Traversin", "Urbanova VI", "Oeste", "12244606");
		Endereco rua5482 = new Endereco(null, "Rua Nilza Aparecida Silva Machado da Silva", "Urbanova VI", "Oeste",
				"12244608");
		Endereco rua5483 = new Endereco(null, "Rua Eduardo Meyer Fleury", "Urbanova VI", "Oeste", "12244611");
		Endereco rua5484 = new Endereco(null, "Rua Cleyde Mara Ferreira de Andrade", "Urbanova VI", "Oeste",
				"12244613");
		Endereco rua5485 = new Endereco(null, "Rua Serra das Vertentes", "Urbanova", "Oeste", "12244615");
		Endereco rua5486 = new Endereco(null, "Rua Serra Grande", "Urbanova VI", "Oeste", "12244617");
		Endereco rua5487 = new Endereco(null, "Rua José Fiorentini Pasquarelli", "Urbanova", "Oeste", "12244619");
		Endereco rua5488 = new Endereco(null, "Rua Albino dos Anjos Conrado", "Urbanova III", "Oeste", "12244850");
		Endereco rua5489 = new Endereco(null, "Rua Rogério Marcos Ribeiro", "Urbanova III", "Oeste", "12244851");
		Endereco rua5490 = new Endereco(null, "Rua Priscilliana de Moraes", "Urbanova III", "Oeste", "12244852");
		Endereco rua5491 = new Endereco(null, "Rua Doutor Marcos Fiúza Silva", "Urbanova", "Oeste", "12244853");
		Endereco rua5492 = new Endereco(null, "Rua José Moreira Sobrinho", "Urbanova", "Oeste", "12244854");
		Endereco rua5493 = new Endereco(null, "Rua Antonio Alves Magalhães", "Urbanova V", "Oeste", "12244855");
		Endereco rua5494 = new Endereco(null, "Rua Plinio Pedrosa Dias", "Urbanova V", "Oeste", "12244856");
		Endereco rua5495 = new Endereco(null, "Rua Inez Maria Cuoghi", "Urbanova V", "Oeste", "12244857");
		Endereco rua5496 = new Endereco(null, "Rua Lorenz Morti", "Urbanova V", "Oeste", "12244858");
		Endereco rua5497 = new Endereco(null, "Rua Virgínia Rivoli Gomes", "Urbanova V", "Oeste", "12244859");
		Endereco rua5498 = new Endereco(null, "Rua Miguel Angel Jimenez Romanillos", "Urbanova", "Oeste", "12244860");
		Endereco rua5499 = new Endereco(null, "Rua Maria José Amaral Alves", "Urbanova V", "Oeste", "12244861");
		Endereco rua5500 = new Endereco(null, "Rua Daniel Alves Areas", "Urbanova V", "Oeste", "12244862");
		Endereco rua5501 = new Endereco(null, "Rua Israel Coppio Sobrinho", "Urbanova V", "Oeste", "12244863");
		Endereco rua5502 = new Endereco(null, "Rua Roberto Felício", "Urbanova", "Oeste", "12244864");
		Endereco rua5503 = new Endereco(null, "Rua Vicente Cursina dos Santos", "Urbanova V", "Oeste", "12244865");
		Endereco rua5504 = new Endereco(null, "Rua Milton Martins", "Urbanova", "Oeste", "12244867");
		Endereco rua5505 = new Endereco(null, "Rua Herbert Brenner", "Urbanova V", "Oeste", "12244869");
		Endereco rua5506 = new Endereco(null, "Rua Antonio Hernandes Gomes", "Urbanova V", "Oeste", "12244870");
		Endereco rua5507 = new Endereco(null, "Rua Ismael Lemes Santana", "Urbanova V", "Oeste", "12244871");
		Endereco rua5508 = new Endereco(null, "Rua Ub 97", "Urbanova", "Oeste", "12244872");
		Endereco rua5509 = new Endereco(null, "Avenida Antonio Widmer", "Urbanova V", "Oeste", "12244873");
		Endereco rua5510 = new Endereco(null, "Rua Maria das Dores Rodrigues Monteiro", "Urbanova VII", "Oeste",
				"12244874");
		Endereco rua5511 = new Endereco(null, "Rua Benedito Freire", "Urbanova VII", "Oeste", "12244875");
		Endereco rua5512 = new Endereco(null, "Rua Leandro Fernandes Santos", "Urbanova VII", "Oeste", "12244876");
		Endereco rua5513 = new Endereco(null, "Rua Silvio Romão de Oliveira", "Urbanova VII", "Oeste", "12244877");
		Endereco rua5514 = new Endereco(null, "Avenida Alex Fernandes da Silva", "Urbanova VII", "Oeste", "12244878");
		Endereco rua5515 = new Endereco(null, "Avenida Giovanni Friggi", "Urbanova VII", "Oeste", "12244879");
		Endereco rua5516 = new Endereco(null, "Avenida Alfonso Friggi", "Urbanova VII", "Oeste", "12244880");
		Endereco rua5517 = new Endereco(null, "Avenida Guglielmo Friggi", "Urbanova VII", "Oeste", "12244881");
		Endereco rua5518 = new Endereco(null, "Avenida Maria de Lourdes Friggi", "Urbanova", "Oeste", "12244882");
		Endereco rua5519 = new Endereco(null, "Rua Maria da Glória Serpa Martins", "Urbanova VII", "Oeste", "12244883");
		Endereco rua5520 = new Endereco(null, "Rua Benedita dos Santos de Oliveira", "Urbanova VII", "Oeste",
				"12244884");
		Endereco rua5521 = new Endereco(null, "Rua Expedicionário José Lopes Cruz", "Urbanova VII", "Oeste",
				"12244885");
		Endereco rua5522 = new Endereco(null, "Rua Engenheiro Amintas Rocha Brito", "Urbanova VII", "Oeste",
				"12244887");
		Endereco rua5523 = new Endereco(null, "Rua Romeu Tinoco", "Urbanova VII", "Oeste", "12244888");
		Endereco rua5524 = new Endereco(null, "Rua Pedro Batista Gonçalves", "Urbanova VII", "Oeste", "12244889");
		Endereco rua5525 = new Endereco(null, "Avenida Giuseppe Friggi", "Urbanova", "Oeste", "12244890");
		Endereco rua5526 = new Endereco(null, "Rua Mauricio do Nascimento Monteiro", "Urbanova VII", "Oeste",
				"12244891");
		Endereco rua5527 = new Endereco(null, "Avenida Josephina Segata", "Urbanova VII", "Oeste", "12244892");
		Endereco rua5528 = new Endereco(null, "Rua Antônio Peneluppi Filho", "Vila Alexandrina", "Norte", "12211160");
		Endereco rua5529 = new Endereco(null, "Travessa Terezinha Savastano", "Vila Alexandrina", "Norte", "12211190");
		Endereco rua5530 = new Endereco(null, "Rua Luís Gama", "Vila Alexandrina", "Norte", "12211200");
		Endereco rua5531 = new Endereco(null, "Rua Paulo Madureira Lebrão", "Vila Alexandrina", "Norte", "12211240");
		Endereco rua5532 = new Endereco(null, "Rua Antônio Júlio da Costa Guimarães", "Vila Alexandrina", "Norte",
				"12211270");
		Endereco rua5533 = new Endereco(null, "Rua Olivo Gomes", "Vila Alexandrina", "Norte", "12211290");
		Endereco rua5534 = new Endereco(null, "Avenida Tivoli", "Vila Betânia", "Centro", "12245230");
		Endereco rua5535 = new Endereco(null, "Praça dos Servidores Públicos Municipais", "Vila Betânia", "Centro",
				"12245471");
		Endereco rua5536 = new Endereco(null, "Avenida Tivoli", "Vila Betânia", "Centro", "12245481");
		Endereco rua5537 = new Endereco(null, "Rua Armando Couto de Magalhães Rodrigues", "Vila Betânia", "Centro",
				"12245483");
		Endereco rua5538 = new Endereco(null, "Rua Raul Roldão da Costa", "Vila Betânia", "Centro", "12245484");
		Endereco rua5539 = new Endereco(null, "Alameda Antônio Rodrigues de Paula", "Vila Betânia", "Centro",
				"12245485");
		Endereco rua5540 = new Endereco(null, "Rua Cândido Marciano Leite", "Vila Betânia", "Centro", "12245486");
		Endereco rua5541 = new Endereco(null, "Praça Vinte e Oito de Outubro", "Vila Betânia", "Centro", "12245487");
		Endereco rua5542 = new Endereco(null, "Praça Capitão Paulo José Menezes", "Vila Betânia", "Centro", "12245488");
		Endereco rua5543 = new Endereco(null, "Alameda José Paula da Silva", "Vila Betânia", "Centro", "12245489");
		Endereco rua5544 = new Endereco(null, "Alameda José Rodrigues de Moraes", "Vila Betânia", "Centro", "12245490");
		Endereco rua5545 = new Endereco(null, "Rua Major José Mariotto Ferreira", "Vila Betânia", "Centro", "12245491");
		Endereco rua5546 = new Endereco(null, "Alameda José Alves de Siqueira Filho", "Vila Betânia", "Centro",
				"12245492");
		Endereco rua5547 = new Endereco(null, "Rua Joaquim de Carvalho", "Vila Betânia", "Centro", "12245493");
		Endereco rua5548 = new Endereco(null, "Rua Álvares de Azevedo", "Vila Betânia", "Centro", "12245494");
		Endereco rua5549 = new Endereco(null, "Rua José Monteiro Teixeira", "Vila Betânia", "Centro", "12245523");
		Endereco rua5550 = new Endereco(null, "Rua Miguel Couto", "Vila Betânia", "Centro", "12245524");
		Endereco rua5551 = new Endereco(null, "Praça Tenente Deodato", "Vila Betânia", "Centro", "12245525");
		Endereco rua5552 = new Endereco(null, "Rua Fagundes Varela", "Vila Betânia", "Centro", "12245530");
		Endereco rua5553 = new Endereco(null, "Rua Diomedes Santos", "Vila Betânia", "Centro", "12245533");
		Endereco rua5554 = new Endereco(null, "Rua Guilherme de Almeida", "Vila Betânia", "Centro", "12245550");
		Endereco rua5555 = new Endereco(null, "Rua Professor Everardo Miranda Passos", "Vila Betânia", "Centro",
				"12245604");
		Endereco rua5556 = new Endereco(null, "Avenida Deputado Benedito Matarazzo", "Vila Betânia", "Centro",
				"12245615");
		Endereco rua5557 = new Endereco(null, "Praça José Peneluppi Filho", "Vila Betânia", "Centro", "12245620");
		Endereco rua5558 = new Endereco(null, "Praça João Batista de Quadros", "Vila Betânia", "Centro", "12245630");
		Endereco rua5559 = new Endereco(null, "Travessa São Dimas", "Vila Betânia", "Centro", "12245631");
		Endereco rua5560 = new Endereco(null, "Rua Agenor Domingues Varanda", "Vila Cândida", "Norte", "12213520");
		Endereco rua5561 = new Endereco(null, "Rua José Silvério de Souza", "Vila Cândida", "Norte", "12213521");
		Endereco rua5562 = new Endereco(null, "Ponte Paulo Machado de Carvalho", "Vila Cândida", "Norte", "12213522");
		Endereco rua5563 = new Endereco(null, "Praça São Marcos", "Vila Cândida", "Norte", "12213530");
		Endereco rua5564 = new Endereco(null, "Avenida Maria Cândida Delgado", "Vila Cândida", "Norte", "12213531");
		Endereco rua5565 = new Endereco(null, "Rua Bernardo Priante", "Vila Cândida", "Norte", "12213550");
		Endereco rua5566 = new Endereco(null, "Rua Coronel Silvestre Cândido Ribeiro", "Vila Cândida", "Norte",
				"12213560");
		Endereco rua5567 = new Endereco(null, "Rua José Dias Medeiros", "Vila Cristina", "Norte", "12211120");
		Endereco rua5568 = new Endereco(null, "Praça Tenente-Coronel Benedito Antônio de Oliveira", "Vila Cristina",
				"Norte", "12211122");
		Endereco rua5569 = new Endereco(null, "Rua Manoel de Oliveira e Silva", "Vila Cristina", "Norte", "12211123");
		Endereco rua5570 = new Endereco(null, "Travessa Medeiros", "Vila Cristina", "Norte", "12211124");
		Endereco rua5571 = new Endereco(null, "Rua Antônio de Oliveira e Silva", "Vila Cristina", "Norte", "12211125");
		Endereco rua5572 = new Endereco(null, "Rua Augusto de Oliveira e Silva", "Vila Cristina", "Norte", "12211126");
		Endereco rua5573 = new Endereco(null, "Rua Antônio Rodrigues Guedes do Prado", "Vila Cristina", "Norte",
				"12211127");
		Endereco rua5574 = new Endereco(null, "Praça Luiz Mioni", "Vila Cristina", "Norte", "12211128");
		Endereco rua5575 = new Endereco(null, "Rua José de Oliveira Prisco", "Vila Cristina", "Norte", "12211129");
		Endereco rua5576 = new Endereco(null, "Rua Vicente Leporace", "Vila Dirce", "Norte", "12213010");
		Endereco rua5577 = new Endereco(null, "Rua Jaguari", "Vila Dirce", "Norte", "12213011");
		Endereco rua5578 = new Endereco(null, "Rua Genoveva Pinto da Cunha", "Vila Dirce", "Norte", "12213020");
		Endereco rua5579 = new Endereco(null, "Rua Mário Scholz", "Vila Dirce", "Norte", "12213030");
		Endereco rua5580 = new Endereco(null, "Rua Nivaldo Prisco da Cunha", "Vila Dirce", "Norte", "12213040");
		Endereco rua5581 = new Endereco(null, "Rua Pedro Antônio de Castro Pinheiros", "Vila Dirce", "Norte",
				"12213041");
		Endereco rua5582 = new Endereco(null, "Rua José Fernando de Almeida Moura", "Vila Dirce", "Norte", "12213050");
		Endereco rua5583 = new Endereco(null, "Avenida Jorge Zarur", " 235", "Vila Ema", "Centro");
		Endereco rua5584 = new Endereco(null, "Rua Madre Paula de São José", "Vila Ema", "Centro", "12243010");
		Endereco rua5585 = new Endereco(null, "Rua Comendador Remo Cesaroni", "Vila Ema", "Centro", "12243020");
		Endereco rua5586 = new Endereco(null, "Rua Justino Cobra", "Vila Ema", "Centro", "12243030");
		Endereco rua5587 = new Endereco(null, "Rua Bárbara Knippelberg Loureiro", "Vila Ema", "Centro", "12243040");
		Endereco rua5588 = new Endereco(null, "Rua Beatriz Sá de Toledo", "Vila Ema", "Centro", "12243050");
		Endereco rua5589 = new Endereco(null, "Rua José Francisco Alves", "Vila Ema", "Centro", "12243060");
		Endereco rua5590 = new Endereco(null, "Rua Jorge Barbosa Moreira", "Vila Ema", "Centro", "12243070");
		Endereco rua5591 = new Endereco(null, "Rua Padre Rodolfo", "Vila Ema", "Centro", "12243080");
		Endereco rua5592 = new Endereco(null, "Avenida Jorge Zarur", "Vila Ema", "Centro", "12243081");
		Endereco rua5593 = new Endereco(null, "Travessa Jamil David", "Vila Ema", "Centro", "12243250");
		Endereco rua5594 = new Endereco(null, "Avenida Heitor Villa Lobos", "Vila Ema", "Centro", "12243260");
		Endereco rua5595 = new Endereco(null, "Rua Francisco Ricci", "Vila Ema", "Centro", "12243261");
		Endereco rua5596 = new Endereco(null, "Acesso José Miguel Dias", "Vila Ema", "Centro", "12243262");
		Endereco rua5597 = new Endereco(null, "Praça Chuí", " 27", "Vila Ema", "Centro");
		Endereco rua5598 = new Endereco(null, "Rua Serimbura", " 355", "Vila Ema", "Centro");
		Endereco rua5599 = new Endereco(null, "Praça Bom Jesus do Serimbura", " 60", "Vila Ema", "Centro");
		Endereco rua5600 = new Endereco(null, "Rua Comendador Remo Cesaroni", " 106", "Vila Ema", "Centro");
		Endereco rua5601 = new Endereco(null, "Rua José Francisco Alves", " 45", "Vila Ema", "Centro");
		Endereco rua5602 = new Endereco(null, "Rua Comendador Remo Cesaroni", " 425", "Vila Ema", "Centro");
		Endereco rua5603 = new Endereco(null, "Rua Beatriz Sá de Toledo", " 95", "Vila Ema", "Centro");
		Endereco rua5604 = new Endereco(null, "Rua Mário Martins Pereira", "Vila Esmeralda", "Norte", "12212190");
		Endereco rua5605 = new Endereco(null, "Rua Benedito Lacerda", "Vila Ester", "Leste", "12221570");
		Endereco rua5606 = new Endereco(null, "Praça Engenheiro Roberto Simone Ale Laurino", "Vila Ester", "Leste",
				"12221573");
		Endereco rua5607 = new Endereco(null, "Rua José Gomes de Abreu", "Vila Ester", "Leste", "12221580");
		Endereco rua5608 = new Endereco(null, "Rua Lupicinio Rodrigues", "Vila Ester", "Leste", "12221590");
		Endereco rua5609 = new Endereco(null, "Praça Benedito Narciso Ceruti", "Vila Ester", "Leste", "12221592");
		Endereco rua5610 = new Endereco(null, "Rua Ciro Monteiro", "Vila Ester", "Leste", "12221600");
		Endereco rua5611 = new Endereco(null, "Rua Carlos Esperíndio", "Vila Ester", "Leste", "12221610");
		Endereco rua5612 = new Endereco(null, "Rua Guimarães Rosa", "Vila Ester", "Leste", "12221611");
		Endereco rua5613 = new Endereco(null, "Rua C", "Vila Ester", "Leste", "12221612");
		Endereco rua5614 = new Endereco(null, "Rua José Dias Pereira Júnior", "Vila Ester", "Leste", "12221620");
		Endereco rua5615 = new Endereco(null, "Rua Alfem Pereira Junqueira", "Vila Ester", "Leste", "12221630");
		Endereco rua5616 = new Endereco(null, "Rua Homero Ferreira de Cunha", "Vila Ester", "Leste", "12221640");
		Endereco rua5617 = new Endereco(null, "Rua Maria da Conceição Maia", "Vila Ester", "Leste", "12221650");
		Endereco rua5618 = new Endereco(null, "Rua Agostinho dos Santos", "Vila Ester", "Leste", "12221660");
		Endereco rua5619 = new Endereco(null, "Rua Catulo da Paixão Cearense", "Vila Ester", "Leste", "12221670");
		Endereco rua5620 = new Endereco(null, "Rua Noel Rosa", "Vila Ester", "Leste", "12221680");
		Endereco rua5621 = new Endereco(null, "Rua Cândido das Neves", "Vila Ester", "Leste", "12221690");
		Endereco rua5622 = new Endereco(null, "Rua Oswaldo Gogliano", "Vila Ester", "Leste", "12221700");
		Endereco rua5623 = new Endereco(null, "Rua Carmem Miranda", "Vila Ester", "Leste", "12221710");
		Endereco rua5624 = new Endereco(null, "Rua Alfredo da Rocha Viana", "Vila Ester", "Leste", "12221720");
		Endereco rua5625 = new Endereco(null, "Rua Assis Valente", "Vila Ester", "Leste", "12221730");
		Endereco rua5626 = new Endereco(null, "Rua Ernesto Júlio Nazareth", "Vila Ester", "Leste", "12221770");
		Endereco rua5627 = new Endereco(null, "Rua Tomaz Antônio Gonzaga", "Vila Guaianazes", "Centro", "12243320");
		Endereco rua5628 = new Endereco(null, "Rua José Pedro de Carvalho Filho", "Vila Guaianazes", "Centro",
				"12243330");
		Endereco rua5629 = new Endereco(null, "Rua José Bonifácio", "Vila Guaianazes", "Centro", "12243340");
		Endereco rua5630 = new Endereco(null, "Rua Aristides Friggi", "Vila Guaianazes", "Centro", "12243350");
		Endereco rua5631 = new Endereco(null, "Rua Serimbura", "Vila Guaianazes", "Centro", "12243360");
		Endereco rua5632 = new Endereco(null, "Praça Bom Jesus do Serimbura", "Vila Guaianazes", "Centro", "12243370");
		Endereco rua5633 = new Endereco(null, "Rua Benedito Julião Machado", "Vila Guarani", "Centro", "12209750");
		Endereco rua5634 = new Endereco(null, "Rua José Pirk", "Vila Guarani", "Centro", "12209760");
		Endereco rua5635 = new Endereco(null, "Rua Antônio Pinto da Cunha", "Vila Guarani", "Centro", "12209770");
		Endereco rua5636 = new Endereco(null, "Rua Francisco Napoleão Isac", "Vila Guarani", "Centro", "12209780");
		Endereco rua5637 = new Endereco(null, "Rua José Antônio de Moraes", "Vila Guarani", "Centro", "12209790");
		Endereco rua5638 = new Endereco(null, "Rua Antônio Friggi", "Vila Guarani", "Centro", "12209800");
		Endereco rua5639 = new Endereco(null, "Rua Francisco Antônio Rodrigues", "Vila Guarani", "Centro", "12209810");
		Endereco rua5640 = new Endereco(null, "Rua Balbino Gonçalves", "Vila Guarani", "Centro", "12209820");
		Endereco rua5641 = new Endereco(null, "Rua João Alves Viana", "Vila Guarani", "Centro", "12209830");
		Endereco rua5642 = new Endereco(null, "Rua Nestor Soriano", "Vila Guarani", "Centro", "12209840");
		Endereco rua5643 = new Endereco(null, "Rua Leonardo Pinto da Cunha", "Vila Higienópolis", "Centro", "12243760");
		Endereco rua5644 = new Endereco(null, "Rua Professor Alfredo Vieira de Moura", "Vila Higienópolis", "Centro",
				"12243770");
		Endereco rua5645 = new Endereco(null, "Avenida Presidente Juscelino Kubitschek", "Vila Industrial", "Leste",
				"12220000");
		Endereco rua5646 = new Endereco(null, "Praça Papa Paulo VI", "Vila Industrial", "Leste", "12220001");
		Endereco rua5647 = new Endereco(null, "Rua Professor Félicio Savastano", "Vila Industrial", "Leste",
				"12220270");
		Endereco rua5648 = new Endereco(null, "Rua Saigiro Nakamura", "Vila Industrial", "Leste", "12220280");
		Endereco rua5649 = new Endereco(null, "Rua Doutor Jamil Cury", "Vila Industrial", "Leste", "12220281");
		Endereco rua5650 = new Endereco(null, "Rua Doutor Ricardo Edwards", "Vila Industrial", "Leste", "12220290");
		Endereco rua5651 = new Endereco(null, "Rua José Molina", "Vila Industrial", "Leste", "12220300");
		Endereco rua5652 = new Endereco(null, "Rua Doutor Alberto Miguel Roman", "Vila Industrial", "Leste",
				"12220320");
		Endereco rua5653 = new Endereco(null, "Rua João Liberato", "Vila Industrial", "Leste", "12220330");
		Endereco rua5654 = new Endereco(null, "Rua Misael Marçal", "Vila Industrial", "Leste", "12220340");
		Endereco rua5655 = new Endereco(null, "Rua Dona Neli Santos Lopes", "Vila Industrial", "Leste", "12220350");
		Endereco rua5656 = new Endereco(null, "Avenida João Marson", "Vila Industrial", "Leste", "12220360");
		Endereco rua5657 = new Endereco(null, "Praça José Avelino de Oliveira", "Vila Industrial", "Leste", "12220370");
		Endereco rua5658 = new Endereco(null, "Avenida Professor Sebastião Paulo de Toledo Pontes", "Vila Industrial",
				"Leste", "12220380");
		Endereco rua5659 = new Endereco(null, "Rua Ari Barroso", "Vila Industrial", "Leste", "12220390");
		Endereco rua5660 = new Endereco(null, "Avenida José de Moura Candelaria", "Vila Industrial", "Leste",
				"12220400");
		Endereco rua5661 = new Endereco(null, "Rua Clementino Alves de Souza", "Vila Industrial", "Leste", "12220410");
		Endereco rua5662 = new Endereco(null, "Rua Julieta Damasceno Claro", "Vila Industrial", "Leste", "12220420");
		Endereco rua5663 = new Endereco(null, "Rua Waldomiro Rosendo de Oliveira", "Vila Industrial", "Leste",
				"12220430");
		Endereco rua5664 = new Endereco(null, "Praça Leão XIII", "Vila Industrial", "Leste", "12220431");
		Endereco rua5665 = new Endereco(null, "Rua José Polli", "Vila Industrial", "Leste", "12220440");
		Endereco rua5666 = new Endereco(null, "Rua Francisco Pereira Filho", "Vila Industrial", "Leste", "12220450");
		Endereco rua5667 = new Endereco(null, "Rua Engenheiro Demerval Veras", "Vila Industrial", "Leste", "12220460");
		Endereco rua5668 = new Endereco(null, "Rua Doutor Adhemar Figueiredo Lira", "Vila Industrial", "Leste",
				"12220470");
		Endereco rua5669 = new Endereco(null, "Rua Albertino de Almeida", "Vila Industrial", "Leste", "12220480");
		Endereco rua5670 = new Endereco(null, "Rua Pedro Pereira Filho", "Vila Industrial", "Leste", "12220482");
		Endereco rua5671 = new Endereco(null, "Rua Ângelo Ottoboni", "Vila Industrial", "Leste", "12220490");
		Endereco rua5672 = new Endereco(null, "Rua Alfredo Pereira Filho", "Vila Industrial", "Leste", "12220520");
		Endereco rua5673 = new Endereco(null, "Rua Edward Simões", "Vila Industrial", "Leste", "12220530");
		Endereco rua5674 = new Endereco(null, "Rua Papa João XXIII", "Vila Industrial", "Leste", "12220540");
		Endereco rua5675 = new Endereco(null, "Praça Aida Monteiro de Castro Veloso", "Vila Industrial", "Leste",
				"12220550");
		Endereco rua5676 = new Endereco(null, "Rua Agostinho Benedetti", "Vila Industrial", "Leste", "12220560");
		Endereco rua5677 = new Endereco(null, "Rua Riskala José Neme", "Vila Industrial", "Leste", "12220570");
		Endereco rua5678 = new Endereco(null, "Rua Israel Diamante", "Vila Industrial", "Leste", "12220580");
		Endereco rua5679 = new Endereco(null, "Rua Afonso Matarazzo Filho", "Vila Industrial", "Leste", "12220590");
		Endereco rua5680 = new Endereco(null, "Estrada da Olaria", "Vila Industrial", "Leste", "12220592");
		Endereco rua5681 = new Endereco(null, "Avenida Presidente Juscelino Kubitschek", " 6701", "Vila Industrial",
				"Leste");
		Endereco rua5682 = new Endereco(null, "Rua Abília Machado", " s/n", "Vila Industrial", "Leste");
		Endereco rua5683 = new Endereco(null, "Rua Israel Diamante", " 56", "Vila Industrial", "Leste");
		Endereco rua5684 = new Endereco(null, "Rua Itinga", "Vila Iracema", "Sudeste", "12228121");
		Endereco rua5685 = new Endereco(null, "Rua Joalma", "Vila Iracema", "Sudeste", "12228130");
		Endereco rua5686 = new Endereco(null, "Rua Medina", "Vila Iracema", "Sudeste", "12228131");
		Endereco rua5687 = new Endereco(null, "Rua Governador Valadares", "Vila Iracema", "Sudeste", "12228140");
		Endereco rua5688 = new Endereco(null, "Rua Frei Inocêncio", "Vila Iracema", "Sudeste", "12228150");
		Endereco rua5689 = new Endereco(null, "Praça Muriae", "Vila Iracema", "Sudeste", "12228151");
		Endereco rua5690 = new Endereco(null, "Praça Centenário", "Vila Iracema", "Sudeste", "12228152");
		Endereco rua5691 = new Endereco(null, "Rua Itambacuri", "Vila Iracema", "Sudeste", "12228160");
		Endereco rua5692 = new Endereco(null, "Rua Itaobim", "Vila Iracema", "Sudeste", "12228161");
		Endereco rua5693 = new Endereco(null, "Rua Piranguinho", "Vila Iracema", "Sudeste", "12228170");
		Endereco rua5694 = new Endereco(null, "Rua Frei São Vicente", "Vila Iracema", "Sudeste", "12228171");
		Endereco rua5695 = new Endereco(null, "Rua Ipiaguinha", "Vila Iracema", "Sudeste", "12228172");
		Endereco rua5696 = new Endereco(null, "Praça Tabajara", "Vila Jaci", "Centro", "12211360");
		Endereco rua5697 = new Endereco(null, "Rua Tibiriçá", "Vila Jaci", "Centro", "12211370");
		Endereco rua5698 = new Endereco(null, "Rua Guaicurus", "Vila Jaci", "Centro", "12211380");
		Endereco rua5699 = new Endereco(null, "Rua Caiapós", "Vila Jaci", "Centro", "12211390");
		Endereco rua5700 = new Endereco(null, "Rua Ovidio Cesar", "Vila Jaci", "Centro", "12211400");
		Endereco rua5701 = new Endereco(null, "Rua Aimorés", "Vila Jaci", "Centro", "12211410");
		Endereco rua5702 = new Endereco(null, "Rua Xavantes", "Vila Jaci", "Centro", "12211411");
		Endereco rua5703 = new Endereco(null, "Rua Benedito Venâncio de Lima", "Conjunto Residencial Vila Leila",
				"Norte", "12212475");
		Endereco rua5704 = new Endereco(null, "Rua Sebastião Geraldo do Nascimento", "Conjunto Residencial Vila Leila",
				"Norte", "12212477");
		Endereco rua5705 = new Endereco(null, "Rua Lázaro Caetano da Costa", "Conjunto Residencial Vila Leila", "Norte",
				"12212479");
		Endereco rua5706 = new Endereco(null, "Rua Irene Maria de Jesus", "Conjunto Residencial Vila Leila", "Norte",
				"12212481");
		Endereco rua5707 = new Endereco(null, "Rua Aracy Iria Camargo", "Conjunto Residencial Vila Leila", "Norte",
				"12212483");
		Endereco rua5708 = new Endereco(null, "Rua São Vicente", "Conjunto Residencial Vila Leila", "Norte",
				"12212560");
		Endereco rua5709 = new Endereco(null, "Rua Santo Onofre", "Conjunto Residencial Vila Leila", "Norte",
				"12212570");
		Endereco rua5710 = new Endereco(null, "Rua Áustria", "Vila Letônia", "Sul", "12231171");
		Endereco rua5711 = new Endereco(null, "Travessa dos Anjos", "Vila Luchetti", "Sul", "12231563");
		Endereco rua5712 = new Endereco(null, "Travessa Claudemir José Souza", "Vila Luchetti", "Sul", "12231565");
		Endereco rua5713 = new Endereco(null, "Travessa Dezesseis", "Vila Luchetti", "Sul", "12231566");
		Endereco rua5714 = new Endereco(null, "Travessa Orlinda Ferreira da Silva", "Vila Luchetti", "Sul", "12231567");
		Endereco rua5715 = new Endereco(null, "Travessa Bento Moreira", "Vila Luchetti", "Sul", "12231569");
		Endereco rua5716 = new Endereco(null, "Rua Doutor Aleixo Mascarenhas", "Vila Maria", "Centro", "12209220");
		Endereco rua5717 = new Endereco(null, "Travessa Alfredo José Dias Costa", "Vila Maria", "Centro", "12209230");
		Endereco rua5718 = new Endereco(null, "Rua Serafim Dias Machado", "Vila Maria", "Centro", "12209240");
		Endereco rua5719 = new Endereco(null, "Rua Paraná", "Vila Maria", "Centro", "12209250");
		Endereco rua5720 = new Endereco(null, "Rua Santa Catarina", "Vila Maria", "Centro", "12209260");
		Endereco rua5721 = new Endereco(null, "Travessa Rio de Janeiro", "Vila Maria", "Centro", "12209270");
		Endereco rua5722 = new Endereco(null, "Rua São Pedro", "Vila Maria", "Centro", "12209280");
		Endereco rua5723 = new Endereco(null, "Rua Minas Gerais", "Vila Maria", "Centro", "12209290");
		Endereco rua5724 = new Endereco(null, "Avenida Engenheiro Sebastião Gualberto", "Vila Maria", "Centro",
				"12209320");
		Endereco rua5725 = new Endereco(null, "Rua Carvalho de Araújo", "Vila Maria", "Centro", "12209390");
		Endereco rua5726 = new Endereco(null, "Praça Bicentenário", "Vila Maria", "Centro", "12209401");
		Endereco rua5727 = new Endereco(null, "Avenida Vinte e Três de Maio", "Vila Maria", "Centro", "12209410");
		Endereco rua5728 = new Endereco(null, "Praça Nene Cursino", "Vila Maria", "Centro", "12209411");
		Endereco rua5729 = new Endereco(null, "Rua São Paulo", "Vila Maria", "Centro", "12209430");
		Endereco rua5730 = new Endereco(null, "Rua Lavapés", "Vila Maria", "Centro", "12209440");
		Endereco rua5731 = new Endereco(null, "Avenida dos Estados", "Vila Maria", "Centro", "12209450");
		Endereco rua5732 = new Endereco(null, "Rua Dom Pedro II", "Vila Maria", "Centro", "12209460");
		Endereco rua5733 = new Endereco(null, "Travessa Antônio Domenico Ferro", "Vila Maria", "Centro", "12209500");
		Endereco rua5734 = new Endereco(null, "Avenida Senador Teotônio Vilela", "Vila Maria", "Centro", "12209510");
		Endereco rua5735 = new Endereco(null, "Avenida São José", " 626", "Vila Maria", "Centro");
		Endereco rua5736 = new Endereco(null, "Rua Ana Rosa", "Vila Mascarenhas Ferraz", "Centro", "12209050");
		Endereco rua5737 = new Endereco(null, "Praça Tiradentes", "Vila Mascarenhas Ferraz", "Centro", "12209061");
		Endereco rua5738 = new Endereco(null, "Rua Delfino Mascarenhas", "Vila Mascarenhas Ferraz", "Centro",
				"12209062");
		Endereco rua5739 = new Endereco(null, "Rua Helena Mascarenhas", "Vila Mascarenhas Ferraz", "Centro",
				"12209070");
		Endereco rua5740 = new Endereco(null, "Praça Antônio Joaquim de Medeiros", "Vila Mascarenhas Ferraz", "Centro",
				"12209161");
		Endereco rua5741 = new Endereco(null, "Rua Matilde da Conceição", "Vila Matilde", "Leste", "12226115");
		Endereco rua5742 = new Endereco(null, "Rua Enzo Guratti", "Vila Monte Alegre", "Norte", "12212820");
		Endereco rua5743 = new Endereco(null, "Avenida Serra Gaúcha", "Vila Monterrey", "Leste", "12226736");
		Endereco rua5744 = new Endereco(null, "Rua Canela", "Vila Monterrey", "Leste", "12226737");
		Endereco rua5745 = new Endereco(null, "Rua Gramado", "Vila Monterrey", "Leste", "12226738");
		Endereco rua5746 = new Endereco(null, "Rua Caxias do Sul", "Vila Monterrey", "Leste", "12226739");
		Endereco rua5747 = new Endereco(null, "Rua Carlos Barbosa", "Vila Monterrey", "Leste", "12226790");
		Endereco rua5748 = new Endereco(null, "Rua Monte Belo do Sul", "Vila Monterrey", "Leste", "12226791");
		Endereco rua5749 = new Endereco(null, "Rua Garibaldi", "Vila Monterrey", "Leste", "12226792");
		Endereco rua5750 = new Endereco(null, "Rua Passo Fundo", "Vila Monterrey", "Leste", "12226793");
		Endereco rua5751 = new Endereco(null, "Rua Veranopólis", "Vila Monterrey", "Leste", "12226794");
		Endereco rua5752 = new Endereco(null, "Rua Nova Pádua", "Vila Monterrey", "Leste", "12226795");
		Endereco rua5753 = new Endereco(null, "Rua Canoas", "Vila Monterrey", "Leste", "12226796");
		Endereco rua5754 = new Endereco(null, "Rua Novo Hamburgo", "Vila Monterrey", "Leste", "12226797");
		Endereco rua5755 = new Endereco(null, "Rua Erechim", "Vila Monterrey", "Leste", "12226798");
		Endereco rua5756 = new Endereco(null, "Rua Guaporé", "Vila Monterrey", "Leste", "12226799");
		Endereco rua5757 = new Endereco(null, "Avenida Porto Alegre", "Vila Monterrey", "Leste", "12226800");
		Endereco rua5758 = new Endereco(null, "Rua Nova Bréscia", "Vila Monterrey", "Leste", "12226846");
		Endereco rua5759 = new Endereco(null, "Rua Paraibuna", "Vila Nair", "Sul", "12231010");
		Endereco rua5760 = new Endereco(null, "Rua das Acácias", "Vila Nair", "Sul", "12231020");
		Endereco rua5761 = new Endereco(null, "Rua Taubaté", "Vila Nair", "Sul", "12231030");
		Endereco rua5762 = new Endereco(null, "Rua Caçapava", "Vila Nair", "Sul", "12231040");
		Endereco rua5763 = new Endereco(null, "Rua Jacareí", "Vila Nair", "Sul", "12231050");
		Endereco rua5764 = new Endereco(null, "Rua Jambeiro", "Vila Nair", "Sul", "12231060");
		Endereco rua5765 = new Endereco(null, "Rua Tremembê", "Vila Nair", "Sul", "12231070");
		Endereco rua5766 = new Endereco(null, "Avenida Marechal Henrique Teixeira Lott", "Vila Nair", "Sul",
				"12231100");
		Endereco rua5767 = new Endereco(null, "Avenida Marginal B", "Vila Nair", "Sul", "12231131");
		Endereco rua5768 = new Endereco(null, "Rua Suécia", "Vila Nair", "Sul", "12231180");
		Endereco rua5769 = new Endereco(null, "Rua Suíça", "Vila Nair", "Sul", "12231190");
		Endereco rua5770 = new Endereco(null, "Rua Santa Ana", "Vila Nair", "Sul", "12231210");
		Endereco rua5771 = new Endereco(null, "Rua Santa Branca", "Vila Nair", "Sul", "12231220");
		Endereco rua5772 = new Endereco(null, "Avenida Heitor Villa Lobos", "Vila Nair", "Sul", "12231230");
		Endereco rua5773 = new Endereco(null, "Rua Oslo", "Vila Nair", "Sul", "12231250");
		Endereco rua5774 = new Endereco(null, "Rua Helsinque", "Vila Nair", "Sul", "12231260");
		Endereco rua5775 = new Endereco(null, "Rua Amsterdan", "Vila Nair", "Sul", "12231290");
		Endereco rua5776 = new Endereco(null, "Rua Albânia", "Vila Nair", "Sul", "12231310");
		Endereco rua5777 = new Endereco(null, "Rua Romênia", "Vila Nair", "Sul", "12231320");
		Endereco rua5778 = new Endereco(null, "Praça Hungria", "Vila Nair", "Sul", "12231330");
		Endereco rua5779 = new Endereco(null, "Rua Grécia", "Vila Nair", "Sul", "12231340");
		Endereco rua5780 = new Endereco(null, "Rua Iuguslavia", "Vila Nair", "Sul", "12231350");
		Endereco rua5781 = new Endereco(null, "Rua Bulgária", "Vila Nair", "Sul", "12231360");
		Endereco rua5782 = new Endereco(null, "Rua Aparecida do Norte", "Vila Nova Conceição", "Sul", "12231080");
		Endereco rua5783 = new Endereco(null, "Rua Pindamonhangaba", "Vila Nova Conceição", "Sul", "12231090");
		Endereco rua5784 = new Endereco(null, "Rua Redenção da Serra", "Vila Nova Conceição", "Sul", "12231101");
		Endereco rua5785 = new Endereco(null, "Rua Guaratinguetá", "Vila Nova Conceição", "Sul", "12231120");
		Endereco rua5786 = new Endereco(null, "Rua Roseira", "Vila Nova Conceição", "Sul", "12231130");
		Endereco rua5787 = new Endereco(null, "Rua Lorena", "Vila Nova Conceição", "Sul", "12231240");
		Endereco rua5788 = new Endereco(null, "Rua Ana da Conceição de Souza", "Vila Nova Conceição", "Sul",
				"12231241");
		Endereco rua5789 = new Endereco(null, "Praça Terezinha Cesar da Silva", "Vila Nova Conceição", "Sul",
				"12231270");
		Endereco rua5790 = new Endereco(null, "Rua Bertolino Leite Machado", "Vila Nova São José", "Centro",
				"12209300");
		Endereco rua5791 = new Endereco(null, "Rua Felisbino Pinto da Cunha", "Vila Nova São José", "Centro",
				"12209310");
		Endereco rua5792 = new Endereco(null, "Rua Joaquim Bernardes Pereira", "Vila Nova São José", "Centro",
				"12209420");
		Endereco rua5793 = new Endereco(null, "Rua Rio Manso", "Altos da Vila Paiva", "Norte", "12213060");
		Endereco rua5794 = new Endereco(null, "Rua Rio das Cobras", "Altos da Vila Paiva", "Norte", "12213062");
		Endereco rua5795 = new Endereco(null, "Rua Rio Jaguari", "Altos da Vila Paiva", "Norte", "12213064");
		Endereco rua5796 = new Endereco(null, "Rua Ribeirão da Fartura", "Altos da Vila Paiva", "Norte", "12213066");
		Endereco rua5797 = new Endereco(null, "Rua Córrego da Ressaca", "Altos da Vila Paiva", "Norte", "12213068");
		Endereco rua5798 = new Endereco(null, "Rua Córrego do Sabão", "Altos da Vila Paiva", "Norte", "12213070");
		Endereco rua5799 = new Endereco(null, "Avenida Rio Buquira", "Altos da Vila Paiva", "Norte", "12213072");
		Endereco rua5800 = new Endereco(null, "Rua Rio Turvo", "Altos da Vila Paiva", "Norte", "12213074");
		Endereco rua5801 = new Endereco(null, "Rua Rio Pararangaba", "Altos da Vila Paiva", "Norte", "12213076");
		Endereco rua5802 = new Endereco(null, "Rua Rio do Peixe", "Altos da Vila Paiva", "Norte", "12213078");
		Endereco rua5803 = new Endereco(null, "Rua Ribeirão do Cajuru", "Altos da Vila Paiva", "Norte", "12213080");
		Endereco rua5804 = new Endereco(null, "Rua Ribeirão da Água Soca", "Altos da Vila Paiva", "Norte", "12213082");
		Endereco rua5805 = new Endereco(null, "Rua Córrego Senhorinha", "Altos da Vila Paiva", "Norte", "12213084");
		Endereco rua5806 = new Endereco(null, "Rua Córrego do Sertãozinho", "Altos da Vila Paiva", "Norte", "12213086");
		Endereco rua5807 = new Endereco(null, "Rua Ribeirão do Vidoca", "Altos da Vila Paiva", "Norte", "12213088");
		Endereco rua5808 = new Endereco(null, "Rua Ribeirão do Guirra", "Altos da Vila Paiva", "Norte", "12213090");
		Endereco rua5809 = new Endereco(null, "Rua Córrego do Cambuí", "Altos da Vila Paiva", "Norte", "12213092");
		Endereco rua5810 = new Endereco(null, "Rua Córrego do Bengalar", "Altos da Vila Paiva", "Norte", "12213094");
		Endereco rua5811 = new Endereco(null, "Rua Córrego do Roncador", "Altos da Vila Paiva", "Norte", "12213096");
		Endereco rua5812 = new Endereco(null, "Rua Córrego Santa Bárbara", "Altos da Vila Paiva", "Norte", "12213098");
		Endereco rua5813 = new Endereco(null, "Rua Rio Comprido", "Altos da Vila Paiva", "Norte", "12213100");
		Endereco rua5814 = new Endereco(null, "Rua Ribeirão do Butá", "Altos da Vila Paiva", "Norte", "12213102");
		Endereco rua5815 = new Endereco(null, "Rua Ribeirão Pau de Saia", "Altos da Vila Paiva", "Norte", "12213104");
		Endereco rua5816 = new Endereco(null, "Rua Corrégo Lava Pés", "Altos da Vila Paiva", "Norte", "12213106");
		Endereco rua5817 = new Endereco(null, "Rua Vinte e Quatro", "Altos da Vila Paiva", "Norte", "12213108");
		Endereco rua5818 = new Endereco(null, "Rua Ribeirão do Putim", "Altos da Vila Paiva", "Norte", "12213110");
		Endereco rua5819 = new Endereco(null, "Rua Córrego Taquari", "Altos da Vila Paiva", "Norte", "12213112");
		Endereco rua5820 = new Endereco(null, "Rua Ribeirão Caeté", "Altos da Vila Paiva", "Norte", "12213114");
		Endereco rua5821 = new Endereco(null, "Rua José Bonifácio de Arantes", "Vila Paiva", "Norte", "12213350");
		Endereco rua5822 = new Endereco(null, "Rua Lucia Lambertine", "Vila Paiva", "Norte", "12213360");
		Endereco rua5823 = new Endereco(null, "Rua Joelma", "Vila Paiva", "Norte", "12213370");
		Endereco rua5824 = new Endereco(null, "Rua Cordelio da Costa", "Vila Paiva", "Norte", "12213380");
		Endereco rua5825 = new Endereco(null, "Rua Boa Vista", "Vila Paiva", "Norte", "12213390");
		Endereco rua5826 = new Endereco(null, "Rua Antônio Pedro Perotti", "Vila Paiva", "Norte", "12213400");
		Endereco rua5827 = new Endereco(null, "Rua Santo Dias da Silva", "Vila Paiva", "Norte", "12213410");
		Endereco rua5828 = new Endereco(null, "Rua Noel Cardoso da Silva", "Vila Paiva", "Norte", "12213420");
		Endereco rua5829 = new Endereco(null, "Rua Maria José Machado", "Vila Paiva", "Norte", "12213430");
		Endereco rua5830 = new Endereco(null, "Rua Almenara", "Vila Paiva", "Norte", "12213440");
		Endereco rua5831 = new Endereco(null, "Rua Brasilino de Paula Ferreira", "Vila Paiva", "Norte", "12213470");
		Endereco rua5832 = new Endereco(null, "Rua Resplendor", "Vila Paiva", "Norte", "12213480");
		Endereco rua5833 = new Endereco(null, "Rua Serafim Alves de Moura", "Vila Paiva", "Norte", "12213490");
		Endereco rua5834 = new Endereco(null, "Rua Butantã", "Vila Paiva", "Norte", "12213500");
		Endereco rua5835 = new Endereco(null, "Rua Guarda-Mor", "Vila Paiva", "Norte", "12213501");
		Endereco rua5836 = new Endereco(null, "Rua João Pedro da Rocha", "Vila Paiva", "Norte", "12213502");
		Endereco rua5837 = new Endereco(null, "Rua Maria Conceição da Silva", "Vila Paiva", "Norte", "12213503");
		Endereco rua5838 = new Endereco(null, "Rua Peixinhos", "Vila Paiva", "Norte", "12213510");
		Endereco rua5839 = new Endereco(null, "Rua Três Pontas", "Vila Paiva", "Norte", "12213511");
		Endereco rua5840 = new Endereco(null, "Avenida dos Cegonheiros", "Vila Patrícia", "Leste", "12221703");
		Endereco rua5841 = new Endereco(null, "Rua Ilma Pelógia Fraga", "Vila Patrícia", "Leste", "12221706");
		Endereco rua5842 = new Endereco(null, "Rua Brazilino Adrião", "Vila Patrícia", "Leste", "12221709");
		Endereco rua5843 = new Endereco(null, "Rua Manoel Joaquim de Oliveira", "Vila Progresso", "Centro", "12215090");
		Endereco rua5844 = new Endereco(null, "Rua João Mendes Pedroso", "Vila Progresso", "Centro", "12215160");
		Endereco rua5845 = new Endereco(null, "Rua Regente Feijó", "Vila Progresso", "Centro", "12215270");
		Endereco rua5846 = new Endereco(null, "Rua Monteiro Lobato", "Vila Rangel", "Norte", "12211430");
		Endereco rua5847 = new Endereco(null, "Rua São Francisco Xavier", "Vila Rangel", "Norte", "12211440");
		Endereco rua5848 = new Endereco(null, "Travessa João Pereira Leite", "Vila Rangel", "Norte", "12211450");
		Endereco rua5849 = new Endereco(null, "Rua Tapajós", "Vila Rangel", "Norte", "12211457");
		Endereco rua5850 = new Endereco(null, "Travessa Francisca Moreira Rangel", "Vila Rangel", "Norte", "12211459");
		Endereco rua5851 = new Endereco(null, "Rua Francisca Maria de Souza", "Vila Rangel", "Norte", "12211461");
		Endereco rua5852 = new Endereco(null, "Travessa Herminio Intrieri", "Vila Rangel", "Norte", "12211463");
		Endereco rua5853 = new Endereco(null, "Rua Betim", "Vila Rica", "Sudeste", "12228080");
		Endereco rua5854 = new Endereco(null, "Rua Nepomuceno", "Vila Rica", "Sudeste", "12228090");
		Endereco rua5855 = new Endereco(null, "Rua Munhuacu", "Vila Rica", "Sudeste", "12228100");
		Endereco rua5856 = new Endereco(null, "Rua Ipatinga", "Vila Rica", "Sudeste", "12228110");
		Endereco rua5857 = new Endereco(null, "Rua Itatiaia", "Vila Rica", "Sudeste", "12228120");
		Endereco rua5858 = new Endereco(null, "Rua Turumirim", "Vila Rica", "Sudeste", "12228122");
		Endereco rua5859 = new Endereco(null, "Rua José Nunes de Paula", "Vila Rossi", "Norte", "12211030");
		Endereco rua5860 = new Endereco(null, "Rua Afonso José de Santana", "Vila Rossi", "Norte", "12211040");
		Endereco rua5861 = new Endereco(null, "Rua Miguel Eras", "Vila Rossi", "Norte", "12211050");
		Endereco rua5862 = new Endereco(null, "Travessa Benedito Venâncio Lima", "Vila Rossi", "Norte", "12211060");
		Endereco rua5863 = new Endereco(null, "Rua Engenheiro Leovigildo Trindade", "Vila Rossi", "Norte", "12211070");
		Endereco rua5864 = new Endereco(null, "Rua José Antônio Cury", "Vila Rossi", "Norte", "12211080");
		Endereco rua5865 = new Endereco(null, "Rua Tuiuti", "Vila Rossi", "Norte", "12211090");
		Endereco rua5866 = new Endereco(null, "Rua Carlos Rodrigues da Costa", "Vila Rossi", "Norte", "12211100");
		Endereco rua5867 = new Endereco(null, "Avenida Rui Barbosa", "Vila Rossi", "Norte", "12211105");
		Endereco rua5868 = new Endereco(null, "Travessa Constantino Pintos", "Vila Rossi", "Norte", "12211110");
		Endereco rua5869 = new Endereco(null, "Rua Kenkiti Shimomoto", " 401", "Vila Rossi", "Norte");
		Endereco rua5870 = new Endereco(null, "Avenida Rui Barbosa", " 688", "Vila Rossi", "Norte");
		Endereco rua5871 = new Endereco(null, "Avenida Rui Barbosa", " 1425", "Vila Rossi", "Norte");
		Endereco rua5872 = new Endereco(null, "Rua Guanahani", "Vila Rubi", "Centro", "12245090");
		Endereco rua5873 = new Endereco(null, "Praça Antilhas", "Vila Rubi", "Centro", "12245571");
		Endereco rua5874 = new Endereco(null, "Rua Pôrto Principe", "Vila Rubi", "Centro", "12245572");
		Endereco rua5875 = new Endereco(null, "Rua Havana", "Vila Rubi", "Centro", "12245573");
		Endereco rua5876 = new Endereco(null, "Rua Kingstown", "Vila Rubi", "Centro", "12245574");
		Endereco rua5877 = new Endereco(null, "Rua Anésia Nunes Matarazzo", "Vila Rubi", "Centro", "12245581");
		Endereco rua5878 = new Endereco(null, "Rua Nassau", "Vila Rubi", "Centro", "12245591");
		Endereco rua5879 = new Endereco(null, "Rua Abolição", "Vila Sanches", "Centro", "12245500");
		Endereco rua5880 = new Endereco(null, "Rua Irmã Agostinha", "Vila Sanches", "Centro", "12245502");
		Endereco rua5881 = new Endereco(null, "Rua Frei Caneca", "Vila Sanches", "Centro", "12245510");
		Endereco rua5882 = new Endereco(null, "Rua Pedro Ernesto", "Vila Sanches", "Centro", "12245520");
		Endereco rua5883 = new Endereco(null, "Rua Lupércio Antônio dos Santos", "Vila Sanches", "Centro", "12245521");
		Endereco rua5884 = new Endereco(null, "Rua Tenente Manuel Pedro de Carvalho", "Vila Santa Helena", "Centro",
				"12209060");
		Endereco rua5885 = new Endereco(null, "Rua Flávio Berling Macedo", "Vila Santa Helena", "Centro", "12209080");
		Endereco rua5886 = new Endereco(null, "Rua Belchior Dias Moréia", "Vila Santa Rita", "Centro", "12242282");
		Endereco rua5887 = new Endereco(null, "Rua Marcos de Azeredo", "Vila Santa Rita", "Centro", "12242283");
		Endereco rua5888 = new Endereco(null, "Rua Doutor Francisco de Souza", "Vila Santa Rita", "Centro", "12242290");
		Endereco rua5889 = new Endereco(null, "Rua Luiz Martins", "Vila Santa Rita", "Centro", "12242320");
		Endereco rua5890 = new Endereco(null, "Rua Brasílio Cursino", "Vila São Benedito", "Sudeste", "12227020");
		Endereco rua5891 = new Endereco(null, "Rua Jorge Martins Xavier", "Vila São Benedito", "Sudeste", "12227021");
		Endereco rua5892 = new Endereco(null, "Rua Teodomiro José da Costa", "Vila São Benedito", "Sudeste",
				"12227030");
		Endereco rua5893 = new Endereco(null, "Avenida Marginal B", "Vila São Benedito", "Sudeste", "12227040");
		Endereco rua5894 = new Endereco(null, "Rua Raul Franco Martins", "Vila São Benedito", "Sudeste", "12227050");
		Endereco rua5895 = new Endereco(null, "Praça Benedito Ugolino Silva Guerra", "Vila São Benedito", "Sudeste",
				"12227060");
		Endereco rua5896 = new Endereco(null, "Rua Edesio José de Melo", "Vila São Benedito", "Sudeste", "12227070");
		Endereco rua5897 = new Endereco(null, "Rua Cuiabá", "Vila São Bento", "Sul", "12231370");
		Endereco rua5898 = new Endereco(null, "Rua Araguaia", "Vila São Bento", "Sul", "12231380");
		Endereco rua5899 = new Endereco(null, "Rua Aporé", "Vila São Bento", "Sul", "12231390");
		Endereco rua5900 = new Endereco(null, "Rua Pelotas", "Vila São Bento", "Sul", "12231400");
		Endereco rua5901 = new Endereco(null, "Rua Ivai", "Vila São Bento", "Sul", "12231410");
		Endereco rua5902 = new Endereco(null, "Rua Iguaçu", "Vila São Bento", "Sul", "12231420");
		Endereco rua5903 = new Endereco(null, "Rua Oiapoque", "Vila São Bento", "Sul", "12231430");
		Endereco rua5904 = new Endereco(null, "Rua Aguapei", "Vila São Bento", "Sul", "12231440");
		Endereco rua5905 = new Endereco(null, "Rua Itamonte", "Vila São Bento", "Sul", "12231450");
		Endereco rua5906 = new Endereco(null, "Rua Paracatu", "Vila São Bento", "Sul", "12231460");
		Endereco rua5907 = new Endereco(null, "Rua Guarai", "Vila São Bento", "Sul", "12231470");
		Endereco rua5908 = new Endereco(null, "Rua Jacui", "Vila São Bento", "Sul", "12231480");
		Endereco rua5909 = new Endereco(null, "Rua Parnaiba", "Vila São Bento", "Sul", "12231490");
		Endereco rua5910 = new Endereco(null, "Rua Canindé", "Vila São Bento", "Sul", "12231500");
		Endereco rua5911 = new Endereco(null, "Rua Paranapanema", "Vila São Bento", "Sul", "12231510");
		Endereco rua5912 = new Endereco(null, "Rua Carinhanha", "Vila São Bento", "Sul", "12231520");
		Endereco rua5913 = new Endereco(null, "Rua Jequitinhonha", "Vila São Bento", "Sul", "12231530");
		Endereco rua5914 = new Endereco(null, "Rua Jaguaribe", "Vila São Bento", "Sul", "12231540");
		Endereco rua5915 = new Endereco(null, "Rua Solimões", "Vila São Bento", "Sul", "12231550");
		Endereco rua5916 = new Endereco(null, "Rua Xingu", "Vila São Bento", "Sul", "12231560");
		Endereco rua5917 = new Endereco(null, "Praça Grajaú", "Vila São Bento", "Sul", "12231561");
		Endereco rua5918 = new Endereco(null, "Praça Tietê", "Vila São Bento", "Sul", "12231562");
		Endereco rua5919 = new Endereco(null, "Rua Japurá", "Vila São Bento", "Sul", "12231570");
		Endereco rua5920 = new Endereco(null, "Rua Apa", "Vila São Bento", "Sul", "12231580");
		Endereco rua5921 = new Endereco(null, "Rodovia Marechal-do-Ar Casimiro Montenegro Filho", "Vila São Bento",
				"Sul", "12231590");
		Endereco rua5922 = new Endereco(null, "Rua Gurupi", "Vila São Bento", "Sul", "12231600");
		Endereco rua5923 = new Endereco(null, "Rua Um", "Vila São Bento", "Sul", "12231601");
		Endereco rua5924 = new Endereco(null, "Rua Paula M F Teixeira", "Vila São Bento", "Sul", "12231602");
		Endereco rua5925 = new Endereco(null, "Estrada Municipal Juca Carvalho", "Vila São Geraldo", "Norte",
				"12213210");
		Endereco rua5926 = new Endereco(null, "Rua Anna Ortega Traballi", "Vila São Geraldo", "Norte", "12213215");
		Endereco rua5927 = new Endereco(null, "Rua Major Manoel Fernandes Netto", "Vila São Geraldo", "Norte",
				"12213270");
		Endereco rua5928 = new Endereco(null, "Estrada Municipal Juca Carvalho", "Vila São Geraldo", "Norte",
				"12213275");
		Endereco rua5929 = new Endereco(null, "Rua Florinda Clemente Nucci", "Vila São Geraldo", "Norte", "12213280");
		Endereco rua5930 = new Endereco(null, "Rua Pureza Maria da Conceição", "Vila São Geraldo", "Norte", "12213290");
		Endereco rua5931 = new Endereco(null, "Rua João Galdino dos Santos", "Vila São Geraldo", "Norte", "12213301");
		Endereco rua5932 = new Endereco(null, "Rua Braz Alves de Almeida", "Vila São Geraldo", "Norte", "12213310");
		Endereco rua5933 = new Endereco(null, "Rua Joaquim Teodoro da Silva", "Vila São Geraldo", "Norte", "12213311");
		Endereco rua5934 = new Endereco(null, "Travessa Caeté", "Vila São Geraldo", "Norte", "12213312");
		Endereco rua5935 = new Endereco(null, "Rua Jair Firmino de Siqueira", "Vila São Geraldo", "Norte", "12213320");
		Endereco rua5936 = new Endereco(null, "Rua Geraldo Rodrigues da Costa", "Vila São Geraldo", "Norte",
				"12213340");
		Endereco rua5937 = new Endereco(null, "Rua Dilson Funaro", "Vila São Geraldo", "Norte", "12213341");
		Endereco rua5938 = new Endereco(null, "Rua Pernambuco", "Vila São Pedro", "Centro", "12215670");
		Endereco rua5939 = new Endereco(null, "Rua Maranhão", "Vila São Pedro", "Centro", "12215680");
		Endereco rua5940 = new Endereco(null, "Rua Acre", "Vila São Pedro", "Centro", "12215690");
		Endereco rua5941 = new Endereco(null, "Avenida Deputado Benedito Matarazzo", "Vila São Pedro", "Centro",
				"12215691");
		Endereco rua5942 = new Endereco(null, "Rua Rosalina Ana dos Santos", "Vila São Pedro", "Centro", "12215692");
		Endereco rua5943 = new Endereco(null, "Rua Piauí", "Vila São Pedro", "Centro", "12215700");
		Endereco rua5944 = new Endereco(null, "Rua Ceará", "Vila São Pedro", "Centro", "12215710");
		Endereco rua5945 = new Endereco(null, "Rua Rio Grande do Norte", "Vila São Pedro", "Centro", "12215720");
		Endereco rua5946 = new Endereco(null, "Rua Ceci", "Vila São Pedro", "Centro", "12215800");
		Endereco rua5947 = new Endereco(null, "Praça Diamante", "Vila São Pedro", "Centro", "12216280");
		Endereco rua5948 = new Endereco(null, "Rua Rio Grande do Sul", "Vila São Pedro", "Centro", "12216370");
		Endereco rua5949 = new Endereco(null, "Rua Espírito Santo", "Vila São Pedro", "Centro", "12216380");
		Endereco rua5950 = new Endereco(null, "Praça Paraíba", "Vila São Pedro", "Centro", "12216390");
		Endereco rua5951 = new Endereco(null, "Rua Bahia", "Vila São Pedro", "Centro", "12216400");
		Endereco rua5952 = new Endereco(null, "Rua Sergipe", "Vila São Pedro", "Centro", "12216410");
		Endereco rua5953 = new Endereco(null, "Rua Alagoas", "Vila São Pedro", "Centro", "12216420");
		Endereco rua5954 = new Endereco(null, "Rua Piraquara Clube", "Vila Sinhá", "Norte", "12212630");
		Endereco rua5955 = new Endereco(null, "Praça Dois Corações", "Vila Sinhá", "Norte", "12212631");
		Endereco rua5956 = new Endereco(null, "Rua Doutor Othon dos Santos Mercadante", "Vila Sinhá", "Norte",
				"12212650");
		Endereco rua5957 = new Endereco(null, "Rua Felipe de Oliveira", "Vila Sinhá", "Norte", "12212651");
		Endereco rua5958 = new Endereco(null, "Rua Ricardo Gonçalves", "Vila Sinhá", "Norte", "12212652");
		Endereco rua5959 = new Endereco(null, "Rua Luiz Murat", "Vila Sinhá", "Norte", "12212653");
		Endereco rua5960 = new Endereco(null, "Rua Guimarães Passos", "Vila Sinhá", "Norte", "12212654");
		Endereco rua5961 = new Endereco(null, "Rua Francisco João Leme", "Vila Sinhá", "Norte", "12212655");
		Endereco rua5962 = new Endereco(null, "Rua Paula Ney", "Vila Sinhá", "Norte", "12212656");
		Endereco rua5963 = new Endereco(null, "Rua Ângelo de Siqueira Afonso", "Vila Sinhá", "Norte", "12212657");
		Endereco rua5964 = new Endereco(null, "Rua Jaguari", "Vila Sinhá", "Norte", "12212659");
		Endereco rua5965 = new Endereco(null, "Rua dos Periquitos", "Vila Tatetuba", "Leste", "12220130");
		Endereco rua5966 = new Endereco(null, "Rua Patativa", "Vila Tatetuba", "Leste", "12220140");
		Endereco rua5967 = new Endereco(null, "Rua Sabiá", "Vila Tatetuba", "Leste", "12220150");
		Endereco rua5968 = new Endereco(null, "Rua Bem-te-vi", "Vila Tatetuba", "Leste", "12220160");
		Endereco rua5969 = new Endereco(null, "Rua das Andorinhas", "Vila Tatetuba", "Leste", "12220170");
		Endereco rua5970 = new Endereco(null, "Rua dos Canários", "Vila Tatetuba", "Leste", "12220180");
		Endereco rua5971 = new Endereco(null, "Praça Uirapuru", "Vila Tatetuba", "Leste", "12220190");
		Endereco rua5972 = new Endereco(null, "Rua Graúna", "Vila Tatetuba", "Leste", "12220200");
		Endereco rua5973 = new Endereco(null, "Praça das Gaivotas", "Vila Tatetuba", "Leste", "12220220");
		Endereco rua5974 = new Endereco(null, "Rua Juriti", "Vila Tatetuba", "Leste", "12220230");
		Endereco rua5975 = new Endereco(null, "Rua dos Tucanos", "Vila Tatetuba", "Leste", "12220240");
		Endereco rua5976 = new Endereco(null, "Rua Arapongas", "Vila Tatetuba", "Leste", "12220250");
		Endereco rua5977 = new Endereco(null, "Rua das Araras", "Vila Tatetuba", "Leste", "12220260");
		Endereco rua5978 = new Endereco(null, "Rua dos Pardais", "Vila Tatetuba", "Leste", "12220600");
		Endereco rua5979 = new Endereco(null, "Rua dos Paturis", "Vila Tatetuba", "Leste", "12220601");
		Endereco rua5980 = new Endereco(null, "Avenida Deputado Benedito Matarazzo", "Vila Tatetuba", "Leste",
				"12220610");
		Endereco rua5981 = new Endereco(null, "Rodovia Presidente Dutra", "Vila Tatetuba", "Leste", "12220611");
		Endereco rua5982 = new Endereco(null, "Rua dos Flamingos", "Vila Tatetuba", "Leste", "12220620");
		Endereco rua5983 = new Endereco(null, "Rua dos Pintassilgos", "Vila Tatetuba", "Leste", "12220630");
		Endereco rua5984 = new Endereco(null, "Rua dos Colibris", "Vila Tatetuba", "Leste", "12220640");
		Endereco rua5985 = new Endereco(null, "Rua Jandaia", "Vila Tatetuba", "Leste", "12220650");
		Endereco rua5986 = new Endereco(null, "Rua Patativa", " 200", "Vila Tatetuba", "Leste");
		Endereco rua5987 = new Endereco(null, "Viaduto Francisco Pereira", "Vila Terezinha", "Centro", "12209670");
		Endereco rua5988 = new Endereco(null, "Rua Maceió", "Vila Terezinha", "Centro", "12209675");
		Endereco rua5989 = new Endereco(null, "Praça Doutor José de Moura Resende", "Vila Terezinha", "Centro",
				"12209680");
		Endereco rua5990 = new Endereco(null, "Rua Belém", "Vila Terezinha", "Centro", "12209685");
		Endereco rua5991 = new Endereco(null, "Rua Curitiba", "Vila Terezinha", "Centro", "12209690");
		Endereco rua5992 = new Endereco(null, "Rua Aracajú", "Vila Terezinha", "Centro", "12209695");
		Endereco rua5993 = new Endereco(null, "Rua Recife", "Vila Terezinha", "Centro", "12209700");
		Endereco rua5994 = new Endereco(null, "Rua Manaus", "Vila Terezinha", "Centro", "12209705");
		Endereco rua5995 = new Endereco(null, "Rua Projetada Dois", "Vila Tesouro", "Leste", "12221411");
		Endereco rua5996 = new Endereco(null, "Rua Três", "Vila Tesouro", "Leste", "12221412");
		Endereco rua5997 = new Endereco(null, "Rua Joaquim Bagunha Maldos", "Vila Tesouro", "Leste", "12221420");
		Endereco rua5998 = new Endereco(null, "Rua Lupércio da Costa Machado", "Vila Tesouro", "Leste", "12221430");
		Endereco rua5999 = new Endereco(null, "Rua Célio Santos", "Vila Tesouro", "Leste", "12221440");
		Endereco rua6000 = new Endereco(null, "Praça Assis Chateaubriand", "Vila Tesouro", "Leste", "12221450");
		Endereco rua6001 = new Endereco(null, "Rua Antônio Marchetti", "Vila Tesouro", "Leste", "12221460");
		Endereco rua6002 = new Endereco(null, "Rua Doutor José de Moura Resende", "Vila Tesouro", "Leste", "12221470");
		Endereco rua6003 = new Endereco(null, "Rua Francisco Nunes de Assis", "Vila Tesouro", "Leste", "12221480");
		Endereco rua6004 = new Endereco(null, "Rua José Cândido Ferreira", "Vila Tesouro", "Leste", "12221490");
		Endereco rua6005 = new Endereco(null, "Estrada Municipal Martins Guimarães", "Vila Tesouro", "Leste",
				"12221520");
		Endereco rua6006 = new Endereco(null, "Rua Professora Maria Siqueira Nathan", "Vila Tesouro", "Leste",
				"12221521");
		Endereco rua6007 = new Endereco(null, "Rua Napoleão Monteiro", "Vila Tesouro", "Leste", "12221530");
		Endereco rua6008 = new Endereco(null, "Rua Vicente Celestino", "Vila Tesouro", "Leste", "12221540");
		Endereco rua6009 = new Endereco(null, "Rua Lamartine Babo", "Vila Tesouro", "Leste", "12221550");
		Endereco rua6010 = new Endereco(null, "Rua Vitório Carnevalli", "Vila Tesouro", "Leste", "12221560");
		Endereco rua6011 = new Endereco(null, "Rua Quatro", "Vila Tesouro", "Leste", "12221841");
		Endereco rua6012 = new Endereco(null, "Rua Leonídia Damasceno Veneziani", "Vila Unidos", "Norte", "12214501");
		Endereco rua6013 = new Endereco(null, "Rua Geraldo Machado da Silva", "Vila Unidos", "Norte", "12214502");
		Endereco rua6014 = new Endereco(null, "Rua Margarida Trindade Machado", "Vila Unidos", "Norte", "12214503");
		Endereco rua6015 = new Endereco(null, "Rua Geraldo Messias", "Vila Unidos", "Norte", "12214504");
		Endereco rua6016 = new Endereco(null, "Rua Jaguari", "Vila Unidos", "Norte", "12214505");
		Endereco rua6017 = new Endereco(null, "Rua João Grill", "Vila Unidos", "Norte", "12214506");
		Endereco rua6018 = new Endereco(null, "Rua José Alves de Souza", "Vila Unidos", "Norte", "12214508");
		Endereco rua6019 = new Endereco(null, "Estrada Santo Agostinho", "Vila Unidos", "Norte", "12214511");
		Endereco rua6020 = new Endereco(null, "Rua dos Coqueiros", "Vila Unidos", "Norte", "12214512");
		Endereco rua6021 = new Endereco(null, "Rua Afrânio de Paiva Delgado", "Vila Veneziani", "Norte", "12212350");
		Endereco rua6022 = new Endereco(null, "Rua Deputado Fernando Ferrari", "Vila Veneziani", "Norte", "12212360");
		Endereco rua6023 = new Endereco(null, "Rua Independência", "Vila Veneziani", "Norte", "12212370");
		Endereco rua6024 = new Endereco(null, "Rua da Constituinte", "Vila Veneziani", "Norte", "12212380");
		Endereco rua6025 = new Endereco(null, "Rua Manoel Rosendo de Oliveira", "Vila Veneziani", "Norte", "12212400");
		Endereco rua6026 = new Endereco(null, "Rua Elias da Cunha Melo", "Vila Veneziani", "Norte", "12212580");
		Endereco rua6027 = new Endereco(null, "Praça Padre Geraldo Ribeiro da Costa", "Vila Veneziani", "Norte",
				"12212590");
		Endereco rua6028 = new Endereco(null, "Rua Anselmo Carnevalli", "Vila Veneziani", "Norte", "12212610");
		Endereco rua6029 = new Endereco(null, "Avenida Rui Barbosa", "Vila Zizinha", "Norte", "12211005");
		Endereco rua6030 = new Endereco(null, "Rua Antero Madureira", "Vila Zizinha", "Norte", "12211010");
		Endereco rua6031 = new Endereco(null, "Rua Kenkiti Shimomoto", "Vila Zizinha", "Norte", "12211020");
		Endereco rua6032 = new Endereco(null, "Rua José Maria Monteiro", "Vila Zizinha", "Norte", "12211021");
		Endereco rua6033 = new Endereco(null, "Rua Xingu", "Vila São Bento", "Sul", "12231560");

		endRepository.saveAll(Arrays.asList(rua4500, rua4501, rua4502, rua4503, rua4504, rua4505, rua4506, rua4507,
				rua4508, rua4509, rua4510, rua4511, rua4512, rua4513, rua4514, rua4515, rua4516, rua4517, rua4518,
				rua4519, rua4520, rua4521, rua4522, rua4523, rua4524, rua4525, rua4526, rua4527, rua4528, rua4529,
				rua4530, rua4531, rua4532, rua4533, rua4534, rua4535, rua4536, rua4537, rua4538, rua4539, rua4540,
				rua4541, rua4542, rua4543, rua4544, rua4545, rua4546, rua4547, rua4548, rua4549, rua4550, rua4551,
				rua4552, rua4553, rua4554, rua4555, rua4556, rua4557, rua4558, rua4559, rua4560, rua4561, rua4562,
				rua4563, rua4564, rua4565, rua4566, rua4567, rua4568, rua4569, rua4570, rua4571, rua4572, rua4573,
				rua4574, rua4575, rua4576, rua4577, rua4578, rua4579, rua4580, rua4581, rua4582, rua4583, rua4584,
				rua4585, rua4586, rua4587, rua4588, rua4589, rua4590, rua4591, rua4592, rua4593, rua4594, rua4595,
				rua4596, rua4597, rua4598, rua4599, rua4600, rua4601, rua4602, rua4603, rua4604, rua4605, rua4606,
				rua4607, rua4608, rua4609, rua4610, rua4611, rua4612, rua4613, rua4614, rua4615, rua4616, rua4617,
				rua4618, rua4619, rua4620, rua4621, rua4622, rua4623, rua4624, rua4625, rua4626, rua4627, rua4628,
				rua4629, rua4630, rua4631, rua4632, rua4633, rua4634, rua4635, rua4636, rua4637, rua4638, rua4639,
				rua4640, rua4641, rua4642, rua4643, rua4644, rua4645, rua4646, rua4647, rua4648, rua4649, rua4650,
				rua4651, rua4652, rua4653, rua4654, rua4655, rua4656, rua4657, rua4658, rua4659, rua4660, rua4661,
				rua4662, rua4663, rua4664, rua4665, rua4666, rua4667, rua4668, rua4669, rua4670, rua4671, rua4672,
				rua4673, rua4674, rua4675, rua4676, rua4677, rua4678, rua4679, rua4680, rua4681, rua4682, rua4683,
				rua4684, rua4685, rua4686, rua4687, rua4688, rua4689, rua4690, rua4691, rua4692, rua4693, rua4694,
				rua4695, rua4696, rua4697, rua4698, rua4699, rua4700, rua4701, rua4702, rua4703, rua4704, rua4705,
				rua4706, rua4707, rua4708, rua4709, rua4710, rua4711, rua4712, rua4713, rua4714, rua4715, rua4716,
				rua4717, rua4718, rua4719, rua4720, rua4721, rua4722, rua4723, rua4724, rua4725, rua4726, rua4727,
				rua4728, rua4729, rua4730, rua4731, rua4732, rua4733, rua4734, rua4735, rua4736, rua4737, rua4738,
				rua4739, rua4740, rua4741, rua4742, rua4743, rua4744, rua4745, rua4746, rua4747, rua4748, rua4749,
				rua4750, rua4751, rua4752, rua4753, rua4754, rua4755, rua4756, rua4757, rua4758, rua4759, rua4760,
				rua4761, rua4762, rua4763, rua4764, rua4765, rua4766, rua4767, rua4768, rua4769, rua4770, rua4771,
				rua4772, rua4773, rua4774, rua4775, rua4776, rua4777, rua4778, rua4779, rua4780, rua4781, rua4782,
				rua4783, rua4784, rua4785, rua4786, rua4787, rua4788, rua4789, rua4790, rua4791, rua4792, rua4793,
				rua4794, rua4795, rua4796, rua4797, rua4798, rua4799, rua4800, rua4801, rua4802, rua4803, rua4804,
				rua4805, rua4806, rua4807, rua4808, rua4809, rua4810, rua4811, rua4812, rua4813, rua4814, rua4815,
				rua4816, rua4817, rua4818, rua4819, rua4820, rua4821, rua4822, rua4823, rua4824, rua4825, rua4826,
				rua4827, rua4828, rua4829, rua4830, rua4831, rua4832, rua4833, rua4834, rua4835, rua4836, rua4837,
				rua4838, rua4839, rua4840, rua4841, rua4842, rua4843, rua4844, rua4845, rua4846, rua4847, rua4848,
				rua4849, rua4850, rua4851, rua4852, rua4853, rua4854, rua4855, rua4856, rua4857, rua4858, rua4859,
				rua4860, rua4861, rua4862, rua4863, rua4864, rua4865, rua4866, rua4867, rua4868, rua4869, rua4870,
				rua4871, rua4872, rua4873, rua4874, rua4875, rua4876, rua4877, rua4878, rua4879, rua4880, rua4881,
				rua4882, rua4883, rua4884, rua4885, rua4886, rua4887, rua4888, rua4889, rua4890, rua4891, rua4892,
				rua4893, rua4894, rua4895, rua4896, rua4897, rua4898, rua4899, rua4900, rua4901, rua4902, rua4903,
				rua4904, rua4905, rua4906, rua4907, rua4908, rua4909, rua4910, rua4911, rua4912, rua4913, rua4914,
				rua4915, rua4916, rua4917, rua4918, rua4919, rua4920, rua4921, rua4922, rua4923, rua4924, rua4925,
				rua4926, rua4927, rua4928, rua4929, rua4930, rua4931, rua4932, rua4933, rua4934, rua4935, rua4936,
				rua4937, rua4938, rua4939, rua4940, rua4941, rua4942, rua4943, rua4944, rua4945, rua4946, rua4947,
				rua4948, rua4949, rua4950, rua4951, rua4952, rua4953, rua4954, rua4955, rua4956, rua4957, rua4958,
				rua4959, rua4960, rua4961, rua4962, rua4963, rua4964, rua4965, rua4966, rua4967, rua4968, rua4969,
				rua4970, rua4971, rua4972, rua4973, rua4974, rua4975, rua4976, rua4977, rua4978, rua4979, rua4980,
				rua4981, rua4982, rua4983, rua4984, rua4985, rua4986, rua4987, rua4988, rua4989, rua4990, rua4991,
				rua4992, rua4993, rua4994, rua4995, rua4996, rua4997, rua4998, rua4999, rua5000, rua5001, rua5002,
				rua5003, rua5004, rua5005, rua5006, rua5007, rua5008, rua5009, rua5010, rua5011, rua5012, rua5013,
				rua5014, rua5015, rua5016, rua5017, rua5018, rua5019, rua5020, rua5021, rua5022, rua5023, rua5024,
				rua5025, rua5026, rua5027, rua5028, rua5029, rua5030, rua5031, rua5032, rua5033, rua5034, rua5035,
				rua5036, rua5037, rua5038, rua5039, rua5040, rua5041, rua5042, rua5043, rua5044, rua5045, rua5046,
				rua5047, rua5048, rua5049, rua5050, rua5051, rua5052, rua5053, rua5054, rua5055, rua5056, rua5057,
				rua5058, rua5059, rua5060, rua5061, rua5062, rua5063, rua5064, rua5065, rua5066, rua5067, rua5068,
				rua5069, rua5070, rua5071, rua5072, rua5073, rua5074, rua5075, rua5076, rua5077, rua5078, rua5079,
				rua5080, rua5081, rua5082, rua5083, rua5084, rua5085, rua5086, rua5087, rua5088, rua5089, rua5090,
				rua5091, rua5092, rua5093, rua5094, rua5095, rua5096, rua5097, rua5098, rua5099, rua5100, rua5101,
				rua5102, rua5103, rua5104, rua5105, rua5106, rua5107, rua5108, rua5109, rua5110, rua5111, rua5112,
				rua5113, rua5114, rua5115, rua5116, rua5117, rua5118, rua5119, rua5120, rua5121, rua5122, rua5123,
				rua5124, rua5125, rua5126, rua5127, rua5128, rua5129, rua5130, rua5131, rua5132, rua5133, rua5134,
				rua5135, rua5136, rua5137, rua5138, rua5139, rua5140, rua5141, rua5142, rua5143, rua5144, rua5145,
				rua5146, rua5147, rua5148, rua5149, rua5150, rua5151, rua5152, rua5153, rua5154, rua5155, rua5156,
				rua5157, rua5158, rua5159, rua5160, rua5161, rua5162, rua5163, rua5164, rua5165, rua5166, rua5167,
				rua5168, rua5169, rua5170, rua5171, rua5172, rua5173, rua5174, rua5175, rua5176, rua5177, rua5178,
				rua5179, rua5180, rua5181, rua5182, rua5183, rua5184, rua5185, rua5186, rua5187, rua5188, rua5189,
				rua5190, rua5191, rua5192, rua5193, rua5194, rua5195, rua5196, rua5197, rua5198, rua5199, rua5200,
				rua5201, rua5202, rua5203, rua5204, rua5205, rua5206, rua5207, rua5208, rua5209, rua5210, rua5211,
				rua5212, rua5213, rua5214, rua5215, rua5216, rua5217, rua5218, rua5219, rua5220, rua5221, rua5222,
				rua5223, rua5224, rua5225, rua5226, rua5227, rua5228, rua5229, rua5230, rua5231, rua5232, rua5233,
				rua5234, rua5235, rua5236, rua5237, rua5238, rua5239, rua5240, rua5241, rua5242, rua5243, rua5244,
				rua5245, rua5246, rua5247, rua5248, rua5249, rua5250, rua5251, rua5252, rua5253, rua5254, rua5255,
				rua5256, rua5257, rua5258, rua5259, rua5260, rua5261, rua5262, rua5263, rua5264, rua5265, rua5266,
				rua5267, rua5268, rua5269, rua5270, rua5271, rua5272, rua5273, rua5274, rua5275, rua5276, rua5277,
				rua5278, rua5279, rua5280, rua5281, rua5282, rua5283, rua5284, rua5285, rua5286, rua5287, rua5288,
				rua5289, rua5290, rua5291, rua5292, rua5293, rua5294, rua5295, rua5296, rua5297, rua5298, rua5299,
				rua5300, rua5301, rua5302, rua5303, rua5304, rua5305, rua5306, rua5307, rua5308, rua5309, rua5310,
				rua5311, rua5312, rua5313, rua5314, rua5315, rua5316, rua5317, rua5318, rua5319, rua5320, rua5321,
				rua5322, rua5323, rua5324, rua5325, rua5326, rua5327, rua5328, rua5329, rua5330, rua5331, rua5332,
				rua5333, rua5334, rua5335, rua5336, rua5337, rua5338, rua5339, rua5340, rua5341, rua5342, rua5343,
				rua5344, rua5345, rua5346, rua5347, rua5348, rua5349, rua5350, rua5351, rua5352, rua5353, rua5354,
				rua5355, rua5356, rua5357, rua5358, rua5359, rua5360, rua5361, rua5362, rua5363, rua5364, rua5365,
				rua5366, rua5367, rua5368, rua5369, rua5370, rua5371, rua5372, rua5373, rua5374, rua5375, rua5376,
				rua5377, rua5378, rua5379, rua5380, rua5381, rua5382, rua5383, rua5384, rua5385, rua5386, rua5387,
				rua5388, rua5389, rua5390, rua5391, rua5392, rua5393, rua5394, rua5395, rua5396, rua5397, rua5398,
				rua5399, rua5400, rua5401, rua5402, rua5403, rua5404, rua5405, rua5406, rua5407, rua5408, rua5409,
				rua5410, rua5411, rua5412, rua5413, rua5414, rua5415, rua5416, rua5417, rua5418, rua5419, rua5420,
				rua5421, rua5422, rua5423, rua5424, rua5425, rua5426, rua5427, rua5428, rua5429, rua5430, rua5431,
				rua5432, rua5433, rua5434, rua5435, rua5436, rua5437, rua5438, rua5439, rua5440, rua5441, rua5442,
				rua5443, rua5444, rua5445, rua5446, rua5447, rua5448, rua5449, rua5450, rua5451, rua5452, rua5453,
				rua5454, rua5455, rua5456, rua5457, rua5458, rua5459, rua5460, rua5461, rua5462, rua5463, rua5464,
				rua5465, rua5466, rua5467, rua5468, rua5469, rua5470, rua5471, rua5472, rua5473, rua5474, rua5475,
				rua5476, rua5477, rua5478, rua5479, rua5480, rua5481, rua5482, rua5483, rua5484, rua5485, rua5486,
				rua5487, rua5488, rua5489, rua5490, rua5491, rua5492, rua5493, rua5494, rua5495, rua5496, rua5497,
				rua5498, rua5499, rua5500, rua5501, rua5502, rua5503, rua5504, rua5505, rua5506, rua5507, rua5508,
				rua5509, rua5510, rua5511, rua5512, rua5513, rua5514, rua5515, rua5516, rua5517, rua5518, rua5519,
				rua5520, rua5521, rua5522, rua5523, rua5524, rua5525, rua5526, rua5527, rua5528, rua5529, rua5530,
				rua5531, rua5532, rua5533, rua5534, rua5535, rua5536, rua5537, rua5538, rua5539, rua5540, rua5541,
				rua5542, rua5543, rua5544, rua5545, rua5546, rua5547, rua5548, rua5549, rua5550, rua5551, rua5552,
				rua5553, rua5554, rua5555, rua5556, rua5557, rua5558, rua5559, rua5560, rua5561, rua5562, rua5563,
				rua5564, rua5565, rua5566, rua5567, rua5568, rua5569, rua5570, rua5571, rua5572, rua5573, rua5574,
				rua5575, rua5576, rua5577, rua5578, rua5579, rua5580, rua5581, rua5582, rua5583, rua5584, rua5585,
				rua5586, rua5587, rua5588, rua5589, rua5590, rua5591, rua5592, rua5593, rua5594, rua5595, rua5596,
				rua5597, rua5598, rua5599, rua5600, rua5601, rua5602, rua5603, rua5604, rua5605, rua5606, rua5607,
				rua5608, rua5609, rua5610, rua5611, rua5612, rua5613, rua5614, rua5615, rua5616, rua5617, rua5618,
				rua5619, rua5620, rua5621, rua5622, rua5623, rua5624, rua5625, rua5626, rua5627, rua5628, rua5629,
				rua5630, rua5631, rua5632, rua5633, rua5634, rua5635, rua5636, rua5637, rua5638, rua5639, rua5640,
				rua5641, rua5642, rua5643, rua5644, rua5645, rua5646, rua5647, rua5648, rua5649, rua5650, rua5651,
				rua5652, rua5653, rua5654, rua5655, rua5656, rua5657, rua5658, rua5659, rua5660, rua5661, rua5662,
				rua5663, rua5664, rua5665, rua5666, rua5667, rua5668, rua5669, rua5670, rua5671, rua5672, rua5673,
				rua5674, rua5675, rua5676, rua5677, rua5678, rua5679, rua5680, rua5681, rua5682, rua5683, rua5684,
				rua5685, rua5686, rua5687, rua5688, rua5689, rua5690, rua5691, rua5692, rua5693, rua5694, rua5695,
				rua5696, rua5697, rua5698, rua5699, rua5700, rua5701, rua5702, rua5703, rua5704, rua5705, rua5706,
				rua5707, rua5708, rua5709, rua5710, rua5711, rua5712, rua5713, rua5714, rua5715, rua5716, rua5717,
				rua5718, rua5719, rua5720, rua5721, rua5722, rua5723, rua5724, rua5725, rua5726, rua5727, rua5728,
				rua5729, rua5730, rua5731, rua5732, rua5733, rua5734, rua5735, rua5736, rua5737, rua5738, rua5739,
				rua5740, rua5741, rua5742, rua5743, rua5744, rua5745, rua5746, rua5747, rua5748, rua5749, rua5750,
				rua5751, rua5752, rua5753, rua5754, rua5755, rua5756, rua5757, rua5758, rua5759, rua5760, rua5761,
				rua5762, rua5763, rua5764, rua5765, rua5766, rua5767, rua5768, rua5769, rua5770, rua5771, rua5772,
				rua5773, rua5774, rua5775, rua5776, rua5777, rua5778, rua5779, rua5780, rua5781, rua5782, rua5783,
				rua5784, rua5785, rua5786, rua5787, rua5788, rua5789, rua5790, rua5791, rua5792, rua5793, rua5794,
				rua5795, rua5796, rua5797, rua5798, rua5799, rua5800, rua5801, rua5802, rua5803, rua5804, rua5805,
				rua5806, rua5807, rua5808, rua5809, rua5810, rua5811, rua5812, rua5813, rua5814, rua5815, rua5816,
				rua5817, rua5818, rua5819, rua5820, rua5821, rua5822, rua5823, rua5824, rua5825, rua5826, rua5827,
				rua5828, rua5829, rua5830, rua5831, rua5832, rua5833, rua5834, rua5835, rua5836, rua5837, rua5838,
				rua5839, rua5840, rua5841, rua5842, rua5843, rua5844, rua5845, rua5846, rua5847, rua5848, rua5849,
				rua5850, rua5851, rua5852, rua5853, rua5854, rua5855, rua5856, rua5857, rua5858, rua5859, rua5860,
				rua5861, rua5862, rua5863, rua5864, rua5865, rua5866, rua5867, rua5868, rua5869, rua5870, rua5871,
				rua5872, rua5873, rua5874, rua5875, rua5876, rua5877, rua5878, rua5879, rua5880, rua5881, rua5882,
				rua5883, rua5884, rua5885, rua5886, rua5887, rua5888, rua5889, rua5890, rua5891, rua5892, rua5893,
				rua5894, rua5895, rua5896, rua5897, rua5898, rua5899, rua5900, rua5901, rua5902, rua5903, rua5904,
				rua5905, rua5906, rua5907, rua5908, rua5909, rua5910, rua5911, rua5912, rua5913, rua5914, rua5915,
				rua5916, rua5917, rua5918, rua5919, rua5920, rua5921, rua5922, rua5923, rua5924, rua5925, rua5926,
				rua5927, rua5928, rua5929, rua5930, rua5931, rua5932, rua5933, rua5934, rua5935, rua5936, rua5937,
				rua5938, rua5939, rua5940, rua5941, rua5942, rua5943, rua5944, rua5945, rua5946, rua5947, rua5948,
				rua5949, rua5950, rua5951, rua5952, rua5953, rua5954, rua5955, rua5956, rua5957, rua5958, rua5959,
				rua5960, rua5961, rua5962, rua5963, rua5964, rua5965, rua5966, rua5967, rua5968, rua5969, rua5970,
				rua5971, rua5972, rua5973, rua5974, rua5975, rua5976, rua5977, rua5978, rua5979, rua5980, rua5981,
				rua5982, rua5983, rua5984, rua5985, rua5986, rua5987, rua5988, rua5989, rua5990, rua5991, rua5992,
				rua5993, rua5994, rua5995, rua5996, rua5997, rua5998, rua5999, rua6000, rua6001, rua6002, rua6003,
				rua6004, rua6005, rua6006, rua6007, rua6008, rua6009, rua6010, rua6011, rua6012, rua6013, rua6014,
				rua6015, rua6016, rua6017, rua6018, rua6019, rua6020, rua6021, rua6022, rua6023, rua6024, rua6025,
				rua6026, rua6027, rua6028, rua6029, rua6030, rua6031, rua6032, rua6033));

	}

}
