/*******************************************************************************
 * Copyright (c) 2017 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
_MF_CLS(_PFX_CORE+"Object",Object,{constructor_:function(){this._resettableContent={};var B=this._mfClazz.prototype;var A=myfaces._impl;if(!B._RT){B._RT=A.core._Runtime;B._Lang=A._util._Lang;B._Dom=A._util._Dom;}},_initDefaultFinalizableFields:function(){var B=this._RT.browser.isIE;if(!B||B>7){return ;}for(var A in this){if(null==this[A]&&A!="_resettableContent"&&A.indexOf("_mf")!=0&&A.indexOf("_")==0){this._resettableContent[A]=true;}}},_finalize:function(){try{if(this._isGCed||!this._RT.browser.isIE||!this._resettableContent){return ;}for(var A in this._resettableContent){if(this._RT.exists(this[A],"_finalize")){this[A]._finalize();}delete this[A];}}finally{this._isGCed=true;}},attr:function(A,B){return this._Lang.attr(this,A,B);},getImpl:function(){this._Impl=this._Impl||this._RT.getGlobalConfig("jsfAjaxImpl",myfaces._impl.core.Impl);return this._Impl;},applyArgs:function(A){this._Lang.applyArgs(this,A);},updateSingletons:function(A){var B=this;B._RT.iterateSingletons(function(C){if(C[A]){C[A]=B;}});}});(function(){var B=window||document;var A=myfaces._impl.core._Runtime;A._MF_OBJECT=B._MF_OBJECT;B._MF_OBJECT=myfaces._impl.core.Object;})();