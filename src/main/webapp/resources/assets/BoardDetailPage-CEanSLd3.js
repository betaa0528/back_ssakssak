import{_ as N,b as F,u as L,a as M,c as k,o as c,e as r,f as t,t as o,h as d,y as p,F as b,q as w,g,w as S,v as A,B as V,C as E}from"./index-DvTNLHIP.js";import{b as f}from"./boardApi-BOuP6GHb.js";import{h as x}from"./moment-C5S46NFB.js";const T=async i=>{try{const l=document.createElement("a");l.href=i,document.body.appendChild(l),l.click(),document.body.removeChild(l)}catch(l){console.error(l)}},n=i=>(V("data-v-626d2dd2"),i=i(),E(),i),$={class:"my-3 d-flex justify-content-between"},j=n(()=>t("i",{class:"fa-solid fa-user"},null,-1)),H=n(()=>t("i",{class:"fa-regular fa-clock"},null,-1)),P=n(()=>t("hr",null,null,-1)),U={class:"text-end"},O=["onClick"],z=n(()=>t("i",{class:"fa-solid fa-paperclip"},null,-1)),G={class:"content"},J={class:"my-5"},K=n(()=>t("i",{class:"fa-solid fa-list"},null,-1)),Q=n(()=>t("i",{class:"fa-regular fa-pen-to-square"},null,-1)),W=n(()=>t("i",{class:"fa-solid fa-trash-can"},null,-1)),X={class:"row mt-2"},Z={class:"col-11"},tt=n(()=>t("label",{class:"form-label"},"댓글",-1)),et={class:"col-1"},st=n(()=>t("label",{class:"form-label"},[d("   "),t("span",{class:"text-body-secondary"})],-1)),ot={class:"table table-striped mt-4"},lt=n(()=>t("thead",null,[t("tr",null,[t("th",{style:{width:"60px"}},"No"),t("th",null,"댓글 내용"),t("th",{style:{width:"150px"}},"작성자"),t("th",{style:{width:"120px"}},"작성일"),t("th",{style:{width:"80px"}})])],-1)),at={key:0},nt=["onClick"],ct={__name:"BoardDetailPage",setup(i){const l=F(),_=L(),v=M(),h=_.params.no,a=k({}),m=k(""),C=()=>{v.push({name:"board/list",query:_.query})},D=()=>{v.push({name:"board/update",params:{no:h},query:_.query})},I=async u=>{const s="/api/board/download/"+u;console.log(s),await T(s)},q=async()=>{confirm("삭제할까요?")&&(await f.delete(h),v.push({name:"board/list",query:_.query}))},y=async()=>{a.value=await f.get(h),console.log("DETAIL",a.value)};y();const Y=async()=>{if(m.value==null||m.value.length==0){alert("내용이 없습니다.");return}const u={bno:h,content:m.value,writer:l.id},s=await f.sendReply(u);console.log(s),s!=null?(alert("댓글이 등록 되었습니다."),y()):alert("댓글 등록에 실패 하였습니다.")},R=async u=>{const s=await f.deleteReply(u);console.log(s),s!=null?(alert("댓글이 삭제 되었습니다."),y()):alert("댓글 삭제에 실패 하였습니다.")};return(u,s)=>(c(),r(b,null,[t("h1",null,o(a.value.title),1),t("div",$,[t("div",null,[j,d(" "+o(a.value.memberName)+" ("+o(a.value.memberId)+") ",1)]),t("div",null,[H,d(" "+o(p(x)(a.value.updateDate).format("YYYY-MM-DD HH:mm")),1)])]),P,t("div",U,[(c(!0),r(b,null,w(a.value.boardAttachFileList,e=>(c(),r("div",{key:e.fno,class:"attach"},[t("span",{onClick:B=>I(e.fno)},[z,d(" "+o(e.originalFilename),1)],8,O)]))),128))]),t("div",G,o(a.value.content),1),t("div",J,[t("button",{class:"btn btn-primary me-2",onClick:C},[K,d(" 목록")]),p(l).id==a.value.memberId?(c(),r(b,{key:0},[t("button",{class:"btn btn-primary me-2",onClick:D},[Q,d(" 수정")]),t("button",{class:"btn btn-danger",onClick:q},[W,d(" 삭제")])],64)):g("",!0)]),t("div",X,[t("div",Z,[tt,S(t("input",{"onUpdate:modelValue":s[0]||(s[0]=e=>m.value=e),type:"text",class:"form-control",placeholder:"내용을 입력하세요."},null,512),[[A,m.value]])]),t("div",et,[st,t("button",{class:"form-control btn btn-primary",onClick:s[1]||(s[1]=e=>Y())},"작성")])]),t("table",ot,[lt,t("tbody",null,[(c(!0),r(b,null,w(a.value.replyList,e=>(c(),r("tr",{key:e.rno},[t("td",null,o(e.rno),1),t("td",null,o(e.content),1),t("td",null,o(e.memberName)+"("+o(e.memberId)+")",1),t("td",null,o(p(x)(e).format("YYYY-MM-DD")),1),t("td",null,[e.memberId==p(l).id?(c(),r("span",at,[t("button",{class:"btn btn-close",onClick:B=>R(e.rno)},null,8,nt)])):g("",!0)])]))),128))])])],64))}},ut=N(ct,[["__scopeId","data-v-626d2dd2"]]);export{ut as default};
