/*
 * Copyright 2026 mingliqiye
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ProjectName mingli-utils
 * ModuleName mingli-utils.main
 * CurrentFile MediaType.kt
 * LastUpdate 2026-03-11 08:46:40
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.http

/**
 * HTTP 媒体类型（MIME 类型）枚举，收录 IANA 注册的媒体类型。
 *
 * 每个枚举项对应一个标准 MIME 类型字符串，可通过 [value] 获取，
 * 或调用 [okhttp] 扩展转换为 OkHttp 的 MediaType。
 *
 * @property value 媒体类型的标准字符串表示，如 "application/json"
 */
enum class MediaType(val value: String) {
	/** MIME 类型：application/1d-interleaved-parityfec */
	APPLICATION_1D_INTERLEAVED_PARITYFEC("application/1d-interleaved-parityfec"),
	/** MIME 类型：application/3gpdash-qoe-report+xml */
	APPLICATION_3GPDASH_QOE_REPORT_XML("application/3gpdash-qoe-report+xml"),
	/** MIME 类型：application/3gpp-ims+xml */
	APPLICATION_3GPP_IMS_XML("application/3gpp-ims+xml"),
	/** MIME 类型：application/3gpp-mbs-object-manifest+json */
	APPLICATION_3GPP_MBS_OBJECT_MANIFEST_JSON("application/3gpp-mbs-object-manifest+json"),
	/** MIME 类型：application/3gpp-mbs-user-service-descriptions+json */
	APPLICATION_3GPP_MBS_USER_SERVICE_DESCRIPTIONS_JSON("application/3gpp-mbs-user-service-descriptions+json"),
	/** MIME 类型：application/3gpp-media-delivery-metrics-report+json */
	APPLICATION_3GPP_MEDIA_DELIVERY_METRICS_REPORT_JSON("application/3gpp-media-delivery-metrics-report+json"),
	/** MIME 类型：application/3gppHal+json */
	APPLICATION_3GPPHAL_JSON("application/3gppHal+json"),
	/** MIME 类型：application/3gppHalForms+json */
	APPLICATION_3GPPHALFORMS_JSON("application/3gppHalForms+json"),
	/** MIME 类型：application/aas+zip */
	APPLICATION_AAS_ZIP("application/aas+zip"),
	/** MIME 类型：application/A2L */
	APPLICATION_A2L("application/A2L"),
	/** MIME 类型：application/ace-groupcomm+cbor */
	APPLICATION_ACE_GROUPCOMM_CBOR("application/ace-groupcomm+cbor"),
	/** MIME 类型：application/ace-trl+cbor */
	APPLICATION_ACE_TRL_CBOR("application/ace-trl+cbor"),
	/** MIME 类型：application/ace+cbor */
	APPLICATION_ACE_CBOR("application/ace+cbor"),
	/** MIME 类型：application/ace+json */
	APPLICATION_ACE_JSON("application/ace+json"),
	/** MIME 类型：application/activemessage */
	APPLICATION_ACTIVEMESSAGE("application/activemessage"),
	/** MIME 类型：application/activity+json */
	APPLICATION_ACTIVITY_JSON("application/activity+json"),
	/** MIME 类型：application/aif+cbor */
	APPLICATION_AIF_CBOR("application/aif+cbor"),
	/** MIME 类型：application/aif+json */
	APPLICATION_AIF_JSON("application/aif+json"),
	/** MIME 类型：application/alto-cdni+json */
	APPLICATION_ALTO_CDNI_JSON("application/alto-cdni+json"),
	/** MIME 类型：application/alto-cdnifilter+json */
	APPLICATION_ALTO_CDNIFILTER_JSON("application/alto-cdnifilter+json"),
	/** MIME 类型：application/alto-costmap+json */
	APPLICATION_ALTO_COSTMAP_JSON("application/alto-costmap+json"),
	/** MIME 类型：application/alto-costmapfilter+json */
	APPLICATION_ALTO_COSTMAPFILTER_JSON("application/alto-costmapfilter+json"),
	/** MIME 类型：application/alto-directory+json */
	APPLICATION_ALTO_DIRECTORY_JSON("application/alto-directory+json"),
	/** MIME 类型：application/alto-endpointprop+json */
	APPLICATION_ALTO_ENDPOINTPROP_JSON("application/alto-endpointprop+json"),
	/** MIME 类型：application/alto-endpointpropparams+json */
	APPLICATION_ALTO_ENDPOINTPROPPARAMS_JSON("application/alto-endpointpropparams+json"),
	/** MIME 类型：application/alto-endpointcost+json */
	APPLICATION_ALTO_ENDPOINTCOST_JSON("application/alto-endpointcost+json"),
	/** MIME 类型：application/alto-endpointcostparams+json */
	APPLICATION_ALTO_ENDPOINTCOSTPARAMS_JSON("application/alto-endpointcostparams+json"),
	/** MIME 类型：application/alto-error+json */
	APPLICATION_ALTO_ERROR_JSON("application/alto-error+json"),
	/** MIME 类型：application/alto-networkmapfilter+json */
	APPLICATION_ALTO_NETWORKMAPFILTER_JSON("application/alto-networkmapfilter+json"),
	/** MIME 类型：application/alto-networkmap+json */
	APPLICATION_ALTO_NETWORKMAP_JSON("application/alto-networkmap+json"),
	/** MIME 类型：application/alto-propmap+json */
	APPLICATION_ALTO_PROPMAP_JSON("application/alto-propmap+json"),
	/** MIME 类型：application/alto-propmapparams+json */
	APPLICATION_ALTO_PROPMAPPARAMS_JSON("application/alto-propmapparams+json"),
	/** MIME 类型：application/alto-tips+json */
	APPLICATION_ALTO_TIPS_JSON("application/alto-tips+json"),
	/** MIME 类型：application/alto-tipsparams+json */
	APPLICATION_ALTO_TIPSPARAMS_JSON("application/alto-tipsparams+json"),
	/** MIME 类型：application/alto-updatestreamcontrol+json */
	APPLICATION_ALTO_UPDATESTREAMCONTROL_JSON("application/alto-updatestreamcontrol+json"),
	/** MIME 类型：application/alto-updatestreamparams+json */
	APPLICATION_ALTO_UPDATESTREAMPARAMS_JSON("application/alto-updatestreamparams+json"),
	/** MIME 类型：application/AML */
	APPLICATION_AML("application/AML"),
	/** MIME 类型：application/andrew-inset */
	APPLICATION_ANDREW_INSET("application/andrew-inset"),
	/** MIME 类型：application/applefile */
	APPLICATION_APPLEFILE("application/applefile"),
	/** MIME 类型：application/asyncapi+json */
	APPLICATION_ASYNCAPI_JSON("application/asyncapi+json"),
	/** MIME 类型：application/asyncapi+yaml */
	APPLICATION_ASYNCAPI_YAML("application/asyncapi+yaml"),
	/** MIME 类型：application/at+jwt */
	APPLICATION_AT_JWT("application/at+jwt"),
	/** MIME 类型：application/ATF */
	APPLICATION_ATF("application/ATF"),
	/** MIME 类型：application/ATFX */
	APPLICATION_ATFX("application/ATFX"),
	/** MIME 类型：application/atom+xml */
	APPLICATION_ATOM_XML("application/atom+xml"),
	/** MIME 类型：application/atomcat+xml */
	APPLICATION_ATOMCAT_XML("application/atomcat+xml"),
	/** MIME 类型：application/atomdeleted+xml */
	APPLICATION_ATOMDELETED_XML("application/atomdeleted+xml"),
	/** MIME 类型：application/atomicmail */
	APPLICATION_ATOMICMAIL("application/atomicmail"),
	/** MIME 类型：application/atomsvc+xml */
	APPLICATION_ATOMSVC_XML("application/atomsvc+xml"),
	/** MIME 类型：application/atsc-dwd+xml */
	APPLICATION_ATSC_DWD_XML("application/atsc-dwd+xml"),
	/** MIME 类型：application/atsc-dynamic-event-message */
	APPLICATION_ATSC_DYNAMIC_EVENT_MESSAGE("application/atsc-dynamic-event-message"),
	/** MIME 类型：application/atsc-held+xml */
	APPLICATION_ATSC_HELD_XML("application/atsc-held+xml"),
	/** MIME 类型：application/atsc-rdt+json */
	APPLICATION_ATSC_RDT_JSON("application/atsc-rdt+json"),
	/** MIME 类型：application/atsc-rsat+xml */
	APPLICATION_ATSC_RSAT_XML("application/atsc-rsat+xml"),
	/** MIME 类型：application/ATXML */
	APPLICATION_ATXML("application/ATXML"),
	/** MIME 类型：application/auth-policy+xml */
	APPLICATION_AUTH_POLICY_XML("application/auth-policy+xml"),
	/** MIME 类型：application/automationml-aml+xml */
	APPLICATION_AUTOMATIONML_AML_XML("application/automationml-aml+xml"),
	/** MIME 类型：application/automationml-amlx+zip */
	APPLICATION_AUTOMATIONML_AMLX_ZIP("application/automationml-amlx+zip"),
	/** MIME 类型：application/bacnet-xdd+zip */
	APPLICATION_BACNET_XDD_ZIP("application/bacnet-xdd+zip"),
	/** MIME 类型：application/batch-SMTP */
	APPLICATION_BATCH_SMTP("application/batch-SMTP"),
	/** MIME 类型：application/beep+xml */
	APPLICATION_BEEP_XML("application/beep+xml"),
	/** MIME 类型：application/bufr */
	APPLICATION_BUFR("application/bufr"),
	/** MIME 类型：application/c2pa */
	APPLICATION_C2PA("application/c2pa"),
	/** MIME 类型：application/calendar+json */
	APPLICATION_CALENDAR_JSON("application/calendar+json"),
	/** MIME 类型：application/calendar+xml */
	APPLICATION_CALENDAR_XML("application/calendar+xml"),
	/** MIME 类型：application/call-completion */
	APPLICATION_CALL_COMPLETION("application/call-completion"),
	/** MIME 类型：application/CALS-1840 */
	APPLICATION_CALS_1840("application/CALS-1840"),
	/** MIME 类型：application/captive+json */
	APPLICATION_CAPTIVE_JSON("application/captive+json"),
	/** MIME 类型：application/cbor */
	APPLICATION_CBOR("application/cbor"),
	/** MIME 类型：application/cbor-seq */
	APPLICATION_CBOR_SEQ("application/cbor-seq"),
	/** MIME 类型：application/cccex */
	APPLICATION_CCCEX("application/cccex"),
	/** MIME 类型：application/ccmp+xml */
	APPLICATION_CCMP_XML("application/ccmp+xml"),
	/** MIME 类型：application/ccxml+xml */
	APPLICATION_CCXML_XML("application/ccxml+xml"),
	/** MIME 类型：application/cda+xml */
	APPLICATION_CDA_XML("application/cda+xml"),
	/** MIME 类型：application/CDFX+XML */
	APPLICATION_CDFX_XML("application/CDFX+XML"),
	/** MIME 类型：application/cdmi-capability */
	APPLICATION_CDMI_CAPABILITY("application/cdmi-capability"),
	/** MIME 类型：application/cdmi-container */
	APPLICATION_CDMI_CONTAINER("application/cdmi-container"),
	/** MIME 类型：application/cdmi-domain */
	APPLICATION_CDMI_DOMAIN("application/cdmi-domain"),
	/** MIME 类型：application/cdmi-object */
	APPLICATION_CDMI_OBJECT("application/cdmi-object"),
	/** MIME 类型：application/cdmi-queue */
	APPLICATION_CDMI_QUEUE("application/cdmi-queue"),
	/** MIME 类型：application/cdni */
	APPLICATION_CDNI("application/cdni"),
	/** MIME 类型：application/ce+cbor */
	APPLICATION_CE_CBOR("application/ce+cbor"),
	/** MIME 类型：application/CEA */
	APPLICATION_CEA("application/CEA"),
	/** MIME 类型：application/cea-2018+xml */
	APPLICATION_CEA_2018_XML("application/cea-2018+xml"),
	/** MIME 类型：application/cellml+xml */
	APPLICATION_CELLML_XML("application/cellml+xml"),
	/** MIME 类型：application/cfw */
	APPLICATION_CFW("application/cfw"),
	/** MIME 类型：application/cid */
	APPLICATION_CID("application/cid"),
	/** MIME 类型：application/cid-edhoc+cbor-seq */
	APPLICATION_CID_EDHOC_CBOR_SEQ("application/cid-edhoc+cbor-seq"),
	/** MIME 类型：application/city+json */
	APPLICATION_CITY_JSON("application/city+json"),
	/** MIME 类型：application/city+json-seq */
	APPLICATION_CITY_JSON_SEQ("application/city+json-seq"),
	/** MIME 类型：application/clr */
	APPLICATION_CLR("application/clr"),
	/** MIME 类型：application/clue_info+xml */
	APPLICATION_CLUE_INFO_XML("application/clue_info+xml"),
	/** MIME 类型：application/clue+xml */
	APPLICATION_CLUE_XML("application/clue+xml"),
	/** MIME 类型：application/cms */
	APPLICATION_CMS("application/cms"),
	/** MIME 类型：application/cmw+cbor */
	APPLICATION_CMW_CBOR("application/cmw+cbor"),
	/** MIME 类型：application/cmw+cose */
	APPLICATION_CMW_COSE("application/cmw+cose"),
	/** MIME 类型：application/cmw+json */
	APPLICATION_CMW_JSON("application/cmw+json"),
	/** MIME 类型：application/cmw+jws */
	APPLICATION_CMW_JWS("application/cmw+jws"),
	/** MIME 类型：application/cnrp+xml */
	APPLICATION_CNRP_XML("application/cnrp+xml"),
	/** MIME 类型：application/coap-eap */
	APPLICATION_COAP_EAP("application/coap-eap"),
	/** MIME 类型：application/coap-group+json */
	APPLICATION_COAP_GROUP_JSON("application/coap-group+json"),
	/** MIME 类型：application/coap-payload */
	APPLICATION_COAP_PAYLOAD("application/coap-payload"),
	/** MIME 类型：application/commonground */
	APPLICATION_COMMONGROUND("application/commonground"),
	/** MIME 类型：application/concise-problem-details+cbor */
	APPLICATION_CONCISE_PROBLEM_DETAILS_CBOR("application/concise-problem-details+cbor"),
	/** MIME 类型：application/conference-info+xml */
	APPLICATION_CONFERENCE_INFO_XML("application/conference-info+xml"),
	/** MIME 类型：application/cpl+xml */
	APPLICATION_CPL_XML("application/cpl+xml"),
	/** MIME 类型：application/cose */
	APPLICATION_COSE("application/cose"),
	/** MIME 类型：application/cose-key */
	APPLICATION_COSE_KEY("application/cose-key"),
	/** MIME 类型：application/cose-key-set */
	APPLICATION_COSE_KEY_SET("application/cose-key-set"),
	/** MIME 类型：application/cose-x509 */
	APPLICATION_COSE_X509("application/cose-x509"),
	/** MIME 类型：application/csrattrs */
	APPLICATION_CSRATTRS("application/csrattrs"),
	/** MIME 类型：application/csta+xml */
	APPLICATION_CSTA_XML("application/csta+xml"),
	/** MIME 类型：application/CSTAdata+xml */
	APPLICATION_CSTADATA_XML("application/CSTAdata+xml"),
	/** MIME 类型：application/csvm+json */
	APPLICATION_CSVM_JSON("application/csvm+json"),
	/** MIME 类型：application/cwl */
	APPLICATION_CWL("application/cwl"),
	/** MIME 类型：application/cwl+json */
	APPLICATION_CWL_JSON("application/cwl+json"),
	/** MIME 类型：application/cwl+yaml */
	APPLICATION_CWL_YAML("application/cwl+yaml"),
	/** MIME 类型：application/cwt */
	APPLICATION_CWT("application/cwt"),
	/** MIME 类型：application/cybercash */
	APPLICATION_CYBERCASH("application/cybercash"),
	/** MIME 类型：application/dash+xml */
	APPLICATION_DASH_XML("application/dash+xml"),
	/** MIME 类型：application/dash-patch+xml */
	APPLICATION_DASH_PATCH_XML("application/dash-patch+xml"),
	/** MIME 类型：application/dashdelta */
	APPLICATION_DASHDELTA("application/dashdelta"),
	/** MIME 类型：application/davmount+xml */
	APPLICATION_DAVMOUNT_XML("application/davmount+xml"),
	/** MIME 类型：application/dca-rft */
	APPLICATION_DCA_RFT("application/dca-rft"),
	/** MIME 类型：application/DCD */
	APPLICATION_DCD("application/DCD"),
	/** MIME 类型：application/dec-dx */
	APPLICATION_DEC_DX("application/dec-dx"),
	/** MIME 类型：application/dialog-info+xml */
	APPLICATION_DIALOG_INFO_XML("application/dialog-info+xml"),
	/** MIME 类型：application/dicom */
	APPLICATION_DICOM("application/dicom"),
	/** MIME 类型：application/dicom+json */
	APPLICATION_DICOM_JSON("application/dicom+json"),
	/** MIME 类型：application/dicom+xml */
	APPLICATION_DICOM_XML("application/dicom+xml"),
	/** MIME 类型：application/did */
	APPLICATION_DID("application/did"),
	/** MIME 类型：application/DII */
	APPLICATION_DII("application/DII"),
	/** MIME 类型：application/DIT */
	APPLICATION_DIT("application/DIT"),
	/** MIME 类型：application/dns */
	APPLICATION_DNS("application/dns"),
	/** MIME 类型：application/dns+json */
	APPLICATION_DNS_JSON("application/dns+json"),
	/** MIME 类型：application/dns-message */
	APPLICATION_DNS_MESSAGE("application/dns-message"),
	/** MIME 类型：application/dots+cbor */
	APPLICATION_DOTS_CBOR("application/dots+cbor"),
	/** MIME 类型：application/dpop+jwt */
	APPLICATION_DPOP_JWT("application/dpop+jwt"),
	/** MIME 类型：application/dskpp+xml */
	APPLICATION_DSKPP_XML("application/dskpp+xml"),
	/** MIME 类型：application/dssc+der */
	APPLICATION_DSSC_DER("application/dssc+der"),
	/** MIME 类型：application/dssc+xml */
	APPLICATION_DSSC_XML("application/dssc+xml"),
	/** MIME 类型：application/dvcs */
	APPLICATION_DVCS("application/dvcs"),
	/** MIME 类型：application/eat+cwt */
	APPLICATION_EAT_CWT("application/eat+cwt"),
	/** MIME 类型：application/eat+jwt */
	APPLICATION_EAT_JWT("application/eat+jwt"),
	/** MIME 类型：application/eat-bun+cbor */
	APPLICATION_EAT_BUN_CBOR("application/eat-bun+cbor"),
	/** MIME 类型：application/eat-bun+json */
	APPLICATION_EAT_BUN_JSON("application/eat-bun+json"),
	/** MIME 类型：application/eat-ucs+cbor */
	APPLICATION_EAT_UCS_CBOR("application/eat-ucs+cbor"),
	/** MIME 类型：application/eat-ucs+json */
	APPLICATION_EAT_UCS_JSON("application/eat-ucs+json"),
	/** MIME 类型：application/ecmascript */
	APPLICATION_ECMASCRIPT("application/ecmascript"),
	/** MIME 类型：application/edhoc+cbor-seq */
	APPLICATION_EDHOC_CBOR_SEQ("application/edhoc+cbor-seq"),
	/** MIME 类型：application/EDI-consent */
	APPLICATION_EDI_CONSENT("application/EDI-consent"),
	/** MIME 类型：application/EDIFACT */
	APPLICATION_EDIFACT("application/EDIFACT"),
	/** MIME 类型：application/EDI-X12 */
	APPLICATION_EDI_X12("application/EDI-X12"),
	/** MIME 类型：application/efi */
	APPLICATION_EFI("application/efi"),
	/** MIME 类型：application/elm+json */
	APPLICATION_ELM_JSON("application/elm+json"),
	/** MIME 类型：application/elm+xml */
	APPLICATION_ELM_XML("application/elm+xml"),
	/** MIME 类型：application/EmergencyCallData.cap+xml */
	APPLICATION_EMERGENCYCALLDATA_CAP_XML("application/EmergencyCallData.cap+xml"),
	/** MIME 类型：application/EmergencyCallData.Comment+xml */
	APPLICATION_EMERGENCYCALLDATA_COMMENT_XML("application/EmergencyCallData.Comment+xml"),
	/** MIME 类型：application/EmergencyCallData.Control+xml */
	APPLICATION_EMERGENCYCALLDATA_CONTROL_XML("application/EmergencyCallData.Control+xml"),
	/** MIME 类型：application/EmergencyCallData.DeviceInfo+xml */
	APPLICATION_EMERGENCYCALLDATA_DEVICEINFO_XML("application/EmergencyCallData.DeviceInfo+xml"),
	/** MIME 类型：application/EmergencyCallData.eCall.MSD */
	APPLICATION_EMERGENCYCALLDATA_ECALL_MSD("application/EmergencyCallData.eCall.MSD"),
	/** MIME 类型：application/EmergencyCallData.LegacyESN+json */
	APPLICATION_EMERGENCYCALLDATA_LEGACYESN_JSON("application/EmergencyCallData.LegacyESN+json"),
	/** MIME 类型：application/EmergencyCallData.ProviderInfo+xml */
	APPLICATION_EMERGENCYCALLDATA_PROVIDERINFO_XML("application/EmergencyCallData.ProviderInfo+xml"),
	/** MIME 类型：application/EmergencyCallData.ServiceInfo+xml */
	APPLICATION_EMERGENCYCALLDATA_SERVICEINFO_XML("application/EmergencyCallData.ServiceInfo+xml"),
	/** MIME 类型：application/EmergencyCallData.SubscriberInfo+xml */
	APPLICATION_EMERGENCYCALLDATA_SUBSCRIBERINFO_XML("application/EmergencyCallData.SubscriberInfo+xml"),
	/** MIME 类型：application/EmergencyCallData.VEDS+xml */
	APPLICATION_EMERGENCYCALLDATA_VEDS_XML("application/EmergencyCallData.VEDS+xml"),
	/** MIME 类型：application/emma+xml */
	APPLICATION_EMMA_XML("application/emma+xml"),
	/** MIME 类型：application/emotionml+xml */
	APPLICATION_EMOTIONML_XML("application/emotionml+xml"),
	/** MIME 类型：application/encaprtp */
	APPLICATION_ENCAPRTP("application/encaprtp"),
	/** MIME 类型：application/entity-statement+jwt */
	APPLICATION_ENTITY_STATEMENT_JWT("application/entity-statement+jwt"),
	/** MIME 类型：application/epp+xml */
	APPLICATION_EPP_XML("application/epp+xml"),
	/** MIME 类型：application/epub+zip */
	APPLICATION_EPUB_ZIP("application/epub+zip"),
	/** MIME 类型：application/eshop */
	APPLICATION_ESHOP("application/eshop"),
	/** MIME 类型：application/example */
	APPLICATION_EXAMPLE("application/example"),
	/** MIME 类型：application/exi */
	APPLICATION_EXI("application/exi"),
	/** MIME 类型：application/expect-ct-report+json */
	APPLICATION_EXPECT_CT_REPORT_JSON("application/expect-ct-report+json"),
	/** MIME 类型：application/explicit-registration-response+jwt */
	APPLICATION_EXPLICIT_REGISTRATION_RESPONSE_JWT("application/explicit-registration-response+jwt"),
	/** MIME 类型：application/express */
	APPLICATION_EXPRESS("application/express"),
	/** MIME 类型：application/fastinfoset */
	APPLICATION_FASTINFOSET("application/fastinfoset"),
	/** MIME 类型：application/fastsoap */
	APPLICATION_FASTSOAP("application/fastsoap"),
	/** MIME 类型：application/fdf */
	APPLICATION_FDF("application/fdf"),
	/** MIME 类型：application/fdt+xml */
	APPLICATION_FDT_XML("application/fdt+xml"),
	/** MIME 类型：application/fhir+json */
	APPLICATION_FHIR_JSON("application/fhir+json"),
	/** MIME 类型：application/fhir+xml */
	APPLICATION_FHIR_XML("application/fhir+xml"),
	/** MIME 类型：application/fits */
	APPLICATION_FITS("application/fits"),
	/** MIME 类型：application/flexfec */
	APPLICATION_FLEXFEC("application/flexfec"),
	/** MIME 类型：application/font-sfnt */
	APPLICATION_FONT_SFNT("application/font-sfnt"),
	/** MIME 类型：application/font-tdpfr */
	APPLICATION_FONT_TDPFR("application/font-tdpfr"),
	/** MIME 类型：application/font-woff */
	APPLICATION_FONT_WOFF("application/font-woff"),
	/** MIME 类型：application/framework-attributes+xml */
	APPLICATION_FRAMEWORK_ATTRIBUTES_XML("application/framework-attributes+xml"),
	/** MIME 类型：application/geo+json */
	APPLICATION_GEO_JSON("application/geo+json"),
	/** MIME 类型：application/geo+json-seq */
	APPLICATION_GEO_JSON_SEQ("application/geo+json-seq"),
	/** MIME 类型：application/geofeed+csv */
	APPLICATION_GEOFEED_CSV("application/geofeed+csv"),
	/** MIME 类型：application/geopackage+sqlite3 */
	APPLICATION_GEOPACKAGE_SQLITE3("application/geopackage+sqlite3"),
	/** MIME 类型：application/geopose+json */
	APPLICATION_GEOPOSE_JSON("application/geopose+json"),
	/** MIME 类型：application/geoxacml+json */
	APPLICATION_GEOXACML_JSON("application/geoxacml+json"),
	/** MIME 类型：application/geoxacml+xml */
	APPLICATION_GEOXACML_XML("application/geoxacml+xml"),
	/** MIME 类型：application/gltf-buffer */
	APPLICATION_GLTF_BUFFER("application/gltf-buffer"),
	/** MIME 类型：application/gml+xml */
	APPLICATION_GML_XML("application/gml+xml"),
	/** MIME 类型：application/gnap-binding-jws */
	APPLICATION_GNAP_BINDING_JWS("application/gnap-binding-jws"),
	/** MIME 类型：application/gnap-binding-jwsd */
	APPLICATION_GNAP_BINDING_JWSD("application/gnap-binding-jwsd"),
	/** MIME 类型：application/gnap-binding-rotation-jws */
	APPLICATION_GNAP_BINDING_ROTATION_JWS("application/gnap-binding-rotation-jws"),
	/** MIME 类型：application/gnap-binding-rotation-jwsd */
	APPLICATION_GNAP_BINDING_ROTATION_JWSD("application/gnap-binding-rotation-jwsd"),
	/** MIME 类型：application/grib */
	APPLICATION_GRIB("application/grib"),
	/** MIME 类型：application/gzip */
	APPLICATION_GZIP("application/gzip"),
	/** MIME 类型：application/H224 */
	APPLICATION_H224("application/H224"),
	/** MIME 类型：application/held+xml */
	APPLICATION_HELD_XML("application/held+xml"),
	/** MIME 类型：application/hl7v2+xml */
	APPLICATION_HL7V2_XML("application/hl7v2+xml"),
	/** MIME 类型：application/http */
	APPLICATION_HTTP("application/http"),
	/** MIME 类型：application/hyperstudio */
	APPLICATION_HYPERSTUDIO("application/hyperstudio"),
	/** MIME 类型：application/ibe-key-request+xml */
	APPLICATION_IBE_KEY_REQUEST_XML("application/ibe-key-request+xml"),
	/** MIME 类型：application/ibe-pkg-reply+xml */
	APPLICATION_IBE_PKG_REPLY_XML("application/ibe-pkg-reply+xml"),
	/** MIME 类型：application/ibe-pp-data */
	APPLICATION_IBE_PP_DATA("application/ibe-pp-data"),
	/** MIME 类型：application/iges */
	APPLICATION_IGES("application/iges"),
	/** MIME 类型：application/im-iscomposing+xml */
	APPLICATION_IM_ISCOMPOSING_XML("application/im-iscomposing+xml"),
	/** MIME 类型：application/index */
	APPLICATION_INDEX("application/index"),
	/** MIME 类型：application/index.cmd */
	APPLICATION_INDEX_CMD("application/index.cmd"),
	/** MIME 类型：application/index.obj */
	APPLICATION_INDEX_OBJ("application/index.obj"),
	/** MIME 类型：application/index.response */
	APPLICATION_INDEX_RESPONSE("application/index.response"),
	/** MIME 类型：application/index.vnd */
	APPLICATION_INDEX_VND("application/index.vnd"),
	/** MIME 类型：application/inkml+xml */
	APPLICATION_INKML_XML("application/inkml+xml"),
	/** MIME 类型：application/IOTP */
	APPLICATION_IOTP("application/IOTP"),
	/** MIME 类型：application/ipfix */
	APPLICATION_IPFIX("application/ipfix"),
	/** MIME 类型：application/ipp */
	APPLICATION_IPP("application/ipp"),
	/** MIME 类型：application/ISUP */
	APPLICATION_ISUP("application/ISUP"),
	/** MIME 类型：application/its+xml */
	APPLICATION_ITS_XML("application/its+xml"),
	/** MIME 类型：application/java-archive */
	APPLICATION_JAVA_ARCHIVE("application/java-archive"),
	/** MIME 类型：application/javascript */
	APPLICATION_JAVASCRIPT("application/javascript"),
	/** MIME 类型：application/jf2feed+json */
	APPLICATION_JF2FEED_JSON("application/jf2feed+json"),
	/** MIME 类型：application/jose */
	APPLICATION_JOSE("application/jose"),
	/** MIME 类型：application/jose+json */
	APPLICATION_JOSE_JSON("application/jose+json"),
	/** MIME 类型：application/jrd+json */
	APPLICATION_JRD_JSON("application/jrd+json"),
	/** MIME 类型：application/jscalendar+json */
	APPLICATION_JSCALENDAR_JSON("application/jscalendar+json"),
	/** MIME 类型：application/jscontact+json */
	APPLICATION_JSCONTACT_JSON("application/jscontact+json"),
	/** MIME 类型：application/json */
	APPLICATION_JSON("application/json"),
	/** MIME 类型：application/json-patch+json */
	APPLICATION_JSON_PATCH_JSON("application/json-patch+json"),
	/** MIME 类型：application/json-patch-query+json */
	APPLICATION_JSON_PATCH_QUERY_JSON("application/json-patch-query+json"),
	/** MIME 类型：application/json-seq */
	APPLICATION_JSON_SEQ("application/json-seq"),
	/** MIME 类型：application/jsonpath */
	APPLICATION_JSONPATH("application/jsonpath"),
	/** MIME 类型：application/jwk+json */
	APPLICATION_JWK_JSON("application/jwk+json"),
	/** MIME 类型：application/jwk-set+json */
	APPLICATION_JWK_SET_JSON("application/jwk-set+json"),
	/** MIME 类型：application/jwk-set+jwt */
	APPLICATION_JWK_SET_JWT("application/jwk-set+jwt"),
	/** MIME 类型：application/jwt */
	APPLICATION_JWT("application/jwt"),
	/** MIME 类型：application/kb+jwt */
	APPLICATION_KB_JWT("application/kb+jwt"),
	/** MIME 类型：application/kbl+xml */
	APPLICATION_KBL_XML("application/kbl+xml"),
	/** MIME 类型：application/kpml-request+xml */
	APPLICATION_KPML_REQUEST_XML("application/kpml-request+xml"),
	/** MIME 类型：application/kpml-response+xml */
	APPLICATION_KPML_RESPONSE_XML("application/kpml-response+xml"),
	/** MIME 类型：application/ld+json */
	APPLICATION_LD_JSON("application/ld+json"),
	/** MIME 类型：application/lgr+xml */
	APPLICATION_LGR_XML("application/lgr+xml"),
	/** MIME 类型：application/link-format */
	APPLICATION_LINK_FORMAT("application/link-format"),
	/** MIME 类型：application/linkset */
	APPLICATION_LINKSET("application/linkset"),
	/** MIME 类型：application/linkset+json */
	APPLICATION_LINKSET_JSON("application/linkset+json"),
	/** MIME 类型：application/load-control+xml */
	APPLICATION_LOAD_CONTROL_XML("application/load-control+xml"),
	/** MIME 类型：application/logout+jwt */
	APPLICATION_LOGOUT_JWT("application/logout+jwt"),
	/** MIME 类型：application/lost+xml */
	APPLICATION_LOST_XML("application/lost+xml"),
	/** MIME 类型：application/lostsync+xml */
	APPLICATION_LOSTSYNC_XML("application/lostsync+xml"),
	/** MIME 类型：application/lpf+zip */
	APPLICATION_LPF_ZIP("application/lpf+zip"),
	/** MIME 类型：application/LXF */
	APPLICATION_LXF("application/LXF"),
	/** MIME 类型：application/mac-binhex40 */
	APPLICATION_MAC_BINHEX40("application/mac-binhex40"),
	/** MIME 类型：application/macwriteii */
	APPLICATION_MACWRITEII("application/macwriteii"),
	/** MIME 类型：application/mads+xml */
	APPLICATION_MADS_XML("application/mads+xml"),
	/** MIME 类型：application/manifest+json */
	APPLICATION_MANIFEST_JSON("application/manifest+json"),
	/** MIME 类型：application/marc */
	APPLICATION_MARC("application/marc"),
	/** MIME 类型：application/marcxml+xml */
	APPLICATION_MARCXML_XML("application/marcxml+xml"),
	/** MIME 类型：application/mathematica */
	APPLICATION_MATHEMATICA("application/mathematica"),
	/** MIME 类型：application/mathml+xml */
	APPLICATION_MATHML_XML("application/mathml+xml"),
	/** MIME 类型：application/mathml-content+xml */
	APPLICATION_MATHML_CONTENT_XML("application/mathml-content+xml"),
	/** MIME 类型：application/mathml-presentation+xml */
	APPLICATION_MATHML_PRESENTATION_XML("application/mathml-presentation+xml"),
	/** MIME 类型：application/mbms-associated-procedure-description+xml */
	APPLICATION_MBMS_ASSOCIATED_PROCEDURE_DESCRIPTION_XML("application/mbms-associated-procedure-description+xml"),
	/** MIME 类型：application/mbms-deregister+xml */
	APPLICATION_MBMS_DEREGISTER_XML("application/mbms-deregister+xml"),
	/** MIME 类型：application/mbms-envelope+xml */
	APPLICATION_MBMS_ENVELOPE_XML("application/mbms-envelope+xml"),
	/** MIME 类型：application/mbms-msk-response+xml */
	APPLICATION_MBMS_MSK_RESPONSE_XML("application/mbms-msk-response+xml"),
	/** MIME 类型：application/mbms-msk+xml */
	APPLICATION_MBMS_MSK_XML("application/mbms-msk+xml"),
	/** MIME 类型：application/mbms-protection-description+xml */
	APPLICATION_MBMS_PROTECTION_DESCRIPTION_XML("application/mbms-protection-description+xml"),
	/** MIME 类型：application/mbms-reception-report+xml */
	APPLICATION_MBMS_RECEPTION_REPORT_XML("application/mbms-reception-report+xml"),
	/** MIME 类型：application/mbms-register-response+xml */
	APPLICATION_MBMS_REGISTER_RESPONSE_XML("application/mbms-register-response+xml"),
	/** MIME 类型：application/mbms-register+xml */
	APPLICATION_MBMS_REGISTER_XML("application/mbms-register+xml"),
	/** MIME 类型：application/mbms-schedule+xml */
	APPLICATION_MBMS_SCHEDULE_XML("application/mbms-schedule+xml"),
	/** MIME 类型：application/mbms-user-service-description+xml */
	APPLICATION_MBMS_USER_SERVICE_DESCRIPTION_XML("application/mbms-user-service-description+xml"),
	/** MIME 类型：application/mbox */
	APPLICATION_MBOX("application/mbox"),
	/** MIME 类型：application/media_control+xml */
	APPLICATION_MEDIA_CONTROL_XML("application/media_control+xml"),
	/** MIME 类型：application/media-policy-dataset+xml */
	APPLICATION_MEDIA_POLICY_DATASET_XML("application/media-policy-dataset+xml"),
	/** MIME 类型：application/mediaservercontrol+xml */
	APPLICATION_MEDIASERVERCONTROL_XML("application/mediaservercontrol+xml"),
	/** MIME 类型：application/merge-patch+json */
	APPLICATION_MERGE_PATCH_JSON("application/merge-patch+json"),
	/** MIME 类型：application/metalink4+xml */
	APPLICATION_METALINK4_XML("application/metalink4+xml"),
	/** MIME 类型：application/mets+xml */
	APPLICATION_METS_XML("application/mets+xml"),
	/** MIME 类型：application/MF4 */
	APPLICATION_MF4("application/MF4"),
	/** MIME 类型：application/mikey */
	APPLICATION_MIKEY("application/mikey"),
	/** MIME 类型：application/mipc */
	APPLICATION_MIPC("application/mipc"),
	/** MIME 类型：application/missing-blocks+cbor-seq */
	APPLICATION_MISSING_BLOCKS_CBOR_SEQ("application/missing-blocks+cbor-seq"),
	/** MIME 类型：application/mmt-aei+xml */
	APPLICATION_MMT_AEI_XML("application/mmt-aei+xml"),
	/** MIME 类型：application/mmt-usd+xml */
	APPLICATION_MMT_USD_XML("application/mmt-usd+xml"),
	/** MIME 类型：application/mods+xml */
	APPLICATION_MODS_XML("application/mods+xml"),
	/** MIME 类型：application/moss-keys */
	APPLICATION_MOSS_KEYS("application/moss-keys"),
	/** MIME 类型：application/moss-signature */
	APPLICATION_MOSS_SIGNATURE("application/moss-signature"),
	/** MIME 类型：application/mosskey-data */
	APPLICATION_MOSSKEY_DATA("application/mosskey-data"),
	/** MIME 类型：application/mosskey-request */
	APPLICATION_MOSSKEY_REQUEST("application/mosskey-request"),
	/** MIME 类型：application/mp21 */
	APPLICATION_MP21("application/mp21"),
	/** MIME 类型：application/mp4 */
	APPLICATION_MP4("application/mp4"),
	/** MIME 类型：application/mpeg4-generic */
	APPLICATION_MPEG4_GENERIC("application/mpeg4-generic"),
	/** MIME 类型：application/mpeg4-iod */
	APPLICATION_MPEG4_IOD("application/mpeg4-iod"),
	/** MIME 类型：application/mpeg4-iod-xmt */
	APPLICATION_MPEG4_IOD_XMT("application/mpeg4-iod-xmt"),
	/** MIME 类型：application/mrb-consumer+xml */
	APPLICATION_MRB_CONSUMER_XML("application/mrb-consumer+xml"),
	/** MIME 类型：application/mrb-publish+xml */
	APPLICATION_MRB_PUBLISH_XML("application/mrb-publish+xml"),
	/** MIME 类型：application/msc-ivr+xml */
	APPLICATION_MSC_IVR_XML("application/msc-ivr+xml"),
	/** MIME 类型：application/msc-mixer+xml */
	APPLICATION_MSC_MIXER_XML("application/msc-mixer+xml"),
	/** MIME 类型：application/msword */
	APPLICATION_MSWORD("application/msword"),
	/** MIME 类型：application/mud+json */
	APPLICATION_MUD_JSON("application/mud+json"),
	/** MIME 类型：application/multipart-core */
	APPLICATION_MULTIPART_CORE("application/multipart-core"),
	/** MIME 类型：application/mxf */
	APPLICATION_MXF("application/mxf"),
	/** MIME 类型：application/n-quads */
	APPLICATION_N_QUADS("application/n-quads"),
	/** MIME 类型：application/n-triples */
	APPLICATION_N_TRIPLES("application/n-triples"),
	/** MIME 类型：application/nasdata */
	APPLICATION_NASDATA("application/nasdata"),
	/** MIME 类型：application/news-checkgroups */
	APPLICATION_NEWS_CHECKGROUPS("application/news-checkgroups"),
	/** MIME 类型：application/news-groupinfo */
	APPLICATION_NEWS_GROUPINFO("application/news-groupinfo"),
	/** MIME 类型：application/news-transmission */
	APPLICATION_NEWS_TRANSMISSION("application/news-transmission"),
	/** MIME 类型：application/nlsml+xml */
	APPLICATION_NLSML_XML("application/nlsml+xml"),
	/** MIME 类型：application/node */
	APPLICATION_NODE("application/node"),
	/** MIME 类型：application/nss */
	APPLICATION_NSS("application/nss"),
	/** MIME 类型：application/oauth-authz-req+jwt */
	APPLICATION_OAUTH_AUTHZ_REQ_JWT("application/oauth-authz-req+jwt"),
	/** MIME 类型：application/oblivious-dns-message */
	APPLICATION_OBLIVIOUS_DNS_MESSAGE("application/oblivious-dns-message"),
	/** MIME 类型：application/ocsp-request */
	APPLICATION_OCSP_REQUEST("application/ocsp-request"),
	/** MIME 类型：application/ocsp-response */
	APPLICATION_OCSP_RESPONSE("application/ocsp-response"),
	/** MIME 类型：application/octet-stream */
	APPLICATION_OCTET_STREAM("application/octet-stream"),
	/** MIME 类型：application/ODA */
	APPLICATION_ODA("application/ODA"),
	/** MIME 类型：application/odm+xml */
	APPLICATION_ODM_XML("application/odm+xml"),
	/** MIME 类型：application/ODX */
	APPLICATION_ODX("application/ODX"),
	/** MIME 类型：application/oebps-package+xml */
	APPLICATION_OEBPS_PACKAGE_XML("application/oebps-package+xml"),
	/** MIME 类型：application/ogg */
	APPLICATION_OGG("application/ogg"),
	/** MIME 类型：application/ohttp-keys */
	APPLICATION_OHTTP_KEYS("application/ohttp-keys"),
	/** MIME 类型：application/opc-nodeset+xml */
	APPLICATION_OPC_NODESET_XML("application/opc-nodeset+xml"),
	/** MIME 类型：application/oscore */
	APPLICATION_OSCORE("application/oscore"),
	/** MIME 类型：application/oxps */
	APPLICATION_OXPS("application/oxps"),
	/** MIME 类型：application/p21 */
	APPLICATION_P21("application/p21"),
	/** MIME 类型：application/p21+zip */
	APPLICATION_P21_ZIP("application/p21+zip"),
	/** MIME 类型：application/p2p-overlay+xml */
	APPLICATION_P2P_OVERLAY_XML("application/p2p-overlay+xml"),
	/** MIME 类型：application/parityfec */
	APPLICATION_PARITYFEC("application/parityfec"),
	/** MIME 类型：application/passport */
	APPLICATION_PASSPORT("application/passport"),
	/** MIME 类型：application/patch-ops-error+xml */
	APPLICATION_PATCH_OPS_ERROR_XML("application/patch-ops-error+xml"),
	/** MIME 类型：application/pdf */
	APPLICATION_PDF("application/pdf"),
	/** MIME 类型：application/PDX */
	APPLICATION_PDX("application/PDX"),
	/** MIME 类型：application/pem-certificate-chain */
	APPLICATION_PEM_CERTIFICATE_CHAIN("application/pem-certificate-chain"),
	/** MIME 类型：application/pgp-encrypted */
	APPLICATION_PGP_ENCRYPTED("application/pgp-encrypted"),
	/** MIME 类型：application/pgp-keys */
	APPLICATION_PGP_KEYS("application/pgp-keys"),
	/** MIME 类型：application/pgp-signature */
	APPLICATION_PGP_SIGNATURE("application/pgp-signature"),
	/** MIME 类型：application/pidf-diff+xml */
	APPLICATION_PIDF_DIFF_XML("application/pidf-diff+xml"),
	/** MIME 类型：application/pidf+xml */
	APPLICATION_PIDF_XML("application/pidf+xml"),
	/** MIME 类型：application/pkcs10 */
	APPLICATION_PKCS10("application/pkcs10"),
	/** MIME 类型：application/pkcs7-mime */
	APPLICATION_PKCS7_MIME("application/pkcs7-mime"),
	/** MIME 类型：application/pkcs7-signature */
	APPLICATION_PKCS7_SIGNATURE("application/pkcs7-signature"),
	/** MIME 类型：application/pkcs8 */
	APPLICATION_PKCS8("application/pkcs8"),
	/** MIME 类型：application/pkcs8-encrypted */
	APPLICATION_PKCS8_ENCRYPTED("application/pkcs8-encrypted"),
	/** MIME 类型：application/pkcs12 */
	APPLICATION_PKCS12("application/pkcs12"),
	/** MIME 类型：application/pkix-attr-cert */
	APPLICATION_PKIX_ATTR_CERT("application/pkix-attr-cert"),
	/** MIME 类型：application/pkix-cert */
	APPLICATION_PKIX_CERT("application/pkix-cert"),
	/** MIME 类型：application/pkix-crl */
	APPLICATION_PKIX_CRL("application/pkix-crl"),
	/** MIME 类型：application/pkix-pkipath */
	APPLICATION_PKIX_PKIPATH("application/pkix-pkipath"),
	/** MIME 类型：application/pkixcmp */
	APPLICATION_PKIXCMP("application/pkixcmp"),
	/** MIME 类型：application/pls+xml */
	APPLICATION_PLS_XML("application/pls+xml"),
	/** MIME 类型：application/poc-settings+xml */
	APPLICATION_POC_SETTINGS_XML("application/poc-settings+xml"),
	/** MIME 类型：application/postscript */
	APPLICATION_POSTSCRIPT("application/postscript"),
	/** MIME 类型：application/ppsp-tracker+json */
	APPLICATION_PPSP_TRACKER_JSON("application/ppsp-tracker+json"),
	/** MIME 类型：application/private-token-issuer-directory */
	APPLICATION_PRIVATE_TOKEN_ISSUER_DIRECTORY("application/private-token-issuer-directory"),
	/** MIME 类型：application/private-token-request */
	APPLICATION_PRIVATE_TOKEN_REQUEST("application/private-token-request"),
	/** MIME 类型：application/private-token-response */
	APPLICATION_PRIVATE_TOKEN_RESPONSE("application/private-token-response"),
	/** MIME 类型：application/problem+json */
	APPLICATION_PROBLEM_JSON("application/problem+json"),
	/** MIME 类型：application/problem+xml */
	APPLICATION_PROBLEM_XML("application/problem+xml"),
	/** MIME 类型：application/protobuf */
	APPLICATION_PROTOBUF("application/protobuf"),
	/** MIME 类型：application/protobuf+json */
	APPLICATION_PROTOBUF_JSON("application/protobuf+json"),
	/** MIME 类型：application/provenance+xml */
	APPLICATION_PROVENANCE_XML("application/provenance+xml"),
	/** MIME 类型：application/provided-claims+jwt */
	APPLICATION_PROVIDED_CLAIMS_JWT("application/provided-claims+jwt"),
	/** MIME 类型：application/prs.alvestrand.titrax-sheet */
	APPLICATION_PRS_ALVESTRAND_TITRAX_SHEET("application/prs.alvestrand.titrax-sheet"),
	/** MIME 类型：application/prs.cww */
	APPLICATION_PRS_CWW("application/prs.cww"),
	/** MIME 类型：application/prs.cyn */
	APPLICATION_PRS_CYN("application/prs.cyn"),
	/** MIME 类型：application/prs.hpub+zip */
	APPLICATION_PRS_HPUB_ZIP("application/prs.hpub+zip"),
	/** MIME 类型：application/prs.implied-document+xml */
	APPLICATION_PRS_IMPLIED_DOCUMENT_XML("application/prs.implied-document+xml"),
	/** MIME 类型：application/prs.implied-executable */
	APPLICATION_PRS_IMPLIED_EXECUTABLE("application/prs.implied-executable"),
	/** MIME 类型：application/prs.implied-object+json */
	APPLICATION_PRS_IMPLIED_OBJECT_JSON("application/prs.implied-object+json"),
	/** MIME 类型：application/prs.implied-object+json-seq */
	APPLICATION_PRS_IMPLIED_OBJECT_JSON_SEQ("application/prs.implied-object+json-seq"),
	/** MIME 类型：application/prs.implied-object+yaml */
	APPLICATION_PRS_IMPLIED_OBJECT_YAML("application/prs.implied-object+yaml"),
	/** MIME 类型：application/prs.implied-structure */
	APPLICATION_PRS_IMPLIED_STRUCTURE("application/prs.implied-structure"),
	/** MIME 类型：application/prs.mayfile */
	APPLICATION_PRS_MAYFILE("application/prs.mayfile"),
	/** MIME 类型：application/prs.nprend */
	APPLICATION_PRS_NPREND("application/prs.nprend"),
	/** MIME 类型：application/prs.plucker */
	APPLICATION_PRS_PLUCKER("application/prs.plucker"),
	/** MIME 类型：application/prs.rdf-xml-crypt */
	APPLICATION_PRS_RDF_XML_CRYPT("application/prs.rdf-xml-crypt"),
	/** MIME 类型：application/prs.sclt */
	APPLICATION_PRS_SCLT("application/prs.sclt"),
	/** MIME 类型：application/prs.vcfbzip2 */
	APPLICATION_PRS_VCFBZIP2("application/prs.vcfbzip2"),
	/** MIME 类型：application/prs.xsf+xml */
	APPLICATION_PRS_XSF_XML("application/prs.xsf+xml"),
	/** MIME 类型：application/pskc+xml */
	APPLICATION_PSKC_XML("application/pskc+xml"),
	/** MIME 类型：application/pvd+json */
	APPLICATION_PVD_JSON("application/pvd+json"),
	/** MIME 类型：application/rdf+xml */
	APPLICATION_RDF_XML("application/rdf+xml"),
	/** MIME 类型：application/route-apd+xml */
	APPLICATION_ROUTE_APD_XML("application/route-apd+xml"),
	/** MIME 类型：application/route-s-tsid+xml */
	APPLICATION_ROUTE_S_TSID_XML("application/route-s-tsid+xml"),
	/** MIME 类型：application/route-usd+xml */
	APPLICATION_ROUTE_USD_XML("application/route-usd+xml"),
	/** MIME 类型：application/QSIG */
	APPLICATION_QSIG("application/QSIG"),
	/** MIME 类型：application/raptorfec */
	APPLICATION_RAPTORFEC("application/raptorfec"),
	/** MIME 类型：application/rdap+json */
	APPLICATION_RDAP_JSON("application/rdap+json"),
	/** MIME 类型：application/reginfo+xml */
	APPLICATION_REGINFO_XML("application/reginfo+xml"),
	/** MIME 类型：application/relax-ng-compact-syntax */
	APPLICATION_RELAX_NG_COMPACT_SYNTAX("application/relax-ng-compact-syntax"),
	/** MIME 类型：application/remote-printing */
	APPLICATION_REMOTE_PRINTING("application/remote-printing"),
	/** MIME 类型：application/reputon+json */
	APPLICATION_REPUTON_JSON("application/reputon+json"),
	/** MIME 类型：application/resolve-response+jwt */
	APPLICATION_RESOLVE_RESPONSE_JWT("application/resolve-response+jwt"),
	/** MIME 类型：application/resource-lists-diff+xml */
	APPLICATION_RESOURCE_LISTS_DIFF_XML("application/resource-lists-diff+xml"),
	/** MIME 类型：application/resource-lists+xml */
	APPLICATION_RESOURCE_LISTS_XML("application/resource-lists+xml"),
	/** MIME 类型：application/rfc+xml */
	APPLICATION_RFC_XML("application/rfc+xml"),
	/** MIME 类型：application/riscos */
	APPLICATION_RISCOS("application/riscos"),
	/** MIME 类型：application/rlmi+xml */
	APPLICATION_RLMI_XML("application/rlmi+xml"),
	/** MIME 类型：application/rls-services+xml */
	APPLICATION_RLS_SERVICES_XML("application/rls-services+xml"),
	/** MIME 类型：application/rpki-checklist */
	APPLICATION_RPKI_CHECKLIST("application/rpki-checklist"),
	/** MIME 类型：application/rpki-ghostbusters */
	APPLICATION_RPKI_GHOSTBUSTERS("application/rpki-ghostbusters"),
	/** MIME 类型：application/rpki-manifest */
	APPLICATION_RPKI_MANIFEST("application/rpki-manifest"),
	/** MIME 类型：application/rpki-publication */
	APPLICATION_RPKI_PUBLICATION("application/rpki-publication"),
	/** MIME 类型：application/rpki-roa */
	APPLICATION_RPKI_ROA("application/rpki-roa"),
	/** MIME 类型：application/rpki-signed-tal */
	APPLICATION_RPKI_SIGNED_TAL("application/rpki-signed-tal"),
	/** MIME 类型：application/rpki-updown */
	APPLICATION_RPKI_UPDOWN("application/rpki-updown"),
	/** MIME 类型：application/rs-metadata+xml */
	APPLICATION_RS_METADATA_XML("application/rs-metadata+xml"),
	/** MIME 类型：application/rtf */
	APPLICATION_RTF("application/rtf"),
	/** MIME 类型：application/rtploopback */
	APPLICATION_RTPLOOPBACK("application/rtploopback"),
	/** MIME 类型：application/rtx */
	APPLICATION_RTX("application/rtx"),
	/** MIME 类型：application/samlassertion+xml */
	APPLICATION_SAMLASSERTION_XML("application/samlassertion+xml"),
	/** MIME 类型：application/samlmetadata+xml */
	APPLICATION_SAMLMETADATA_XML("application/samlmetadata+xml"),
	/** MIME 类型：application/sarif-external-properties+json */
	APPLICATION_SARIF_EXTERNAL_PROPERTIES_JSON("application/sarif-external-properties+json"),
	/** MIME 类型：application/sarif+json */
	APPLICATION_SARIF_JSON("application/sarif+json"),
	/** MIME 类型：application/sbe */
	APPLICATION_SBE("application/sbe"),
	/** MIME 类型：application/sbml+xml */
	APPLICATION_SBML_XML("application/sbml+xml"),
	/** MIME 类型：application/scaip+xml */
	APPLICATION_SCAIP_XML("application/scaip+xml"),
	/** MIME 类型：application/scim+json */
	APPLICATION_SCIM_JSON("application/scim+json"),
	/** MIME 类型：application/scitt-receipt+cose */
	APPLICATION_SCITT_RECEIPT_COSE("application/scitt-receipt+cose"),
	/** MIME 类型：application/scitt-statement+cose */
	APPLICATION_SCITT_STATEMENT_COSE("application/scitt-statement+cose"),
	/** MIME 类型：application/scvp-cv-request */
	APPLICATION_SCVP_CV_REQUEST("application/scvp-cv-request"),
	/** MIME 类型：application/scvp-cv-response */
	APPLICATION_SCVP_CV_RESPONSE("application/scvp-cv-response"),
	/** MIME 类型：application/scvp-vp-request */
	APPLICATION_SCVP_VP_REQUEST("application/scvp-vp-request"),
	/** MIME 类型：application/scvp-vp-response */
	APPLICATION_SCVP_VP_RESPONSE("application/scvp-vp-response"),
	/** MIME 类型：application/sd-jwt */
	APPLICATION_SD_JWT("application/sd-jwt"),
	/** MIME 类型：application/sd-jwt+json */
	APPLICATION_SD_JWT_JSON("application/sd-jwt+json"),
	/** MIME 类型：application/sdf+json */
	APPLICATION_SDF_JSON("application/sdf+json"),
	/** MIME 类型：application/sdp */
	APPLICATION_SDP("application/sdp"),
	/** MIME 类型：application/secevent+jwt */
	APPLICATION_SECEVENT_JWT("application/secevent+jwt"),
	/** MIME 类型：application/senml-etch+cbor */
	APPLICATION_SENML_ETCH_CBOR("application/senml-etch+cbor"),
	/** MIME 类型：application/senml-etch+json */
	APPLICATION_SENML_ETCH_JSON("application/senml-etch+json"),
	/** MIME 类型：application/senml-exi */
	APPLICATION_SENML_EXI("application/senml-exi"),
	/** MIME 类型：application/senml+cbor */
	APPLICATION_SENML_CBOR("application/senml+cbor"),
	/** MIME 类型：application/senml+json */
	APPLICATION_SENML_JSON("application/senml+json"),
	/** MIME 类型：application/senml+xml */
	APPLICATION_SENML_XML("application/senml+xml"),
	/** MIME 类型：application/sensml-exi */
	APPLICATION_SENSML_EXI("application/sensml-exi"),
	/** MIME 类型：application/sensml+cbor */
	APPLICATION_SENSML_CBOR("application/sensml+cbor"),
	/** MIME 类型：application/sensml+json */
	APPLICATION_SENSML_JSON("application/sensml+json"),
	/** MIME 类型：application/sensml+xml */
	APPLICATION_SENSML_XML("application/sensml+xml"),
	/** MIME 类型：application/sep-exi */
	APPLICATION_SEP_EXI("application/sep-exi"),
	/** MIME 类型：application/sep+xml */
	APPLICATION_SEP_XML("application/sep+xml"),
	/** MIME 类型：application/session-info */
	APPLICATION_SESSION_INFO("application/session-info"),
	/** MIME 类型：application/set-payment */
	APPLICATION_SET_PAYMENT("application/set-payment"),
	/** MIME 类型：application/set-payment-initiation */
	APPLICATION_SET_PAYMENT_INITIATION("application/set-payment-initiation"),
	/** MIME 类型：application/set-registration */
	APPLICATION_SET_REGISTRATION("application/set-registration"),
	/** MIME 类型：application/set-registration-initiation */
	APPLICATION_SET_REGISTRATION_INITIATION("application/set-registration-initiation"),
	/** MIME 类型：application/SGML */
	APPLICATION_SGML("application/SGML"),
	/** MIME 类型：application/sgml-open-catalog */
	APPLICATION_SGML_OPEN_CATALOG("application/sgml-open-catalog"),
	/** MIME 类型：application/shf+xml */
	APPLICATION_SHF_XML("application/shf+xml"),
	/** MIME 类型：application/sieve */
	APPLICATION_SIEVE("application/sieve"),
	/** MIME 类型：application/simple-filter+xml */
	APPLICATION_SIMPLE_FILTER_XML("application/simple-filter+xml"),
	/** MIME 类型：application/simple-message-summary */
	APPLICATION_SIMPLE_MESSAGE_SUMMARY("application/simple-message-summary"),
	/** MIME 类型：application/simpleSymbolContainer */
	APPLICATION_SIMPLESYMBOLCONTAINER("application/simpleSymbolContainer"),
	/** MIME 类型：application/sipc */
	APPLICATION_SIPC("application/sipc"),
	/** MIME 类型：application/slate */
	APPLICATION_SLATE("application/slate"),
	/** MIME 类型：application/smil */
	APPLICATION_SMIL("application/smil"),
	/** MIME 类型：application/smil+xml */
	APPLICATION_SMIL_XML("application/smil+xml"),
	/** MIME 类型：application/smpte336m */
	APPLICATION_SMPTE336M("application/smpte336m"),
	/** MIME 类型：application/soap+fastinfoset */
	APPLICATION_SOAP_FASTINFOSET("application/soap+fastinfoset"),
	/** MIME 类型：application/soap+xml */
	APPLICATION_SOAP_XML("application/soap+xml"),
	/** MIME 类型：application/sparql-query */
	APPLICATION_SPARQL_QUERY("application/sparql-query"),
	/** MIME 类型：application/spdx+json */
	APPLICATION_SPDX_JSON("application/spdx+json"),
	/** MIME 类型：application/sparql-results+xml */
	APPLICATION_SPARQL_RESULTS_XML("application/sparql-results+xml"),
	/** MIME 类型：application/spirits-event+xml */
	APPLICATION_SPIRITS_EVENT_XML("application/spirits-event+xml"),
	/** MIME 类型：application/sql */
	APPLICATION_SQL("application/sql"),
	/** MIME 类型：application/srgs */
	APPLICATION_SRGS("application/srgs"),
	/** MIME 类型：application/srgs+xml */
	APPLICATION_SRGS_XML("application/srgs+xml"),
	/** MIME 类型：application/sru+xml */
	APPLICATION_SRU_XML("application/sru+xml"),
	/** MIME 类型：application/sslkeylogfile */
	APPLICATION_SSLKEYLOGFILE("application/sslkeylogfile"),
	/** MIME 类型：application/ssml+xml */
	APPLICATION_SSML_XML("application/ssml+xml"),
	/** MIME 类型：application/ST2110-41 */
	APPLICATION_ST2110_41("application/ST2110-41"),
	/** MIME 类型：application/stix+json */
	APPLICATION_STIX_JSON("application/stix+json"),
	/** MIME 类型：application/stratum */
	APPLICATION_STRATUM("application/stratum"),
	/** MIME 类型：application/suit-envelope+cose */
	APPLICATION_SUIT_ENVELOPE_COSE("application/suit-envelope+cose"),
	/** MIME 类型：application/suit-report+cose */
	APPLICATION_SUIT_REPORT_COSE("application/suit-report+cose"),
	/** MIME 类型：application/swid+cbor */
	APPLICATION_SWID_CBOR("application/swid+cbor"),
	/** MIME 类型：application/swid+xml */
	APPLICATION_SWID_XML("application/swid+xml"),
	/** MIME 类型：application/tamp-apex-update */
	APPLICATION_TAMP_APEX_UPDATE("application/tamp-apex-update"),
	/** MIME 类型：application/tamp-apex-update-confirm */
	APPLICATION_TAMP_APEX_UPDATE_CONFIRM("application/tamp-apex-update-confirm"),
	/** MIME 类型：application/tamp-community-update */
	APPLICATION_TAMP_COMMUNITY_UPDATE("application/tamp-community-update"),
	/** MIME 类型：application/tamp-community-update-confirm */
	APPLICATION_TAMP_COMMUNITY_UPDATE_CONFIRM("application/tamp-community-update-confirm"),
	/** MIME 类型：application/tamp-error */
	APPLICATION_TAMP_ERROR("application/tamp-error"),
	/** MIME 类型：application/tamp-sequence-adjust */
	APPLICATION_TAMP_SEQUENCE_ADJUST("application/tamp-sequence-adjust"),
	/** MIME 类型：application/tamp-sequence-adjust-confirm */
	APPLICATION_TAMP_SEQUENCE_ADJUST_CONFIRM("application/tamp-sequence-adjust-confirm"),
	/** MIME 类型：application/tamp-status-query */
	APPLICATION_TAMP_STATUS_QUERY("application/tamp-status-query"),
	/** MIME 类型：application/tamp-status-response */
	APPLICATION_TAMP_STATUS_RESPONSE("application/tamp-status-response"),
	/** MIME 类型：application/tamp-update */
	APPLICATION_TAMP_UPDATE("application/tamp-update"),
	/** MIME 类型：application/tamp-update-confirm */
	APPLICATION_TAMP_UPDATE_CONFIRM("application/tamp-update-confirm"),
	/** MIME 类型：application/taxii+json */
	APPLICATION_TAXII_JSON("application/taxii+json"),
	/** MIME 类型：application/td+json */
	APPLICATION_TD_JSON("application/td+json"),
	/** MIME 类型：application/tei+xml */
	APPLICATION_TEI_XML("application/tei+xml"),
	/** MIME 类型：application/TETRA_ISI */
	APPLICATION_TETRA_ISI("application/TETRA_ISI"),
	/** MIME 类型：application/texinfo */
	APPLICATION_TEXINFO("application/texinfo"),
	/** MIME 类型：application/thraud+xml */
	APPLICATION_THRAUD_XML("application/thraud+xml"),
	/** MIME 类型：application/timestamp-query */
	APPLICATION_TIMESTAMP_QUERY("application/timestamp-query"),
	/** MIME 类型：application/timestamp-reply */
	APPLICATION_TIMESTAMP_REPLY("application/timestamp-reply"),
	/** MIME 类型：application/timestamped-data */
	APPLICATION_TIMESTAMPED_DATA("application/timestamped-data"),
	/** MIME 类型：application/tlsrpt+gzip */
	APPLICATION_TLSRPT_GZIP("application/tlsrpt+gzip"),
	/** MIME 类型：application/tlsrpt+json */
	APPLICATION_TLSRPT_JSON("application/tlsrpt+json"),
	/** MIME 类型：application/tm+json */
	APPLICATION_TM_JSON("application/tm+json"),
	/** MIME 类型：application/tnauthlist */
	APPLICATION_TNAUTHLIST("application/tnauthlist"),
	/** MIME 类型：application/toc+cbor */
	APPLICATION_TOC_CBOR("application/toc+cbor"),
	/** MIME 类型：application/token-introspection+jwt */
	APPLICATION_TOKEN_INTROSPECTION_JWT("application/token-introspection+jwt"),
	/** MIME 类型：application/toml */
	APPLICATION_TOML("application/toml"),
	/** MIME 类型：application/trickle-ice-sdpfrag */
	APPLICATION_TRICKLE_ICE_SDPFRAG("application/trickle-ice-sdpfrag"),
	/** MIME 类型：application/trig */
	APPLICATION_TRIG("application/trig"),
	/** MIME 类型：application/trust-chain+json */
	APPLICATION_TRUST_CHAIN_JSON("application/trust-chain+json"),
	/** MIME 类型：application/trust-mark+jwt */
	APPLICATION_TRUST_MARK_JWT("application/trust-mark+jwt"),
	/** MIME 类型：application/trust-mark-delegation+jwt */
	APPLICATION_TRUST_MARK_DELEGATION_JWT("application/trust-mark-delegation+jwt"),
	/** MIME 类型：application/trust-mark-status-response+jwt */
	APPLICATION_TRUST_MARK_STATUS_RESPONSE_JWT("application/trust-mark-status-response+jwt"),
	/** MIME 类型：application/ttml+xml */
	APPLICATION_TTML_XML("application/ttml+xml"),
	/** MIME 类型：application/tve-trigger */
	APPLICATION_TVE_TRIGGER("application/tve-trigger"),
	/** MIME 类型：application/tzif */
	APPLICATION_TZIF("application/tzif"),
	/** MIME 类型：application/tzif-leap */
	APPLICATION_TZIF_LEAP("application/tzif-leap"),
	/** MIME 类型：application/uccs+cbor */
	APPLICATION_UCCS_CBOR("application/uccs+cbor"),
	/** MIME 类型：application/ujcs+json */
	APPLICATION_UJCS_JSON("application/ujcs+json"),
	/** MIME 类型：application/ulpfec */
	APPLICATION_ULPFEC("application/ulpfec"),
	/** MIME 类型：application/urc-grpsheet+xml */
	APPLICATION_URC_GRPSHEET_XML("application/urc-grpsheet+xml"),
	/** MIME 类型：application/urc-ressheet+xml */
	APPLICATION_URC_RESSHEET_XML("application/urc-ressheet+xml"),
	/** MIME 类型：application/urc-targetdesc+xml */
	APPLICATION_URC_TARGETDESC_XML("application/urc-targetdesc+xml"),
	/** MIME 类型：application/urc-uisocketdesc+xml */
	APPLICATION_URC_UISOCKETDESC_XML("application/urc-uisocketdesc+xml"),
	/** MIME 类型：application/vc */
	APPLICATION_VC("application/vc"),
	/** MIME 类型：application/vc+cose */
	APPLICATION_VC_COSE("application/vc+cose"),
	/** MIME 类型：application/vc+jwt */
	APPLICATION_VC_JWT("application/vc+jwt"),
	/** MIME 类型：application/vc+sd-jwt */
	APPLICATION_VC_SD_JWT("application/vc+sd-jwt"),
	/** MIME 类型：application/vcard+json */
	APPLICATION_VCARD_JSON("application/vcard+json"),
	/** MIME 类型：application/vcard+xml */
	APPLICATION_VCARD_XML("application/vcard+xml"),
	/** MIME 类型：application/vec+xml */
	APPLICATION_VEC_XML("application/vec+xml"),
	/** MIME 类型：application/vec-package+gzip */
	APPLICATION_VEC_PACKAGE_GZIP("application/vec-package+gzip"),
	/** MIME 类型：application/vec-package+zip */
	APPLICATION_VEC_PACKAGE_ZIP("application/vec-package+zip"),
	/** MIME 类型：application/vemmi */
	APPLICATION_VEMMI("application/vemmi"),
	/** MIME 类型：application/vnd.1000minds.decision-model+xml */
	APPLICATION_VND_1000MINDS_DECISION_MODEL_XML("application/vnd.1000minds.decision-model+xml"),
	/** MIME 类型：application/vnd.1ob */
	APPLICATION_VND_1OB("application/vnd.1ob"),
	/** MIME 类型：application/vnd.3gpp.5gnas */
	APPLICATION_VND_3GPP_5GNAS("application/vnd.3gpp.5gnas"),
	/** MIME 类型：application/vnd.3gpp.5gsa2x */
	APPLICATION_VND_3GPP_5GSA2X("application/vnd.3gpp.5gsa2x"),
	/** MIME 类型：application/vnd.3gpp.5gsa2x-local-service-information */
	APPLICATION_VND_3GPP_5GSA2X_LOCAL_SERVICE_INFORMATION("application/vnd.3gpp.5gsa2x-local-service-information"),
	/** MIME 类型：application/vnd.3gpp.5gsv2x */
	APPLICATION_VND_3GPP_5GSV2X("application/vnd.3gpp.5gsv2x"),
	/** MIME 类型：application/vnd.3gpp.5gsv2x-local-service-information */
	APPLICATION_VND_3GPP_5GSV2X_LOCAL_SERVICE_INFORMATION("application/vnd.3gpp.5gsv2x-local-service-information"),
	/** MIME 类型：application/vnd.3gpp.access-transfer-events+xml */
	APPLICATION_VND_3GPP_ACCESS_TRANSFER_EVENTS_XML("application/vnd.3gpp.access-transfer-events+xml"),
	/** MIME 类型：application/vnd.3gpp.bsf+xml */
	APPLICATION_VND_3GPP_BSF_XML("application/vnd.3gpp.bsf+xml"),
	/** MIME 类型：application/vnd.3gpp.crs+xml */
	APPLICATION_VND_3GPP_CRS_XML("application/vnd.3gpp.crs+xml"),
	/** MIME 类型：application/vnd.3gpp.current-location-discovery+xml */
	APPLICATION_VND_3GPP_CURRENT_LOCATION_DISCOVERY_XML("application/vnd.3gpp.current-location-discovery+xml"),
	/** MIME 类型：application/vnd.3gpp.GMOP+xml */
	APPLICATION_VND_3GPP_GMOP_XML("application/vnd.3gpp.GMOP+xml"),
	/** MIME 类型：application/vnd.3gpp.gtpc */
	APPLICATION_VND_3GPP_GTPC("application/vnd.3gpp.gtpc"),
	/** MIME 类型：application/vnd.3gpp.interworking-data */
	APPLICATION_VND_3GPP_INTERWORKING_DATA("application/vnd.3gpp.interworking-data"),
	/** MIME 类型：application/vnd.3gpp.lpp */
	APPLICATION_VND_3GPP_LPP("application/vnd.3gpp.lpp"),
	/** MIME 类型：application/vnd.3gpp.mc-signalling-ear */
	APPLICATION_VND_3GPP_MC_SIGNALLING_EAR("application/vnd.3gpp.mc-signalling-ear"),
	/** MIME 类型：application/vnd.3gpp.mcdata-affiliation-command+xml */
	APPLICATION_VND_3GPP_MCDATA_AFFILIATION_COMMAND_XML("application/vnd.3gpp.mcdata-affiliation-command+xml"),
	/** MIME 类型：application/vnd.3gpp.mcdata-info+xml */
	APPLICATION_VND_3GPP_MCDATA_INFO_XML("application/vnd.3gpp.mcdata-info+xml"),
	/** MIME 类型：application/vnd.3gpp.mcdata-msgstore-ctrl-request+xml */
	APPLICATION_VND_3GPP_MCDATA_MSGSTORE_CTRL_REQUEST_XML("application/vnd.3gpp.mcdata-msgstore-ctrl-request+xml"),
	/** MIME 类型：application/vnd.3gpp.mcdata-payload */
	APPLICATION_VND_3GPP_MCDATA_PAYLOAD("application/vnd.3gpp.mcdata-payload"),
	/** MIME 类型：application/vnd.3gpp.mcdata-regroup+xml */
	APPLICATION_VND_3GPP_MCDATA_REGROUP_XML("application/vnd.3gpp.mcdata-regroup+xml"),
	/** MIME 类型：application/vnd.3gpp.mcdata-service-config+xml */
	APPLICATION_VND_3GPP_MCDATA_SERVICE_CONFIG_XML("application/vnd.3gpp.mcdata-service-config+xml"),
	/** MIME 类型：application/vnd.3gpp.mcdata-signalling */
	APPLICATION_VND_3GPP_MCDATA_SIGNALLING("application/vnd.3gpp.mcdata-signalling"),
	/** MIME 类型：application/vnd.3gpp.mcdata-ue-config+xml */
	APPLICATION_VND_3GPP_MCDATA_UE_CONFIG_XML("application/vnd.3gpp.mcdata-ue-config+xml"),
	/** MIME 类型：application/vnd.3gpp.mcdata-user-profile+xml */
	APPLICATION_VND_3GPP_MCDATA_USER_PROFILE_XML("application/vnd.3gpp.mcdata-user-profile+xml"),
	/** MIME 类型：application/vnd.3gpp.mcptt-affiliation-command+xml */
	APPLICATION_VND_3GPP_MCPTT_AFFILIATION_COMMAND_XML("application/vnd.3gpp.mcptt-affiliation-command+xml"),
	/** MIME 类型：application/vnd.3gpp.mcptt-floor-request+xml */
	APPLICATION_VND_3GPP_MCPTT_FLOOR_REQUEST_XML("application/vnd.3gpp.mcptt-floor-request+xml"),
	/** MIME 类型：application/vnd.3gpp.mcptt-info+xml */
	APPLICATION_VND_3GPP_MCPTT_INFO_XML("application/vnd.3gpp.mcptt-info+xml"),
	/** MIME 类型：application/vnd.3gpp.mcptt-location-info+xml */
	APPLICATION_VND_3GPP_MCPTT_LOCATION_INFO_XML("application/vnd.3gpp.mcptt-location-info+xml"),
	/** MIME 类型：application/vnd.3gpp.mcptt-mbms-usage-info+xml */
	APPLICATION_VND_3GPP_MCPTT_MBMS_USAGE_INFO_XML("application/vnd.3gpp.mcptt-mbms-usage-info+xml"),
	/** MIME 类型：application/vnd.3gpp.mcptt-regroup+xml */
	APPLICATION_VND_3GPP_MCPTT_REGROUP_XML("application/vnd.3gpp.mcptt-regroup+xml"),
	/** MIME 类型：application/vnd.3gpp.mcptt-service-config+xml */
	APPLICATION_VND_3GPP_MCPTT_SERVICE_CONFIG_XML("application/vnd.3gpp.mcptt-service-config+xml"),
	/** MIME 类型：application/vnd.3gpp.mcptt-signed+xml */
	APPLICATION_VND_3GPP_MCPTT_SIGNED_XML("application/vnd.3gpp.mcptt-signed+xml"),
	/** MIME 类型：application/vnd.3gpp.mcptt-ue-config+xml */
	APPLICATION_VND_3GPP_MCPTT_UE_CONFIG_XML("application/vnd.3gpp.mcptt-ue-config+xml"),
	/** MIME 类型：application/vnd.3gpp.mcptt-ue-init-config+xml */
	APPLICATION_VND_3GPP_MCPTT_UE_INIT_CONFIG_XML("application/vnd.3gpp.mcptt-ue-init-config+xml"),
	/** MIME 类型：application/vnd.3gpp.mcptt-user-profile+xml */
	APPLICATION_VND_3GPP_MCPTT_USER_PROFILE_XML("application/vnd.3gpp.mcptt-user-profile+xml"),
	/** MIME 类型：application/vnd.3gpp.mcvideo-affiliation-command+xml */
	APPLICATION_VND_3GPP_MCVIDEO_AFFILIATION_COMMAND_XML("application/vnd.3gpp.mcvideo-affiliation-command+xml"),
	/** MIME 类型：application/vnd.3gpp.mcvideo-affiliation-info+xml */
	APPLICATION_VND_3GPP_MCVIDEO_AFFILIATION_INFO_XML("application/vnd.3gpp.mcvideo-affiliation-info+xml"),
	/** MIME 类型：application/vnd.3gpp.mcvideo-info+xml */
	APPLICATION_VND_3GPP_MCVIDEO_INFO_XML("application/vnd.3gpp.mcvideo-info+xml"),
	/** MIME 类型：application/vnd.3gpp.mcvideo-location-info+xml */
	APPLICATION_VND_3GPP_MCVIDEO_LOCATION_INFO_XML("application/vnd.3gpp.mcvideo-location-info+xml"),
	/** MIME 类型：application/vnd.3gpp.mcvideo-mbms-usage-info+xml */
	APPLICATION_VND_3GPP_MCVIDEO_MBMS_USAGE_INFO_XML("application/vnd.3gpp.mcvideo-mbms-usage-info+xml"),
	/** MIME 类型：application/vnd.3gpp.mcvideo-regroup+xml */
	APPLICATION_VND_3GPP_MCVIDEO_REGROUP_XML("application/vnd.3gpp.mcvideo-regroup+xml"),
	/** MIME 类型：application/vnd.3gpp.mcvideo-service-config+xml */
	APPLICATION_VND_3GPP_MCVIDEO_SERVICE_CONFIG_XML("application/vnd.3gpp.mcvideo-service-config+xml"),
	/** MIME 类型：application/vnd.3gpp.mcvideo-transmission-request+xml */
	APPLICATION_VND_3GPP_MCVIDEO_TRANSMISSION_REQUEST_XML("application/vnd.3gpp.mcvideo-transmission-request+xml"),
	/** MIME 类型：application/vnd.3gpp.mcvideo-ue-config+xml */
	APPLICATION_VND_3GPP_MCVIDEO_UE_CONFIG_XML("application/vnd.3gpp.mcvideo-ue-config+xml"),
	/** MIME 类型：application/vnd.3gpp.mcvideo-user-profile+xml */
	APPLICATION_VND_3GPP_MCVIDEO_USER_PROFILE_XML("application/vnd.3gpp.mcvideo-user-profile+xml"),
	/** MIME 类型：application/vnd.3gpp.mid-call+xml */
	APPLICATION_VND_3GPP_MID_CALL_XML("application/vnd.3gpp.mid-call+xml"),
	/** MIME 类型：application/vnd.3gpp.ngap */
	APPLICATION_VND_3GPP_NGAP("application/vnd.3gpp.ngap"),
	/** MIME 类型：application/vnd.3gpp.pfcp */
	APPLICATION_VND_3GPP_PFCP("application/vnd.3gpp.pfcp"),
	/** MIME 类型：application/vnd.3gpp.pic-bw-large */
	APPLICATION_VND_3GPP_PIC_BW_LARGE("application/vnd.3gpp.pic-bw-large"),
	/** MIME 类型：application/vnd.3gpp.pic-bw-small */
	APPLICATION_VND_3GPP_PIC_BW_SMALL("application/vnd.3gpp.pic-bw-small"),
	/** MIME 类型：application/vnd.3gpp.pic-bw-var */
	APPLICATION_VND_3GPP_PIC_BW_VAR("application/vnd.3gpp.pic-bw-var"),
	/** MIME 类型：application/vnd.3gpp.pinapp-info+xml */
	APPLICATION_VND_3GPP_PINAPP_INFO_XML("application/vnd.3gpp.pinapp-info+xml"),
	/** MIME 类型：application/vnd.3gpp-prose-pc3a+xml */
	APPLICATION_VND_3GPP_PROSE_PC3A_XML("application/vnd.3gpp-prose-pc3a+xml"),
	/** MIME 类型：application/vnd.3gpp-prose-pc3ach+xml */
	APPLICATION_VND_3GPP_PROSE_PC3ACH_XML("application/vnd.3gpp-prose-pc3ach+xml"),
	/** MIME 类型：application/vnd.3gpp-prose-pc3ch+xml */
	APPLICATION_VND_3GPP_PROSE_PC3CH_XML("application/vnd.3gpp-prose-pc3ch+xml"),
	/** MIME 类型：application/vnd.3gpp-prose-pc8+xml */
	APPLICATION_VND_3GPP_PROSE_PC8_XML("application/vnd.3gpp-prose-pc8+xml"),
	/** MIME 类型：application/vnd.3gpp-prose+xml */
	APPLICATION_VND_3GPP_PROSE_XML("application/vnd.3gpp-prose+xml"),
	/** MIME 类型：application/vnd.3gpp.s1ap */
	APPLICATION_VND_3GPP_S1AP("application/vnd.3gpp.s1ap"),
	/** MIME 类型：application/vnd.3gpp.seal-app-comm-requirements-info+xml */
	APPLICATION_VND_3GPP_SEAL_APP_COMM_REQUIREMENTS_INFO_XML("application/vnd.3gpp.seal-app-comm-requirements-info+xml"),
	/** MIME 类型：application/vnd.3gpp.seal-data-delivery-info+cbor */
	APPLICATION_VND_3GPP_SEAL_DATA_DELIVERY_INFO_CBOR("application/vnd.3gpp.seal-data-delivery-info+cbor"),
	/** MIME 类型：application/vnd.3gpp.seal-data-delivery-info+xml */
	APPLICATION_VND_3GPP_SEAL_DATA_DELIVERY_INFO_XML("application/vnd.3gpp.seal-data-delivery-info+xml"),
	/** MIME 类型：application/vnd.3gpp.seal-group-doc+xml */
	APPLICATION_VND_3GPP_SEAL_GROUP_DOC_XML("application/vnd.3gpp.seal-group-doc+xml"),
	/** MIME 类型：application/vnd.3gpp.seal-info+xml */
	APPLICATION_VND_3GPP_SEAL_INFO_XML("application/vnd.3gpp.seal-info+xml"),
	/** MIME 类型：application/vnd.3gpp.seal-location-info+cbor */
	APPLICATION_VND_3GPP_SEAL_LOCATION_INFO_CBOR("application/vnd.3gpp.seal-location-info+cbor"),
	/** MIME 类型：application/vnd.3gpp.seal-location-info+xml */
	APPLICATION_VND_3GPP_SEAL_LOCATION_INFO_XML("application/vnd.3gpp.seal-location-info+xml"),
	/** MIME 类型：application/vnd.3gpp.seal-mbms-usage-info+xml */
	APPLICATION_VND_3GPP_SEAL_MBMS_USAGE_INFO_XML("application/vnd.3gpp.seal-mbms-usage-info+xml"),
	/** MIME 类型：application/vnd.3gpp.seal-mbs-usage-info+xml */
	APPLICATION_VND_3GPP_SEAL_MBS_USAGE_INFO_XML("application/vnd.3gpp.seal-mbs-usage-info+xml"),
	/** MIME 类型：application/vnd.3gpp.seal-network-QoS-management-info+xml */
	APPLICATION_VND_3GPP_SEAL_NETWORK_QOS_MANAGEMENT_INFO_XML("application/vnd.3gpp.seal-network-QoS-management-info+xml"),
	/** MIME 类型：application/vnd.3gpp.seal-network-resource-info+cbor */
	APPLICATION_VND_3GPP_SEAL_NETWORK_RESOURCE_INFO_CBOR("application/vnd.3gpp.seal-network-resource-info+cbor"),
	/** MIME 类型：application/vnd.3gpp.seal-ue-config-info+xml */
	APPLICATION_VND_3GPP_SEAL_UE_CONFIG_INFO_XML("application/vnd.3gpp.seal-ue-config-info+xml"),
	/** MIME 类型：application/vnd.3gpp.seal-unicast-info+xml */
	APPLICATION_VND_3GPP_SEAL_UNICAST_INFO_XML("application/vnd.3gpp.seal-unicast-info+xml"),
	/** MIME 类型：application/vnd.3gpp.seal-user-profile-info+xml */
	APPLICATION_VND_3GPP_SEAL_USER_PROFILE_INFO_XML("application/vnd.3gpp.seal-user-profile-info+xml"),
	/** MIME 类型：application/vnd.3gpp.sms */
	APPLICATION_VND_3GPP_SMS("application/vnd.3gpp.sms"),
	/** MIME 类型：application/vnd.3gpp.sms+xml */
	APPLICATION_VND_3GPP_SMS_XML("application/vnd.3gpp.sms+xml"),
	/** MIME 类型：application/vnd.3gpp.srvcc-ext+xml */
	APPLICATION_VND_3GPP_SRVCC_EXT_XML("application/vnd.3gpp.srvcc-ext+xml"),
	/** MIME 类型：application/vnd.3gpp.SRVCC-info+xml */
	APPLICATION_VND_3GPP_SRVCC_INFO_XML("application/vnd.3gpp.SRVCC-info+xml"),
	/** MIME 类型：application/vnd.3gpp.state-and-event-info+xml */
	APPLICATION_VND_3GPP_STATE_AND_EVENT_INFO_XML("application/vnd.3gpp.state-and-event-info+xml"),
	/** MIME 类型：application/vnd.3gpp.ussd+xml */
	APPLICATION_VND_3GPP_USSD_XML("application/vnd.3gpp.ussd+xml"),
	/** MIME 类型：application/vnd.3gpp.vae-info+xml */
	APPLICATION_VND_3GPP_VAE_INFO_XML("application/vnd.3gpp.vae-info+xml"),
	/** MIME 类型：application/vnd.3gpp-v2x-local-service-information */
	APPLICATION_VND_3GPP_V2X_LOCAL_SERVICE_INFORMATION("application/vnd.3gpp-v2x-local-service-information"),
	/** MIME 类型：application/vnd.3gpp2.bcmcsinfo+xml */
	APPLICATION_VND_3GPP2_BCMCSINFO_XML("application/vnd.3gpp2.bcmcsinfo+xml"),
	/** MIME 类型：application/vnd.3gpp2.sms */
	APPLICATION_VND_3GPP2_SMS("application/vnd.3gpp2.sms"),
	/** MIME 类型：application/vnd.3gpp2.tcap */
	APPLICATION_VND_3GPP2_TCAP("application/vnd.3gpp2.tcap"),
	/** MIME 类型：application/vnd.3gpp.v2x */
	APPLICATION_VND_3GPP_V2X("application/vnd.3gpp.v2x"),
	/** MIME 类型：application/vnd.3lightssoftware.imagescal */
	APPLICATION_VND_3LIGHTSSOFTWARE_IMAGESCAL("application/vnd.3lightssoftware.imagescal"),
	/** MIME 类型：application/vnd.3M.Post-it-Notes */
	APPLICATION_VND_3M_POST_IT_NOTES("application/vnd.3M.Post-it-Notes"),
	/** MIME 类型：application/vnd.accpac.simply.aso */
	APPLICATION_VND_ACCPAC_SIMPLY_ASO("application/vnd.accpac.simply.aso"),
	/** MIME 类型：application/vnd.accpac.simply.imp */
	APPLICATION_VND_ACCPAC_SIMPLY_IMP("application/vnd.accpac.simply.imp"),
	/** MIME 类型：application/vnd.acm.addressxfer+json */
	APPLICATION_VND_ACM_ADDRESSXFER_JSON("application/vnd.acm.addressxfer+json"),
	/** MIME 类型：application/vnd.acm.chatbot+json */
	APPLICATION_VND_ACM_CHATBOT_JSON("application/vnd.acm.chatbot+json"),
	/** MIME 类型：application/vnd.acucobol */
	APPLICATION_VND_ACUCOBOL("application/vnd.acucobol"),
	/** MIME 类型：application/vnd.acucorp */
	APPLICATION_VND_ACUCORP("application/vnd.acucorp"),
	/** MIME 类型：application/vnd.adobe.flash.movie */
	APPLICATION_VND_ADOBE_FLASH_MOVIE("application/vnd.adobe.flash.movie"),
	/** MIME 类型：application/vnd.adobe.formscentral.fcdt */
	APPLICATION_VND_ADOBE_FORMSCENTRAL_FCDT("application/vnd.adobe.formscentral.fcdt"),
	/** MIME 类型：application/vnd.adobe.fxp */
	APPLICATION_VND_ADOBE_FXP("application/vnd.adobe.fxp"),
	/** MIME 类型：application/vnd.adobe.partial-upload */
	APPLICATION_VND_ADOBE_PARTIAL_UPLOAD("application/vnd.adobe.partial-upload"),
	/** MIME 类型：application/vnd.adobe.xdp+xml */
	APPLICATION_VND_ADOBE_XDP_XML("application/vnd.adobe.xdp+xml"),
	/** MIME 类型：application/vnd.aether.imp */
	APPLICATION_VND_AETHER_IMP("application/vnd.aether.imp"),
	/** MIME 类型：application/vnd.afpc.afplinedata */
	APPLICATION_VND_AFPC_AFPLINEDATA("application/vnd.afpc.afplinedata"),
	/** MIME 类型：application/vnd.afpc.afplinedata-pagedef */
	APPLICATION_VND_AFPC_AFPLINEDATA_PAGEDEF("application/vnd.afpc.afplinedata-pagedef"),
	/** MIME 类型：application/vnd.afpc.cmoca-cmresource */
	APPLICATION_VND_AFPC_CMOCA_CMRESOURCE("application/vnd.afpc.cmoca-cmresource"),
	/** MIME 类型：application/vnd.afpc.foca-charset */
	APPLICATION_VND_AFPC_FOCA_CHARSET("application/vnd.afpc.foca-charset"),
	/** MIME 类型：application/vnd.afpc.foca-codedfont */
	APPLICATION_VND_AFPC_FOCA_CODEDFONT("application/vnd.afpc.foca-codedfont"),
	/** MIME 类型：application/vnd.afpc.foca-codepage */
	APPLICATION_VND_AFPC_FOCA_CODEPAGE("application/vnd.afpc.foca-codepage"),
	/** MIME 类型：application/vnd.afpc.modca */
	APPLICATION_VND_AFPC_MODCA("application/vnd.afpc.modca"),
	/** MIME 类型：application/vnd.afpc.modca-cmtable */
	APPLICATION_VND_AFPC_MODCA_CMTABLE("application/vnd.afpc.modca-cmtable"),
	/** MIME 类型：application/vnd.afpc.modca-formdef */
	APPLICATION_VND_AFPC_MODCA_FORMDEF("application/vnd.afpc.modca-formdef"),
	/** MIME 类型：application/vnd.afpc.modca-mediummap */
	APPLICATION_VND_AFPC_MODCA_MEDIUMMAP("application/vnd.afpc.modca-mediummap"),
	/** MIME 类型：application/vnd.afpc.modca-objectcontainer */
	APPLICATION_VND_AFPC_MODCA_OBJECTCONTAINER("application/vnd.afpc.modca-objectcontainer"),
	/** MIME 类型：application/vnd.afpc.modca-overlay */
	APPLICATION_VND_AFPC_MODCA_OVERLAY("application/vnd.afpc.modca-overlay"),
	/** MIME 类型：application/vnd.afpc.modca-pagesegment */
	APPLICATION_VND_AFPC_MODCA_PAGESEGMENT("application/vnd.afpc.modca-pagesegment"),
	/** MIME 类型：application/vnd.age */
	APPLICATION_VND_AGE("application/vnd.age"),
	/** MIME 类型：application/vnd.ah-barcode */
	APPLICATION_VND_AH_BARCODE("application/vnd.ah-barcode"),
	/** MIME 类型：application/vnd.ahead.space */
	APPLICATION_VND_AHEAD_SPACE("application/vnd.ahead.space"),
	/** MIME 类型：application/vnd.aia */
	APPLICATION_VND_AIA("application/vnd.aia"),
	/** MIME 类型：application/vnd.airzip.filesecure.azf */
	APPLICATION_VND_AIRZIP_FILESECURE_AZF("application/vnd.airzip.filesecure.azf"),
	/** MIME 类型：application/vnd.airzip.filesecure.azs */
	APPLICATION_VND_AIRZIP_FILESECURE_AZS("application/vnd.airzip.filesecure.azs"),
	/** MIME 类型：application/vnd.amadeus+json */
	APPLICATION_VND_AMADEUS_JSON("application/vnd.amadeus+json"),
	/** MIME 类型：application/vnd.amazon.mobi8-ebook */
	APPLICATION_VND_AMAZON_MOBI8_EBOOK("application/vnd.amazon.mobi8-ebook"),
	/** MIME 类型：application/vnd.americandynamics.acc */
	APPLICATION_VND_AMERICANDYNAMICS_ACC("application/vnd.americandynamics.acc"),
	/** MIME 类型：application/vnd.amiga.ami */
	APPLICATION_VND_AMIGA_AMI("application/vnd.amiga.ami"),
	/** MIME 类型：application/vnd.amundsen.maze+xml */
	APPLICATION_VND_AMUNDSEN_MAZE_XML("application/vnd.amundsen.maze+xml"),
	/** MIME 类型：application/vnd.android.ota */
	APPLICATION_VND_ANDROID_OTA("application/vnd.android.ota"),
	/** MIME 类型：application/vnd.anki */
	APPLICATION_VND_ANKI("application/vnd.anki"),
	/** MIME 类型：application/vnd.anser-web-certificate-issue-initiation */
	APPLICATION_VND_ANSER_WEB_CERTIFICATE_ISSUE_INITIATION("application/vnd.anser-web-certificate-issue-initiation"),
	/** MIME 类型：application/vnd.antix.game-component */
	APPLICATION_VND_ANTIX_GAME_COMPONENT("application/vnd.antix.game-component"),
	/** MIME 类型：application/vnd.apache.arrow.file */
	APPLICATION_VND_APACHE_ARROW_FILE("application/vnd.apache.arrow.file"),
	/** MIME 类型：application/vnd.apache.arrow.stream */
	APPLICATION_VND_APACHE_ARROW_STREAM("application/vnd.apache.arrow.stream"),
	/** MIME 类型：application/vnd.apache.parquet */
	APPLICATION_VND_APACHE_PARQUET("application/vnd.apache.parquet"),
	/** MIME 类型：application/vnd.apache.thrift.binary */
	APPLICATION_VND_APACHE_THRIFT_BINARY("application/vnd.apache.thrift.binary"),
	/** MIME 类型：application/vnd.apache.thrift.compact */
	APPLICATION_VND_APACHE_THRIFT_COMPACT("application/vnd.apache.thrift.compact"),
	/** MIME 类型：application/vnd.apache.thrift.json */
	APPLICATION_VND_APACHE_THRIFT_JSON("application/vnd.apache.thrift.json"),
	/** MIME 类型：application/vnd.apexlang */
	APPLICATION_VND_APEXLANG("application/vnd.apexlang"),
	/** MIME 类型：application/vnd.api+json */
	APPLICATION_VND_API_JSON("application/vnd.api+json"),
	/** MIME 类型：application/vnd.aplextor.warrp+json */
	APPLICATION_VND_APLEXTOR_WARRP_JSON("application/vnd.aplextor.warrp+json"),
	/** MIME 类型：application/vnd.apothekende.reservation+json */
	APPLICATION_VND_APOTHEKENDE_RESERVATION_JSON("application/vnd.apothekende.reservation+json"),
	/** MIME 类型：application/vnd.apple.installer+xml */
	APPLICATION_VND_APPLE_INSTALLER_XML("application/vnd.apple.installer+xml"),
	/** MIME 类型：application/vnd.apple.keynote */
	APPLICATION_VND_APPLE_KEYNOTE("application/vnd.apple.keynote"),
	/** MIME 类型：application/vnd.apple.mpegurl */
	APPLICATION_VND_APPLE_MPEGURL("application/vnd.apple.mpegurl"),
	/** MIME 类型：application/vnd.apple.numbers */
	APPLICATION_VND_APPLE_NUMBERS("application/vnd.apple.numbers"),
	/** MIME 类型：application/vnd.apple.pages */
	APPLICATION_VND_APPLE_PAGES("application/vnd.apple.pages"),
	/** MIME 类型：application/vnd.arastra.swi */
	APPLICATION_VND_ARASTRA_SWI("application/vnd.arastra.swi"),
	/** MIME 类型：application/vnd.aristanetworks.swi */
	APPLICATION_VND_ARISTANETWORKS_SWI("application/vnd.aristanetworks.swi"),
	/** MIME 类型：application/vnd.artisan+json */
	APPLICATION_VND_ARTISAN_JSON("application/vnd.artisan+json"),
	/** MIME 类型：application/vnd.artsquare */
	APPLICATION_VND_ARTSQUARE("application/vnd.artsquare"),
	/** MIME 类型：application/vnd.as207960.vas.config+jer */
	APPLICATION_VND_AS207960_VAS_CONFIG_JER("application/vnd.as207960.vas.config+jer"),
	/** MIME 类型：application/vnd.as207960.vas.config+uper */
	APPLICATION_VND_AS207960_VAS_CONFIG_UPER("application/vnd.as207960.vas.config+uper"),
	/** MIME 类型：application/vnd.as207960.vas.tap+jer */
	APPLICATION_VND_AS207960_VAS_TAP_JER("application/vnd.as207960.vas.tap+jer"),
	/** MIME 类型：application/vnd.as207960.vas.tap+uper */
	APPLICATION_VND_AS207960_VAS_TAP_UPER("application/vnd.as207960.vas.tap+uper"),
	/** MIME 类型：application/vnd.astraea-software.iota */
	APPLICATION_VND_ASTRAEA_SOFTWARE_IOTA("application/vnd.astraea-software.iota"),
	/** MIME 类型：application/vnd.audiograph */
	APPLICATION_VND_AUDIOGRAPH("application/vnd.audiograph"),
	/** MIME 类型：application/vnd.autopackage */
	APPLICATION_VND_AUTOPACKAGE("application/vnd.autopackage"),
	/** MIME 类型：application/vnd.avalon+json */
	APPLICATION_VND_AVALON_JSON("application/vnd.avalon+json"),
	/** MIME 类型：application/vnd.avistar+xml */
	APPLICATION_VND_AVISTAR_XML("application/vnd.avistar+xml"),
	/** MIME 类型：application/vnd.balsamiq.bmml+xml */
	APPLICATION_VND_BALSAMIQ_BMML_XML("application/vnd.balsamiq.bmml+xml"),
	/** MIME 类型：application/vnd.banana-accounting */
	APPLICATION_VND_BANANA_ACCOUNTING("application/vnd.banana-accounting"),
	/** MIME 类型：application/vnd.bbf.usp.error */
	APPLICATION_VND_BBF_USP_ERROR("application/vnd.bbf.usp.error"),
	/** MIME 类型：application/vnd.bbf.usp.msg */
	APPLICATION_VND_BBF_USP_MSG("application/vnd.bbf.usp.msg"),
	/** MIME 类型：application/vnd.bbf.usp.msg+json */
	APPLICATION_VND_BBF_USP_MSG_JSON("application/vnd.bbf.usp.msg+json"),
	/** MIME 类型：application/vnd.balsamiq.bmpr */
	APPLICATION_VND_BALSAMIQ_BMPR("application/vnd.balsamiq.bmpr"),
	/** MIME 类型：application/vnd.bekitzur-stech+json */
	APPLICATION_VND_BEKITZUR_STECH_JSON("application/vnd.bekitzur-stech+json"),
	/** MIME 类型：application/vnd.belightsoft.lhzd+zip */
	APPLICATION_VND_BELIGHTSOFT_LHZD_ZIP("application/vnd.belightsoft.lhzd+zip"),
	/** MIME 类型：application/vnd.belightsoft.lhzl+zip */
	APPLICATION_VND_BELIGHTSOFT_LHZL_ZIP("application/vnd.belightsoft.lhzl+zip"),
	/** MIME 类型：application/vnd.bint.med-content */
	APPLICATION_VND_BINT_MED_CONTENT("application/vnd.bint.med-content"),
	/** MIME 类型：application/vnd.biopax.rdf+xml */
	APPLICATION_VND_BIOPAX_RDF_XML("application/vnd.biopax.rdf+xml"),
	/** MIME 类型：application/vnd.blink-idb-value-wrapper */
	APPLICATION_VND_BLINK_IDB_VALUE_WRAPPER("application/vnd.blink-idb-value-wrapper"),
	/** MIME 类型：application/vnd.blueice.multipass */
	APPLICATION_VND_BLUEICE_MULTIPASS("application/vnd.blueice.multipass"),
	/** MIME 类型：application/vnd.bluetooth.ep.oob */
	APPLICATION_VND_BLUETOOTH_EP_OOB("application/vnd.bluetooth.ep.oob"),
	/** MIME 类型：application/vnd.bluetooth.le.oob */
	APPLICATION_VND_BLUETOOTH_LE_OOB("application/vnd.bluetooth.le.oob"),
	/** MIME 类型：application/vnd.bmi */
	APPLICATION_VND_BMI("application/vnd.bmi"),
	/** MIME 类型：application/vnd.bpf */
	APPLICATION_VND_BPF("application/vnd.bpf"),
	/** MIME 类型：application/vnd.bpf3 */
	APPLICATION_VND_BPF3("application/vnd.bpf3"),
	/** MIME 类型：application/vnd.businessobjects */
	APPLICATION_VND_BUSINESSOBJECTS("application/vnd.businessobjects"),
	/** MIME 类型：application/vnd.byu.uapi+json */
	APPLICATION_VND_BYU_UAPI_JSON("application/vnd.byu.uapi+json"),
	/** MIME 类型：application/vnd.bzip3 */
	APPLICATION_VND_BZIP3("application/vnd.bzip3"),
	/** MIME 类型：application/vnd.c3voc.schedule+xml */
	APPLICATION_VND_C3VOC_SCHEDULE_XML("application/vnd.c3voc.schedule+xml"),
	/** MIME 类型：application/vnd.cab-jscript */
	APPLICATION_VND_CAB_JSCRIPT("application/vnd.cab-jscript"),
	/** MIME 类型：application/vnd.canon-cpdl */
	APPLICATION_VND_CANON_CPDL("application/vnd.canon-cpdl"),
	/** MIME 类型：application/vnd.canon-lips */
	APPLICATION_VND_CANON_LIPS("application/vnd.canon-lips"),
	/** MIME 类型：application/vnd.capasystems-pg+json */
	APPLICATION_VND_CAPASYSTEMS_PG_JSON("application/vnd.capasystems-pg+json"),
	/** MIME 类型：application/vnd.cel */
	APPLICATION_VND_CEL("application/vnd.cel"),
	/** MIME 类型：application/vnd.cendio.thinlinc.clientconf */
	APPLICATION_VND_CENDIO_THINLINC_CLIENTCONF("application/vnd.cendio.thinlinc.clientconf"),
	/** MIME 类型：application/vnd.century-systems.tcp_stream */
	APPLICATION_VND_CENTURY_SYSTEMS_TCP_STREAM("application/vnd.century-systems.tcp_stream"),
	/** MIME 类型：application/vnd.chemdraw+xml */
	APPLICATION_VND_CHEMDRAW_XML("application/vnd.chemdraw+xml"),
	/** MIME 类型：application/vnd.chess-pgn */
	APPLICATION_VND_CHESS_PGN("application/vnd.chess-pgn"),
	/** MIME 类型：application/vnd.chipnuts.karaoke-mmd */
	APPLICATION_VND_CHIPNUTS_KARAOKE_MMD("application/vnd.chipnuts.karaoke-mmd"),
	/** MIME 类型：application/vnd.ciedi */
	APPLICATION_VND_CIEDI("application/vnd.ciedi"),
	/** MIME 类型：application/vnd.cinderella */
	APPLICATION_VND_CINDERELLA("application/vnd.cinderella"),
	/** MIME 类型：application/vnd.cirpack.isdn-ext */
	APPLICATION_VND_CIRPACK_ISDN_EXT("application/vnd.cirpack.isdn-ext"),
	/** MIME 类型：application/vnd.citationstyles.style+xml */
	APPLICATION_VND_CITATIONSTYLES_STYLE_XML("application/vnd.citationstyles.style+xml"),
	/** MIME 类型：application/vnd.claymore */
	APPLICATION_VND_CLAYMORE("application/vnd.claymore"),
	/** MIME 类型：application/vnd.cloanto.rp9 */
	APPLICATION_VND_CLOANTO_RP9("application/vnd.cloanto.rp9"),
	/** MIME 类型：application/vnd.clonk.c4group */
	APPLICATION_VND_CLONK_C4GROUP("application/vnd.clonk.c4group"),
	/** MIME 类型：application/vnd.cluetrust.cartomobile-config */
	APPLICATION_VND_CLUETRUST_CARTOMOBILE_CONFIG("application/vnd.cluetrust.cartomobile-config"),
	/** MIME 类型：application/vnd.cluetrust.cartomobile-config-pkg */
	APPLICATION_VND_CLUETRUST_CARTOMOBILE_CONFIG_PKG("application/vnd.cluetrust.cartomobile-config-pkg"),
	/** MIME 类型：application/vnd.cncf.helm.chart.content.v1.tar+gzip */
	APPLICATION_VND_CNCF_HELM_CHART_CONTENT_V1_TAR_GZIP("application/vnd.cncf.helm.chart.content.v1.tar+gzip"),
	/** MIME 类型：application/vnd.cncf.helm.chart.provenance.v1.prov */
	APPLICATION_VND_CNCF_HELM_CHART_PROVENANCE_V1_PROV("application/vnd.cncf.helm.chart.provenance.v1.prov"),
	/** MIME 类型：application/vnd.cncf.helm.config.v1+json */
	APPLICATION_VND_CNCF_HELM_CONFIG_V1_JSON("application/vnd.cncf.helm.config.v1+json"),
	/** MIME 类型：application/vnd.coffeescript */
	APPLICATION_VND_COFFEESCRIPT("application/vnd.coffeescript"),
	/** MIME 类型：application/vnd.collabio.xodocuments.document */
	APPLICATION_VND_COLLABIO_XODOCUMENTS_DOCUMENT("application/vnd.collabio.xodocuments.document"),
	/** MIME 类型：application/vnd.collabio.xodocuments.document-template */
	APPLICATION_VND_COLLABIO_XODOCUMENTS_DOCUMENT_TEMPLATE("application/vnd.collabio.xodocuments.document-template"),
	/** MIME 类型：application/vnd.collabio.xodocuments.presentation */
	APPLICATION_VND_COLLABIO_XODOCUMENTS_PRESENTATION("application/vnd.collabio.xodocuments.presentation"),
	/** MIME 类型：application/vnd.collabio.xodocuments.presentation-template */
	APPLICATION_VND_COLLABIO_XODOCUMENTS_PRESENTATION_TEMPLATE("application/vnd.collabio.xodocuments.presentation-template"),
	/** MIME 类型：application/vnd.collabio.xodocuments.spreadsheet */
	APPLICATION_VND_COLLABIO_XODOCUMENTS_SPREADSHEET("application/vnd.collabio.xodocuments.spreadsheet"),
	/** MIME 类型：application/vnd.collabio.xodocuments.spreadsheet-template */
	APPLICATION_VND_COLLABIO_XODOCUMENTS_SPREADSHEET_TEMPLATE("application/vnd.collabio.xodocuments.spreadsheet-template"),
	/** MIME 类型：application/vnd.collection.doc+json */
	APPLICATION_VND_COLLECTION_DOC_JSON("application/vnd.collection.doc+json"),
	/** MIME 类型：application/vnd.collection+json */
	APPLICATION_VND_COLLECTION_JSON("application/vnd.collection+json"),
	/** MIME 类型：application/vnd.collection.next+json */
	APPLICATION_VND_COLLECTION_NEXT_JSON("application/vnd.collection.next+json"),
	/** MIME 类型：application/vnd.comicbook-rar */
	APPLICATION_VND_COMICBOOK_RAR("application/vnd.comicbook-rar"),
	/** MIME 类型：application/vnd.comicbook+zip */
	APPLICATION_VND_COMICBOOK_ZIP("application/vnd.comicbook+zip"),
	/** MIME 类型：application/vnd.commerce-battelle */
	APPLICATION_VND_COMMERCE_BATTELLE("application/vnd.commerce-battelle"),
	/** MIME 类型：application/vnd.commonspace */
	APPLICATION_VND_COMMONSPACE("application/vnd.commonspace"),
	/** MIME 类型：application/vnd.coreos.ignition+json */
	APPLICATION_VND_COREOS_IGNITION_JSON("application/vnd.coreos.ignition+json"),
	/** MIME 类型：application/vnd.cosmocaller */
	APPLICATION_VND_COSMOCALLER("application/vnd.cosmocaller"),
	/** MIME 类型：application/vnd.contact.cmsg */
	APPLICATION_VND_CONTACT_CMSG("application/vnd.contact.cmsg"),
	/** MIME 类型：application/vnd.crick.clicker */
	APPLICATION_VND_CRICK_CLICKER("application/vnd.crick.clicker"),
	/** MIME 类型：application/vnd.crick.clicker.keyboard */
	APPLICATION_VND_CRICK_CLICKER_KEYBOARD("application/vnd.crick.clicker.keyboard"),
	/** MIME 类型：application/vnd.crick.clicker.palette */
	APPLICATION_VND_CRICK_CLICKER_PALETTE("application/vnd.crick.clicker.palette"),
	/** MIME 类型：application/vnd.crick.clicker.template */
	APPLICATION_VND_CRICK_CLICKER_TEMPLATE("application/vnd.crick.clicker.template"),
	/** MIME 类型：application/vnd.crick.clicker.wordbank */
	APPLICATION_VND_CRICK_CLICKER_WORDBANK("application/vnd.crick.clicker.wordbank"),
	/** MIME 类型：application/vnd.criticaltools.wbs+xml */
	APPLICATION_VND_CRITICALTOOLS_WBS_XML("application/vnd.criticaltools.wbs+xml"),
	/** MIME 类型：application/vnd.cryptii.pipe+json */
	APPLICATION_VND_CRYPTII_PIPE_JSON("application/vnd.cryptii.pipe+json"),
	/** MIME 类型：application/vnd.crypto-shade-file */
	APPLICATION_VND_CRYPTO_SHADE_FILE("application/vnd.crypto-shade-file"),
	/** MIME 类型：application/vnd.cryptomator.encrypted */
	APPLICATION_VND_CRYPTOMATOR_ENCRYPTED("application/vnd.cryptomator.encrypted"),
	/** MIME 类型：application/vnd.cryptomator.vault */
	APPLICATION_VND_CRYPTOMATOR_VAULT("application/vnd.cryptomator.vault"),
	/** MIME 类型：application/vnd.ctc-posml */
	APPLICATION_VND_CTC_POSML("application/vnd.ctc-posml"),
	/** MIME 类型：application/vnd.ctct.ws+xml */
	APPLICATION_VND_CTCT_WS_XML("application/vnd.ctct.ws+xml"),
	/** MIME 类型：application/vnd.cups-pdf */
	APPLICATION_VND_CUPS_PDF("application/vnd.cups-pdf"),
	/** MIME 类型：application/vnd.cups-postscript */
	APPLICATION_VND_CUPS_POSTSCRIPT("application/vnd.cups-postscript"),
	/** MIME 类型：application/vnd.cups-ppd */
	APPLICATION_VND_CUPS_PPD("application/vnd.cups-ppd"),
	/** MIME 类型：application/vnd.cups-raster */
	APPLICATION_VND_CUPS_RASTER("application/vnd.cups-raster"),
	/** MIME 类型：application/vnd.cups-raw */
	APPLICATION_VND_CUPS_RAW("application/vnd.cups-raw"),
	/** MIME 类型：application/vnd.curl */
	APPLICATION_VND_CURL("application/vnd.curl"),
	/** MIME 类型：application/vnd.cyan.dean.root+xml */
	APPLICATION_VND_CYAN_DEAN_ROOT_XML("application/vnd.cyan.dean.root+xml"),
	/** MIME 类型：application/vnd.cybank */
	APPLICATION_VND_CYBANK("application/vnd.cybank"),
	/** MIME 类型：application/vnd.cyclonedx+json */
	APPLICATION_VND_CYCLONEDX_JSON("application/vnd.cyclonedx+json"),
	/** MIME 类型：application/vnd.cyclonedx+xml */
	APPLICATION_VND_CYCLONEDX_XML("application/vnd.cyclonedx+xml"),
	/** MIME 类型：application/vnd.d2l.coursepackage1p0+zip */
	APPLICATION_VND_D2L_COURSEPACKAGE1P0_ZIP("application/vnd.d2l.coursepackage1p0+zip"),
	/** MIME 类型：application/vnd.d3m-dataset */
	APPLICATION_VND_D3M_DATASET("application/vnd.d3m-dataset"),
	/** MIME 类型：application/vnd.d3m-problem */
	APPLICATION_VND_D3M_PROBLEM("application/vnd.d3m-problem"),
	/** MIME 类型：application/vnd.dart */
	APPLICATION_VND_DART("application/vnd.dart"),
	/** MIME 类型：application/vnd.data-vision.rdz */
	APPLICATION_VND_DATA_VISION_RDZ("application/vnd.data-vision.rdz"),
	/** MIME 类型：application/vnd.datalog */
	APPLICATION_VND_DATALOG("application/vnd.datalog"),
	/** MIME 类型：application/vnd.datapackage+json */
	APPLICATION_VND_DATAPACKAGE_JSON("application/vnd.datapackage+json"),
	/** MIME 类型：application/vnd.dataresource+json */
	APPLICATION_VND_DATARESOURCE_JSON("application/vnd.dataresource+json"),
	/** MIME 类型：application/vnd.dbf */
	APPLICATION_VND_DBF("application/vnd.dbf"),
	/** MIME 类型：application/vnd.dcmp+xml */
	APPLICATION_VND_DCMP_XML("application/vnd.dcmp+xml"),
	/** MIME 类型：application/vnd.debian.binary-package */
	APPLICATION_VND_DEBIAN_BINARY_PACKAGE("application/vnd.debian.binary-package"),
	/** MIME 类型：application/vnd.dece.data */
	APPLICATION_VND_DECE_DATA("application/vnd.dece.data"),
	/** MIME 类型：application/vnd.dece.ttml+xml */
	APPLICATION_VND_DECE_TTML_XML("application/vnd.dece.ttml+xml"),
	/** MIME 类型：application/vnd.dece.unspecified */
	APPLICATION_VND_DECE_UNSPECIFIED("application/vnd.dece.unspecified"),
	/** MIME 类型：application/vnd.dece.zip */
	APPLICATION_VND_DECE_ZIP("application/vnd.dece.zip"),
	/** MIME 类型：application/vnd.denovo.fcselayout-link */
	APPLICATION_VND_DENOVO_FCSELAYOUT_LINK("application/vnd.denovo.fcselayout-link"),
	/** MIME 类型：application/vnd.desmume.movie */
	APPLICATION_VND_DESMUME_MOVIE("application/vnd.desmume.movie"),
	/** MIME 类型：application/vnd.dir-bi.plate-dl-nosuffix */
	APPLICATION_VND_DIR_BI_PLATE_DL_NOSUFFIX("application/vnd.dir-bi.plate-dl-nosuffix"),
	/** MIME 类型：application/vnd.dm.delegation+xml */
	APPLICATION_VND_DM_DELEGATION_XML("application/vnd.dm.delegation+xml"),
	/** MIME 类型：application/vnd.dna */
	APPLICATION_VND_DNA("application/vnd.dna"),
	/** MIME 类型：application/vnd.document+json */
	APPLICATION_VND_DOCUMENT_JSON("application/vnd.document+json"),
	/** MIME 类型：application/vnd.dolby.mobile.1 */
	APPLICATION_VND_DOLBY_MOBILE_1("application/vnd.dolby.mobile.1"),
	/** MIME 类型：application/vnd.dolby.mobile.2 */
	APPLICATION_VND_DOLBY_MOBILE_2("application/vnd.dolby.mobile.2"),
	/** MIME 类型：application/vnd.doremir.scorecloud-binary-document */
	APPLICATION_VND_DOREMIR_SCORECLOUD_BINARY_DOCUMENT("application/vnd.doremir.scorecloud-binary-document"),
	/** MIME 类型：application/vnd.dpgraph */
	APPLICATION_VND_DPGRAPH("application/vnd.dpgraph"),
	/** MIME 类型：application/vnd.dreamfactory */
	APPLICATION_VND_DREAMFACTORY("application/vnd.dreamfactory"),
	/** MIME 类型：application/vnd.drive+json */
	APPLICATION_VND_DRIVE_JSON("application/vnd.drive+json"),
	/** MIME 类型：application/vnd.dtg.local */
	APPLICATION_VND_DTG_LOCAL("application/vnd.dtg.local"),
	/** MIME 类型：application/vnd.dtg.local.flash */
	APPLICATION_VND_DTG_LOCAL_FLASH("application/vnd.dtg.local.flash"),
	/** MIME 类型：application/vnd.dtg.local.html */
	APPLICATION_VND_DTG_LOCAL_HTML("application/vnd.dtg.local.html"),
	/** MIME 类型：application/vnd.dvb.ait */
	APPLICATION_VND_DVB_AIT("application/vnd.dvb.ait"),
	/** MIME 类型：application/vnd.dvb.dvbisl+xml */
	APPLICATION_VND_DVB_DVBISL_XML("application/vnd.dvb.dvbisl+xml"),
	/** MIME 类型：application/vnd.dvb.dvbj */
	APPLICATION_VND_DVB_DVBJ("application/vnd.dvb.dvbj"),
	/** MIME 类型：application/vnd.dvb.esgcontainer */
	APPLICATION_VND_DVB_ESGCONTAINER("application/vnd.dvb.esgcontainer"),
	/** MIME 类型：application/vnd.dvb.ipdcdftnotifaccess */
	APPLICATION_VND_DVB_IPDCDFTNOTIFACCESS("application/vnd.dvb.ipdcdftnotifaccess"),
	/** MIME 类型：application/vnd.dvb.ipdcesgaccess */
	APPLICATION_VND_DVB_IPDCESGACCESS("application/vnd.dvb.ipdcesgaccess"),
	/** MIME 类型：application/vnd.dvb.ipdcesgaccess2 */
	APPLICATION_VND_DVB_IPDCESGACCESS2("application/vnd.dvb.ipdcesgaccess2"),
	/** MIME 类型：application/vnd.dvb.ipdcesgpdd */
	APPLICATION_VND_DVB_IPDCESGPDD("application/vnd.dvb.ipdcesgpdd"),
	/** MIME 类型：application/vnd.dvb.ipdcroaming */
	APPLICATION_VND_DVB_IPDCROAMING("application/vnd.dvb.ipdcroaming"),
	/** MIME 类型：application/vnd.dvb.iptv.alfec-base */
	APPLICATION_VND_DVB_IPTV_ALFEC_BASE("application/vnd.dvb.iptv.alfec-base"),
	/** MIME 类型：application/vnd.dvb.iptv.alfec-enhancement */
	APPLICATION_VND_DVB_IPTV_ALFEC_ENHANCEMENT("application/vnd.dvb.iptv.alfec-enhancement"),
	/** MIME 类型：application/vnd.dvb.notif-aggregate-root+xml */
	APPLICATION_VND_DVB_NOTIF_AGGREGATE_ROOT_XML("application/vnd.dvb.notif-aggregate-root+xml"),
	/** MIME 类型：application/vnd.dvb.notif-container+xml */
	APPLICATION_VND_DVB_NOTIF_CONTAINER_XML("application/vnd.dvb.notif-container+xml"),
	/** MIME 类型：application/vnd.dvb.notif-generic+xml */
	APPLICATION_VND_DVB_NOTIF_GENERIC_XML("application/vnd.dvb.notif-generic+xml"),
	/** MIME 类型：application/vnd.dvb.notif-ia-msglist+xml */
	APPLICATION_VND_DVB_NOTIF_IA_MSGLIST_XML("application/vnd.dvb.notif-ia-msglist+xml"),
	/** MIME 类型：application/vnd.dvb.notif-ia-registration-request+xml */
	APPLICATION_VND_DVB_NOTIF_IA_REGISTRATION_REQUEST_XML("application/vnd.dvb.notif-ia-registration-request+xml"),
	/** MIME 类型：application/vnd.dvb.notif-ia-registration-response+xml */
	APPLICATION_VND_DVB_NOTIF_IA_REGISTRATION_RESPONSE_XML("application/vnd.dvb.notif-ia-registration-response+xml"),
	/** MIME 类型：application/vnd.dvb.notif-init+xml */
	APPLICATION_VND_DVB_NOTIF_INIT_XML("application/vnd.dvb.notif-init+xml"),
	/** MIME 类型：application/vnd.dvb.pfr */
	APPLICATION_VND_DVB_PFR("application/vnd.dvb.pfr"),
	/** MIME 类型：application/vnd.dvb.service */
	APPLICATION_VND_DVB_SERVICE("application/vnd.dvb.service"),
	/** MIME 类型：application/vnd.dxr */
	APPLICATION_VND_DXR("application/vnd.dxr"),
	/** MIME 类型：application/vnd.dynageo */
	APPLICATION_VND_DYNAGEO("application/vnd.dynageo"),
	/** MIME 类型：application/vnd.dzr */
	APPLICATION_VND_DZR("application/vnd.dzr"),
	/** MIME 类型：application/vnd.easykaraoke.cdgdownload */
	APPLICATION_VND_EASYKARAOKE_CDGDOWNLOAD("application/vnd.easykaraoke.cdgdownload"),
	/** MIME 类型：application/vnd.ecip.rlp */
	APPLICATION_VND_ECIP_RLP("application/vnd.ecip.rlp"),
	/** MIME 类型：application/vnd.ecdis-update */
	APPLICATION_VND_ECDIS_UPDATE("application/vnd.ecdis-update"),
	/** MIME 类型：application/vnd.eclipse.ditto+json */
	APPLICATION_VND_ECLIPSE_DITTO_JSON("application/vnd.eclipse.ditto+json"),
	/** MIME 类型：application/vnd.ecowin.chart */
	APPLICATION_VND_ECOWIN_CHART("application/vnd.ecowin.chart"),
	/** MIME 类型：application/vnd.ecowin.filerequest */
	APPLICATION_VND_ECOWIN_FILEREQUEST("application/vnd.ecowin.filerequest"),
	/** MIME 类型：application/vnd.ecowin.fileupdate */
	APPLICATION_VND_ECOWIN_FILEUPDATE("application/vnd.ecowin.fileupdate"),
	/** MIME 类型：application/vnd.ecowin.series */
	APPLICATION_VND_ECOWIN_SERIES("application/vnd.ecowin.series"),
	/** MIME 类型：application/vnd.ecowin.seriesrequest */
	APPLICATION_VND_ECOWIN_SERIESREQUEST("application/vnd.ecowin.seriesrequest"),
	/** MIME 类型：application/vnd.ecowin.seriesupdate */
	APPLICATION_VND_ECOWIN_SERIESUPDATE("application/vnd.ecowin.seriesupdate"),
	/** MIME 类型：application/vnd.efi.img */
	APPLICATION_VND_EFI_IMG("application/vnd.efi.img"),
	/** MIME 类型：application/vnd.efi.iso */
	APPLICATION_VND_EFI_ISO("application/vnd.efi.iso"),
	/** MIME 类型：application/vnd.eln+zip */
	APPLICATION_VND_ELN_ZIP("application/vnd.eln+zip"),
	/** MIME 类型：application/vnd.emclient.accessrequest+xml */
	APPLICATION_VND_EMCLIENT_ACCESSREQUEST_XML("application/vnd.emclient.accessrequest+xml"),
	/** MIME 类型：application/vnd.enliven */
	APPLICATION_VND_ENLIVEN("application/vnd.enliven"),
	/** MIME 类型：application/vnd.enphase.envoy */
	APPLICATION_VND_ENPHASE_ENVOY("application/vnd.enphase.envoy"),
	/** MIME 类型：application/vnd.eprints.data+xml */
	APPLICATION_VND_EPRINTS_DATA_XML("application/vnd.eprints.data+xml"),
	/** MIME 类型：application/vnd.epson.esf */
	APPLICATION_VND_EPSON_ESF("application/vnd.epson.esf"),
	/** MIME 类型：application/vnd.epson.msf */
	APPLICATION_VND_EPSON_MSF("application/vnd.epson.msf"),
	/** MIME 类型：application/vnd.epson.quickanime */
	APPLICATION_VND_EPSON_QUICKANIME("application/vnd.epson.quickanime"),
	/** MIME 类型：application/vnd.epson.salt */
	APPLICATION_VND_EPSON_SALT("application/vnd.epson.salt"),
	/** MIME 类型：application/vnd.epson.ssf */
	APPLICATION_VND_EPSON_SSF("application/vnd.epson.ssf"),
	/** MIME 类型：application/vnd.ericsson.quickcall */
	APPLICATION_VND_ERICSSON_QUICKCALL("application/vnd.ericsson.quickcall"),
	/** MIME 类型：application/vnd.erofs */
	APPLICATION_VND_EROFS("application/vnd.erofs"),
	/** MIME 类型：application/vnd.espass-espass+zip */
	APPLICATION_VND_ESPASS_ESPASS_ZIP("application/vnd.espass-espass+zip"),
	/** MIME 类型：application/vnd.eszigno3+xml */
	APPLICATION_VND_ESZIGNO3_XML("application/vnd.eszigno3+xml"),
	/** MIME 类型：application/vnd.etsi.aoc+xml */
	APPLICATION_VND_ETSI_AOC_XML("application/vnd.etsi.aoc+xml"),
	/** MIME 类型：application/vnd.etsi.asic-s+zip */
	APPLICATION_VND_ETSI_ASIC_S_ZIP("application/vnd.etsi.asic-s+zip"),
	/** MIME 类型：application/vnd.etsi.asic-e+zip */
	APPLICATION_VND_ETSI_ASIC_E_ZIP("application/vnd.etsi.asic-e+zip"),
	/** MIME 类型：application/vnd.etsi.cug+xml */
	APPLICATION_VND_ETSI_CUG_XML("application/vnd.etsi.cug+xml"),
	/** MIME 类型：application/vnd.etsi.iptvcommand+xml */
	APPLICATION_VND_ETSI_IPTVCOMMAND_XML("application/vnd.etsi.iptvcommand+xml"),
	/** MIME 类型：application/vnd.etsi.iptvdiscovery+xml */
	APPLICATION_VND_ETSI_IPTVDISCOVERY_XML("application/vnd.etsi.iptvdiscovery+xml"),
	/** MIME 类型：application/vnd.etsi.iptvprofile+xml */
	APPLICATION_VND_ETSI_IPTVPROFILE_XML("application/vnd.etsi.iptvprofile+xml"),
	/** MIME 类型：application/vnd.etsi.iptvsad-bc+xml */
	APPLICATION_VND_ETSI_IPTVSAD_BC_XML("application/vnd.etsi.iptvsad-bc+xml"),
	/** MIME 类型：application/vnd.etsi.iptvsad-cod+xml */
	APPLICATION_VND_ETSI_IPTVSAD_COD_XML("application/vnd.etsi.iptvsad-cod+xml"),
	/** MIME 类型：application/vnd.etsi.iptvsad-npvr+xml */
	APPLICATION_VND_ETSI_IPTVSAD_NPVR_XML("application/vnd.etsi.iptvsad-npvr+xml"),
	/** MIME 类型：application/vnd.etsi.iptvservice+xml */
	APPLICATION_VND_ETSI_IPTVSERVICE_XML("application/vnd.etsi.iptvservice+xml"),
	/** MIME 类型：application/vnd.etsi.iptvsync+xml */
	APPLICATION_VND_ETSI_IPTVSYNC_XML("application/vnd.etsi.iptvsync+xml"),
	/** MIME 类型：application/vnd.etsi.iptvueprofile+xml */
	APPLICATION_VND_ETSI_IPTVUEPROFILE_XML("application/vnd.etsi.iptvueprofile+xml"),
	/** MIME 类型：application/vnd.etsi.mcid+xml */
	APPLICATION_VND_ETSI_MCID_XML("application/vnd.etsi.mcid+xml"),
	/** MIME 类型：application/vnd.etsi.mheg5 */
	APPLICATION_VND_ETSI_MHEG5("application/vnd.etsi.mheg5"),
	/** MIME 类型：application/vnd.etsi.overload-control-policy-dataset+xml */
	APPLICATION_VND_ETSI_OVERLOAD_CONTROL_POLICY_DATASET_XML("application/vnd.etsi.overload-control-policy-dataset+xml"),
	/** MIME 类型：application/vnd.etsi.pstn+xml */
	APPLICATION_VND_ETSI_PSTN_XML("application/vnd.etsi.pstn+xml"),
	/** MIME 类型：application/vnd.etsi.sci+xml */
	APPLICATION_VND_ETSI_SCI_XML("application/vnd.etsi.sci+xml"),
	/** MIME 类型：application/vnd.etsi.simservs+xml */
	APPLICATION_VND_ETSI_SIMSERVS_XML("application/vnd.etsi.simservs+xml"),
	/** MIME 类型：application/vnd.etsi.timestamp-token */
	APPLICATION_VND_ETSI_TIMESTAMP_TOKEN("application/vnd.etsi.timestamp-token"),
	/** MIME 类型：application/vnd.etsi.tsl+xml */
	APPLICATION_VND_ETSI_TSL_XML("application/vnd.etsi.tsl+xml"),
	/** MIME 类型：application/vnd.etsi.tsl.der */
	APPLICATION_VND_ETSI_TSL_DER("application/vnd.etsi.tsl.der"),
	/** MIME 类型：application/vnd.eu.kasparian.car+json */
	APPLICATION_VND_EU_KASPARIAN_CAR_JSON("application/vnd.eu.kasparian.car+json"),
	/** MIME 类型：application/vnd.eudora.data */
	APPLICATION_VND_EUDORA_DATA("application/vnd.eudora.data"),
	/** MIME 类型：application/vnd.evolv.ecig.profile */
	APPLICATION_VND_EVOLV_ECIG_PROFILE("application/vnd.evolv.ecig.profile"),
	/** MIME 类型：application/vnd.evolv.ecig.settings */
	APPLICATION_VND_EVOLV_ECIG_SETTINGS("application/vnd.evolv.ecig.settings"),
	/** MIME 类型：application/vnd.evolv.ecig.theme */
	APPLICATION_VND_EVOLV_ECIG_THEME("application/vnd.evolv.ecig.theme"),
	/** MIME 类型：application/vnd.exstream-empower+zip */
	APPLICATION_VND_EXSTREAM_EMPOWER_ZIP("application/vnd.exstream-empower+zip"),
	/** MIME 类型：application/vnd.exstream-package */
	APPLICATION_VND_EXSTREAM_PACKAGE("application/vnd.exstream-package"),
	/** MIME 类型：application/vnd.ezpix-album */
	APPLICATION_VND_EZPIX_ALBUM("application/vnd.ezpix-album"),
	/** MIME 类型：application/vnd.ezpix-package */
	APPLICATION_VND_EZPIX_PACKAGE("application/vnd.ezpix-package"),
	/** MIME 类型：application/vnd.f-secure.mobile */
	APPLICATION_VND_F_SECURE_MOBILE("application/vnd.f-secure.mobile"),
	/** MIME 类型：application/vnd.faf+yaml */
	APPLICATION_VND_FAF_YAML("application/vnd.faf+yaml"),
	/** MIME 类型：application/vnd.fastcopy-disk-image */
	APPLICATION_VND_FASTCOPY_DISK_IMAGE("application/vnd.fastcopy-disk-image"),
	/** MIME 类型：application/vnd.familysearch.gedcom+zip */
	APPLICATION_VND_FAMILYSEARCH_GEDCOM_ZIP("application/vnd.familysearch.gedcom+zip"),
	/** MIME 类型：application/vnd.fdsn.mseed */
	APPLICATION_VND_FDSN_MSEED("application/vnd.fdsn.mseed"),
	/** MIME 类型：application/vnd.fdsn.seed */
	APPLICATION_VND_FDSN_SEED("application/vnd.fdsn.seed"),
	/** MIME 类型：application/vnd.fdsn.stationxml+xml */
	APPLICATION_VND_FDSN_STATIONXML_XML("application/vnd.fdsn.stationxml+xml"),
	/** MIME 类型：application/vnd.ffsns */
	APPLICATION_VND_FFSNS("application/vnd.ffsns"),
	/** MIME 类型：application/vnd.fgb */
	APPLICATION_VND_FGB("application/vnd.fgb"),
	/** MIME 类型：application/vnd.ficlab.flb+zip */
	APPLICATION_VND_FICLAB_FLB_ZIP("application/vnd.ficlab.flb+zip"),
	/** MIME 类型：application/vnd.filmit.zfc */
	APPLICATION_VND_FILMIT_ZFC("application/vnd.filmit.zfc"),
	/** MIME 类型：application/vnd.fints */
	APPLICATION_VND_FINTS("application/vnd.fints"),
	/** MIME 类型：application/vnd.firemonkeys.cloudcell */
	APPLICATION_VND_FIREMONKEYS_CLOUDCELL("application/vnd.firemonkeys.cloudcell"),
	/** MIME 类型：application/vnd.FloGraphIt */
	APPLICATION_VND_FLOGRAPHIT("application/vnd.FloGraphIt"),
	/** MIME 类型：application/vnd.fluxtime.clip */
	APPLICATION_VND_FLUXTIME_CLIP("application/vnd.fluxtime.clip"),
	/** MIME 类型：application/vnd.font-fontforge-sfd */
	APPLICATION_VND_FONT_FONTFORGE_SFD("application/vnd.font-fontforge-sfd"),
	/** MIME 类型：application/vnd.framemaker */
	APPLICATION_VND_FRAMEMAKER("application/vnd.framemaker"),
	/** MIME 类型：application/vnd.freelog.comic */
	APPLICATION_VND_FREELOG_COMIC("application/vnd.freelog.comic"),
	/** MIME 类型：application/vnd.frogans.fnc */
	APPLICATION_VND_FROGANS_FNC("application/vnd.frogans.fnc"),
	/** MIME 类型：application/vnd.frogans.ltf */
	APPLICATION_VND_FROGANS_LTF("application/vnd.frogans.ltf"),
	/** MIME 类型：application/vnd.fsc.weblaunch */
	APPLICATION_VND_FSC_WEBLAUNCH("application/vnd.fsc.weblaunch"),
	/** MIME 类型：application/vnd.fujifilm.fb.docuworks */
	APPLICATION_VND_FUJIFILM_FB_DOCUWORKS("application/vnd.fujifilm.fb.docuworks"),
	/** MIME 类型：application/vnd.fujifilm.fb.docuworks.binder */
	APPLICATION_VND_FUJIFILM_FB_DOCUWORKS_BINDER("application/vnd.fujifilm.fb.docuworks.binder"),
	/** MIME 类型：application/vnd.fujifilm.fb.docuworks.container */
	APPLICATION_VND_FUJIFILM_FB_DOCUWORKS_CONTAINER("application/vnd.fujifilm.fb.docuworks.container"),
	/** MIME 类型：application/vnd.fujifilm.fb.jfi+xml */
	APPLICATION_VND_FUJIFILM_FB_JFI_XML("application/vnd.fujifilm.fb.jfi+xml"),
	/** MIME 类型：application/vnd.fujitsu.oasys */
	APPLICATION_VND_FUJITSU_OASYS("application/vnd.fujitsu.oasys"),
	/** MIME 类型：application/vnd.fujitsu.oasys2 */
	APPLICATION_VND_FUJITSU_OASYS2("application/vnd.fujitsu.oasys2"),
	/** MIME 类型：application/vnd.fujitsu.oasys3 */
	APPLICATION_VND_FUJITSU_OASYS3("application/vnd.fujitsu.oasys3"),
	/** MIME 类型：application/vnd.fujitsu.oasysgp */
	APPLICATION_VND_FUJITSU_OASYSGP("application/vnd.fujitsu.oasysgp"),
	/** MIME 类型：application/vnd.fujitsu.oasysprs */
	APPLICATION_VND_FUJITSU_OASYSPRS("application/vnd.fujitsu.oasysprs"),
	/** MIME 类型：application/vnd.fujixerox.ART4 */
	APPLICATION_VND_FUJIXEROX_ART4("application/vnd.fujixerox.ART4"),
	/** MIME 类型：application/vnd.fujixerox.ART-EX */
	APPLICATION_VND_FUJIXEROX_ART_EX("application/vnd.fujixerox.ART-EX"),
	/** MIME 类型：application/vnd.fujixerox.ddd */
	APPLICATION_VND_FUJIXEROX_DDD("application/vnd.fujixerox.ddd"),
	/** MIME 类型：application/vnd.fujixerox.docuworks */
	APPLICATION_VND_FUJIXEROX_DOCUWORKS("application/vnd.fujixerox.docuworks"),
	/** MIME 类型：application/vnd.fujixerox.docuworks.binder */
	APPLICATION_VND_FUJIXEROX_DOCUWORKS_BINDER("application/vnd.fujixerox.docuworks.binder"),
	/** MIME 类型：application/vnd.fujixerox.docuworks.container */
	APPLICATION_VND_FUJIXEROX_DOCUWORKS_CONTAINER("application/vnd.fujixerox.docuworks.container"),
	/** MIME 类型：application/vnd.fujixerox.HBPL */
	APPLICATION_VND_FUJIXEROX_HBPL("application/vnd.fujixerox.HBPL"),
	/** MIME 类型：application/vnd.fut-misnet */
	APPLICATION_VND_FUT_MISNET("application/vnd.fut-misnet"),
	/** MIME 类型：application/vnd.futoin+cbor */
	APPLICATION_VND_FUTOIN_CBOR("application/vnd.futoin+cbor"),
	/** MIME 类型：application/vnd.futoin+json */
	APPLICATION_VND_FUTOIN_JSON("application/vnd.futoin+json"),
	/** MIME 类型：application/vnd.fuzzysheet */
	APPLICATION_VND_FUZZYSHEET("application/vnd.fuzzysheet"),
	/** MIME 类型：application/vnd.g3pix.g3fc */
	APPLICATION_VND_G3PIX_G3FC("application/vnd.g3pix.g3fc"),
	/** MIME 类型：application/vnd.ga4gh.passport+jwt */
	APPLICATION_VND_GA4GH_PASSPORT_JWT("application/vnd.ga4gh.passport+jwt"),
	/** MIME 类型：application/vnd.genomatix.tuxedo */
	APPLICATION_VND_GENOMATIX_TUXEDO("application/vnd.genomatix.tuxedo"),
	/** MIME 类型：application/vnd.genozip */
	APPLICATION_VND_GENOZIP("application/vnd.genozip"),
	/** MIME 类型：application/vnd.gentics.grd+json */
	APPLICATION_VND_GENTICS_GRD_JSON("application/vnd.gentics.grd+json"),
	/** MIME 类型：application/vnd.gentoo.catmetadata+xml */
	APPLICATION_VND_GENTOO_CATMETADATA_XML("application/vnd.gentoo.catmetadata+xml"),
	/** MIME 类型：application/vnd.gentoo.ebuild */
	APPLICATION_VND_GENTOO_EBUILD("application/vnd.gentoo.ebuild"),
	/** MIME 类型：application/vnd.gentoo.eclass */
	APPLICATION_VND_GENTOO_ECLASS("application/vnd.gentoo.eclass"),
	/** MIME 类型：application/vnd.gentoo.gpkg */
	APPLICATION_VND_GENTOO_GPKG("application/vnd.gentoo.gpkg"),
	/** MIME 类型：application/vnd.gentoo.manifest */
	APPLICATION_VND_GENTOO_MANIFEST("application/vnd.gentoo.manifest"),
	/** MIME 类型：application/vnd.gentoo.xpak */
	APPLICATION_VND_GENTOO_XPAK("application/vnd.gentoo.xpak"),
	/** MIME 类型：application/vnd.gentoo.pkgmetadata+xml */
	APPLICATION_VND_GENTOO_PKGMETADATA_XML("application/vnd.gentoo.pkgmetadata+xml"),
	/** MIME 类型：application/vnd.geo+json */
	APPLICATION_VND_GEO_JSON("application/vnd.geo+json"),
	/** MIME 类型：application/vnd.geocube+xml */
	APPLICATION_VND_GEOCUBE_XML("application/vnd.geocube+xml"),
	/** MIME 类型：application/vnd.geogebra.file */
	APPLICATION_VND_GEOGEBRA_FILE("application/vnd.geogebra.file"),
	/** MIME 类型：application/vnd.geogebra.pinboard */
	APPLICATION_VND_GEOGEBRA_PINBOARD("application/vnd.geogebra.pinboard"),
	/** MIME 类型：application/vnd.geogebra.slides */
	APPLICATION_VND_GEOGEBRA_SLIDES("application/vnd.geogebra.slides"),
	/** MIME 类型：application/vnd.geogebra.tool */
	APPLICATION_VND_GEOGEBRA_TOOL("application/vnd.geogebra.tool"),
	/** MIME 类型：application/vnd.geometry-explorer */
	APPLICATION_VND_GEOMETRY_EXPLORER("application/vnd.geometry-explorer"),
	/** MIME 类型：application/vnd.geonext */
	APPLICATION_VND_GEONEXT("application/vnd.geonext"),
	/** MIME 类型：application/vnd.geoplan */
	APPLICATION_VND_GEOPLAN("application/vnd.geoplan"),
	/** MIME 类型：application/vnd.geospace */
	APPLICATION_VND_GEOSPACE("application/vnd.geospace"),
	/** MIME 类型：application/vnd.gerber */
	APPLICATION_VND_GERBER("application/vnd.gerber"),
	/** MIME 类型：application/vnd.globalplatform.card-content-mgt */
	APPLICATION_VND_GLOBALPLATFORM_CARD_CONTENT_MGT("application/vnd.globalplatform.card-content-mgt"),
	/** MIME 类型：application/vnd.globalplatform.card-content-mgt-response */
	APPLICATION_VND_GLOBALPLATFORM_CARD_CONTENT_MGT_RESPONSE("application/vnd.globalplatform.card-content-mgt-response"),
	/** MIME 类型：application/vnd.gmx */
	APPLICATION_VND_GMX("application/vnd.gmx"),
	/** MIME 类型：application/vnd.gnu.taler.exchange+json */
	APPLICATION_VND_GNU_TALER_EXCHANGE_JSON("application/vnd.gnu.taler.exchange+json"),
	/** MIME 类型：application/vnd.gnu.taler.merchant+json */
	APPLICATION_VND_GNU_TALER_MERCHANT_JSON("application/vnd.gnu.taler.merchant+json"),
	/** MIME 类型：application/vnd.google-earth.kml+xml */
	APPLICATION_VND_GOOGLE_EARTH_KML_XML("application/vnd.google-earth.kml+xml"),
	/** MIME 类型：application/vnd.google-earth.kmz */
	APPLICATION_VND_GOOGLE_EARTH_KMZ("application/vnd.google-earth.kmz"),
	/** MIME 类型：application/vnd.gov.sk.e-form+xml */
	APPLICATION_VND_GOV_SK_E_FORM_XML("application/vnd.gov.sk.e-form+xml"),
	/** MIME 类型：application/vnd.gov.sk.e-form+zip */
	APPLICATION_VND_GOV_SK_E_FORM_ZIP("application/vnd.gov.sk.e-form+zip"),
	/** MIME 类型：application/vnd.gov.sk.xmldatacontainer+xml */
	APPLICATION_VND_GOV_SK_XMLDATACONTAINER_XML("application/vnd.gov.sk.xmldatacontainer+xml"),
	/** MIME 类型：application/vnd.gpxsee.map+xml */
	APPLICATION_VND_GPXSEE_MAP_XML("application/vnd.gpxsee.map+xml"),
	/** MIME 类型：application/vnd.grafeq */
	APPLICATION_VND_GRAFEQ("application/vnd.grafeq"),
	/** MIME 类型：application/vnd.gridmp */
	APPLICATION_VND_GRIDMP("application/vnd.gridmp"),
	/** MIME 类型：application/vnd.groove-account */
	APPLICATION_VND_GROOVE_ACCOUNT("application/vnd.groove-account"),
	/** MIME 类型：application/vnd.groove-help */
	APPLICATION_VND_GROOVE_HELP("application/vnd.groove-help"),
	/** MIME 类型：application/vnd.groove-identity-message */
	APPLICATION_VND_GROOVE_IDENTITY_MESSAGE("application/vnd.groove-identity-message"),
	/** MIME 类型：application/vnd.groove-injector */
	APPLICATION_VND_GROOVE_INJECTOR("application/vnd.groove-injector"),
	/** MIME 类型：application/vnd.groove-tool-message */
	APPLICATION_VND_GROOVE_TOOL_MESSAGE("application/vnd.groove-tool-message"),
	/** MIME 类型：application/vnd.groove-tool-template */
	APPLICATION_VND_GROOVE_TOOL_TEMPLATE("application/vnd.groove-tool-template"),
	/** MIME 类型：application/vnd.groove-vcard */
	APPLICATION_VND_GROOVE_VCARD("application/vnd.groove-vcard"),
	/** MIME 类型：application/vnd.hal+json */
	APPLICATION_VND_HAL_JSON("application/vnd.hal+json"),
	/** MIME 类型：application/vnd.hal+xml */
	APPLICATION_VND_HAL_XML("application/vnd.hal+xml"),
	/** MIME 类型：application/vnd.HandHeld-Entertainment+xml */
	APPLICATION_VND_HANDHELD_ENTERTAINMENT_XML("application/vnd.HandHeld-Entertainment+xml"),
	/** MIME 类型：application/vnd.hbci */
	APPLICATION_VND_HBCI("application/vnd.hbci"),
	/** MIME 类型：application/vnd.hc+json */
	APPLICATION_VND_HC_JSON("application/vnd.hc+json"),
	/** MIME 类型：application/vnd.hcl-bireports */
	APPLICATION_VND_HCL_BIREPORTS("application/vnd.hcl-bireports"),
	/** MIME 类型：application/vnd.hdt */
	APPLICATION_VND_HDT("application/vnd.hdt"),
	/** MIME 类型：application/vnd.heroku+json */
	APPLICATION_VND_HEROKU_JSON("application/vnd.heroku+json"),
	/** MIME 类型：application/vnd.hhe.lesson-player */
	APPLICATION_VND_HHE_LESSON_PLAYER("application/vnd.hhe.lesson-player"),
	/** MIME 类型：application/vnd.hp-HPGL */
	APPLICATION_VND_HP_HPGL("application/vnd.hp-HPGL"),
	/** MIME 类型：application/vnd.hp-hpid */
	APPLICATION_VND_HP_HPID("application/vnd.hp-hpid"),
	/** MIME 类型：application/vnd.hp-hps */
	APPLICATION_VND_HP_HPS("application/vnd.hp-hps"),
	/** MIME 类型：application/vnd.hp-jlyt */
	APPLICATION_VND_HP_JLYT("application/vnd.hp-jlyt"),
	/** MIME 类型：application/vnd.hp-PCL */
	APPLICATION_VND_HP_PCL("application/vnd.hp-PCL"),
	/** MIME 类型：application/vnd.hp-PCLXL */
	APPLICATION_VND_HP_PCLXL("application/vnd.hp-PCLXL"),
	/** MIME 类型：application/vnd.hsl */
	APPLICATION_VND_HSL("application/vnd.hsl"),
	/** MIME 类型：application/vnd.httphone */
	APPLICATION_VND_HTTPHONE("application/vnd.httphone"),
	/** MIME 类型：application/vnd.hydrostatix.sof-data */
	APPLICATION_VND_HYDROSTATIX_SOF_DATA("application/vnd.hydrostatix.sof-data"),
	/** MIME 类型：application/vnd.hyper-item+json */
	APPLICATION_VND_HYPER_ITEM_JSON("application/vnd.hyper-item+json"),
	/** MIME 类型：application/vnd.hyper+json */
	APPLICATION_VND_HYPER_JSON("application/vnd.hyper+json"),
	/** MIME 类型：application/vnd.hyperdrive+json */
	APPLICATION_VND_HYPERDRIVE_JSON("application/vnd.hyperdrive+json"),
	/** MIME 类型：application/vnd.hzn-3d-crossword */
	APPLICATION_VND_HZN_3D_CROSSWORD("application/vnd.hzn-3d-crossword"),
	/** MIME 类型：application/vnd.ibm.afplinedata */
	APPLICATION_VND_IBM_AFPLINEDATA("application/vnd.ibm.afplinedata"),
	/** MIME 类型：application/vnd.ibm.electronic-media */
	APPLICATION_VND_IBM_ELECTRONIC_MEDIA("application/vnd.ibm.electronic-media"),
	/** MIME 类型：application/vnd.ibm.MiniPay */
	APPLICATION_VND_IBM_MINIPAY("application/vnd.ibm.MiniPay"),
	/** MIME 类型：application/vnd.ibm.modcap */
	APPLICATION_VND_IBM_MODCAP("application/vnd.ibm.modcap"),
	/** MIME 类型：application/vnd.ibm.rights-management */
	APPLICATION_VND_IBM_RIGHTS_MANAGEMENT("application/vnd.ibm.rights-management"),
	/** MIME 类型：application/vnd.ibm.secure-container */
	APPLICATION_VND_IBM_SECURE_CONTAINER("application/vnd.ibm.secure-container"),
	/** MIME 类型：application/vnd.iccprofile */
	APPLICATION_VND_ICCPROFILE("application/vnd.iccprofile"),
	/** MIME 类型：application/vnd.ieee.1905 */
	APPLICATION_VND_IEEE_1905("application/vnd.ieee.1905"),
	/** MIME 类型：application/vnd.igloader */
	APPLICATION_VND_IGLOADER("application/vnd.igloader"),
	/** MIME 类型：application/vnd.imagemeter.folder+zip */
	APPLICATION_VND_IMAGEMETER_FOLDER_ZIP("application/vnd.imagemeter.folder+zip"),
	/** MIME 类型：application/vnd.imagemeter.image+zip */
	APPLICATION_VND_IMAGEMETER_IMAGE_ZIP("application/vnd.imagemeter.image+zip"),
	/** MIME 类型：application/vnd.immervision-ivp */
	APPLICATION_VND_IMMERVISION_IVP("application/vnd.immervision-ivp"),
	/** MIME 类型：application/vnd.immervision-ivu */
	APPLICATION_VND_IMMERVISION_IVU("application/vnd.immervision-ivu"),
	/** MIME 类型：application/vnd.ims.imsccv1p1 */
	APPLICATION_VND_IMS_IMSCCV1P1("application/vnd.ims.imsccv1p1"),
	/** MIME 类型：application/vnd.ims.imsccv1p2 */
	APPLICATION_VND_IMS_IMSCCV1P2("application/vnd.ims.imsccv1p2"),
	/** MIME 类型：application/vnd.ims.imsccv1p3 */
	APPLICATION_VND_IMS_IMSCCV1P3("application/vnd.ims.imsccv1p3"),
	/** MIME 类型：application/vnd.ims.lis.v2.result+json */
	APPLICATION_VND_IMS_LIS_V2_RESULT_JSON("application/vnd.ims.lis.v2.result+json"),
	/** MIME 类型：application/vnd.ims.lti.v2.toolconsumerprofile+json */
	APPLICATION_VND_IMS_LTI_V2_TOOLCONSUMERPROFILE_JSON("application/vnd.ims.lti.v2.toolconsumerprofile+json"),
	/** MIME 类型：application/vnd.ims.lti.v2.toolproxy.id+json */
	APPLICATION_VND_IMS_LTI_V2_TOOLPROXY_ID_JSON("application/vnd.ims.lti.v2.toolproxy.id+json"),
	/** MIME 类型：application/vnd.ims.lti.v2.toolproxy+json */
	APPLICATION_VND_IMS_LTI_V2_TOOLPROXY_JSON("application/vnd.ims.lti.v2.toolproxy+json"),
	/** MIME 类型：application/vnd.ims.lti.v2.toolsettings+json */
	APPLICATION_VND_IMS_LTI_V2_TOOLSETTINGS_JSON("application/vnd.ims.lti.v2.toolsettings+json"),
	/** MIME 类型：application/vnd.ims.lti.v2.toolsettings.simple+json */
	APPLICATION_VND_IMS_LTI_V2_TOOLSETTINGS_SIMPLE_JSON("application/vnd.ims.lti.v2.toolsettings.simple+json"),
	/** MIME 类型：application/vnd.informedcontrol.rms+xml */
	APPLICATION_VND_INFORMEDCONTROL_RMS_XML("application/vnd.informedcontrol.rms+xml"),
	/** MIME 类型：application/vnd.infotech.project */
	APPLICATION_VND_INFOTECH_PROJECT("application/vnd.infotech.project"),
	/** MIME 类型：application/vnd.infotech.project+xml */
	APPLICATION_VND_INFOTECH_PROJECT_XML("application/vnd.infotech.project+xml"),
	/** MIME 类型：application/vnd.informix-visionary */
	APPLICATION_VND_INFORMIX_VISIONARY("application/vnd.informix-visionary"),
	/** MIME 类型：application/vnd.innopath.wamp.notification */
	APPLICATION_VND_INNOPATH_WAMP_NOTIFICATION("application/vnd.innopath.wamp.notification"),
	/** MIME 类型：application/vnd.insors.igm */
	APPLICATION_VND_INSORS_IGM("application/vnd.insors.igm"),
	/** MIME 类型：application/vnd.intercon.formnet */
	APPLICATION_VND_INTERCON_FORMNET("application/vnd.intercon.formnet"),
	/** MIME 类型：application/vnd.intergeo */
	APPLICATION_VND_INTERGEO("application/vnd.intergeo"),
	/** MIME 类型：application/vnd.intertrust.digibox */
	APPLICATION_VND_INTERTRUST_DIGIBOX("application/vnd.intertrust.digibox"),
	/** MIME 类型：application/vnd.intertrust.nncp */
	APPLICATION_VND_INTERTRUST_NNCP("application/vnd.intertrust.nncp"),
	/** MIME 类型：application/vnd.intu.qbo */
	APPLICATION_VND_INTU_QBO("application/vnd.intu.qbo"),
	/** MIME 类型：application/vnd.intu.qfx */
	APPLICATION_VND_INTU_QFX("application/vnd.intu.qfx"),
	/** MIME 类型：application/vnd.ipfs.ipns-record */
	APPLICATION_VND_IPFS_IPNS_RECORD("application/vnd.ipfs.ipns-record"),
	/** MIME 类型：application/vnd.ipld.car */
	APPLICATION_VND_IPLD_CAR("application/vnd.ipld.car"),
	/** MIME 类型：application/vnd.ipld.dag-cbor */
	APPLICATION_VND_IPLD_DAG_CBOR("application/vnd.ipld.dag-cbor"),
	/** MIME 类型：application/vnd.ipld.dag-json */
	APPLICATION_VND_IPLD_DAG_JSON("application/vnd.ipld.dag-json"),
	/** MIME 类型：application/vnd.ipld.raw */
	APPLICATION_VND_IPLD_RAW("application/vnd.ipld.raw"),
	/** MIME 类型：application/vnd.iptc.g2.catalogitem+xml */
	APPLICATION_VND_IPTC_G2_CATALOGITEM_XML("application/vnd.iptc.g2.catalogitem+xml"),
	/** MIME 类型：application/vnd.iptc.g2.conceptitem+xml */
	APPLICATION_VND_IPTC_G2_CONCEPTITEM_XML("application/vnd.iptc.g2.conceptitem+xml"),
	/** MIME 类型：application/vnd.iptc.g2.knowledgeitem+xml */
	APPLICATION_VND_IPTC_G2_KNOWLEDGEITEM_XML("application/vnd.iptc.g2.knowledgeitem+xml"),
	/** MIME 类型：application/vnd.iptc.g2.newsitem+xml */
	APPLICATION_VND_IPTC_G2_NEWSITEM_XML("application/vnd.iptc.g2.newsitem+xml"),
	/** MIME 类型：application/vnd.iptc.g2.newsmessage+xml */
	APPLICATION_VND_IPTC_G2_NEWSMESSAGE_XML("application/vnd.iptc.g2.newsmessage+xml"),
	/** MIME 类型：application/vnd.iptc.g2.packageitem+xml */
	APPLICATION_VND_IPTC_G2_PACKAGEITEM_XML("application/vnd.iptc.g2.packageitem+xml"),
	/** MIME 类型：application/vnd.iptc.g2.planningitem+xml */
	APPLICATION_VND_IPTC_G2_PLANNINGITEM_XML("application/vnd.iptc.g2.planningitem+xml"),
	/** MIME 类型：application/vnd.ipunplugged.rcprofile */
	APPLICATION_VND_IPUNPLUGGED_RCPROFILE("application/vnd.ipunplugged.rcprofile"),
	/** MIME 类型：application/vnd.irepository.package+xml */
	APPLICATION_VND_IREPOSITORY_PACKAGE_XML("application/vnd.irepository.package+xml"),
	/** MIME 类型：application/vnd.is-xpr */
	APPLICATION_VND_IS_XPR("application/vnd.is-xpr"),
	/** MIME 类型：application/vnd.isac.fcs */
	APPLICATION_VND_ISAC_FCS("application/vnd.isac.fcs"),
	/** MIME 类型：application/vnd.jam */
	APPLICATION_VND_JAM("application/vnd.jam"),
	/** MIME 类型：application/vnd.iso11783-10+zip */
	APPLICATION_VND_ISO11783_10_ZIP("application/vnd.iso11783-10+zip"),
	/** MIME 类型：application/vnd.japannet-directory-service */
	APPLICATION_VND_JAPANNET_DIRECTORY_SERVICE("application/vnd.japannet-directory-service"),
	/** MIME 类型：application/vnd.japannet-jpnstore-wakeup */
	APPLICATION_VND_JAPANNET_JPNSTORE_WAKEUP("application/vnd.japannet-jpnstore-wakeup"),
	/** MIME 类型：application/vnd.japannet-payment-wakeup */
	APPLICATION_VND_JAPANNET_PAYMENT_WAKEUP("application/vnd.japannet-payment-wakeup"),
	/** MIME 类型：application/vnd.japannet-registration */
	APPLICATION_VND_JAPANNET_REGISTRATION("application/vnd.japannet-registration"),
	/** MIME 类型：application/vnd.japannet-registration-wakeup */
	APPLICATION_VND_JAPANNET_REGISTRATION_WAKEUP("application/vnd.japannet-registration-wakeup"),
	/** MIME 类型：application/vnd.japannet-setstore-wakeup */
	APPLICATION_VND_JAPANNET_SETSTORE_WAKEUP("application/vnd.japannet-setstore-wakeup"),
	/** MIME 类型：application/vnd.japannet-verification */
	APPLICATION_VND_JAPANNET_VERIFICATION("application/vnd.japannet-verification"),
	/** MIME 类型：application/vnd.japannet-verification-wakeup */
	APPLICATION_VND_JAPANNET_VERIFICATION_WAKEUP("application/vnd.japannet-verification-wakeup"),
	/** MIME 类型：application/vnd.jcp.javame.midlet-rms */
	APPLICATION_VND_JCP_JAVAME_MIDLET_RMS("application/vnd.jcp.javame.midlet-rms"),
	/** MIME 类型：application/vnd.jisp */
	APPLICATION_VND_JISP("application/vnd.jisp"),
	/** MIME 类型：application/vnd.joost.joda-archive */
	APPLICATION_VND_JOOST_JODA_ARCHIVE("application/vnd.joost.joda-archive"),
	/** MIME 类型：application/vnd.jsk.isdn-ngn */
	APPLICATION_VND_JSK_ISDN_NGN("application/vnd.jsk.isdn-ngn"),
	/** MIME 类型：application/vnd.kahootz */
	APPLICATION_VND_KAHOOTZ("application/vnd.kahootz"),
	/** MIME 类型：application/vnd.kde.karbon */
	APPLICATION_VND_KDE_KARBON("application/vnd.kde.karbon"),
	/** MIME 类型：application/vnd.kde.kchart */
	APPLICATION_VND_KDE_KCHART("application/vnd.kde.kchart"),
	/** MIME 类型：application/vnd.kde.kformula */
	APPLICATION_VND_KDE_KFORMULA("application/vnd.kde.kformula"),
	/** MIME 类型：application/vnd.kde.kivio */
	APPLICATION_VND_KDE_KIVIO("application/vnd.kde.kivio"),
	/** MIME 类型：application/vnd.kde.kontour */
	APPLICATION_VND_KDE_KONTOUR("application/vnd.kde.kontour"),
	/** MIME 类型：application/vnd.kde.kpresenter */
	APPLICATION_VND_KDE_KPRESENTER("application/vnd.kde.kpresenter"),
	/** MIME 类型：application/vnd.kde.kspread */
	APPLICATION_VND_KDE_KSPREAD("application/vnd.kde.kspread"),
	/** MIME 类型：application/vnd.kde.kword */
	APPLICATION_VND_KDE_KWORD("application/vnd.kde.kword"),
	/** MIME 类型：application/vnd.kdl */
	APPLICATION_VND_KDL("application/vnd.kdl"),
	/** MIME 类型：application/vnd.kenameaapp */
	APPLICATION_VND_KENAMEAAPP("application/vnd.kenameaapp"),
	/** MIME 类型：application/vnd.keyman.kmp+zip */
	APPLICATION_VND_KEYMAN_KMP_ZIP("application/vnd.keyman.kmp+zip"),
	/** MIME 类型：application/vnd.keyman.kmx */
	APPLICATION_VND_KEYMAN_KMX("application/vnd.keyman.kmx"),
	/** MIME 类型：application/vnd.kidspiration */
	APPLICATION_VND_KIDSPIRATION("application/vnd.kidspiration"),
	/** MIME 类型：application/vnd.Kinar */
	APPLICATION_VND_KINAR("application/vnd.Kinar"),
	/** MIME 类型：application/vnd.koan */
	APPLICATION_VND_KOAN("application/vnd.koan"),
	/** MIME 类型：application/vnd.kodak-descriptor */
	APPLICATION_VND_KODAK_DESCRIPTOR("application/vnd.kodak-descriptor"),
	/** MIME 类型：application/vnd.las */
	APPLICATION_VND_LAS("application/vnd.las"),
	/** MIME 类型：application/vnd.las.las+json */
	APPLICATION_VND_LAS_LAS_JSON("application/vnd.las.las+json"),
	/** MIME 类型：application/vnd.las.las+xml */
	APPLICATION_VND_LAS_LAS_XML("application/vnd.las.las+xml"),
	/** MIME 类型：application/vnd.laszip */
	APPLICATION_VND_LASZIP("application/vnd.laszip"),
	/** MIME 类型：application/vnd.ldev.productlicensing */
	APPLICATION_VND_LDEV_PRODUCTLICENSING("application/vnd.ldev.productlicensing"),
	/** MIME 类型：application/vnd.leap+json */
	APPLICATION_VND_LEAP_JSON("application/vnd.leap+json"),
	/** MIME 类型：application/vnd.liberty-request+xml */
	APPLICATION_VND_LIBERTY_REQUEST_XML("application/vnd.liberty-request+xml"),
	/** MIME 类型：application/vnd.llamagraphics.life-balance.desktop */
	APPLICATION_VND_LLAMAGRAPHICS_LIFE_BALANCE_DESKTOP("application/vnd.llamagraphics.life-balance.desktop"),
	/** MIME 类型：application/vnd.llamagraphics.life-balance.exchange+xml */
	APPLICATION_VND_LLAMAGRAPHICS_LIFE_BALANCE_EXCHANGE_XML("application/vnd.llamagraphics.life-balance.exchange+xml"),
	/** MIME 类型：application/vnd.logipipe.circuit+zip */
	APPLICATION_VND_LOGIPIPE_CIRCUIT_ZIP("application/vnd.logipipe.circuit+zip"),
	/** MIME 类型：application/vnd.loom */
	APPLICATION_VND_LOOM("application/vnd.loom"),
	/** MIME 类型：application/vnd.lotus-1-2-3 */
	APPLICATION_VND_LOTUS_1_2_3("application/vnd.lotus-1-2-3"),
	/** MIME 类型：application/vnd.lotus-approach */
	APPLICATION_VND_LOTUS_APPROACH("application/vnd.lotus-approach"),
	/** MIME 类型：application/vnd.lotus-freelance */
	APPLICATION_VND_LOTUS_FREELANCE("application/vnd.lotus-freelance"),
	/** MIME 类型：application/vnd.lotus-notes */
	APPLICATION_VND_LOTUS_NOTES("application/vnd.lotus-notes"),
	/** MIME 类型：application/vnd.lotus-organizer */
	APPLICATION_VND_LOTUS_ORGANIZER("application/vnd.lotus-organizer"),
	/** MIME 类型：application/vnd.lotus-screencam */
	APPLICATION_VND_LOTUS_SCREENCAM("application/vnd.lotus-screencam"),
	/** MIME 类型：application/vnd.lotus-wordpro */
	APPLICATION_VND_LOTUS_WORDPRO("application/vnd.lotus-wordpro"),
	/** MIME 类型：application/vnd.macports.portpkg */
	APPLICATION_VND_MACPORTS_PORTPKG("application/vnd.macports.portpkg"),
	/** MIME 类型：application/vnd.maml */
	APPLICATION_VND_MAML("application/vnd.maml"),
	/** MIME 类型：application/vnd.mapbox-vector-tile */
	APPLICATION_VND_MAPBOX_VECTOR_TILE("application/vnd.mapbox-vector-tile"),
	/** MIME 类型：application/vnd.marlin.drm.actiontoken+xml */
	APPLICATION_VND_MARLIN_DRM_ACTIONTOKEN_XML("application/vnd.marlin.drm.actiontoken+xml"),
	/** MIME 类型：application/vnd.marlin.drm.conftoken+xml */
	APPLICATION_VND_MARLIN_DRM_CONFTOKEN_XML("application/vnd.marlin.drm.conftoken+xml"),
	/** MIME 类型：application/vnd.marlin.drm.license+xml */
	APPLICATION_VND_MARLIN_DRM_LICENSE_XML("application/vnd.marlin.drm.license+xml"),
	/** MIME 类型：application/vnd.marlin.drm.mdcf */
	APPLICATION_VND_MARLIN_DRM_MDCF("application/vnd.marlin.drm.mdcf"),
	/** MIME 类型：application/vnd.mason+json */
	APPLICATION_VND_MASON_JSON("application/vnd.mason+json"),
	/** MIME 类型：application/vnd.maxar.archive.3tz+zip */
	APPLICATION_VND_MAXAR_ARCHIVE_3TZ_ZIP("application/vnd.maxar.archive.3tz+zip"),
	/** MIME 类型：application/vnd.maxmind.maxmind-db */
	APPLICATION_VND_MAXMIND_MAXMIND_DB("application/vnd.maxmind.maxmind-db"),
	/** MIME 类型：application/vnd.mcd */
	APPLICATION_VND_MCD("application/vnd.mcd"),
	/** MIME 类型：application/vnd.mdl */
	APPLICATION_VND_MDL("application/vnd.mdl"),
	/** MIME 类型：application/vnd.mdl-mbsdf */
	APPLICATION_VND_MDL_MBSDF("application/vnd.mdl-mbsdf"),
	/** MIME 类型：application/vnd.medcalcdata */
	APPLICATION_VND_MEDCALCDATA("application/vnd.medcalcdata"),
	/** MIME 类型：application/vnd.mediastation.cdkey */
	APPLICATION_VND_MEDIASTATION_CDKEY("application/vnd.mediastation.cdkey"),
	/** MIME 类型：application/vnd.medicalholodeck.recordxr */
	APPLICATION_VND_MEDICALHOLODECK_RECORDXR("application/vnd.medicalholodeck.recordxr"),
	/** MIME 类型：application/vnd.meridian-slingshot */
	APPLICATION_VND_MERIDIAN_SLINGSHOT("application/vnd.meridian-slingshot"),
	/** MIME 类型：application/vnd.mermaid */
	APPLICATION_VND_MERMAID("application/vnd.mermaid"),
	/** MIME 类型：application/vnd.MFER */
	APPLICATION_VND_MFER("application/vnd.MFER"),
	/** MIME 类型：application/vnd.mfmp */
	APPLICATION_VND_MFMP("application/vnd.mfmp"),
	/** MIME 类型：application/vnd.micro+json */
	APPLICATION_VND_MICRO_JSON("application/vnd.micro+json"),
	/** MIME 类型：application/vnd.micrografx.flo */
	APPLICATION_VND_MICROGRAFX_FLO("application/vnd.micrografx.flo"),
	/** MIME 类型：application/vnd.micrografx.igx */
	APPLICATION_VND_MICROGRAFX_IGX("application/vnd.micrografx.igx"),
	/** MIME 类型：application/vnd.microsoft.portable-executable */
	APPLICATION_VND_MICROSOFT_PORTABLE_EXECUTABLE("application/vnd.microsoft.portable-executable"),
	/** MIME 类型：application/vnd.microsoft.windows.thumbnail-cache */
	APPLICATION_VND_MICROSOFT_WINDOWS_THUMBNAIL_CACHE("application/vnd.microsoft.windows.thumbnail-cache"),
	/** MIME 类型：application/vnd.miele+json */
	APPLICATION_VND_MIELE_JSON("application/vnd.miele+json"),
	/** MIME 类型：application/vnd.mif */
	APPLICATION_VND_MIF("application/vnd.mif"),
	/** MIME 类型：application/vnd.minisoft-hp3000-save */
	APPLICATION_VND_MINISOFT_HP3000_SAVE("application/vnd.minisoft-hp3000-save"),
	/** MIME 类型：application/vnd.mitsubishi.misty-guard.trustweb */
	APPLICATION_VND_MITSUBISHI_MISTY_GUARD_TRUSTWEB("application/vnd.mitsubishi.misty-guard.trustweb"),
	/** MIME 类型：application/vnd.Mobius.DAF */
	APPLICATION_VND_MOBIUS_DAF("application/vnd.Mobius.DAF"),
	/** MIME 类型：application/vnd.Mobius.DIS */
	APPLICATION_VND_MOBIUS_DIS("application/vnd.Mobius.DIS"),
	/** MIME 类型：application/vnd.Mobius.MBK */
	APPLICATION_VND_MOBIUS_MBK("application/vnd.Mobius.MBK"),
	/** MIME 类型：application/vnd.Mobius.MQY */
	APPLICATION_VND_MOBIUS_MQY("application/vnd.Mobius.MQY"),
	/** MIME 类型：application/vnd.Mobius.MSL */
	APPLICATION_VND_MOBIUS_MSL("application/vnd.Mobius.MSL"),
	/** MIME 类型：application/vnd.Mobius.PLC */
	APPLICATION_VND_MOBIUS_PLC("application/vnd.Mobius.PLC"),
	/** MIME 类型：application/vnd.Mobius.TXF */
	APPLICATION_VND_MOBIUS_TXF("application/vnd.Mobius.TXF"),
	/** MIME 类型：application/vnd.modl */
	APPLICATION_VND_MODL("application/vnd.modl"),
	/** MIME 类型：application/vnd.mophun.application */
	APPLICATION_VND_MOPHUN_APPLICATION("application/vnd.mophun.application"),
	/** MIME 类型：application/vnd.mophun.certificate */
	APPLICATION_VND_MOPHUN_CERTIFICATE("application/vnd.mophun.certificate"),
	/** MIME 类型：application/vnd.motorola.flexsuite */
	APPLICATION_VND_MOTOROLA_FLEXSUITE("application/vnd.motorola.flexsuite"),
	/** MIME 类型：application/vnd.motorola.flexsuite.adsi */
	APPLICATION_VND_MOTOROLA_FLEXSUITE_ADSI("application/vnd.motorola.flexsuite.adsi"),
	/** MIME 类型：application/vnd.motorola.flexsuite.fis */
	APPLICATION_VND_MOTOROLA_FLEXSUITE_FIS("application/vnd.motorola.flexsuite.fis"),
	/** MIME 类型：application/vnd.motorola.flexsuite.gotap */
	APPLICATION_VND_MOTOROLA_FLEXSUITE_GOTAP("application/vnd.motorola.flexsuite.gotap"),
	/** MIME 类型：application/vnd.motorola.flexsuite.kmr */
	APPLICATION_VND_MOTOROLA_FLEXSUITE_KMR("application/vnd.motorola.flexsuite.kmr"),
	/** MIME 类型：application/vnd.motorola.flexsuite.ttc */
	APPLICATION_VND_MOTOROLA_FLEXSUITE_TTC("application/vnd.motorola.flexsuite.ttc"),
	/** MIME 类型：application/vnd.motorola.flexsuite.wem */
	APPLICATION_VND_MOTOROLA_FLEXSUITE_WEM("application/vnd.motorola.flexsuite.wem"),
	/** MIME 类型：application/vnd.motorola.iprm */
	APPLICATION_VND_MOTOROLA_IPRM("application/vnd.motorola.iprm"),
	/** MIME 类型：application/vnd.mozilla.xul+xml */
	APPLICATION_VND_MOZILLA_XUL_XML("application/vnd.mozilla.xul+xml"),
	/** MIME 类型：application/vnd.ms-artgalry */
	APPLICATION_VND_MS_ARTGALRY("application/vnd.ms-artgalry"),
	/** MIME 类型：application/vnd.ms-asf */
	APPLICATION_VND_MS_ASF("application/vnd.ms-asf"),
	/** MIME 类型：application/vnd.ms-cab-compressed */
	APPLICATION_VND_MS_CAB_COMPRESSED("application/vnd.ms-cab-compressed"),
	/** MIME 类型：application/vnd.ms-3mfdocument */
	APPLICATION_VND_MS_3MFDOCUMENT("application/vnd.ms-3mfdocument"),
	/** MIME 类型：application/vnd.ms-excel */
	APPLICATION_VND_MS_EXCEL("application/vnd.ms-excel"),
	/** MIME 类型：application/vnd.ms-excel.addin.macroEnabled.12 */
	APPLICATION_VND_MS_EXCEL_ADDIN_MACROENABLED_12("application/vnd.ms-excel.addin.macroEnabled.12"),
	/** MIME 类型：application/vnd.ms-excel.sheet.binary.macroEnabled.12 */
	APPLICATION_VND_MS_EXCEL_SHEET_BINARY_MACROENABLED_12("application/vnd.ms-excel.sheet.binary.macroEnabled.12"),
	/** MIME 类型：application/vnd.ms-excel.sheet.macroEnabled.12 */
	APPLICATION_VND_MS_EXCEL_SHEET_MACROENABLED_12("application/vnd.ms-excel.sheet.macroEnabled.12"),
	/** MIME 类型：application/vnd.ms-excel.template.macroEnabled.12 */
	APPLICATION_VND_MS_EXCEL_TEMPLATE_MACROENABLED_12("application/vnd.ms-excel.template.macroEnabled.12"),
	/** MIME 类型：application/vnd.ms-fontobject */
	APPLICATION_VND_MS_FONTOBJECT("application/vnd.ms-fontobject"),
	/** MIME 类型：application/vnd.ms-htmlhelp */
	APPLICATION_VND_MS_HTMLHELP("application/vnd.ms-htmlhelp"),
	/** MIME 类型：application/vnd.ms-ims */
	APPLICATION_VND_MS_IMS("application/vnd.ms-ims"),
	/** MIME 类型：application/vnd.ms-lrm */
	APPLICATION_VND_MS_LRM("application/vnd.ms-lrm"),
	/** MIME 类型：application/vnd.ms-office.activeX+xml */
	APPLICATION_VND_MS_OFFICE_ACTIVEX_XML("application/vnd.ms-office.activeX+xml"),
	/** MIME 类型：application/vnd.ms-officetheme */
	APPLICATION_VND_MS_OFFICETHEME("application/vnd.ms-officetheme"),
	/** MIME 类型：application/vnd.ms-playready.initiator+xml */
	APPLICATION_VND_MS_PLAYREADY_INITIATOR_XML("application/vnd.ms-playready.initiator+xml"),
	/** MIME 类型：application/vnd.ms-powerpoint */
	APPLICATION_VND_MS_POWERPOINT("application/vnd.ms-powerpoint"),
	/** MIME 类型：application/vnd.ms-powerpoint.addin.macroEnabled.12 */
	APPLICATION_VND_MS_POWERPOINT_ADDIN_MACROENABLED_12("application/vnd.ms-powerpoint.addin.macroEnabled.12"),
	/** MIME 类型：application/vnd.ms-powerpoint.presentation.macroEnabled.12 */
	APPLICATION_VND_MS_POWERPOINT_PRESENTATION_MACROENABLED_12("application/vnd.ms-powerpoint.presentation.macroEnabled.12"),
	/** MIME 类型：application/vnd.ms-powerpoint.slide.macroEnabled.12 */
	APPLICATION_VND_MS_POWERPOINT_SLIDE_MACROENABLED_12("application/vnd.ms-powerpoint.slide.macroEnabled.12"),
	/** MIME 类型：application/vnd.ms-powerpoint.slideshow.macroEnabled.12 */
	APPLICATION_VND_MS_POWERPOINT_SLIDESHOW_MACROENABLED_12("application/vnd.ms-powerpoint.slideshow.macroEnabled.12"),
	/** MIME 类型：application/vnd.ms-powerpoint.template.macroEnabled.12 */
	APPLICATION_VND_MS_POWERPOINT_TEMPLATE_MACROENABLED_12("application/vnd.ms-powerpoint.template.macroEnabled.12"),
	/** MIME 类型：application/vnd.ms-PrintDeviceCapabilities+xml */
	APPLICATION_VND_MS_PRINTDEVICECAPABILITIES_XML("application/vnd.ms-PrintDeviceCapabilities+xml"),
	/** MIME 类型：application/vnd.ms-PrintSchemaTicket+xml */
	APPLICATION_VND_MS_PRINTSCHEMATICKET_XML("application/vnd.ms-PrintSchemaTicket+xml"),
	/** MIME 类型：application/vnd.ms-project */
	APPLICATION_VND_MS_PROJECT("application/vnd.ms-project"),
	/** MIME 类型：application/vnd.ms-tnef */
	APPLICATION_VND_MS_TNEF("application/vnd.ms-tnef"),
	/** MIME 类型：application/vnd.ms-windows.devicepairing */
	APPLICATION_VND_MS_WINDOWS_DEVICEPAIRING("application/vnd.ms-windows.devicepairing"),
	/** MIME 类型：application/vnd.ms-windows.nwprinting.oob */
	APPLICATION_VND_MS_WINDOWS_NWPRINTING_OOB("application/vnd.ms-windows.nwprinting.oob"),
	/** MIME 类型：application/vnd.ms-windows.printerpairing */
	APPLICATION_VND_MS_WINDOWS_PRINTERPAIRING("application/vnd.ms-windows.printerpairing"),
	/** MIME 类型：application/vnd.ms-windows.wsd.oob */
	APPLICATION_VND_MS_WINDOWS_WSD_OOB("application/vnd.ms-windows.wsd.oob"),
	/** MIME 类型：application/vnd.ms-wmdrm.lic-chlg-req */
	APPLICATION_VND_MS_WMDRM_LIC_CHLG_REQ("application/vnd.ms-wmdrm.lic-chlg-req"),
	/** MIME 类型：application/vnd.ms-wmdrm.lic-resp */
	APPLICATION_VND_MS_WMDRM_LIC_RESP("application/vnd.ms-wmdrm.lic-resp"),
	/** MIME 类型：application/vnd.ms-wmdrm.meter-chlg-req */
	APPLICATION_VND_MS_WMDRM_METER_CHLG_REQ("application/vnd.ms-wmdrm.meter-chlg-req"),
	/** MIME 类型：application/vnd.ms-wmdrm.meter-resp */
	APPLICATION_VND_MS_WMDRM_METER_RESP("application/vnd.ms-wmdrm.meter-resp"),
	/** MIME 类型：application/vnd.ms-word.document.macroEnabled.12 */
	APPLICATION_VND_MS_WORD_DOCUMENT_MACROENABLED_12("application/vnd.ms-word.document.macroEnabled.12"),
	/** MIME 类型：application/vnd.ms-word.template.macroEnabled.12 */
	APPLICATION_VND_MS_WORD_TEMPLATE_MACROENABLED_12("application/vnd.ms-word.template.macroEnabled.12"),
	/** MIME 类型：application/vnd.ms-works */
	APPLICATION_VND_MS_WORKS("application/vnd.ms-works"),
	/** MIME 类型：application/vnd.ms-wpl */
	APPLICATION_VND_MS_WPL("application/vnd.ms-wpl"),
	/** MIME 类型：application/vnd.ms-xpsdocument */
	APPLICATION_VND_MS_XPSDOCUMENT("application/vnd.ms-xpsdocument"),
	/** MIME 类型：application/vnd.msa-disk-image */
	APPLICATION_VND_MSA_DISK_IMAGE("application/vnd.msa-disk-image"),
	/** MIME 类型：application/vnd.mseq */
	APPLICATION_VND_MSEQ("application/vnd.mseq"),
	/** MIME 类型：application/vnd.msgpack */
	APPLICATION_VND_MSGPACK("application/vnd.msgpack"),
	/** MIME 类型：application/vnd.msign */
	APPLICATION_VND_MSIGN("application/vnd.msign"),
	/** MIME 类型：application/vnd.multiad.creator */
	APPLICATION_VND_MULTIAD_CREATOR("application/vnd.multiad.creator"),
	/** MIME 类型：application/vnd.multiad.creator.cif */
	APPLICATION_VND_MULTIAD_CREATOR_CIF("application/vnd.multiad.creator.cif"),
	/** MIME 类型：application/vnd.musician */
	APPLICATION_VND_MUSICIAN("application/vnd.musician"),
	/** MIME 类型：application/vnd.music-niff */
	APPLICATION_VND_MUSIC_NIFF("application/vnd.music-niff"),
	/** MIME 类型：application/vnd.muvee.style */
	APPLICATION_VND_MUVEE_STYLE("application/vnd.muvee.style"),
	/** MIME 类型：application/vnd.mynfc */
	APPLICATION_VND_MYNFC("application/vnd.mynfc"),
	/** MIME 类型：application/vnd.nacamar.ybrid+json */
	APPLICATION_VND_NACAMAR_YBRID_JSON("application/vnd.nacamar.ybrid+json"),
	/** MIME 类型：application/vnd.nato.bindingdataobject+cbor */
	APPLICATION_VND_NATO_BINDINGDATAOBJECT_CBOR("application/vnd.nato.bindingdataobject+cbor"),
	/** MIME 类型：application/vnd.nato.bindingdataobject+json */
	APPLICATION_VND_NATO_BINDINGDATAOBJECT_JSON("application/vnd.nato.bindingdataobject+json"),
	/** MIME 类型：application/vnd.nato.bindingdataobject+xml */
	APPLICATION_VND_NATO_BINDINGDATAOBJECT_XML("application/vnd.nato.bindingdataobject+xml"),
	/** MIME 类型：application/vnd.nato.openxmlformats-package.iepd+zip */
	APPLICATION_VND_NATO_OPENXMLFORMATS_PACKAGE_IEPD_ZIP("application/vnd.nato.openxmlformats-package.iepd+zip"),
	/** MIME 类型：application/vnd.ncd.control */
	APPLICATION_VND_NCD_CONTROL("application/vnd.ncd.control"),
	/** MIME 类型：application/vnd.ncd.reference */
	APPLICATION_VND_NCD_REFERENCE("application/vnd.ncd.reference"),
	/** MIME 类型：application/vnd.nearst.inv+json */
	APPLICATION_VND_NEARST_INV_JSON("application/vnd.nearst.inv+json"),
	/** MIME 类型：application/vnd.nebumind.line */
	APPLICATION_VND_NEBUMIND_LINE("application/vnd.nebumind.line"),
	/** MIME 类型：application/vnd.nervana */
	APPLICATION_VND_NERVANA("application/vnd.nervana"),
	/** MIME 类型：application/vnd.netfpx */
	APPLICATION_VND_NETFPX("application/vnd.netfpx"),
	/** MIME 类型：application/vnd.neurolanguage.nlu */
	APPLICATION_VND_NEUROLANGUAGE_NLU("application/vnd.neurolanguage.nlu"),
	/** MIME 类型：application/vnd.nimn */
	APPLICATION_VND_NIMN("application/vnd.nimn"),
	/** MIME 类型：application/vnd.nintendo.snes.rom */
	APPLICATION_VND_NINTENDO_SNES_ROM("application/vnd.nintendo.snes.rom"),
	/** MIME 类型：application/vnd.nintendo.nitro.rom */
	APPLICATION_VND_NINTENDO_NITRO_ROM("application/vnd.nintendo.nitro.rom"),
	/** MIME 类型：application/vnd.nitf */
	APPLICATION_VND_NITF("application/vnd.nitf"),
	/** MIME 类型：application/vnd.noblenet-directory */
	APPLICATION_VND_NOBLENET_DIRECTORY("application/vnd.noblenet-directory"),
	/** MIME 类型：application/vnd.noblenet-sealer */
	APPLICATION_VND_NOBLENET_SEALER("application/vnd.noblenet-sealer"),
	/** MIME 类型：application/vnd.noblenet-web */
	APPLICATION_VND_NOBLENET_WEB("application/vnd.noblenet-web"),
	/** MIME 类型：application/vnd.nokia.catalogs */
	APPLICATION_VND_NOKIA_CATALOGS("application/vnd.nokia.catalogs"),
	/** MIME 类型：application/vnd.nokia.conml+wbxml */
	APPLICATION_VND_NOKIA_CONML_WBXML("application/vnd.nokia.conml+wbxml"),
	/** MIME 类型：application/vnd.nokia.conml+xml */
	APPLICATION_VND_NOKIA_CONML_XML("application/vnd.nokia.conml+xml"),
	/** MIME 类型：application/vnd.nokia.iptv.config+xml */
	APPLICATION_VND_NOKIA_IPTV_CONFIG_XML("application/vnd.nokia.iptv.config+xml"),
	/** MIME 类型：application/vnd.nokia.iSDS-radio-presets */
	APPLICATION_VND_NOKIA_ISDS_RADIO_PRESETS("application/vnd.nokia.iSDS-radio-presets"),
	/** MIME 类型：application/vnd.nokia.landmark+wbxml */
	APPLICATION_VND_NOKIA_LANDMARK_WBXML("application/vnd.nokia.landmark+wbxml"),
	/** MIME 类型：application/vnd.nokia.landmark+xml */
	APPLICATION_VND_NOKIA_LANDMARK_XML("application/vnd.nokia.landmark+xml"),
	/** MIME 类型：application/vnd.nokia.landmarkcollection+xml */
	APPLICATION_VND_NOKIA_LANDMARKCOLLECTION_XML("application/vnd.nokia.landmarkcollection+xml"),
	/** MIME 类型：application/vnd.nokia.ncd */
	APPLICATION_VND_NOKIA_NCD("application/vnd.nokia.ncd"),
	/** MIME 类型：application/vnd.nokia.n-gage.ac+xml */
	APPLICATION_VND_NOKIA_N_GAGE_AC_XML("application/vnd.nokia.n-gage.ac+xml"),
	/** MIME 类型：application/vnd.nokia.n-gage.data */
	APPLICATION_VND_NOKIA_N_GAGE_DATA("application/vnd.nokia.n-gage.data"),
	/** MIME 类型：application/vnd.nokia.n-gage.symbian.install */
	APPLICATION_VND_NOKIA_N_GAGE_SYMBIAN_INSTALL("application/vnd.nokia.n-gage.symbian.install"),
	/** MIME 类型：application/vnd.nokia.pcd+wbxml */
	APPLICATION_VND_NOKIA_PCD_WBXML("application/vnd.nokia.pcd+wbxml"),
	/** MIME 类型：application/vnd.nokia.pcd+xml */
	APPLICATION_VND_NOKIA_PCD_XML("application/vnd.nokia.pcd+xml"),
	/** MIME 类型：application/vnd.nokia.radio-preset */
	APPLICATION_VND_NOKIA_RADIO_PRESET("application/vnd.nokia.radio-preset"),
	/** MIME 类型：application/vnd.nokia.radio-presets */
	APPLICATION_VND_NOKIA_RADIO_PRESETS("application/vnd.nokia.radio-presets"),
	/** MIME 类型：application/vnd.novadigm.EDM */
	APPLICATION_VND_NOVADIGM_EDM("application/vnd.novadigm.EDM"),
	/** MIME 类型：application/vnd.novadigm.EDX */
	APPLICATION_VND_NOVADIGM_EDX("application/vnd.novadigm.EDX"),
	/** MIME 类型：application/vnd.novadigm.EXT */
	APPLICATION_VND_NOVADIGM_EXT("application/vnd.novadigm.EXT"),
	/** MIME 类型：application/vnd.ntt-local.content-share */
	APPLICATION_VND_NTT_LOCAL_CONTENT_SHARE("application/vnd.ntt-local.content-share"),
	/** MIME 类型：application/vnd.ntt-local.file-transfer */
	APPLICATION_VND_NTT_LOCAL_FILE_TRANSFER("application/vnd.ntt-local.file-transfer"),
	/** MIME 类型：application/vnd.ntt-local.ogw_remote-access */
	APPLICATION_VND_NTT_LOCAL_OGW_REMOTE_ACCESS("application/vnd.ntt-local.ogw_remote-access"),
	/** MIME 类型：application/vnd.ntt-local.sip-ta_remote */
	APPLICATION_VND_NTT_LOCAL_SIP_TA_REMOTE("application/vnd.ntt-local.sip-ta_remote"),
	/** MIME 类型：application/vnd.ntt-local.sip-ta_tcp_stream */
	APPLICATION_VND_NTT_LOCAL_SIP_TA_TCP_STREAM("application/vnd.ntt-local.sip-ta_tcp_stream"),
	/** MIME 类型：application/vnd.nubaltec.nudoku-game */
	APPLICATION_VND_NUBALTEC_NUDOKU_GAME("application/vnd.nubaltec.nudoku-game"),
	/** MIME 类型：application/vnd.oai.workflows */
	APPLICATION_VND_OAI_WORKFLOWS("application/vnd.oai.workflows"),
	/** MIME 类型：application/vnd.oai.workflows+json */
	APPLICATION_VND_OAI_WORKFLOWS_JSON("application/vnd.oai.workflows+json"),
	/** MIME 类型：application/vnd.oai.workflows+yaml */
	APPLICATION_VND_OAI_WORKFLOWS_YAML("application/vnd.oai.workflows+yaml"),
	/** MIME 类型：application/vnd.oasis.opendocument.base */
	APPLICATION_VND_OASIS_OPENDOCUMENT_BASE("application/vnd.oasis.opendocument.base"),
	/** MIME 类型：application/vnd.oasis.opendocument.chart */
	APPLICATION_VND_OASIS_OPENDOCUMENT_CHART("application/vnd.oasis.opendocument.chart"),
	/** MIME 类型：application/vnd.oasis.opendocument.chart-template */
	APPLICATION_VND_OASIS_OPENDOCUMENT_CHART_TEMPLATE("application/vnd.oasis.opendocument.chart-template"),
	/** MIME 类型：application/vnd.oasis.opendocument.database */
	APPLICATION_VND_OASIS_OPENDOCUMENT_DATABASE("application/vnd.oasis.opendocument.database"),
	/** MIME 类型：application/vnd.oasis.opendocument.formula */
	APPLICATION_VND_OASIS_OPENDOCUMENT_FORMULA("application/vnd.oasis.opendocument.formula"),
	/** MIME 类型：application/vnd.oasis.opendocument.formula-template */
	APPLICATION_VND_OASIS_OPENDOCUMENT_FORMULA_TEMPLATE("application/vnd.oasis.opendocument.formula-template"),
	/** MIME 类型：application/vnd.oasis.opendocument.graphics */
	APPLICATION_VND_OASIS_OPENDOCUMENT_GRAPHICS("application/vnd.oasis.opendocument.graphics"),
	/** MIME 类型：application/vnd.oasis.opendocument.graphics-template */
	APPLICATION_VND_OASIS_OPENDOCUMENT_GRAPHICS_TEMPLATE("application/vnd.oasis.opendocument.graphics-template"),
	/** MIME 类型：application/vnd.oasis.opendocument.image */
	APPLICATION_VND_OASIS_OPENDOCUMENT_IMAGE("application/vnd.oasis.opendocument.image"),
	/** MIME 类型：application/vnd.oasis.opendocument.image-template */
	APPLICATION_VND_OASIS_OPENDOCUMENT_IMAGE_TEMPLATE("application/vnd.oasis.opendocument.image-template"),
	/** MIME 类型：application/vnd.oasis.opendocument.presentation */
	APPLICATION_VND_OASIS_OPENDOCUMENT_PRESENTATION("application/vnd.oasis.opendocument.presentation"),
	/** MIME 类型：application/vnd.oasis.opendocument.presentation-template */
	APPLICATION_VND_OASIS_OPENDOCUMENT_PRESENTATION_TEMPLATE("application/vnd.oasis.opendocument.presentation-template"),
	/** MIME 类型：application/vnd.oasis.opendocument.spreadsheet */
	APPLICATION_VND_OASIS_OPENDOCUMENT_SPREADSHEET("application/vnd.oasis.opendocument.spreadsheet"),
	/** MIME 类型：application/vnd.oasis.opendocument.spreadsheet-template */
	APPLICATION_VND_OASIS_OPENDOCUMENT_SPREADSHEET_TEMPLATE("application/vnd.oasis.opendocument.spreadsheet-template"),
	/** MIME 类型：application/vnd.oasis.opendocument.text */
	APPLICATION_VND_OASIS_OPENDOCUMENT_TEXT("application/vnd.oasis.opendocument.text"),
	/** MIME 类型：application/vnd.oasis.opendocument.text-master */
	APPLICATION_VND_OASIS_OPENDOCUMENT_TEXT_MASTER("application/vnd.oasis.opendocument.text-master"),
	/** MIME 类型：application/vnd.oasis.opendocument.text-master-template */
	APPLICATION_VND_OASIS_OPENDOCUMENT_TEXT_MASTER_TEMPLATE("application/vnd.oasis.opendocument.text-master-template"),
	/** MIME 类型：application/vnd.oasis.opendocument.text-template */
	APPLICATION_VND_OASIS_OPENDOCUMENT_TEXT_TEMPLATE("application/vnd.oasis.opendocument.text-template"),
	/** MIME 类型：application/vnd.oasis.opendocument.text-web */
	APPLICATION_VND_OASIS_OPENDOCUMENT_TEXT_WEB("application/vnd.oasis.opendocument.text-web"),
	/** MIME 类型：application/vnd.obn */
	APPLICATION_VND_OBN("application/vnd.obn"),
	/** MIME 类型：application/vnd.ocf+cbor */
	APPLICATION_VND_OCF_CBOR("application/vnd.ocf+cbor"),
	/** MIME 类型：application/vnd.oci.image.manifest.v1+json */
	APPLICATION_VND_OCI_IMAGE_MANIFEST_V1_JSON("application/vnd.oci.image.manifest.v1+json"),
	/** MIME 类型：application/vnd.oftn.l10n+json */
	APPLICATION_VND_OFTN_L10N_JSON("application/vnd.oftn.l10n+json"),
	/** MIME 类型：application/vnd.oipf.contentaccessdownload+xml */
	APPLICATION_VND_OIPF_CONTENTACCESSDOWNLOAD_XML("application/vnd.oipf.contentaccessdownload+xml"),
	/** MIME 类型：application/vnd.oipf.contentaccessstreaming+xml */
	APPLICATION_VND_OIPF_CONTENTACCESSSTREAMING_XML("application/vnd.oipf.contentaccessstreaming+xml"),
	/** MIME 类型：application/vnd.oipf.cspg-hexbinary */
	APPLICATION_VND_OIPF_CSPG_HEXBINARY("application/vnd.oipf.cspg-hexbinary"),
	/** MIME 类型：application/vnd.oipf.dae.svg+xml */
	APPLICATION_VND_OIPF_DAE_SVG_XML("application/vnd.oipf.dae.svg+xml"),
	/** MIME 类型：application/vnd.oipf.dae.xhtml+xml */
	APPLICATION_VND_OIPF_DAE_XHTML_XML("application/vnd.oipf.dae.xhtml+xml"),
	/** MIME 类型：application/vnd.oipf.mippvcontrolmessage+xml */
	APPLICATION_VND_OIPF_MIPPVCONTROLMESSAGE_XML("application/vnd.oipf.mippvcontrolmessage+xml"),
	/** MIME 类型：application/vnd.oipf.pae.gem */
	APPLICATION_VND_OIPF_PAE_GEM("application/vnd.oipf.pae.gem"),
	/** MIME 类型：application/vnd.oipf.spdiscovery+xml */
	APPLICATION_VND_OIPF_SPDISCOVERY_XML("application/vnd.oipf.spdiscovery+xml"),
	/** MIME 类型：application/vnd.oipf.spdlist+xml */
	APPLICATION_VND_OIPF_SPDLIST_XML("application/vnd.oipf.spdlist+xml"),
	/** MIME 类型：application/vnd.oipf.ueprofile+xml */
	APPLICATION_VND_OIPF_UEPROFILE_XML("application/vnd.oipf.ueprofile+xml"),
	/** MIME 类型：application/vnd.oipf.userprofile+xml */
	APPLICATION_VND_OIPF_USERPROFILE_XML("application/vnd.oipf.userprofile+xml"),
	/** MIME 类型：application/vnd.olpc-sugar */
	APPLICATION_VND_OLPC_SUGAR("application/vnd.olpc-sugar"),
	/** MIME 类型：application/vnd.oma.bcast.associated-procedure-parameter+xml */
	APPLICATION_VND_OMA_BCAST_ASSOCIATED_PROCEDURE_PARAMETER_XML("application/vnd.oma.bcast.associated-procedure-parameter+xml"),
	/** MIME 类型：application/vnd.oma.bcast.drm-trigger+xml */
	APPLICATION_VND_OMA_BCAST_DRM_TRIGGER_XML("application/vnd.oma.bcast.drm-trigger+xml"),
	/** MIME 类型：application/vnd.oma.bcast.imd+xml */
	APPLICATION_VND_OMA_BCAST_IMD_XML("application/vnd.oma.bcast.imd+xml"),
	/** MIME 类型：application/vnd.oma.bcast.ltkm */
	APPLICATION_VND_OMA_BCAST_LTKM("application/vnd.oma.bcast.ltkm"),
	/** MIME 类型：application/vnd.oma.bcast.notification+xml */
	APPLICATION_VND_OMA_BCAST_NOTIFICATION_XML("application/vnd.oma.bcast.notification+xml"),
	/** MIME 类型：application/vnd.oma.bcast.provisioningtrigger */
	APPLICATION_VND_OMA_BCAST_PROVISIONINGTRIGGER("application/vnd.oma.bcast.provisioningtrigger"),
	/** MIME 类型：application/vnd.oma.bcast.sgboot */
	APPLICATION_VND_OMA_BCAST_SGBOOT("application/vnd.oma.bcast.sgboot"),
	/** MIME 类型：application/vnd.oma.bcast.sgdd+xml */
	APPLICATION_VND_OMA_BCAST_SGDD_XML("application/vnd.oma.bcast.sgdd+xml"),
	/** MIME 类型：application/vnd.oma.bcast.sgdu */
	APPLICATION_VND_OMA_BCAST_SGDU("application/vnd.oma.bcast.sgdu"),
	/** MIME 类型：application/vnd.oma.bcast.simple-symbol-container */
	APPLICATION_VND_OMA_BCAST_SIMPLE_SYMBOL_CONTAINER("application/vnd.oma.bcast.simple-symbol-container"),
	/** MIME 类型：application/vnd.oma.bcast.smartcard-trigger+xml */
	APPLICATION_VND_OMA_BCAST_SMARTCARD_TRIGGER_XML("application/vnd.oma.bcast.smartcard-trigger+xml"),
	/** MIME 类型：application/vnd.oma.bcast.sprov+xml */
	APPLICATION_VND_OMA_BCAST_SPROV_XML("application/vnd.oma.bcast.sprov+xml"),
	/** MIME 类型：application/vnd.oma.bcast.stkm */
	APPLICATION_VND_OMA_BCAST_STKM("application/vnd.oma.bcast.stkm"),
	/** MIME 类型：application/vnd.oma.cab-address-book+xml */
	APPLICATION_VND_OMA_CAB_ADDRESS_BOOK_XML("application/vnd.oma.cab-address-book+xml"),
	/** MIME 类型：application/vnd.oma.cab-feature-handler+xml */
	APPLICATION_VND_OMA_CAB_FEATURE_HANDLER_XML("application/vnd.oma.cab-feature-handler+xml"),
	/** MIME 类型：application/vnd.oma.cab-pcc+xml */
	APPLICATION_VND_OMA_CAB_PCC_XML("application/vnd.oma.cab-pcc+xml"),
	/** MIME 类型：application/vnd.oma.cab-subs-invite+xml */
	APPLICATION_VND_OMA_CAB_SUBS_INVITE_XML("application/vnd.oma.cab-subs-invite+xml"),
	/** MIME 类型：application/vnd.oma.cab-user-prefs+xml */
	APPLICATION_VND_OMA_CAB_USER_PREFS_XML("application/vnd.oma.cab-user-prefs+xml"),
	/** MIME 类型：application/vnd.oma.dcd */
	APPLICATION_VND_OMA_DCD("application/vnd.oma.dcd"),
	/** MIME 类型：application/vnd.oma.dcdc */
	APPLICATION_VND_OMA_DCDC("application/vnd.oma.dcdc"),
	/** MIME 类型：application/vnd.oma.dd2+xml */
	APPLICATION_VND_OMA_DD2_XML("application/vnd.oma.dd2+xml"),
	/** MIME 类型：application/vnd.oma.drm.risd+xml */
	APPLICATION_VND_OMA_DRM_RISD_XML("application/vnd.oma.drm.risd+xml"),
	/** MIME 类型：application/vnd.oma.group-usage-list+xml */
	APPLICATION_VND_OMA_GROUP_USAGE_LIST_XML("application/vnd.oma.group-usage-list+xml"),
	/** MIME 类型：application/vnd.oma.lwm2m+cbor */
	APPLICATION_VND_OMA_LWM2M_CBOR("application/vnd.oma.lwm2m+cbor"),
	/** MIME 类型：application/vnd.oma.lwm2m+json */
	APPLICATION_VND_OMA_LWM2M_JSON("application/vnd.oma.lwm2m+json"),
	/** MIME 类型：application/vnd.oma.lwm2m+tlv */
	APPLICATION_VND_OMA_LWM2M_TLV("application/vnd.oma.lwm2m+tlv"),
	/** MIME 类型：application/vnd.oma.pal+xml */
	APPLICATION_VND_OMA_PAL_XML("application/vnd.oma.pal+xml"),
	/** MIME 类型：application/vnd.oma.poc.detailed-progress-report+xml */
	APPLICATION_VND_OMA_POC_DETAILED_PROGRESS_REPORT_XML("application/vnd.oma.poc.detailed-progress-report+xml"),
	/** MIME 类型：application/vnd.oma.poc.final-report+xml */
	APPLICATION_VND_OMA_POC_FINAL_REPORT_XML("application/vnd.oma.poc.final-report+xml"),
	/** MIME 类型：application/vnd.oma.poc.groups+xml */
	APPLICATION_VND_OMA_POC_GROUPS_XML("application/vnd.oma.poc.groups+xml"),
	/** MIME 类型：application/vnd.oma.poc.invocation-descriptor+xml */
	APPLICATION_VND_OMA_POC_INVOCATION_DESCRIPTOR_XML("application/vnd.oma.poc.invocation-descriptor+xml"),
	/** MIME 类型：application/vnd.oma.poc.optimized-progress-report+xml */
	APPLICATION_VND_OMA_POC_OPTIMIZED_PROGRESS_REPORT_XML("application/vnd.oma.poc.optimized-progress-report+xml"),
	/** MIME 类型：application/vnd.oma.push */
	APPLICATION_VND_OMA_PUSH("application/vnd.oma.push"),
	/** MIME 类型：application/vnd.oma.scidm.messages+xml */
	APPLICATION_VND_OMA_SCIDM_MESSAGES_XML("application/vnd.oma.scidm.messages+xml"),
	/** MIME 类型：application/vnd.oma.xcap-directory+xml */
	APPLICATION_VND_OMA_XCAP_DIRECTORY_XML("application/vnd.oma.xcap-directory+xml"),
	/** MIME 类型：application/vnd.omads-email+xml */
	APPLICATION_VND_OMADS_EMAIL_XML("application/vnd.omads-email+xml"),
	/** MIME 类型：application/vnd.omads-file+xml */
	APPLICATION_VND_OMADS_FILE_XML("application/vnd.omads-file+xml"),
	/** MIME 类型：application/vnd.omads-folder+xml */
	APPLICATION_VND_OMADS_FOLDER_XML("application/vnd.omads-folder+xml"),
	/** MIME 类型：application/vnd.omaloc-supl-init */
	APPLICATION_VND_OMALOC_SUPL_INIT("application/vnd.omaloc-supl-init"),
	/** MIME 类型：application/vnd.oma-scws-config */
	APPLICATION_VND_OMA_SCWS_CONFIG("application/vnd.oma-scws-config"),
	/** MIME 类型：application/vnd.oma-scws-http-request */
	APPLICATION_VND_OMA_SCWS_HTTP_REQUEST("application/vnd.oma-scws-http-request"),
	/** MIME 类型：application/vnd.oma-scws-http-response */
	APPLICATION_VND_OMA_SCWS_HTTP_RESPONSE("application/vnd.oma-scws-http-response"),
	/** MIME 类型：application/vnd.oms.cellular-cose-content+cbor */
	APPLICATION_VND_OMS_CELLULAR_COSE_CONTENT_CBOR("application/vnd.oms.cellular-cose-content+cbor"),
	/** MIME 类型：application/vnd.onepager */
	APPLICATION_VND_ONEPAGER("application/vnd.onepager"),
	/** MIME 类型：application/vnd.onepagertamp */
	APPLICATION_VND_ONEPAGERTAMP("application/vnd.onepagertamp"),
	/** MIME 类型：application/vnd.onepagertamx */
	APPLICATION_VND_ONEPAGERTAMX("application/vnd.onepagertamx"),
	/** MIME 类型：application/vnd.onepagertat */
	APPLICATION_VND_ONEPAGERTAT("application/vnd.onepagertat"),
	/** MIME 类型：application/vnd.onepagertatp */
	APPLICATION_VND_ONEPAGERTATP("application/vnd.onepagertatp"),
	/** MIME 类型：application/vnd.onepagertatx */
	APPLICATION_VND_ONEPAGERTATX("application/vnd.onepagertatx"),
	/** MIME 类型：application/vnd.onvif.metadata */
	APPLICATION_VND_ONVIF_METADATA("application/vnd.onvif.metadata"),
	/** MIME 类型：application/vnd.openblox.game-binary */
	APPLICATION_VND_OPENBLOX_GAME_BINARY("application/vnd.openblox.game-binary"),
	/** MIME 类型：application/vnd.openblox.game+xml */
	APPLICATION_VND_OPENBLOX_GAME_XML("application/vnd.openblox.game+xml"),
	/** MIME 类型：application/vnd.openeye.oeb */
	APPLICATION_VND_OPENEYE_OEB("application/vnd.openeye.oeb"),
	/** MIME 类型：application/vnd.openprinttag */
	APPLICATION_VND_OPENPRINTTAG("application/vnd.openprinttag"),
	/** MIME 类型：application/vnd.openstreetmap.data+xml */
	APPLICATION_VND_OPENSTREETMAP_DATA_XML("application/vnd.openstreetmap.data+xml"),
	/** MIME 类型：application/vnd.opentimestamps.ots */
	APPLICATION_VND_OPENTIMESTAMPS_OTS("application/vnd.opentimestamps.ots"),
	/** MIME 类型：application/vnd.openvpi.dspx+json */
	APPLICATION_VND_OPENVPI_DSPX_JSON("application/vnd.openvpi.dspx+json"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.custom-properties+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_CUSTOM_PROPERTIES_XML("application/vnd.openxmlformats-officedocument.custom-properties+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.customXmlProperties+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_CUSTOMXMLPROPERTIES_XML("application/vnd.openxmlformats-officedocument.customXmlProperties+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.drawing+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_DRAWING_XML("application/vnd.openxmlformats-officedocument.drawing+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.drawingml.chart+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_DRAWINGML_CHART_XML("application/vnd.openxmlformats-officedocument.drawingml.chart+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.drawingml.chartshapes+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_DRAWINGML_CHARTSHAPES_XML("application/vnd.openxmlformats-officedocument.drawingml.chartshapes+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.drawingml.diagramColors+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_DRAWINGML_DIAGRAMCOLORS_XML("application/vnd.openxmlformats-officedocument.drawingml.diagramColors+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.drawingml.diagramData+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_DRAWINGML_DIAGRAMDATA_XML("application/vnd.openxmlformats-officedocument.drawingml.diagramData+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.drawingml.diagramLayout+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_DRAWINGML_DIAGRAMLAYOUT_XML("application/vnd.openxmlformats-officedocument.drawingml.diagramLayout+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.drawingml.diagramStyle+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_DRAWINGML_DIAGRAMSTYLE_XML("application/vnd.openxmlformats-officedocument.drawingml.diagramStyle+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.extended-properties+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_EXTENDED_PROPERTIES_XML("application/vnd.openxmlformats-officedocument.extended-properties+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.commentAuthors+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_COMMENTAUTHORS_XML("application/vnd.openxmlformats-officedocument.presentationml.commentAuthors+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.comments+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_COMMENTS_XML("application/vnd.openxmlformats-officedocument.presentationml.comments+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.handoutMaster+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_HANDOUTMASTER_XML("application/vnd.openxmlformats-officedocument.presentationml.handoutMaster+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.notesMaster+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_NOTESMASTER_XML("application/vnd.openxmlformats-officedocument.presentationml.notesMaster+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.notesSlide+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_NOTESSLIDE_XML("application/vnd.openxmlformats-officedocument.presentationml.notesSlide+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.presentation */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_PRESENTATION("application/vnd.openxmlformats-officedocument.presentationml.presentation"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.presentation.main+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_PRESENTATION_MAIN_XML("application/vnd.openxmlformats-officedocument.presentationml.presentation.main+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.presProps+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_PRESPROPS_XML("application/vnd.openxmlformats-officedocument.presentationml.presProps+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.slide */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_SLIDE("application/vnd.openxmlformats-officedocument.presentationml.slide"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.slide+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_SLIDE_XML("application/vnd.openxmlformats-officedocument.presentationml.slide+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.slideLayout+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_SLIDELAYOUT_XML("application/vnd.openxmlformats-officedocument.presentationml.slideLayout+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.slideMaster+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_SLIDEMASTER_XML("application/vnd.openxmlformats-officedocument.presentationml.slideMaster+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.slideshow */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_SLIDESHOW("application/vnd.openxmlformats-officedocument.presentationml.slideshow"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.slideshow.main+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_SLIDESHOW_MAIN_XML("application/vnd.openxmlformats-officedocument.presentationml.slideshow.main+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.slideUpdateInfo+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_SLIDEUPDATEINFO_XML("application/vnd.openxmlformats-officedocument.presentationml.slideUpdateInfo+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.tableStyles+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_TABLESTYLES_XML("application/vnd.openxmlformats-officedocument.presentationml.tableStyles+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.tags+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_TAGS_XML("application/vnd.openxmlformats-officedocument.presentationml.tags+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.template */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_TEMPLATE("application/vnd.openxmlformats-officedocument.presentationml.template"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.template.main+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_TEMPLATE_MAIN_XML("application/vnd.openxmlformats-officedocument.presentationml.template.main+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.presentationml.viewProps+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_PRESENTATIONML_VIEWPROPS_XML("application/vnd.openxmlformats-officedocument.presentationml.viewProps+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.calcChain+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_CALCCHAIN_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.calcChain+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.chartsheet+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_CHARTSHEET_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.chartsheet+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.comments+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_COMMENTS_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.comments+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.connections+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_CONNECTIONS_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.connections+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.dialogsheet+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_DIALOGSHEET_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.dialogsheet+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.externalLink+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_EXTERNALLINK_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.externalLink+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.pivotCacheDefinition+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_PIVOTCACHEDEFINITION_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.pivotCacheDefinition+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.pivotCacheRecords+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_PIVOTCACHERECORDS_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.pivotCacheRecords+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.pivotTable+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_PIVOTTABLE_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.pivotTable+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.queryTable+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_QUERYTABLE_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.queryTable+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.revisionHeaders+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_REVISIONHEADERS_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.revisionHeaders+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.revisionLog+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_REVISIONLOG_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.revisionLog+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.sharedStrings+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_SHAREDSTRINGS_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.sharedStrings+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.sheet */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_SHEET("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.sheet.main+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_SHEET_MAIN_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet.main+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.sheetMetadata+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_SHEETMETADATA_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.sheetMetadata+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.styles+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_STYLES_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.styles+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.table+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_TABLE_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.table+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.tableSingleCells+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_TABLESINGLECELLS_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.tableSingleCells+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.template */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_TEMPLATE("application/vnd.openxmlformats-officedocument.spreadsheetml.template"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.template.main+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_TEMPLATE_MAIN_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.template.main+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.userNames+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_USERNAMES_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.userNames+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.volatileDependencies+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_VOLATILEDEPENDENCIES_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.volatileDependencies+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.spreadsheetml.worksheet+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML_WORKSHEET_XML("application/vnd.openxmlformats-officedocument.spreadsheetml.worksheet+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.theme+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_THEME_XML("application/vnd.openxmlformats-officedocument.theme+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.themeOverride+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_THEMEOVERRIDE_XML("application/vnd.openxmlformats-officedocument.themeOverride+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.vmlDrawing */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_VMLDRAWING("application/vnd.openxmlformats-officedocument.vmlDrawing"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.wordprocessingml.comments+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_COMMENTS_XML("application/vnd.openxmlformats-officedocument.wordprocessingml.comments+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.wordprocessingml.document */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT("application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.wordprocessingml.document.glossary+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT_GLOSSARY_XML("application/vnd.openxmlformats-officedocument.wordprocessingml.document.glossary+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.wordprocessingml.document.main+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_DOCUMENT_MAIN_XML("application/vnd.openxmlformats-officedocument.wordprocessingml.document.main+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.wordprocessingml.endnotes+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_ENDNOTES_XML("application/vnd.openxmlformats-officedocument.wordprocessingml.endnotes+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.wordprocessingml.fontTable+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_FONTTABLE_XML("application/vnd.openxmlformats-officedocument.wordprocessingml.fontTable+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.wordprocessingml.footer+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_FOOTER_XML("application/vnd.openxmlformats-officedocument.wordprocessingml.footer+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.wordprocessingml.footnotes+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_FOOTNOTES_XML("application/vnd.openxmlformats-officedocument.wordprocessingml.footnotes+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.wordprocessingml.numbering+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_NUMBERING_XML("application/vnd.openxmlformats-officedocument.wordprocessingml.numbering+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.wordprocessingml.settings+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_SETTINGS_XML("application/vnd.openxmlformats-officedocument.wordprocessingml.settings+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.wordprocessingml.styles+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_STYLES_XML("application/vnd.openxmlformats-officedocument.wordprocessingml.styles+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.wordprocessingml.template */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_TEMPLATE("application/vnd.openxmlformats-officedocument.wordprocessingml.template"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.wordprocessingml.template.main+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_TEMPLATE_MAIN_XML("application/vnd.openxmlformats-officedocument.wordprocessingml.template.main+xml"),
	/** MIME 类型：application/vnd.openxmlformats-officedocument.wordprocessingml.webSettings+xml */
	APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML_WEBSETTINGS_XML("application/vnd.openxmlformats-officedocument.wordprocessingml.webSettings+xml"),
	/** MIME 类型：application/vnd.openxmlformats-package.core-properties+xml */
	APPLICATION_VND_OPENXMLFORMATS_PACKAGE_CORE_PROPERTIES_XML("application/vnd.openxmlformats-package.core-properties+xml"),
	/** MIME 类型：application/vnd.openxmlformats-package.digital-signature-xmlsignature+xml */
	APPLICATION_VND_OPENXMLFORMATS_PACKAGE_DIGITAL_SIGNATURE_XMLSIGNATURE_XML("application/vnd.openxmlformats-package.digital-signature-xmlsignature+xml"),
	/** MIME 类型：application/vnd.openxmlformats-package.relationships+xml */
	APPLICATION_VND_OPENXMLFORMATS_PACKAGE_RELATIONSHIPS_XML("application/vnd.openxmlformats-package.relationships+xml"),
	/** MIME 类型：application/vnd.oracle.resource+json */
	APPLICATION_VND_ORACLE_RESOURCE_JSON("application/vnd.oracle.resource+json"),
	/** MIME 类型：application/vnd.orange.indata */
	APPLICATION_VND_ORANGE_INDATA("application/vnd.orange.indata"),
	/** MIME 类型：application/vnd.osa.netdeploy */
	APPLICATION_VND_OSA_NETDEPLOY("application/vnd.osa.netdeploy"),
	/** MIME 类型：application/vnd.osgeo.mapguide.package */
	APPLICATION_VND_OSGEO_MAPGUIDE_PACKAGE("application/vnd.osgeo.mapguide.package"),
	/** MIME 类型：application/vnd.osgi.bundle */
	APPLICATION_VND_OSGI_BUNDLE("application/vnd.osgi.bundle"),
	/** MIME 类型：application/vnd.osgi.dp */
	APPLICATION_VND_OSGI_DP("application/vnd.osgi.dp"),
	/** MIME 类型：application/vnd.osgi.subsystem */
	APPLICATION_VND_OSGI_SUBSYSTEM("application/vnd.osgi.subsystem"),
	/** MIME 类型：application/vnd.otps.ct-kip+xml */
	APPLICATION_VND_OTPS_CT_KIP_XML("application/vnd.otps.ct-kip+xml"),
	/** MIME 类型：application/vnd.oxli.countgraph */
	APPLICATION_VND_OXLI_COUNTGRAPH("application/vnd.oxli.countgraph"),
	/** MIME 类型：application/vnd.pagerduty+json */
	APPLICATION_VND_PAGERDUTY_JSON("application/vnd.pagerduty+json"),
	/** MIME 类型：application/vnd.palm */
	APPLICATION_VND_PALM("application/vnd.palm"),
	/** MIME 类型：application/vnd.panoply */
	APPLICATION_VND_PANOPLY("application/vnd.panoply"),
	/** MIME 类型：application/vnd.paos.xml */
	APPLICATION_VND_PAOS_XML("application/vnd.paos.xml"),
	/** MIME 类型：application/vnd.patentdive */
	APPLICATION_VND_PATENTDIVE("application/vnd.patentdive"),
	/** MIME 类型：application/vnd.patientecommsdoc */
	APPLICATION_VND_PATIENTECOMMSDOC("application/vnd.patientecommsdoc"),
	/** MIME 类型：application/vnd.pawaafile */
	APPLICATION_VND_PAWAAFILE("application/vnd.pawaafile"),
	/** MIME 类型：application/vnd.pcos */
	APPLICATION_VND_PCOS("application/vnd.pcos"),
	/** MIME 类型：application/vnd.pg.format */
	APPLICATION_VND_PG_FORMAT("application/vnd.pg.format"),
	/** MIME 类型：application/vnd.pg.osasli */
	APPLICATION_VND_PG_OSASLI("application/vnd.pg.osasli"),
	/** MIME 类型：application/vnd.piaccess.application-licence */
	APPLICATION_VND_PIACCESS_APPLICATION_LICENCE("application/vnd.piaccess.application-licence"),
	/** MIME 类型：application/vnd.picsel */
	APPLICATION_VND_PICSEL("application/vnd.picsel"),
	/** MIME 类型：application/vnd.pmi.widget */
	APPLICATION_VND_PMI_WIDGET("application/vnd.pmi.widget"),
	/** MIME 类型：application/vnd.pmtiles */
	APPLICATION_VND_PMTILES("application/vnd.pmtiles"),
	/** MIME 类型：application/vnd.poc.group-advertisement+xml */
	APPLICATION_VND_POC_GROUP_ADVERTISEMENT_XML("application/vnd.poc.group-advertisement+xml"),
	/** MIME 类型：application/vnd.pocketlearn */
	APPLICATION_VND_POCKETLEARN("application/vnd.pocketlearn"),
	/** MIME 类型：application/vnd.powerbuilder6 */
	APPLICATION_VND_POWERBUILDER6("application/vnd.powerbuilder6"),
	/** MIME 类型：application/vnd.powerbuilder6-s */
	APPLICATION_VND_POWERBUILDER6_S("application/vnd.powerbuilder6-s"),
	/** MIME 类型：application/vnd.powerbuilder7 */
	APPLICATION_VND_POWERBUILDER7("application/vnd.powerbuilder7"),
	/** MIME 类型：application/vnd.powerbuilder75 */
	APPLICATION_VND_POWERBUILDER75("application/vnd.powerbuilder75"),
	/** MIME 类型：application/vnd.powerbuilder75-s */
	APPLICATION_VND_POWERBUILDER75_S("application/vnd.powerbuilder75-s"),
	/** MIME 类型：application/vnd.powerbuilder7-s */
	APPLICATION_VND_POWERBUILDER7_S("application/vnd.powerbuilder7-s"),
	/** MIME 类型：application/vnd.pp.systemverify+xml */
	APPLICATION_VND_PP_SYSTEMVERIFY_XML("application/vnd.pp.systemverify+xml"),
	/** MIME 类型：application/vnd.preminet */
	APPLICATION_VND_PREMINET("application/vnd.preminet"),
	/** MIME 类型：application/vnd.previewsystems.box */
	APPLICATION_VND_PREVIEWSYSTEMS_BOX("application/vnd.previewsystems.box"),
	/** MIME 类型：application/vnd.project-graph */
	APPLICATION_VND_PROJECT_GRAPH("application/vnd.project-graph"),
	/** MIME 类型：application/vnd.proteus.magazine */
	APPLICATION_VND_PROTEUS_MAGAZINE("application/vnd.proteus.magazine"),
	/** MIME 类型：application/vnd.psfs */
	APPLICATION_VND_PSFS("application/vnd.psfs"),
	/** MIME 类型：application/vnd.pt.mundusmundi */
	APPLICATION_VND_PT_MUNDUSMUNDI("application/vnd.pt.mundusmundi"),
	/** MIME 类型：application/vnd.publishare-delta-tree */
	APPLICATION_VND_PUBLISHARE_DELTA_TREE("application/vnd.publishare-delta-tree"),
	/** MIME 类型：application/vnd.pvi.ptid1 */
	APPLICATION_VND_PVI_PTID1("application/vnd.pvi.ptid1"),
	/** MIME 类型：application/vnd.pwg-multiplexed */
	APPLICATION_VND_PWG_MULTIPLEXED("application/vnd.pwg-multiplexed"),
	/** MIME 类型：application/vnd.pwg-xhtml-print+xml */
	APPLICATION_VND_PWG_XHTML_PRINT_XML("application/vnd.pwg-xhtml-print+xml"),
	/** MIME 类型：application/vnd.pyon+json */
	APPLICATION_VND_PYON_JSON("application/vnd.pyon+json"),
	/** MIME 类型：application/vnd.qualcomm.brew-app-res */
	APPLICATION_VND_QUALCOMM_BREW_APP_RES("application/vnd.qualcomm.brew-app-res"),
	/** MIME 类型：application/vnd.quarantainenet */
	APPLICATION_VND_QUARANTAINENET("application/vnd.quarantainenet"),
	/** MIME 类型：application/vnd.Quark.QuarkXPress */
	APPLICATION_VND_QUARK_QUARKXPRESS("application/vnd.Quark.QuarkXPress"),
	/** MIME 类型：application/vnd.quobject-quoxdocument */
	APPLICATION_VND_QUOBJECT_QUOXDOCUMENT("application/vnd.quobject-quoxdocument"),
	/** MIME 类型：application/vnd.R74n.sandboxels+json */
	APPLICATION_VND_R74N_SANDBOXELS_JSON("application/vnd.R74n.sandboxels+json"),
	/** MIME 类型：application/vnd.radisys.moml+xml */
	APPLICATION_VND_RADISYS_MOML_XML("application/vnd.radisys.moml+xml"),
	/** MIME 类型：application/vnd.radisys.msml-audit-conf+xml */
	APPLICATION_VND_RADISYS_MSML_AUDIT_CONF_XML("application/vnd.radisys.msml-audit-conf+xml"),
	/** MIME 类型：application/vnd.radisys.msml-audit-conn+xml */
	APPLICATION_VND_RADISYS_MSML_AUDIT_CONN_XML("application/vnd.radisys.msml-audit-conn+xml"),
	/** MIME 类型：application/vnd.radisys.msml-audit-dialog+xml */
	APPLICATION_VND_RADISYS_MSML_AUDIT_DIALOG_XML("application/vnd.radisys.msml-audit-dialog+xml"),
	/** MIME 类型：application/vnd.radisys.msml-audit-stream+xml */
	APPLICATION_VND_RADISYS_MSML_AUDIT_STREAM_XML("application/vnd.radisys.msml-audit-stream+xml"),
	/** MIME 类型：application/vnd.radisys.msml-audit+xml */
	APPLICATION_VND_RADISYS_MSML_AUDIT_XML("application/vnd.radisys.msml-audit+xml"),
	/** MIME 类型：application/vnd.radisys.msml-conf+xml */
	APPLICATION_VND_RADISYS_MSML_CONF_XML("application/vnd.radisys.msml-conf+xml"),
	/** MIME 类型：application/vnd.radisys.msml-dialog-base+xml */
	APPLICATION_VND_RADISYS_MSML_DIALOG_BASE_XML("application/vnd.radisys.msml-dialog-base+xml"),
	/** MIME 类型：application/vnd.radisys.msml-dialog-fax-detect+xml */
	APPLICATION_VND_RADISYS_MSML_DIALOG_FAX_DETECT_XML("application/vnd.radisys.msml-dialog-fax-detect+xml"),
	/** MIME 类型：application/vnd.radisys.msml-dialog-fax-sendrecv+xml */
	APPLICATION_VND_RADISYS_MSML_DIALOG_FAX_SENDRECV_XML("application/vnd.radisys.msml-dialog-fax-sendrecv+xml"),
	/** MIME 类型：application/vnd.radisys.msml-dialog-group+xml */
	APPLICATION_VND_RADISYS_MSML_DIALOG_GROUP_XML("application/vnd.radisys.msml-dialog-group+xml"),
	/** MIME 类型：application/vnd.radisys.msml-dialog-speech+xml */
	APPLICATION_VND_RADISYS_MSML_DIALOG_SPEECH_XML("application/vnd.radisys.msml-dialog-speech+xml"),
	/** MIME 类型：application/vnd.radisys.msml-dialog-transform+xml */
	APPLICATION_VND_RADISYS_MSML_DIALOG_TRANSFORM_XML("application/vnd.radisys.msml-dialog-transform+xml"),
	/** MIME 类型：application/vnd.radisys.msml-dialog+xml */
	APPLICATION_VND_RADISYS_MSML_DIALOG_XML("application/vnd.radisys.msml-dialog+xml"),
	/** MIME 类型：application/vnd.radisys.msml+xml */
	APPLICATION_VND_RADISYS_MSML_XML("application/vnd.radisys.msml+xml"),
	/** MIME 类型：application/vnd.rainstor.data */
	APPLICATION_VND_RAINSTOR_DATA("application/vnd.rainstor.data"),
	/** MIME 类型：application/vnd.rapid */
	APPLICATION_VND_RAPID("application/vnd.rapid"),
	/** MIME 类型：application/vnd.rar */
	APPLICATION_VND_RAR("application/vnd.rar"),
	/** MIME 类型：application/vnd.realvnc.bed */
	APPLICATION_VND_REALVNC_BED("application/vnd.realvnc.bed"),
	/** MIME 类型：application/vnd.recordare.musicxml */
	APPLICATION_VND_RECORDARE_MUSICXML("application/vnd.recordare.musicxml"),
	/** MIME 类型：application/vnd.recordare.musicxml+xml */
	APPLICATION_VND_RECORDARE_MUSICXML_XML("application/vnd.recordare.musicxml+xml"),
	/** MIME 类型：application/vnd.relpipe */
	APPLICATION_VND_RELPIPE("application/vnd.relpipe"),
	/** MIME 类型：application/vnd.RenLearn.rlprint */
	APPLICATION_VND_RENLEARN_RLPRINT("application/vnd.RenLearn.rlprint"),
	/** MIME 类型：application/vnd.resilient.logic */
	APPLICATION_VND_RESILIENT_LOGIC("application/vnd.resilient.logic"),
	/** MIME 类型：application/vnd.restful+json */
	APPLICATION_VND_RESTFUL_JSON("application/vnd.restful+json"),
	/** MIME 类型：application/vnd.rig.cryptonote */
	APPLICATION_VND_RIG_CRYPTONOTE("application/vnd.rig.cryptonote"),
	/** MIME 类型：application/vnd.route66.link66+xml */
	APPLICATION_VND_ROUTE66_LINK66_XML("application/vnd.route66.link66+xml"),
	/** MIME 类型：application/vnd.rs-274x */
	APPLICATION_VND_RS_274X("application/vnd.rs-274x"),
	/** MIME 类型：application/vnd.ruckus.download */
	APPLICATION_VND_RUCKUS_DOWNLOAD("application/vnd.ruckus.download"),
	/** MIME 类型：application/vnd.s3sms */
	APPLICATION_VND_S3SMS("application/vnd.s3sms"),
	/** MIME 类型：application/vnd.sailingtracker.track */
	APPLICATION_VND_SAILINGTRACKER_TRACK("application/vnd.sailingtracker.track"),
	/** MIME 类型：application/vnd.sar */
	APPLICATION_VND_SAR("application/vnd.sar"),
	/** MIME 类型：application/vnd.sbm.cid */
	APPLICATION_VND_SBM_CID("application/vnd.sbm.cid"),
	/** MIME 类型：application/vnd.sbm.mid2 */
	APPLICATION_VND_SBM_MID2("application/vnd.sbm.mid2"),
	/** MIME 类型：application/vnd.scribus */
	APPLICATION_VND_SCRIBUS("application/vnd.scribus"),
	/** MIME 类型：application/vnd.sealed.3df */
	APPLICATION_VND_SEALED_3DF("application/vnd.sealed.3df"),
	/** MIME 类型：application/vnd.sealed.csf */
	APPLICATION_VND_SEALED_CSF("application/vnd.sealed.csf"),
	/** MIME 类型：application/vnd.sealed.doc */
	APPLICATION_VND_SEALED_DOC("application/vnd.sealed.doc"),
	/** MIME 类型：application/vnd.sealed.eml */
	APPLICATION_VND_SEALED_EML("application/vnd.sealed.eml"),
	/** MIME 类型：application/vnd.sealed.mht */
	APPLICATION_VND_SEALED_MHT("application/vnd.sealed.mht"),
	/** MIME 类型：application/vnd.sealed.net */
	APPLICATION_VND_SEALED_NET("application/vnd.sealed.net"),
	/** MIME 类型：application/vnd.sealed.ppt */
	APPLICATION_VND_SEALED_PPT("application/vnd.sealed.ppt"),
	/** MIME 类型：application/vnd.sealed.tiff */
	APPLICATION_VND_SEALED_TIFF("application/vnd.sealed.tiff"),
	/** MIME 类型：application/vnd.sealed.xls */
	APPLICATION_VND_SEALED_XLS("application/vnd.sealed.xls"),
	/** MIME 类型：application/vnd.sealedmedia.softseal.html */
	APPLICATION_VND_SEALEDMEDIA_SOFTSEAL_HTML("application/vnd.sealedmedia.softseal.html"),
	/** MIME 类型：application/vnd.sealedmedia.softseal.pdf */
	APPLICATION_VND_SEALEDMEDIA_SOFTSEAL_PDF("application/vnd.sealedmedia.softseal.pdf"),
	/** MIME 类型：application/vnd.seemail */
	APPLICATION_VND_SEEMAIL("application/vnd.seemail"),
	/** MIME 类型：application/vnd.seis+json */
	APPLICATION_VND_SEIS_JSON("application/vnd.seis+json"),
	/** MIME 类型：application/vnd.sema */
	APPLICATION_VND_SEMA("application/vnd.sema"),
	/** MIME 类型：application/vnd.semd */
	APPLICATION_VND_SEMD("application/vnd.semd"),
	/** MIME 类型：application/vnd.semf */
	APPLICATION_VND_SEMF("application/vnd.semf"),
	/** MIME 类型：application/vnd.shade-save-file */
	APPLICATION_VND_SHADE_SAVE_FILE("application/vnd.shade-save-file"),
	/** MIME 类型：application/vnd.shana.informed.formdata */
	APPLICATION_VND_SHANA_INFORMED_FORMDATA("application/vnd.shana.informed.formdata"),
	/** MIME 类型：application/vnd.shana.informed.formtemplate */
	APPLICATION_VND_SHANA_INFORMED_FORMTEMPLATE("application/vnd.shana.informed.formtemplate"),
	/** MIME 类型：application/vnd.shana.informed.interchange */
	APPLICATION_VND_SHANA_INFORMED_INTERCHANGE("application/vnd.shana.informed.interchange"),
	/** MIME 类型：application/vnd.shana.informed.package */
	APPLICATION_VND_SHANA_INFORMED_PACKAGE("application/vnd.shana.informed.package"),
	/** MIME 类型：application/vnd.shootproof+json */
	APPLICATION_VND_SHOOTPROOF_JSON("application/vnd.shootproof+json"),
	/** MIME 类型：application/vnd.shopkick+json */
	APPLICATION_VND_SHOPKICK_JSON("application/vnd.shopkick+json"),
	/** MIME 类型：application/vnd.shp */
	APPLICATION_VND_SHP("application/vnd.shp"),
	/** MIME 类型：application/vnd.shx */
	APPLICATION_VND_SHX("application/vnd.shx"),
	/** MIME 类型：application/vnd.sigrok.session */
	APPLICATION_VND_SIGROK_SESSION("application/vnd.sigrok.session"),
	/** MIME 类型：application/vnd.SimTech-MindMapper */
	APPLICATION_VND_SIMTECH_MINDMAPPER("application/vnd.SimTech-MindMapper"),
	/** MIME 类型：application/vnd.siren+json */
	APPLICATION_VND_SIREN_JSON("application/vnd.siren+json"),
	/** MIME 类型：application/vnd.sirtx.vmv0 */
	APPLICATION_VND_SIRTX_VMV0("application/vnd.sirtx.vmv0"),
	/** MIME 类型：application/vnd.sketchometry */
	APPLICATION_VND_SKETCHOMETRY("application/vnd.sketchometry"),
	/** MIME 类型：application/vnd.smaf */
	APPLICATION_VND_SMAF("application/vnd.smaf"),
	/** MIME 类型：application/vnd.smart.notebook */
	APPLICATION_VND_SMART_NOTEBOOK("application/vnd.smart.notebook"),
	/** MIME 类型：application/vnd.smart.teacher */
	APPLICATION_VND_SMART_TEACHER("application/vnd.smart.teacher"),
	/** MIME 类型：application/vnd.smintio.portals.archive */
	APPLICATION_VND_SMINTIO_PORTALS_ARCHIVE("application/vnd.smintio.portals.archive"),
	/** MIME 类型：application/vnd.snesdev-page-table */
	APPLICATION_VND_SNESDEV_PAGE_TABLE("application/vnd.snesdev-page-table"),
	/** MIME 类型：application/vnd.software602.filler.form+xml */
	APPLICATION_VND_SOFTWARE602_FILLER_FORM_XML("application/vnd.software602.filler.form+xml"),
	/** MIME 类型：application/vnd.software602.filler.form-xml-zip */
	APPLICATION_VND_SOFTWARE602_FILLER_FORM_XML_ZIP("application/vnd.software602.filler.form-xml-zip"),
	/** MIME 类型：application/vnd.solent.sdkm+xml */
	APPLICATION_VND_SOLENT_SDKM_XML("application/vnd.solent.sdkm+xml"),
	/** MIME 类型：application/vnd.spotfire.dxp */
	APPLICATION_VND_SPOTFIRE_DXP("application/vnd.spotfire.dxp"),
	/** MIME 类型：application/vnd.spotfire.sfs */
	APPLICATION_VND_SPOTFIRE_SFS("application/vnd.spotfire.sfs"),
	/** MIME 类型：application/vnd.sqlite3 */
	APPLICATION_VND_SQLITE3("application/vnd.sqlite3"),
	/** MIME 类型：application/vnd.sss-cod */
	APPLICATION_VND_SSS_COD("application/vnd.sss-cod"),
	/** MIME 类型：application/vnd.sss-dtf */
	APPLICATION_VND_SSS_DTF("application/vnd.sss-dtf"),
	/** MIME 类型：application/vnd.sss-ntf */
	APPLICATION_VND_SSS_NTF("application/vnd.sss-ntf"),
	/** MIME 类型：application/vnd.stepmania.package */
	APPLICATION_VND_STEPMANIA_PACKAGE("application/vnd.stepmania.package"),
	/** MIME 类型：application/vnd.stepmania.stepchart */
	APPLICATION_VND_STEPMANIA_STEPCHART("application/vnd.stepmania.stepchart"),
	/** MIME 类型：application/vnd.street-stream */
	APPLICATION_VND_STREET_STREAM("application/vnd.street-stream"),
	/** MIME 类型：application/vnd.sun.wadl+xml */
	APPLICATION_VND_SUN_WADL_XML("application/vnd.sun.wadl+xml"),
	/** MIME 类型：application/vnd.superfile.super */
	APPLICATION_VND_SUPERFILE_SUPER("application/vnd.superfile.super"),
	/** MIME 类型：application/vnd.sus-calendar */
	APPLICATION_VND_SUS_CALENDAR("application/vnd.sus-calendar"),
	/** MIME 类型：application/vnd.svd */
	APPLICATION_VND_SVD("application/vnd.svd"),
	/** MIME 类型：application/vnd.swiftview-ics */
	APPLICATION_VND_SWIFTVIEW_ICS("application/vnd.swiftview-ics"),
	/** MIME 类型：application/vnd.sybyl.mol2 */
	APPLICATION_VND_SYBYL_MOL2("application/vnd.sybyl.mol2"),
	/** MIME 类型：application/vnd.sycle+xml */
	APPLICATION_VND_SYCLE_XML("application/vnd.sycle+xml"),
	/** MIME 类型：application/vnd.syft+json */
	APPLICATION_VND_SYFT_JSON("application/vnd.syft+json"),
	/** MIME 类型：application/vnd.syncml.dm.notification */
	APPLICATION_VND_SYNCML_DM_NOTIFICATION("application/vnd.syncml.dm.notification"),
	/** MIME 类型：application/vnd.syncml.dmddf+xml */
	APPLICATION_VND_SYNCML_DMDDF_XML("application/vnd.syncml.dmddf+xml"),
	/** MIME 类型：application/vnd.syncml.dmtnds+wbxml */
	APPLICATION_VND_SYNCML_DMTNDS_WBXML("application/vnd.syncml.dmtnds+wbxml"),
	/** MIME 类型：application/vnd.syncml.dmtnds+xml */
	APPLICATION_VND_SYNCML_DMTNDS_XML("application/vnd.syncml.dmtnds+xml"),
	/** MIME 类型：application/vnd.syncml.dmddf+wbxml */
	APPLICATION_VND_SYNCML_DMDDF_WBXML("application/vnd.syncml.dmddf+wbxml"),
	/** MIME 类型：application/vnd.syncml.dm+wbxml */
	APPLICATION_VND_SYNCML_DM_WBXML("application/vnd.syncml.dm+wbxml"),
	/** MIME 类型：application/vnd.syncml.dm+xml */
	APPLICATION_VND_SYNCML_DM_XML("application/vnd.syncml.dm+xml"),
	/** MIME 类型：application/vnd.syncml.ds.notification */
	APPLICATION_VND_SYNCML_DS_NOTIFICATION("application/vnd.syncml.ds.notification"),
	/** MIME 类型：application/vnd.syncml+xml */
	APPLICATION_VND_SYNCML_XML("application/vnd.syncml+xml"),
	/** MIME 类型：application/vnd.tableschema+json */
	APPLICATION_VND_TABLESCHEMA_JSON("application/vnd.tableschema+json"),
	/** MIME 类型：application/vnd.tao.intent-module-archive */
	APPLICATION_VND_TAO_INTENT_MODULE_ARCHIVE("application/vnd.tao.intent-module-archive"),
	/** MIME 类型：application/vnd.tcpdump.pcap */
	APPLICATION_VND_TCPDUMP_PCAP("application/vnd.tcpdump.pcap"),
	/** MIME 类型：application/vnd.think-cell.ppttc+json */
	APPLICATION_VND_THINK_CELL_PPTTC_JSON("application/vnd.think-cell.ppttc+json"),
	/** MIME 类型：application/vnd.tml */
	APPLICATION_VND_TML("application/vnd.tml"),
	/** MIME 类型：application/vnd.tmd.mediaflex.api+xml */
	APPLICATION_VND_TMD_MEDIAFLEX_API_XML("application/vnd.tmd.mediaflex.api+xml"),
	/** MIME 类型：application/vnd.tmobile-livetv */
	APPLICATION_VND_TMOBILE_LIVETV("application/vnd.tmobile-livetv"),
	/** MIME 类型：application/vnd.tri.onesource */
	APPLICATION_VND_TRI_ONESOURCE("application/vnd.tri.onesource"),
	/** MIME 类型：application/vnd.trid.tpt */
	APPLICATION_VND_TRID_TPT("application/vnd.trid.tpt"),
	/** MIME 类型：application/vnd.triscape.mxs */
	APPLICATION_VND_TRISCAPE_MXS("application/vnd.triscape.mxs"),
	/** MIME 类型：application/vnd.trueapp */
	APPLICATION_VND_TRUEAPP("application/vnd.trueapp"),
	/** MIME 类型：application/vnd.truedoc */
	APPLICATION_VND_TRUEDOC("application/vnd.truedoc"),
	/** MIME 类型：application/vnd.ubisoft.webplayer */
	APPLICATION_VND_UBISOFT_WEBPLAYER("application/vnd.ubisoft.webplayer"),
	/** MIME 类型：application/vnd.ufdl */
	APPLICATION_VND_UFDL("application/vnd.ufdl"),
	/** MIME 类型：application/vnd.uic.dosipas.v1 */
	APPLICATION_VND_UIC_DOSIPAS_V1("application/vnd.uic.dosipas.v1"),
	/** MIME 类型：application/vnd.uic.dosipas.v2 */
	APPLICATION_VND_UIC_DOSIPAS_V2("application/vnd.uic.dosipas.v2"),
	/** MIME 类型：application/vnd.uic.osdm+json */
	APPLICATION_VND_UIC_OSDM_JSON("application/vnd.uic.osdm+json"),
	/** MIME 类型：application/vnd.uic.tlb-fcb */
	APPLICATION_VND_UIC_TLB_FCB("application/vnd.uic.tlb-fcb"),
	/** MIME 类型：application/vnd.uiq.theme */
	APPLICATION_VND_UIQ_THEME("application/vnd.uiq.theme"),
	/** MIME 类型：application/vnd.umajin */
	APPLICATION_VND_UMAJIN("application/vnd.umajin"),
	/** MIME 类型：application/vnd.unity */
	APPLICATION_VND_UNITY("application/vnd.unity"),
	/** MIME 类型：application/vnd.uoml+xml */
	APPLICATION_VND_UOML_XML("application/vnd.uoml+xml"),
	/** MIME 类型：application/vnd.uplanet.alert */
	APPLICATION_VND_UPLANET_ALERT("application/vnd.uplanet.alert"),
	/** MIME 类型：application/vnd.uplanet.alert-wbxml */
	APPLICATION_VND_UPLANET_ALERT_WBXML("application/vnd.uplanet.alert-wbxml"),
	/** MIME 类型：application/vnd.uplanet.bearer-choice */
	APPLICATION_VND_UPLANET_BEARER_CHOICE("application/vnd.uplanet.bearer-choice"),
	/** MIME 类型：application/vnd.uplanet.bearer-choice-wbxml */
	APPLICATION_VND_UPLANET_BEARER_CHOICE_WBXML("application/vnd.uplanet.bearer-choice-wbxml"),
	/** MIME 类型：application/vnd.uplanet.cacheop */
	APPLICATION_VND_UPLANET_CACHEOP("application/vnd.uplanet.cacheop"),
	/** MIME 类型：application/vnd.uplanet.cacheop-wbxml */
	APPLICATION_VND_UPLANET_CACHEOP_WBXML("application/vnd.uplanet.cacheop-wbxml"),
	/** MIME 类型：application/vnd.uplanet.channel */
	APPLICATION_VND_UPLANET_CHANNEL("application/vnd.uplanet.channel"),
	/** MIME 类型：application/vnd.uplanet.channel-wbxml */
	APPLICATION_VND_UPLANET_CHANNEL_WBXML("application/vnd.uplanet.channel-wbxml"),
	/** MIME 类型：application/vnd.uplanet.list */
	APPLICATION_VND_UPLANET_LIST("application/vnd.uplanet.list"),
	/** MIME 类型：application/vnd.uplanet.listcmd */
	APPLICATION_VND_UPLANET_LISTCMD("application/vnd.uplanet.listcmd"),
	/** MIME 类型：application/vnd.uplanet.listcmd-wbxml */
	APPLICATION_VND_UPLANET_LISTCMD_WBXML("application/vnd.uplanet.listcmd-wbxml"),
	/** MIME 类型：application/vnd.uplanet.list-wbxml */
	APPLICATION_VND_UPLANET_LIST_WBXML("application/vnd.uplanet.list-wbxml"),
	/** MIME 类型：application/vnd.uri-map */
	APPLICATION_VND_URI_MAP("application/vnd.uri-map"),
	/** MIME 类型：application/vnd.uplanet.signal */
	APPLICATION_VND_UPLANET_SIGNAL("application/vnd.uplanet.signal"),
	/** MIME 类型：application/vnd.valve.source.material */
	APPLICATION_VND_VALVE_SOURCE_MATERIAL("application/vnd.valve.source.material"),
	/** MIME 类型：application/vnd.vcx */
	APPLICATION_VND_VCX("application/vnd.vcx"),
	/** MIME 类型：application/vnd.vd-study */
	APPLICATION_VND_VD_STUDY("application/vnd.vd-study"),
	/** MIME 类型：application/vnd.vectorworks */
	APPLICATION_VND_VECTORWORKS("application/vnd.vectorworks"),
	/** MIME 类型：application/vnd.vel+json */
	APPLICATION_VND_VEL_JSON("application/vnd.vel+json"),
	/** MIME 类型：application/vnd.veraison.tsm-report+cbor */
	APPLICATION_VND_VERAISON_TSM_REPORT_CBOR("application/vnd.veraison.tsm-report+cbor"),
	/** MIME 类型：application/vnd.veraison.tsm-report+json */
	APPLICATION_VND_VERAISON_TSM_REPORT_JSON("application/vnd.veraison.tsm-report+json"),
	/** MIME 类型：application/vnd.verifier-attestation+jwt */
	APPLICATION_VND_VERIFIER_ATTESTATION_JWT("application/vnd.verifier-attestation+jwt"),
	/** MIME 类型：application/vnd.verimatrix.vcas */
	APPLICATION_VND_VERIMATRIX_VCAS("application/vnd.verimatrix.vcas"),
	/** MIME 类型：application/vnd.veritone.aion+json */
	APPLICATION_VND_VERITONE_AION_JSON("application/vnd.veritone.aion+json"),
	/** MIME 类型：application/vnd.veryant.thin */
	APPLICATION_VND_VERYANT_THIN("application/vnd.veryant.thin"),
	/** MIME 类型：application/vnd.ves.encrypted */
	APPLICATION_VND_VES_ENCRYPTED("application/vnd.ves.encrypted"),
	/** MIME 类型：application/vnd.vidsoft.vidconference */
	APPLICATION_VND_VIDSOFT_VIDCONFERENCE("application/vnd.vidsoft.vidconference"),
	/** MIME 类型：application/vnd.visio */
	APPLICATION_VND_VISIO("application/vnd.visio"),
	/** MIME 类型：application/vnd.visionary */
	APPLICATION_VND_VISIONARY("application/vnd.visionary"),
	/** MIME 类型：application/vnd.vividence.scriptfile */
	APPLICATION_VND_VIVIDENCE_SCRIPTFILE("application/vnd.vividence.scriptfile"),
	/** MIME 类型：application/vnd.vocalshaper.vsp4 */
	APPLICATION_VND_VOCALSHAPER_VSP4("application/vnd.vocalshaper.vsp4"),
	/** MIME 类型：application/vnd.vsf */
	APPLICATION_VND_VSF("application/vnd.vsf"),
	/** MIME 类型：application/vnd.vuq */
	APPLICATION_VND_VUQ("application/vnd.vuq"),
	/** MIME 类型：application/vnd.wantverse */
	APPLICATION_VND_WANTVERSE("application/vnd.wantverse"),
	/** MIME 类型：application/vnd.wap.sic */
	APPLICATION_VND_WAP_SIC("application/vnd.wap.sic"),
	/** MIME 类型：application/vnd.wap.slc */
	APPLICATION_VND_WAP_SLC("application/vnd.wap.slc"),
	/** MIME 类型：application/vnd.wap.wbxml */
	APPLICATION_VND_WAP_WBXML("application/vnd.wap.wbxml"),
	/** MIME 类型：application/vnd.wap.wmlc */
	APPLICATION_VND_WAP_WMLC("application/vnd.wap.wmlc"),
	/** MIME 类型：application/vnd.wap.wmlscriptc */
	APPLICATION_VND_WAP_WMLSCRIPTC("application/vnd.wap.wmlscriptc"),
	/** MIME 类型：application/vnd.wasmflow.wafl */
	APPLICATION_VND_WASMFLOW_WAFL("application/vnd.wasmflow.wafl"),
	/** MIME 类型：application/vnd.webturbo */
	APPLICATION_VND_WEBTURBO("application/vnd.webturbo"),
	/** MIME 类型：application/vnd.wfa.dpp */
	APPLICATION_VND_WFA_DPP("application/vnd.wfa.dpp"),
	/** MIME 类型：application/vnd.wfa.p2p */
	APPLICATION_VND_WFA_P2P("application/vnd.wfa.p2p"),
	/** MIME 类型：application/vnd.wfa.wsc */
	APPLICATION_VND_WFA_WSC("application/vnd.wfa.wsc"),
	/** MIME 类型：application/vnd.windows.devicepairing */
	APPLICATION_VND_WINDOWS_DEVICEPAIRING("application/vnd.windows.devicepairing"),
	/** MIME 类型：application/vnd.wmap */
	APPLICATION_VND_WMAP("application/vnd.wmap"),
	/** MIME 类型：application/vnd.wmc */
	APPLICATION_VND_WMC("application/vnd.wmc"),
	/** MIME 类型：application/vnd.wmf.bootstrap */
	APPLICATION_VND_WMF_BOOTSTRAP("application/vnd.wmf.bootstrap"),
	/** MIME 类型：application/vnd.wolfram.mathematica */
	APPLICATION_VND_WOLFRAM_MATHEMATICA("application/vnd.wolfram.mathematica"),
	/** MIME 类型：application/vnd.wolfram.mathematica.package */
	APPLICATION_VND_WOLFRAM_MATHEMATICA_PACKAGE("application/vnd.wolfram.mathematica.package"),
	/** MIME 类型：application/vnd.wolfram.player */
	APPLICATION_VND_WOLFRAM_PLAYER("application/vnd.wolfram.player"),
	/** MIME 类型：application/vnd.wordlift */
	APPLICATION_VND_WORDLIFT("application/vnd.wordlift"),
	/** MIME 类型：application/vnd.wordperfect */
	APPLICATION_VND_WORDPERFECT("application/vnd.wordperfect"),
	/** MIME 类型：application/vnd.wqd */
	APPLICATION_VND_WQD("application/vnd.wqd"),
	/** MIME 类型：application/vnd.wrq-hp3000-labelled */
	APPLICATION_VND_WRQ_HP3000_LABELLED("application/vnd.wrq-hp3000-labelled"),
	/** MIME 类型：application/vnd.wt.stf */
	APPLICATION_VND_WT_STF("application/vnd.wt.stf"),
	/** MIME 类型：application/vnd.wv.csp+xml */
	APPLICATION_VND_WV_CSP_XML("application/vnd.wv.csp+xml"),
	/** MIME 类型：application/vnd.wv.csp+wbxml */
	APPLICATION_VND_WV_CSP_WBXML("application/vnd.wv.csp+wbxml"),
	/** MIME 类型：application/vnd.wv.ssp+xml */
	APPLICATION_VND_WV_SSP_XML("application/vnd.wv.ssp+xml"),
	/** MIME 类型：application/vnd.xacml+json */
	APPLICATION_VND_XACML_JSON("application/vnd.xacml+json"),
	/** MIME 类型：application/vnd.xara */
	APPLICATION_VND_XARA("application/vnd.xara"),
	/** MIME 类型：application/vnd.xarin.cpj */
	APPLICATION_VND_XARIN_CPJ("application/vnd.xarin.cpj"),
	/** MIME 类型：application/vnd.xcdn */
	APPLICATION_VND_XCDN("application/vnd.xcdn"),
	/** MIME 类型：application/vnd.xecrets-encrypted */
	APPLICATION_VND_XECRETS_ENCRYPTED("application/vnd.xecrets-encrypted"),
	/** MIME 类型：application/vnd.xfdl */
	APPLICATION_VND_XFDL("application/vnd.xfdl"),
	/** MIME 类型：application/vnd.xfdl.webform */
	APPLICATION_VND_XFDL_WEBFORM("application/vnd.xfdl.webform"),
	/** MIME 类型：application/vnd.xmi+xml */
	APPLICATION_VND_XMI_XML("application/vnd.xmi+xml"),
	/** MIME 类型：application/vnd.xmpie.cpkg */
	APPLICATION_VND_XMPIE_CPKG("application/vnd.xmpie.cpkg"),
	/** MIME 类型：application/vnd.xmpie.dpkg */
	APPLICATION_VND_XMPIE_DPKG("application/vnd.xmpie.dpkg"),
	/** MIME 类型：application/vnd.xmpie.plan */
	APPLICATION_VND_XMPIE_PLAN("application/vnd.xmpie.plan"),
	/** MIME 类型：application/vnd.xmpie.ppkg */
	APPLICATION_VND_XMPIE_PPKG("application/vnd.xmpie.ppkg"),
	/** MIME 类型：application/vnd.xmpie.xlim */
	APPLICATION_VND_XMPIE_XLIM("application/vnd.xmpie.xlim"),
	/** MIME 类型：application/vnd.yamaha.hv-dic */
	APPLICATION_VND_YAMAHA_HV_DIC("application/vnd.yamaha.hv-dic"),
	/** MIME 类型：application/vnd.yamaha.hv-script */
	APPLICATION_VND_YAMAHA_HV_SCRIPT("application/vnd.yamaha.hv-script"),
	/** MIME 类型：application/vnd.yamaha.hv-voice */
	APPLICATION_VND_YAMAHA_HV_VOICE("application/vnd.yamaha.hv-voice"),
	/** MIME 类型：application/vnd.yamaha.openscoreformat.osfpvg+xml */
	APPLICATION_VND_YAMAHA_OPENSCOREFORMAT_OSFPVG_XML("application/vnd.yamaha.openscoreformat.osfpvg+xml"),
	/** MIME 类型：application/vnd.yamaha.openscoreformat */
	APPLICATION_VND_YAMAHA_OPENSCOREFORMAT("application/vnd.yamaha.openscoreformat"),
	/** MIME 类型：application/vnd.yamaha.remote-setup */
	APPLICATION_VND_YAMAHA_REMOTE_SETUP("application/vnd.yamaha.remote-setup"),
	/** MIME 类型：application/vnd.yamaha.smaf-audio */
	APPLICATION_VND_YAMAHA_SMAF_AUDIO("application/vnd.yamaha.smaf-audio"),
	/** MIME 类型：application/vnd.yamaha.smaf-phrase */
	APPLICATION_VND_YAMAHA_SMAF_PHRASE("application/vnd.yamaha.smaf-phrase"),
	/** MIME 类型：application/vnd.yamaha.through-ngn */
	APPLICATION_VND_YAMAHA_THROUGH_NGN("application/vnd.yamaha.through-ngn"),
	/** MIME 类型：application/vnd.yamaha.tunnel-udpencap */
	APPLICATION_VND_YAMAHA_TUNNEL_UDPENCAP("application/vnd.yamaha.tunnel-udpencap"),
	/** MIME 类型：application/vnd.yaoweme */
	APPLICATION_VND_YAOWEME("application/vnd.yaoweme"),
	/** MIME 类型：application/vnd.yellowriver-custom-menu */
	APPLICATION_VND_YELLOWRIVER_CUSTOM_MENU("application/vnd.yellowriver-custom-menu"),
	/** MIME 类型：application/vnd.youtube.yt */
	APPLICATION_VND_YOUTUBE_YT("application/vnd.youtube.yt"),
	/** MIME 类型：application/vnd.zoho-presentation.show */
	APPLICATION_VND_ZOHO_PRESENTATION_SHOW("application/vnd.zoho-presentation.show"),
	/** MIME 类型：application/vnd.zul */
	APPLICATION_VND_ZUL("application/vnd.zul"),
	/** MIME 类型：application/vnd.zzazz.deck+xml */
	APPLICATION_VND_ZZAZZ_DECK_XML("application/vnd.zzazz.deck+xml"),
	/** MIME 类型：application/voicexml+xml */
	APPLICATION_VOICEXML_XML("application/voicexml+xml"),
	/** MIME 类型：application/voucher-cms+json */
	APPLICATION_VOUCHER_CMS_JSON("application/voucher-cms+json"),
	/** MIME 类型：application/voucher-jws+json */
	APPLICATION_VOUCHER_JWS_JSON("application/voucher-jws+json"),
	/** MIME 类型：application/vp */
	APPLICATION_VP("application/vp"),
	/** MIME 类型：application/vp+cose */
	APPLICATION_VP_COSE("application/vp+cose"),
	/** MIME 类型：application/vp+jwt */
	APPLICATION_VP_JWT("application/vp+jwt"),
	/** MIME 类型：application/vp+sd-jwt */
	APPLICATION_VP_SD_JWT("application/vp+sd-jwt"),
	/** MIME 类型：application/vq-rtcpxr */
	APPLICATION_VQ_RTCPXR("application/vq-rtcpxr"),
	/** MIME 类型：application/wasm */
	APPLICATION_WASM("application/wasm"),
	/** MIME 类型：application/watcherinfo+xml */
	APPLICATION_WATCHERINFO_XML("application/watcherinfo+xml"),
	/** MIME 类型：application/webpush-options+json */
	APPLICATION_WEBPUSH_OPTIONS_JSON("application/webpush-options+json"),
	/** MIME 类型：application/whoispp-query */
	APPLICATION_WHOISPP_QUERY("application/whoispp-query"),
	/** MIME 类型：application/whoispp-response */
	APPLICATION_WHOISPP_RESPONSE("application/whoispp-response"),
	/** MIME 类型：application/widget */
	APPLICATION_WIDGET("application/widget"),
	/** MIME 类型：application/wita */
	APPLICATION_WITA("application/wita"),
	/** MIME 类型：application/wordperfect5.1 */
	APPLICATION_WORDPERFECT5_1("application/wordperfect5.1"),
	/** MIME 类型：application/wsdl+xml */
	APPLICATION_WSDL_XML("application/wsdl+xml"),
	/** MIME 类型：application/wspolicy+xml */
	APPLICATION_WSPOLICY_XML("application/wspolicy+xml"),
	/** MIME 类型：application/x-pki-message */
	APPLICATION_X_PKI_MESSAGE("application/x-pki-message"),
	/** MIME 类型：application/x-www-form-urlencoded */
	APPLICATION_X_WWW_FORM_URLENCODED("application/x-www-form-urlencoded"),
	/** MIME 类型：application/x-x509-ca-cert */
	APPLICATION_X_X509_CA_CERT("application/x-x509-ca-cert"),
	/** MIME 类型：application/x-x509-ca-ra-cert */
	APPLICATION_X_X509_CA_RA_CERT("application/x-x509-ca-ra-cert"),
	/** MIME 类型：application/x-x509-next-ca-cert */
	APPLICATION_X_X509_NEXT_CA_CERT("application/x-x509-next-ca-cert"),
	/** MIME 类型：application/x400-bp */
	APPLICATION_X400_BP("application/x400-bp"),
	/** MIME 类型：application/xacml+xml */
	APPLICATION_XACML_XML("application/xacml+xml"),
	/** MIME 类型：application/xcap-att+xml */
	APPLICATION_XCAP_ATT_XML("application/xcap-att+xml"),
	/** MIME 类型：application/xcap-caps+xml */
	APPLICATION_XCAP_CAPS_XML("application/xcap-caps+xml"),
	/** MIME 类型：application/xcap-diff+xml */
	APPLICATION_XCAP_DIFF_XML("application/xcap-diff+xml"),
	/** MIME 类型：application/xcap-el+xml */
	APPLICATION_XCAP_EL_XML("application/xcap-el+xml"),
	/** MIME 类型：application/xcap-error+xml */
	APPLICATION_XCAP_ERROR_XML("application/xcap-error+xml"),
	/** MIME 类型：application/xcap-ns+xml */
	APPLICATION_XCAP_NS_XML("application/xcap-ns+xml"),
	/** MIME 类型：application/xcon-conference-info-diff+xml */
	APPLICATION_XCON_CONFERENCE_INFO_DIFF_XML("application/xcon-conference-info-diff+xml"),
	/** MIME 类型：application/xcon-conference-info+xml */
	APPLICATION_XCON_CONFERENCE_INFO_XML("application/xcon-conference-info+xml"),
	/** MIME 类型：application/xenc+xml */
	APPLICATION_XENC_XML("application/xenc+xml"),
	/** MIME 类型：application/xfdf */
	APPLICATION_XFDF("application/xfdf"),
	/** MIME 类型：application/xhtml+xml */
	APPLICATION_XHTML_XML("application/xhtml+xml"),
	/** MIME 类型：application/xliff+xml */
	APPLICATION_XLIFF_XML("application/xliff+xml"),
	/** MIME 类型：application/xml */
	APPLICATION_XML("application/xml"),
	/** MIME 类型：application/xml-dtd */
	APPLICATION_XML_DTD("application/xml-dtd"),
	/** MIME 类型：application/xml-external-parsed-entity */
	APPLICATION_XML_EXTERNAL_PARSED_ENTITY("application/xml-external-parsed-entity"),
	/** MIME 类型：application/xml-patch+xml */
	APPLICATION_XML_PATCH_XML("application/xml-patch+xml"),
	/** MIME 类型：application/xmpp+xml */
	APPLICATION_XMPP_XML("application/xmpp+xml"),
	/** MIME 类型：application/xop+xml */
	APPLICATION_XOP_XML("application/xop+xml"),
	/** MIME 类型：application/xslt+xml */
	APPLICATION_XSLT_XML("application/xslt+xml"),
	/** MIME 类型：application/xv+xml */
	APPLICATION_XV_XML("application/xv+xml"),
	/** MIME 类型：application/yaml */
	APPLICATION_YAML("application/yaml"),
	/** MIME 类型：application/yang */
	APPLICATION_YANG("application/yang"),
	/** MIME 类型：application/yang-data+cbor */
	APPLICATION_YANG_DATA_CBOR("application/yang-data+cbor"),
	/** MIME 类型：application/yang-data+json */
	APPLICATION_YANG_DATA_JSON("application/yang-data+json"),
	/** MIME 类型：application/yang-data+xml */
	APPLICATION_YANG_DATA_XML("application/yang-data+xml"),
	/** MIME 类型：application/yang-patch+json */
	APPLICATION_YANG_PATCH_JSON("application/yang-patch+json"),
	/** MIME 类型：application/yang-patch+xml */
	APPLICATION_YANG_PATCH_XML("application/yang-patch+xml"),
	/** MIME 类型：application/yang-sid+json */
	APPLICATION_YANG_SID_JSON("application/yang-sid+json"),
	/** MIME 类型：application/yin+xml */
	APPLICATION_YIN_XML("application/yin+xml"),
	/** MIME 类型：application/zip */
	APPLICATION_ZIP("application/zip"),
	/** MIME 类型：application/zlib */
	APPLICATION_ZLIB("application/zlib"),
	/** MIME 类型：application/zstd */
	APPLICATION_ZSTD("application/zstd"),
	/** MIME 类型：audio/1d-interleaved-parityfec */
	AUDIO_1D_INTERLEAVED_PARITYFEC("audio/1d-interleaved-parityfec"),
	/** MIME 类型：audio/32kadpcm */
	AUDIO_32KADPCM("audio/32kadpcm"),
	/** MIME 类型：audio/3gpp */
	AUDIO_3GPP("audio/3gpp"),
	/** MIME 类型：audio/3gpp2 */
	AUDIO_3GPP2("audio/3gpp2"),
	/** MIME 类型：audio/aac */
	AUDIO_AAC("audio/aac"),
	/** MIME 类型：audio/ac3 */
	AUDIO_AC3("audio/ac3"),
	/** MIME 类型：audio/AMR */
	AUDIO_AMR("audio/AMR"),
	/** MIME 类型：audio/AMR-WB */
	AUDIO_AMR_WB("audio/AMR-WB"),
	/** MIME 类型：audio/amr-wb+ */
	AUDIO_AMR_WB_("audio/amr-wb+"),
	/** MIME 类型：audio/aptx */
	AUDIO_APTX("audio/aptx"),
	/** MIME 类型：audio/asc */
	AUDIO_ASC("audio/asc"),
	/** MIME 类型：audio/ATRAC-ADVANCED-LOSSLESS */
	AUDIO_ATRAC_ADVANCED_LOSSLESS("audio/ATRAC-ADVANCED-LOSSLESS"),
	/** MIME 类型：audio/ATRAC-X */
	AUDIO_ATRAC_X("audio/ATRAC-X"),
	/** MIME 类型：audio/ATRAC3 */
	AUDIO_ATRAC3("audio/ATRAC3"),
	/** MIME 类型：audio/basic */
	AUDIO_BASIC("audio/basic"),
	/** MIME 类型：audio/BV16 */
	AUDIO_BV16("audio/BV16"),
	/** MIME 类型：audio/BV32 */
	AUDIO_BV32("audio/BV32"),
	/** MIME 类型：audio/clearmode */
	AUDIO_CLEARMODE("audio/clearmode"),
	/** MIME 类型：audio/CN */
	AUDIO_CN("audio/CN"),
	/** MIME 类型：audio/DAT12 */
	AUDIO_DAT12("audio/DAT12"),
	/** MIME 类型：audio/dls */
	AUDIO_DLS("audio/dls"),
	/** MIME 类型：audio/dsr-es201108 */
	AUDIO_DSR_ES201108("audio/dsr-es201108"),
	/** MIME 类型：audio/dsr-es202050 */
	AUDIO_DSR_ES202050("audio/dsr-es202050"),
	/** MIME 类型：audio/dsr-es202211 */
	AUDIO_DSR_ES202211("audio/dsr-es202211"),
	/** MIME 类型：audio/dsr-es202212 */
	AUDIO_DSR_ES202212("audio/dsr-es202212"),
	/** MIME 类型：audio/DV */
	AUDIO_DV("audio/DV"),
	/** MIME 类型：audio/DVI4 */
	AUDIO_DVI4("audio/DVI4"),
	/** MIME 类型：audio/eac3 */
	AUDIO_EAC3("audio/eac3"),
	/** MIME 类型：audio/encaprtp */
	AUDIO_ENCAPRTP("audio/encaprtp"),
	/** MIME 类型：audio/EVRC */
	AUDIO_EVRC("audio/EVRC"),
	/** MIME 类型：audio/EVRC-QCP */
	AUDIO_EVRC_QCP("audio/EVRC-QCP"),
	/** MIME 类型：audio/EVRC0 */
	AUDIO_EVRC0("audio/EVRC0"),
	/** MIME 类型：audio/EVRC1 */
	AUDIO_EVRC1("audio/EVRC1"),
	/** MIME 类型：audio/EVRCB */
	AUDIO_EVRCB("audio/EVRCB"),
	/** MIME 类型：audio/EVRCB0 */
	AUDIO_EVRCB0("audio/EVRCB0"),
	/** MIME 类型：audio/EVRCB1 */
	AUDIO_EVRCB1("audio/EVRCB1"),
	/** MIME 类型：audio/EVRCNW */
	AUDIO_EVRCNW("audio/EVRCNW"),
	/** MIME 类型：audio/EVRCNW0 */
	AUDIO_EVRCNW0("audio/EVRCNW0"),
	/** MIME 类型：audio/EVRCNW1 */
	AUDIO_EVRCNW1("audio/EVRCNW1"),
	/** MIME 类型：audio/EVRCWB */
	AUDIO_EVRCWB("audio/EVRCWB"),
	/** MIME 类型：audio/EVRCWB0 */
	AUDIO_EVRCWB0("audio/EVRCWB0"),
	/** MIME 类型：audio/EVRCWB1 */
	AUDIO_EVRCWB1("audio/EVRCWB1"),
	/** MIME 类型：audio/EVS */
	AUDIO_EVS("audio/EVS"),
	/** MIME 类型：audio/example */
	AUDIO_EXAMPLE("audio/example"),
	/** MIME 类型：audio/flac */
	AUDIO_FLAC("audio/flac"),
	/** MIME 类型：audio/flexfec */
	AUDIO_FLEXFEC("audio/flexfec"),
	/** MIME 类型：audio/fwdred */
	AUDIO_FWDRED("audio/fwdred"),
	/** MIME 类型：audio/G711-0 */
	AUDIO_G711_0("audio/G711-0"),
	/** MIME 类型：audio/G719 */
	AUDIO_G719("audio/G719"),
	/** MIME 类型：audio/G7221 */
	AUDIO_G7221("audio/G7221"),
	/** MIME 类型：audio/G722 */
	AUDIO_G722("audio/G722"),
	/** MIME 类型：audio/G723 */
	AUDIO_G723("audio/G723"),
	/** MIME 类型：audio/G726-16 */
	AUDIO_G726_16("audio/G726-16"),
	/** MIME 类型：audio/G726-24 */
	AUDIO_G726_24("audio/G726-24"),
	/** MIME 类型：audio/G726-32 */
	AUDIO_G726_32("audio/G726-32"),
	/** MIME 类型：audio/G726-40 */
	AUDIO_G726_40("audio/G726-40"),
	/** MIME 类型：audio/G728 */
	AUDIO_G728("audio/G728"),
	/** MIME 类型：audio/G729 */
	AUDIO_G729("audio/G729"),
	/** MIME 类型：audio/G7291 */
	AUDIO_G7291("audio/G7291"),
	/** MIME 类型：audio/G729D */
	AUDIO_G729D("audio/G729D"),
	/** MIME 类型：audio/G729E */
	AUDIO_G729E("audio/G729E"),
	/** MIME 类型：audio/GSM */
	AUDIO_GSM("audio/GSM"),
	/** MIME 类型：audio/GSM-EFR */
	AUDIO_GSM_EFR("audio/GSM-EFR"),
	/** MIME 类型：audio/GSM-HR-08 */
	AUDIO_GSM_HR_08("audio/GSM-HR-08"),
	/** MIME 类型：audio/iLBC */
	AUDIO_ILBC("audio/iLBC"),
	/** MIME 类型：audio/ip-mr_v2.5 */
	AUDIO_IP_MR_V2_5("audio/ip-mr_v2.5"),
	/** MIME 类型：audio/L8 */
	AUDIO_L8("audio/L8"),
	/** MIME 类型：audio/L16 */
	AUDIO_L16("audio/L16"),
	/** MIME 类型：audio/L20 */
	AUDIO_L20("audio/L20"),
	/** MIME 类型：audio/L24 */
	AUDIO_L24("audio/L24"),
	/** MIME 类型：audio/LPC */
	AUDIO_LPC("audio/LPC"),
	/** MIME 类型：audio/matroska */
	AUDIO_MATROSKA("audio/matroska"),
	/** MIME 类型：audio/MELP */
	AUDIO_MELP("audio/MELP"),
	/** MIME 类型：audio/MELP600 */
	AUDIO_MELP600("audio/MELP600"),
	/** MIME 类型：audio/MELP1200 */
	AUDIO_MELP1200("audio/MELP1200"),
	/** MIME 类型：audio/MELP2400 */
	AUDIO_MELP2400("audio/MELP2400"),
	/** MIME 类型：audio/mhas */
	AUDIO_MHAS("audio/mhas"),
	/** MIME 类型：audio/midi-clip */
	AUDIO_MIDI_CLIP("audio/midi-clip"),
	/** MIME 类型：audio/mobile-xmf */
	AUDIO_MOBILE_XMF("audio/mobile-xmf"),
	/** MIME 类型：audio/MPA */
	AUDIO_MPA("audio/MPA"),
	/** MIME 类型：audio/mp4 */
	AUDIO_MP4("audio/mp4"),
	/** MIME 类型：audio/MP4A-LATM */
	AUDIO_MP4A_LATM("audio/MP4A-LATM"),
	/** MIME 类型：audio/mpa-robust */
	AUDIO_MPA_ROBUST("audio/mpa-robust"),
	/** MIME 类型：audio/mpeg */
	AUDIO_MPEG("audio/mpeg"),
	/** MIME 类型：audio/mpeg4-generic */
	AUDIO_MPEG4_GENERIC("audio/mpeg4-generic"),
	/** MIME 类型：audio/ogg */
	AUDIO_OGG("audio/ogg"),
	/** MIME 类型：audio/opus */
	AUDIO_OPUS("audio/opus"),
	/** MIME 类型：audio/parityfec */
	AUDIO_PARITYFEC("audio/parityfec"),
	/** MIME 类型：audio/PCMA */
	AUDIO_PCMA("audio/PCMA"),
	/** MIME 类型：audio/PCMA-WB */
	AUDIO_PCMA_WB("audio/PCMA-WB"),
	/** MIME 类型：audio/PCMU */
	AUDIO_PCMU("audio/PCMU"),
	/** MIME 类型：audio/PCMU-WB */
	AUDIO_PCMU_WB("audio/PCMU-WB"),
	/** MIME 类型：audio/prs.sid */
	AUDIO_PRS_SID("audio/prs.sid"),
	/** MIME 类型：audio/QCELP */
	AUDIO_QCELP("audio/QCELP"),
	/** MIME 类型：audio/raptorfec */
	AUDIO_RAPTORFEC("audio/raptorfec"),
	/** MIME 类型：audio/RED */
	AUDIO_RED("audio/RED"),
	/** MIME 类型：audio/rtp-enc-aescm128 */
	AUDIO_RTP_ENC_AESCM128("audio/rtp-enc-aescm128"),
	/** MIME 类型：audio/rtploopback */
	AUDIO_RTPLOOPBACK("audio/rtploopback"),
	/** MIME 类型：audio/rtp-midi */
	AUDIO_RTP_MIDI("audio/rtp-midi"),
	/** MIME 类型：audio/rtx */
	AUDIO_RTX("audio/rtx"),
	/** MIME 类型：audio/scip */
	AUDIO_SCIP("audio/scip"),
	/** MIME 类型：audio/SMV */
	AUDIO_SMV("audio/SMV"),
	/** MIME 类型：audio/SMV0 */
	AUDIO_SMV0("audio/SMV0"),
	/** MIME 类型：audio/SMV-QCP */
	AUDIO_SMV_QCP("audio/SMV-QCP"),
	/** MIME 类型：audio/sofa */
	AUDIO_SOFA("audio/sofa"),
	/** MIME 类型：audio/soundfont */
	AUDIO_SOUNDFONT("audio/soundfont"),
	/** MIME 类型：audio/sp-midi */
	AUDIO_SP_MIDI("audio/sp-midi"),
	/** MIME 类型：audio/speex */
	AUDIO_SPEEX("audio/speex"),
	/** MIME 类型：audio/t140c */
	AUDIO_T140C("audio/t140c"),
	/** MIME 类型：audio/t38 */
	AUDIO_T38("audio/t38"),
	/** MIME 类型：audio/telephone-event */
	AUDIO_TELEPHONE_EVENT("audio/telephone-event"),
	/** MIME 类型：audio/TETRA_ACELP */
	AUDIO_TETRA_ACELP("audio/TETRA_ACELP"),
	/** MIME 类型：audio/TETRA_ACELP_BB */
	AUDIO_TETRA_ACELP_BB("audio/TETRA_ACELP_BB"),
	/** MIME 类型：audio/tone */
	AUDIO_TONE("audio/tone"),
	/** MIME 类型：audio/TSVCIS */
	AUDIO_TSVCIS("audio/TSVCIS"),
	/** MIME 类型：audio/UEMCLIP */
	AUDIO_UEMCLIP("audio/UEMCLIP"),
	/** MIME 类型：audio/ulpfec */
	AUDIO_ULPFEC("audio/ulpfec"),
	/** MIME 类型：audio/usac */
	AUDIO_USAC("audio/usac"),
	/** MIME 类型：audio/VDVI */
	AUDIO_VDVI("audio/VDVI"),
	/** MIME 类型：audio/VMR-WB */
	AUDIO_VMR_WB("audio/VMR-WB"),
	/** MIME 类型：audio/vnd.3gpp.iufp */
	AUDIO_VND_3GPP_IUFP("audio/vnd.3gpp.iufp"),
	/** MIME 类型：audio/vnd.4SB */
	AUDIO_VND_4SB("audio/vnd.4SB"),
	/** MIME 类型：audio/vnd.audiokoz */
	AUDIO_VND_AUDIOKOZ("audio/vnd.audiokoz"),
	/** MIME 类型：audio/vnd.blockfact.facta */
	AUDIO_VND_BLOCKFACT_FACTA("audio/vnd.blockfact.facta"),
	/** MIME 类型：audio/vnd.CELP */
	AUDIO_VND_CELP("audio/vnd.CELP"),
	/** MIME 类型：audio/vnd.cisco.nse */
	AUDIO_VND_CISCO_NSE("audio/vnd.cisco.nse"),
	/** MIME 类型：audio/vnd.cmles.radio-events */
	AUDIO_VND_CMLES_RADIO_EVENTS("audio/vnd.cmles.radio-events"),
	/** MIME 类型：audio/vnd.cns.anp1 */
	AUDIO_VND_CNS_ANP1("audio/vnd.cns.anp1"),
	/** MIME 类型：audio/vnd.cns.inf1 */
	AUDIO_VND_CNS_INF1("audio/vnd.cns.inf1"),
	/** MIME 类型：audio/vnd.dece.audio */
	AUDIO_VND_DECE_AUDIO("audio/vnd.dece.audio"),
	/** MIME 类型：audio/vnd.digital-winds */
	AUDIO_VND_DIGITAL_WINDS("audio/vnd.digital-winds"),
	/** MIME 类型：audio/vnd.dlna.adts */
	AUDIO_VND_DLNA_ADTS("audio/vnd.dlna.adts"),
	/** MIME 类型：audio/vnd.dolby.heaac.1 */
	AUDIO_VND_DOLBY_HEAAC_1("audio/vnd.dolby.heaac.1"),
	/** MIME 类型：audio/vnd.dolby.heaac.2 */
	AUDIO_VND_DOLBY_HEAAC_2("audio/vnd.dolby.heaac.2"),
	/** MIME 类型：audio/vnd.dolby.mlp */
	AUDIO_VND_DOLBY_MLP("audio/vnd.dolby.mlp"),
	/** MIME 类型：audio/vnd.dolby.mps */
	AUDIO_VND_DOLBY_MPS("audio/vnd.dolby.mps"),
	/** MIME 类型：audio/vnd.dolby.pl2 */
	AUDIO_VND_DOLBY_PL2("audio/vnd.dolby.pl2"),
	/** MIME 类型：audio/vnd.dolby.pl2x */
	AUDIO_VND_DOLBY_PL2X("audio/vnd.dolby.pl2x"),
	/** MIME 类型：audio/vnd.dolby.pl2z */
	AUDIO_VND_DOLBY_PL2Z("audio/vnd.dolby.pl2z"),
	/** MIME 类型：audio/vnd.dolby.pulse.1 */
	AUDIO_VND_DOLBY_PULSE_1("audio/vnd.dolby.pulse.1"),
	/** MIME 类型：audio/vnd.dra */
	AUDIO_VND_DRA("audio/vnd.dra"),
	/** MIME 类型：audio/vnd.dts */
	AUDIO_VND_DTS("audio/vnd.dts"),
	/** MIME 类型：audio/vnd.dts.hd */
	AUDIO_VND_DTS_HD("audio/vnd.dts.hd"),
	/** MIME 类型：audio/vnd.dts.uhd */
	AUDIO_VND_DTS_UHD("audio/vnd.dts.uhd"),
	/** MIME 类型：audio/vnd.dvb.file */
	AUDIO_VND_DVB_FILE("audio/vnd.dvb.file"),
	/** MIME 类型：audio/vnd.everad.plj */
	AUDIO_VND_EVERAD_PLJ("audio/vnd.everad.plj"),
	/** MIME 类型：audio/vnd.hns.audio */
	AUDIO_VND_HNS_AUDIO("audio/vnd.hns.audio"),
	/** MIME 类型：audio/vnd.lucent.voice */
	AUDIO_VND_LUCENT_VOICE("audio/vnd.lucent.voice"),
	/** MIME 类型：audio/vnd.ms-playready.media.pya */
	AUDIO_VND_MS_PLAYREADY_MEDIA_PYA("audio/vnd.ms-playready.media.pya"),
	/** MIME 类型：audio/vnd.nokia.mobile-xmf */
	AUDIO_VND_NOKIA_MOBILE_XMF("audio/vnd.nokia.mobile-xmf"),
	/** MIME 类型：audio/vnd.nortel.vbk */
	AUDIO_VND_NORTEL_VBK("audio/vnd.nortel.vbk"),
	/** MIME 类型：audio/vnd.nuera.ecelp4800 */
	AUDIO_VND_NUERA_ECELP4800("audio/vnd.nuera.ecelp4800"),
	/** MIME 类型：audio/vnd.nuera.ecelp7470 */
	AUDIO_VND_NUERA_ECELP7470("audio/vnd.nuera.ecelp7470"),
	/** MIME 类型：audio/vnd.nuera.ecelp9600 */
	AUDIO_VND_NUERA_ECELP9600("audio/vnd.nuera.ecelp9600"),
	/** MIME 类型：audio/vnd.octel.sbc */
	AUDIO_VND_OCTEL_SBC("audio/vnd.octel.sbc"),
	/** MIME 类型：audio/vnd.presonus.multitrack */
	AUDIO_VND_PRESONUS_MULTITRACK("audio/vnd.presonus.multitrack"),
	/** MIME 类型：audio/vnd.qcelp */
	AUDIO_VND_QCELP("audio/vnd.qcelp"),
	/** MIME 类型：audio/vnd.rhetorex.32kadpcm */
	AUDIO_VND_RHETOREX_32KADPCM("audio/vnd.rhetorex.32kadpcm"),
	/** MIME 类型：audio/vnd.rip */
	AUDIO_VND_RIP("audio/vnd.rip"),
	/** MIME 类型：audio/vnd.sealedmedia.softseal.mpeg */
	AUDIO_VND_SEALEDMEDIA_SOFTSEAL_MPEG("audio/vnd.sealedmedia.softseal.mpeg"),
	/** MIME 类型：audio/vnd.vmx.cvsd */
	AUDIO_VND_VMX_CVSD("audio/vnd.vmx.cvsd"),
	/** MIME 类型：audio/vorbis */
	AUDIO_VORBIS("audio/vorbis"),
	/** MIME 类型：audio/vorbis-config */
	AUDIO_VORBIS_CONFIG("audio/vorbis-config"),
	/** MIME 类型：font/collection */
	FONT_COLLECTION("font/collection"),
	/** MIME 类型：font/otf */
	FONT_OTF("font/otf"),
	/** MIME 类型：font/sfnt */
	FONT_SFNT("font/sfnt"),
	/** MIME 类型：font/ttf */
	FONT_TTF("font/ttf"),
	/** MIME 类型：font/woff */
	FONT_WOFF("font/woff"),
	/** MIME 类型：font/woff2 */
	FONT_WOFF2("font/woff2"),
	/** MIME 类型：haptics/ivs */
	HAPTICS_IVS("haptics/ivs"),
	/** MIME 类型：haptics/hjif */
	HAPTICS_HJIF("haptics/hjif"),
	/** MIME 类型：haptics/hmpg */
	HAPTICS_HMPG("haptics/hmpg"),
	/** MIME 类型：image/aces */
	IMAGE_ACES("image/aces"),
	/** MIME 类型：image/apng */
	IMAGE_APNG("image/apng"),
	/** MIME 类型：image/avci */
	IMAGE_AVCI("image/avci"),
	/** MIME 类型：image/avcs */
	IMAGE_AVCS("image/avcs"),
	/** MIME 类型：image/avif */
	IMAGE_AVIF("image/avif"),
	/** MIME 类型：image/bmp */
	IMAGE_BMP("image/bmp"),
	/** MIME 类型：image/cgm */
	IMAGE_CGM("image/cgm"),
	/** MIME 类型：image/dicom-rle */
	IMAGE_DICOM_RLE("image/dicom-rle"),
	/** MIME 类型：image/dpx */
	IMAGE_DPX("image/dpx"),
	/** MIME 类型：image/emf */
	IMAGE_EMF("image/emf"),
	/** MIME 类型：image/example */
	IMAGE_EXAMPLE("image/example"),
	/** MIME 类型：image/fits */
	IMAGE_FITS("image/fits"),
	/** MIME 类型：image/g3fax */
	IMAGE_G3FAX("image/g3fax"),
	/** MIME 类型：image/gif */
	IMAGE_GIF("image/gif"),
	/** MIME 类型：image/heic */
	IMAGE_HEIC("image/heic"),
	/** MIME 类型：image/heic-sequence */
	IMAGE_HEIC_SEQUENCE("image/heic-sequence"),
	/** MIME 类型：image/heif */
	IMAGE_HEIF("image/heif"),
	/** MIME 类型：image/heif-sequence */
	IMAGE_HEIF_SEQUENCE("image/heif-sequence"),
	/** MIME 类型：image/hej2k */
	IMAGE_HEJ2K("image/hej2k"),
	/** MIME 类型：image/hsj2 */
	IMAGE_HSJ2("image/hsj2"),
	/** MIME 类型：image/ief */
	IMAGE_IEF("image/ief"),
	/** MIME 类型：image/j2c */
	IMAGE_J2C("image/j2c"),
	/** MIME 类型：image/jaii */
	IMAGE_JAII("image/jaii"),
	/** MIME 类型：image/jais */
	IMAGE_JAIS("image/jais"),
	/** MIME 类型：image/jls */
	IMAGE_JLS("image/jls"),
	/** MIME 类型：image/jp2 */
	IMAGE_JP2("image/jp2"),
	/** MIME 类型：image/jpeg */
	IMAGE_JPEG("image/jpeg"),
	/** MIME 类型：image/jph */
	IMAGE_JPH("image/jph"),
	/** MIME 类型：image/jphc */
	IMAGE_JPHC("image/jphc"),
	/** MIME 类型：image/jpm */
	IMAGE_JPM("image/jpm"),
	/** MIME 类型：image/jpx */
	IMAGE_JPX("image/jpx"),
	/** MIME 类型：image/jxl */
	IMAGE_JXL("image/jxl"),
	/** MIME 类型：image/jxr */
	IMAGE_JXR("image/jxr"),
	/** MIME 类型：image/jxrA */
	IMAGE_JXRA("image/jxrA"),
	/** MIME 类型：image/jxrS */
	IMAGE_JXRS("image/jxrS"),
	/** MIME 类型：image/jxs */
	IMAGE_JXS("image/jxs"),
	/** MIME 类型：image/jxsc */
	IMAGE_JXSC("image/jxsc"),
	/** MIME 类型：image/jxsi */
	IMAGE_JXSI("image/jxsi"),
	/** MIME 类型：image/jxss */
	IMAGE_JXSS("image/jxss"),
	/** MIME 类型：image/ktx */
	IMAGE_KTX("image/ktx"),
	/** MIME 类型：image/ktx2 */
	IMAGE_KTX2("image/ktx2"),
	/** MIME 类型：image/naplps */
	IMAGE_NAPLPS("image/naplps"),
	/** MIME 类型：image/png */
	IMAGE_PNG("image/png"),
	/** MIME 类型：image/prs.btif */
	IMAGE_PRS_BTIF("image/prs.btif"),
	/** MIME 类型：image/prs.pti */
	IMAGE_PRS_PTI("image/prs.pti"),
	/** MIME 类型：image/pwg-raster */
	IMAGE_PWG_RASTER("image/pwg-raster"),
	/** MIME 类型：image/svg+xml */
	IMAGE_SVG_XML("image/svg+xml"),
	/** MIME 类型：image/t38 */
	IMAGE_T38("image/t38"),
	/** MIME 类型：image/tiff */
	IMAGE_TIFF("image/tiff"),
	/** MIME 类型：image/tiff-fx */
	IMAGE_TIFF_FX("image/tiff-fx"),
	/** MIME 类型：image/vnd.adobe.photoshop */
	IMAGE_VND_ADOBE_PHOTOSHOP("image/vnd.adobe.photoshop"),
	/** MIME 类型：image/vnd.airzip.accelerator.azv */
	IMAGE_VND_AIRZIP_ACCELERATOR_AZV("image/vnd.airzip.accelerator.azv"),
	/** MIME 类型：image/vnd.blockfact.facti */
	IMAGE_VND_BLOCKFACT_FACTI("image/vnd.blockfact.facti"),
	/** MIME 类型：image/vnd.clip */
	IMAGE_VND_CLIP("image/vnd.clip"),
	/** MIME 类型：image/vnd.cns.inf2 */
	IMAGE_VND_CNS_INF2("image/vnd.cns.inf2"),
	/** MIME 类型：image/vnd.dece.graphic */
	IMAGE_VND_DECE_GRAPHIC("image/vnd.dece.graphic"),
	/** MIME 类型：image/vnd.djvu */
	IMAGE_VND_DJVU("image/vnd.djvu"),
	/** MIME 类型：image/vnd.dwg */
	IMAGE_VND_DWG("image/vnd.dwg"),
	/** MIME 类型：image/vnd.dxf */
	IMAGE_VND_DXF("image/vnd.dxf"),
	/** MIME 类型：image/vnd.dvb.subtitle */
	IMAGE_VND_DVB_SUBTITLE("image/vnd.dvb.subtitle"),
	/** MIME 类型：image/vnd.fastbidsheet */
	IMAGE_VND_FASTBIDSHEET("image/vnd.fastbidsheet"),
	/** MIME 类型：image/vnd.fpx */
	IMAGE_VND_FPX("image/vnd.fpx"),
	/** MIME 类型：image/vnd.fst */
	IMAGE_VND_FST("image/vnd.fst"),
	/** MIME 类型：image/vnd.fujixerox.edmics-mmr */
	IMAGE_VND_FUJIXEROX_EDMICS_MMR("image/vnd.fujixerox.edmics-mmr"),
	/** MIME 类型：image/vnd.fujixerox.edmics-rlc */
	IMAGE_VND_FUJIXEROX_EDMICS_RLC("image/vnd.fujixerox.edmics-rlc"),
	/** MIME 类型：image/vnd.globalgraphics.pgb */
	IMAGE_VND_GLOBALGRAPHICS_PGB("image/vnd.globalgraphics.pgb"),
	/** MIME 类型：image/vnd.microsoft.icon */
	IMAGE_VND_MICROSOFT_ICON("image/vnd.microsoft.icon"),
	/** MIME 类型：image/vnd.mix */
	IMAGE_VND_MIX("image/vnd.mix"),
	/** MIME 类型：image/vnd.ms-modi */
	IMAGE_VND_MS_MODI("image/vnd.ms-modi"),
	/** MIME 类型：image/vnd.mozilla.apng */
	IMAGE_VND_MOZILLA_APNG("image/vnd.mozilla.apng"),
	/** MIME 类型：image/vnd.net-fpx */
	IMAGE_VND_NET_FPX("image/vnd.net-fpx"),
	/** MIME 类型：image/vnd.pco.b16 */
	IMAGE_VND_PCO_B16("image/vnd.pco.b16"),
	/** MIME 类型：image/vnd.radiance */
	IMAGE_VND_RADIANCE("image/vnd.radiance"),
	/** MIME 类型：image/vnd.sealed.png */
	IMAGE_VND_SEALED_PNG("image/vnd.sealed.png"),
	/** MIME 类型：image/vnd.sealedmedia.softseal.gif */
	IMAGE_VND_SEALEDMEDIA_SOFTSEAL_GIF("image/vnd.sealedmedia.softseal.gif"),
	/** MIME 类型：image/vnd.sealedmedia.softseal.jpg */
	IMAGE_VND_SEALEDMEDIA_SOFTSEAL_JPG("image/vnd.sealedmedia.softseal.jpg"),
	/** MIME 类型：image/vnd.svf */
	IMAGE_VND_SVF("image/vnd.svf"),
	/** MIME 类型：image/vnd.tencent.tap */
	IMAGE_VND_TENCENT_TAP("image/vnd.tencent.tap"),
	/** MIME 类型：image/vnd.valve.source.texture */
	IMAGE_VND_VALVE_SOURCE_TEXTURE("image/vnd.valve.source.texture"),
	/** MIME 类型：image/vnd.wap.wbmp */
	IMAGE_VND_WAP_WBMP("image/vnd.wap.wbmp"),
	/** MIME 类型：image/vnd.xiff */
	IMAGE_VND_XIFF("image/vnd.xiff"),
	/** MIME 类型：image/vnd.zbrush.pcx */
	IMAGE_VND_ZBRUSH_PCX("image/vnd.zbrush.pcx"),
	/** MIME 类型：image/webp */
	IMAGE_WEBP("image/webp"),
	/** MIME 类型：image/wmf */
	IMAGE_WMF("image/wmf"),
	/** MIME 类型：image/x-emf */
	IMAGE_X_EMF("image/x-emf"),
	/** MIME 类型：image/x-wmf */
	IMAGE_X_WMF("image/x-wmf"),
	/** MIME 类型：message/bhttp */
	MESSAGE_BHTTP("message/bhttp"),
	/** MIME 类型：message/CPIM */
	MESSAGE_CPIM("message/CPIM"),
	/** MIME 类型：message/delivery-status */
	MESSAGE_DELIVERY_STATUS("message/delivery-status"),
	/** MIME 类型：message/disposition-notification */
	MESSAGE_DISPOSITION_NOTIFICATION("message/disposition-notification"),
	/** MIME 类型：message/example */
	MESSAGE_EXAMPLE("message/example"),
	/** MIME 类型：message/external-body */
	MESSAGE_EXTERNAL_BODY("message/external-body"),
	/** MIME 类型：message/feedback-report */
	MESSAGE_FEEDBACK_REPORT("message/feedback-report"),
	/** MIME 类型：message/global */
	MESSAGE_GLOBAL("message/global"),
	/** MIME 类型：message/global-delivery-status */
	MESSAGE_GLOBAL_DELIVERY_STATUS("message/global-delivery-status"),
	/** MIME 类型：message/global-disposition-notification */
	MESSAGE_GLOBAL_DISPOSITION_NOTIFICATION("message/global-disposition-notification"),
	/** MIME 类型：message/global-headers */
	MESSAGE_GLOBAL_HEADERS("message/global-headers"),
	/** MIME 类型：message/http */
	MESSAGE_HTTP("message/http"),
	/** MIME 类型：message/imdn+xml */
	MESSAGE_IMDN_XML("message/imdn+xml"),
	/** MIME 类型：message/mls */
	MESSAGE_MLS("message/mls"),
	/** MIME 类型：message/news */
	MESSAGE_NEWS("message/news"),
	/** MIME 类型：message/ohttp-req */
	MESSAGE_OHTTP_REQ("message/ohttp-req"),
	/** MIME 类型：message/ohttp-res */
	MESSAGE_OHTTP_RES("message/ohttp-res"),
	/** MIME 类型：message/partial */
	MESSAGE_PARTIAL("message/partial"),
	/** MIME 类型：message/rfc822 */
	MESSAGE_RFC822("message/rfc822"),
	/** MIME 类型：message/s-http */
	MESSAGE_S_HTTP("message/s-http"),
	/** MIME 类型：message/sip */
	MESSAGE_SIP("message/sip"),
	/** MIME 类型：message/sipfrag */
	MESSAGE_SIPFRAG("message/sipfrag"),
	/** MIME 类型：message/tracking-status */
	MESSAGE_TRACKING_STATUS("message/tracking-status"),
	/** MIME 类型：message/vnd.si.simp */
	MESSAGE_VND_SI_SIMP("message/vnd.si.simp"),
	/** MIME 类型：message/vnd.wfa.wsc */
	MESSAGE_VND_WFA_WSC("message/vnd.wfa.wsc"),
	/** MIME 类型：model/3mf */
	MODEL_3MF("model/3mf"),
	/** MIME 类型：model/e57 */
	MODEL_E57("model/e57"),
	/** MIME 类型：model/example */
	MODEL_EXAMPLE("model/example"),
	/** MIME 类型：model/gltf-binary */
	MODEL_GLTF_BINARY("model/gltf-binary"),
	/** MIME 类型：model/gltf+json */
	MODEL_GLTF_JSON("model/gltf+json"),
	/** MIME 类型：model/JT */
	MODEL_JT("model/JT"),
	/** MIME 类型：model/iges */
	MODEL_IGES("model/iges"),
	/** MIME 类型：model/mesh */
	MODEL_MESH("model/mesh"),
	/** MIME 类型：model/mtl */
	MODEL_MTL("model/mtl"),
	/** MIME 类型：model/obj */
	MODEL_OBJ("model/obj"),
	/** MIME 类型：model/prc */
	MODEL_PRC("model/prc"),
	/** MIME 类型：model/step */
	MODEL_STEP("model/step"),
	/** MIME 类型：model/step+xml */
	MODEL_STEP_XML("model/step+xml"),
	/** MIME 类型：model/step+zip */
	MODEL_STEP_ZIP("model/step+zip"),
	/** MIME 类型：model/step-xml+zip */
	MODEL_STEP_XML_ZIP("model/step-xml+zip"),
	/** MIME 类型：model/stl */
	MODEL_STL("model/stl"),
	/** MIME 类型：model/u3d */
	MODEL_U3D("model/u3d"),
	/** MIME 类型：model/vnd.bary */
	MODEL_VND_BARY("model/vnd.bary"),
	/** MIME 类型：model/vnd.cld */
	MODEL_VND_CLD("model/vnd.cld"),
	/** MIME 类型：model/vnd.collada+xml */
	MODEL_VND_COLLADA_XML("model/vnd.collada+xml"),
	/** MIME 类型：model/vnd.dwf */
	MODEL_VND_DWF("model/vnd.dwf"),
	/** MIME 类型：model/vnd.flatland.3dml */
	MODEL_VND_FLATLAND_3DML("model/vnd.flatland.3dml"),
	/** MIME 类型：model/vnd.gdl */
	MODEL_VND_GDL("model/vnd.gdl"),
	/** MIME 类型：model/vnd.gs-gdl */
	MODEL_VND_GS_GDL("model/vnd.gs-gdl"),
	/** MIME 类型：model/vnd.gtw */
	MODEL_VND_GTW("model/vnd.gtw"),
	/** MIME 类型：model/vnd.moml+xml */
	MODEL_VND_MOML_XML("model/vnd.moml+xml"),
	/** MIME 类型：model/vnd.mts */
	MODEL_VND_MTS("model/vnd.mts"),
	/** MIME 类型：model/vnd.opengex */
	MODEL_VND_OPENGEX("model/vnd.opengex"),
	/** MIME 类型：model/vnd.parasolid.transmit.binary */
	MODEL_VND_PARASOLID_TRANSMIT_BINARY("model/vnd.parasolid.transmit.binary"),
	/** MIME 类型：model/vnd.parasolid.transmit.text */
	MODEL_VND_PARASOLID_TRANSMIT_TEXT("model/vnd.parasolid.transmit.text"),
	/** MIME 类型：model/vnd.pytha.pyox */
	MODEL_VND_PYTHA_PYOX("model/vnd.pytha.pyox"),
	/** MIME 类型：model/vnd.rosette.annotated-data-model */
	MODEL_VND_ROSETTE_ANNOTATED_DATA_MODEL("model/vnd.rosette.annotated-data-model"),
	/** MIME 类型：model/vnd.sap.vds */
	MODEL_VND_SAP_VDS("model/vnd.sap.vds"),
	/** MIME 类型：model/vnd.usda */
	MODEL_VND_USDA("model/vnd.usda"),
	/** MIME 类型：model/vnd.usdz+zip */
	MODEL_VND_USDZ_ZIP("model/vnd.usdz+zip"),
	/** MIME 类型：model/vnd.valve.source.compiled-map */
	MODEL_VND_VALVE_SOURCE_COMPILED_MAP("model/vnd.valve.source.compiled-map"),
	/** MIME 类型：model/vnd.vtu */
	MODEL_VND_VTU("model/vnd.vtu"),
	/** MIME 类型：model/vrml */
	MODEL_VRML("model/vrml"),
	/** MIME 类型：model/x3d-vrml */
	MODEL_X3D_VRML("model/x3d-vrml"),
	/** MIME 类型：model/x3d+fastinfoset */
	MODEL_X3D_FASTINFOSET("model/x3d+fastinfoset"),
	/** MIME 类型：model/x3d+xml */
	MODEL_X3D_XML("model/x3d+xml"),
	/** MIME 类型：multipart/alternative */
	MULTIPART_ALTERNATIVE("multipart/alternative"),
	/** MIME 类型：multipart/appledouble */
	MULTIPART_APPLEDOUBLE("multipart/appledouble"),
	/** MIME 类型：multipart/byteranges */
	MULTIPART_BYTERANGES("multipart/byteranges"),
	/** MIME 类型：multipart/digest */
	MULTIPART_DIGEST("multipart/digest"),
	/** MIME 类型：multipart/encrypted */
	MULTIPART_ENCRYPTED("multipart/encrypted"),
	/** MIME 类型：multipart/example */
	MULTIPART_EXAMPLE("multipart/example"),
	/** MIME 类型：multipart/form-data */
	MULTIPART_FORM_DATA("multipart/form-data"),
	/** MIME 类型：multipart/header-set */
	MULTIPART_HEADER_SET("multipart/header-set"),
	/** MIME 类型：multipart/mixed */
	MULTIPART_MIXED("multipart/mixed"),
	/** MIME 类型：multipart/multilingual */
	MULTIPART_MULTILINGUAL("multipart/multilingual"),
	/** MIME 类型：multipart/parallel */
	MULTIPART_PARALLEL("multipart/parallel"),
	/** MIME 类型：multipart/related */
	MULTIPART_RELATED("multipart/related"),
	/** MIME 类型：multipart/report */
	MULTIPART_REPORT("multipart/report"),
	/** MIME 类型：multipart/signed */
	MULTIPART_SIGNED("multipart/signed"),
	/** MIME 类型：multipart/vnd.bint.med-plus */
	MULTIPART_VND_BINT_MED_PLUS("multipart/vnd.bint.med-plus"),
	/** MIME 类型：multipart/voice-message */
	MULTIPART_VOICE_MESSAGE("multipart/voice-message"),
	/** MIME 类型：multipart/x-mixed-replace */
	MULTIPART_X_MIXED_REPLACE("multipart/x-mixed-replace"),
	/** MIME 类型：text/1d-interleaved-parityfec */
	TEXT_1D_INTERLEAVED_PARITYFEC("text/1d-interleaved-parityfec"),
	/** MIME 类型：text/cache-manifest */
	TEXT_CACHE_MANIFEST("text/cache-manifest"),
	/** MIME 类型：text/calendar */
	TEXT_CALENDAR("text/calendar"),
	/** MIME 类型：text/cql */
	TEXT_CQL("text/cql"),
	/** MIME 类型：text/cql-expression */
	TEXT_CQL_EXPRESSION("text/cql-expression"),
	/** MIME 类型：text/cql-identifier */
	TEXT_CQL_IDENTIFIER("text/cql-identifier"),
	/** MIME 类型：text/css */
	TEXT_CSS("text/css"),
	/** MIME 类型：text/csv */
	TEXT_CSV("text/csv"),
	/** MIME 类型：text/csv-schema */
	TEXT_CSV_SCHEMA("text/csv-schema"),
	/** MIME 类型：text/directory */
	TEXT_DIRECTORY("text/directory"),
	/** MIME 类型：text/dns */
	TEXT_DNS("text/dns"),
	/** MIME 类型：text/ecmascript */
	TEXT_ECMASCRIPT("text/ecmascript"),
	/** MIME 类型：text/encaprtp */
	TEXT_ENCAPRTP("text/encaprtp"),
	/** MIME 类型：text/enriched */
	TEXT_ENRICHED("text/enriched"),
	/** MIME 类型：text/example */
	TEXT_EXAMPLE("text/example"),
	/** MIME 类型：text/fhirpath */
	TEXT_FHIRPATH("text/fhirpath"),
	/** MIME 类型：text/flexfec */
	TEXT_FLEXFEC("text/flexfec"),
	/** MIME 类型：text/fwdred */
	TEXT_FWDRED("text/fwdred"),
	/** MIME 类型：text/gff3 */
	TEXT_GFF3("text/gff3"),
	/** MIME 类型：text/grammar-ref-list */
	TEXT_GRAMMAR_REF_LIST("text/grammar-ref-list"),
	/** MIME 类型：text/hl7v2 */
	TEXT_HL7V2("text/hl7v2"),
	/** MIME 类型：text/html */
	TEXT_HTML("text/html"),
	/** MIME 类型：text/javascript */
	TEXT_JAVASCRIPT("text/javascript"),
	/** MIME 类型：text/jcr-cnd */
	TEXT_JCR_CND("text/jcr-cnd"),
	/** MIME 类型：text/markdown */
	TEXT_MARKDOWN("text/markdown"),
	/** MIME 类型：text/mizar */
	TEXT_MIZAR("text/mizar"),
	/** MIME 类型：text/n3 */
	TEXT_N3("text/n3"),
	/** MIME 类型：text/org */
	TEXT_ORG("text/org"),
	/** MIME 类型：text/parameters */
	TEXT_PARAMETERS("text/parameters"),
	/** MIME 类型：text/parityfec */
	TEXT_PARITYFEC("text/parityfec"),
	/** MIME 类型：text/plain */
	TEXT_PLAIN("text/plain"),
	/** MIME 类型：text/provenance-notation */
	TEXT_PROVENANCE_NOTATION("text/provenance-notation"),
	/** MIME 类型：text/prs.fallenstein.rst */
	TEXT_PRS_FALLENSTEIN_RST("text/prs.fallenstein.rst"),
	/** MIME 类型：text/prs.lines.tag */
	TEXT_PRS_LINES_TAG("text/prs.lines.tag"),
	/** MIME 类型：text/prs.prop.logic */
	TEXT_PRS_PROP_LOGIC("text/prs.prop.logic"),
	/** MIME 类型：text/prs.texi */
	TEXT_PRS_TEXI("text/prs.texi"),
	/** MIME 类型：text/raptorfec */
	TEXT_RAPTORFEC("text/raptorfec"),
	/** MIME 类型：text/RED */
	TEXT_RED("text/RED"),
	/** MIME 类型：text/rfc822-headers */
	TEXT_RFC822_HEADERS("text/rfc822-headers"),
	/** MIME 类型：text/richtext */
	TEXT_RICHTEXT("text/richtext"),
	/** MIME 类型：text/rtf */
	TEXT_RTF("text/rtf"),
	/** MIME 类型：text/rtp-enc-aescm128 */
	TEXT_RTP_ENC_AESCM128("text/rtp-enc-aescm128"),
	/** MIME 类型：text/rtploopback */
	TEXT_RTPLOOPBACK("text/rtploopback"),
	/** MIME 类型：text/rtx */
	TEXT_RTX("text/rtx"),
	/** MIME 类型：text/SGML */
	TEXT_SGML("text/SGML"),
	/** MIME 类型：text/shaclc */
	TEXT_SHACLC("text/shaclc"),
	/** MIME 类型：text/shex */
	TEXT_SHEX("text/shex"),
	/** MIME 类型：text/spdx */
	TEXT_SPDX("text/spdx"),
	/** MIME 类型：text/strings */
	TEXT_STRINGS("text/strings"),
	/** MIME 类型：text/t140 */
	TEXT_T140("text/t140"),
	/** MIME 类型：text/tab-separated-values */
	TEXT_TAB_SEPARATED_VALUES("text/tab-separated-values"),
	/** MIME 类型：text/troff */
	TEXT_TROFF("text/troff"),
	/** MIME 类型：text/turtle */
	TEXT_TURTLE("text/turtle"),
	/** MIME 类型：text/ulpfec */
	TEXT_ULPFEC("text/ulpfec"),
	/** MIME 类型：text/uri-list */
	TEXT_URI_LIST("text/uri-list"),
	/** MIME 类型：text/vcard */
	TEXT_VCARD("text/vcard"),
	/** MIME 类型：text/vnd.a */
	TEXT_VND_A("text/vnd.a"),
	/** MIME 类型：text/vnd.abc */
	TEXT_VND_ABC("text/vnd.abc"),
	/** MIME 类型：text/vnd.ascii-art */
	TEXT_VND_ASCII_ART("text/vnd.ascii-art"),
	/** MIME 类型：text/vnd.curl */
	TEXT_VND_CURL("text/vnd.curl"),
	/** MIME 类型：text/vnd.debian.copyright */
	TEXT_VND_DEBIAN_COPYRIGHT("text/vnd.debian.copyright"),
	/** MIME 类型：text/vnd.DMClientScript */
	TEXT_VND_DMCLIENTSCRIPT("text/vnd.DMClientScript"),
	/** MIME 类型：text/vnd.dvb.subtitle */
	TEXT_VND_DVB_SUBTITLE("text/vnd.dvb.subtitle"),
	/** MIME 类型：text/vnd.esmertec.theme-descriptor */
	TEXT_VND_ESMERTEC_THEME_DESCRIPTOR("text/vnd.esmertec.theme-descriptor"),
	/** MIME 类型：text/vnd.exchangeable */
	TEXT_VND_EXCHANGEABLE("text/vnd.exchangeable"),
	/** MIME 类型：text/vnd.familysearch.gedcom */
	TEXT_VND_FAMILYSEARCH_GEDCOM("text/vnd.familysearch.gedcom"),
	/** MIME 类型：text/vnd.ficlab.flt */
	TEXT_VND_FICLAB_FLT("text/vnd.ficlab.flt"),
	/** MIME 类型：text/vnd.fly */
	TEXT_VND_FLY("text/vnd.fly"),
	/** MIME 类型：text/vnd.fmi.flexstor */
	TEXT_VND_FMI_FLEXSTOR("text/vnd.fmi.flexstor"),
	/** MIME 类型：text/vnd.gml */
	TEXT_VND_GML("text/vnd.gml"),
	/** MIME 类型：text/vnd.graphviz */
	TEXT_VND_GRAPHVIZ("text/vnd.graphviz"),
	/** MIME 类型：text/vnd.hans */
	TEXT_VND_HANS("text/vnd.hans"),
	/** MIME 类型：text/vnd.hgl */
	TEXT_VND_HGL("text/vnd.hgl"),
	/** MIME 类型：text/vnd.in3d.3dml */
	TEXT_VND_IN3D_3DML("text/vnd.in3d.3dml"),
	/** MIME 类型：text/vnd.in3d.spot */
	TEXT_VND_IN3D_SPOT("text/vnd.in3d.spot"),
	/** MIME 类型：text/vnd.IPTC.NewsML */
	TEXT_VND_IPTC_NEWSML("text/vnd.IPTC.NewsML"),
	/** MIME 类型：text/vnd.IPTC.NITF */
	TEXT_VND_IPTC_NITF("text/vnd.IPTC.NITF"),
	/** MIME 类型：text/vnd.latex-z */
	TEXT_VND_LATEX_Z("text/vnd.latex-z"),
	/** MIME 类型：text/vnd.motorola.reflex */
	TEXT_VND_MOTOROLA_REFLEX("text/vnd.motorola.reflex"),
	/** MIME 类型：text/vnd.ms-mediapackage */
	TEXT_VND_MS_MEDIAPACKAGE("text/vnd.ms-mediapackage"),
	/** MIME 类型：text/vnd.net2phone.commcenter.command */
	TEXT_VND_NET2PHONE_COMMCENTER_COMMAND("text/vnd.net2phone.commcenter.command"),
	/** MIME 类型：text/vnd.radisys.msml-basic-layout */
	TEXT_VND_RADISYS_MSML_BASIC_LAYOUT("text/vnd.radisys.msml-basic-layout"),
	/** MIME 类型：text/vnd.senx.warpscript */
	TEXT_VND_SENX_WARPSCRIPT("text/vnd.senx.warpscript"),
	/** MIME 类型：text/vnd.si.uricatalogue */
	TEXT_VND_SI_URICATALOGUE("text/vnd.si.uricatalogue"),
	/** MIME 类型：text/vnd.sun.j2me.app-descriptor */
	TEXT_VND_SUN_J2ME_APP_DESCRIPTOR("text/vnd.sun.j2me.app-descriptor"),
	/** MIME 类型：text/vnd.sosi */
	TEXT_VND_SOSI("text/vnd.sosi"),
	/** MIME 类型：text/vnd.typst */
	TEXT_VND_TYPST("text/vnd.typst"),
	/** MIME 类型：text/vnd.trolltech.linguist */
	TEXT_VND_TROLLTECH_LINGUIST("text/vnd.trolltech.linguist"),
	/** MIME 类型：text/vnd.vcf */
	TEXT_VND_VCF("text/vnd.vcf"),
	/** MIME 类型：text/vnd.wap.si */
	TEXT_VND_WAP_SI("text/vnd.wap.si"),
	/** MIME 类型：text/vnd.wap.sl */
	TEXT_VND_WAP_SL("text/vnd.wap.sl"),
	/** MIME 类型：text/vnd.wap.wml */
	TEXT_VND_WAP_WML("text/vnd.wap.wml"),
	/** MIME 类型：text/vnd.wap.wmlscript */
	TEXT_VND_WAP_WMLSCRIPT("text/vnd.wap.wmlscript"),
	/** MIME 类型：text/vnd.zoo.kcl */
	TEXT_VND_ZOO_KCL("text/vnd.zoo.kcl"),
	/** MIME 类型：text/vtt */
	TEXT_VTT("text/vtt"),
	/** MIME 类型：text/wgsl */
	TEXT_WGSL("text/wgsl"),
	/** MIME 类型：text/xml */
	TEXT_XML("text/xml"),
	/** MIME 类型：text/xml-external-parsed-entity */
	TEXT_XML_EXTERNAL_PARSED_ENTITY("text/xml-external-parsed-entity"),
	/** MIME 类型：video/1d-interleaved-parityfec */
	VIDEO_1D_INTERLEAVED_PARITYFEC("video/1d-interleaved-parityfec"),
	/** MIME 类型：video/3gpp */
	VIDEO_3GPP("video/3gpp"),
	/** MIME 类型：video/3gpp2 */
	VIDEO_3GPP2("video/3gpp2"),
	/** MIME 类型：video/3gpp-tt */
	VIDEO_3GPP_TT("video/3gpp-tt"),
	/** MIME 类型：video/AV1 */
	VIDEO_AV1("video/AV1"),
	/** MIME 类型：video/BMPEG */
	VIDEO_BMPEG("video/BMPEG"),
	/** MIME 类型：video/BT656 */
	VIDEO_BT656("video/BT656"),
	/** MIME 类型：video/CelB */
	VIDEO_CELB("video/CelB"),
	/** MIME 类型：video/DV */
	VIDEO_DV("video/DV"),
	/** MIME 类型：video/encaprtp */
	VIDEO_ENCAPRTP("video/encaprtp"),
	/** MIME 类型：video/evc */
	VIDEO_EVC("video/evc"),
	/** MIME 类型：video/example */
	VIDEO_EXAMPLE("video/example"),
	/** MIME 类型：video/FFV1 */
	VIDEO_FFV1("video/FFV1"),
	/** MIME 类型：video/flexfec */
	VIDEO_FLEXFEC("video/flexfec"),
	/** MIME 类型：video/H261 */
	VIDEO_H261("video/H261"),
	/** MIME 类型：video/H263 */
	VIDEO_H263("video/H263"),
	/** MIME 类型：video/H263-1998 */
	VIDEO_H263_1998("video/H263-1998"),
	/** MIME 类型：video/H263-2000 */
	VIDEO_H263_2000("video/H263-2000"),
	/** MIME 类型：video/H264 */
	VIDEO_H264("video/H264"),
	/** MIME 类型：video/H264-RCDO */
	VIDEO_H264_RCDO("video/H264-RCDO"),
	/** MIME 类型：video/H264-SVC */
	VIDEO_H264_SVC("video/H264-SVC"),
	/** MIME 类型：video/H265 */
	VIDEO_H265("video/H265"),
	/** MIME 类型：video/H266 */
	VIDEO_H266("video/H266"),
	/** MIME 类型：video/iso.segment */
	VIDEO_ISO_SEGMENT("video/iso.segment"),
	/** MIME 类型：video/JPEG */
	VIDEO_JPEG("video/JPEG"),
	/** MIME 类型：video/jpeg2000 */
	VIDEO_JPEG2000("video/jpeg2000"),
	/** MIME 类型：video/jpeg2000-scl */
	VIDEO_JPEG2000_SCL("video/jpeg2000-scl"),
	/** MIME 类型：video/jxsv */
	VIDEO_JXSV("video/jxsv"),
	/** MIME 类型：video/lottie+json */
	VIDEO_LOTTIE_JSON("video/lottie+json"),
	/** MIME 类型：video/matroska */
	VIDEO_MATROSKA("video/matroska"),
	/** MIME 类型：video/matroska-3d */
	VIDEO_MATROSKA_3D("video/matroska-3d"),
	/** MIME 类型：video/mj2 */
	VIDEO_MJ2("video/mj2"),
	/** MIME 类型：video/MP1S */
	VIDEO_MP1S("video/MP1S"),
	/** MIME 类型：video/MP2P */
	VIDEO_MP2P("video/MP2P"),
	/** MIME 类型：video/MP2T */
	VIDEO_MP2T("video/MP2T"),
	/** MIME 类型：video/mp4 */
	VIDEO_MP4("video/mp4"),
	/** MIME 类型：video/MP4V-ES */
	VIDEO_MP4V_ES("video/MP4V-ES"),
	/** MIME 类型：video/MPV */
	VIDEO_MPV("video/MPV"),
	/** MIME 类型：video/mpeg */
	VIDEO_MPEG("video/mpeg"),
	/** MIME 类型：video/mpeg4-generic */
	VIDEO_MPEG4_GENERIC("video/mpeg4-generic"),
	/** MIME 类型：video/nv */
	VIDEO_NV("video/nv"),
	/** MIME 类型：video/ogg */
	VIDEO_OGG("video/ogg"),
	/** MIME 类型：video/parityfec */
	VIDEO_PARITYFEC("video/parityfec"),
	/** MIME 类型：video/pointer */
	VIDEO_POINTER("video/pointer"),
	/** MIME 类型：video/quicktime */
	VIDEO_QUICKTIME("video/quicktime"),
	/** MIME 类型：video/raptorfec */
	VIDEO_RAPTORFEC("video/raptorfec"),
	/** MIME 类型：video/raw */
	VIDEO_RAW("video/raw"),
	/** MIME 类型：video/rtp-enc-aescm128 */
	VIDEO_RTP_ENC_AESCM128("video/rtp-enc-aescm128"),
	/** MIME 类型：video/rtploopback */
	VIDEO_RTPLOOPBACK("video/rtploopback"),
	/** MIME 类型：video/rtx */
	VIDEO_RTX("video/rtx"),
	/** MIME 类型：video/scip */
	VIDEO_SCIP("video/scip"),
	/** MIME 类型：video/smpte291 */
	VIDEO_SMPTE291("video/smpte291"),
	/** MIME 类型：video/SMPTE292M */
	VIDEO_SMPTE292M("video/SMPTE292M"),
	/** MIME 类型：video/ulpfec */
	VIDEO_ULPFEC("video/ulpfec"),
	/** MIME 类型：video/vc1 */
	VIDEO_VC1("video/vc1"),
	/** MIME 类型：video/vc2 */
	VIDEO_VC2("video/vc2"),
	/** MIME 类型：video/vnd.blockfact.factv */
	VIDEO_VND_BLOCKFACT_FACTV("video/vnd.blockfact.factv"),
	/** MIME 类型：video/vnd.CCTV */
	VIDEO_VND_CCTV("video/vnd.CCTV"),
	/** MIME 类型：video/vnd.dece.hd */
	VIDEO_VND_DECE_HD("video/vnd.dece.hd"),
	/** MIME 类型：video/vnd.dece.mobile */
	VIDEO_VND_DECE_MOBILE("video/vnd.dece.mobile"),
	/** MIME 类型：video/vnd.dece.mp4 */
	VIDEO_VND_DECE_MP4("video/vnd.dece.mp4"),
	/** MIME 类型：video/vnd.dece.pd */
	VIDEO_VND_DECE_PD("video/vnd.dece.pd"),
	/** MIME 类型：video/vnd.dece.sd */
	VIDEO_VND_DECE_SD("video/vnd.dece.sd"),
	/** MIME 类型：video/vnd.dece.video */
	VIDEO_VND_DECE_VIDEO("video/vnd.dece.video"),
	/** MIME 类型：video/vnd.directv.mpeg */
	VIDEO_VND_DIRECTV_MPEG("video/vnd.directv.mpeg"),
	/** MIME 类型：video/vnd.directv.mpeg-tts */
	VIDEO_VND_DIRECTV_MPEG_TTS("video/vnd.directv.mpeg-tts"),
	/** MIME 类型：video/vnd.dlna.mpeg-tts */
	VIDEO_VND_DLNA_MPEG_TTS("video/vnd.dlna.mpeg-tts"),
	/** MIME 类型：video/vnd.dvb.file */
	VIDEO_VND_DVB_FILE("video/vnd.dvb.file"),
	/** MIME 类型：video/vnd.fvt */
	VIDEO_VND_FVT("video/vnd.fvt"),
	/** MIME 类型：video/vnd.hns.video */
	VIDEO_VND_HNS_VIDEO("video/vnd.hns.video"),
	/** MIME 类型：video/vnd.iptvforum.1dparityfec-1010 */
	VIDEO_VND_IPTVFORUM_1DPARITYFEC_1010("video/vnd.iptvforum.1dparityfec-1010"),
	/** MIME 类型：video/vnd.iptvforum.1dparityfec-2005 */
	VIDEO_VND_IPTVFORUM_1DPARITYFEC_2005("video/vnd.iptvforum.1dparityfec-2005"),
	/** MIME 类型：video/vnd.iptvforum.2dparityfec-1010 */
	VIDEO_VND_IPTVFORUM_2DPARITYFEC_1010("video/vnd.iptvforum.2dparityfec-1010"),
	/** MIME 类型：video/vnd.iptvforum.2dparityfec-2005 */
	VIDEO_VND_IPTVFORUM_2DPARITYFEC_2005("video/vnd.iptvforum.2dparityfec-2005"),
	/** MIME 类型：video/vnd.iptvforum.ttsavc */
	VIDEO_VND_IPTVFORUM_TTSAVC("video/vnd.iptvforum.ttsavc"),
	/** MIME 类型：video/vnd.iptvforum.ttsmpeg2 */
	VIDEO_VND_IPTVFORUM_TTSMPEG2("video/vnd.iptvforum.ttsmpeg2"),
	/** MIME 类型：video/vnd.motorola.video */
	VIDEO_VND_MOTOROLA_VIDEO("video/vnd.motorola.video"),
	/** MIME 类型：video/vnd.motorola.videop */
	VIDEO_VND_MOTOROLA_VIDEOP("video/vnd.motorola.videop"),
	/** MIME 类型：video/vnd.mpegurl */
	VIDEO_VND_MPEGURL("video/vnd.mpegurl"),
	/** MIME 类型：video/vnd.ms-playready.media.pyv */
	VIDEO_VND_MS_PLAYREADY_MEDIA_PYV("video/vnd.ms-playready.media.pyv"),
	/** MIME 类型：video/vnd.nokia.interleaved-multimedia */
	VIDEO_VND_NOKIA_INTERLEAVED_MULTIMEDIA("video/vnd.nokia.interleaved-multimedia"),
	/** MIME 类型：video/vnd.nokia.mp4vr */
	VIDEO_VND_NOKIA_MP4VR("video/vnd.nokia.mp4vr"),
	/** MIME 类型：video/vnd.nokia.videovoip */
	VIDEO_VND_NOKIA_VIDEOVOIP("video/vnd.nokia.videovoip"),
	/** MIME 类型：video/vnd.objectvideo */
	VIDEO_VND_OBJECTVIDEO("video/vnd.objectvideo"),
	/** MIME 类型：video/vnd.planar */
	VIDEO_VND_PLANAR("video/vnd.planar"),
	/** MIME 类型：video/vnd.radgamettools.bink */
	VIDEO_VND_RADGAMETTOOLS_BINK("video/vnd.radgamettools.bink"),
	/** MIME 类型：video/vnd.radgamettools.smacker */
	VIDEO_VND_RADGAMETTOOLS_SMACKER("video/vnd.radgamettools.smacker"),
	/** MIME 类型：video/vnd.sealed.mpeg1 */
	VIDEO_VND_SEALED_MPEG1("video/vnd.sealed.mpeg1"),
	/** MIME 类型：video/vnd.sealed.mpeg4 */
	VIDEO_VND_SEALED_MPEG4("video/vnd.sealed.mpeg4"),
	/** MIME 类型：video/vnd.sealed.swf */
	VIDEO_VND_SEALED_SWF("video/vnd.sealed.swf"),
	/** MIME 类型：video/vnd.sealedmedia.softseal.mov */
	VIDEO_VND_SEALEDMEDIA_SOFTSEAL_MOV("video/vnd.sealedmedia.softseal.mov"),
	/** MIME 类型：video/vnd.uvvu.mp4 */
	VIDEO_VND_UVVU_MP4("video/vnd.uvvu.mp4"),
	/** MIME 类型：video/vnd.youtube.yt */
	VIDEO_VND_YOUTUBE_YT("video/vnd.youtube.yt"),
	/** MIME 类型：video/vnd.vivo */
	VIDEO_VND_VIVO("video/vnd.vivo"),
	/** MIME 类型：video/VP8 */
	VIDEO_VP8("video/VP8"),
	/** MIME 类型：video/VP9 */
	VIDEO_VP9("video/VP9");
}
