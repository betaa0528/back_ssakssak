import{u as w}from"./stockStore-C02B7glj.js";import{_ as x,d as c,c as f,p as A,o as b,e as C,k as V,y as j,D as F,b as T,f as t,t as v,w as L,v as E,B as q,C as B,P as Q,g as M,F as O,h as N}from"./index-DvTNLHIP.js";import{a as R}from"./studentStockApi-kF3M_Z2u.js";const H={class:"container",style:{height:"100%"}},z={__name:"StockChart",setup(o){const p=w(),i=c(()=>p.chartData),s=c(()=>i.value.length===0?0:i.value.reduce((a,e)=>a.stockPrice>=e.stockPrice?a:e).stockPrice),_=a=>{if(!a||isNaN(a))return[0,0,0,0];const e=parseInt(a+(Math.random()*10-4)),r=parseInt(a+(Math.random()*8+2)),k=parseInt(a-(Math.random()*6+2)),y=parseInt(a),S=Math.max(e,r,y),g=Math.min(e,k,y);return[e,S,g,y]},d=a=>a.map(e=>({x:new Date(e.stockDate),y:_(e.stockPrice)})),n=f([{name:"Stock Prices",data:d(i.value)}]);A(i,a=>{n.value[0].data=d(a)});const u=f({chart:{id:"basic-bar"},height:"100%",xaxis:{type:"datetime",labels:{formatter:function(a){return new Date(a).getDate()}},tickAmount:i.value.length},yaxis:{tooltip:{enabled:!0},range:s.value+10}});return(a,e)=>(b(),C("div",H,[V(j(F),{style:{width:"100%",height:"100%"},type:"candlestick",options:u.value,series:n.value},null,8,["options","series"])]))}},G=x(z,[["__scopeId","data-v-8f6727d1"]]),D=o=>(q("data-v-fb9aa980"),o=o(),B(),o),J={class:"modal-wrap"},K={class:"modal-container p-4 shadow-lg rounded bg-white"},W=D(()=>t("div",{class:"modal-header mb-4 d-flex justify-content-between align-items-center"},[t("span",{class:"fs-3 fw-bold"},"싹싹주식 매수하기")],-1)),X={class:"modal-body"},Y={class:"mb-2"},Z=D(()=>t("span",{class:"fs-5"},"싹싹 주식 금액 : ",-1)),tt={class:"fs-5 fw-bold"},st={class:"mb-3"},et=D(()=>t("span",{class:"fs-5"},"구매 가능한 주식 수량 : ",-1)),at={class:"fs-5 fw-bold text-primary"},ot={class:"mb-3"},nt=D(()=>t("span",{class:"d-block fs-5 mb-2"},"구매할 수량",-1)),ct={class:"d-flex align-items-center"},lt={class:"mt-2"},rt={class:"mb-3"},it=D(()=>t("span",{class:"d-block fs-5"},"주문 금액:",-1)),ut={class:"fw-bold"},dt={__name:"StockBuy",emits:["closePop"],setup(o,{emit:p}){const i=T(),s=f(""),_=w(),d=c(()=>_.myStock),n=c(()=>_.chartData),u=c(()=>{const l=n.value[n.value.length-1];return!l||!l.stockPrice?0:parseInt(d.value.seed/l.stockPrice)}),a=c(()=>n.value.length===0?0:n.value[n.value.length-1]);console.log(a.value.stockPrice);const e=c(()=>s.value*a.value.stockPrice),r=f({username:i.username,name:i.name,quantity:"",stock_price:""}),k=l=>{s.value=Number(s.value)+Number(l)},y=()=>{s.value=u.value},S=p,g=async()=>{r.value.quantity=s.value,r.value.stock_price=a.value.stockPrice;try{const l=await R.buyStock(r.value);_.updateMyStock(l.data),h()}catch(l){console.error("주식사기 실패..",l)}},h=()=>{S("close")};return(l,m)=>(b(),C("div",J,[t("div",K,[W,t("div",X,[t("div",Y,[Z,t("span",tt,v(a.value.stockPrice)+" 씨드",1)]),t("div",st,[et,t("span",at,v(u.value)+" 싹싹",1)]),t("div",ot,[nt,t("div",ct,[L(t("input",{type:"number",class:"form-control w-50","onUpdate:modelValue":m[0]||(m[0]=I=>s.value=I),placeholder:"0"},null,512),[[E,s.value]])]),t("div",lt,[t("button",{class:"btn btn-outline btn-outline-danger me-2 pt-0 pb-1",onClick:m[1]||(m[1]=I=>k(5))},"+5"),t("button",{class:"btn btn-outline-danger btn-color-danger me-2 pt-0 pb-1",onClick:m[2]||(m[2]=I=>k(10))},"+10"),t("button",{class:"btn btn-outline-danger btn-color-danger me-2 pt-0 pb-1",onClick:m[3]||(m[3]=I=>k(20))},"+20"),t("button",{class:"btn btn-outline-danger btn-color-danger pt-0 pb-1",onClick:y},"전체")])]),t("div",rt,[it,t("span",ut,v(e.value)+" 씨드",1)])]),t("div",{class:"modal-footer d-flex justify-content-end"},[t("button",{class:"btn btn-secondary me-2",onClick:h},"닫기"),t("button",{class:"btn btn-danger",onClick:g},"매수하기")])])]))}},_t=x(dt,[["__scopeId","data-v-fb9aa980"]]),P=o=>(q("data-v-0ae70bca"),o=o(),B(),o),ht={class:"modal-wrap"},mt={class:"modal-container p-4 shadow-lg rounded bg-white"},vt=P(()=>t("div",{class:"modal-header mb-4 d-flex justify-content-between align-items-center"},[t("span",{class:"fs-3 fw-bold"},"싹싹주식 판매하기")],-1)),pt={class:"modal-body"},bt={class:"mb-2"},ft=P(()=>t("span",{class:"fs-5"},"싹싹 주식 금액 : ",-1)),kt={class:"fs-5 fw-bold"},yt={class:"mb-3"},gt=P(()=>t("span",{class:"fs-5"},"판매 가능한 주식 수량 : ",-1)),$t={class:"fs-5 fw-bold txt-primary"},St={class:"mb-3"},wt=P(()=>t("span",{class:"d-block fs-5 mb-2"},"판매할 수량",-1)),xt={class:"d-flex align-items-center"},Ct={class:"mt-2"},Dt={class:"mb-3"},Pt=P(()=>t("span",{class:"fs-5 me-2"},"주문 금액 :",-1)),It={class:"fs-5 fw-bold"},Nt={__name:"StockSell",emits:["closePop"],setup(o,{emit:p}){const i=T(),s=f(""),_=w(),d=c(()=>_.myStock),n=c(()=>_.chartData);c(()=>{const h=n.value[n.value.length-1];return!h||!h.stockPrice?0:parseInt(d.value.seed/h.stockPrice)});const u=c(()=>n.value.length===0?0:n.value[n.value.length-1]),a=c(()=>s.value*u.value.stockPrice),e=f({username:i.username,name:i.name,quantity:"",stock_price:""}),r=h=>{s.value=Number(s.value)+Number(h)},k=()=>{s.value=d.value.totalQuantity},y=p,S=async()=>{e.value.quantity=s.value,e.value.stock_price=u.value.stockPrice;try{const h=await R.sellStock(e.value);_.updateMyStock(h.data),g()}catch(h){console.error("주식팔기 실패..",h)}},g=()=>{y("close")};return(h,l)=>(b(),C("div",ht,[t("div",mt,[vt,t("div",pt,[t("div",bt,[ft,t("span",kt,v(u.value.stockPrice)+" 씨드",1)]),t("div",yt,[gt,t("span",$t,v(d.value.totalQuantity)+" 싹싹",1)]),t("div",St,[wt,t("div",xt,[L(t("input",{type:"number",class:"form-control w-50","onUpdate:modelValue":l[0]||(l[0]=m=>s.value=m),placeholder:"0"},null,512),[[E,s.value]])]),t("div",Ct,[t("button",{class:"btn btn-outline btn-quantity btn-outline-primary me-2",onClick:l[1]||(l[1]=m=>r(5))},"+5"),t("button",{class:"btn btn-outline-primary btn-quantity btn-color-primary me-2",onClick:l[2]||(l[2]=m=>r(10))},"+10"),t("button",{class:"btn btn-outline-primary btn-quantity btn-color-primary me-2",onClick:l[3]||(l[3]=m=>r(20))},"+20"),t("button",{class:"btn btn-outline-primary btn-quantity btn-color-primary",onClick:k},"최대")])]),t("div",Dt,[Pt,t("span",It,v(a.value)+" 씨드",1)])]),t("div",{class:"modal-footer d-flex justify-content-end"},[t("button",{class:"btn btn-secondary me-2",onClick:g},"닫기"),t("button",{class:"btn btn-primary",onClick:S},"매도하기")])])]))}},qt=x(Nt,[["__scopeId","data-v-0ae70bca"]]),U=o=>(q("data-v-9050aae0"),o=o(),B(),o),Bt={class:"container p-0 mt-2"},Qt={class:"mt-2"},Mt=U(()=>t("span",{class:"fs-4"},"현재 주문 가능 주식 : ",-1)),Tt={class:"fs-4 fw-semibold"},Vt=U(()=>t("span",{class:"fs-4"},"현재 판매 가능 주식 : ",-1)),jt={class:"fs-4 fw-semibold"},Lt={__name:"StockTrade",setup(o){const p=w(),i=c(()=>p.myStock),s=c(()=>p.chartData),_=c(()=>{const e=s.value[s.value.length-1];return!e||!e.stockPrice?0:parseInt(i.value.seed/e.stockPrice)}),d=f(!1),n=f(!1),u=()=>{d.value=!d.value},a=()=>{n.value=!n.value};return(e,r)=>(b(),C(O,null,[t("div",Bt,[t("div",Qt,[Mt,t("span",Tt,v(_.value)+" 싹싹",1)]),t("div",null,[Vt,t("span",jt,v(i.value.totalQuantity)+" 싹싹",1)]),t("div",{class:"mt-4 d-flex"},[t("button",{class:"btn btn-danger me-1 w-50",onClick:u},"주식 구매하기"),t("button",{class:"btn btn-primary w-50",onClick:a},"주식 판매하기")])]),d.value?(b(),Q(_t,{key:0,onClose:u})):M("",!0),n.value?(b(),Q(qt,{key:1,onClose:a})):M("",!0)],64))}},Et=x(Lt,[["__scopeId","data-v-9050aae0"]]),$=o=>(q("data-v-9f15c3e2"),o=o(),B(),o),Rt={class:"container"},Ut={class:"shadow card p-4 bg-card"},At={class:"row"},Ft={class:"col-5"},Ot=$(()=>t("div",{class:"mx-1 mt-2 mb-3"},null,-1)),Ht=$(()=>t("div",{class:"d-flex align-items-center mb-2"},null,-1)),zt={class:"chart-title"},Gt={class:"fs-5 mb-0 text-danger fw-semibold"},Jt=$(()=>t("span",{class:"text-gray"},"오늘의 가격",-1)),Kt={class:"fs-5 txt-primary fw-semibold"},Wt=$(()=>t("span",{class:"fs-6 text-muted pe-2"},"어제보다",-1)),Xt=$(()=>t("hr",null,null,-1)),Yt={class:"fs-5 mt-3 mb-1"},Zt={class:"fw-bold text-danger"},ts={class:"fs-5 mb-1 mb-3"},ss={class:"fw-bold txt-primary"},es=$(()=>t("hr",null,null,-1)),as={class:"col-7"},os={__name:"StockChartLayout",setup(o){const p=w(),i=T(),s=c(()=>p.chartData),_=i.roles,d=c(()=>s.value.length===0?0:s.value.reduce((e,r)=>e.stockPrice>=r.stockPrice?e:r)),n=c(()=>s.value.length===0?0:s.value.reduce((e,r)=>e.stockPrice<=r.stockPrice?e:r)),u=c(()=>s.value.length===0?0:s.value[s.value.length-1]),a=c(()=>s.value.length===0?0:s.value[s.value.length-1].stockPrice-s.value[s.value.length-2].stockPrice);return(e,r)=>(b(),C("div",Rt,[t("div",Ut,[t("div",At,[t("div",Ft,[Ot,Ht,t("div",zt,[t("p",Gt,[Jt,N(" "+v(u.value.stockPrice)+" 씨드",1)])]),t("p",Kt,[Wt,N(" "+v(a.value)+" 씨드 ("+v(u.value.change>=0?`+${u.value.change}`:u.value.change)+"%) ",1)]),Xt,t("p",Yt,[N("최고 가격 (30일): "),t("span",Zt,v(d.value.stockPrice)+" 씨드",1)]),t("p",ts,[N("최저 가격 (30일): "),t("span",ss,v(n.value.stockPrice)+" 씨드",1)]),es,t("div",null,[j(_)[0]==="ROLE_STUDENT"?(b(),Q(Et,{key:0})):M("",!0)])]),t("div",as,[V(G)])])])]))}},rs=x(os,[["__scopeId","data-v-9f15c3e2"]]);export{rs as S};