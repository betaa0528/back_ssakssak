import{S as V}from"./StockChartLayout-D9FYjZTr.js";import{m as v,_ as x,c as $,o as i,e as d,f as t,i as B,w as f,v as g,d as y,C as D,F as k,q as M,t as m,N as P,h as I,n as w,g as F,k as h}from"./index-gxZJ1D_R.js";import{u as C}from"./stockStore-sz4ZB7M7.js";/* empty css                                                                        */import"./studentStockApi-CKw2OddO.js";const b="/api/teacher/stock",S={async getStockNewsList(){const{data:r}=await v.get(`${b}/news/list`);return r},async addRate(r){try{const a=await v.post(`${b}/rate-apply`,r);console.log("등락률 추가 결과",a)}catch(a){throw a}},async addNews(r){try{return await v.post(`${b}/news`,r)}catch(a){throw a}},async delete(r){try{return await v.post(`${b}/news/${r}`)}catch(a){throw a}}},U={class:"modal-wrap"},j={class:"modal-container p-4 shadow-lg rounded bg-white"},T={class:"mb-3"},q={class:"mb-3"},E={__name:"StockCreateNewsModal",emits:["closeModal","submitForm"],setup(r,{emit:a}){const n=C(),c=$({title:"",content:""}),u=a,l=async()=>{const e=await S.addNews(c.value);e.status===200&&p(),console.log(e),await n.fetchNewsList()},p=()=>{u("close")};return(e,s)=>(i(),d("div",U,[t("div",j,[s[5]||(s[5]=t("h4",{class:"mb-4"},"뉴스 입력하기",-1)),t("form",{onSubmit:B(l,["prevent"])},[t("div",T,[s[2]||(s[2]=t("label",{for:"title",class:"form-label"},"제목",-1)),f(t("input",{type:"text",id:"title",class:"form-control","onUpdate:modelValue":s[0]||(s[0]=o=>c.value.title=o),placeholder:"제목을 입력하세요"},null,512),[[g,c.value.title]])]),t("div",q,[s[3]||(s[3]=t("label",{for:"content",class:"form-label"},"내용",-1)),f(t("textarea",{id:"content",class:"form-control",rows:"5","onUpdate:modelValue":s[1]||(s[1]=o=>c.value.content=o),placeholder:"내용을 입력하세요"},null,512),[[g,c.value.content]])]),t("div",{class:"d-flex justify-content-end"},[t("button",{type:"button",class:"btn btn-secondary me-2",onClick:p},"취소"),s[4]||(s[4]=t("button",{type:"submit",class:"btn btn-primary"},"등록",-1))])],32)])]))}},z=x(E,[["__scopeId","data-v-507e5fd1"]]),A={class:"container"},Y={class:"shadow card p-4"},G={class:"cardBody p-0"},H={class:"list-group px-2"},J={class:"fw-semibold"},K=["onClick"],O={__name:"StockNewsCreate",setup(r){const a=C(),n=y(()=>a.newsList);D(()=>{a.fetchNewsList()});const c=async e=>{(await S.delete(e)).status===200&&a.fetchNewsList()},u=$(!1),l=()=>{u.value=!u.value},p=e=>{console.log(e),newsData.value.push(e),l()};return(e,s)=>(i(),d(k,null,[t("div",A,[t("div",Y,[s[1]||(s[1]=t("div",{class:"mb-3"},[t("span",{class:"fs-2 fw-bold"},"주식 뉴스 관리")],-1)),t("div",G,[t("ul",H,[(i(!0),d(k,null,M(n.value,(o,_)=>(i(),d("li",{class:"list-group-item border-0 px-0 py-2 d-flex justify-content-between align-items-center",key:_,style:{"border-bottom":"1px solid rgba(0, 0, 0, 0.1)",transition:"background-color 0.3s"}},[t("span",null,m(o.newsDate),1),t("span",J,m(o.title),1),t("button",{type:"button",class:"btn btn-sm btn-outline-danger me-3",onClick:N=>c(o.newsId)},s[0]||(s[0]=[t("i",{class:"bi bi-trash"},null,-1)]),8,K)]))),128))]),t("div",{class:"mt-3"},[t("button",{class:"btn btn-primary btn-lg w-100",onClick:l}," 새 뉴스 만들기 ")])])])]),u.value?(i(),P(z,{key:0,onSubmitForm:p,onClose:l})):I("",!0)],64))}},Q=x(O,[["__scopeId","data-v-28d20536"]]),W={class:"container"},X={class:"shadow card p-4"},Z={class:"section"},tt={class:"list-group"},st={class:"fs-6 fw-semibold"},et={class:"mt-2"},ot={class:"row d-flex align-items-center"},at={class:"col-9 d-flex p-0"},nt={__name:"StockRate",setup(r){const a=C();D(async()=>{await a.fetchChartData()});const n=y(()=>a.chartData),c=e=>e.getFullYear()+"-"+(e.getMonth()+1<10?"0"+(e.getMonth()+1):e.getMonth()+1)+"-"+(e.getDate()<10?"0"+e.getDate():e.getDate()),u=y(()=>{const e=[];if(n.value&&n.value.length>0){for(let s=n.value.length-1;s>=n.value.length-5;s--)if(s>=0){console.log(n.value[s]);const o=n.value[s].stockPrice,_=new Date(n.value[s].stockDate),N=c(_),L=n.value[s].change,R={price:o,day:N,change:L};e.push(R)}}return e}),l=$(""),p=async()=>{if(l.value>100){alert("0에서 100사이의 숫자로 입력해주세요");return}else{if(l.value==="")return;if(isNaN(l.value)){alert("숫자만 입력해주세요"),l.value="";return}}try{const s=n.value[n.value.length-1].stockPrice*(1+parseFloat(l.value)/100),o={change:l.value,stock_price:parseInt(s)};await S.addRate(o),l.value="",await a.fetchChartData()}catch(e){console.error(e)}};return(e,s)=>(i(),d("div",W,[t("div",X,[s[4]||(s[4]=t("div",null,[t("span",{class:"fs-2 fw-bold"},"주식 등락률 관리")],-1)),t("div",Z,[t("ul",tt,[(i(!0),d(k,null,M(u.value,(o,_)=>(i(),d("li",{key:_,class:w(["list-group-item border-0 p-3 mb-2 d-flex justify-content-between align-items-center shadow-sm rounded",{"bg-light-success":parseFloat(o)>0,"bg-light-danger":parseFloat(o)<0}])},[t("span",st,[F(m(o.day)+" : ",1),t("span",{class:w(parseFloat(o.change)>0?"text-danger":"txt-primary")},m(o.price),3),s[1]||(s[1]=F(" 씨드 ")),t("span",{class:w(parseFloat(o.change)>0?"text-danger":"txt-primary")},"   "+m(o.change)+"% ",3),t("span",null,m(o.change>0?o.change===0?"보합":"상승":"하락"),1)]),t("i",{class:w([parseFloat(o.change)>0?"bi bi-arrow-up text-danger":"bi bi-arrow-down txt-primary","fs-5"])},null,2)],2))),128))])]),t("div",et,[s[3]||(s[3]=t("span",{class:"fs-5 fw-semibold ps-2"},"주식 등락률 설정",-1)),t("div",ot,[s[2]||(s[2]=t("div",{class:"col-3"},[t("span",{class:"fs-6 fw-bold ps-3"},"오늘 등락률: ")],-1)),t("div",at,[f(t("input",{type:"text","onUpdate:modelValue":s[0]||(s[0]=o=>l.value=o),class:"form-control w-75 mx-2",placeholder:"등락률을 입력하세요 (%)"},null,512),[[g,l.value]]),t("button",{class:"btn btn-primary",onClick:p}," 확인 ")])])])])]))}},lt=x(nt,[["__scopeId","data-v-0a1bc1d0"]]),rt={class:"container mt-3",style:{width:"90vw"}},ct={class:"row"},it={class:"col-12"},dt={class:"row mt-3 g-0"},ut={class:"col-6"},pt={class:"col-6"},ht={__name:"TeacherStockPage",setup(r){return(a,n)=>(i(),d("div",rt,[t("div",ct,[t("div",it,[h(V)])]),t("div",dt,[t("div",ut,[h(lt)]),t("div",pt,[h(Q)])])]))}};export{ht as default};
