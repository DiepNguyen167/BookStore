--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-10-20 16:18:42

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
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2887 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 206 (class 1259 OID 16508)
-- Name: ACCOUNT; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."ACCOUNT" (
    "USERNAME" character varying(200) NOT NULL,
    "PASS" character varying(200) NOT NULL,
    "ROLE" integer NOT NULL
);


ALTER TABLE public."ACCOUNT" OWNER TO postgres;

--
-- TOC entry 2888 (class 0 OID 0)
-- Dependencies: 206
-- Name: COLUMN "ACCOUNT"."ROLE"; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public."ACCOUNT"."ROLE" IS '-- 0 :  ADMIN
-- 1 : EMPLOYEE
-- 2 : CUSTOMER';


--
-- TOC entry 199 (class 1259 OID 16454)
-- Name: AUTHOR; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."AUTHOR" (
    "ID" integer NOT NULL,
    "NAME" character varying(200),
    "DESCRIPTION" character varying(1000)
);


ALTER TABLE public."AUTHOR" OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16452)
-- Name: AUTHOR_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."AUTHOR_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."AUTHOR_ID_seq" OWNER TO postgres;

--
-- TOC entry 2889 (class 0 OID 0)
-- Dependencies: 198
-- Name: AUTHOR_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."AUTHOR_ID_seq" OWNED BY public."AUTHOR"."ID";


--
-- TOC entry 197 (class 1259 OID 16443)
-- Name: BOOKS; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."BOOKS" (
    "ID" integer NOT NULL,
    "NAME" character varying(200),
    "CATEGORY_ID" integer,
    "PUBLISHER_ID" integer,
    "AUTHOR_ID" integer,
    "QUALITY" integer,
    "COST" integer,
    "DESCRIPTION" character varying(1000)
);


ALTER TABLE public."BOOKS" OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16441)
-- Name: BOOKS_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."BOOKS_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."BOOKS_ID_seq" OWNER TO postgres;

--
-- TOC entry 2890 (class 0 OID 0)
-- Dependencies: 196
-- Name: BOOKS_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."BOOKS_ID_seq" OWNED BY public."BOOKS"."ID";


--
-- TOC entry 201 (class 1259 OID 16466)
-- Name: CATEGORY; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."CATEGORY" (
    "ID" integer NOT NULL,
    "NAME" character varying(200) NOT NULL,
    "DESCRIPTION" character varying(1000)
);


ALTER TABLE public."CATEGORY" OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16464)
-- Name: CATEGORY_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."CATEGORY_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."CATEGORY_ID_seq" OWNER TO postgres;

--
-- TOC entry 2891 (class 0 OID 0)
-- Dependencies: 200
-- Name: CATEGORY_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."CATEGORY_ID_seq" OWNED BY public."CATEGORY"."ID";


--
-- TOC entry 205 (class 1259 OID 16499)
-- Name: CUSTOMER; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."CUSTOMER" (
    "ID" integer NOT NULL,
    "NAME" character varying(200) NOT NULL,
    "USERNAME" character varying(200) NOT NULL,
    "PHONENUMBER" character varying(200),
    "BIRTH" date,
    "GENDER" character varying(8)
);


ALTER TABLE public."CUSTOMER" OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16497)
-- Name: CUSTOMER_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."CUSTOMER_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."CUSTOMER_ID_seq" OWNER TO postgres;

--
-- TOC entry 2892 (class 0 OID 0)
-- Dependencies: 204
-- Name: CUSTOMER_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."CUSTOMER_ID_seq" OWNED BY public."CUSTOMER"."ID";


--
-- TOC entry 208 (class 1259 OID 16515)
-- Name: MANAGER; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."MANAGER" (
    "ID" integer NOT NULL,
    "USERNAME" character varying(200) NOT NULL,
    "NAME" character varying(200) NOT NULL,
    "BIRTH" date,
    "ROLE" integer NOT NULL,
    "GENDER" character varying(8),
    "PHONENUMBER" character varying
);


ALTER TABLE public."MANAGER" OWNER TO postgres;

--
-- TOC entry 2893 (class 0 OID 0)
-- Dependencies: 208
-- Name: COLUMN "MANAGER"."ROLE"; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public."MANAGER"."ROLE" IS '0 : ADMIN
1 : EMPLOYEE';


--
-- TOC entry 207 (class 1259 OID 16513)
-- Name: MANAGER_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."MANAGER_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."MANAGER_ID_seq" OWNER TO postgres;

--
-- TOC entry 2894 (class 0 OID 0)
-- Dependencies: 207
-- Name: MANAGER_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."MANAGER_ID_seq" OWNED BY public."MANAGER"."ID";


--
-- TOC entry 210 (class 1259 OID 16526)
-- Name: ORDER; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."ORDER" (
    "ID" integer NOT NULL,
    "CUSTOMER_ID" integer NOT NULL,
    "EMPLOYEE_ID" integer,
    "CREATE_DATE" date,
    "SALE_DATE" date,
    "STATUS" character varying(200),
    "TOTAL_AMOUNT" integer
);


ALTER TABLE public."ORDER" OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16532)
-- Name: ORDER_DETAIL; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."ORDER_DETAIL" (
    "ORDER_ID" integer NOT NULL,
    "BOOK_ID" integer,
    "QUALITY" integer,
    "DESCRIPTION" character varying
);


ALTER TABLE public."ORDER_DETAIL" OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16524)
-- Name: ORDER_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."ORDER_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."ORDER_ID_seq" OWNER TO postgres;

--
-- TOC entry 2895 (class 0 OID 0)
-- Dependencies: 209
-- Name: ORDER_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."ORDER_ID_seq" OWNED BY public."ORDER"."ID";


--
-- TOC entry 203 (class 1259 OID 16477)
-- Name: PUBLISHER; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."PUBLISHER" (
    "ID" integer NOT NULL,
    "NAME" character varying(200) NOT NULL,
    "DESCRIPTION" character varying(1000)
);


ALTER TABLE public."PUBLISHER" OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16475)
-- Name: PUBLISHER_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."PUBLISHER_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."PUBLISHER_ID_seq" OWNER TO postgres;

--
-- TOC entry 2896 (class 0 OID 0)
-- Dependencies: 202
-- Name: PUBLISHER_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."PUBLISHER_ID_seq" OWNED BY public."PUBLISHER"."ID";


--
-- TOC entry 213 (class 1259 OID 16542)
-- Name: RECEIPT_BOOK; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."RECEIPT_BOOK" (
    "ID" integer NOT NULL,
    "RECEIPT_DATE" date,
    "EMPLOYEE_ID" integer
);


ALTER TABLE public."RECEIPT_BOOK" OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16540)
-- Name: RECEIPT_BOOK_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."RECEIPT_BOOK_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."RECEIPT_BOOK_ID_seq" OWNER TO postgres;

--
-- TOC entry 2897 (class 0 OID 0)
-- Dependencies: 212
-- Name: RECEIPT_BOOK_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."RECEIPT_BOOK_ID_seq" OWNED BY public."RECEIPT_BOOK"."ID";


--
-- TOC entry 214 (class 1259 OID 16548)
-- Name: RECEIPT_DETAIL; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."RECEIPT_DETAIL" (
    "RECEIPT_ID" integer,
    "BOOK_ID" integer,
    "QUALITY" integer,
    "COST" integer
);


ALTER TABLE public."RECEIPT_DETAIL" OWNER TO postgres;

--
-- TOC entry 2732 (class 2604 OID 16457)
-- Name: AUTHOR ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."AUTHOR" ALTER COLUMN "ID" SET DEFAULT nextval('public."AUTHOR_ID_seq"'::regclass);


--
-- TOC entry 2731 (class 2604 OID 16446)
-- Name: BOOKS ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."BOOKS" ALTER COLUMN "ID" SET DEFAULT nextval('public."BOOKS_ID_seq"'::regclass);


--
-- TOC entry 2733 (class 2604 OID 16469)
-- Name: CATEGORY ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."CATEGORY" ALTER COLUMN "ID" SET DEFAULT nextval('public."CATEGORY_ID_seq"'::regclass);


--
-- TOC entry 2735 (class 2604 OID 16502)
-- Name: CUSTOMER ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."CUSTOMER" ALTER COLUMN "ID" SET DEFAULT nextval('public."CUSTOMER_ID_seq"'::regclass);


--
-- TOC entry 2736 (class 2604 OID 16518)
-- Name: MANAGER ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."MANAGER" ALTER COLUMN "ID" SET DEFAULT nextval('public."MANAGER_ID_seq"'::regclass);


--
-- TOC entry 2737 (class 2604 OID 16529)
-- Name: ORDER ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."ORDER" ALTER COLUMN "ID" SET DEFAULT nextval('public."ORDER_ID_seq"'::regclass);


--
-- TOC entry 2734 (class 2604 OID 16480)
-- Name: PUBLISHER ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."PUBLISHER" ALTER COLUMN "ID" SET DEFAULT nextval('public."PUBLISHER_ID_seq"'::regclass);


--
-- TOC entry 2738 (class 2604 OID 16545)
-- Name: RECEIPT_BOOK ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."RECEIPT_BOOK" ALTER COLUMN "ID" SET DEFAULT nextval('public."RECEIPT_BOOK_ID_seq"'::regclass);


--
-- TOC entry 2750 (class 2606 OID 16512)
-- Name: ACCOUNT ACCOUNT_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."ACCOUNT"
    ADD CONSTRAINT "ACCOUNT_pkey" PRIMARY KEY ("USERNAME");


--
-- TOC entry 2742 (class 2606 OID 16462)
-- Name: AUTHOR AUTHOR_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."AUTHOR"
    ADD CONSTRAINT "AUTHOR_pkey" PRIMARY KEY ("ID");


--
-- TOC entry 2740 (class 2606 OID 16451)
-- Name: BOOKS BOOKS_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."BOOKS"
    ADD CONSTRAINT "BOOKS_pkey" PRIMARY KEY ("ID");


--
-- TOC entry 2744 (class 2606 OID 16474)
-- Name: CATEGORY CATEGORY_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."CATEGORY"
    ADD CONSTRAINT "CATEGORY_pkey" PRIMARY KEY ("ID");


--
-- TOC entry 2748 (class 2606 OID 16507)
-- Name: CUSTOMER CUSTOMER_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."CUSTOMER"
    ADD CONSTRAINT "CUSTOMER_pkey" PRIMARY KEY ("ID");


--
-- TOC entry 2752 (class 2606 OID 16520)
-- Name: MANAGER MANAGER_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."MANAGER"
    ADD CONSTRAINT "MANAGER_pkey" PRIMARY KEY ("USERNAME");


--
-- TOC entry 2756 (class 2606 OID 16539)
-- Name: ORDER_DETAIL ORDER_DETAIL_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."ORDER_DETAIL"
    ADD CONSTRAINT "ORDER_DETAIL_pkey" PRIMARY KEY ("ORDER_ID");


--
-- TOC entry 2754 (class 2606 OID 16531)
-- Name: ORDER ORDER_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."ORDER"
    ADD CONSTRAINT "ORDER_pkey" PRIMARY KEY ("ID");


--
-- TOC entry 2746 (class 2606 OID 16485)
-- Name: PUBLISHER PUBLISHER_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."PUBLISHER"
    ADD CONSTRAINT "PUBLISHER_pkey" PRIMARY KEY ("ID");


--
-- TOC entry 2758 (class 2606 OID 16547)
-- Name: RECEIPT_BOOK RECEIPT_BOOK_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."RECEIPT_BOOK"
    ADD CONSTRAINT "RECEIPT_BOOK_pkey" PRIMARY KEY ("ID");


-- Completed on 2018-10-20 16:18:43

--
-- PostgreSQL database dump complete
--

