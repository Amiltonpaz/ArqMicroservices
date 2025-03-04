FROM quay.io/keycloak/keycloak:26.1.0

# Define o diretório do Keycloak
ENV KC_HOME=/opt/keycloak

# Copia o standalone.xml customizado para dentro do contêiner
COPY standalone.xml $KC_HOME/conf/standalone.xml

# Comando de inicialização do Keycloak
ENTRYPOINT ["/opt/keycloak/bin/kc.sh", "start-dev"]
