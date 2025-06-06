<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row >
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="美食名称" prop="meishimingcheng">
          <el-input v-model="ruleForm.meishimingcheng" 
              placeholder="美食名称" clearable  :readonly="ro.meishimingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="美食名称" prop="meishimingcheng">
              <el-input v-model="ruleForm.meishimingcheng" 
                placeholder="美食名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="美食类型" prop="meishileixing">
          <el-input v-model="ruleForm.meishileixing" 
              placeholder="美食类型" clearable  :readonly="ro.meishileixing"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="美食类型" prop="meishileixing">
              <el-input v-model="ruleForm.meishileixing" 
                placeholder="美食类型" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info' && !ro.meishitupian" label="美食图片" prop="meishitupian">
          <file-upload
          tip="点击上传美食图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.meishitupian?ruleForm.meishitupian:''"
          @change="meishitupianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.meishitupian" label="美食图片" prop="meishitupian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.meishitupian.split(',')" :src="$base.url+item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="材料" prop="cailiao">
          <el-input v-model="ruleForm.cailiao" 
              placeholder="材料" clearable  :readonly="ro.cailiao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="材料" prop="cailiao">
              <el-input v-model="ruleForm.cailiao" 
                placeholder="材料" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="简介" prop="jianjie">
          <el-input v-model="ruleForm.jianjie" 
              placeholder="简介" clearable  :readonly="ro.jianjie"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="简介" prop="jianjie">
              <el-input v-model="ruleForm.jianjie" 
                placeholder="简介" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="美食分类" prop="meishifenlei">
          <el-input v-model="ruleForm.meishifenlei" 
              placeholder="美食分类" clearable  :readonly="ro.meishifenlei"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="美食分类" prop="meishifenlei">
              <el-input v-model="ruleForm.meishifenlei" 
                placeholder="美食分类" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="餐厅名称" prop="cantingmingcheng">
          <el-input v-model="ruleForm.cantingmingcheng" 
              placeholder="餐厅名称" clearable  :readonly="ro.cantingmingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="餐厅名称" prop="cantingmingcheng">
              <el-input v-model="ruleForm.cantingmingcheng" 
                placeholder="餐厅名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="餐厅地址" prop="cantingdizhi">
          <el-input v-model="ruleForm.cantingdizhi" 
              placeholder="餐厅地址" clearable  :readonly="ro.cantingdizhi"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="餐厅地址" prop="cantingdizhi">
              <el-input v-model="ruleForm.cantingdizhi" 
                placeholder="餐厅地址" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="餐厅电话" prop="cantingdianhua">
          <el-input v-model="ruleForm.cantingdianhua" 
              placeholder="餐厅电话" clearable  :readonly="ro.cantingdianhua"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="餐厅电话" prop="cantingdianhua">
              <el-input v-model="ruleForm.cantingdianhua" 
                placeholder="餐厅电话" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="餐厅评分" prop="cantingpingfen">
          <el-select :disabled="ro.cantingpingfen" v-model="ruleForm.cantingpingfen" placeholder="请选择餐厅评分">
            <el-option
                v-for="(item,index) in cantingpingfenOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="餐厅评分" prop="cantingpingfen">
	      <el-input v-model="ruleForm.cantingpingfen"
                placeholder="餐厅评分" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="美食评分" prop="meishipingfen">
          <el-select :disabled="ro.meishipingfen" v-model="ruleForm.meishipingfen" placeholder="请选择美食评分">
            <el-option
                v-for="(item,index) in meishipingfenOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="美食评分" prop="meishipingfen">
	      <el-input v-model="ruleForm.meishipingfen"
                placeholder="美食评分" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="账号" prop="zhanghao">
          <el-input v-model="ruleForm.zhanghao" 
              placeholder="账号" clearable  :readonly="ro.zhanghao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="账号" prop="zhanghao">
              <el-input v-model="ruleForm.zhanghao" 
                placeholder="账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="date" v-if="type!='info'" label="评分时间" prop="pingfenshijian">
            <el-date-picker
                value-format="yyyy-MM-dd HH:mm:ss"
                v-model="ruleForm.pingfenshijian" 
                type="datetime"
                :readonly="ro.pingfenshijian"
                placeholder="评分时间">
            </el-date-picker>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.pingfenshijian" label="评分时间" prop="pingfenshijian">
              <el-input v-model="ruleForm.pingfenshijian" 
                placeholder="评分时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item class="textarea" v-if="type!='info'" label="评价" prop="pingjia">
                <el-input
                  style="min-width: 200px; max-width: 600px;"
                  type="textarea"
                  :rows="8"
                  placeholder="评价"
                  v-model="ruleForm.pingjia" >
                </el-input>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.pingjia" label="评价" prop="pingjia">
                    <span>{{ruleForm.pingjia}}</span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
      <el-form-item class="btn">
        <el-button  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
	  addEditForm: {"btnSaveFontColor":"#fff","selectFontSize":"14px","btnCancelBorderColor":"rgba(255, 255, 255, 1)","inputBorderRadius":"4px","inputFontSize":"14px","textareaBgColor":"#fff","btnSaveFontSize":"14px","textareaBorderRadius":"4px","uploadBgColor":"#fff","textareaBorderStyle":"solid","btnCancelWidth":"88px","textareaHeight":"120px","dateBgColor":"#fff","btnSaveBorderRadius":"30px 0 0 0 ","uploadLableFontSize":"14px","textareaBorderWidth":"1px","inputLableColor":"rgba(48, 208, 182, 1)","addEditBoxColor":"rgba(255, 255, 255, 0)","dateIconFontSize":"14px","btnSaveBgColor":"rgba(48, 208, 182, 1)","uploadIconFontColor":"rgba(48, 208, 182, 1)","textareaBorderColor":"rgba(48, 208, 182, 1)","btnCancelBgColor":"rgba(170, 170, 170, 1)","selectLableColor":"rgba(48, 208, 182, 1)","btnSaveBorderStyle":"double","dateBorderWidth":"1px","dateLableFontSize":"14px","dateBorderRadius":"4px","btnCancelBorderStyle":"double","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"rgba(48, 208, 182, 1)","btnCancelHeight":"44px","inputHeight":"40px","btnCancelFontColor":"rgba(255, 255, 255, 1)","dateBorderColor":"rgba(48, 208, 182, 1)","dateIconFontColor":"rgba(48, 208, 182, 1)","uploadBorderStyle":"solid","dateBorderStyle":"solid","dateLableColor":"rgba(48, 208, 182, 1)","dateFontSize":"14px","inputBorderWidth":"1px","uploadIconFontSize":"28px","selectHeight":"40px","inputFontColor":"#606266","uploadHeight":"148px","textareaLableColor":"rgba(48, 208, 182, 1)","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"30px 0 0 0 ","inputBgColor":"rgba(255, 255, 255, 1)","inputLableFontSize":"14px","uploadLableColor":"rgba(48, 208, 182, 1)","uploadBorderRadius":"4px","btnSaveHeight":"44px","selectBgColor":"#fff","btnSaveWidth":"88px","selectIconFontSize":"14px","dateHeight":"40px","selectBorderColor":"rgba(48, 208, 182, 1)","inputBorderColor":"rgba(48, 208, 182, 1)","uploadBorderColor":"rgba(48, 208, 182, 1)","textareaFontColor":"#606266","selectBorderWidth":"1px","dateFontColor":"#606266","btnCancelBorderWidth":"5px","uploadBorderWidth":"1px","textareaFontSize":"14px","selectBorderRadius":"4px","selectFontColor":"#606266","btnSaveBorderColor":"rgba(255, 255, 255, 1)","btnSaveBorderWidth":"5px"},
      id: '',
      type: '',
      ro:{
	meishimingcheng : false,
	meishileixing : false,
	meishitupian : false,
	cailiao : false,
	jianjie : false,
	meishifenlei : false,
	cantingmingcheng : false,
	cantingdizhi : false,
	cantingdianhua : false,
	cantingpingfen : false,
	meishipingfen : false,
	pingjia : false,
	zhanghao : false,
	pingfenshijian : false,
	crossuserid : false,
	crossrefid : false,
      },
      ruleForm: {
        meishimingcheng: '',
        meishileixing: '',
        meishitupian: '',
        cailiao: '',
        jianjie: '',
        meishifenlei: '',
        cantingmingcheng: '',
        cantingdizhi: '',
        cantingdianhua: '',
        cantingpingfen: '',
        meishipingfen: '',
        pingjia: '',
        zhanghao: '',
        pingfenshijian: '',
        crossuserid: '',
        crossrefid: '',
      },
          cantingpingfenOptions: [],
          meishipingfenOptions: [],
      rules: {
          meishimingcheng: [
                { required: true, message: '美食名称不能为空', trigger: 'blur' },
          ],
          meishileixing: [
          ],
          meishitupian: [
          ],
          cailiao: [
          ],
          jianjie: [
          ],
          meishifenlei: [
          ],
          cantingmingcheng: [
                { required: true, message: '餐厅名称不能为空', trigger: 'blur' },
          ],
          cantingdizhi: [
          ],
          cantingdianhua: [
          ],
          cantingpingfen: [
                { required: true, message: '餐厅评分不能为空', trigger: 'blur' },
          ],
          meishipingfen: [
                { required: true, message: '美食评分不能为空', trigger: 'blur' },
          ],
          pingjia: [
                { required: true, message: '评价不能为空', trigger: 'blur' },
          ],
          zhanghao: [
          ],
          pingfenshijian: [
          ],
          crossuserid: [
          ],
          crossrefid: [
          ],
      }
    };
  },
  props: ["parent"],
  computed: {



  },
  created() {
	this.ruleForm.pingfenshijian = this.getCurDateTime()

	this.addEditStyleChange()
	this.addEditUploadStyleChange()
  },
  methods: {
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='logistics'){
        this.logistics=false;
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
          if(o=='meishimingcheng'){
            this.ruleForm.meishimingcheng = obj[o];
	    this.ro.meishimingcheng = true;
            continue;
          }
          if(o=='meishileixing'){
            this.ruleForm.meishileixing = obj[o];
	    this.ro.meishileixing = true;
            continue;
          }
          if(o=='meishitupian'){
            this.ruleForm.meishitupian = obj[o];
	    this.ro.meishitupian = true;
            continue;
          }
          if(o=='cailiao'){
            this.ruleForm.cailiao = obj[o];
	    this.ro.cailiao = true;
            continue;
          }
          if(o=='jianjie'){
            this.ruleForm.jianjie = obj[o];
	    this.ro.jianjie = true;
            continue;
          }
          if(o=='meishifenlei'){
            this.ruleForm.meishifenlei = obj[o];
	    this.ro.meishifenlei = true;
            continue;
          }
          if(o=='cantingmingcheng'){
            this.ruleForm.cantingmingcheng = obj[o];
	    this.ro.cantingmingcheng = true;
            continue;
          }
          if(o=='cantingdizhi'){
            this.ruleForm.cantingdizhi = obj[o];
	    this.ro.cantingdizhi = true;
            continue;
          }
          if(o=='cantingdianhua'){
            this.ruleForm.cantingdianhua = obj[o];
	    this.ro.cantingdianhua = true;
            continue;
          }
          if(o=='cantingpingfen'){
            this.ruleForm.cantingpingfen = obj[o];
	    this.ro.cantingpingfen = true;
            continue;
          }
          if(o=='meishipingfen'){
            this.ruleForm.meishipingfen = obj[o];
	    this.ro.meishipingfen = true;
            continue;
          }
          if(o=='pingjia'){
            this.ruleForm.pingjia = obj[o];
	    this.ro.pingjia = true;
            continue;
          }
          if(o=='zhanghao'){
            this.ruleForm.zhanghao = obj[o];
	    this.ro.zhanghao = true;
            continue;
          }
          if(o=='pingfenshijian'){
            this.ruleForm.pingfenshijian = obj[o];
	    this.ro.pingfenshijian = true;
            continue;
          }
          if(o=='crossuserid'){
            this.ruleForm.crossuserid = obj[o];
	    this.ro.crossuserid = true;
            continue;
          }
          if(o=='crossrefid'){
            this.ruleForm.crossrefid = obj[o];
	    this.ro.crossrefid = true;
            continue;
          }
        }
      }
      // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
		if(json.zhanghao!=''&&json.zhanghao){
                this.ruleForm.zhanghao = json.zhanghao
	    		this.ro.zhanghao = true;
		}
        } else {
          this.$message.error(data.msg);
        }
      });
            this.cantingpingfenOptions = "1,2,3,4,5".split(',')
            this.meishipingfenOptions = "1,2,3,4,5".split(',')
    },
    // 多级联动参数
    info(id) {
      this.$http({
        url: `pingjiaxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
	//解决前台上传图片后台不显示的问题
	let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {






	if(this.ruleForm.meishitupian!=null) {
		this.ruleForm.meishitupian = this.ruleForm.meishitupian.replace(new RegExp(this.$base.url,"g"),"");
	}



























var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(!statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "pingjiaxinxi/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `pingjiaxinxi/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.pingjiaxinxiCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `pingjiaxinxi/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.pingjiaxinxiCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.pingjiaxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    meishitupianUploadChange(fileUrls) {
	this.ruleForm.meishitupian = fileUrls;
	this.addEditUploadStyleChange()
    },
	addEditStyleChange() {
	  this.$nextTick(()=>{
	    // input
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    // select
	    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectFontColor
	      el.style.fontSize = this.addEditForm.selectFontSize
	      el.style.borderWidth = this.addEditForm.selectBorderWidth
	      el.style.borderStyle = this.addEditForm.selectBorderStyle
	      el.style.borderColor = this.addEditForm.selectBorderColor
	      el.style.borderRadius = this.addEditForm.selectBorderRadius
	      el.style.backgroundColor = this.addEditForm.selectBgColor
	    })
	    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectLableColor
	      el.style.fontSize = this.addEditForm.selectLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
	      el.style.color = this.addEditForm.selectIconFontColor
	      el.style.fontSize = this.addEditForm.selectIconFontSize
	    })
	    // date
	    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateFontColor
	      el.style.fontSize = this.addEditForm.dateFontSize
	      el.style.borderWidth = this.addEditForm.dateBorderWidth
	      el.style.borderStyle = this.addEditForm.dateBorderStyle
	      el.style.borderColor = this.addEditForm.dateBorderColor
	      el.style.borderRadius = this.addEditForm.dateBorderRadius
	      el.style.backgroundColor = this.addEditForm.dateBgColor
	    })
	    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateLableColor
	      el.style.fontSize = this.addEditForm.dateLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
	      el.style.color = this.addEditForm.dateIconFontColor
	      el.style.fontSize = this.addEditForm.dateIconFontSize
	      el.style.lineHeight = this.addEditForm.dateHeight
	    })
	    // upload
	    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
	    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
	      el.style.width = this.addEditForm.uploadHeight
	      el.style.height = this.addEditForm.uploadHeight
	      el.style.borderWidth = this.addEditForm.uploadBorderWidth
	      el.style.borderStyle = this.addEditForm.uploadBorderStyle
	      el.style.borderColor = this.addEditForm.uploadBorderColor
	      el.style.borderRadius = this.addEditForm.uploadBorderRadius
	      el.style.backgroundColor = this.addEditForm.uploadBgColor
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.uploadHeight
	      el.style.color = this.addEditForm.uploadLableColor
	      el.style.fontSize = this.addEditForm.uploadLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
	      el.style.color = this.addEditForm.uploadIconFontColor
	      el.style.fontSize = this.addEditForm.uploadIconFontSize
	      el.style.lineHeight = iconLineHeight
	      el.style.display = 'block'
	    })
	    // 多文本输入框
	    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
	      el.style.height = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaFontColor
	      el.style.fontSize = this.addEditForm.textareaFontSize
	      el.style.borderWidth = this.addEditForm.textareaBorderWidth
	      el.style.borderStyle = this.addEditForm.textareaBorderStyle
	      el.style.borderColor = this.addEditForm.textareaBorderColor
	      el.style.borderRadius = this.addEditForm.textareaBorderRadius
	      el.style.backgroundColor = this.addEditForm.textareaBgColor
	    })
	    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
	      // el.style.lineHeight = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaLableColor
	      el.style.fontSize = this.addEditForm.textareaLableFontSize
	    })
	    // 保存
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    // 返回
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
	addEditUploadStyleChange() {
		this.$nextTick(()=>{
		  document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
			el.style.width = this.addEditForm.uploadHeight
			el.style.height = this.addEditForm.uploadHeight
			el.style.borderWidth = this.addEditForm.uploadBorderWidth
			el.style.borderStyle = this.addEditForm.uploadBorderStyle
			el.style.borderColor = this.addEditForm.uploadBorderColor
			el.style.borderRadius = this.addEditForm.uploadBorderRadius
			el.style.backgroundColor = this.addEditForm.uploadBgColor
		  })
	  })
	},
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}
</style>
