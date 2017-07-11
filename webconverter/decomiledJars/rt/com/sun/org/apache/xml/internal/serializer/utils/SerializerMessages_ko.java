package com.sun.org.apache.xml.internal.serializer.utils;

import java.util.ListResourceBundle;

public class SerializerMessages_ko
  extends ListResourceBundle
{
  public SerializerMessages_ko() {}
  
  public Object[][] getContents()
  {
    Object[][] arrayOfObject; = { { "BAD_MSGKEY", "메시지 키 ''{0}''이(가) 메시지 클래스 ''{1}''에 없습니다." }, { "BAD_MSGFORMAT", "메시지 클래스 ''{1}''에서 ''{0}'' 메시지의 형식이 잘못되었습니다." }, { "ER_SERIALIZER_NOT_CONTENTHANDLER", "Serializer 클래스 ''{0}''이(가) org.xml.sax.ContentHandler를 구현하지 않았습니다." }, { "ER_RESOURCE_COULD_NOT_FIND", "[{0}] 리소스를 찾을 수 없습니다.\n {1}" }, { "ER_RESOURCE_COULD_NOT_LOAD", "[{0}] 리소스가 다음을 로드할 수 없음: {1} \n {2} \t {3}" }, { "ER_BUFFER_SIZE_LESSTHAN_ZERO", "버퍼 크기 <=0" }, { "ER_INVALID_UTF16_SURROGATE", "부적합한 UTF-16 대리 요소가 감지됨: {0}" }, { "ER_OIERROR", "IO 오류" }, { "ER_ILLEGAL_ATTRIBUTE_POSITION", "하위 노드가 생성된 후 또는 요소가 생성되기 전에 {0} 속성을 추가할 수 없습니다. 속성이 무시됩니다." }, { "ER_NAMESPACE_PREFIX", "''{0}'' 접두어에 대한 네임스페이스가 선언되지 않았습니다." }, { "ER_STRAY_ATTRIBUTE", "''{0}'' 속성이 요소에 포함되어 있지 않습니다." }, { "ER_STRAY_NAMESPACE", "네임스페이스 선언 ''{0}''=''{1}''이(가) 요소에 포함되어 있지 않습니다." }, { "ER_COULD_NOT_LOAD_RESOURCE", "{0}을(를) 로드할 수 없습니다. CLASSPATH를 확인하십시오. 현재 기본값만 사용하는 중입니다." }, { "ER_ILLEGAL_CHARACTER", "{1}의 지정된 출력 인코딩에서 표시되지 않는 정수 값 {0}의 문자를 출력하려고 시도했습니다." }, { "ER_COULD_NOT_LOAD_METHOD_PROPERTY", "출력 메소드 ''{1}''에 대한 속성 파일 ''{0}''을(를) 로드할 수 없습니다. CLASSPATH를 확인하십시오." }, { "ER_INVALID_PORT", "포트 번호가 부적합합니다." }, { "ER_PORT_WHEN_HOST_NULL", "호스트가 널일 경우 포트를 설정할 수 없습니다." }, { "ER_HOST_ADDRESS_NOT_WELLFORMED", "호스트가 완전한 주소가 아닙니다." }, { "ER_SCHEME_NOT_CONFORMANT", "체계가 일치하지 않습니다." }, { "ER_SCHEME_FROM_NULL_STRING", "널 문자열에서 체계를 설정할 수 없습니다." }, { "ER_PATH_CONTAINS_INVALID_ESCAPE_SEQUENCE", "경로에 부적합한 이스케이프 시퀀스가 포함되어 있습니다." }, { "ER_PATH_INVALID_CHAR", "경로에 부적합한 문자가 포함됨: {0}" }, { "ER_FRAG_INVALID_CHAR", "부분에 부적합한 문자가 포함되어 있습니다." }, { "ER_FRAG_WHEN_PATH_NULL", "경로가 널일 경우 부분을 설정할 수 없습니다." }, { "ER_FRAG_FOR_GENERIC_URI", "일반 URI에 대해서만 부분을 설정할 수 있습니다." }, { "ER_NO_SCHEME_IN_URI", "URI에서 체계를 찾을 수 없습니다." }, { "ER_CANNOT_INIT_URI_EMPTY_PARMS", "빈 매개변수로 URI를 초기화할 수 없습니다." }, { "ER_NO_FRAGMENT_STRING_IN_PATH", "경로와 부분에 모두 부분을 지정할 수는 없습니다." }, { "ER_NO_QUERY_STRING_IN_PATH", "경로 및 질의 문자열에 질의 문자열을 지정할 수 없습니다." }, { "ER_NO_PORT_IF_NO_HOST", "호스트를 지정하지 않은 경우에는 포트를 지정할 수 없습니다." }, { "ER_NO_USERINFO_IF_NO_HOST", "호스트를 지정하지 않은 경우에는 Userinfo를 지정할 수 없습니다." }, { "ER_XML_VERSION_NOT_SUPPORTED", "경고: 출력 문서의 버전이 ''{0}''이(가) 되도록 요청했습니다. 이 버전의 XML은 지원되지 않습니다. 출력 문서의 버전은 ''1.0''이 됩니다." }, { "ER_SCHEME_REQUIRED", "체계가 필요합니다!" }, { "ER_FACTORY_PROPERTY_MISSING", "SerializerFactory에 전달된 Properties 객체에 ''{0}'' 속성이 없습니다." }, { "ER_ENCODING_NOT_SUPPORTED", "경고: 인코딩 ''{0}''은(는) Java 런타임에 지원되지 않습니다." } };
    return arrayOfObject;;
  }
}
