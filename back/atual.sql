--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-11-26 19:55:53

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2395 (class 0 OID 0)
-- Dependencies: 2394
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 1 (class 3079 OID 12278)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2397 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 209 (class 1259 OID 16614)
-- Name: caixa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.caixa (
    id integer NOT NULL,
    status boolean,
    numero integer,
    valor_abertura double precision,
    valor_fechamento double precision,
    lucro_diario double precision,
    data character varying(10)
);


ALTER TABLE public.caixa OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16612)
-- Name: caixa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.caixa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.caixa_id_seq OWNER TO postgres;

--
-- TOC entry 2398 (class 0 OID 0)
-- Dependencies: 208
-- Name: caixa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.caixa_id_seq OWNED BY public.caixa.id;


--
-- TOC entry 227 (class 1259 OID 16791)
-- Name: consulta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.consulta (
    id integer NOT NULL,
    tipo character varying(30),
    agendamento boolean,
    id_paciente integer,
    id_medico integer,
    id_consultorio integer,
    id_pagamento integer,
    data_hora character varying(20)
);


ALTER TABLE public.consulta OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 16789)
-- Name: consulta_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.consulta_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.consulta_id_seq OWNER TO postgres;

--
-- TOC entry 2399 (class 0 OID 0)
-- Dependencies: 226
-- Name: consulta_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.consulta_id_seq OWNED BY public.consulta.id;


--
-- TOC entry 215 (class 1259 OID 16657)
-- Name: consultorio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.consultorio (
    id integer NOT NULL,
    nome_fantasia character varying(30),
    razao_social character varying(30),
    cnpj character varying(12),
    id_endereco integer,
    id_contato integer
);


ALTER TABLE public.consultorio OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16655)
-- Name: consultorio_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.consultorio_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.consultorio_id_seq OWNER TO postgres;

--
-- TOC entry 2400 (class 0 OID 0)
-- Dependencies: 214
-- Name: consultorio_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.consultorio_id_seq OWNED BY public.consultorio.id;


--
-- TOC entry 233 (class 1259 OID 25094)
-- Name: contato; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contato (
    id integer NOT NULL,
    email character varying(50),
    telefone character varying(20),
    celular character varying(20)
);


ALTER TABLE public.contato OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 25092)
-- Name: contato_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contato_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contato_id_seq OWNER TO postgres;

--
-- TOC entry 2401 (class 0 OID 0)
-- Dependencies: 232
-- Name: contato_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.contato_id_seq OWNED BY public.contato.id;


--
-- TOC entry 211 (class 1259 OID 16622)
-- Name: endereco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.endereco (
    id integer NOT NULL,
    cep character varying(10),
    rua character varying(30),
    bairro character varying(50),
    numero character varying(5),
    municipio character varying(30),
    estado character varying(3)
);


ALTER TABLE public.endereco OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16620)
-- Name: endereco_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.endereco_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.endereco_id_seq OWNER TO postgres;

--
-- TOC entry 2402 (class 0 OID 0)
-- Dependencies: 210
-- Name: endereco_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.endereco_id_seq OWNED BY public.endereco.id;


--
-- TOC entry 219 (class 1259 OID 16691)
-- Name: especializacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.especializacao (
    id integer NOT NULL,
    descricao character varying(100),
    salario double precision,
    id_medico integer,
    horario_disponivel character varying(5)
);


ALTER TABLE public.especializacao OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16689)
-- Name: especializacao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.especializacao_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.especializacao_id_seq OWNER TO postgres;

--
-- TOC entry 2403 (class 0 OID 0)
-- Dependencies: 218
-- Name: especializacao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.especializacao_id_seq OWNED BY public.especializacao.id;


--
-- TOC entry 201 (class 1259 OID 16461)
-- Name: estoque; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estoque (
    id integer NOT NULL,
    descricao character varying(255),
    id_consultorio integer
);


ALTER TABLE public.estoque OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16459)
-- Name: estoque_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estoque_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estoque_id_seq OWNER TO postgres;

--
-- TOC entry 2404 (class 0 OID 0)
-- Dependencies: 200
-- Name: estoque_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estoque_id_seq OWNED BY public.estoque.id;


--
-- TOC entry 205 (class 1259 OID 16549)
-- Name: fornecedor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fornecedor (
    id integer NOT NULL,
    nome_fantasia character varying(20),
    razao_social character varying(20),
    cnpj character varying(12),
    id_endereco integer,
    id_contato integer
);


ALTER TABLE public.fornecedor OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16547)
-- Name: fornecedor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.fornecedor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.fornecedor_id_seq OWNER TO postgres;

--
-- TOC entry 2405 (class 0 OID 0)
-- Dependencies: 204
-- Name: fornecedor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.fornecedor_id_seq OWNED BY public.fornecedor.id;


--
-- TOC entry 197 (class 1259 OID 16414)
-- Name: funcionario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.funcionario (
    id integer NOT NULL,
    nome character varying(30),
    id_caixa integer NOT NULL,
    cpf character varying(14) NOT NULL,
    salario double precision NOT NULL,
    funcao character varying(25),
    data_nascimento character varying(10),
    id_login integer,
    id_endereco integer,
    id_contato integer
);


ALTER TABLE public.funcionario OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16412)
-- Name: funcionario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.funcionario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.funcionario_id_seq OWNER TO postgres;

--
-- TOC entry 2406 (class 0 OID 0)
-- Dependencies: 196
-- Name: funcionario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.funcionario_id_seq OWNED BY public.funcionario.id;


--
-- TOC entry 229 (class 1259 OID 16824)
-- Name: login; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.login (
    id integer NOT NULL,
    usuario character varying(10),
    senha character varying(10)
);


ALTER TABLE public.login OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 16822)
-- Name: login_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.login_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.login_id_seq OWNER TO postgres;

--
-- TOC entry 2407 (class 0 OID 0)
-- Dependencies: 228
-- Name: login_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.login_id_seq OWNED BY public.login.id;


--
-- TOC entry 217 (class 1259 OID 16678)
-- Name: medico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.medico (
    id integer NOT NULL,
    nome character varying(50),
    sexo character varying(10),
    rg integer,
    id_consultorio integer,
    cpf character varying(14),
    data_nascimento character varying(10),
    data_cadastro character varying(10),
    id_login integer,
    id_endereco integer,
    id_contato integer
);


ALTER TABLE public.medico OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16676)
-- Name: medico_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.medico_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.medico_id_seq OWNER TO postgres;

--
-- TOC entry 2408 (class 0 OID 0)
-- Dependencies: 216
-- Name: medico_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.medico_id_seq OWNED BY public.medico.id;


--
-- TOC entry 213 (class 1259 OID 16644)
-- Name: paciente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.paciente (
    id integer NOT NULL,
    nome character varying(50),
    cpf character varying(14),
    sexo character varying(9),
    data_nascimento character varying(10),
    data_cadastro character varying(10),
    rg integer,
    id_prontuario integer,
    id_endereco integer,
    id_contato integer,
    convenio character varying(20)
);


ALTER TABLE public.paciente OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16642)
-- Name: paciente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.paciente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.paciente_id_seq OWNER TO postgres;

--
-- TOC entry 2409 (class 0 OID 0)
-- Dependencies: 212
-- Name: paciente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.paciente_id_seq OWNED BY public.paciente.id;


--
-- TOC entry 223 (class 1259 OID 16722)
-- Name: pagamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pagamento (
    id integer NOT NULL,
    valor_total double precision,
    status boolean,
    forma_pagamento character varying(10),
    quantidade_parcelas integer,
    id_caixa integer,
    data_vencimento character varying(10)
);


ALTER TABLE public.pagamento OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16720)
-- Name: pagamento_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pagamento_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pagamento_id_seq OWNER TO postgres;

--
-- TOC entry 2410 (class 0 OID 0)
-- Dependencies: 222
-- Name: pagamento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pagamento_id_seq OWNED BY public.pagamento.id;


--
-- TOC entry 225 (class 1259 OID 16735)
-- Name: parcela; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.parcela (
    id integer NOT NULL,
    valor double precision,
    status boolean,
    numero integer,
    parcela_unica boolean,
    id_pagamento integer,
    data_vencimento character varying(10)
);


ALTER TABLE public.parcela OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16733)
-- Name: parcela_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.parcela_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.parcela_id_seq OWNER TO postgres;

--
-- TOC entry 2411 (class 0 OID 0)
-- Dependencies: 224
-- Name: parcela_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.parcela_id_seq OWNED BY public.parcela.id;


--
-- TOC entry 207 (class 1259 OID 16575)
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produto (
    id integer NOT NULL,
    nome character varying(50),
    fabricante character varying(50),
    quantidade_estoque integer,
    quantidade_minina integer,
    preco_compra double precision,
    id_estoque integer,
    id_fornecedor integer
);


ALTER TABLE public.produto OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16573)
-- Name: produto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.produto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.produto_id_seq OWNER TO postgres;

--
-- TOC entry 2412 (class 0 OID 0)
-- Dependencies: 206
-- Name: produto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.produto_id_seq OWNED BY public.produto.id;


--
-- TOC entry 221 (class 1259 OID 16706)
-- Name: prontuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.prontuario (
    id integer NOT NULL,
    exames character varying(255),
    receitas character varying(255)
);


ALTER TABLE public.prontuario OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16704)
-- Name: prontuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.prontuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.prontuario_id_seq OWNER TO postgres;

--
-- TOC entry 2413 (class 0 OID 0)
-- Dependencies: 220
-- Name: prontuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.prontuario_id_seq OWNED BY public.prontuario.id;


--
-- TOC entry 231 (class 1259 OID 25011)
-- Name: relatorio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.relatorio (
    id integer NOT NULL,
    descricao character varying(255),
    relatorio character varying(500),
    id_funcionario integer
);


ALTER TABLE public.relatorio OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 25009)
-- Name: relatorio_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.relatorio_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.relatorio_id_seq OWNER TO postgres;

--
-- TOC entry 2414 (class 0 OID 0)
-- Dependencies: 230
-- Name: relatorio_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.relatorio_id_seq OWNED BY public.relatorio.id;


--
-- TOC entry 203 (class 1259 OID 16469)
-- Name: saida_estoque; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.saida_estoque (
    id integer NOT NULL,
    nome character varying(50),
    fabricante character varying(50),
    quantidade_saida integer,
    id_estoque integer
);


ALTER TABLE public.saida_estoque OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16467)
-- Name: saida_estoque_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.saida_estoque_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.saida_estoque_id_seq OWNER TO postgres;

--
-- TOC entry 2415 (class 0 OID 0)
-- Dependencies: 202
-- Name: saida_estoque_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.saida_estoque_id_seq OWNED BY public.saida_estoque.id;


--
-- TOC entry 199 (class 1259 OID 16435)
-- Name: tarefa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tarefa (
    id integer NOT NULL,
    descricao character varying(50),
    prioridade integer,
    status boolean,
    id_funcionario integer,
    data_inicio character varying(10),
    data_termino character varying(10)
);


ALTER TABLE public.tarefa OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16433)
-- Name: tarefa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tarefa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tarefa_id_seq OWNER TO postgres;

--
-- TOC entry 2416 (class 0 OID 0)
-- Dependencies: 198
-- Name: tarefa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tarefa_id_seq OWNED BY public.tarefa.id;


--
-- TOC entry 2140 (class 2604 OID 16617)
-- Name: caixa id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caixa ALTER COLUMN id SET DEFAULT nextval('public.caixa_id_seq'::regclass);


--
-- TOC entry 2149 (class 2604 OID 16794)
-- Name: consulta id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta ALTER COLUMN id SET DEFAULT nextval('public.consulta_id_seq'::regclass);


--
-- TOC entry 2143 (class 2604 OID 16660)
-- Name: consultorio id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultorio ALTER COLUMN id SET DEFAULT nextval('public.consultorio_id_seq'::regclass);


--
-- TOC entry 2152 (class 2604 OID 25097)
-- Name: contato id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contato ALTER COLUMN id SET DEFAULT nextval('public.contato_id_seq'::regclass);


--
-- TOC entry 2141 (class 2604 OID 16625)
-- Name: endereco id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco ALTER COLUMN id SET DEFAULT nextval('public.endereco_id_seq'::regclass);


--
-- TOC entry 2145 (class 2604 OID 16694)
-- Name: especializacao id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.especializacao ALTER COLUMN id SET DEFAULT nextval('public.especializacao_id_seq'::regclass);


--
-- TOC entry 2136 (class 2604 OID 16464)
-- Name: estoque id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estoque ALTER COLUMN id SET DEFAULT nextval('public.estoque_id_seq'::regclass);


--
-- TOC entry 2138 (class 2604 OID 16552)
-- Name: fornecedor id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedor ALTER COLUMN id SET DEFAULT nextval('public.fornecedor_id_seq'::regclass);


--
-- TOC entry 2134 (class 2604 OID 16417)
-- Name: funcionario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario ALTER COLUMN id SET DEFAULT nextval('public.funcionario_id_seq'::regclass);


--
-- TOC entry 2150 (class 2604 OID 16827)
-- Name: login id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.login ALTER COLUMN id SET DEFAULT nextval('public.login_id_seq'::regclass);


--
-- TOC entry 2144 (class 2604 OID 16681)
-- Name: medico id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medico ALTER COLUMN id SET DEFAULT nextval('public.medico_id_seq'::regclass);


--
-- TOC entry 2142 (class 2604 OID 16647)
-- Name: paciente id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente ALTER COLUMN id SET DEFAULT nextval('public.paciente_id_seq'::regclass);


--
-- TOC entry 2147 (class 2604 OID 16725)
-- Name: pagamento id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamento ALTER COLUMN id SET DEFAULT nextval('public.pagamento_id_seq'::regclass);


--
-- TOC entry 2148 (class 2604 OID 16738)
-- Name: parcela id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parcela ALTER COLUMN id SET DEFAULT nextval('public.parcela_id_seq'::regclass);


--
-- TOC entry 2139 (class 2604 OID 16578)
-- Name: produto id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto ALTER COLUMN id SET DEFAULT nextval('public.produto_id_seq'::regclass);


--
-- TOC entry 2146 (class 2604 OID 16709)
-- Name: prontuario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prontuario ALTER COLUMN id SET DEFAULT nextval('public.prontuario_id_seq'::regclass);


--
-- TOC entry 2151 (class 2604 OID 25014)
-- Name: relatorio id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.relatorio ALTER COLUMN id SET DEFAULT nextval('public.relatorio_id_seq'::regclass);


--
-- TOC entry 2137 (class 2604 OID 16472)
-- Name: saida_estoque id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.saida_estoque ALTER COLUMN id SET DEFAULT nextval('public.saida_estoque_id_seq'::regclass);


--
-- TOC entry 2135 (class 2604 OID 16438)
-- Name: tarefa id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarefa ALTER COLUMN id SET DEFAULT nextval('public.tarefa_id_seq'::regclass);


--
-- TOC entry 2364 (class 0 OID 16614)
-- Dependencies: 209
-- Data for Name: caixa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.caixa (id, status, numero, valor_abertura, valor_fechamento, lucro_diario, data) FROM stdin;
91	t	0	0	0	0	21/10/2018
92	t	5	0	0	0	21/10/2018
93	f	0	0	0	0	22/10/2018
94	f	0	0	0	0	22/10/2018
95	f	0	0	0	0	22/10/2018
96	f	0	0	0	0	22/10/2018
97	f	0	0	0	0	22/10/2018
98	f	0	0	0	0	22/10/2018
99	f	0	0	0	0	22/10/2018
100	f	0	0	0	0	22/10/2018
101	f	0	0	0	0	22/10/2018
102	f	1	0	0	0	23/10/2018
103	f	1	0	0	0	23/10/2018
104	f	1	0	0	0	23/10/2018
105	f	1	0	0	0	23/10/2018
106	f	1	0	0	0	23/10/2018
107	f	1	0	0	0	23/10/2018
108	f	1	0	0	0	23/10/2018
109	f	1	0	0	0	23/10/2018
110	f	1	0	0	0	23/10/2018
111	f	1	0	0	0	23/10/2018
112	f	1	0	0	0	23/10/2018
113	t	1	0	0	0	26/11/2018
114	t	1	0	0	0	26/11/2018
115	t	1	0	0	0	26/11/2018
116	t	1	0	0	0	26/11/2018
21	t	1	100	200	100	10/10/10
90	t	0	0	0	0	21/10/2018
\.


--
-- TOC entry 2382 (class 0 OID 16791)
-- Dependencies: 227
-- Data for Name: consulta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.consulta (id, tipo, agendamento, id_paciente, id_medico, id_consultorio, id_pagamento, data_hora) FROM stdin;
1	presencial	t	1	1	1	28	19/10/2018    4:40
2	presencial	t	1	1	4	28	19/10/2018    4:53
3	presencial	t	1	4	6	28	19/10/2018    5:15
4	\N	f	1	10	18	28	20/10/2018    0:15
5	\N	f	1	11	20	28	20/10/2018    0:17
6	\N	f	1	12	22	28	20/10/2018    0:19
7	\N	f	1	13	24	28	20/10/2018    0:33
8	\N	f	1	15	27	28	20/10/2018    1:27
9	\N	f	1	16	28	28	20/10/2018    1:35
10	\N	f	1	17	29	28	20/10/2018    1:39
11	\N	f	1	18	30	28	20/10/2018    1:45
12	\N	f	1	19	31	28	20/10/2018    1:48
13	\N	f	1	20	32	28	20/10/2018    1:50
14	\N	f	1	21	33	28	20/10/2018    1:52
15	\N	f	1	22	34	28	20/10/2018    1:56
16	\N	f	21	23	35	28	20/10/2018    2:0
17	\N	f	25	24	36	28	20/10/2018    7:6
18	\N	f	31	26	53	28	10/10/2010    10:50
19	\N	f	32	27	55	112	10/10/2010    10:50
20	\N	f	33	28	57	113	10/10/2010    10:50
\.


--
-- TOC entry 2370 (class 0 OID 16657)
-- Dependencies: 215
-- Data for Name: consultorio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.consultorio (id, nome_fantasia, razao_social, cnpj, id_endereco, id_contato) FROM stdin;
1	Glenda cuntult	Star	21483721	\N	\N
2	eu	andre	12653 45	\N	\N
3	Andre	rt	1	\N	\N
4	Andre	rt	1	\N	\N
5	Andre	rt	1	\N	\N
6	Andre	rt	1	\N	\N
7	Andre	rt	1	\N	\N
8	Andre	rt	1	\N	\N
9	Andre	rt	1	\N	\N
10	\N	\N	\N	\N	\N
11	\N	\N	\N	\N	\N
12	\N	\N	\N	\N	\N
13	\N	\N	\N	\N	\N
14	\N	\N	\N	\N	\N
15	\N	\N	\N	\N	\N
16	\N	\N	\N	\N	\N
17	\N	\N	\N	\N	\N
18	\N	\N	\N	\N	\N
19	\N	\N	\N	\N	\N
20	\N	\N	\N	\N	\N
21	\N	\N	\N	\N	\N
22	\N	\N	\N	\N	\N
23	\N	\N	\N	\N	\N
24	\N	\N	\N	\N	\N
25	\N	\N	\N	\N	\N
26	\N	\N	\N	\N	\N
27	\N	\N	\N	\N	\N
28	\N	\N	\N	\N	\N
29	\N	\N	\N	\N	\N
30	\N	\N	\N	\N	\N
31	\N	\N	\N	\N	\N
32	\N	\N	\N	\N	\N
33	\N	\N	\N	\N	\N
34	\N	\N	\N	\N	\N
35	\N	\N	\N	\N	\N
36	\N	\N	\N	\N	\N
42	\N	\N	\N	\N	\N
43	\N	\N	\N	\N	\N
44	\N	\N	\N	\N	\N
45	Andre	\N	\N	\N	\N
46	Andre	\N	\N	\N	\N
47	Consultorio	\N	\N	\N	\N
49	Consultorio	\N	\N	\N	\N
50	Consultorio	\N	\N	\N	\N
51	Consultorio	\N	\N	\N	\N
54	Consultorio	\N	\N	\N	\N
56	Consultorio	\N	\N	47	\N
58	Consultorio	\N	\N	51	\N
59	Glenda conporation	\N	\N	60	14
60	Glenda conporation	\N	\N	61	16
61	\N	\N	\N	96	89
62	\N	\N	\N	98	91
63	\N	\N	\N	100	93
\.


--
-- TOC entry 2388 (class 0 OID 25094)
-- Dependencies: 233
-- Data for Name: contato; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.contato (id, email, telefone, celular) FROM stdin;
1	heldonjose@gmail.com	EMAIL	\N
2	83-9-9627-9632	TELEFONE	\N
3	oilyhkjltgy	email	\N
4	oilyhkjltgy	email	\N
5	oilyhkjltgy	email	\N
6	oilyhkjltgy	email	\N
7	oilyhkjltgy	email	\N
8	oilyhkjltgy	\N	email
9	@gmail.coom	5555555	999999
10	@gmail.coom	5555555	999999
11	@gmail.coom	5555555	999999
12	@gmail.coom	5555555	999999
13	@gmail.coom	5555555	999999
14	@gmail.coom	5555555	999999
15	@gmail.coom	5555555	999999
16	@gmail.coom	5555555	999999
17	@gmail.com	\N	(87) 9999-9999
18	@gmail.com	\N	(87) 9999-9999
19	@gmail.com	\N	(87) 9999-9999
20	@gmail.com	\N	(87) 9999-9999
21	@gmail.com	\N	(87) 9999-9999
22	@gmail.com	\N	(87) 9999-9999
23	@gmail.com	\N	(87) 9999-9999
24	@gmail.com	\N	(87) 9999-9999
25	wff	\N	(  )     -    
26	wff	\N	(  )     -    
27	evvv	\N	(55) 5955-9999
28	evvv	\N	(55) 5955-9999
29	evvv	\N	(55) 5955-9999
30	evvv	\N	(55) 5955-9999
31	evvv	\N	(55) 5955-9999
32	evvv	\N	(55) 5955-9999
33	@gmail	\N	(55) 5555-5555
34	@gmail	\N	(55) 5555-5555
35	@gmail.com	\N	(88) 8888-8888
36	@gmail.com	\N	(88) 8888-8888
37	@gmail.com	\N	(99) 9999-9999
38	@gmail.com	\N	(99) 9999-9999
39	@andrejunior	(  )     -    	(88) 8888-8888
40	@andrejunior	(  )     -    	(88) 8888-8888
41		(  )     -    	(  )     -    
42		\N	(  )     -    
43		\N	(  )     -    
44		\N	(  )     -    
45		\N	(  )     -    
46		\N	(  )     -    
47		\N	(  )     -    
48		\N	(  )     -    
49		\N	(  )     -    
50		(  )     -    	(  )     -    
51		(  )     -    	(  )     -    
52		(  )     -    	(  )     -    
53		(  )     -    	(  )     -    
54		(  )     -    	(  )     -    
55		(  )     -    	(  )     -    
56		\N	(  )     -    
57		\N	(  )     -    
58		\N	(  )     -    
59		\N	(  )     -    
60		\N	(  )     -    
61		\N	(  )     -    
62		\N	(  )     -    
63		\N	(  )     -    
64		\N	(  )     -    
65		\N	(  )     -    
66		\N	(  )     -    
67		\N	(  )     -    
68		\N	(  )     -    
69		\N	(  )     -    
70		\N	(  )     -    
71		\N	(  )     -    
72		\N	(  )     -    
73		\N	(  )     -    
74		\N	(  )     -    
75		\N	(  )     -    
76		\N	(  )     -    
77		\N	(  )     -    
78			(  )     -    
79			(  )     -    
80			(  )     -    
81			(  )     -    
82		(  )     -    	(55) 5555-5555
83		(  )     -    	(55) 5555-5555
84		(  )     -    	(55) 5555-5555
85		(  )     -    	(55) 5555-5555
86		(  )     -    	(55) 5555-5555
87		(  )     -    	(55) 5555-5555
88		(  )     -    	(99) 9999-9999
89		(  )     -    	(99) 9999-9999
90		(  )     -    	(  )     -    
91		(  )     -    	(  )     -    
92		(  )     -    	(  )     -    
93		(  )     -    	(  )     -    
94		(  )     -    	(  )     -    
95		(  )     -    	(  )     -    
96		(  )     -    	(  )     -    
97	@maria.coom	(87) 9999-9999	(87) 5555-5555
98			(  )     -    
99			(  )     -    
100			(  )     -    
101			(  )     -    
102	anftvxgbx@rdtgt.com		(55) 4661-6161
\.


--
-- TOC entry 2366 (class 0 OID 16622)
-- Dependencies: 211
-- Data for Name: endereco; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.endereco (id, cep, rua, bairro, numero, municipio, estado) FROM stdin;
1	676	decio campos da silva	centro	36	\N	\N
2	676	decio campos da silva	centro	36	\N	\N
3	\N	\N	kckenkktr	\N	\N	\N
4	\N	\N	kckenkktr	\N	\N	\N
5	\N	\N	kckenkktr	\N	\N	\N
6	\N	\N	kckenkktr	\N	\N	\N
7	\N	\N	kckenkktr	\N	\N	\N
8	\N	\N	kckenkktr	\N	\N	\N
9	\N	\N	kckenkktr	\N	\N	\N
10	\N	\N	kckenkktr	\N	\N	\N
11	\N	\N	kckenkktr	\N	\N	\N
12	\N	\N	kckenkktr	\N	\N	\N
13	\N	\N	kckenkktr	\N	\N	\N
14	\N	\N	kckenkktr	\N	\N	\N
15	\N	\N	kckenkktr	\N	\N	\N
16	\N	\N	kckenkktr	\N	\N	\N
17	\N	\N	kckenkktr	\N	\N	\N
18	\N	\N	kckenkktr	\N	\N	\N
19	\N	\N	kckenkktr	\N	\N	\N
20	\N	\N	kckenkktr	\N	\N	\N
21	\N	\N	kckenkktr	\N	\N	\N
22	899988	\N	\N	\N	\N	\N
23	899988	\N	\N	\N	\N	\N
24	899988	\N	\N	\N	\N	\N
25	899988	\N	\N	\N	\N	\N
26	\N	\N	kckenkktr	\N	\N	\N
27	\N	\N	kckenkktr	\N	\N	\N
28	\N	\N	kckenkktr	\N	\N	\N
29	\N	\N	kckenkktr	\N	\N	\N
30	\N	\N	kckenkktr	\N	\N	\N
31	\N	\N	kckenkktr	\N	\N	\N
32	\N	\N	kckenkktr	\N	\N	\N
33	\N	\N	kckenkktr	\N	\N	\N
34	\N	\N	centro	\N	\N	\N
35	\N	\N	centro	\N	\N	\N
36	\N	\N	centro	\N	\N	\N
37	\N	\N	centro	\N	\N	\N
38	\N	\N	centro	\N	\N	\N
39	\N	\N	centro	\N	\N	\N
40	\N	\N	centro	\N	\N	\N
41	\N	\N	centro	\N	\N	\N
42	\N	\N	centro	\N	\N	\N
43	\N	\N	centro	\N	\N	\N
44	\N	\N	centro	\N	\N	\N
45	\N	\N	cabaré	\N	\N	\N
46	\N	\N	cabaré	\N	\N	\N
47	\N	\N	cabaré	\N	\N	\N
48	\N	\N	cabaré	\N	\N	\N
49	\N	\N	novo	\N	\N	\N
50	\N	\N	novo	\N	\N	\N
51	\N	\N	novo	\N	\N	\N
52	\N	\N	novo	\N	\N	\N
53	\N	\N	\N	\N	\N	\N
54	\N	\N	\N	\N	\N	\N
55	\N	\N	\N	\N	\N	\N
56	\N	\N	\N	\N	\N	\N
57	\N	\N	\N	\N	\N	\N
58	\N	\N	\N	\N	\N	\N
59	\N	\N	\N	\N	\N	\N
60	\N	\N	\N	\N	\N	\N
61	\N	\N	\N	\N	\N	\N
62	\N	\N	\N	\N	\N	\N
63	\N	4545		\N	\N	\N
64	\N	4444		\N	\N	\N
65	\N	4444		\N	\N	\N
66	\N	4444		\N	\N	\N
67	\N			\N	\N	\N
68	\N	decio  campos		\N	\N	\N
69	\N	decio		\N	\N	\N
70	\N	amaral campos		\N	\N	\N
71	\N	amaral campo		\N	\N	\N
72	\N			\N	\N	\N
73	\N			\N	\N	\N
74	\N			\N	\N	\N
75	\N			\N	\N	\N
76	\N			\N	\N	\N
77	\N			\N	\N	\N
78	\N			\N	\N	\N
79	\N			\N	\N	\N
80	\N			\N	\N	\N
81	\N			\N	\N	\N
82	\N			\N	\N	\N
83	\N			\N	\N	\N
84	\N			\N	\N	\N
85	\N			\N	\N	\N
86	\N			\N	\N	\N
87	\N			\N	\N	\N
88	\N			\N	\N	\N
89	\N			\N	\N	\N
90	\N			\N	\N	\N
91	\N			\N	\N	\N
92	\N			\N	\N	\N
93	\N			\N	\N	\N
94	     -   				\N	\N
95	     -   				\N	\N
96	     -   	dwedwd			\N	\N
97	     -   	dwedwd			\N	\N
98	     -   				\N	\N
99	     -   				\N	\N
100	     -   				\N	\N
101	     -   				\N	\N
102	     -   				\N	\N
103	     -   				\N	\N
104	     -   				\N	\N
105	56800-000	campo silva	centro	23	\N	\N
106	     -   				triunfo	AP
107	     -   					AC
108	     -   	campos				AC
109	56800-000	campos	centro	123	Serra talhada	AM
\.


--
-- TOC entry 2374 (class 0 OID 16691)
-- Dependencies: 219
-- Data for Name: especializacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.especializacao (id, descricao, salario, id_medico, horario_disponivel) FROM stdin;
1	Pediatria	300	1	15:30
2	Oculista	700	1	10:0
3	Cardiologista	0	5	17:19
4	Cardiologista	0	6	17:31
5	Cardiologista	0	6	17:31
6	Cardiologista	0	6	17:31
\.


--
-- TOC entry 2356 (class 0 OID 16461)
-- Dependencies: 201
-- Data for Name: estoque; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estoque (id, descricao, id_consultorio) FROM stdin;
1	tudo	\N
24	ycc	\N
25	ycc	\N
26	ycc	\N
27	ycc	\N
28	ycc	\N
29	ycc	\N
30	nomeestoque	\N
31	novo	42
32	novo 222	43
33	novo 222	44
34	novo 222	45
35	novo 222	46
36	luvas	47
37	luvas	49
38	luvas	50
\.


--
-- TOC entry 2360 (class 0 OID 16549)
-- Dependencies: 205
-- Data for Name: fornecedor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fornecedor (id, nome_fantasia, razao_social, cnpj, id_endereco, id_contato) FROM stdin;
65	glenda	diva	w234234	\N	\N
66	glenda	diva	w	\N	\N
67	glenda	diva	w	\N	\N
68	glenda	diva	w	\N	\N
69	glenda	diva	w	\N	\N
70	glenda	diva	w	\N	\N
71	glenda	diva	w	\N	\N
72	glenda	diva	w	\N	\N
73	glenda	diva	w	\N	\N
1	andre	l	w	\N	\N
74	t	j	h	\N	\N
75	t	j	h	\N	\N
76	yu	tu	t	\N	\N
77	yu	tu	t	\N	\N
78	yu	tu	t	\N	\N
79	yu	tu	t	\N	\N
80	yu	tu	t	\N	\N
81	yu	tu	t	\N	\N
82	yu	tu	t	\N	\N
83	yu	tu	t	\N	\N
84	yu	andre	t	\N	\N
85	yu	andre	t	\N	\N
86	yu	andre	t	\N	\N
91	yu	andre	t	1	\N
92	yu	andre	t	2	\N
93	andre	\N	\N	4	\N
94	andre	\N	\N	5	\N
95	andre	\N	\N	6	\N
96	andre	\N	\N	7	\N
97	andre	\N	\N	8	\N
98	\N	\N	\N	34	\N
99	\N	\N	\N	35	\N
\.


--
-- TOC entry 2352 (class 0 OID 16414)
-- Dependencies: 197
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.funcionario (id, nome, id_caixa, cpf, salario, funcao, data_nascimento, id_login, id_endereco, id_contato) FROM stdin;
79	glenda maravilhosa	86	0	0	\N	20/10/2018	135	\N	\N
80	glenda maravilhosa	87	0	0	\N	20/10/2018	136	\N	\N
81	andre	88	0	0	\N	21/10/2018	137	36	\N
82	\N	96	0	0	\N	22/10/2018	143	53	6
1	andre	1	11111111	10	 programador junior	19/11/1990	\N	\N	\N
14	andre	1	11111	0	administrador	10/10/2010	\N	\N	\N
15	andre	1	11111	0	administrador	10/10/2010	\N	\N	\N
16	andre	1	11111	0	administrador	10/10/2010	\N	\N	\N
17	andre	1	11111	0	administrador	10/10/2010	\N	\N	\N
18	andre	1	11111	0	administrador	10/10/2010	\N	\N	\N
19	andre	1	11111	0	administrador	10/10/2010	\N	\N	\N
20	Ande	1	0	0	\N	19/10/2018	\N	\N	\N
21	Ande	0	0	0	\N	19/10/2018	\N	\N	\N
22	Ande	30	0	0	\N	19/10/2018	\N	\N	\N
23	Ande	30	0	0	\N	19/10/2018	\N	\N	\N
24	Ande	31	0	0	\N	19/10/2018	\N	\N	\N
25	Ande	31	0	0	\N	19/10/2018	\N	\N	\N
26	Ande	32	0	0	\N	19/10/2018	\N	\N	\N
27	Ande	32	0	0	\N	19/10/2018	\N	\N	\N
28	Ande	33	0	0	\N	19/10/2018	\N	\N	\N
29	Ande	33	0	0	\N	19/10/2018	\N	\N	\N
35	Ande	38	0	0	\N	20/10/2018	65	\N	\N
36	Ande	38	0	0	\N	20/10/2018	66	\N	\N
37	Ande	40	0	0	\N	20/10/2018	69	\N	\N
38	Ande	41	0	0	\N	20/10/2018	71	\N	\N
39	Ande	42	0	0	\N	20/10/2018	73	\N	\N
40	Ande	43	0	0	\N	20/10/2018	75	\N	\N
41	Ande	44	0	0	\N	20/10/2018	77	\N	\N
42	Ande	45	0	0	\N	20/10/2018	79	\N	\N
43	Ande	47	0	0	\N	20/10/2018	82	\N	\N
44	Ande	48	0	0	\N	20/10/2018	84	\N	\N
45	Ande	49	0	0	\N	20/10/2018	86	\N	\N
46	Ande	50	0	0	\N	20/10/2018	88	\N	\N
47	Ande	51	0	0	\N	20/10/2018	90	\N	\N
48	Ande	52	0	0	\N	20/10/2018	92	\N	\N
49	Ande	52	0	0	\N	20/10/2018	93	\N	\N
50	Ande	53	0	0	\N	20/10/2018	94	\N	\N
51	Ande	53	0	0	\N	20/10/2018	95	\N	\N
52	Ande	54	0	0	\N	20/10/2018	96	\N	\N
53	Ande	54	0	0	\N	20/10/2018	97	\N	\N
54	Ande	55	0	0	\N	20/10/2018	98	\N	\N
55	Ande	56	0	0	\N	20/10/2018	99	\N	\N
56	Ande	56	0	0	\N	20/10/2018	100	\N	\N
57	Ande	57	0	0	\N	20/10/2018	101	\N	\N
58	Ande	58	0	0	\N	20/10/2018	102	\N	\N
59	Ande	58	0	0	\N	20/10/2018	103	\N	\N
60	Ande	59	0	0	\N	20/10/2018	104	\N	\N
61	Ande	60	0	0	\N	20/10/2018	105	\N	\N
62	Ande	60	0	0	\N	20/10/2018	106	\N	\N
63	Ande	61	0	0	\N	20/10/2018	107	\N	\N
64	Ande	62	0	0	\N	20/10/2018	108	\N	\N
65	Ande	62	0	0	\N	20/10/2018	109	\N	\N
66	Ande	63	0	0	\N	20/10/2018	110	\N	\N
67	Ande	64	0	0	\N	20/10/2018	111	\N	\N
68	Ande	64	0	0	\N	20/10/2018	112	\N	\N
69	Ande	65	0	0	\N	20/10/2018	113	\N	\N
70	Ande	66	0	0	\N	20/10/2018	114	\N	\N
71	Ande	66	0	0	\N	20/10/2018	115	\N	\N
72	Ande	67	0	0	\N	20/10/2018	116	\N	\N
73	glenda koslovsky	68	0	0	\N	20/10/2018	117	\N	\N
74	glenda koslovsky	68	0	0	\N	20/10/2018	118	\N	\N
75	glenda koslovsky	69	0	0	\N	20/10/2018	119	\N	\N
76	glenda koslovsky lindja	70	0	0	\N	20/10/2018	120	\N	\N
77	glenda maravilhosa	73	0	0	\N	20/10/2018	122	\N	\N
78	glenda maravilhosa	85	0	0	\N	20/10/2018	134	\N	\N
83	\N	97	0	0	\N	22/10/2018	144	54	7
85	\N	99	0	0	\N	22/10/2018	146	56	8
86	\N	100	0	0	\N	22/10/2018	147	57	9
87	\N	101	0	0	\N	22/10/2018	148	58	10
89	andre	105	0	0	programador junior	23/10/2018	150	71	40
90		106	0	0		23/10/2018	151	72	41
91		107	0	0		23/10/2018	152	77	50
92		108	0	0		23/10/2018	153	78	51
93		109	0	0		23/10/2018	154	79	52
94		110	0	0		23/10/2018	155	80	53
95		111	0	0		23/10/2018	156	81	54
96		112	0	0		23/10/2018	157	82	55
97		113	0	0		\N	161	102	94
99		115	0	0		\N	162	104	96
100	maria	116	651.561.651-56	10	programadora	20/12/2018	163	105	97
\.


--
-- TOC entry 2384 (class 0 OID 16824)
-- Dependencies: 229
-- Data for Name: login; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.login (id, usuario, senha) FROM stdin;
1	condeandre	123
63	funo	\N
64	funo	\N
65	funo	\N
66	funo	\N
67	funo	\N
68	funo	\N
69	funo	\N
70	funo	\N
71	funo	\N
72	funo	\N
73	funo	\N
74	funo	\N
75	funo	\N
76	funo	\N
77	funo	\N
78	funo	\N
79	funo	\N
80	funo	\N
81	funo	\N
82	funo	\N
83	funo	\N
84	funo	\N
85	funo	\N
86	funo	\N
87	funo	\N
88	funo	\N
89	funo	\N
90	funo	\N
91	funo	\N
92	funo	\N
93	funo	\N
94	funo	\N
95	funo	\N
96	funo	\N
97	funo	\N
98	funo	\N
99	funo	\N
100	funo	\N
101	funo	\N
102	funo	\N
103	funo	\N
104	funo	\N
105	funo	\N
106	funo	\N
107	funo	\N
108	funo	\N
109	funo	\N
110	funo	\N
111	funo	\N
112	funo	\N
113	funo	\N
114	funo	\N
115	funo	\N
116	funo	\N
117	funo	\N
118	funo	\N
119	funo	\N
120	funo	\N
121	admin	\N
122	admin	\N
123	admin	\N
124	admin	\N
125	admin	\N
126	admin	\N
127	admin	\N
128	admin	\N
129	admin	\N
130	admin	\N
131	admin	\N
132	admin	\N
133	admin	\N
134	admin	\N
135	admin	\N
136	admin	\N
137	andre	\N
138	andre	\N
139	andre	\N
140	andre	\N
141	andre	\N
142	\N	\N
143	\N	\N
144	\N	\N
145	\N	\N
146	\N	\N
147	\N	\N
148	\N	\N
149	\N	\N
150	andre	123
151		123
152		123
153		123
154		123
155		123
156		123
157		123
158	andre	123
159		123
160		123
161	andre	\N
162	andre	123
163	maria	123
\.


--
-- TOC entry 2372 (class 0 OID 16678)
-- Dependencies: 217
-- Data for Name: medico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.medico (id, nome, sexo, rg, id_consultorio, cpf, data_nascimento, data_cadastro, id_login, id_endereco, id_contato) FROM stdin;
1	Glenda	\N	\N	1	\N	\N	\N	\N	\N	\N
2	21	Masculino	12	1	1111	10/10/2018	10/10/2018	\N	\N	\N
3	andre	Masculino	12	5	1111	10/10/2018	10/10/2018	\N	\N	\N
4	andre	Masculino	12	7	1111	10/10/2018	10/10/2018	\N	\N	\N
5	andre	Masculino	12	8	1111	10/10/2018	10/10/2018	\N	\N	\N
6	andre	Masculino	12	9	1111	10/10/2018	10/10/2018	\N	\N	\N
7	\N	\N	0	13	\N	20/10/2018	20/10/2018	\N	\N	\N
8	\N	\N	0	15	\N	20/10/2018	20/10/2018	\N	\N	\N
9	\N	\N	0	17	\N	20/10/2018	20/10/2018	\N	\N	\N
10	\N	\N	0	19	\N	20/10/2018	20/10/2018	\N	\N	\N
11	\N	\N	0	21	\N	20/10/2018	20/10/2018	\N	\N	\N
12	\N	\N	0	23	\N	20/10/2018	20/10/2018	\N	\N	\N
13	\N	\N	0	25	\N	20/10/2018	20/10/2018	\N	\N	\N
14	\N	\N	0	26	\N	20/10/2018	20/10/2018	123	\N	\N
15	\N	\N	0	27	\N	20/10/2018	20/10/2018	124	\N	\N
16	\N	\N	0	28	\N	20/10/2018	20/10/2018	125	\N	\N
17	\N	\N	0	29	\N	20/10/2018	20/10/2018	126	\N	\N
18	\N	\N	0	30	\N	20/10/2018	20/10/2018	127	\N	\N
19	\N	\N	0	31	\N	20/10/2018	20/10/2018	128	\N	\N
20	\N	\N	0	32	\N	20/10/2018	20/10/2018	129	\N	\N
21	\N	\N	0	33	\N	20/10/2018	20/10/2018	130	\N	\N
22	\N	\N	0	34	\N	20/10/2018	20/10/2018	131	\N	\N
23	\N	\N	0	35	\N	20/10/2018	20/10/2018	132	\N	\N
24	\N	\N	0	36	\N	20/10/2018	20/10/2018	133	\N	\N
25	\N	\N	0	51	\N	21/10/2018	21/10/2018	138	37	\N
26	\N	\N	0	54	\N	21/10/2018	21/10/2018	139	44	\N
27	\N	\N	0	56	\N	21/10/2018	21/10/2018	140	48	\N
28	\N	\N	0	58	\N	21/10/2018	21/10/2018	141	52	\N
29	\N	\N	0	60	\N	22/10/2018	22/10/2018	149	62	15
30	andre	Masculino	8888888	61	666.666.666-66	32/22/1132	5/2/1	158	97	88
31	andre	Masculino	5555454	62	   .   .   -  	  /  /    	5/2/1	159	99	90
32	glenda 	Masculino	5555466	63	   .   .   -  	  /  /    	26/11/2018	160	101	92
\.


--
-- TOC entry 2368 (class 0 OID 16644)
-- Dependencies: 213
-- Data for Name: paciente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.paciente (id, nome, cpf, sexo, data_nascimento, data_cadastro, rg, id_prontuario, id_endereco, id_contato, convenio) FROM stdin;
1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N
21	andre	\N	\N		20/10/2018	0	19	29	\N	\N
25	andre	\N	\N		20/10/2018	0	23	33	\N	\N
31	\N	\N	\N		21/10/2018	0	29	43	\N	\N
32	\N	\N	\N		21/10/2018	0	30	45	\N	\N
33	\N	\N	\N		21/10/2018	0	31	49	\N	\N
34	\N	\N	\N		22/10/2018	0	32	59	12	\N
35	eu	1111			23/10/2018	4545	33	63	25	\N
36	ewfe	veece			23/10/2018	4444	34	64	27	\N
37	ewfe	veece			23/10/2018	4444	35	65	29	\N
38	ewfe	veece			23/10/2018	4444	36	66	31	\N
39	moral	444			23/10/2018	0	37	67	33	\N
40	andre	11111111			23/10/2018	0	38	68	35	\N
41	andre	111.111.111-11			23/10/2018	0	39	69	37	\N
42		   .   .   -  			23/10/2018	0	40	73	42	\N
43		   .   .   -  			23/10/2018	0	41	74	44	\N
44		   .   .   -  			23/10/2018	0	42	75	46	\N
45		   .   .   -  			23/10/2018	0	43	76	48	\N
46	gg	   .   .   -  			24/10/2018	0	44	83	56	\N
47	gg	   .   .   -  			24/10/2018	0	45	84	58	\N
48	gg	   .   .   -  			24/10/2018	0	46	85	60	\N
49	axa	   .   .   -  			24/10/2018	0	47	86	62	\N
50	axa	   .   .   -  			24/10/2018	0	48	87	64	\N
51	eee	   .   .   -  			24/10/2018	0	49	88	66	\N
52	ln	   .   .   -  			24/10/2018	0	50	89	68	\N
53	ln	   .   .   -  			24/10/2018	0	51	90	70	\N
54	eu	   .   .   -  			24/10/2018	0	52	91	72	\N
55	maria	   .   .   -  		11/11/1111	\N	0	53	92	74	\N
56	ey	   .   .   -  		  /  /    	\N	0	54	93	76	\N
57	loira	   .   .   -  		  /  /    	\N	0	55	94	78	\N
58	glenda 	   .   .   -  		  /  /    	\N	4444444	56	95	80	\N
59	maria	   .   .   -  		  /  /    	\N	1111111	57	106	98	\N
60	andreyhtgiuj	   .   .   -  		  /  /    	\N	7885151	58	107	100	sus
61	nara	   .   .   -  		  /  /    	\N	0	59	108	101	sus
62	maria alves	111.111.111-11	Masculino	20/15/2018	\N	8888888	60	109	102	77777
\.


--
-- TOC entry 2378 (class 0 OID 16722)
-- Dependencies: 223
-- Data for Name: pagamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pagamento (id, valor_total, status, forma_pagamento, quantidade_parcelas, id_caixa, data_vencimento) FROM stdin;
28	10	t	cheque	10	21	10/10/2010
111	0	f	\N	0	21	21/10/2018
112	0	f	\N	0	91	21/10/2018
113	0	f	\N	0	92	21/10/2018
\.


--
-- TOC entry 2380 (class 0 OID 16735)
-- Dependencies: 225
-- Data for Name: parcela; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.parcela (id, valor, status, numero, parcela_unica, id_pagamento, data_vencimento) FROM stdin;
15	\N	\N	\N	\N	113	\N
14	50	\N	5	\N	113	\N
\.


--
-- TOC entry 2362 (class 0 OID 16575)
-- Dependencies: 207
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.produto (id, nome, fabricante, quantidade_estoque, quantidade_minina, preco_compra, id_estoque, id_fornecedor) FROM stdin;
118	arroz	eu	10	5	10.199999999999999	1	73
119	u	t	2	5	10	1	74
120	u	t	2	5	10	1	75
121	t	y	3	2	2	1	76
122	t	y	3	2	2	27	77
123	t	y	3	2	2	28	78
124	t	y	3	2	2	28	79
125	t	y	3	2	2	28	80
126	t	y	3	2	2	29	81
127	t	y	3	2	2	29	82
128	t	y	3	2	2	29	83
129	arros	yccc	3	2	2	30	84
130	arros	yccc	3	2	2	30	85
131	arros	yccc	3	2	2	30	86
132	feijao	\N	0	0	0	38	99
133	4	\N	\N	\N	\N	\N	\N
134	arroz	\N	\N	\N	\N	\N	\N
\.


--
-- TOC entry 2376 (class 0 OID 16706)
-- Dependencies: 221
-- Data for Name: prontuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.prontuario (id, exames, receitas) FROM stdin;
16	exames	\N
17	exames	\N
18	exames	\N
19	exames	\N
20	exames	\N
21	exames	\N
22	exames	\N
23	exames	\N
24	doente	\N
25	doente	\N
26	doente	\N
27	doente	\N
28	doente	\N
29	doente	\N
30	doente	\N
31	doente	\N
32	gripe 	\N
33	\N	\N
34	\N	\N
35	\N	\N
36	\N	\N
37	\N	\N
38	\N	\N
39	\N	\N
40	\N	\N
41	\N	\N
42	\N	\N
43	\N	\N
44	\N	\N
45	\N	\N
46	\N	\N
47	\N	\N
48	\N	\N
49	\N	\N
50	\N	\N
51	\N	\N
52	\N	\N
53	\N	\N
54	\N	\N
55	\N	\N
56	\N	\N
57	\N	\N
58	\N	\N
59	\N	\N
60	\N	\N
\.


--
-- TOC entry 2386 (class 0 OID 25011)
-- Dependencies: 231
-- Data for Name: relatorio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.relatorio (id, descricao, relatorio, id_funcionario) FROM stdin;
42	eu	\N	\N
\.


--
-- TOC entry 2358 (class 0 OID 16469)
-- Dependencies: 203
-- Data for Name: saida_estoque; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.saida_estoque (id, nome, fabricante, quantidade_saida, id_estoque) FROM stdin;
6	luvas	\N	\N	\N
\.


--
-- TOC entry 2354 (class 0 OID 16435)
-- Dependencies: 199
-- Data for Name: tarefa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tarefa (id, descricao, prioridade, status, id_funcionario, data_inicio, data_termino) FROM stdin;
49	tomar remedio	\N	\N	\N	\N	\N
\.


--
-- TOC entry 2417 (class 0 OID 0)
-- Dependencies: 208
-- Name: caixa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.caixa_id_seq', 116, true);


--
-- TOC entry 2418 (class 0 OID 0)
-- Dependencies: 226
-- Name: consulta_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.consulta_id_seq', 20, true);


--
-- TOC entry 2419 (class 0 OID 0)
-- Dependencies: 214
-- Name: consultorio_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.consultorio_id_seq', 63, true);


--
-- TOC entry 2420 (class 0 OID 0)
-- Dependencies: 232
-- Name: contato_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contato_id_seq', 102, true);


--
-- TOC entry 2421 (class 0 OID 0)
-- Dependencies: 210
-- Name: endereco_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.endereco_id_seq', 109, true);


--
-- TOC entry 2422 (class 0 OID 0)
-- Dependencies: 218
-- Name: especializacao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.especializacao_id_seq', 6, true);


--
-- TOC entry 2423 (class 0 OID 0)
-- Dependencies: 200
-- Name: estoque_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estoque_id_seq', 38, true);


--
-- TOC entry 2424 (class 0 OID 0)
-- Dependencies: 204
-- Name: fornecedor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.fornecedor_id_seq', 99, true);


--
-- TOC entry 2425 (class 0 OID 0)
-- Dependencies: 196
-- Name: funcionario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.funcionario_id_seq', 100, true);


--
-- TOC entry 2426 (class 0 OID 0)
-- Dependencies: 228
-- Name: login_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.login_id_seq', 163, true);


--
-- TOC entry 2427 (class 0 OID 0)
-- Dependencies: 216
-- Name: medico_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.medico_id_seq', 32, true);


--
-- TOC entry 2428 (class 0 OID 0)
-- Dependencies: 212
-- Name: paciente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.paciente_id_seq', 62, true);


--
-- TOC entry 2429 (class 0 OID 0)
-- Dependencies: 222
-- Name: pagamento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pagamento_id_seq', 113, true);


--
-- TOC entry 2430 (class 0 OID 0)
-- Dependencies: 224
-- Name: parcela_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.parcela_id_seq', 15, true);


--
-- TOC entry 2431 (class 0 OID 0)
-- Dependencies: 206
-- Name: produto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produto_id_seq', 134, true);


--
-- TOC entry 2432 (class 0 OID 0)
-- Dependencies: 220
-- Name: prontuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.prontuario_id_seq', 60, true);


--
-- TOC entry 2433 (class 0 OID 0)
-- Dependencies: 230
-- Name: relatorio_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.relatorio_id_seq', 42, true);


--
-- TOC entry 2434 (class 0 OID 0)
-- Dependencies: 202
-- Name: saida_estoque_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.saida_estoque_id_seq', 6, true);


--
-- TOC entry 2435 (class 0 OID 0)
-- Dependencies: 198
-- Name: tarefa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tarefa_id_seq', 49, true);


--
-- TOC entry 2172 (class 2606 OID 16619)
-- Name: caixa caixa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caixa
    ADD CONSTRAINT caixa_pkey PRIMARY KEY (id);


--
-- TOC entry 2198 (class 2606 OID 16796)
-- Name: consulta consulta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT consulta_pkey PRIMARY KEY (id);


--
-- TOC entry 2180 (class 2606 OID 16662)
-- Name: consultorio consultorio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultorio
    ADD CONSTRAINT consultorio_pkey PRIMARY KEY (id);


--
-- TOC entry 2206 (class 2606 OID 25099)
-- Name: contato contato_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contato
    ADD CONSTRAINT contato_pkey PRIMARY KEY (id);


--
-- TOC entry 2174 (class 2606 OID 16627)
-- Name: endereco endereco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (id);


--
-- TOC entry 2189 (class 2606 OID 16696)
-- Name: especializacao especializacao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.especializacao
    ADD CONSTRAINT especializacao_pkey PRIMARY KEY (id);


--
-- TOC entry 2161 (class 2606 OID 16466)
-- Name: estoque estoque_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estoque
    ADD CONSTRAINT estoque_pkey PRIMARY KEY (id);


--
-- TOC entry 2168 (class 2606 OID 16554)
-- Name: fornecedor fornecedor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT fornecedor_pkey PRIMARY KEY (id);


--
-- TOC entry 2157 (class 2606 OID 16419)
-- Name: funcionario funcionario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (id);


--
-- TOC entry 2202 (class 2606 OID 16829)
-- Name: login login_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.login
    ADD CONSTRAINT login_pkey PRIMARY KEY (id);


--
-- TOC entry 2187 (class 2606 OID 16683)
-- Name: medico medico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medico
    ADD CONSTRAINT medico_pkey PRIMARY KEY (id);


--
-- TOC entry 2178 (class 2606 OID 16649)
-- Name: paciente paciente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT paciente_pkey PRIMARY KEY (id);


--
-- TOC entry 2194 (class 2606 OID 16727)
-- Name: pagamento pagamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamento
    ADD CONSTRAINT pagamento_pkey PRIMARY KEY (id);


--
-- TOC entry 2196 (class 2606 OID 16740)
-- Name: parcela parcela_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parcela
    ADD CONSTRAINT parcela_pkey PRIMARY KEY (id);


--
-- TOC entry 2170 (class 2606 OID 16580)
-- Name: produto produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id);


--
-- TOC entry 2191 (class 2606 OID 16714)
-- Name: prontuario prontuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prontuario
    ADD CONSTRAINT prontuario_pkey PRIMARY KEY (id);


--
-- TOC entry 2204 (class 2606 OID 25019)
-- Name: relatorio relatorio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.relatorio
    ADD CONSTRAINT relatorio_pkey PRIMARY KEY (id);


--
-- TOC entry 2164 (class 2606 OID 16474)
-- Name: saida_estoque saida_estoque_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.saida_estoque
    ADD CONSTRAINT saida_estoque_pkey PRIMARY KEY (id);


--
-- TOC entry 2159 (class 2606 OID 16440)
-- Name: tarefa tarefa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarefa
    ADD CONSTRAINT tarefa_pkey PRIMARY KEY (id);


--
-- TOC entry 2153 (class 1259 OID 25186)
-- Name: fki_id_Endereco; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "fki_id_Endereco" ON public.funcionario USING btree (id_endereco);


--
-- TOC entry 2183 (class 1259 OID 25153)
-- Name: fki_id_Login; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "fki_id_Login" ON public.medico USING btree (id_login);


--
-- TOC entry 2192 (class 1259 OID 25069)
-- Name: fki_id_caixa; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_id_caixa ON public.pagamento USING btree (id_caixa);


--
-- TOC entry 2162 (class 1259 OID 25175)
-- Name: fki_id_consultorio; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_id_consultorio ON public.estoque USING btree (id_consultorio);


--
-- TOC entry 2165 (class 1259 OID 25231)
-- Name: fki_id_cont; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_id_cont ON public.fornecedor USING btree (id_contato);


--
-- TOC entry 2181 (class 1259 OID 25242)
-- Name: fki_id_contat; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_id_contat ON public.consultorio USING btree (id_contato);


--
-- TOC entry 2154 (class 1259 OID 25220)
-- Name: fki_id_contato; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_id_contato ON public.funcionario USING btree (id_contato);


--
-- TOC entry 2184 (class 1259 OID 25248)
-- Name: fki_id_contatos; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_id_contatos ON public.medico USING btree (id_contato);


--
-- TOC entry 2175 (class 1259 OID 25254)
-- Name: fki_id_conttato; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_id_conttato ON public.paciente USING btree (id_contato);


--
-- TOC entry 2185 (class 1259 OID 25197)
-- Name: fki_id_end; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_id_end ON public.medico USING btree (id_endereco);


--
-- TOC entry 2182 (class 1259 OID 25214)
-- Name: fki_id_ende; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_id_ende ON public.consultorio USING btree (id_endereco);


--
-- TOC entry 2166 (class 1259 OID 25042)
-- Name: fki_id_endereco; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_id_endereco ON public.fornecedor USING btree (id_endereco);


--
-- TOC entry 2155 (class 1259 OID 25126)
-- Name: fki_id_login; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_id_login ON public.funcionario USING btree (id_login);


--
-- TOC entry 2199 (class 1259 OID 25169)
-- Name: fki_id_paciente; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_id_paciente ON public.consulta USING btree (id_paciente);


--
-- TOC entry 2200 (class 1259 OID 25085)
-- Name: fki_id_pagamento; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_id_pagamento ON public.consulta USING btree (id_pagamento);


--
-- TOC entry 2176 (class 1259 OID 25110)
-- Name: fki_id_prontuario; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_id_prontuario ON public.paciente USING btree (id_prontuario);


--
-- TOC entry 2224 (class 2606 OID 16697)
-- Name: especializacao especializacao_id_medico_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.especializacao
    ADD CONSTRAINT especializacao_id_medico_fkey FOREIGN KEY (id_medico) REFERENCES public.medico(id);


--
-- TOC entry 2225 (class 2606 OID 25064)
-- Name: pagamento id_caixa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamento
    ADD CONSTRAINT id_caixa FOREIGN KEY (id_caixa) REFERENCES public.caixa(id);


--
-- TOC entry 2210 (class 2606 OID 25170)
-- Name: estoque id_consultorio; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estoque
    ADD CONSTRAINT id_consultorio FOREIGN KEY (id_consultorio) REFERENCES public.consultorio(id);


--
-- TOC entry 2209 (class 2606 OID 25215)
-- Name: funcionario id_contato; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT id_contato FOREIGN KEY (id_contato) REFERENCES public.contato(id);


--
-- TOC entry 2213 (class 2606 OID 25226)
-- Name: fornecedor id_contato; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT id_contato FOREIGN KEY (id_contato) REFERENCES public.contato(id);


--
-- TOC entry 2219 (class 2606 OID 25237)
-- Name: consultorio id_contato; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultorio
    ADD CONSTRAINT id_contato FOREIGN KEY (id_contato) REFERENCES public.contato(id);


--
-- TOC entry 2223 (class 2606 OID 25243)
-- Name: medico id_contato; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medico
    ADD CONSTRAINT id_contato FOREIGN KEY (id_contato) REFERENCES public.contato(id);


--
-- TOC entry 2217 (class 2606 OID 25249)
-- Name: paciente id_contato; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT id_contato FOREIGN KEY (id_contato) REFERENCES public.contato(id);


--
-- TOC entry 2212 (class 2606 OID 25037)
-- Name: fornecedor id_endereco; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT id_endereco FOREIGN KEY (id_endereco) REFERENCES public.endereco(id);


--
-- TOC entry 2208 (class 2606 OID 25181)
-- Name: funcionario id_endereco; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT id_endereco FOREIGN KEY (id_endereco) REFERENCES public.endereco(id);


--
-- TOC entry 2222 (class 2606 OID 25192)
-- Name: medico id_endereco; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medico
    ADD CONSTRAINT id_endereco FOREIGN KEY (id_endereco) REFERENCES public.endereco(id);


--
-- TOC entry 2218 (class 2606 OID 25209)
-- Name: consultorio id_endereco; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultorio
    ADD CONSTRAINT id_endereco FOREIGN KEY (id_endereco) REFERENCES public.endereco(id);


--
-- TOC entry 2207 (class 2606 OID 25121)
-- Name: funcionario id_login; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT id_login FOREIGN KEY (id_login) REFERENCES public.login(id);


--
-- TOC entry 2221 (class 2606 OID 25148)
-- Name: medico id_login; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medico
    ADD CONSTRAINT id_login FOREIGN KEY (id_login) REFERENCES public.login(id);


--
-- TOC entry 2228 (class 2606 OID 25164)
-- Name: consulta id_paciente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT id_paciente FOREIGN KEY (id_paciente) REFERENCES public.paciente(id);


--
-- TOC entry 2227 (class 2606 OID 25080)
-- Name: consulta id_pagamento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT id_pagamento FOREIGN KEY (id_pagamento) REFERENCES public.pagamento(id);


--
-- TOC entry 2216 (class 2606 OID 25105)
-- Name: paciente id_prontuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT id_prontuario FOREIGN KEY (id_prontuario) REFERENCES public.prontuario(id);


--
-- TOC entry 2220 (class 2606 OID 16684)
-- Name: medico medico_id_consultorio_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medico
    ADD CONSTRAINT medico_id_consultorio_fkey FOREIGN KEY (id_consultorio) REFERENCES public.consultorio(id);


--
-- TOC entry 2226 (class 2606 OID 16741)
-- Name: parcela parcela_id_pagamento_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parcela
    ADD CONSTRAINT parcela_id_pagamento_fkey FOREIGN KEY (id_pagamento) REFERENCES public.pagamento(id);


--
-- TOC entry 2214 (class 2606 OID 16581)
-- Name: produto produto_id_estoque_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_id_estoque_fkey FOREIGN KEY (id_estoque) REFERENCES public.estoque(id);


--
-- TOC entry 2215 (class 2606 OID 16586)
-- Name: produto produto_id_fornecedor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_id_fornecedor_fkey FOREIGN KEY (id_fornecedor) REFERENCES public.fornecedor(id);


--
-- TOC entry 2229 (class 2606 OID 25020)
-- Name: relatorio relatorio_id_funcionario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.relatorio
    ADD CONSTRAINT relatorio_id_funcionario_fkey FOREIGN KEY (id_funcionario) REFERENCES public.funcionario(id);


--
-- TOC entry 2211 (class 2606 OID 16475)
-- Name: saida_estoque saida_estoque_id_estoque_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.saida_estoque
    ADD CONSTRAINT saida_estoque_id_estoque_fkey FOREIGN KEY (id_estoque) REFERENCES public.estoque(id);


-- Completed on 2018-11-26 19:55:54

--
-- PostgreSQL database dump complete
--

