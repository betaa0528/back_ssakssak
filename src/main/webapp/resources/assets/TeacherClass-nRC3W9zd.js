import{_ as I,c as b,r as T,o as l,e as o,f as t,h as V,i as g,F as u,q as p,g as y,t as f,B as A,C as B}from"./index-DvTNLHIP.js";import{a as N}from"./teacherClassApi-AZEW-Jam.js";const _=d=>(A("data-v-03e15d52"),d=d(),B(),d),j={class:"container my-5 p-5 bg-light rounded"},L=_(()=>t("h3",{class:"mb-4"},[t("strong",null,"파일 업로드")],-1)),q=_(()=>t("p",{class:"text-center",style:{"font-size":"1.1rem"}},"파일을 여기에 끌어다 놓거나, 파일 선택 버튼을 눌러 파일을 직접 선택해주세요.",-1)),z=_(()=>t("i",{class:"bi bi-upload me-2"},null,-1)),E={key:0,class:"mt-4"},M=["onClick"],P={class:"text-center mt-3"},R=["disabled"],U={key:1,class:"mt-5"},X=_(()=>t("h5",null,[t("strong",null,"CSV 파일 파싱 결과")],-1)),$={class:"table table-striped"},G={__name:"TeacherClass",setup(d){const m=b(null),r=T([]),c=b([]),k=s=>{const e=s.target.files;v(e);for(let n=0;n<e.length;n++){const a=e[n];if(a&&a.type==="text/csv"){const i=new FileReader;i.onload=h=>{const S=h.target.result;c.value=x(S),console.log("CSV Data Array:",c.value)},i.readAsText(a)}else console.error("Invalid file type. Please upload a CSV file.")}},x=s=>s.split(`
`).map(n=>n.split(",")),C=()=>{m.value.click()},v=s=>{for(let e=0;e<s.length;e++)r.push(s[e])},F=s=>{const e=s.dataTransfer.files;v(e)},w=s=>{r.splice(s,1)},D=async()=>{if(!r.length)return;const s=new FormData;s.append("file",r[0]);try{const e=await N.uploadCsv(s);console.log("파일 업로드 성공:",e),alert("파일이 성공적으로 등록되었습니다."),r.length=0}catch(e){console.error("파일 업로드 실패:",e),alert("파일 업로드 중 오류가 발생했습니다.")}};return(s,e)=>(l(),o("div",j,[L,t("div",{class:"upload-box bg-light d-flex flex-column justify-content-center align-items-center p-5 rounded",onDragover:e[0]||(e[0]=g(()=>{},["prevent"])),onDrop:g(F,["prevent"])},[q,t("input",{type:"file",onChange:k,class:"d-none",ref_key:"fileInput",ref:m,accept:".xls,.xlsx,.csv"},null,544),t("button",{class:"btn btn-primary mt-3",onClick:C},[z,V("파일 선택 ")])],32),r.length?(l(),o("div",E,[(l(!0),o(u,null,p(r,(n,a)=>(l(),o("div",{key:a,class:"d-flex justify-content-between align-items-center py-3 px-3 border"},[t("span",null,f(n.name),1),t("button",{class:"btn btn-link text-black",onClick:i=>w(a)},"X 삭제",8,M)]))),128))])):y("",!0),t("div",P,[t("button",{class:"btn btn-primary",disabled:!r.length,onClick:D}," 등록 ",8,R)]),c.value.length?(l(),o("div",U,[X,t("table",$,[t("thead",null,[t("tr",null,[(l(!0),o(u,null,p(c.value[0],(n,a)=>(l(),o("th",{key:a},f(n),1))),128))])]),t("tbody",null,[(l(!0),o(u,null,p(c.value.slice(1),(n,a)=>(l(),o("tr",{key:a},[(l(!0),o(u,null,p(n,(i,h)=>(l(),o("td",{key:h},f(i),1))),128))]))),128))])])])):y("",!0)]))}},K=I(G,[["__scopeId","data-v-03e15d52"]]);export{K as default};
