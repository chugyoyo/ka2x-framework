create table GRESA_SA_DTL
(
	RSADTLID NUMBER(12),
	RSAID NUMBER(10),
	PLACEPOINTID NUMBER(10),
	COUNTERID NUMBER(10),
	CLERKERID NUMBER(10),
	GOODSID NUMBER(10),
	TAXRATE NUMBER(3,2),
	PRICEID NUMBER(10),
	UNITPRICE NUMBER(20,10),
	TOTAL_LINE NUMBER(12,4),
	USEPRICE NUMBER(20,10),
	REALMONEY NUMBER(12,4),
	RESAPRICE NUMBER(20,10),
	GOODSQTY NUMBER(16,6),
	GOODSUNIT VARCHAR2(10),
	PRESCRIBEFLAG NUMBER(4),
	PRESCRIPTIONDTLID NUMBER(10),
	COMBINESOURCEID NUMBER(10),
	PRESENTFLAG NUMBER(1),
	BREAKSALES NUMBER(1),
	ORRSADTLID NUMBER(10),
	USESTATUS NUMBER(1),
	STORAGEID NUMBER(10),
	GOODSDTLID NUMBER(10),
	BATCHID NUMBER(10),
	POSID NUMBER(10),
	LOTID NUMBER(10),
	GOODSSTATUSID NUMBER(10),
	MANUALRATE NUMBER(16,6),
	MANUALMONEY NUMBER(12,2),
	MANUALPREMONEY NUMBER(12,2),
	MARKETRATE NUMBER(16,6),
	MARKETMONEY NUMBER(12,2),
	MARKETPREMONEY NUMBER(12,2),
	MAINMANUALMONEY NUMBER(12,2),
	MAINMANUALPREMONEY NUMBER(12,2),
	MAINMARKETMONEY NUMBER(12,2),
	MAINMARKETPREMONEY NUMBER(12,2),
	PARENTRSADTLID NUMBER(10),
	SHOPPEFLAG NUMBER(1),
	COMBINEGOODSQTY NUMBER(16,6),
	REDUCEDPRICE NUMBER(20,10),
	REDUCEDMONEY NUMBER(12,2),
	COMBPREMONEY NUMBER(12,2),
	COMBPRICE NUMBER(20,10),
	RECIPEFLAG NUMBER(1),
	RECIPENO VARCHAR2(40),
	RECIPTDATE DATE,
	RECIPEHOSPITAL VARCHAR2(60),
	RECIPEDOCTOR VARCHAR2(20),
	SKCERTID NUMBER(10),
	MEMO VARCHAR2(200),
	ZXCOLUMN1 VARCHAR2(50),
	ZXCOLUMN2 VARCHAR2(50),
	ZXCOLUMN3 VARCHAR2(50),
	ZXCOLUMN4 VARCHAR2(50),
	ZXCOLUMN5 VARCHAR2(50),
	COSTINGPRICE NUMBER(20,10),
	COSTINGMONEY NUMBER(12,2),
	NOPROMFLAG NUMBER(1),
	GROUPREQDTLID NUMBER(10),
	MAININTEGPREMONEY NUMBER(12,2),
	MAINVOUCHPREMONEY NUMBER(12,2),
	INSPOINTSFLAG NUMBER(1),
	INSDISCFLAG NUMBER(1),
	NOUSEVOUFLAG NUMBER(1),
	ISLIMIT NUMBER(1),
	DTLINTEGRAL NUMBER(20,10),
	EXAMPRICE NUMBER(20,10),
	ACCFLAG NUMBER(1),
	ECODES VARCHAR2(100),
	PEIFANGMANID NUMBER(10),
	SHENFANGMANID NUMBER(10),
	IGNOREMONEY NUMBER(12,2),
	GOODSNO VARCHAR2(100),
	LOTNO VARCHAR2(100),
	ALLOCATIONMON NUMBER(12,2),
	SINGLEFLAG NUMBER(10),
	SERIESFLAG NUMBER(10),
	ENTIREFLAG NUMBER(10),
	SINGLE NUMBER(3),
	SERIES NUMBER(3),
	ENTIRE NUMBER(3),
	PROMSALESID NUMBER(10),
	LARGESHOPPINGFLAG NUMBER(2),
	NOSINGLEPROMFLAG NUMBER(2),
	CHUFANGDTLID NUMBER(10),
	CLEARANCEFLAG NUMBER(1),
	SETMARKETMONEY NUMBER(12,2),
	SETMARKETPREMONEY NUMBER(12,2),
	ZX_REALMONEY NUMBER(12,4),
	VARIETYID NUMBER(10),
	XQTSDAYS VARCHAR2(30),
	PUSH_CLASS VARCHAR2(10),
	IS_SALE_PRICE VARCHAR2(10),
	RECEIPTPRIALONE NUMBER(1),
	ZX_SJEXPORTXMLFLAG NUMBER(2),
	YBCODE VARCHAR2(50),
	ACTIVITYMONEY NUMBER(12,2),
	ACTIVITYFLAG NUMBER(1),
	ZX_PROVINCECOLLFLAG NUMBER(1),
	IS_MI VARCHAR2(10),
	MI_CLASS VARCHAR2(10),
	REDUCEDPRICEMEMO VARCHAR2(200),
	CNAME VARCHAR2(100),
	IDCODE VARCHAR2(100),
	TELEPHONE VARCHAR2(100),
	OTHERID NUMBER(10),
	RECIPMEMO VARCHAR2(200),
	AGE NUMBER(10),
	SEX NUMBER(1),
	ZXPRICE NUMBER(20,10),
	ZXMONEY NUMBER(12,4),
	COSTPRICE NUMBER(20,4),
	DHID NUMBER(10),
	DHINTEGRAL NUMBER(12,2),
	DHMOENY NUMBER(12,2),
	RULECODE VARCHAR2(100),
	VOUCHERCODE VARCHAR2(100),
	VOUCHERMONEY NUMBER(12,2),
	VOUCHERSUBTYPE VARCHAR2(100),
	SERIESMONEY NUMBER(12,2),
	GROUPMONEY NUMBER(12,2),
	ALLMONEY NUMBER(12,2),
	NOMONEY NUMBER(12,2),
	LEVELMONEY NUMBER(12,2),
	NOLEVELMONEY NUMBER(12,2),
	SETNO VARCHAR2(40),
	DHQTY NUMBER(12,2),
	JT_AMT NUMBER(16,4),
	SZYBTRANSFLAG NUMBER(1),
	BREAKDTLID NUMBER(10),
	SURPLUS_NUMBER NUMBER(10),
	SALE_NUMBER NUMBER(10),
	PRICE07 NUMBER(16,4),
	EXEC_PRICE NUMBER(16,4),
	PROM_FLAG VARCHAR2(2),
	ZZ_PRICE NUMBER(16,4),
	RSAFLAG NUMBER(1),
	LOW_PRICE NUMBER(16,4),
	UNIT_PRICE NUMBER(16,4),
	ROYALTY_RATE NUMBER(16,4),
	ZZHY_ZK NUMBER(10,4),
	PROMORDERDTLID VARCHAR2(50),
	USEPRICE2 NUMBER(20,4),
	REALMONEY2 NUMBER(12,4),
	ZX_YLZD NUMBER(10),
	SID NUMBER(10),
	SPLITORIRSADTLID NUMBER(12),
	ISZPHG NUMBER(1),
	ZPHGSID NUMBER(12),
	RULEID NUMBER(10),
	RULEDTLID NUMBER(10),
	RULETYPE NUMBER(2),
	BELONGGOODSNO VARCHAR2(100),
	GIFTGROUPIDS VARCHAR2(100),
	GOODSTOPRESENTFLAG VARCHAR2(50),
	PROMORDERID VARCHAR2(50),
	UNITPRICE_BAK NUMBER(20,4),
	USEPRICE_BAK NUMBER(20,4),
	ZY_ADDPRICE_RATE NUMBER(12,2),
	SUPPER_VIP_EXCLUSIVE NUMBER(12,2),
	SUPPER_VIP_COUPON NUMBER(12,2),
	PROMOTERNO NUMBER(10),
	KH04_AKC515 VARCHAR2(50),
	KH04_AKC516 VARCHAR2(100),
	KH02_AKA072 VARCHAR2(20),
	KH02_CKC402 VARCHAR2(50),
	MEMBERSHIPMONEY NUMBER(12,2),
	MEMBERSHIPMONEY2 NUMBER(12,2),
	VIPPRICE NUMBER(16,4),
	EPHEDRINE NUMBER(1),
	PRE_REALMONEY NUMBER(16,4),
	PRE_SHAREPRICE NUMBER(16,4),
	XQPRICE NUMBER(16,4),
	SYS_MODIFYDATE DATE default sysdate,
	ORDERDTLID NUMBER(10),
	ISPRE NUMBER(1),
	PREDATE DATE,
	THEMEID VARCHAR2(100),
	REDUCED_TYPE NUMBER(4),
	ZX_TOGBYBDATE DATE,
	RECIPEID NUMBER(10),
	REALMONEY3 NUMBER(12,4),
	USEPRICE3 NUMBER(20,4),
	constraint GRESA_SA_DTL_CHECK
		check (nvl(goodsqty*realmoney,0)>=0)
)
/

comment on column GRESA_SA_DTL.RSAID is '流水号'
/

comment on column GRESA_SA_DTL.PLACEPOINTID is '门店ID'
/

comment on column GRESA_SA_DTL.CLERKERID is '营业员ID'
/

comment on column GRESA_SA_DTL.GOODSID is '货品ID'
/

comment on column GRESA_SA_DTL.TAXRATE is '税率  '
/

comment on column GRESA_SA_DTL.PRICEID is '价格ID'
/

comment on column GRESA_SA_DTL.UNITPRICE is '原价'
/

comment on column GRESA_SA_DTL.TOTAL_LINE is '应收金额'
/

comment on column GRESA_SA_DTL.USEPRICE is '时价'
/

comment on column GRESA_SA_DTL.REALMONEY is '实收金额'
/

comment on column GRESA_SA_DTL.RESAPRICE is '零售价'
/

comment on column GRESA_SA_DTL.GOODSQTY is '单位数量'
/

comment on column GRESA_SA_DTL.GOODSUNIT is '货品基本单位'
/

comment on column GRESA_SA_DTL.PRESCRIPTIONDTLID is '药方细单ID'
/

comment on column GRESA_SA_DTL.COMBINESOURCEID is '组合商品ID'
/

comment on column GRESA_SA_DTL.USESTATUS is '状态'
/

comment on column GRESA_SA_DTL.GOODSSTATUSID is '批号'
/

comment on column GRESA_SA_DTL.MANUALMONEY is '整单手工折扣金额'
/

comment on column GRESA_SA_DTL.MANUALPREMONEY is '整单手工优惠金额'
/

comment on column GRESA_SA_DTL.MARKETRATE is '促销折扣率'
/

comment on column GRESA_SA_DTL.MARKETMONEY is '促销折扣金额'
/

comment on column GRESA_SA_DTL.MARKETPREMONEY is '促销优惠金额'
/

comment on column GRESA_SA_DTL.MAINMANUALMONEY is '整单手工折扣金额'
/

comment on column GRESA_SA_DTL.MAINMANUALPREMONEY is '整单手工优惠金额'
/

comment on column GRESA_SA_DTL.MAINMARKETMONEY is '整单促销折扣金额'
/

comment on column GRESA_SA_DTL.MAINMARKETPREMONEY is '整单促销优惠金额'
/

comment on column GRESA_SA_DTL.PARENTRSADTLID is '赠品所属明细ID'
/

comment on column GRESA_SA_DTL.COMBINEGOODSQTY is '组合商品数量'
/

comment on column GRESA_SA_DTL.REDUCEDPRICE is '手工减价价格'
/

comment on column GRESA_SA_DTL.REDUCEDMONEY is '手工减价金额'
/

comment on column GRESA_SA_DTL.COMBPREMONEY is '组合商品优惠金额'
/

comment on column GRESA_SA_DTL.COMBPRICE is '组合商品价格'
/

comment on column GRESA_SA_DTL.ZXCOLUMN1 is '复核员'
/

comment on column GRESA_SA_DTL.ZXCOLUMN2 is 'OTO销售渠道'
/

comment on column GRESA_SA_DTL.ZXCOLUMN3 is '值为‘1’是从10021生成的流水'
/

comment on column GRESA_SA_DTL.ZXCOLUMN4 is '值为‘1’是会员补卡生成的流水'
/

comment on column GRESA_SA_DTL.ZXCOLUMN5 is '小票类型'
/

comment on column GRESA_SA_DTL.COSTINGPRICE is '成本价'
/

comment on column GRESA_SA_DTL.COSTINGMONEY is '成本金额'
/

comment on column GRESA_SA_DTL.NOPROMFLAG is '不参与整单促销标记'
/

comment on column GRESA_SA_DTL.PEIFANGMANID is '配方员ID'
/

comment on column GRESA_SA_DTL.SHENFANGMANID is '审方员ID'
/

comment on column GRESA_SA_DTL.GOODSNO is '商品编码'
/

comment on column GRESA_SA_DTL.LOTNO is '批号	'
/

comment on column GRESA_SA_DTL.NOSINGLEPROMFLAG is '单品系列取促'
/

comment on column GRESA_SA_DTL.SETMARKETMONEY is '系列促销折扣金额'
/

comment on column GRESA_SA_DTL.SETMARKETPREMONEY is '系列促销优惠金额'
/

comment on column GRESA_SA_DTL.ZX_REALMONEY is '专项实收金额'
/

comment on column GRESA_SA_DTL.PUSH_CLASS is '主推级别'
/

comment on column GRESA_SA_DTL.IS_SALE_PRICE is '是否特价商品'
/

comment on column GRESA_SA_DTL.YBCODE is '医保编码'
/

comment on column GRESA_SA_DTL.ACTIVITYMONEY is '活动赠品金额'
/

comment on column GRESA_SA_DTL.ACTIVITYFLAG is '活动赠品标识'
/

comment on column GRESA_SA_DTL.ZX_PROVINCECOLLFLAG is '省局零售采集标志'
/

comment on column GRESA_SA_DTL.IS_MI is '是否医保'
/

comment on column GRESA_SA_DTL.MI_CLASS is '医保甲乙类'
/

comment on column GRESA_SA_DTL.REDUCEDPRICEMEMO is '手工折价备注'
/

comment on column GRESA_SA_DTL.CNAME is '患者姓名'
/

comment on column GRESA_SA_DTL.IDCODE is '身份证号'
/

comment on column GRESA_SA_DTL.TELEPHONE is '电话'
/

comment on column GRESA_SA_DTL.OTHERID is '复核员ID'
/

comment on column GRESA_SA_DTL.RECIPMEMO is '处方内容'
/

comment on column GRESA_SA_DTL.AGE is '年龄'
/

comment on column GRESA_SA_DTL.SEX is '性别 1代表：男, 2代表：女'
/

comment on column GRESA_SA_DTL.ZXPRICE is '分摊前价格'
/

comment on column GRESA_SA_DTL.ZXMONEY is '分摊前金额'
/

comment on column GRESA_SA_DTL.COSTPRICE is '未含税成本'
/

comment on column GRESA_SA_DTL.DHID is '兑换设置id'
/

comment on column GRESA_SA_DTL.DHINTEGRAL is '兑换积分'
/

comment on column GRESA_SA_DTL.DHMOENY is '抵扣金额'
/

comment on column GRESA_SA_DTL.RULECODE is '优惠劵规则'
/

comment on column GRESA_SA_DTL.VOUCHERCODE is '优惠劵编码'
/

comment on column GRESA_SA_DTL.VOUCHERMONEY is '单品优惠金额'
/

comment on column GRESA_SA_DTL.VOUCHERSUBTYPE is '劵类型'
/

comment on column GRESA_SA_DTL.SERIESMONEY is '系列品种优惠金额'
/

comment on column GRESA_SA_DTL.GROUPMONEY is '组合品种优惠金额'
/

comment on column GRESA_SA_DTL.ALLMONEY is '整单全场优惠金额'
/

comment on column GRESA_SA_DTL.NOMONEY is '整单不参与品优惠金额'
/

comment on column GRESA_SA_DTL.LEVELMONEY is '整单参与级别优惠金额'
/

comment on column GRESA_SA_DTL.NOLEVELMONEY is '整单不参与级别优惠金额'
/

comment on column GRESA_SA_DTL.SETNO is '系列编码'
/

comment on column GRESA_SA_DTL.DHQTY is '兑换数量'
/

comment on column GRESA_SA_DTL.JT_AMT is '加提金额参数'
/

comment on column GRESA_SA_DTL.SZYBTRANSFLAG is '医保进销存上传标识'
/

comment on column GRESA_SA_DTL.BREAKDTLID is '拆零管理细单ID'
/

comment on column GRESA_SA_DTL.SURPLUS_NUMBER is '拆零剩余份数'
/

comment on column GRESA_SA_DTL.SALE_NUMBER is '拆零销售份数'
/

comment on column GRESA_SA_DTL.PRICE07 is '会员价/员工价'
/

comment on column GRESA_SA_DTL.EXEC_PRICE is '促销执行价'
/

comment on column GRESA_SA_DTL.PROM_FLAG is '是否有促销：Y/N'
/

comment on column GRESA_SA_DTL.ZZ_PRICE is '至尊价格'
/

comment on column GRESA_SA_DTL.RSAFLAG is '限购判断'
/

comment on column GRESA_SA_DTL.LOW_PRICE is '商品低价'
/

comment on column GRESA_SA_DTL.UNIT_PRICE is '商品标准单价'
/

comment on column GRESA_SA_DTL.ROYALTY_RATE is '提成比例'
/

comment on column GRESA_SA_DTL.ZZHY_ZK is '至尊会员折扣'
/

comment on column GRESA_SA_DTL.PROMORDERDTLID is '中台细单ID'
/

comment on column GRESA_SA_DTL.USEPRICE2 is '分摊单价(中台)'
/

comment on column GRESA_SA_DTL.REALMONEY2 is '分摊金额(中台)'
/

comment on column GRESA_SA_DTL.ZX_YLZD is '预留字段'
/

comment on column GRESA_SA_DTL.SID is 'ERP传中台虚单'
/

comment on column GRESA_SA_DTL.SPLITORIRSADTLID is '拆单(中台)'
/

comment on column GRESA_SA_DTL.ISZPHG is '是否赠品换购'
/

comment on column GRESA_SA_DTL.ZPHGSID is '产生赠品换购原单'
/

comment on column GRESA_SA_DTL.RULEID is '促销中心策略总单ID'
/

comment on column GRESA_SA_DTL.RULEDTLID is '促销中心策略细单ID'
/

comment on column GRESA_SA_DTL.RULETYPE is '促销中心促销类型'
/

comment on column GRESA_SA_DTL.PROMORDERID is '中台单据ID'
/

comment on column GRESA_SA_DTL.UNITPRICE_BAK is '中药加价前的unitprice价'
/

comment on column GRESA_SA_DTL.USEPRICE_BAK is '中药加价前的useprice价'
/

comment on column GRESA_SA_DTL.ZY_ADDPRICE_RATE is '中药加价比率'
/

comment on column GRESA_SA_DTL.SUPPER_VIP_EXCLUSIVE is '至尊会员独享优惠价'
/

comment on column GRESA_SA_DTL.SUPPER_VIP_COUPON is '至尊会员独享优惠券'
/

comment on column GRESA_SA_DTL.PROMOTERNO is '推广员工号'
/

comment on column GRESA_SA_DTL.KH04_AKC515 is '保定医保_用法代码'
/

comment on column GRESA_SA_DTL.KH04_AKC516 is '保定医保_用法名称'
/

comment on column GRESA_SA_DTL.KH02_AKA072 is '保定医保_频次代码'
/

comment on column GRESA_SA_DTL.KH02_CKC402 is '保定医保_频次名称'
/

comment on column GRESA_SA_DTL.MEMBERSHIPMONEY is '会员主推优惠金额'
/

comment on column GRESA_SA_DTL.MEMBERSHIPMONEY2 is '会员主推优惠金额2'
/

comment on column GRESA_SA_DTL.VIPPRICE is '会员价'
/

comment on column GRESA_SA_DTL.EPHEDRINE is '是否麻黄碱 1 是 20201005添加'
/

comment on column GRESA_SA_DTL.PRE_REALMONEY is '优惠券预分摊后金额'
/

comment on column GRESA_SA_DTL.PRE_SHAREPRICE is '优惠券预分摊金额'
/

comment on column GRESA_SA_DTL.XQPRICE is '执行近效期打折标志'
/

comment on column GRESA_SA_DTL.SYS_MODIFYDATE is '时间戳'
/

comment on column GRESA_SA_DTL.ORDERDTLID is '电商'
/

comment on column GRESA_SA_DTL.ISPRE is '是否预热促销'
/

comment on column GRESA_SA_DTL.PREDATE is '预热日期'
/

comment on column GRESA_SA_DTL.THEMEID is '主题ID'
/

comment on column GRESA_SA_DTL.REDUCED_TYPE is '手工折价类型ID'
/

comment on column GRESA_SA_DTL.ZX_TOGBYBDATE is '医保数据上传时间'
/

comment on column GRESA_SA_DTL.RECIPEID is '主方细单id'
/

comment on column GRESA_SA_DTL.REALMONEY3 is '分摊金额（新小票）'
/

comment on column GRESA_SA_DTL.USEPRICE3 is '分摊单价（新小票）'
/

create index IDX_GSD_L_C
	on GRESA_SA_DTL (LOTID, COMBINESOURCEID)
/

create index IDX_GRESA_SA_DTL_CHUFANGDTLID
	on GRESA_SA_DTL (CHUFANGDTLID)
/

create unique index GRESA_SA_DTL_UK
	on GRESA_SA_DTL (RSADTLID)
/

create index GRESA_SA_DTL_CLERKERID_IDX
	on GRESA_SA_DTL (CLERKERID)
/

create index GRESA_SA_DTL_RSAID_IDX
	on GRESA_SA_DTL (RSAID)
/

create index GRESA_SA_DTL_GOODSID_IDX
	on GRESA_SA_DTL (GOODSID)
/

