import{m as p,R as z,_ as J,c as w,u as O,a as Q,E as X,r as Y,d as G,p as Z,j as tt,o as n,e as l,f as t,F as L,q as R,g as S,i as et,w as T,v as j,t as r,k as st,l as C,A as N,L as at,B as dt,C as ot}from"./index-DvTNLHIP.js";const m="/api/teacher/reward",u={async getRewardList(){try{const{data:e}=await p.get(`${m}/list`);return console.log(e),e}catch(e){console.error("Failed fetch reward list",e)}},async addReward(e){try{const{data:d}=await p.post(`${m}/apply`,e);return d}catch(d){throw console.error("Failed reward add"),d}},async deleteReward(e){try{const{data:d}=await p.post(`${m}/${e}`);return d}catch(d){throw d}},async getStudentList(){try{const{data:e}=await p.get(`${m}/student-list`);return e}catch(e){throw e}},async sendRewardToStudent(e){try{return await p.post(`${m}/pay`,e)}catch(d){console.log(d)}},async getRewardGiveList(e){try{const{data:d}=await p.get(`${m}/pay/list`,{params:e});return d}catch(d){console.error(d)}}},ct=z("reward",{state:()=>({rewardList:[],rewardGiveList:[],studentList:[]}),actions:{async fetchRewardList(){try{const e=await u.getRewardList();this.rewardList=e}catch(e){throw console.error("Failed to fetch reward:",e),e}},async fetchStudentList(){try{const e=await u.getStudentList();this.studentList=e}catch(e){throw console.error("Failed to fetch studentList:",e),e}},async fetchRewardGiveList(){try{const e=await u.getRewardGiveList();this.rewardGiveList=e}catch(e){throw console.error("Failed to fetch rewardGiveList",e),e}}},persist:!0}),c=e=>(dt("data-v-56d4d63d"),e=e(),ot(),e),nt={class:"container mt-5"},lt={key:0},rt={class:"row"},it={class:"col-12 col-md-6 reward-list"},vt={class:"card shadow-sm mb-3",style:{height:"30%"}},ut=c(()=>t("div",{class:"reward-title mt-4 ms-4"},[t("span",{class:"fs-2 fw-bold ms-3"},"현재 리워드 목록")],-1)),_t={class:"card-body pt-0 mt-3"},ht=N('<div class="d-flex row m-0 mb-2 pe-3" style="width:100%;" data-v-56d4d63d><div class="col-6 text-center" data-v-56d4d63d><span class="h4" data-v-56d4d63d>리워드 명</span></div><div class="col-4 text-center" data-v-56d4d63d><span class="h4" data-v-56d4d63d>금액</span></div><div class="col-2 text-center" data-v-56d4d63d><span class="h4" data-v-56d4d63d>삭제</span></div></div><hr data-v-56d4d63d>',2),pt={key:0,class:"reward-list-wrap",style:{"overflow-y":"auto","max-height":"80vh"}},wt=["onClick"],mt={class:"fs-5 text-dark"},ft={class:"col-4 text-center"},xt={class:"fs-5 text-dark"},yt={class:"col-2 text-center pe-2"},gt=["onClick"],bt=c(()=>t("i",{class:"bi bi-trash"},null,-1)),kt=[bt],Lt={class:"mt-2"},Rt={class:"mb-3 d-flex justify-content-between align-items-center"},St=c(()=>t("label",{class:"form-label fs-5 fw-bold reward-label"},"리워드 명",-1)),Ct={class:"d-flex align-items-center reward-add-box"},It=c(()=>t("label",{class:"form-label fs-5 fw-bold reward-amount"},"금액",-1)),$t=c(()=>t("span",{class:"me-4"}," 씨드 ",-1)),Vt=c(()=>t("button",{class:"btn btn-primary px-3",type:"submit"},"리워드 추가",-1)),Gt={class:"card shadow-sm",style:{height:"30%"}},Nt=c(()=>t("span",{class:"fs-2 fw-bold ms-1"},"학생 목록",-1)),qt={class:"p-0 mt-3 text-center d-flex flex-column",style:{height:"100%"}},Ft=N('<div class="d-flex row m-0 mb-2 pe-2" style="width:100%;" data-v-56d4d63d><div class="col-2 text-center" data-v-56d4d63d><span class="h4" data-v-56d4d63d>선택</span></div><div class="col-2 text-center" data-v-56d4d63d><span class="h4" data-v-56d4d63d>번호</span></div><div class="col-4 text-center" data-v-56d4d63d><span class="h4" data-v-56d4d63d>이름</span></div><div class="col-4 text-center" data-v-56d4d63d><span class="h4" data-v-56d4d63d>보유 씨드</span></div></div>',1),Tt={class:"std-list-wrap",style:{"overflow-y":"scroll"}},jt=["onClick"],At={class:"col-2 text-center pt-1"},Bt=["value","onChange","checked"],Dt={class:"col-2 text-center",style:{"overflow-x":"auto"}},Ut={class:"fs-5 text-dark"},Et={class:"col-4 text-center"},Mt={class:"fs-5 text-dark"},Pt={class:"col-4 text-center"},Ht={class:"fs-5 text-dark"},Kt={class:"col-12 col-md-6"},Wt={class:"card shadow-sm reward-card d-flex flex-column",style:{height:"100%"}},zt={class:"m-4",style:{flex:"0.7",display:"flex","flex-direction":"column","justify-content":"flex-start","padding-top":"200px"}},Jt=c(()=>t("div",{class:"ms-2 mt-6"},[t("span",{class:"reward-title fs-3 fw-bold"},"리워드 적용 학생")],-1)),Ot={class:"d-flex mt-2 ms-3 flex-wrap"},Qt=["onClick"],Xt={class:"mx-4",style:{flex:"1",display:"flex","flex-direction":"column","justify-content":"flex-start"}},Yt=c(()=>t("div",{class:"ms-2"},[t("span",{class:"fs-3 fw-bold"},"적용 리워드")],-1)),Zt={class:"d-flex mt-2 ms-3 flex-wrap"},te={key:1},ee={class:"card mt-3 reward-card2"},se=c(()=>t("div",{class:"mt-4 ms-4"},[t("span",{class:"fs-2 fw-bold ms-3"},"리워드 지급 목록")],-1)),ae={class:"p-0 mt-3 d-flex flex-column",style:{height:"100%"}},de=N('<div class="d-flex row m-0 mb-2 mx-auto" style="width:90%;" data-v-56d4d63d><div class="col-3 text-center" data-v-56d4d63d><span class="h4" data-v-56d4d63d>날짜</span></div><div class="col-2 text-center" data-v-56d4d63d><span class="h4" data-v-56d4d63d>이름</span></div><div class="col-5 text-center" data-v-56d4d63d><span class="h4" data-v-56d4d63d>리워드명</span></div><div class="col-2 text-center" data-v-56d4d63d><span class="h4" data-v-56d4d63d>금액</span></div></div>',1),oe={class:"col-3 text-center"},ce={class:"fs-5 text-dark"},ne={class:"col-2 text-center",style:{"overflow-x":"auto"}},le={class:"fs-5 text-dark"},re={class:"col-5 text-center"},ie={class:"fs-5 text-dark"},ve={class:"col-2 text-center"},ue={class:"fs-5 text-dark"},_e={class:"my-5 d-flex"},he={class:"flex-grow-1 text-center"},pe=c(()=>t("i",{class:"fa-solid fa-backward-fast"},null,-1)),we=c(()=>t("i",{class:"fa-solid fa-caret-left"},null,-1)),me=c(()=>t("i",{class:"fa-solid fa-caret-right"},null,-1)),fe=c(()=>t("i",{class:"fa-solid fa-forward-fast"},null,-1)),xe={__name:"TeacherRewardPage",setup(e){const d=w("reward"),f=O(),A=Q(),v=ct();X(()=>{v.fetchRewardList(),v.fetchStudentList(),v.fetchRewardGiveList()});const x=w({}),y=Y({page:parseInt(f.query.page)||1,amount:parseInt(f.query.amount)||12});console.log(x.value);const I=G(()=>v.rewardList),B=G(()=>x.value.rewardList),q=G(()=>v.studentList),b=w(""),k=w(""),D=async()=>{try{const a={reward_name:b.value,reward_seed:k.value},o=await u.addReward(a);console.log(o),b.value="",k.value="",await v.fetchRewardList()}catch(a){console.log(a)}},U=async a=>{await u.deleteReward(a),v.fetchRewardList()},i=w([]),_=w(null),E=a=>{_.value=I.value.find(o=>o.rewardId===a)},M=()=>{_.value=""},$=a=>{console.log(a);const o=i.value.findIndex(h=>h.std_id===a.std_id);o>-1?i.value.splice(o,1):i.value.push(a)},P=()=>{i.value=[...q.value]},H=()=>{i.value=[]},K=async()=>{try{const o={students:i.value.map(s=>at(s)),reward_id:_.value.rewardId},h=await u.sendRewardToStudent(o);h.status===200&&alert(h.data),i.value=[],_.value=null,await v.fetchStudentList(),V()}catch{alert("잘못된 요청입니다.")}},W=async a=>{console.log("CLICK,,,,"),A.push({query:{page:a,amount:y.amount}})};Z(f,async a=>{console.log("WATCH",f.query.page),await V(f.query)});const V=async a=>{try{x.value=await u.getRewardGiveList(a),console.log("asdf",x.value)}catch{}};return V(y),(a,o)=>{const h=tt("vue-awesome-paginate");return n(),l("div",nt,[d.value==="reward"?(n(),l("div",lt,[t("div",rt,[t("div",it,[t("div",vt,[ut,t("div",_t,[ht,I.value?(n(),l("div",pt,[(n(!0),l(L,null,R(I.value,(s,g)=>(n(),l("div",{key:s.rewardId,class:"d-flex text-center py-2 list-item",style:{width:"100%"}},[t("div",{class:"col-6 text-center reward-name",onClick:F=>E(s.rewardId)},[t("span",mt,r(s.rewardName),1)],8,wt),t("div",ft,[t("span",xt,r(s.rewardSeed)+" 씨드",1)]),t("div",yt,[t("button",{type:"button",class:"btn btn-sm btn-outline-danger",onClick:F=>U(s.rewardId)},kt,8,gt)])]))),128))])):S("",!0),t("div",Lt,[t("form",{onSubmit:et(D,["prevent"])},[t("div",Rt,[St,T(t("input",{type:"text",class:"form-control reward-input","onUpdate:modelValue":o[0]||(o[0]=s=>b.value=s),placeholder:"ex) 밥을 남기지 않고 잘 먹어요"},null,512),[[j,b.value]])]),t("div",Ct,[It,T(t("input",{type:"text",class:"form-control me-2 w-50 text-end","onUpdate:modelValue":o[1]||(o[1]=s=>k.value=s),placeholder:"ex) 300"},null,512),[[j,k.value]]),$t,Vt])],32)])])]),t("div",Gt,[t("div",{class:"d-flex justify-content-between mt-4 ms-4"},[Nt,t("div",{class:"p-0 me-4"},[t("button",{class:"btn btn-primary me-2 py-2",onClick:P},"전체선택"),t("button",{class:"btn btn-outline-primary me-2 px-3 py-2",onClick:H},"전체선택해제")])]),t("div",qt,[Ft,t("div",Tt,[(n(!0),l(L,null,R(q.value,s=>(n(),l("div",{key:s.std_id,class:"d-flex text-center py-2 name-box",style:{width:"100%"},onClick:g=>$(s)},[t("div",At,[t("input",{type:"checkbox",value:s,onChange:g=>$(s),checked:i.value.includes(s)},null,40,Bt)]),t("div",Dt,[t("span",Ut,r(s.std_id),1)]),t("div",Et,[t("span",Mt,r(s.std_name),1)]),t("div",Pt,[t("span",Ht,r(s.seed),1)])],8,jt))),128))])])])]),t("div",Kt,[t("div",Wt,[t("div",zt,[Jt,t("div",Ot,[(n(!0),l(L,null,R(i.value,(s,g)=>(n(),l("div",{key:g,class:"btn btn-warning cyan me-2 mb-3",onClick:F=>$(s)},r(s.std_name),9,Qt))),128))])]),t("div",Xt,[Yt,t("div",Zt,[_.value?(n(),l("div",{key:0,class:"btn btn-warning d-inline-block",onClick:M},r(_.value.rewardName),1)):S("",!0)])]),t("div",{class:"text-center p-3 mt-auto mb-4"},[t("button",{class:"btn btn-warning",style:{width:"80%"},onClick:K},"리워드 지급")])])])])])):S("",!0),d.value==="reward"?(n(),l("div",te,[t("div",ee,[se,t("div",null,[t("div",ae,[de,t("div",null,[(n(!0),l(L,null,R(B.value,(s,g)=>(n(),l("div",{key:s.giveId,class:"d-flex py-2 mx-auto",style:{width:"90%"}},[t("div",oe,[t("span",ce,r(s.giveDate),1)]),t("div",ne,[t("span",le,r(s.stdName),1)]),t("div",re,[t("span",ie,r(s.rewardName),1)]),t("div",ve,[t("span",ue,r(s.giveSeed)+" 씨드",1)])]))),128)),t("div",_e,[t("div",he,[st(h,{"total-items":x.value.totalCount,"items-per-page":y.amount,"max-pages-shown":5,"show-ending-buttons":!0,modelValue:y.page,"onUpdate:modelValue":o[2]||(o[2]=s=>y.page=s),onClick:W},{"first-page-button":C(()=>[pe]),"prev-button":C(()=>[we]),"next-button":C(()=>[me]),"last-page-button":C(()=>[fe]),_:1},8,["total-items","items-per-page","modelValue"])])])])])])])])):S("",!0)])}}},ge=J(xe,[["__scopeId","data-v-56d4d63d"]]);export{ge as default};
