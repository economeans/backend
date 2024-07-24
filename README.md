# Economeans

Economeans는 Spring Boot를 사용하여 개발된 경제 기사 속 단어들을 낱낱이 파헤치는 서비스입니다.


## 시작하기

이 지침을 따라 로컬 개발 및 테스트 목적으로 프로젝트를 설정하세요.

### 전제 조건

- Java 19
- Docker
- Docker Compose

### 설치

#### 1. 저장소를 클론합니다:

```bash
git clone https://github.com/economeans/backend.git
cd economeans
```

#### 2. example.env 파일을 .env로 복사하고 필요한 환경 변수를 설정합니다:

```bash
cp example.env .env
```

#### 3. .env 파일을 열고 FINNHUB_API_KEY에 유효한 Finnhub API 키를 입력합니다.

```
FINNHUB_API_KEY=
```

#### 4. IntelliJ IDEA에서 Lombok 플러그인 설치:

1. IntelliJ IDEA를 엽니다.
2. File > Settings (Windows/Linux) 또는 IntelliJ IDEA > Preferences (macOS)로 이동합니다.
3. Plugins로 이동합니다.
4. Marketplace 탭에서 "Lombok"을 검색합니다.
5. "Lombok" 플러그인을 찾아 "Install" 버튼을 클릭합니다.
6. IDE를 재시작하여 변경 사항을 적용합니다.

### 실행

Docker Compose를 사용하여 애플리케이션을 빌드하고 실행합니다:

```bash
docker compose up --build
```

애플리케이션이 http://localhost:8080에서 실행됩니다.

### API 테스트

애플리케이션이 실행되면 다음 엔드포인트를 테스트할 수 있습니다:

- GET `/api/v1/articles`: 경제 뉴스 기사 목록을 가져옵니다.

예시 요청: `curl "http://localhost:8080/api/v1/articles?category=general"`

성공적인 응답은 200 상태 코드와 함께 JSON 형식의 기사 목록을 반환합니다.

## 개발

### 프로젝트 구조

프로젝트의 주요 구성 요소는 다음과 같습니다:

- `annotations`: 커스텀 어노테이션을 정의합니다. 예를 들어, `@Traced` 어노테이션은 메서드 레벨 추적을 위해 사용됩니다.

- `application`: 비즈니스 로직을 포함하는 서비스 클래스들이 위치합니다. 이 계층은 컨트롤러와 인프라스트럭처 계층 사이의 중간 계층 역할을 합니다.

- `aspects`: 관점 지향 프로그래밍(AOP)을 위한 클래스들이 위치합니다. 예를 들어, `TracingAspect`는 `@Traced` 어노테이션이 붙은 메서드의 실행을 추적합니다.

- `config`: 애플리케이션의 설정 클래스들이 위치합니다.

- `controllers`: REST API의 엔드포인트를 정의하는 컨트롤러 클래스들이 위치합니다.

- `dtos`: Data Transfer Object 클래스들이 위치합니다. 이들은 클라이언트와 서버 간의 데이터 교환을 위해 사용됩니다.

- `infrastructure`: 외부 서비스나 데이터베이스와의 통신을 담당하는 클래스들이 위치합니다.

- `security`: 보안 관련 설정 및 구현이 위치합니다. 예를 들어, `WebSecurityConfig`가 여기에 포함됩니다.

- `test` 폴더는 `main`과 유사한 구조를 가지며, 각 컴포넌트에 대한 테스트 클래스들이 위치합니다.

### 환경변수

#### FINNHUB_API_KEY*

Finnhub API 키를 지정합니다.

#### OTEL_SERVICE_NAME

현재 실행 중인 서비스나 애플리케이션의 이름을 지정합니다.(예: "economeans-server")

이 이름은 텔레메트리 데이터를 식별하고 구분하는 데 사용됩니다.

#### OTEL_TRACES_EXPORTER

트레이스 데이터를 내보낼 때 사용할 익스포터를 지정합니다.(예: "jaeger", "zipkin", "otlp" 등)

#### OTEL_METRICS_EXPORTER

메트릭 데이터를 내보낼 때 사용할 익스포터를 지정합니다.(예: "prometheus", "otlp" 등)

#### OTEL_LOGS_EXPORTER

로그 데이터를 내보낼 때 사용할 익스포터를 지정합니다.(예: "otlp", "console" 등)

#### OTEL_METRIC_EXPORT_INTERVAL

메트릭 데이터를 얼마나 자주 내보낼지 결정하는 시간 간격을 설정합니다.

일반적으로 밀리초 단위로 지정합니다.

## 기술 스택

- Spring Boot (Java 19)
- Docker
- OpenTelemetry (추적)
- Finnhub API (뉴스 데이터)

## 소셜 로그인 스팩
http://localhost:8080/oauth2/authorization/naver?redirect_uri=https://naver.com&mode=login